package br.ufmt.hujm.model.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import br.ufmt.hujm.model.dao.AlunoDAO;
import br.ufmt.hujm.model.dao.PessoaDAO;
import br.ufmt.hujm.model.entities.Aluno;
import br.ufmt.hujm.model.entities.Pessoa;
import br.ufmt.hujm.service.AlunoService;
import br.ufmt.hujm.util.Mensagem;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class AlunoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Aluno aluno = new Aluno();
	private AlunoDAO alunoDAO = new AlunoDAO();
	private List<Aluno> listaDeAlunos;
	private List<Pessoa> listaDePessoas;
	
	@Autowired
	private AlunoService alunoService;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoDAO getAlunoDAO() {
		return alunoDAO;
	}

	public void setAlunoDAO(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public List<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}

	public void setAlunos(List<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}

	public List<Pessoa> getListaDePessoas() {
		return listaDePessoas;
	}

	public void setPessoas(List<Pessoa> listaDePessoas) {
		this.listaDePessoas = listaDePessoas;
	}

	@PostConstruct
	public void listar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			listaDeAlunos = alunoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os alunos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			aluno = new Aluno();

			PessoaDAO pessoaDAO = new PessoaDAO();
			listaDePessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo aluno");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.merge(aluno);

			aluno = new Aluno();
			
			Aluno alunoExistente = alunoService.obterPorRGA(aluno.getRegistroRGA().getRga());
			if(alunoExistente != null && aluno.getIdPessoa() != alunoExistente.getIdPessoa()){
				Mensagem.mensagemErro("Ja existe um aluno cadastrado com este RGA");
				return;
			}
			alunoService.salvar(aluno);
			Mensagem.mensagemInformacao("Aluno cadastrado com sucesso");
			listaDeAlunos = alunoService.listarTodos();
			aluno = null;
			
			listaDeAlunos = alunoDAO.listar();

			PessoaDAO pessoaDAO = new PessoaDAO();
			listaDePessoas = pessoaDAO.listar();
			
			Messages.addGlobalInfo("Aluno salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o aluno");
			erro.printStackTrace();
		}
	}

	public String getDataAtual() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}
}

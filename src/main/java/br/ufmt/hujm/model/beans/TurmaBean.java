package br.ufmt.hujm.model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.ufmt.hujm.model.entities.Curso;
import br.ufmt.hujm.model.entities.DiaSemana;
import br.ufmt.hujm.model.entities.Matricula;
import br.ufmt.hujm.model.entities.Turma;
import br.ufmt.hujm.service.CursoService;
import br.ufmt.hujm.service.MatriculaService;
import br.ufmt.hujm.service.TurmaService;
import br.ufmt.hujm.util.Mensagem;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class TurmaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Turma turma;
	private List<Turma> turmas;
	private List<Curso> cursos;
	private List<Matricula> matriculas;
	
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private CursoService cursoService;
	@Autowired
	private MatriculaService matriculaService;

	public void novaTurma() {
		turma = new Turma();
	}
	
	public void salvarTurma() {
		turmaService.salvar(turma);
		turma = null;
		atualizarTurmas();
		Mensagem.mensagemInformacao("Turma salva com sucesso!");
	}

	public void editarTurma(Turma turma) {
		this.turma = turma;
		this.turma.setMatriculas(new ArrayList<Matricula>(this.turma
				.getMatriculas()));
	}
	
	private void atualizarTurmas() {
		turmas = turmaService.listarTodas();
	}

	public List<DiaSemana> getDiasSemana(){
		return Arrays.asList(DiaSemana.values());
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public MatriculaService getMatriculaService() {
		return matriculaService;
	}

	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}
}

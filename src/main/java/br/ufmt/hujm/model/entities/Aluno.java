package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "alunos")
@NamedQueries({
	@NamedQuery(name = Aluno.OBTER_POR_RGA, query = Aluno.OBTER_POR_RGA)
})
public class Aluno extends Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String OBTER_POR_RGA = "from Aluno where rga = :rga";
	
	//private Long idAluno;
	private String registroGEP;
	private Matricula registroRGA = new Matricula();
	private Turma idTurma;
	
	private Date dataCadastro;

	//@Column(name = "aluno_id", unique = true, nullable = false)
	//public Long getIdAluno() {
	//	return idAluno;
	//}

	//public void setIdAluno(Long idAluno) {
	//	this.idAluno = idAluno;
	//}
	
	public Aluno(){
		super();
	}
	
	public Aluno (String nome, String cpf, String rg,
			Sexo sexo, Date dataNascimento, Cidade cidadeNatal,
			Nivel nivelEscolaridade, Endereco endereco,
			String telResidencial, String celPrincipal, String celOpcional,
			String contato, String email, byte[]foto){
		
		//this.idAluno = IdPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidadeNatal = cidadeNatal;
		this.nivelEscolaridade = nivelEscolaridade;
		this.endereco = endereco;
		this.telResidencial = telResidencial;
		this.celPrincipal = celPrincipal;
		this.celOpcional = celOpcional;
		this.contato = contato;
		this.email = email;
		this.foto = foto;
	}
	
	public String getRegistroGEP() {
		return registroGEP;
	}

	public void setRegistroGEP(String registroGEP) {
		this.registroGEP = registroGEP;
	}

	public Matricula getRegistroRGA() {
		return registroRGA;
	}

	public void setRegistroRGA(Matricula registroRGA) {
		this.registroRGA = registroRGA;
	}

	public Turma getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Turma idTurma) {
		this.idTurma = idTurma;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}*/
}

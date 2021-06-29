package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "matricula")
@NamedQueries({
	@NamedQuery(name = Matricula.LISTAR_TODAS, query = Matricula.LISTAR_TODAS),
	@NamedQuery(name = Matricula.LISTAR_POR_CURSO, query = Matricula.LISTAR_POR_CURSO),
	@NamedQuery(name = Matricula.OBTER_NUMERO_ULTIMA_MATRICULA, query = Matricula.OBTER_NUMERO_ULTIMA_MATRICULA),
	@NamedQuery(name = "Matricula.ListarTodasAtivas", query = "from Matricula where ativo = true")
})
public class Matricula implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idMatricula;
	private String rga;
	private Instituicao instituicao = new Instituicao();
	private Pessoa pessoa;
	private Aluno aluno;
	private Curso curso = new Curso();
	
	private Date dataMatricula;
	
	private boolean ativo = true;
	private Date dataDesativacao;
	
	public static final String LISTAR_TODAS = "select new MatriculaVO(" +
			"id, numero, dataMatricula, aluno.nome, curso.nome) from Matricula order by cast(numero as long)";
	public static final String LISTAR_POR_CURSO = "from Matricula where curso.id = :idCurso";
	public static final String OBTER_NUMERO_ULTIMA_MATRICULA = 
			"select max(cast(numero as long)) from Matricula";
	
	public Matricula(){
		
	}
	
	public Matricula(Integer idMatricula, Date data, String numero, String nomeAluno, String nomeCurso){
		setIdMatricula(idMatricula);
		setRga(rga);
		setDataMatricula(data);
		setAluno(new Aluno());
		this.pessoa.setNome(nomeAluno);
		setCurso(new Curso());
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	@NotEmpty(message = "Preenchimento obrigatorio!")
	public String getRga() {
		return rga;
	}

	public void setRga(String rga) {
		this.rga = rga;
	}

	@ManyToOne
	@JoinColumn(name = "instituicao_id")
	@NotNull(message = "Preenchimento obrigatorio!")
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	@NotNull(message = "O campo Data Matricula e obrigatorio.")
	@Temporal(TemporalType.DATE)
	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	@NotNull(message = "Selecione um aluno")
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@NotNull(message = "Selecione um curso")
	@ManyToOne
	@JoinColumn(name = "curso_id")
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Temporal(TemporalType.DATE)
	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMatricula == null) ? 0 : idMatricula.hashCode());
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
		Matricula other = (Matricula) obj;
		if (idMatricula == null) {
			if (other.idMatricula != null)
				return false;
		} else if (!idMatricula.equals(other.idMatricula))
			return false;
		return true;
	}
}

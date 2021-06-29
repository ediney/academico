package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** ENTIDADE CURSO
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "cursos")
public class Curso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idCurso;
	private String nome;
	
	private Instituicao idInstituicao;
	
	private Set<Turma> turmas = new HashSet<Turma>(0);
	
	private Set <EstagioAtividade> estagiosAtividades = new HashSet<EstagioAtividade>(0);
	
	private Date dataUltimaAlteracao;
	
	public Curso(){
		
	}
	
	public Curso(String nome){
		this.nome = nome;
	}
	
	public Curso(Long idCurso, Date dataUltimaAlteracao){
		this.idCurso = idCurso;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "curso_id", unique = true, nullable = false)
	public Long getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	
	@Column(length = 120, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* Relacionamento Muitos-Para-Um
	 * Muitos cursos pertencem a uma instituicao de ensino
	 */
	@ManyToOne
	@Column(name = "instituicao_id", unique = true, nullable = false)
	public Instituicao getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Instituicao idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	
	/* Relacionamento Um-Para-Muitos
	 * Um curso possui muitas turmas de alunos
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cursos")
	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}

	/* Relacionamento Um-Para-Muitos
	 * Um curso possui muitos estagios e atividades academicas
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cursos")
	public Set <EstagioAtividade> getEstagiosAtividades() {
		return estagiosAtividades;
	}

	public void setEstagiosAtividades(Set <EstagioAtividade> estagiosAtividades) {
		this.estagiosAtividades = estagiosAtividades;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_ultima_alteracao", nullable = false, length = 23)
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCurso == null) ? 0 : idCurso.hashCode());
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
		Curso other = (Curso) obj;
		if (idCurso == null) {
			if (other.idCurso != null)
				return false;
		} else if (!idCurso.equals(other.idCurso))
			return false;
		return true;
	}
}

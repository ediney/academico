package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "turmas")
public class Turma implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idTurma;
	private String descricao;
	private Curso idCurso;
	private List<Matricula> matriculas = new ArrayList<Matricula>();
	
	public Turma(){
		
	}
	
	public Turma(String descricao){
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}
	
	@Column(length = 120, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	public Curso getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTurma == null) ? 0 : idTurma.hashCode());
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
		Turma other = (Turma) obj;
		if (idTurma == null) {
			if (other.idTurma != null)
				return false;
		} else if (!idTurma.equals(other.idTurma))
			return false;
		return true;
	}
}

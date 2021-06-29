package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "instituicoes")
public class Instituicao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idInstituicao;
	private String nome;
	private String sigla;
	
	private Set <Curso> cursos = new HashSet<Curso>(0);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdInstituicao() {
		return idInstituicao;
	}
	
	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	
	@Column(length = 120, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(length = 10, nullable = false)
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/* Relacionamento Um-Para-Muitos
	 * Uma instituicao de ensino possui muitos cursos
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "instituicao")
	public Set <Curso> getCursos() {
		return cursos;
	}

	public void cursos(Set <Curso> cursos) {
		this.cursos = cursos;
	}
	
	public Instituicao(){
		
	}
	
	public Instituicao(String nome){
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInstituicao == null) ? 0 : idInstituicao.hashCode());
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
		Instituicao other = (Instituicao) obj;
		if (idInstituicao == null) {
			if (other.idInstituicao != null)
				return false;
		} else if (!idInstituicao.equals(other.idInstituicao))
			return false;
		return true;
	}
}

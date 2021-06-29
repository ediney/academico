package br.ufmt.hujm.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** ENTIDADE: PROGRAMA
 * - Responsavel por armazenar informacoes referentes aos programas;
 * - Categorizacao dos estagios e atividades;
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "programas")
public class Programa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPrograma;
	private String descricao;
	
	private EstagioAtividade idEstagioAtividade;
	
	@Id
	@GeneratedValue
	public Long getIdPrograma() {
		return idPrograma;
	}
	
	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}
	
	@Column(length = 120, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne
	@JoinColumn(name = "estagio_atividade_id", nullable = false)
	public EstagioAtividade getIdEstagioAtividade() {
		return idEstagioAtividade;
	}

	public void setIdEstagioAtividade(EstagioAtividade idEstagioAtividade) {
		this.idEstagioAtividade = idEstagioAtividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPrograma == null) ? 0 : idPrograma.hashCode());
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
		Programa other = (Programa) obj;
		if (idPrograma == null) {
			if (other.idPrograma != null)
				return false;
		} else if (!idPrograma.equals(other.idPrograma))
			return false;
		return true;
	}
}

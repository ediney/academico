package br.ufmt.hujm.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "cidades")
public class Cidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idCidade;
	private String nome;
	private Estado idEstado;
	private Estado estado;
	
	/* Construtor Default de Cidade
	 * 
	 */
	public Cidade(){
		
	}
	
	public Cidade(String nome, Estado estado){
		super();
		this.nome = nome;
		this.estado = estado;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdCidade() {
		return idCidade;
	}
	
	public void setIdCidade(Integer integer) {
		this.idCidade = integer;
	}
	
	@Column(length = 120, nullable = false)
	@NotEmpty(message = "Preenchimento obrigatorio!")
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/* Relacionamento Muitos-Para-Um
	 * Muitas cidades pertencem a um Estado
	 */
	@ManyToOne
	public Estado getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}

	/* Metodo gerador da etiqueta com o nome do Estado
	 * 
	 */
	@NotNull(message = "Preenchimento obrigatorio!")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCidade == null) ? 0 : idCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (idCidade == null) {
			if (other.idCidade != null)
				return false;
		} else if (!idCidade.equals(other.idCidade))
			return false;
		return true;
	}
}

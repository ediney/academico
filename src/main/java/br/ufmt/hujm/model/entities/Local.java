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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** ENTIDADE LOCAL:
 * - Responsavel por armazenar dados dos ambientes fisicos do HUJM onde se realizam
 * os estagios e atividades academicas.
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "locais")
public class Local implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idLocal;
	private String nome;
	private Date dataInicio;
	private Date dataTermino;
	
	private Set <EstagioAtividade> estagiosAtividades = new HashSet<EstagioAtividade>(0);
	
	@Id
	@GeneratedValue
	public Long getIdLocal() {
		return idLocal;
	}
	
	public void setIdLocal(Long idLocal) {
		this.idLocal = idLocal;
	}
	@Column(length = 120, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataTermino() {
		return dataTermino;
	}
	
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set <EstagioAtividade> getEstagiosAtividades() {
		return estagiosAtividades;
	}

	public void setEstagiosAtividades(Set <EstagioAtividade> estagiosAtividades) {
		this.estagiosAtividades = estagiosAtividades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLocal == null) ? 0 : idLocal.hashCode());
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
		Local other = (Local) obj;
		if (idLocal == null) {
			if (other.idLocal != null)
				return false;
		} else if (!idLocal.equals(other.idLocal))
			return false;
		return true;
	}
}

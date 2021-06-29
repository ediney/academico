package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "uf")
public class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, sequenceName = "uf_seq", name = "uf_seq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Integer idEstado;
	
	private String label;
	private String sigla;
	
	/* Lista dos Estados da Federacao 
	 * 
	 */
	@ElementCollection(targetClass = EstadoEnum.class, fetch = FetchType.EAGER)
	@JoinTable(name = "uf_enums", joinColumns = @JoinColumn(name = "listauf_id"))
	@Column(name = "uf_enum", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<EstadoEnum> listaEstadoEnum;
	
	private Set <Cidade> cidadesDoEstado = new HashSet<Cidade>(0);
	
	private Estado(String label, String sigla){
		this.label = label;
	}
	
	@Column(length = 120, nullable = false)
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(length = 2, nullable = false)
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	/* Relacao das cidades pertencentes a um Estado da Federacao
	 * 
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "uf")
	public Set <Cidade> getCidadesDoEstado() {
		return cidadesDoEstado;
	}

	public void setCidadesDoEstado(Set <Cidade> cidadesDoEstado) {
		this.cidadesDoEstado = cidadesDoEstado;
	}
}

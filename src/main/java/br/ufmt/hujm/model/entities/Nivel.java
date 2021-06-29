package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class Nivel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, sequenceName = "nivel_seq", name = "nivel_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nivel_seq")
	@Column(nullable = false)
	private Integer idNivel;
	private String label;

	@ElementCollection(targetClass = EstadoEnum.class, fetch = FetchType.EAGER)
	@JoinTable(name = "nivelenums", joinColumns = @JoinColumn(name = "nivellist_id"))
	@Column(name = "nivelenum", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<NivelEnum> listaNivelEnum;
	
	
	private Nivel (String label){
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

package br.ufmt.hujm.model.entities;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public enum DiaSemana {
	
	SEGUNDA("Segunda-Feira"),
	TERCA("Terçaa-Feira"),
	QUARTA("Quarta-Feira"),
	QUINTA("Quinta-Feira"),
	SEXTA("Sexta-Feira"),
	SABADO("Sábado"),
	DOMINGO("Domingo");
	
	private String label;
	
	private DiaSemana(String label){
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

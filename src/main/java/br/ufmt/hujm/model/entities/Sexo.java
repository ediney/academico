package br.ufmt.hujm.model.entities;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String label;
	
	private Sexo(String label){
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

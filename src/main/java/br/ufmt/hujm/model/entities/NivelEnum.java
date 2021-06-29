package br.ufmt.hujm.model.entities;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public enum NivelEnum {
	
	CAPACITACAO("CAPACITAÇÃO"),
	GRADUACAO("GRADUAÇÃO"),
	POSGRADUACAO("PÓS-GRADUAÇÃO"),
	QUALIFICACAO("QUALIFICAÇÃO");
	
	private String label;
	
	private NivelEnum (String label){
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}

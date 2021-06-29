package br.ufmt.hujm.model.entities;

import javax.persistence.Column;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public enum EstadoEnum {
	
	ACRE("Acre","AC"),
	ALAGOAS("Alagoas","AL"),
	AMAPA("Amapa","AP"),
	AMAZONAS("Amazonas", "AM"),
	BAHIA("Bahia","BA"),
	CEARA("Ceara","CE"),
	DISTRITO_FEDERAL("Distrito Federal","DF"),
	ESPIRITO_SANTO("Espirito Santo","ES"),
	GOIAS("Goias","GO"),
	MARANHAO("Maranhao","MA"),
	MATO_GROSSO("Mato Grosso","MT"),
	MATO_GROSSO_DO_SUL("Mato Grosso do Sul","MS"),
	MINAS_GERAIS("Minas Gerais","MG"),
	PARA("Para","PA"),
	PARAIBA("Paraiba","PB"),
	PARANA("Parana","PR"),
	PERNANBUCO("Pernambuco","PE"),
	PIAUI("Piaui","PI"),
	RORAIMA("Roraima","RR"),
	RONDONIA("Rondonia","RO"),
	RIO_DE_JANEIRO("Rio de Janeiro","RJ"),
	RIO_GRANDE_DO_NORTE("Rio Grande do Norte","RN"),
	RIO_GRANDE_DO_SUL("Rio Grande do Sul","RS"),
	SANTA_CATARINA("Santa Catarina","SC"),
	SAO_PAULO("Sao Paulo","SP"),
	SERGIPE("Sergipe","SE"),
	TOCANTINS("Tocantins","TO");
	
	private String label;
	private String sigla;
	
	private EstadoEnum (String label, String sigla){
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

}

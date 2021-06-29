package br.ufmt.hujm.model.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.Programa;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class ProgramaBean {
	
	private Programa programa = new Programa();

	public Programa getPrograma() {
		return programa;
	}

	public void setProgrma(Programa programa) {
		this.programa = programa;
	}
	
}

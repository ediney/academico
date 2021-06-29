package br.ufmt.hujm.model.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.Local;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class LocalBean {
	
	private Local local = new Local();

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
	
}

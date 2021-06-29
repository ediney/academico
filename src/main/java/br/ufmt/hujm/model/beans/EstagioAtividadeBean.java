package br.ufmt.hujm.model.beans;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.DiaSemana;
import br.ufmt.hujm.model.entities.EstagioAtividade;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class EstagioAtividadeBean {
	
	private EstagioAtividade estagioAtividade;
	
	@PostConstruct
	public void init(){
		estagioAtividade = new EstagioAtividade();
	}
	
	public void submit(){
		System.out.println(Arrays.toString(estagioAtividade.getDias()));
	}
	
	public EstagioAtividade getEntity() {
        return estagioAtividade;
    }

    public DiaSemana[] getAvailableValues() {
        return DiaSemana.values();
    }	
}

package br.ufmt.hujm.repository;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufmt.hujm.model.entities.Programa;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class ProgramaRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Programa guardar(Programa programa) {

        return manager.merge(programa);
    }
}

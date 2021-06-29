package br.ufmt.hujm.repository;

import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufmt.hujm.model.entities.Matricula;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class MatriculaRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Matricula guardar(Matricula matricula) {

        return manager.merge(matricula);

    }
}

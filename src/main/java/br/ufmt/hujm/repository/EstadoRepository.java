package br.ufmt.hujm.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufmt.hujm.model.entities.Estado;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class EstadoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Estado guardar(Estado estado) {

        return manager.merge(estado);
    }

    public List<Estado> buscarEstado() {
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    public Estado porId(Long id) {
        return manager.find(Estado.class, id);
    }
}

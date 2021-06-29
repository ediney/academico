package br.ufmt.hujm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufmt.hujm.model.entities.Turma;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Service("turmaService")
@Transactional
public class TurmaServiceImpl implements TurmaService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Turma turma) {
		entityManager.merge(turma);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> listarTodas() {
		// TODO - Mostrar Hibernate.initialize()
		return entityManager.createQuery("select t from Turma t").getResultList();
	}

}

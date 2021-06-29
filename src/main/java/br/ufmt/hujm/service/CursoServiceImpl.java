package br.ufmt.hujm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufmt.hujm.model.entities.Curso;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Service(value = "cursoService")
@Transactional
public class CursoServiceImpl implements CursoService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Curso curso) {
		entityManager.merge(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos() {
		return entityManager.createQuery("from Curso").getResultList();
	}

	@Override
	public void excluir(Curso curso) {
		curso = entityManager.merge(curso);
		entityManager.remove(curso);
	}

}

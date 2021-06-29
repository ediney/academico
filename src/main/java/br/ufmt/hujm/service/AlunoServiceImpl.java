package br.ufmt.hujm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufmt.hujm.model.entities.Aluno;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Service("alunoService")
@Transactional
public class AlunoServiceImpl implements AlunoService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(Aluno aluno) {
		entityManager.merge(aluno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listarTodos() {
		return entityManager.createQuery("from Aluno").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Aluno obterPorRGA(String rga) {
		List<Aluno> alunos = entityManager.createNamedQuery(Aluno.OBTER_POR_RGA)
				.setParameter("rga", rga).getResultList();
		
		if(!alunos.isEmpty()){
			return alunos.get(0);
		} else {
			return null;
		}
	}

}

package br.ufmt.hujm.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufmt.hujm.model.entities.Matricula;
import br.ufmt.hujm.util.DataUtils;
import br.ufmt.hujm.util.MatriculaVO;
import br.ufmt.hujm.util.ParametrosBuscaMatricula;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@Service("matriculaService")
@Transactional
public class MatriculaServiceImpl implements MatriculaService{
	
	private static final String FORMATO_BANCO_POSTGRESQL = "yyyy-MM-dd";

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaVO> listarTodas() {
		return entityManager.createNamedQuery(Matricula.LISTAR_TODAS).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodasAtivas() {
		return entityManager.createNamedQuery("Matricula.ListarTodasAtivas").getResultList();
	}

	@Override
	public void salvar(Matricula matricula) {
		entityManager.merge(matricula);
	}

	@Override
	public Matricula obterPorId(Integer id) {
		return entityManager.find(Matricula.class, id);
	}

	@Override
	public List<Matricula> listarPorCurso(Integer id) {
		return entityManager.createNamedQuery(Matricula.LISTAR_POR_CURSO, Matricula.class)
				.setParameter("idCurso", id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaVO> pesquisar(ParametrosBuscaMatricula parametros) {
		StringBuilder builder = new StringBuilder("select new br.ufmt.hujm.util.MatriculaVO(" +
			"m.id, m.numero, m.dataMatricula, m.aluno.nome, m.curso.nome) from Matricula m where m.id is not null ");
		
		if(parametros.getAluno() != null){
			builder.append(" and m.aluno = :aluno");
		}
		
		if(parametros.getCursos() != null && !parametros.getCursos().isEmpty()){
			builder.append(" and m.curso in (:cursos)");
		}
		
		if(parametros.getDataInicial() != null){
			builder.append(" and date(m.dataMatricula) >= '" + DataUtils
					.obterDataFormatoBanco(parametros.getDataInicial(), FORMATO_BANCO_POSTGRESQL) + "'");
		}
		
		if(parametros.getDataFinal() != null){
			builder.append(" and date(m.dataMatricula) <= '" + DataUtils
					.obterDataFormatoBanco(parametros.getDataFinal(), FORMATO_BANCO_POSTGRESQL) + "'");
		}
		
		Query query = entityManager.createQuery(builder.toString());
		
		if(parametros.getAluno() == null){
			query.setParameter("aluno", parametros.getAluno());
		}
		
		if(parametros.getCursos() != null && !parametros.getCursos().isEmpty()){
			query.setParameter("cursos", parametros.getCursos());
		}
		
		return query.getResultList();
	}

	@Override
	public Long obterNumeroUltimaMatricula() {
		return (Long) entityManager.createNamedQuery(
				Matricula.OBTER_NUMERO_ULTIMA_MATRICULA).getSingleResult();
	}

}

package br.ufmt.hujm.service;

import java.util.List;

import br.ufmt.hujm.model.entities.Matricula;
import br.ufmt.hujm.util.MatriculaVO;
import br.ufmt.hujm.util.ParametrosBuscaMatricula;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public interface MatriculaService {

	public List<MatriculaVO> listarTodas();
	public void salvar(Matricula matricula);
	public List<Matricula> listarTodasAtivas();
	public Matricula obterPorId(Integer id);
	public List<Matricula> listarPorCurso(Integer id);
	public List<MatriculaVO> pesquisar(ParametrosBuscaMatricula parametros);
	public Long obterNumeroUltimaMatricula();
}

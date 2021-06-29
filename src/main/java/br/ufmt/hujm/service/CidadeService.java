package br.ufmt.hujm.service;

import java.util.List;

import br.ufmt.hujm.model.entities.Cidade;
import br.ufmt.hujm.model.entities.Estado;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public interface CidadeService {

	public void salvar(Cidade cidade);
	public List<Cidade> listarTodas();
	public void excluir(Cidade cidade);
	public List<Cidade> obterCidadesDoEstado(Estado estado);
}

package br.ufmt.hujm.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ocpsoft.pretty.faces.util.StringUtils;

import br.ufmt.hujm.filters.AlunoFilter;
import br.ufmt.hujm.model.entities.Aluno;

/** Camada de persistencia no banco de dados
 * 
 * @author Ediney Lopes
 * 
 */
public class AlunoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Aluno guardar(Aluno aluno) {

        return manager.merge(aluno);
    }

    /** 
     * Metodo filtra aluno e envia para a tela,
     * de modo que permite a pesquisa
     * por outro atributo, adicionando na classe AlunoFilter
     */    
	@SuppressWarnings("unchecked")
	public List<Aluno> filtrados(AlunoFilter filtro) {
		/** Solicita ao manager desempacotamento da Session do Hibernate,
		 *  e guarda na variavel session.
		 */
        Session session = manager.unwrap(Session.class);
      //criando um criterio para entidade Aluno.
        Criteria criteria = session.createCriteria(Aluno.class).createAlias("turma", "t");
        
        //Consulta aluno por Nome
        if (StringUtils.isNotBlank(filtro.getNome())) {
            criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
        }
           
        //Consulta aluno por Turma
        if (StringUtils.isNotBlank(filtro.getTurma())) {
            criteria.add(Restrictions.ilike("s.descricao", filtro.getTurma(), MatchMode.ANYWHERE));
        }
             
        return criteria.addOrder(Order.asc("nome")).list();
    }

    public List<Aluno> buscarAluno() {
        return manager.createQuery("from Aluno", Aluno.class).getResultList();

    }
    
    //Retorna um aluno dado o id dele
    public Aluno porId(Long id) {
       return manager.find(Aluno.class, id);
    }
}

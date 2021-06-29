package br.ufmt.hujm.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ocpsoft.pretty.faces.util.StringUtils;

import br.ufmt.hujm.filters.EstagioAtividadeFilter;
import br.ufmt.hujm.model.entities.EstagioAtividade;

/** Camada de persistencia de dados
 * 
 * @author Ediney Lopes
 * 
 */
public class EstagioAtividadeRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public EstagioAtividade guardar(EstagioAtividade estagioAtividade) {

        return manager.merge(estagioAtividade);

    }

    public EstagioAtividade porDescricao(String descricao) {
        try {
            return manager.createQuery("from EstagioAtividade where upper(descricao) = :descricao", EstagioAtividade.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<EstagioAtividade> filtrados(EstagioAtividadeFilter filtro) {

        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(EstagioAtividade.class);

        criteria.add(Restrictions.eq(null, filtro));

        if (StringUtils.isNotBlank(filtro.getDescricao())) {
            criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));

        }

        return criteria.addOrder(Order.asc("descricao")).list();

    }

    public List<EstagioAtividade> buscarDisciplina() {
        return manager.createQuery("from Disciplina", EstagioAtividade.class).getResultList();

    }

    public EstagioAtividade porId(Long id) {
        return manager.find(EstagioAtividade.class, id);
    }

    
}

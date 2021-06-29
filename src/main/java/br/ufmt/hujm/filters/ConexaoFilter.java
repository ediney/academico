package br.ufmt.hujm.filters;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.FilterDefinition;

import br.ufmt.hujm.util.HibernateUtil;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class ConexaoFilter implements Filter {
 
    private SessionFactory sessionFactory;
 
    public void destroy() {
         
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {
            this.sessionFactory.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sessionFactory.getCurrentSession().getTransaction().commit();
            this.sessionFactory.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if (this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                    this.sessionFactory.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
 
    public void init(FilterConfig arg0) throws ServletException {
        this.sessionFactory = HibernateUtil.getFabricaDeSessoes();
    }

	@Override
	public String getName() {
		return null;
	}

	@Override
	public FilterDefinition getFilterDefinition() {
		return null;
	}

	@Override
	public Filter setParameter(String name, Object value) {
		return null;
	}

	@Override
	public Filter setParameterList(String name, @SuppressWarnings("rawtypes") Collection values) {
		return null;
	}

	@Override
	public Filter setParameterList(String name, Object[] values) {
		return null;
	}

	@Override
	public void validate() throws HibernateException {
		
	}
}

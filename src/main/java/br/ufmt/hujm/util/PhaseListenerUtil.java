package br.ufmt.hujm.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class PhaseListenerUtil implements PhaseListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Antes da Fase
    @Override
    public void beforePhase(PhaseEvent fase) {
        System.out.println("Antes da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {            
            SessionFactory sf = HibernateUtil.getFabricaDeSessoes();
            FacesContextUtil.setRequestSession(sf);            
        }
    }
    
    //Depois da Fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally{
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}

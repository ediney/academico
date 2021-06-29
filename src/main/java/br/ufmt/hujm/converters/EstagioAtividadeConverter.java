package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.EstagioAtividade;
import br.ufmt.hujm.repository.EstagioAtividadeRepository;
import br.ufmt.hujm.util.CDIServiceLocator;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter(value = "estagioAtividadeConverter" , forClass = EstagioAtividade.class)
public class EstagioAtividadeConverter implements Converter{
    
    private EstagioAtividadeRepository estagioAtividadeRepository;

    public EstagioAtividadeConverter() {
        estagioAtividadeRepository = CDIServiceLocator.getBean(EstagioAtividadeRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        EstagioAtividade retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = estagioAtividadeRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            EstagioAtividade estagioAtividade = (EstagioAtividade) value;
            return estagioAtividade.getIdEstagioAtividade() == null ? null : estagioAtividade.getIdEstagioAtividade().toString();
        }

        return "";

    }
    
    
}

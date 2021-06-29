package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.ufmt.hujm.model.entities.Estado;
import br.ufmt.hujm.repository.EstadoRepository;
import br.ufmt.hujm.util.CDIServiceLocator;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

    @Inject
    private EstadoRepository estadoRepository;

    public EstadoConverter() {
        estadoRepository = CDIServiceLocator.getBean(EstadoRepository.class);
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Estado retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = estadoRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            return ((Estado) value).getLabel();
        }

        return "";

    }
}

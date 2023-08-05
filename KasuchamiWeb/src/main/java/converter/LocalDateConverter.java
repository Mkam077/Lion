package converter;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateTimeConverter")
public class LocalDateConverter implements Converter {

	/////////////////////class à utiliser si ajout d' un champ avec date en BDD////////////////////////////////	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		try {
			return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch (IllegalArgumentException | DateTimeException e 
				                                                 ) {
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Message"), e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}

		String s = new SimpleDateFormat("dd-MM-yyyy").format(value);
		
		
		return s;
		// According to a time zone of a specific user.
	}



}

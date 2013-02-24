package org.travelplan.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.travelplan.messagesource.MessagesSource;

@Named
@Scope("session")
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String localeCode = MessagesSource.getLocale().toString();
	
	private static Map<String,Object> countries;
	static{
		countries = new LinkedHashMap<String,Object>();
		countries.put("Russian", new Locale("ru"));
		countries.put("English", Locale.US);		
	}

	public Map<String, Object> getCountries() {
		return countries;
	}
	
	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
	
	//value change event listener
	public void countryLocaleCodeChanged(ValueChangeEvent e){		 
		String newLocaleValue = e.getNewValue().toString();
 
		//loop country map to compare the locale code
        for (Map.Entry<String, Object> entry : countries.entrySet())
        	if (entry.getValue().toString().equals(newLocaleValue)) {
        		FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
        		MessagesSource.setLocale((Locale)entry.getValue());
        	}
	}				
}

//http://stackoverflow.com/questions/6487237/converter-implemented-but-still-having-error-conversion-error-setting-value

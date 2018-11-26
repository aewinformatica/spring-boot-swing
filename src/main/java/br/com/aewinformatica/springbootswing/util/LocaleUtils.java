package br.com.aewinformatica.springbootswing.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleUtils {
	

	public static ResourceBundle getRb() {
		
		Locale locale = new Locale("pt_BR");
    	ResourceBundle rb = ResourceBundle.getBundle("br.com.aewinformatica.springbootswing.resources.content", locale);
    	
		return rb;
	}
	


}

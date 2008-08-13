package com.zenexity.pict.cvq.taglib;

import javax.servlet.jsp.tagext.TagSupport;

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;

public class I18nTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private EcitizenDataCache ecicitizenDataCache = null ;
	

	private String clazz;
	private String field;
	private String enumValue;
	private String lang;
	
	public int doEndTag() {
		try {
			String eltTrans = null;
			if (enumValue != null)
				eltTrans = ecicitizenDataCache.getEnumElementTranslation(ecicitizenDataCache.getCurrentUser(),clazz, field, enumValue, lang);
			else if (field != null)
				eltTrans = ecicitizenDataCache.getElementTranslation(ecicitizenDataCache.getCurrentUser(),clazz, field, lang);
//			else
//				eltTrans = LocalizationService.getGlobalElementTranslation(clazz, lang);
			
	   	  	pageContext.getOut().println(eltTrans);
	   	} catch (Exception ignored) {
	   		// too bad
	   	}
	   	
	   	return EVAL_PAGE;
	}
	
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public void setLang(String lang) {
		this.lang = lang;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	public void setEcicitizenDataCache(EcitizenDataCache ecicitizenDataCache) {
		this.ecicitizenDataCache = ecicitizenDataCache;
	}
}

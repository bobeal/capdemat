package fr.cg95.cvq.exporter.service.localization.impl;

import fr.cg95.cvq.exporter.service.localization.ILocalizationService;

public class LocalizationService implements ILocalizationService {

	private fr.cg95.cvq.util.localization.ILocalizationService localizationService = null ;
	
	public void setLocalizationService(
			fr.cg95.cvq.util.localization.ILocalizationService localizatonService) {
		this.localizationService = localizatonService;
	}

	public String getElementTranslation(String className, String elementName,
			String lang) {
		return this.localizationService.getElementTranslation(className,elementName,lang);
	}

	public String getEnumElementTranslation(String className,
			String elementName, String enumValue, String lang) {
		return this.localizationService.getEnumElementTranslation(className,elementName,enumValue,lang);
	}

}

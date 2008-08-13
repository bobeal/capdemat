package fr.cg95.cvq.exporter.service.localization;

public interface ILocalizationService {

	public  String getElementTranslation(final String className, final String elementName,
			final String lang) ;
	
	public  String getEnumElementTranslation(final String className, final String elementName,
			final String enumValue, final String lang) ;
}

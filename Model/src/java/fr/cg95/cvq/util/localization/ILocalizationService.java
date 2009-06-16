package fr.cg95.cvq.util.localization;

import java.util.Map;

import net.sf.saxon.om.NodeInfo;

/**
 * Service dedicated to the translation of various elements defined in the common data model
 * (aka XML Schemas).
 * 
 * FIXME : add a method to get the translated name of the request type object 
 *
 * @author bor@zenexity.fr
 * @author mna@zenexity.fr
 * 
 */
@Deprecated
public interface ILocalizationService {

    /** service name used by Spring's application context */
    String SERVICE_NAME = "localizationService";

	/**
	 * Get the translation of an element's name.
	 */
	public String getElementTranslation(final String className, final String elementName,
			final String lang) ;

    /**
     * Get global referential data associated to the given element type name from the given request
     * namespace.
     * 
     * The result document is wrapped in a Saxon {@link NodeInfo} object and is only designed
     * to be used from XSLT stylesheets.
     */
    public NodeInfo getEnumsDataNode(final String requestNamespace, final String elementTypeName, 
            final String lang);
    
	/**
	 * Get the translation of an element's enumeration value.
     * 
     * @param className the class name of the object in which the enum is used
     * @param elementName the name of the element which uses the enum
     * @param enumValue the enum value for which the translation is asked
     * @param lang the language of the translation
	 */
	public String getEnumElementTranslation(final String className, final String elementName,
			final String enumValue, final String lang) ;

    /**
     * Get the enum key corresponding to the provided translated value.
     * 
     * @param className the class name of the object in which the enum is used
     * @param elementName the name of the element which uses the enum
     * @param enumTranslatedValue the enum translated value for which the key is asked
     * @param lang the language of the provided value
     */
    public String getEnumKeyFromTranslation(final String className, final String elementName,
            final String enumTranslatedValue, final String lang) ;

	/**
	 * Get global referential data associated to the given element type name
	 * from the given request namespace.
	 * 
	 * The result is a Map
	 */
	public Map getEnumsDataMap(final String requestNamespace,
			final String elementTypeName, final String lang);
	
	/**
	 * Get the long or short description of an element's name.
	 */
	public String getElementDesc(final String requestNamespace, 
			final String elementTypeName, final String elementName, final String lang, final boolean fullDesc);
	
	/**
	 * Get the long or short description of a global element's name.
	 */
	public String getGlobalElementDesc(final String className, final String elementName, 
			final String lang, final boolean fullDesc);
}

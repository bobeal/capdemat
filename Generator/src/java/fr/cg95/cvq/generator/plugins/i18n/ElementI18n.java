package fr.cg95.cvq.generator.plugins.i18n;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.ElementTypeClass;
import fr.cg95.cvq.generator.UserDocumentation;
import fr.cg95.cvq.generator.common.ElementSpecific;

/**
 * @author rdj@zenexity.fr
 */
public class ElementI18n extends ElementSpecific<ElementI18n> {

    private String i18nPrefixCode;
    private ElementTypeClass typeClass;
    private Map<String,UserDocumentation> i18nUserDoc = new HashMap<String, UserDocumentation>();
    
    public ElementI18n(String name, String requestAcronym) {
        this.i18nPrefixCode = requestAcronym + ".property." + StringUtils.uncapitalize(name);
    }
    
    public Map<String, UserDocumentation> getI18nUserDoc() {
        return i18nUserDoc;
    }
    
    public void addi18nUserDocText (String lang, String text) {
        if (i18nUserDoc.get(lang) == null)
            i18nUserDoc.put(lang, new UserDocumentation());
        if (i18nUserDoc.get(lang).getText() == null)
            i18nUserDoc.get(lang).setText(text);
    }
    
    public void addi18nUserDocEnums (String lang, HashMap<String,String> enums) {
        if (i18nUserDoc.get(lang) == null)
            i18nUserDoc.put(lang, new UserDocumentation());
        i18nUserDoc.get(lang).setXmlTranslationNodes(enums);
    }

    public String getI18nPrefixCode() {
        return i18nPrefixCode;
    }

    public String getTypeClass() {
        return typeClass.toString();
    }

    public void setTypeClass(ElementTypeClass typeClass) {
        this.typeClass = typeClass;
    }
}

package fr.cg95.cvq.generator;

import java.util.HashMap;

public class UserDocumentation {

    private String sourceUri;
    private String lang;
    private String text;

    /** 
     * As XMLBeans does not yet handle annotations on enumerations,
     * we use this temp solution that consists in maintaining an hashmap
     * of (enum value <-> translation) pairs
     */
    private HashMap<String, String> xmlTranslationNodes;

    public UserDocumentation(String sourceUri, String lang, String text,
        HashMap<String, String> xmlTln) {
        this.sourceUri = sourceUri;
        this.lang = lang;
        this.text = text;
        this.xmlTranslationNodes = xmlTln;
    }

    public UserDocumentation() {}

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
    }

    public String getSourceUri() {
        return sourceUri;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setXmlTranslationNodes(HashMap<String, String> xmlTln) {
        this.xmlTranslationNodes = xmlTln;
    }

    public HashMap<String, String> getXmlTranslationNodes() {
        return xmlTranslationNodes;
    }
}

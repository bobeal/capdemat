package fr.cg95.cvq.generator.plugins.model;

import org.apache.commons.lang.StringUtils;

import fr.cg95.cvq.generator.ElementProperties;
import fr.cg95.cvq.generator.IPluginGenerator;

public class ElementModelProperties extends ElementProperties {

    /**
     * Element name as defined in the XML Schema
     */
    private String elementName;

    /**
     * Element name ready to be used as a Java class field
     */
    private String nameAsParam;

    private String javaPackageName;

    /** For referential elements, the Java namespace's last particle (eg school) */
    private String namespaceLastParticle;

    /** for referential elements, whether their lifecycle is tied to the request */
    private boolean isTiedToRequest;
    
    /**
     * For exploded local complex types, need to know the name of the complex type
     * for XMLBeans &lt;-&gt; Model conversion
     */
    private String complexContainerElementTypeName;

    /**
     * For exploded local complex types, need to know the name of the referring complex element name
     * for XMLBeans &lt;-&gt; Model conversion
     */
    private String complexContainerElementName;

    private String widget;

    public ElementModelProperties(ElementProperties eltProperties) {
        super(eltProperties);
        if (isSimpleType()) {
            String xmlBeanType = getXmlBeanType();
            if (xmlBeanType.indexOf("XmlLong") != -1) {
                widget = "long";
            } else if (xmlBeanType.indexOf("XmlDouble") != -1) {
                widget = "double";
            } else if (xmlBeanType.indexOf("XmlString") != -1
                || xmlBeanType.indexOf("XmlToken") != -1) {
                if (getEnumValues() == null) {
                    widget = "string";
                } else {
                    widget = "enum";
                }
            } else if (xmlBeanType.indexOf("XmlDate") != -1) {
                widget = "date";
            } else if (xmlBeanType.indexOf("XmlBoolean") != -1) {
                widget = "boolean";
            } else if (xmlBeanType.indexOf("XmlPositiveInteger") != -1) {
                widget = "positiveInteger";
            } else if (xmlBeanType.indexOf("XmlDecimal") != -1) {
                widget = "short";
            }
        } else {
            if (getMaxOccurs() != null
                && getMaxOccurs().intValue() == 1) {
                if (isReferentialType()) {
                    widget = "referential";
                } else {
                    widget = "complex";
                }
            } else {
                if (isReferentialType()) {
                    widget = "referentialList";
                } else {
                    widget = "complexList";
                }
            }
        }
    }

    public void setElementName(final String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return this.elementName;
    }

    public void setNameAsParam(String name) {
        this.nameAsParam = StringUtils.uncapitalize(name);
    }

    public String getNameAsParam() {
        return this.nameAsParam;
    }

    public void setJavaPackageName(String javaPackageName) {
        this.javaPackageName = javaPackageName;
    }

    public String getJavaPackageName() {
        return this.javaPackageName;
    }

    /**
     * Calculate the XMLBeans package name for this element
     *
     * @fixme XSD namespaces should follow what we have in the model
     */
    public String getXmlBeansPackageName() {
        String xmlBeansPackageName = null;
        if (namespaceLastParticle != null) {
            if (namespaceLastParticle.equals("authority")
                || namespaceLastParticle.equals("users")
                || namespaceLastParticle.equals("request"))
                xmlBeansPackageName = IPluginGenerator.XMLBEANS_BASE_TARGET_NS
                    + "." + IPluginGenerator.XMLBEANS_REFERENTIAL_NS;
            else
                xmlBeansPackageName = IPluginGenerator.XMLBEANS_BASE_TARGET_NS
                    + ".request." + namespaceLastParticle;
        } else {
            xmlBeansPackageName = IPluginGenerator.XMLBEANS_BASE_TARGET_NS
                + "." + IPluginGenerator.XMLBEANS_REFERENTIAL_NS;
        }

        return xmlBeansPackageName;
    }

    public String getModelClassName() {
        return StringUtils.removeEnd(this.xmlSchemaType, "Type");
    }

    public void setNamespaceLastParticle(String namespaceLastParticle) {
        this.namespaceLastParticle = namespaceLastParticle;
    }

    public String getNamespaceLastParticle() {
        return this.namespaceLastParticle;
    }

    public boolean isTiedToRequest() {
        return isTiedToRequest;
    }

    public void setTiedToRequest(boolean isTiedToRequest) {
        this.isTiedToRequest = isTiedToRequest;
    }

    public void setComplexContainerElementName(final String complexContainerElementName) {
        this.complexContainerElementName = complexContainerElementName;
    }

    public String getComplexContainerElementName() {
        return this.complexContainerElementName;
    }

    public void setComplexContainerElementTypeName(final String complexContainerElementTypeName) {
        this.complexContainerElementTypeName = complexContainerElementTypeName;
    }

    public String getComplexContainerElementTypeName() {
        return this.complexContainerElementTypeName;
    }

    public String getWidget() {
        return widget;
    }
}

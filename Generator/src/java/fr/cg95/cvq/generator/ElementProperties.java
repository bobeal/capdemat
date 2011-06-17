package fr.cg95.cvq.generator;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * A wrapper class to encapsulate elements properties and pass them to
 * the plugins
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class ElementProperties {

    private static Set<String> complexTypesAsSimple = new HashSet<String>();
    static {
        complexTypesAsSimple.add("LocalReferentialDataType");
        complexTypesAsSimple.add("SchoolType");
        complexTypesAsSimple.add("RecreationCenterType");
        complexTypesAsSimple.add("AddressType");
        complexTypesAsSimple.add("FrenchRIBType");
        complexTypesAsSimple.add("BankAccountType");
    }

    /** minimum element's occurences */
    protected BigInteger minOccurs;
    /** maximum element's occurences (null if unbounded) */
    protected BigInteger maxOccurs;
    /** min length (for string elements) */
    protected int minLength;
    /** max length (for string elements) */
    protected int maxLength;
    /** length (for string elements) */
    protected int length;
    /** length (for list element) */
    protected int listLength;
    /** list of patterns for elements that have this facet defined */
    protected String[] patterns;
    /** element's default value */
    protected String defaultValue;
    /** list of enumeration values for elements that have this facet defined */
    protected String[] enumValues;

    /** type in XMLBeans parliance */
    protected String xmlBeanType;
    /** type in Java real world */
    protected String javaType;
    /** type in XML Schema parliance */
    protected String xmlSchemaType;

    /** whether this type has been defined in a referential schema */
    protected boolean referentialType;
    /** whether this type has been defined in the current request */
    protected boolean requestType;
    /** whether this type is an XML Schema primitive type */
    protected boolean primitiveType;
    /** whether this type is a list type */
    protected boolean listType;
    /** whether this is a simple type */
    protected boolean simpleType;
    /** whether this is a complex type */
    protected boolean complexType;
    /** if complex type, tells whether it's part of a choice content element */
    protected boolean choiceElement;
    /** whether this element is inherited from the parent (abstract) request type */
    protected boolean inherited;
    /** whether this element references a local referential type */
    protected boolean localReferential;

    public ElementProperties() {}

    public ElementProperties(ElementProperties eltProperties) {
        this.minOccurs = eltProperties.getMinOccurs();
        this.maxOccurs = eltProperties.getMaxOccurs();
        this.minLength = eltProperties.getMinLength();
        this.maxLength = eltProperties.getMaxLength();
        this.length = eltProperties.getLength();
        this.listLength = eltProperties.getListLength();
        this.patterns = eltProperties.getPatterns();
        this.defaultValue = eltProperties.getDefaultValue();
        this.enumValues = eltProperties.getEnumValues();

        this.javaType = eltProperties.getJavaType();
        this.xmlSchemaType = eltProperties.getXmlSchemaType();
        this.xmlBeanType = eltProperties.getXmlBeanType();

        this.referentialType = eltProperties.isReferentialType();
        this.requestType = eltProperties.isRequestType();
        this.listType = eltProperties.isListType();
        this.primitiveType = eltProperties.isPrimitiveType();
        this.simpleType = eltProperties.isSimpleType();
        this.complexType = eltProperties.isComplexType();
        this.choiceElement = eltProperties.isChoiceElement();
        this.inherited = eltProperties.isInherited();
        this.localReferential = eltProperties.isLocalReferential();
    }

    public void setMinOccurs(BigInteger minOccurs) {
        this.minOccurs = minOccurs;
    }

    public BigInteger getMinOccurs() {
        return this.minOccurs;
    }

    public void setMaxOccurs(BigInteger maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public BigInteger getMaxOccurs() {
        return this.maxOccurs;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setListLength(int listLength) {
        this.listLength = listLength;
    }

    public int getListLength() {
        return this.listLength;
    }

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }

    public String[] getPatterns() {
        return this.patterns;
    }

    public void setEnumValues(String[] enumValues) {
        this.enumValues = enumValues;
    }

    public String[] getEnumValues() {
        return this.enumValues;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaType() {
        return this.javaType;
    }

    public void setXmlBeanType(String xmlBeanType) {
        this.xmlBeanType = xmlBeanType;
    }

    public String getXmlBeanType() {
        return this.xmlBeanType;
    }

    public void setXmlSchemaType(String xmlSchemaType) {
        this.xmlSchemaType = xmlSchemaType;
    }

    public String getXmlSchemaType() {
        return this.xmlSchemaType;
    }

    public void setReferentialType(boolean referentialType) {
        this.referentialType = referentialType;
    }

    public boolean isReferentialType() {
        return referentialType;
    }

    public void setRequestType(boolean requestType) {
        this.requestType = requestType;
    }

    public boolean isRequestType() {
        return requestType;
    }

    public void setListType(boolean listType) {
        this.listType = listType;
    }

    public boolean isListType() {
        return listType;
    }

    public void setPrimitiveType(boolean primitiveType) {
        this.primitiveType = primitiveType;
    }

    public boolean isPrimitiveType() {
        return primitiveType;
    }

    public void setComplexType(boolean complexType) {
        this.complexType = complexType;
    }

    public boolean isComplexType() {
        return complexType;
    }

    public void setChoiceElement(boolean choiceElement) {
        this.choiceElement = choiceElement;
    }

    public boolean isChoiceElement() {
        return choiceElement;
    }

    public void setSimpleType(boolean simpleType) {
        this.simpleType = simpleType;
    }

    public boolean isSimpleType() {
        return simpleType;
    }

    public void setInherited(boolean inherited) {
        this.inherited = inherited;
    }

    public boolean isInherited() {
        return inherited;
    }

    public void setLocalReferential(boolean localReferential) {
        this.localReferential = localReferential;
    }

    public boolean isLocalReferential() {
        return localReferential;
    }

    public ElementTypeClass getTypeClass() {
        if (simpleType || complexTypesAsSimple.contains(xmlSchemaType))
            return ElementTypeClass.SIMPLE;
        if (maxOccurs == null || maxOccurs.compareTo(BigInteger.ONE) == 1)
            return ElementTypeClass.COLLECTION;
        return ElementTypeClass.COMPLEX;
    }
}

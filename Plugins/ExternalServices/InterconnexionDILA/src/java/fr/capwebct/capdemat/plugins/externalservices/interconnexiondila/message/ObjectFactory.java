//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.23 at 04:10:50 PM CEST 
//


package fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Message_QNAME = new QName("http://www.message.interconnexiondila.externalservices.plugins.capdemat.capwebct.fr", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QualiteDemandeurType }
     * 
     */
    public QualiteDemandeurType createQualiteDemandeurType() {
        return new QualiteDemandeurType();
    }

    /**
     * Create an instance of {@link ParentType }
     * 
     */
    public ParentType createParentType() {
        return new ParentType();
    }

    /**
     * Create an instance of {@link DemandeActeType }
     * 
     */
    public DemandeActeType createDemandeActeType() {
        return new DemandeActeType();
    }

    /**
     * Create an instance of {@link AdressePostaleType }
     * 
     */
    public AdressePostaleType createAdressePostaleType() {
        return new AdressePostaleType();
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link BatchMailType }
     * 
     */
    public BatchMailType createBatchMailType() {
        return new BatchMailType();
    }

    /**
     * Create an instance of {@link EnveloppeMetierType }
     * 
     */
    public EnveloppeMetierType createEnveloppeMetierType() {
        return new EnveloppeMetierType();
    }

    /**
     * Create an instance of {@link IndividuType }
     * 
     */
    public IndividuType createIndividuType() {
        return new IndividuType();
    }
    
    /**
     * Create an instance of {@link NatureActeNaissanceType }
     * 
     */
    public NatureActeNaissanceType createNatureActeNaissanceType() {
        return new NatureActeNaissanceType();
    }

    /**
     * Create an instance of {@link DemandeurType }
     * 
     */
    public DemandeurType createDemandeurType() {
        return new DemandeurType();
    }

    /**
     * Create an instance of {@link VoieType }
     * 
     */
    public VoieType createVoieType() {
        return new VoieType();
    }

    /**
     * Create an instance of {@link FiliationType }
     * 
     */
    public FiliationType createFiliationType() {
        return new FiliationType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link AckType }
     * 
     */
    public AckType createAckType() {
        return new AckType();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link UpdateDbType }
     * 
     */
    public UpdateDbType createUpdateDbType() {
        return new UpdateDbType();
    }

    /**
     * Create an instance of {@link MotifDemandeType }
     * 
     */
    public MotifDemandeType createMotifDemandeType() {
        return new MotifDemandeType();
    }

    /**
     * Create an instance of {@link LieuNaissanceType }
     * 
     */
    public LieuNaissanceType createLieuNaissanceType() {
        return new LieuNaissanceType();
    }

    /**
     * Create an instance of {@link DepartementType }
     * 
     */
    public DepartementType createDepartementType() {
        return new DepartementType();
    }

    /**
     * Create an instance of {@link BodyType }
     * 
     */
    public BodyType createBodyType() {
        return new BodyType();
    }

    /**
     * Create an instance of {@link TypeDemandeType }
     * 
     */
    public TypeDemandeType createTypeDemandeType() {
        return new TypeDemandeType();
    }

    /**
     * Create an instance of {@link TypeActeType }
     * 
     */
    public TypeActeType createTypeActeType() {
        return new TypeActeType();
    }

    /**
     * Create an instance of {@link NatureActeType }
     * 
     */
    public NatureActeType createNatureActeType() {
        return new NatureActeType();
    }

    /**
     * Create an instance of {@link EnveloppeTechniqueType }
     * 
     */
    public EnveloppeTechniqueType createEnveloppeTechniqueType() {
        return new EnveloppeTechniqueType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.tempuri.org/ec#", name = "Message")
    public JAXBElement<MessageType> createMessage(MessageType value) {
        return new JAXBElement<MessageType>(_Message_QNAME, MessageType.class, null, value);
    }

}

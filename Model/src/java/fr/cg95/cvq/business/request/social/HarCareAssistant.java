package fr.cg95.cvq.business.request.social;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.util.*;

import java.math.BigInteger;

/**
 * @hibernate.class
 *  table="har_care_assistant"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HarCareAssistant implements Serializable {

    private static final long serialVersionUID = 1L;



    public HarCareAssistant() {
        super();
    }


    public final String modelToXmlString() {

        HarCareAssistantType object = (HarCareAssistantType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HarCareAssistantType harCareAssistant = HarCareAssistantType.Factory.newInstance();
        harCareAssistant.setHarProviderName(this.harProviderName);
        harCareAssistant.setHarProviderCode(this.harProviderCode);
        if (this.harEmployer != null)
            harCareAssistant.setHarEmployer(this.harEmployer.booleanValue());
        harCareAssistant.setHarCarerKind(this.harCarerKind);
        harCareAssistant.setHarProviderCity(this.harProviderCity);
        harCareAssistant.setHarProviderAddress(this.harProviderAddress);
        return harCareAssistant;
    }

    public static HarCareAssistant xmlToModel(HarCareAssistantType harCareAssistantDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HarCareAssistant harCareAssistant = new HarCareAssistant();
        harCareAssistant.setHarProviderName(harCareAssistantDoc.getHarProviderName());
        harCareAssistant.setHarProviderCode(harCareAssistantDoc.getHarProviderCode());
        harCareAssistant.setHarEmployer(Boolean.valueOf(harCareAssistantDoc.getHarEmployer()));
        harCareAssistant.setHarCarerKind(harCareAssistantDoc.getHarCarerKind());
        harCareAssistant.setHarProviderCity(harCareAssistantDoc.getHarProviderCity());
        harCareAssistant.setHarProviderAddress(harCareAssistantDoc.getHarProviderAddress());
        return harCareAssistant;
    }

    private Long id;


    public final void setId(final Long id) {
        this.id = id;
    }


    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

    private String harProviderName;

    public final void setHarProviderName(final String harProviderName) {
        this.harProviderName = harProviderName;
    }


    /**
     * @hibernate.property
     *  column="har_provider_name"
     */
    public final String getHarProviderName() {
        return this.harProviderName;
    }

    private String harProviderCode;

    public final void setHarProviderCode(final String harProviderCode) {
        this.harProviderCode = harProviderCode;
    }


    /**
     * @hibernate.property
     *  column="har_provider_code"
     *  length="5"
     */
    public final String getHarProviderCode() {
        return this.harProviderCode;
    }

    private Boolean harEmployer;

    public final void setHarEmployer(final Boolean harEmployer) {
        this.harEmployer = harEmployer;
    }


    /**
     * @hibernate.property
     *  column="har_employer"
     */
    public final Boolean getHarEmployer() {
        return this.harEmployer;
    }

    private String harCarerKind;

    public final void setHarCarerKind(final String harCarerKind) {
        this.harCarerKind = harCarerKind;
    }


    /**
     * @hibernate.property
     *  column="har_carer_kind"
     */
    public final String getHarCarerKind() {
        return this.harCarerKind;
    }

    private String harProviderCity;

    public final void setHarProviderCity(final String harProviderCity) {
        this.harProviderCity = harProviderCity;
    }


    /**
     * @hibernate.property
     *  column="har_provider_city"
     *  length="32"
     */
    public final String getHarProviderCity() {
        return this.harProviderCity;
    }

    private String harProviderAddress;

    public final void setHarProviderAddress(final String harProviderAddress) {
        this.harProviderAddress = harProviderAddress;
    }


    /**
     * @hibernate.property
     *  column="har_provider_address"
     */
    public final String getHarProviderAddress() {
        return this.harProviderAddress;
    }

}

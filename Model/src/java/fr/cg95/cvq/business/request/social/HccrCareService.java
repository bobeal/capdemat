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
 *  table="hccr_care_service"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HccrCareService implements Serializable {

    private static final long serialVersionUID = 1L;



    public HccrCareService() {
        super();
        careServiceCareServiceEmployer = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        HccrCareServiceType object = (HccrCareServiceType) this.modelToXml();
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
        HccrCareServiceType hccrCareService = HccrCareServiceType.Factory.newInstance();
        if (this.careServiceCareServiceEmployer != null)
            hccrCareService.setCareServiceCareServiceEmployer(this.careServiceCareServiceEmployer.booleanValue());
        hccrCareService.setCareServiceKind(this.careServiceKind);
        hccrCareService.setCareServiceProviderName(this.careServiceProviderName);
        if (this.careServiceProviderAddress != null)
            hccrCareService.setCareServiceProviderAddress(Address.modelToXml(this.careServiceProviderAddress));
        return hccrCareService;
    }

    public static HccrCareService xmlToModel(HccrCareServiceType hccrCareServiceDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrCareService hccrCareService = new HccrCareService();
        hccrCareService.setCareServiceCareServiceEmployer(Boolean.valueOf(hccrCareServiceDoc.getCareServiceCareServiceEmployer()));
        hccrCareService.setCareServiceKind(hccrCareServiceDoc.getCareServiceKind());
        hccrCareService.setCareServiceProviderName(hccrCareServiceDoc.getCareServiceProviderName());
        if (hccrCareServiceDoc.getCareServiceProviderAddress() != null)
            hccrCareService.setCareServiceProviderAddress(Address.xmlToModel(hccrCareServiceDoc.getCareServiceProviderAddress()));
        return hccrCareService;
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

    private Boolean careServiceCareServiceEmployer;

    public final void setCareServiceCareServiceEmployer(final Boolean careServiceCareServiceEmployer) {
        this.careServiceCareServiceEmployer = careServiceCareServiceEmployer;
    }


    /**
     * @hibernate.property
     *  column="care_service_care_service_employer"
     */
    public final Boolean getCareServiceCareServiceEmployer() {
        return this.careServiceCareServiceEmployer;
    }

    private String careServiceKind;

    public final void setCareServiceKind(final String careServiceKind) {
        this.careServiceKind = careServiceKind;
    }


    /**
     * @hibernate.property
     *  column="care_service_kind"
     */
    public final String getCareServiceKind() {
        return this.careServiceKind;
    }

    private String careServiceProviderName;

    public final void setCareServiceProviderName(final String careServiceProviderName) {
        this.careServiceProviderName = careServiceProviderName;
    }


    /**
     * @hibernate.property
     *  column="care_service_provider_name"
     *  length="38"
     */
    public final String getCareServiceProviderName() {
        return this.careServiceProviderName;
    }

    private fr.cg95.cvq.business.users.Address careServiceProviderAddress;

    public final void setCareServiceProviderAddress(final fr.cg95.cvq.business.users.Address careServiceProviderAddress) {
        this.careServiceProviderAddress = careServiceProviderAddress;
    }


    /**
     * @hibernate.many-to-one
     *  cascade="all"
     *  column="care_service_provider_address_id"
     *  class="fr.cg95.cvq.business.users.Address"
     */
    public final fr.cg95.cvq.business.users.Address getCareServiceProviderAddress() {
        return this.careServiceProviderAddress;
    }

}

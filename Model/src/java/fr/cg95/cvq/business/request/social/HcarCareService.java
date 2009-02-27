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
 *  table="hcar_care_service"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HcarCareService implements Serializable {

    private static final long serialVersionUID = 1L;



    public HcarCareService() {
        super();
        careServiceCareServiceEmployer = Boolean.valueOf(false);
    }


    public final String modelToXmlString() {

        HcarCareServiceType object = (HcarCareServiceType) this.modelToXml();
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
        HcarCareServiceType hcarCareService = HcarCareServiceType.Factory.newInstance();
        if (this.careServiceCareServiceEmployer != null)
            hcarCareService.setCareServiceCareServiceEmployer(this.careServiceCareServiceEmployer.booleanValue());
        hcarCareService.setCareServiceKind(this.careServiceKind);
        hcarCareService.setCareServiceProviderName(this.careServiceProviderName);
        if (this.careServiceProviderAddress != null)
            hcarCareService.setCareServiceProviderAddress(Address.modelToXml(this.careServiceProviderAddress));
        return hcarCareService;
    }

    public static HcarCareService xmlToModel(HcarCareServiceType hcarCareServiceDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarCareService hcarCareService = new HcarCareService();
        hcarCareService.setCareServiceCareServiceEmployer(Boolean.valueOf(hcarCareServiceDoc.getCareServiceCareServiceEmployer()));
        hcarCareService.setCareServiceKind(hcarCareServiceDoc.getCareServiceKind());
        hcarCareService.setCareServiceProviderName(hcarCareServiceDoc.getCareServiceProviderName());
        if (hcarCareServiceDoc.getCareServiceProviderAddress() != null)
            hcarCareService.setCareServiceProviderAddress(Address.xmlToModel(hcarCareServiceDoc.getCareServiceProviderAddress()));
        return hcarCareService;
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

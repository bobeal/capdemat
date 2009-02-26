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
 *  table="hccr_home_intervenant"
 *  lazy="false"
 *
 * Generated class file, do not edit!
 */
public class HccrHomeIntervenant implements Serializable {

    private static final long serialVersionUID = 1L;



    public HccrHomeIntervenant() {
        super();
    }


    public final String modelToXmlString() {

        HccrHomeIntervenantType object = (HccrHomeIntervenantType) this.modelToXml();
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
        HccrHomeIntervenantType hccrHomeIntervenant = HccrHomeIntervenantType.Factory.newInstance();
        if (this.homeIntervenantKind != null)
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.xml.request.social.HccrHomeIntervenantKindType.Enum.forString(this.homeIntervenantKind.toString()));
        hccrHomeIntervenant.setHomeIntervenantDetails(this.homeIntervenantDetails);
        return hccrHomeIntervenant;
    }

    public static HccrHomeIntervenant xmlToModel(HccrHomeIntervenantType hccrHomeIntervenantDoc) {

        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HccrHomeIntervenant hccrHomeIntervenant = new HccrHomeIntervenant();
        if (hccrHomeIntervenantDoc.getHomeIntervenantKind() != null)
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType.forString(hccrHomeIntervenantDoc.getHomeIntervenantKind().toString()));
        else
            hccrHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType.getDefaultHccrHomeIntervenantKindType());
        hccrHomeIntervenant.setHomeIntervenantDetails(hccrHomeIntervenantDoc.getHomeIntervenantDetails());
        return hccrHomeIntervenant;
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

    private fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType homeIntervenantKind;

    public final void setHomeIntervenantKind(final fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType homeIntervenantKind) {
        this.homeIntervenantKind = homeIntervenantKind;
    }


    /**
     * @hibernate.property
     *  column="home_intervenant_kind"
     */
    public final fr.cg95.cvq.business.request.social.HccrHomeIntervenantKindType getHomeIntervenantKind() {
        return this.homeIntervenantKind;
    }

    private String homeIntervenantDetails;

    public final void setHomeIntervenantDetails(final String homeIntervenantDetails) {
        this.homeIntervenantDetails = homeIntervenantDetails;
    }


    /**
     * @hibernate.property
     *  column="home_intervenant_details"
     *  length="60"
     */
    public final String getHomeIntervenantDetails() {
        return this.homeIntervenantDetails;
    }

}

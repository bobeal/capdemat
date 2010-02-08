
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="hcar_home_intervenant"
 *  lazy="false"
 */
public class HcarHomeIntervenant implements Serializable {

    private static final long serialVersionUID = 1L;

    public HcarHomeIntervenant() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarHomeIntervenantType object = (HcarHomeIntervenantType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarHomeIntervenantType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarHomeIntervenantType hcarHomeIntervenant = HcarHomeIntervenantType.Factory.newInstance();
        int i = 0;
    
        if (this.homeIntervenantKind != null)
            hcarHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.xml.request.social.HcarHomeIntervenantKindType.Enum.forString(this.homeIntervenantKind.toString()));
      
        hcarHomeIntervenant.setHomeIntervenantDetails(this.homeIntervenantDetails);
      
        return hcarHomeIntervenant;
    }

    public static HcarHomeIntervenant xmlToModel(HcarHomeIntervenantType hcarHomeIntervenantDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarHomeIntervenant hcarHomeIntervenant = new HcarHomeIntervenant();
    
        if (hcarHomeIntervenantDoc.getHomeIntervenantKind() != null)
            hcarHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType.forString(hcarHomeIntervenantDoc.getHomeIntervenantKind().toString()));
        else
            hcarHomeIntervenant.setHomeIntervenantKind(fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType.getDefaultHcarHomeIntervenantKindType());
      
        hcarHomeIntervenant.setHomeIntervenantDetails(hcarHomeIntervenantDoc.getHomeIntervenantDetails());
      
        return hcarHomeIntervenant;
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

  
    private fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType homeIntervenantKind;

    public final void setHomeIntervenantKind(final fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType homeIntervenantKind) {
        this.homeIntervenantKind = homeIntervenantKind;
    }

    /**
  
        * @hibernate.property
        *  column="home_intervenant_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.HcarHomeIntervenantKindType getHomeIntervenantKind() {
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

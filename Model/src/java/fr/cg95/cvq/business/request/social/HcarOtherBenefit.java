
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
 *  table="hcar_other_benefit"
 *  lazy="false"
 */
public class HcarOtherBenefit implements Serializable {

    private static final long serialVersionUID = 1L;

    public HcarOtherBenefit() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarOtherBenefitType object = (HcarOtherBenefitType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarOtherBenefitType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarOtherBenefitType hcarOtherBenefit = HcarOtherBenefitType.Factory.newInstance();
        int i = 0;
    
        hcarOtherBenefit.setOtherBenefitName(this.otherBenefitName);
      
        return hcarOtherBenefit;
    }

    public static HcarOtherBenefit xmlToModel(HcarOtherBenefitType hcarOtherBenefitDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarOtherBenefit hcarOtherBenefit = new HcarOtherBenefit();
    
        hcarOtherBenefit.setOtherBenefitName(hcarOtherBenefitDoc.getOtherBenefitName());
      
        return hcarOtherBenefit;
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

  
    private String otherBenefitName;

    public final void setOtherBenefitName(final String otherBenefitName) {
        this.otherBenefitName = otherBenefitName;
    }

    /**
  
        * @hibernate.property
        *  column="other_benefit_name"
        *  length="60"
      
    */
    public final String getOtherBenefitName() {
        return this.otherBenefitName;
    }
  
}

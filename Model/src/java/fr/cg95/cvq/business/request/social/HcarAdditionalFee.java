
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.oval.constraint.*;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="hcar_additional_fee"
 *  lazy="false"
 */
public class HcarAdditionalFee implements Serializable {

    private static final long serialVersionUID = 1L;

    public HcarAdditionalFee() {
        super();
      
    }

    public final String modelToXmlString() {
        HcarAdditionalFeeType object = (HcarAdditionalFeeType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HcarAdditionalFeeType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        HcarAdditionalFeeType hcarAdditionalFee = HcarAdditionalFeeType.Factory.newInstance();
        int i = 0;
    
        hcarAdditionalFee.setAdditionalFeeKind(this.additionalFeeKind);
      
        hcarAdditionalFee.setAdditionalFeePeriodicity(this.additionalFeePeriodicity);
      
        hcarAdditionalFee.setAdditionalFeeCost(this.additionalFeeCost);
      
        return hcarAdditionalFee;
    }

    public static HcarAdditionalFee xmlToModel(HcarAdditionalFeeType hcarAdditionalFeeDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        HcarAdditionalFee hcarAdditionalFee = new HcarAdditionalFee();
    
        hcarAdditionalFee.setAdditionalFeeKind(hcarAdditionalFeeDoc.getAdditionalFeeKind());
      
        hcarAdditionalFee.setAdditionalFeePeriodicity(hcarAdditionalFeeDoc.getAdditionalFeePeriodicity());
      
        hcarAdditionalFee.setAdditionalFeeCost(hcarAdditionalFeeDoc.getAdditionalFeeCost());
      
        return hcarAdditionalFee;
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

  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeeKind"
      )
    
    private String additionalFeeKind;

    public final void setAdditionalFeeKind(final String additionalFeeKind) {
        this.additionalFeeKind = additionalFeeKind;
    }

    /**
  
        * @hibernate.property
        *  column="additional_fee_kind"
        *  length="30"
      
    */
    public final String getAdditionalFeeKind() {
        return this.additionalFeeKind;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeePeriodicity"
      )
    
    private String additionalFeePeriodicity;

    public final void setAdditionalFeePeriodicity(final String additionalFeePeriodicity) {
        this.additionalFeePeriodicity = additionalFeePeriodicity;
    }

    /**
  
        * @hibernate.property
        *  column="additional_fee_periodicity"
        *  length="30"
      
    */
    public final String getAdditionalFeePeriodicity() {
        return this.additionalFeePeriodicity;
    }
  
    
      @NotNull(
        
        
        profiles = {"benefits"},
        message = "additionalFeeCost"
      )
    
      @NotBlank(
        
        
        profiles = {"benefits"},
        message = "additionalFeeCost"
      )
    
    private String additionalFeeCost;

    public final void setAdditionalFeeCost(final String additionalFeeCost) {
        this.additionalFeeCost = additionalFeeCost;
    }

    /**
  
        * @hibernate.property
        *  column="additional_fee_cost"
        *  length="6"
      
    */
    public final String getAdditionalFeeCost() {
        return this.additionalFeeCost;
    }
  
}

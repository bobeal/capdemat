
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalTime;

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
 *  table="dhr_not_real_asset"
 *  lazy="false"
 */
public class DhrNotRealAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    public DhrNotRealAsset() {
        super();
      
    }

    public final String modelToXmlString() {
        DhrNotRealAssetType object = (DhrNotRealAssetType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final DhrNotRealAssetType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        DhrNotRealAssetType dhrNotRealAsset = DhrNotRealAssetType.Factory.newInstance();
        int i = 0;
    
        if (this.dhrNotRealAssetValue != null)
            dhrNotRealAsset.setDhrNotRealAssetValue(new BigInteger(this.dhrNotRealAssetValue.toString()));
      
        if (this.dhrNotRealAssetAddress != null)
            dhrNotRealAsset.setDhrNotRealAssetAddress(Address.modelToXml(this.dhrNotRealAssetAddress));
      
        date = this.dhrNotRealAssetDate;
        if (date != null) {
            calendar.setTime(date);
            dhrNotRealAsset.setDhrNotRealAssetDate(calendar);
        }
      
        dhrNotRealAsset.setDhrNotRealAssetNotaryName(this.dhrNotRealAssetNotaryName);
      
        dhrNotRealAsset.setDhrNotRealAssetBeneficiaryName(this.dhrNotRealAssetBeneficiaryName);
      
        dhrNotRealAsset.setDhrNotRealAssetBeneficiaryFirstName(this.dhrNotRealAssetBeneficiaryFirstName);
      
        if (this.dhrNotRealAssetType != null)
            dhrNotRealAsset.setDhrNotRealAssetType(fr.cg95.cvq.xml.request.social.DhrAssetTypeType.Enum.forString(this.dhrNotRealAssetType.toString()));
      
        if (this.dhrNotRealAssetBeneficiaryAddress != null)
            dhrNotRealAsset.setDhrNotRealAssetBeneficiaryAddress(Address.modelToXml(this.dhrNotRealAssetBeneficiaryAddress));
      
        if (this.dhrNotRealAssetNotaryAddress != null)
            dhrNotRealAsset.setDhrNotRealAssetNotaryAddress(Address.modelToXml(this.dhrNotRealAssetNotaryAddress));
      
        if (this.dhrNotRealAssetKind != null)
            dhrNotRealAsset.setDhrNotRealAssetKind(fr.cg95.cvq.xml.request.social.DhrAssetKindType.Enum.forString(this.dhrNotRealAssetKind.toString()));
      
        return dhrNotRealAsset;
    }

    public static DhrNotRealAsset xmlToModel(DhrNotRealAssetType dhrNotRealAssetDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        DhrNotRealAsset dhrNotRealAsset = new DhrNotRealAsset();
    
        dhrNotRealAsset.setDhrNotRealAssetValue(dhrNotRealAssetDoc.getDhrNotRealAssetValue());
      
        if (dhrNotRealAssetDoc.getDhrNotRealAssetAddress() != null)
            dhrNotRealAsset.setDhrNotRealAssetAddress(Address.xmlToModel(dhrNotRealAssetDoc.getDhrNotRealAssetAddress()));
      
        calendar = dhrNotRealAssetDoc.getDhrNotRealAssetDate();
        if (calendar != null) {
            dhrNotRealAsset.setDhrNotRealAssetDate(calendar.getTime());
        }
      
        dhrNotRealAsset.setDhrNotRealAssetNotaryName(dhrNotRealAssetDoc.getDhrNotRealAssetNotaryName());
      
        dhrNotRealAsset.setDhrNotRealAssetBeneficiaryName(dhrNotRealAssetDoc.getDhrNotRealAssetBeneficiaryName());
      
        dhrNotRealAsset.setDhrNotRealAssetBeneficiaryFirstName(dhrNotRealAssetDoc.getDhrNotRealAssetBeneficiaryFirstName());
      
        if (dhrNotRealAssetDoc.getDhrNotRealAssetType() != null)
            dhrNotRealAsset.setDhrNotRealAssetType(fr.cg95.cvq.business.request.social.DhrAssetTypeType.forString(dhrNotRealAssetDoc.getDhrNotRealAssetType().toString()));
        else
            dhrNotRealAsset.setDhrNotRealAssetType(fr.cg95.cvq.business.request.social.DhrAssetTypeType.getDefaultDhrAssetTypeType());
      
        if (dhrNotRealAssetDoc.getDhrNotRealAssetBeneficiaryAddress() != null)
            dhrNotRealAsset.setDhrNotRealAssetBeneficiaryAddress(Address.xmlToModel(dhrNotRealAssetDoc.getDhrNotRealAssetBeneficiaryAddress()));
      
        if (dhrNotRealAssetDoc.getDhrNotRealAssetNotaryAddress() != null)
            dhrNotRealAsset.setDhrNotRealAssetNotaryAddress(Address.xmlToModel(dhrNotRealAssetDoc.getDhrNotRealAssetNotaryAddress()));
      
        if (dhrNotRealAssetDoc.getDhrNotRealAssetKind() != null)
            dhrNotRealAsset.setDhrNotRealAssetKind(fr.cg95.cvq.business.request.social.DhrAssetKindType.forString(dhrNotRealAssetDoc.getDhrNotRealAssetKind().toString()));
        else
            dhrNotRealAsset.setDhrNotRealAssetKind(fr.cg95.cvq.business.request.social.DhrAssetKindType.getDefaultDhrAssetKindType());
      
        return dhrNotRealAsset;
    }

    @Override
    public DhrNotRealAsset clone() {
        DhrNotRealAsset result = new DhrNotRealAsset();
        
          
            
        result.setDhrNotRealAssetValue(dhrNotRealAssetValue);
      
          
        
          
            
        if (dhrNotRealAssetAddress != null)
            result.setDhrNotRealAssetAddress(dhrNotRealAssetAddress.clone());
      
          
        
          
            
        result.setDhrNotRealAssetDate(dhrNotRealAssetDate);
      
          
        
          
            
        result.setDhrNotRealAssetNotaryName(dhrNotRealAssetNotaryName);
      
          
        
          
            
        result.setDhrNotRealAssetBeneficiaryName(dhrNotRealAssetBeneficiaryName);
      
          
        
          
            
        result.setDhrNotRealAssetBeneficiaryFirstName(dhrNotRealAssetBeneficiaryFirstName);
      
          
        
          
            
        if (dhrNotRealAssetType != null)
            result.setDhrNotRealAssetType(dhrNotRealAssetType);
        else
            result.setDhrNotRealAssetType(fr.cg95.cvq.business.request.social.DhrAssetTypeType.getDefaultDhrAssetTypeType());
      
          
        
          
            
        if (dhrNotRealAssetBeneficiaryAddress != null)
            result.setDhrNotRealAssetBeneficiaryAddress(dhrNotRealAssetBeneficiaryAddress.clone());
      
          
        
          
            
        if (dhrNotRealAssetNotaryAddress != null)
            result.setDhrNotRealAssetNotaryAddress(dhrNotRealAssetNotaryAddress.clone());
      
          
        
          
            
        if (dhrNotRealAssetKind != null)
            result.setDhrNotRealAssetKind(dhrNotRealAssetKind);
        else
            result.setDhrNotRealAssetKind(fr.cg95.cvq.business.request.social.DhrAssetKindType.getDefaultDhrAssetKindType());
      
          
        
        return result;
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

  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetValue"
      )
    
    private java.math.BigInteger dhrNotRealAssetValue;

    public final void setDhrNotRealAssetValue(final java.math.BigInteger dhrNotRealAssetValue) {
        this.dhrNotRealAssetValue = dhrNotRealAssetValue;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_value"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getDhrNotRealAssetValue() {
        return this.dhrNotRealAssetValue;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrNotRealAsset.dhrNotRealAssetKind'].test(_this.dhrNotRealAssetKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"resources"},
        message = "dhrNotRealAssetAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrNotRealAsset.dhrNotRealAssetKind'].test(_this.dhrNotRealAssetKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"resources"},
        message = "dhrNotRealAssetAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrNotRealAssetAddress;

    public final void setDhrNotRealAssetAddress(final fr.cg95.cvq.business.users.Address dhrNotRealAssetAddress) {
        this.dhrNotRealAssetAddress = dhrNotRealAssetAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_not_real_asset_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrNotRealAssetAddress() {
        return this.dhrNotRealAssetAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetDate"
      )
    
    private java.util.Date dhrNotRealAssetDate;

    public final void setDhrNotRealAssetDate(final java.util.Date dhrNotRealAssetDate) {
        this.dhrNotRealAssetDate = dhrNotRealAssetDate;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_date"
        
      
    */
    public final java.util.Date getDhrNotRealAssetDate() {
        return this.dhrNotRealAssetDate;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetNotaryName"
      )
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetNotaryName"
      )
    
      @NotBlank(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetNotaryName"
      )
    
    private String dhrNotRealAssetNotaryName;

    public final void setDhrNotRealAssetNotaryName(final String dhrNotRealAssetNotaryName) {
        this.dhrNotRealAssetNotaryName = dhrNotRealAssetNotaryName;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_notary_name"
        *  length="38"
      
    */
    public final String getDhrNotRealAssetNotaryName() {
        return this.dhrNotRealAssetNotaryName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryName"
      )
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryName"
      )
    
      @NotBlank(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryName"
      )
    
    private String dhrNotRealAssetBeneficiaryName;

    public final void setDhrNotRealAssetBeneficiaryName(final String dhrNotRealAssetBeneficiaryName) {
        this.dhrNotRealAssetBeneficiaryName = dhrNotRealAssetBeneficiaryName;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_beneficiary_name"
        *  length="38"
      
    */
    public final String getDhrNotRealAssetBeneficiaryName() {
        return this.dhrNotRealAssetBeneficiaryName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryFirstName"
      )
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryFirstName"
      )
    
      @NotBlank(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryFirstName"
      )
    
    private String dhrNotRealAssetBeneficiaryFirstName;

    public final void setDhrNotRealAssetBeneficiaryFirstName(final String dhrNotRealAssetBeneficiaryFirstName) {
        this.dhrNotRealAssetBeneficiaryFirstName = dhrNotRealAssetBeneficiaryFirstName;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_beneficiary_first_name"
        *  length="38"
      
    */
    public final String getDhrNotRealAssetBeneficiaryFirstName() {
        return this.dhrNotRealAssetBeneficiaryFirstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetType"
      )
    
    private fr.cg95.cvq.business.request.social.DhrAssetTypeType dhrNotRealAssetType;

    public final void setDhrNotRealAssetType(final fr.cg95.cvq.business.request.social.DhrAssetTypeType dhrNotRealAssetType) {
        this.dhrNotRealAssetType = dhrNotRealAssetType;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_type"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrAssetTypeType getDhrNotRealAssetType() {
        return this.dhrNotRealAssetType;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetBeneficiaryAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrNotRealAssetBeneficiaryAddress;

    public final void setDhrNotRealAssetBeneficiaryAddress(final fr.cg95.cvq.business.users.Address dhrNotRealAssetBeneficiaryAddress) {
        this.dhrNotRealAssetBeneficiaryAddress = dhrNotRealAssetBeneficiaryAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_not_real_asset_beneficiary_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrNotRealAssetBeneficiaryAddress() {
        return this.dhrNotRealAssetBeneficiaryAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetNotaryAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetNotaryAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrNotRealAssetNotaryAddress;

    public final void setDhrNotRealAssetNotaryAddress(final fr.cg95.cvq.business.users.Address dhrNotRealAssetNotaryAddress) {
        this.dhrNotRealAssetNotaryAddress = dhrNotRealAssetNotaryAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_not_real_asset_notary_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrNotRealAssetNotaryAddress() {
        return this.dhrNotRealAssetNotaryAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"resources"},
        message = "dhrNotRealAssetKind"
      )
    
    private fr.cg95.cvq.business.request.social.DhrAssetKindType dhrNotRealAssetKind;

    public final void setDhrNotRealAssetKind(final fr.cg95.cvq.business.request.social.DhrAssetKindType dhrNotRealAssetKind) {
        this.dhrNotRealAssetKind = dhrNotRealAssetKind;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_not_real_asset_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrAssetKindType getDhrNotRealAssetKind() {
        return this.dhrNotRealAssetKind;
    }
  
}

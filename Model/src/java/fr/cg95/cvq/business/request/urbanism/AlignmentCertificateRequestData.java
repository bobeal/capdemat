
package fr.cg95.cvq.business.request.urbanism;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="alignment_certificate_request"
 *  lazy="false"
 */
public class AlignmentCertificateRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public AlignmentCertificateRequestData() {
      
        requesterQuality = fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType.OWNER;
      
    }

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
        
        
        profiles = {"cadastre"},
        message = "requesterQuality"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality"
        
      
    */
    public final fr.cg95.cvq.business.request.urbanism.AcrRequesterQualityType getRequesterQuality() {
        return this.requesterQuality;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "section"
      )
    
      @NotBlank(
        
        
        profiles = {"cadastre"},
        message = "section"
      )
    
    private String section;

    public final void setSection(final String section) {
        this.section = section;
    }

    /**
 
        * @hibernate.property
        *  column="section"
        
      
    */
    public final String getSection() {
        return this.section;
    }
  
    
    private String transportationRoute;

    public final void setTransportationRoute(final String transportationRoute) {
        this.transportationRoute = transportationRoute;
    }

    /**
 
        * @hibernate.property
        *  column="transportation_route"
        
      
    */
    public final String getTransportationRoute() {
        return this.transportationRoute;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerFirstNames"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerFirstNames"
      )
    
    private String ownerFirstNames;

    public final void setOwnerFirstNames(final String ownerFirstNames) {
        this.ownerFirstNames = ownerFirstNames;
    }

    /**
 
        * @hibernate.property
        *  column="owner_first_names"
        
      
    */
    public final String getOwnerFirstNames() {
        return this.ownerFirstNames;
    }
  
    
    private String locality;

    public final void setLocality(final String locality) {
        this.locality = locality;
    }

    /**
 
        * @hibernate.property
        *  column="locality"
        
      
    */
    public final String getLocality() {
        return this.locality;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "number"
      )
    
    private java.math.BigInteger number;

    public final void setNumber(final java.math.BigInteger number) {
        this.number = number;
    }

    /**
 
        * @hibernate.property
        *  column="number"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getNumber() {
        return this.number;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerLastName"
      )
    
    private String ownerLastName;

    public final void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    /**
 
        * @hibernate.property
        *  column="owner_last_name"
        *  length="38"
      
    */
    public final String getOwnerLastName() {
        return this.ownerLastName;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerAddress"
      )
    
    private fr.cg95.cvq.business.users.Address ownerAddress;

    public final void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="owner_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return this.ownerAddress;
    }
  
}


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
 *  table="alignment_numbering_connection_request"
 *  lazy="false"
 */
public class AlignmentNumberingConnectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public AlignmentNumberingConnectionRequestData() {
      
        requesterQuality = fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.OWNER;
      
        isAccountAddress = Boolean.valueOf(true);
      
    }

    @Override
    public AlignmentNumberingConnectionRequestData clone() {
        AlignmentNumberingConnectionRequestData result = new AlignmentNumberingConnectionRequestData();
        
          
            
        result.setIsNumbering(isNumbering);
      
          
        
          
            
        if (otherAddress != null)
            result.setOtherAddress(otherAddress.clone());
      
          
        
          
            
        result.setOwnerFirstNames(ownerFirstNames);
      
          
        
          
            
        result.setNumber(number);
      
          
        
          
            
        result.setArea(area);
      
          
        
          
            
        result.setMoreThanTwoYears(moreThanTwoYears);
      
          
        
          
            
        if (ownerAddress != null)
            result.setOwnerAddress(ownerAddress.clone());
      
          
        
          
            
        if (requesterQuality != null)
            result.setRequesterQuality(requesterQuality);
        else
            result.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.getDefaultAncrRequesterQualityType());
      
          
        
          
            
        result.setSection(section);
      
          
        
          
            
        result.setTransportationRoute(transportationRoute);
      
          
        
          
            
        result.setLocality(locality);
      
          
        
          
            
        result.setIsConnection(isConnection);
      
          
        
          
            
        result.setIsAccountAddress(isAccountAddress);
      
          
        
          
            
        result.setIsAlignment(isAlignment);
      
          
        
          
            
        result.setOwnerLastName(ownerLastName);
      
          
        
        return result;
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
        message = "isNumbering"
      )
    
    private Boolean isNumbering;

    public final void setIsNumbering(final Boolean isNumbering) {
        this.isNumbering = isNumbering;
    }

    /**
 
        * @hibernate.property
        *  column="is_numbering"
        
      
    */
    public final Boolean getIsNumbering() {
        return this.isNumbering;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isAccountAddress'].test(_this.isAccountAddress.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"address"},
        message = "otherAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['isAccountAddress'].test(_this.isAccountAddress.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"address"},
        message = "otherAddress"
      )
    
    private fr.cg95.cvq.business.users.Address otherAddress;

    public final void setOtherAddress(final fr.cg95.cvq.business.users.Address otherAddress) {
        this.otherAddress = otherAddress;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="other_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getOtherAddress() {
        return this.otherAddress;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerFirstNames"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
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
  
    
    private java.math.BigInteger area;

    public final void setArea(final java.math.BigInteger area) {
        this.area = area;
    }

    /**
 
        * @hibernate.property
        *  column="area"
        *  type="serializable"
        
      
    */
    public final java.math.BigInteger getArea() {
        return this.area;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "moreThanTwoYears"
      )
    
    private Boolean moreThanTwoYears;

    public final void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        this.moreThanTwoYears = moreThanTwoYears;
    }

    /**
 
        * @hibernate.property
        *  column="more_than_two_years"
        
      
    */
    public final Boolean getMoreThanTwoYears() {
        return this.moreThanTwoYears;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerAddress"
      )
    
      @AssertValid(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
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
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "requesterQuality"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality;

    public final void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

    /**
 
        * @hibernate.property
        *  column="requester_quality"
        
      
    */
    public final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType getRequesterQuality() {
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
        message = "isConnection"
      )
    
    private Boolean isConnection;

    public final void setIsConnection(final Boolean isConnection) {
        this.isConnection = isConnection;
    }

    /**
 
        * @hibernate.property
        *  column="is_connection"
        
      
    */
    public final Boolean getIsConnection() {
        return this.isConnection;
    }
  
    
      @NotNull(
        
        
        profiles = {"address"},
        message = "isAccountAddress"
      )
    
    private Boolean isAccountAddress;

    public final void setIsAccountAddress(final Boolean isAccountAddress) {
        this.isAccountAddress = isAccountAddress;
    }

    /**
 
        * @hibernate.property
        *  column="is_account_address"
        
      
    */
    public final Boolean getIsAccountAddress() {
        return this.isAccountAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "isAlignment"
      )
    
    private Boolean isAlignment;

    public final void setIsAlignment(final Boolean isAlignment) {
        this.isAlignment = isAlignment;
    }

    /**
 
        * @hibernate.property
        *  column="is_alignment"
        
      
    */
    public final Boolean getIsAlignment() {
        return this.isAlignment;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerLastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"cadastre"},
        message = "ownerLastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= !_this.conditions['requesterQuality'].test(_this.requesterQuality.toString());" +
                
              
            
            
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
  
}

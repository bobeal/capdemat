

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

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="alignment_numbering_connection_request")
public class AlignmentNumberingConnectionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public AlignmentNumberingConnectionRequestData() {
      
        isAccountAddress = Boolean.valueOf(true);
      
        requesterQuality = fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.OWNER;
      
    }

    @Override
    public AlignmentNumberingConnectionRequestData clone() {
        AlignmentNumberingConnectionRequestData result = new AlignmentNumberingConnectionRequestData();
        
          
            
        result.setArea(area);
      
          
        
          
            
        result.setIsAccountAddress(isAccountAddress);
      
          
        
          
            
        result.setIsAlignment(isAlignment);
      
          
        
          
            
        result.setIsConnection(isConnection);
      
          
        
          
            
        result.setIsNumbering(isNumbering);
      
          
        
          
            
        result.setLocality(locality);
      
          
        
          
            
        result.setMoreThanTwoYears(moreThanTwoYears);
      
          
        
          
            
        result.setNumber(number);
      
          
        
          
            
        if (otherAddress != null)
            result.setOtherAddress(otherAddress.clone());
      
          
        
          
            
        if (ownerAddress != null)
            result.setOwnerAddress(ownerAddress.clone());
      
          
        
          
            
        result.setOwnerFirstNames(ownerFirstNames);
      
          
        
          
            
        result.setOwnerLastName(ownerLastName);
      
          
        
          
            
        if (requesterQuality != null)
            result.setRequesterQuality(requesterQuality);
        else
            result.setRequesterQuality(fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType.getDefaultAncrRequesterQualityType());
      
          
        
          
            
        result.setSection(section);
      
          
        
          
            
        result.setTransportationRoute(transportationRoute);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
    private java.math.BigInteger area;

    public void setArea(final java.math.BigInteger area) {
        this.area = area;
    }

 
    @Column(name="area" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getArea() {
        return this.area;
    }
  
    
      @NotNull(
        
        
        profiles = {"address"},
        message = "isAccountAddress"
      )
    
    private Boolean isAccountAddress;

    public void setIsAccountAddress(final Boolean isAccountAddress) {
        this.isAccountAddress = isAccountAddress;
    }

 
    @Column(name="is_account_address"  )
      
    public Boolean getIsAccountAddress() {
        return this.isAccountAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "isAlignment"
      )
    
    private Boolean isAlignment;

    public void setIsAlignment(final Boolean isAlignment) {
        this.isAlignment = isAlignment;
    }

 
    @Column(name="is_alignment"  )
      
    public Boolean getIsAlignment() {
        return this.isAlignment;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "isConnection"
      )
    
    private Boolean isConnection;

    public void setIsConnection(final Boolean isConnection) {
        this.isConnection = isConnection;
    }

 
    @Column(name="is_connection"  )
      
    public Boolean getIsConnection() {
        return this.isConnection;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "isNumbering"
      )
    
    private Boolean isNumbering;

    public void setIsNumbering(final Boolean isNumbering) {
        this.isNumbering = isNumbering;
    }

 
    @Column(name="is_numbering"  )
      
    public Boolean getIsNumbering() {
        return this.isNumbering;
    }
  
    
    private String locality;

    public void setLocality(final String locality) {
        this.locality = locality;
    }

 
    @Column(name="locality"  )
      
    public String getLocality() {
        return this.locality;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "moreThanTwoYears"
      )
    
    private Boolean moreThanTwoYears;

    public void setMoreThanTwoYears(final Boolean moreThanTwoYears) {
        this.moreThanTwoYears = moreThanTwoYears;
    }

 
    @Column(name="more_than_two_years"  )
      
    public Boolean getMoreThanTwoYears() {
        return this.moreThanTwoYears;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "number"
      )
    
    private java.math.BigInteger number;

    public void setNumber(final java.math.BigInteger number) {
        this.number = number;
    }

 
    @Column(name="number" , columnDefinition="bytea" )
    @Type(type="serializable") //Hack see http://capdemat.capwebct.fr/ticket/338
      
    public java.math.BigInteger getNumber() {
        return this.number;
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

    public void setOtherAddress(final fr.cg95.cvq.business.users.Address otherAddress) {
        this.otherAddress = otherAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="other_address_id")
      
    public fr.cg95.cvq.business.users.Address getOtherAddress() {
        return this.otherAddress;
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

    public void setOwnerAddress(final fr.cg95.cvq.business.users.Address ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="owner_address_id")
      
    public fr.cg95.cvq.business.users.Address getOwnerAddress() {
        return this.ownerAddress;
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

    public void setOwnerFirstNames(final String ownerFirstNames) {
        this.ownerFirstNames = ownerFirstNames;
    }

 
    @Column(name="owner_first_names"  )
      
    public String getOwnerFirstNames() {
        return this.ownerFirstNames;
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

    public void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

 
    @Column(name="owner_last_name" , length=38 )
      
    public String getOwnerLastName() {
        return this.ownerLastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"cadastre"},
        message = "requesterQuality"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality;

    public void setRequesterQuality(final fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType requesterQuality) {
        this.requesterQuality = requesterQuality;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_quality"  )
      
    public fr.cg95.cvq.business.request.urbanism.AncrRequesterQualityType getRequesterQuality() {
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

    public void setSection(final String section) {
        this.section = section;
    }

 
    @Column(name="section"  )
      
    public String getSection() {
        return this.section;
    }
  
    
    private String transportationRoute;

    public void setTransportationRoute(final String transportationRoute) {
        this.transportationRoute = transportationRoute;
    }

 
    @Column(name="transportation_route"  )
      
    public String getTransportationRoute() {
        return this.transportationRoute;
    }
  
}

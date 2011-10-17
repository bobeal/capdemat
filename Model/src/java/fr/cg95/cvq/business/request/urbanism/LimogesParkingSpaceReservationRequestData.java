

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
@Table(name="limoges_parking_space_reservation_request")
public class LimogesParkingSpaceReservationRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LimogesParkingSpaceReservationRequestData() {
      
        furnitureLift = Boolean.valueOf(false);
      
        lpsrrRule = Boolean.valueOf(false);
      
    }

    @Override
    public LimogesParkingSpaceReservationRequestData clone() {
        LimogesParkingSpaceReservationRequestData result = new LimogesParkingSpaceReservationRequestData();
        
          
            
        result.setAddress(address);
      
          
        
          
            
        if (civility != null)
            result.setCivility(civility);
        else
            result.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setContractorName(contractorName);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.LocalReferentialData> durationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>();
        for (LocalReferentialData object : duration) {
            durationList.add(object.clone());
        }
        result.setDuration(durationList);
      
          
        
          
            
        result.setFaxNumber(faxNumber);
      
          
        
          
            
        result.setFirstName(firstName);
      
          
        
          
            
        result.setFootWay(footWay);
      
          
        
          
            
        result.setFurnitureLift(furnitureLift);
      
          
        
          
            
        result.setLastName(lastName);
      
          
        
          
            
        result.setLpsrrRule(lpsrrRule);
      
          
        
          
            
        result.setMail(mail);
      
          
        
          
            
        result.setPhoneNumber(phoneNumber);
      
          
        
          
            
        result.setRequesterFirstAddress(requesterFirstAddress);
      
          
        
          
            
        if (requesterFirstAddressKind != null)
            result.setRequesterFirstAddressKind(requesterFirstAddressKind);
        else
            result.setRequesterFirstAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
          
        
          
            
        result.setRequesterOtherAddress(requesterOtherAddress);
      
          
        
          
            
        if (requesterOtherAddressKind != null)
            result.setRequesterOtherAddressKind(requesterOtherAddressKind);
        else
            result.setRequesterOtherAddressKind(fr.cg95.cvq.business.request.urbanism.AccountAddressKindType.getDefaultAccountAddressKindType());
      
          
        
          
            
        if (requesterType != null)
            result.setRequesterType(requesterType);
        else
            result.setRequesterType(fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType.getDefaultLpsrrRequesterType());
      
          
        
          
            
        result.setStartDate(startDate);
      
          
        
          
            
        result.setVehiclesRegistration(vehiclesRegistration);
      
          
        
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

  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forAll='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "address"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forAll='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "address"
      )
    
    private String address;

    public void setAddress(final String address) {
        this.address = address;
    }

 
    @Column(name="address"  )
      
    public String getAddress() {
        return this.address;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "civility"
      )
    
    private fr.cg95.cvq.business.users.TitleType civility;

    public void setCivility(final fr.cg95.cvq.business.users.TitleType civility) {
        this.civility = civility;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="civility"  )
      
    public fr.cg95.cvq.business.users.TitleType getCivility() {
        return this.civility;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isContractor='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "contractorName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isContractor='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "contractorName"
      )
    
    private String contractorName;

    public void setContractorName(final String contractorName) {
        this.contractorName = contractorName;
    }

 
    @Column(name="contractor_name"  )
      
    public String getContractorName() {
        return this.contractorName;
    }
  
    
      @LocalReferential(
        
        
        profiles = {"reservation"},
        message = "duration"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"reservation"},
        message = "duration"
      )
    
    private List<fr.cg95.cvq.business.request.LocalReferentialData> duration;

    public void setDuration(final List<fr.cg95.cvq.business.request.LocalReferentialData> duration) {
        this.duration = duration;
    }

 
    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="limoges_parking_space_reservation_request_duration",
            joinColumns=
                @JoinColumn(name="limoges_parking_space_reservation_request_id"),
            inverseJoinColumns=
                @JoinColumn(name="duration_id"))
    @OrderColumn(name="duration_index")
      
    public List<fr.cg95.cvq.business.request.LocalReferentialData> getDuration() {
        return this.duration;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isContractor='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "faxNumber"
      )
    
    private String faxNumber;

    public void setFaxNumber(final String faxNumber) {
        this.faxNumber = faxNumber;
    }

 
    @Column(name="fax_number" , length=10 )
      
    public String getFaxNumber() {
        return this.faxNumber;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "firstName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "firstName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "firstName"
      )
    
    private String firstName;

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

 
    @Column(name="first_name" , length=38 )
      
    public String getFirstName() {
        return this.firstName;
    }
  
    
      @NotNull(
        
        
        profiles = {"complement"},
        message = "footWay"
      )
    
    private Boolean footWay;

    public void setFootWay(final Boolean footWay) {
        this.footWay = footWay;
    }

 
    @Column(name="foot_way"  )
      
    public Boolean getFootWay() {
        return this.footWay;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "furnitureLift"
      )
    
    private Boolean furnitureLift;

    public void setFurnitureLift(final Boolean furnitureLift) {
        this.furnitureLift = furnitureLift;
    }

 
    @Column(name="furniture_lift"  )
      
    public Boolean getFurnitureLift() {
        return this.furnitureLift;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "lastName"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "lastName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isLandlord='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "lastName"
      )
    
    private String lastName;

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

 
    @Column(name="last_name" , length=38 )
      
    public String getLastName() {
        return this.lastName;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "lpsrrRule"
      )
    
    private Boolean lpsrrRule;

    public void setLpsrrRule(final Boolean lpsrrRule) {
        this.lpsrrRule = lpsrrRule;
    }

 
    @Column(name="lpsrr_rule"  )
      
    public Boolean getLpsrrRule() {
        return this.lpsrrRule;
    }
  
    
    private String mail;

    public void setMail(final String mail) {
        this.mail = mail;
    }

 
    @Column(name="mail"  )
      
    public String getMail() {
        return this.mail;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forAll='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "phoneNumber"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forAll='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "phoneNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forAll='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "phoneNumber"
      )
    
    private String phoneNumber;

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

 
    @Column(name="phone_number" , length=10 )
      
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterFirstAddressKind'].test(_this.requesterFirstAddressKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"reservation"},
        message = "requesterFirstAddress"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterFirstAddressKind'].test(_this.requesterFirstAddressKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"reservation"},
        message = "requesterFirstAddress"
      )
    
    private String requesterFirstAddress;

    public void setRequesterFirstAddress(final String requesterFirstAddress) {
        this.requesterFirstAddress = requesterFirstAddress;
    }

 
    @Column(name="requester_first_address"  )
      
    public String getRequesterFirstAddress() {
        return this.requesterFirstAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "requesterFirstAddressKind"
      )
    
    private fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind;

    public void setRequesterFirstAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterFirstAddressKind) {
        this.requesterFirstAddressKind = requesterFirstAddressKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_first_address_kind"  )
      
    public fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterFirstAddressKind() {
        return this.requesterFirstAddressKind;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterOtherAddressKind'].test(_this.requesterOtherAddressKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"reservation"},
        message = "requesterOtherAddress"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterOtherAddressKind'].test(_this.requesterOtherAddressKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"reservation"},
        message = "requesterOtherAddress"
      )
    
    private String requesterOtherAddress;

    public void setRequesterOtherAddress(final String requesterOtherAddress) {
        this.requesterOtherAddress = requesterOtherAddress;
    }

 
    @Column(name="requester_other_address"  )
      
    public String getRequesterOtherAddress() {
        return this.requesterOtherAddress;
    }
  
    
    private fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind;

    public void setRequesterOtherAddressKind(final fr.cg95.cvq.business.request.urbanism.AccountAddressKindType requesterOtherAddressKind) {
        this.requesterOtherAddressKind = requesterOtherAddressKind;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_other_address_kind"  )
      
    public fr.cg95.cvq.business.request.urbanism.AccountAddressKindType getRequesterOtherAddressKind() {
        return this.requesterOtherAddressKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"requester"},
        message = "requesterType"
      )
    
    private fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType requesterType;

    public void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType requesterType) {
        this.requesterType = requesterType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_type"  )
      
    public fr.cg95.cvq.business.request.urbanism.LpsrrRequesterType getRequesterType() {
        return this.requesterType;
    }
  
    
      @NotNull(
        
        
        profiles = {"reservation"},
        message = "startDate"
      )
    
    private java.util.Date startDate;

    public void setStartDate(final java.util.Date startDate) {
        this.startDate = startDate;
    }

 
    @Column(name="start_date"  )
      
    public java.util.Date getStartDate() {
        return this.startDate;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['footWay'].test(_this.footWay.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"complement"},
        message = "vehiclesRegistration"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['footWay'].test(_this.footWay.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"complement"},
        message = "vehiclesRegistration"
      )
    
    private String vehiclesRegistration;

    public void setVehiclesRegistration(final String vehiclesRegistration) {
        this.vehiclesRegistration = vehiclesRegistration;
    }

 
    @Column(name="vehicles_registration"  )
      
    public String getVehiclesRegistration() {
        return this.vehiclesRegistration;
    }
  
}

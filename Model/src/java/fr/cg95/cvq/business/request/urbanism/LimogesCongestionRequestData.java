

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
@Table(name="limoges_congestion_request")
public class LimogesCongestionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LimogesCongestionRequestData() {
      
        lcrDuesAcceptance = Boolean.valueOf(false);
      
    }

    @Override
    public LimogesCongestionRequestData clone() {
        LimogesCongestionRequestData result = new LimogesCongestionRequestData();
        
          
            
        result.setAddress(address);
      
          
        
          
            
        result.setAutorizationNumber(autorizationNumber);
      
          
        
          
            
        if (civility != null)
            result.setCivility(civility);
        else
            result.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setCollectivityName(collectivityName);
      
          
        
          
            
        result.setContractorName(contractorName);
      
          
        
          
            
        result.setFaxNumber(faxNumber);
      
          
        
          
            
        result.setFirstName(firstName);
      
          
        
          
            
        result.setLastName(lastName);
      
          
        
          
            
        result.setLcrCompteDe(lcrCompteDe);
      
          
        
          
            
        List<fr.cg95.cvq.business.request.urbanism.LcrDescription> lcrDescriptionList = new ArrayList<fr.cg95.cvq.business.request.urbanism.LcrDescription>();
        for (LcrDescription object : lcrDescription) {
            lcrDescriptionList.add(object.clone());
        }
        result.setLcrDescription(lcrDescriptionList);
      
          
        
          
            
        result.setLcrDuesAcceptance(lcrDuesAcceptance);
      
          
        
          
            
        result.setLcrDuration(lcrDuration);
      
          
        
          
            
        result.setLcrEndWork(lcrEndWork);
      
          
        
          
            
        result.setLcrStartWork(lcrStartWork);
      
          
        
          
            
        result.setLcrWorkAddress(lcrWorkAddress);
      
          
        
          
            
        result.setLcrWorkNature(lcrWorkNature);
      
          
        
          
            
        result.setMail(mail);
      
          
        
          
            
        result.setPhoneNumber(phoneNumber);
      
          
        
          
            
        if (requesterType != null)
            result.setRequesterType(requesterType);
        else
            result.setRequesterType(fr.cg95.cvq.business.request.urbanism.LcrRequesterType.getDefaultLcrRequesterType());
      
          
        
          
            
        if (selectedRequestType != null)
            result.setSelectedRequestType(selectedRequestType);
        else
            result.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LcrRequestType.getDefaultLcrRequestType());
      
          
        
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
          
            "active &= _this.conditions['selectedRequestType'].test(_this.selectedRequestType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"work"},
        message = "autorizationNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['selectedRequestType'].test(_this.selectedRequestType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"work"},
        message = "autorizationNumber"
      )
    
    private String autorizationNumber;

    public void setAutorizationNumber(final String autorizationNumber) {
        this.autorizationNumber = autorizationNumber;
    }

 
    @Column(name="autorization_number"  )
      
    public String getAutorizationNumber() {
        return this.autorizationNumber;
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
          
            "active &= _this.conditions['requesterType'].test('isCollectivity='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "collectivityName"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('isCollectivity='+_this.requesterType.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"requester"},
        message = "collectivityName"
      )
    
    private String collectivityName;

    public void setCollectivityName(final String collectivityName) {
        this.collectivityName = collectivityName;
    }

 
    @Column(name="collectivity_name"  )
      
    public String getCollectivityName() {
        return this.collectivityName;
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
  
    
      @MaxLength(
        
          value = 10,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['requesterType'].test('forContractorCollectivity='+_this.requesterType.toString());" +
                
              
            
            
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
        
        
        profiles = {"work"},
        message = "lcrCompteDe"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrCompteDe"
      )
    
    private String lcrCompteDe;

    public void setLcrCompteDe(final String lcrCompteDe) {
        this.lcrCompteDe = lcrCompteDe;
    }

 
    @Column(name="lcr_compte_de"  )
      
    public String getLcrCompteDe() {
        return this.lcrCompteDe;
    }
  
    
      @AssertValid(
        
        
        profiles = {"work"},
        message = "lcrDescription"
      )
    
      @MinSize(
        
          value = 1,
        
        
        profiles = {"work"},
        message = "lcrDescription"
      )
    
    private List<fr.cg95.cvq.business.request.urbanism.LcrDescription> lcrDescription;

    public void setLcrDescription(final List<fr.cg95.cvq.business.request.urbanism.LcrDescription> lcrDescription) {
        this.lcrDescription = lcrDescription;
    }

 
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderColumn(name="lcr_description_index")
    @JoinColumn(name="limoges_congestion_request_id")
      
    public List<fr.cg95.cvq.business.request.urbanism.LcrDescription> getLcrDescription() {
        return this.lcrDescription;
    }
  
    
      @NotNull(
        
        
        profiles = {"rules"},
        message = "lcrDuesAcceptance"
      )
    
    private Boolean lcrDuesAcceptance;

    public void setLcrDuesAcceptance(final Boolean lcrDuesAcceptance) {
        this.lcrDuesAcceptance = lcrDuesAcceptance;
    }

 
    @Column(name="lcr_dues_acceptance"  )
      
    public Boolean getLcrDuesAcceptance() {
        return this.lcrDuesAcceptance;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrDuration"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrDuration"
      )
    
    private String lcrDuration;

    public void setLcrDuration(final String lcrDuration) {
        this.lcrDuration = lcrDuration;
    }

 
    @Column(name="lcr_duration"  )
      
    public String getLcrDuration() {
        return this.lcrDuration;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrEndWork"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrEndWork"
      )
    
    private String lcrEndWork;

    public void setLcrEndWork(final String lcrEndWork) {
        this.lcrEndWork = lcrEndWork;
    }

 
    @Column(name="lcr_end_work"  )
      
    public String getLcrEndWork() {
        return this.lcrEndWork;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrStartWork"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrStartWork"
      )
    
    private String lcrStartWork;

    public void setLcrStartWork(final String lcrStartWork) {
        this.lcrStartWork = lcrStartWork;
    }

 
    @Column(name="lcr_start_work"  )
      
    public String getLcrStartWork() {
        return this.lcrStartWork;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrWorkAddress"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrWorkAddress"
      )
    
    private String lcrWorkAddress;

    public void setLcrWorkAddress(final String lcrWorkAddress) {
        this.lcrWorkAddress = lcrWorkAddress;
    }

 
    @Column(name="lcr_work_address"  )
      
    public String getLcrWorkAddress() {
        return this.lcrWorkAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrWorkNature"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrWorkNature"
      )
    
    private String lcrWorkNature;

    public void setLcrWorkNature(final String lcrWorkNature) {
        this.lcrWorkNature = lcrWorkNature;
    }

 
    @Column(name="lcr_work_nature"  )
      
    public String getLcrWorkNature() {
        return this.lcrWorkNature;
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
        
        
        profiles = {"requester"},
        message = "requesterType"
      )
    
    private fr.cg95.cvq.business.request.urbanism.LcrRequesterType requesterType;

    public void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LcrRequesterType requesterType) {
        this.requesterType = requesterType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_type"  )
      
    public fr.cg95.cvq.business.request.urbanism.LcrRequesterType getRequesterType() {
        return this.requesterType;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "selectedRequestType"
      )
    
    private fr.cg95.cvq.business.request.urbanism.LcrRequestType selectedRequestType;

    public void setSelectedRequestType(final fr.cg95.cvq.business.request.urbanism.LcrRequestType selectedRequestType) {
        this.selectedRequestType = selectedRequestType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="selected_request_type"  )
      
    public fr.cg95.cvq.business.request.urbanism.LcrRequestType getSelectedRequestType() {
        return this.selectedRequestType;
    }
  
}

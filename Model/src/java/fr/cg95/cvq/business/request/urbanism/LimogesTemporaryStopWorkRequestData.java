

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
@Table(name="limoges_temporary_stop_work_request")
public class LimogesTemporaryStopWorkRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public LimogesTemporaryStopWorkRequestData() {
      
        ltswrRule = Boolean.valueOf(false);
      
    }

    @Override
    public LimogesTemporaryStopWorkRequestData clone() {
        LimogesTemporaryStopWorkRequestData result = new LimogesTemporaryStopWorkRequestData();
        
          
            
        result.setAddress(address);
      
          
        
          
            
        if (alternateTraffic != null)
            result.setAlternateTraffic(alternateTraffic);
        else
            result.setAlternateTraffic(fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic.getDefaultLtswrAlternateTraffic());
      
          
        
          
            
        result.setAlternateTrafficDirection(alternateTrafficDirection);
      
          
        
          
            
        result.setAlternateTrafficMeter(alternateTrafficMeter);
      
          
        
          
            
        result.setAutorizationNumber(autorizationNumber);
      
          
        
          
            
        if (civility != null)
            result.setCivility(civility);
        else
            result.setCivility(fr.cg95.cvq.business.users.TitleType.getDefaultTitleType());
      
          
        
          
            
        result.setCollectivityName(collectivityName);
      
          
        
          
            
        result.setComment(comment);
      
          
        
          
            
        result.setContractorName(contractorName);
      
          
        
          
            
        result.setDeviation(deviation);
      
          
        
          
            
        if (drivingBan != null)
            result.setDrivingBan(drivingBan);
        else
            result.setDrivingBan(fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan.getDefaultLtswrDrivingBan());
      
          
        
          
            
        result.setDrivingBanBetween(drivingBanBetween);
      
          
        
          
            
        result.setDrivingBanDirection(drivingBanDirection);
      
          
        
          
            
        result.setFaxNumber(faxNumber);
      
          
        
          
            
        result.setFirstName(firstName);
      
          
        
          
            
        result.setLastName(lastName);
      
          
        
          
            
        result.setLtswrRule(ltswrRule);
      
          
        
          
            
        result.setMail(mail);
      
          
        
          
            
        if (noParking != null)
            result.setNoParking(noParking);
        else
            result.setNoParking(fr.cg95.cvq.business.request.urbanism.LtswrNoParking.getDefaultLtswrNoParking());
      
          
        
          
            
        result.setNoParkingStraightMeter(noParkingStraightMeter);
      
          
        
          
            
        result.setNoParkingStraightNumber(noParkingStraightNumber);
      
          
        
          
            
        result.setOnBehalf(onBehalf);
      
          
        
          
            
        result.setPhoneNumber(phoneNumber);
      
          
        
          
            
        if (requesterType != null)
            result.setRequesterType(requesterType);
        else
            result.setRequesterType(fr.cg95.cvq.business.request.urbanism.LtswrRequesterType.getDefaultLtswrRequesterType());
      
          
        
          
            
        if (selectedRequestType != null)
            result.setSelectedRequestType(selectedRequestType);
        else
            result.setSelectedRequestType(fr.cg95.cvq.business.request.urbanism.LtswrRequestType.getDefaultLtswrRequestType());
      
          
        
          
            
        result.setWorkAddress(workAddress);
      
          
        
          
            
        result.setWorkDate(workDate);
      
          
        
          
            
        result.setWorkDuration(workDuration);
      
          
        
          
            
        result.setWorkTime(workTime);
      
          
        
          
            
        result.setWorkType(workType);
      
          
        
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
  
    
    private fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic alternateTraffic;

    public void setAlternateTraffic(final fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic alternateTraffic) {
        this.alternateTraffic = alternateTraffic;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="alternate_traffic"  )
      
    public fr.cg95.cvq.business.request.urbanism.LtswrAlternateTraffic getAlternateTraffic() {
        return this.alternateTraffic;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['alternateTraffic'].test('direction='+_this.alternateTraffic.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "alternateTrafficDirection"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['alternateTraffic'].test('direction='+_this.alternateTraffic.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "alternateTrafficDirection"
      )
    
    private String alternateTrafficDirection;

    public void setAlternateTrafficDirection(final String alternateTrafficDirection) {
        this.alternateTrafficDirection = alternateTrafficDirection;
    }

 
    @Column(name="alternate_traffic_direction"  )
      
    public String getAlternateTrafficDirection() {
        return this.alternateTrafficDirection;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['alternateTraffic'].test('alternate='+_this.alternateTraffic.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "alternateTrafficMeter"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['alternateTraffic'].test('alternate='+_this.alternateTraffic.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "alternateTrafficMeter"
      )
    
    private String alternateTrafficMeter;

    public void setAlternateTrafficMeter(final String alternateTrafficMeter) {
        this.alternateTrafficMeter = alternateTrafficMeter;
    }

 
    @Column(name="alternate_traffic_meter"  )
      
    public String getAlternateTrafficMeter() {
        return this.alternateTrafficMeter;
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
  
    
    private String comment;

    public void setComment(final String comment) {
        this.comment = comment;
    }

 
    @Column(name="comment"  )
      
    public String getComment() {
        return this.comment;
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('deviation='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "deviation"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('deviation='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "deviation"
      )
    
    private String deviation;

    public void setDeviation(final String deviation) {
        this.deviation = deviation;
    }

 
    @Column(name="deviation"  )
      
    public String getDeviation() {
        return this.deviation;
    }
  
    
    private fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan drivingBan;

    public void setDrivingBan(final fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan drivingBan) {
        this.drivingBan = drivingBan;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="driving_ban"  )
      
    public fr.cg95.cvq.business.request.urbanism.LtswrDrivingBan getDrivingBan() {
        return this.drivingBan;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('banBetween='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "drivingBanBetween"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('banBetween='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "drivingBanBetween"
      )
    
    private String drivingBanBetween;

    public void setDrivingBanBetween(final String drivingBanBetween) {
        this.drivingBanBetween = drivingBanBetween;
    }

 
    @Column(name="driving_ban_between"  )
      
    public String getDrivingBanBetween() {
        return this.drivingBanBetween;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('ban='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "drivingBanDirection"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['drivingBan'].test('ban='+_this.drivingBan.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "drivingBanDirection"
      )
    
    private String drivingBanDirection;

    public void setDrivingBanDirection(final String drivingBanDirection) {
        this.drivingBanDirection = drivingBanDirection;
    }

 
    @Column(name="driving_ban_direction"  )
      
    public String getDrivingBanDirection() {
        return this.drivingBanDirection;
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
        
        
        profiles = {"rules"},
        message = "ltswrRule"
      )
    
    private Boolean ltswrRule;

    public void setLtswrRule(final Boolean ltswrRule) {
        this.ltswrRule = ltswrRule;
    }

 
    @Column(name="ltswr_rule"  )
      
    public Boolean getLtswrRule() {
        return this.ltswrRule;
    }
  
    
    private String mail;

    public void setMail(final String mail) {
        this.mail = mail;
    }

 
    @Column(name="mail"  )
      
    public String getMail() {
        return this.mail;
    }
  
    
    private fr.cg95.cvq.business.request.urbanism.LtswrNoParking noParking;

    public void setNoParking(final fr.cg95.cvq.business.request.urbanism.LtswrNoParking noParking) {
        this.noParking = noParking;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="no_parking"  )
      
    public fr.cg95.cvq.business.request.urbanism.LtswrNoParking getNoParking() {
        return this.noParking;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['noParking'].test(_this.noParking.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "noParkingStraightMeter"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['noParking'].test(_this.noParking.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "noParkingStraightMeter"
      )
    
    private String noParkingStraightMeter;

    public void setNoParkingStraightMeter(final String noParkingStraightMeter) {
        this.noParkingStraightMeter = noParkingStraightMeter;
    }

 
    @Column(name="no_parking_straight_meter"  )
      
    public String getNoParkingStraightMeter() {
        return this.noParkingStraightMeter;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['noParking'].test(_this.noParking.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "noParkingStraightNumber"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['noParking'].test(_this.noParking.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"informations"},
        message = "noParkingStraightNumber"
      )
    
    private String noParkingStraightNumber;

    public void setNoParkingStraightNumber(final String noParkingStraightNumber) {
        this.noParkingStraightNumber = noParkingStraightNumber;
    }

 
    @Column(name="no_parking_straight_number"  )
      
    public String getNoParkingStraightNumber() {
        return this.noParkingStraightNumber;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "onBehalf"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "onBehalf"
      )
    
    private String onBehalf;

    public void setOnBehalf(final String onBehalf) {
        this.onBehalf = onBehalf;
    }

 
    @Column(name="on_behalf"  )
      
    public String getOnBehalf() {
        return this.onBehalf;
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
    
    private fr.cg95.cvq.business.request.urbanism.LtswrRequesterType requesterType;

    public void setRequesterType(final fr.cg95.cvq.business.request.urbanism.LtswrRequesterType requesterType) {
        this.requesterType = requesterType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="requester_type"  )
      
    public fr.cg95.cvq.business.request.urbanism.LtswrRequesterType getRequesterType() {
        return this.requesterType;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "selectedRequestType"
      )
    
    private fr.cg95.cvq.business.request.urbanism.LtswrRequestType selectedRequestType;

    public void setSelectedRequestType(final fr.cg95.cvq.business.request.urbanism.LtswrRequestType selectedRequestType) {
        this.selectedRequestType = selectedRequestType;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="selected_request_type"  )
      
    public fr.cg95.cvq.business.request.urbanism.LtswrRequestType getSelectedRequestType() {
        return this.selectedRequestType;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "workAddress"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "workAddress"
      )
    
    private String workAddress;

    public void setWorkAddress(final String workAddress) {
        this.workAddress = workAddress;
    }

 
    @Column(name="work_address"  )
      
    public String getWorkAddress() {
        return this.workAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "workDate"
      )
    
    private java.util.Date workDate;

    public void setWorkDate(final java.util.Date workDate) {
        this.workDate = workDate;
    }

 
    @Column(name="work_date"  )
      
    public java.util.Date getWorkDate() {
        return this.workDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "workDuration"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "workDuration"
      )
    
    private String workDuration;

    public void setWorkDuration(final String workDuration) {
        this.workDuration = workDuration;
    }

 
    @Column(name="work_duration"  )
      
    public String getWorkDuration() {
        return this.workDuration;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "workTime"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "workTime"
      )
    
    private String workTime;

    public void setWorkTime(final String workTime) {
        this.workTime = workTime;
    }

 
    @Column(name="work_time"  )
      
    public String getWorkTime() {
        return this.workTime;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "workType"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "workType"
      )
    
    private String workType;

    public void setWorkType(final String workType) {
        this.workType = workType;
    }

 
    @Column(name="work_type"  )
      
    public String getWorkType() {
        return this.workType;
    }
  
}

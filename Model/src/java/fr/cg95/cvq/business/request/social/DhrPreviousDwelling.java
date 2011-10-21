
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="dhr_previous_dwelling")
public class DhrPreviousDwelling implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        DomesticHelpRequest.conditions;

    public DhrPreviousDwelling() {
        super();
      
    }

    public final String modelToXmlString() {
        DhrPreviousDwellingType object = (DhrPreviousDwellingType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final DhrPreviousDwellingType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        DhrPreviousDwellingType dhrPreviousDwelling = DhrPreviousDwellingType.Factory.newInstance();
        int i = 0;
    
        if (this.dhrPreviousDwellingStatus != null)
            dhrPreviousDwelling.setDhrPreviousDwellingStatus(fr.cg95.cvq.xml.request.social.DhrDwellingStatusType.Enum.forString(this.dhrPreviousDwellingStatus.toString()));
      
        if (this.dhrPreviousDwellingKind != null)
            dhrPreviousDwelling.setDhrPreviousDwellingKind(fr.cg95.cvq.xml.request.social.DhrDwellingKindType.Enum.forString(this.dhrPreviousDwellingKind.toString()));
      
        dhrPreviousDwelling.setDhrPreviousDwellingComment(this.dhrPreviousDwellingComment);
      
        date = this.dhrPreviousDwellingDepartureDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwelling.setDhrPreviousDwellingDepartureDate(calendar);
        }
      
        if (this.dhrPreviousDwellingAddress != null)
            dhrPreviousDwelling.setDhrPreviousDwellingAddress(Address.modelToXml(this.dhrPreviousDwellingAddress));
      
        date = this.dhrPreviousDwellingArrivalDate;
        if (date != null) {
            calendar.setTime(date);
            dhrPreviousDwelling.setDhrPreviousDwellingArrivalDate(calendar);
        }
      
        return dhrPreviousDwelling;
    }

    public static DhrPreviousDwelling xmlToModel(DhrPreviousDwellingType dhrPreviousDwellingDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        DhrPreviousDwelling dhrPreviousDwelling = new DhrPreviousDwelling();
    
        if (dhrPreviousDwellingDoc.getDhrPreviousDwellingStatus() != null)
            dhrPreviousDwelling.setDhrPreviousDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.forString(dhrPreviousDwellingDoc.getDhrPreviousDwellingStatus().toString()));
        else
            dhrPreviousDwelling.setDhrPreviousDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.getDefaultDhrDwellingStatusType());
      
        if (dhrPreviousDwellingDoc.getDhrPreviousDwellingKind() != null)
            dhrPreviousDwelling.setDhrPreviousDwellingKind(fr.cg95.cvq.business.request.social.DhrDwellingKindType.forString(dhrPreviousDwellingDoc.getDhrPreviousDwellingKind().toString()));
        else
            dhrPreviousDwelling.setDhrPreviousDwellingKind(fr.cg95.cvq.business.request.social.DhrDwellingKindType.getDefaultDhrDwellingKindType());
      
        dhrPreviousDwelling.setDhrPreviousDwellingComment(dhrPreviousDwellingDoc.getDhrPreviousDwellingComment());
      
        calendar = dhrPreviousDwellingDoc.getDhrPreviousDwellingDepartureDate();
        if (calendar != null) {
            dhrPreviousDwelling.setDhrPreviousDwellingDepartureDate(calendar.getTime());
        }
      
        if (dhrPreviousDwellingDoc.getDhrPreviousDwellingAddress() != null)
            dhrPreviousDwelling.setDhrPreviousDwellingAddress(Address.xmlToModel(dhrPreviousDwellingDoc.getDhrPreviousDwellingAddress()));
      
        calendar = dhrPreviousDwellingDoc.getDhrPreviousDwellingArrivalDate();
        if (calendar != null) {
            dhrPreviousDwelling.setDhrPreviousDwellingArrivalDate(calendar.getTime());
        }
      
        return dhrPreviousDwelling;
    }

    @Override
    public DhrPreviousDwelling clone() {
        DhrPreviousDwelling result = new DhrPreviousDwelling();
        
          
            
        if (dhrPreviousDwellingStatus != null)
            result.setDhrPreviousDwellingStatus(dhrPreviousDwellingStatus);
        else
            result.setDhrPreviousDwellingStatus(fr.cg95.cvq.business.request.social.DhrDwellingStatusType.getDefaultDhrDwellingStatusType());
      
          
        
          
            
        if (dhrPreviousDwellingKind != null)
            result.setDhrPreviousDwellingKind(dhrPreviousDwellingKind);
        else
            result.setDhrPreviousDwellingKind(fr.cg95.cvq.business.request.social.DhrDwellingKindType.getDefaultDhrDwellingKindType());
      
          
        
          
            
        result.setDhrPreviousDwellingComment(dhrPreviousDwellingComment);
      
          
        
          
            
        result.setDhrPreviousDwellingDepartureDate(dhrPreviousDwellingDepartureDate);
      
          
        
          
            
        if (dhrPreviousDwellingAddress != null)
            result.setDhrPreviousDwellingAddress(dhrPreviousDwellingAddress.clone());
      
          
        
          
            
        result.setDhrPreviousDwellingArrivalDate(dhrPreviousDwellingArrivalDate);
      
          
        
        return result;
    }

    private Long id;

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
          
            "active &= _this.conditions['dhrPreviousDwelling.dhrPreviousDwellingKind'].test(_this.dhrPreviousDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingStatus"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrPreviousDwellingStatus;

    public void setDhrPreviousDwellingStatus(final fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrPreviousDwellingStatus) {
        this.dhrPreviousDwellingStatus = dhrPreviousDwellingStatus;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="dhr_previous_dwelling_status"  )
      
    public fr.cg95.cvq.business.request.social.DhrDwellingStatusType getDhrPreviousDwellingStatus() {
        return this.dhrPreviousDwellingStatus;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingKind"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrPreviousDwellingKind;

    public void setDhrPreviousDwellingKind(final fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrPreviousDwellingKind) {
        this.dhrPreviousDwellingKind = dhrPreviousDwellingKind;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="dhr_previous_dwelling_kind"  )
      
    public fr.cg95.cvq.business.request.social.DhrDwellingKindType getDhrPreviousDwellingKind() {
        return this.dhrPreviousDwellingKind;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingComment"
      )
    
      @NotBlank(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingComment"
      )
    
    private String dhrPreviousDwellingComment;

    public void setDhrPreviousDwellingComment(final String dhrPreviousDwellingComment) {
        this.dhrPreviousDwellingComment = dhrPreviousDwellingComment;
    }


    @Column(name="dhr_previous_dwelling_comment"  )
      
    public String getDhrPreviousDwellingComment() {
        return this.dhrPreviousDwellingComment;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingDepartureDate"
      )
    
    private java.util.Date dhrPreviousDwellingDepartureDate;

    public void setDhrPreviousDwellingDepartureDate(final java.util.Date dhrPreviousDwellingDepartureDate) {
        this.dhrPreviousDwellingDepartureDate = dhrPreviousDwellingDepartureDate;
    }


    @Column(name="dhr_previous_dwelling_departure_date"  )
      
    public java.util.Date getDhrPreviousDwellingDepartureDate() {
        return this.dhrPreviousDwellingDepartureDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingAddress"
      )
    
      @AssertValid(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingAddress"
      )
    
    private fr.cg95.cvq.business.users.Address dhrPreviousDwellingAddress;

    public void setDhrPreviousDwellingAddress(final fr.cg95.cvq.business.users.Address dhrPreviousDwellingAddress) {
        this.dhrPreviousDwellingAddress = dhrPreviousDwellingAddress;
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="dhr_previous_dwelling_address_id")
      
    public fr.cg95.cvq.business.users.Address getDhrPreviousDwellingAddress() {
        return this.dhrPreviousDwellingAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingArrivalDate"
      )
    
    private java.util.Date dhrPreviousDwellingArrivalDate;

    public void setDhrPreviousDwellingArrivalDate(final java.util.Date dhrPreviousDwellingArrivalDate) {
        this.dhrPreviousDwellingArrivalDate = dhrPreviousDwellingArrivalDate;
    }


    @Column(name="dhr_previous_dwelling_arrival_date"  )
      
    public java.util.Date getDhrPreviousDwellingArrivalDate() {
        return this.dhrPreviousDwellingArrivalDate;
    }
  
}

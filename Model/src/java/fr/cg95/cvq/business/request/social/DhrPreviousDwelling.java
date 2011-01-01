
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
 *  table="dhr_previous_dwelling"
 *  lazy="false"
 */
public class DhrPreviousDwelling implements Serializable {

    private static final long serialVersionUID = 1L;

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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['dhrPreviousDwelling.dhrPreviousDwellingKind'].test(_this.dhrPreviousDwellingKind.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingStatus"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrPreviousDwellingStatus;

    public final void setDhrPreviousDwellingStatus(final fr.cg95.cvq.business.request.social.DhrDwellingStatusType dhrPreviousDwellingStatus) {
        this.dhrPreviousDwellingStatus = dhrPreviousDwellingStatus;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_previous_dwelling_status"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingStatusType getDhrPreviousDwellingStatus() {
        return this.dhrPreviousDwellingStatus;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingKind"
      )
    
    private fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrPreviousDwellingKind;

    public final void setDhrPreviousDwellingKind(final fr.cg95.cvq.business.request.social.DhrDwellingKindType dhrPreviousDwellingKind) {
        this.dhrPreviousDwellingKind = dhrPreviousDwellingKind;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_previous_dwelling_kind"
        
      
    */
    public final fr.cg95.cvq.business.request.social.DhrDwellingKindType getDhrPreviousDwellingKind() {
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

    public final void setDhrPreviousDwellingComment(final String dhrPreviousDwellingComment) {
        this.dhrPreviousDwellingComment = dhrPreviousDwellingComment;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_previous_dwelling_comment"
        
      
    */
    public final String getDhrPreviousDwellingComment() {
        return this.dhrPreviousDwellingComment;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingDepartureDate"
      )
    
    private java.util.Date dhrPreviousDwellingDepartureDate;

    public final void setDhrPreviousDwellingDepartureDate(final java.util.Date dhrPreviousDwellingDepartureDate) {
        this.dhrPreviousDwellingDepartureDate = dhrPreviousDwellingDepartureDate;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_previous_dwelling_departure_date"
        
      
    */
    public final java.util.Date getDhrPreviousDwellingDepartureDate() {
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

    public final void setDhrPreviousDwellingAddress(final fr.cg95.cvq.business.users.Address dhrPreviousDwellingAddress) {
        this.dhrPreviousDwellingAddress = dhrPreviousDwellingAddress;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="dhr_previous_dwelling_address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getDhrPreviousDwellingAddress() {
        return this.dhrPreviousDwellingAddress;
    }
  
    
      @NotNull(
        
        
        profiles = {"dwelling"},
        message = "dhrPreviousDwellingArrivalDate"
      )
    
    private java.util.Date dhrPreviousDwellingArrivalDate;

    public final void setDhrPreviousDwellingArrivalDate(final java.util.Date dhrPreviousDwellingArrivalDate) {
        this.dhrPreviousDwellingArrivalDate = dhrPreviousDwellingArrivalDate;
    }

    /**
  
        * @hibernate.property
        *  column="dhr_previous_dwelling_arrival_date"
        
      
    */
    public final java.util.Date getDhrPreviousDwellingArrivalDate() {
        return this.dhrPreviousDwellingArrivalDate;
    }
  
}

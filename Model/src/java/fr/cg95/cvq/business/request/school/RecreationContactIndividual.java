
package fr.cg95.cvq.business.request.school;

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
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="recreation_contact_individual")
public class RecreationContactIndividual implements Serializable {

    private static final long serialVersionUID = 1L;

    public RecreationContactIndividual() {
        super();
      
    }

    public final String modelToXmlString() {
        RecreationContactIndividualType object = (RecreationContactIndividualType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final RecreationContactIndividualType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        RecreationContactIndividualType recreationContactIndividual = RecreationContactIndividualType.Factory.newInstance();
        int i = 0;
    
        recreationContactIndividual.setOfficePhone(this.officePhone);
      
        if (this.address != null)
            recreationContactIndividual.setAddress(Address.modelToXml(this.address));
      
        recreationContactIndividual.setFirstName(this.firstName);
      
        recreationContactIndividual.setLastName(this.lastName);
      
        recreationContactIndividual.setHomePhone(this.homePhone);
      
        return recreationContactIndividual;
    }

    public static RecreationContactIndividual xmlToModel(RecreationContactIndividualType recreationContactIndividualDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        RecreationContactIndividual recreationContactIndividual = new RecreationContactIndividual();
    
        recreationContactIndividual.setOfficePhone(recreationContactIndividualDoc.getOfficePhone());
      
        if (recreationContactIndividualDoc.getAddress() != null)
            recreationContactIndividual.setAddress(Address.xmlToModel(recreationContactIndividualDoc.getAddress()));
      
        recreationContactIndividual.setFirstName(recreationContactIndividualDoc.getFirstName());
      
        recreationContactIndividual.setLastName(recreationContactIndividualDoc.getLastName());
      
        recreationContactIndividual.setHomePhone(recreationContactIndividualDoc.getHomePhone());
      
        return recreationContactIndividual;
    }

    @Override
    public RecreationContactIndividual clone() {
        RecreationContactIndividual result = new RecreationContactIndividual();
        
          
            
        result.setOfficePhone(officePhone);
      
          
        
          
            
        if (address != null)
            result.setAddress(address.clone());
      
          
        
          
            
        result.setFirstName(firstName);
      
          
        
          
            
        result.setLastName(lastName);
      
          
        
          
            
        result.setHomePhone(homePhone);
      
          
        
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

  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"contact"},
        message = "officePhone"
      )
    
    private String officePhone;

    public void setOfficePhone(final String officePhone) {
        this.officePhone = officePhone;
    }


    @Column(name="office_phone" , length=10 )
      
    public String getOfficePhone() {
        return this.officePhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"contact"},
        message = "address"
      )
    
      @AssertValid(
        
        
        profiles = {"contact"},
        message = "address"
      )
    
    private fr.cg95.cvq.business.users.Address address;

    public void setAddress(final fr.cg95.cvq.business.users.Address address) {
        this.address = address;
    }


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
      
    public fr.cg95.cvq.business.users.Address getAddress() {
        return this.address;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"contact"},
        message = "firstName"
      )
    
      @NotNull(
        
        
        profiles = {"contact"},
        message = "firstName"
      )
    
      @NotBlank(
        
        
        profiles = {"contact"},
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
        
        
        profiles = {"contact"},
        message = "lastName"
      )
    
      @NotNull(
        
        
        profiles = {"contact"},
        message = "lastName"
      )
    
      @NotBlank(
        
        
        profiles = {"contact"},
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
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"contact"},
        message = "homePhone"
      )
    
    private String homePhone;

    public void setHomePhone(final String homePhone) {
        this.homePhone = homePhone;
    }


    @Column(name="home_phone" , length=10 )
      
    public String getHomePhone() {
        return this.homePhone;
    }
  
}

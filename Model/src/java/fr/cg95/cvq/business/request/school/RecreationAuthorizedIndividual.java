
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

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="recreation_authorized_individual"
 *  lazy="false"
 */
public class RecreationAuthorizedIndividual implements Serializable {

    private static final long serialVersionUID = 1L;

    public RecreationAuthorizedIndividual() {
        super();
      
    }

    public final String modelToXmlString() {
        RecreationAuthorizedIndividualType object = (RecreationAuthorizedIndividualType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final RecreationAuthorizedIndividualType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        RecreationAuthorizedIndividualType recreationAuthorizedIndividual = RecreationAuthorizedIndividualType.Factory.newInstance();
        int i = 0;
    
        recreationAuthorizedIndividual.setOfficePhone(this.officePhone);
      
        if (this.address != null)
            recreationAuthorizedIndividual.setAddress(Address.modelToXml(this.address));
      
        recreationAuthorizedIndividual.setFirstName(this.firstName);
      
        recreationAuthorizedIndividual.setLastName(this.lastName);
      
        recreationAuthorizedIndividual.setHomePhone(this.homePhone);
      
        return recreationAuthorizedIndividual;
    }

    public static RecreationAuthorizedIndividual xmlToModel(RecreationAuthorizedIndividualType recreationAuthorizedIndividualDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        RecreationAuthorizedIndividual recreationAuthorizedIndividual = new RecreationAuthorizedIndividual();
    
        recreationAuthorizedIndividual.setOfficePhone(recreationAuthorizedIndividualDoc.getOfficePhone());
      
        if (recreationAuthorizedIndividualDoc.getAddress() != null)
            recreationAuthorizedIndividual.setAddress(Address.xmlToModel(recreationAuthorizedIndividualDoc.getAddress()));
      
        recreationAuthorizedIndividual.setFirstName(recreationAuthorizedIndividualDoc.getFirstName());
      
        recreationAuthorizedIndividual.setLastName(recreationAuthorizedIndividualDoc.getLastName());
      
        recreationAuthorizedIndividual.setHomePhone(recreationAuthorizedIndividualDoc.getHomePhone());
      
        return recreationAuthorizedIndividual;
    }

    @Override
    public RecreationAuthorizedIndividual clone() {
        RecreationAuthorizedIndividual result = new RecreationAuthorizedIndividual();
        
          
            
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

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"authorization"},
        message = "officePhone"
      )
    
    private String officePhone;

    public final void setOfficePhone(final String officePhone) {
        this.officePhone = officePhone;
    }

    /**
  
        * @hibernate.property
        *  column="office_phone"
        *  length="10"
      
    */
    public final String getOfficePhone() {
        return this.officePhone;
    }
  
    
      @NotNull(
        
        
        profiles = {"authorization"},
        message = "address"
      )
    
      @AssertValid(
        
        
        profiles = {"authorization"},
        message = "address"
      )
    
    private fr.cg95.cvq.business.users.Address address;

    public final void setAddress(final fr.cg95.cvq.business.users.Address address) {
        this.address = address;
    }

    /**
  
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="address_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getAddress() {
        return this.address;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"authorization"},
        message = "firstName"
      )
    
      @NotNull(
        
        
        profiles = {"authorization"},
        message = "firstName"
      )
    
      @NotBlank(
        
        
        profiles = {"authorization"},
        message = "firstName"
      )
    
    private String firstName;

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
  
        * @hibernate.property
        *  column="first_name"
        *  length="38"
      
    */
    public final String getFirstName() {
        return this.firstName;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"authorization"},
        message = "lastName"
      )
    
      @NotNull(
        
        
        profiles = {"authorization"},
        message = "lastName"
      )
    
      @NotBlank(
        
        
        profiles = {"authorization"},
        message = "lastName"
      )
    
    private String lastName;

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
  
        * @hibernate.property
        *  column="last_name"
        *  length="38"
      
    */
    public final String getLastName() {
        return this.lastName;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"authorization"},
        message = "homePhone"
      )
    
    private String homePhone;

    public final void setHomePhone(final String homePhone) {
        this.homePhone = homePhone;
    }

    /**
  
        * @hibernate.property
        *  column="home_phone"
        *  length="10"
      
    */
    public final String getHomePhone() {
        return this.homePhone;
    }
  
}

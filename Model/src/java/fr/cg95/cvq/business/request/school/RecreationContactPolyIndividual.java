
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
 *  table="recreation_contact_poly_individual"
 *  lazy="false"
 */
public class RecreationContactPolyIndividual implements Serializable {

    private static final long serialVersionUID = 1L;

    public RecreationContactPolyIndividual() {
        super();
      
    }

    public final String modelToXmlString() {
        RecreationContactPolyIndividualType object = (RecreationContactPolyIndividualType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final RecreationContactPolyIndividualType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        RecreationContactPolyIndividualType recreationContactPolyIndividual = RecreationContactPolyIndividualType.Factory.newInstance();
        int i = 0;
    
        recreationContactPolyIndividual.setOfficePhone(this.officePhone);
      
        if (this.address != null)
            recreationContactPolyIndividual.setAddress(Address.modelToXml(this.address));
      
        recreationContactPolyIndividual.setFirstName(this.firstName);
      
        recreationContactPolyIndividual.setLastName(this.lastName);
      
        recreationContactPolyIndividual.setHomePhone(this.homePhone);
      
        return recreationContactPolyIndividual;
    }

    public static RecreationContactPolyIndividual xmlToModel(RecreationContactPolyIndividualType recreationContactPolyIndividualDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        RecreationContactPolyIndividual recreationContactPolyIndividual = new RecreationContactPolyIndividual();
    
        recreationContactPolyIndividual.setOfficePhone(recreationContactPolyIndividualDoc.getOfficePhone());
      
        if (recreationContactPolyIndividualDoc.getAddress() != null)
            recreationContactPolyIndividual.setAddress(Address.xmlToModel(recreationContactPolyIndividualDoc.getAddress()));
      
        recreationContactPolyIndividual.setFirstName(recreationContactPolyIndividualDoc.getFirstName());
      
        recreationContactPolyIndividual.setLastName(recreationContactPolyIndividualDoc.getLastName());
      
        recreationContactPolyIndividual.setHomePhone(recreationContactPolyIndividualDoc.getHomePhone());
      
        return recreationContactPolyIndividual;
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
        
        
        profiles = {"contact"},
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
        
        
        profiles = {"contact"},
        message = "address"
      )
    
      @AssertValid(
        
        
        profiles = {"contact"},
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
        
        
        profiles = {"contact"},
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

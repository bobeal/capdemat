
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
 *  table="perischool_authorized_individual"
 *  lazy="false"
 */
public class PerischoolAuthorizedIndividual implements Serializable {

    private static final long serialVersionUID = 1L;

    public PerischoolAuthorizedIndividual() {
        super();
      
    }

    public final String modelToXmlString() {
        PerischoolAuthorizedIndividualType object = (PerischoolAuthorizedIndividualType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final PerischoolAuthorizedIndividualType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        PerischoolAuthorizedIndividualType perischoolAuthorizedIndividual = PerischoolAuthorizedIndividualType.Factory.newInstance();
        int i = 0;
    
        perischoolAuthorizedIndividual.setOfficePhone(this.officePhone);
      
        if (this.address != null)
            perischoolAuthorizedIndividual.setAddress(Address.modelToXml(this.address));
      
        perischoolAuthorizedIndividual.setFirstName(this.firstName);
      
        perischoolAuthorizedIndividual.setLastName(this.lastName);
      
        perischoolAuthorizedIndividual.setHomePhone(this.homePhone);
      
        return perischoolAuthorizedIndividual;
    }

    public static PerischoolAuthorizedIndividual xmlToModel(PerischoolAuthorizedIndividualType perischoolAuthorizedIndividualDoc) {
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        PerischoolAuthorizedIndividual perischoolAuthorizedIndividual = new PerischoolAuthorizedIndividual();
    
        perischoolAuthorizedIndividual.setOfficePhone(perischoolAuthorizedIndividualDoc.getOfficePhone());
      
        if (perischoolAuthorizedIndividualDoc.getAddress() != null)
            perischoolAuthorizedIndividual.setAddress(Address.xmlToModel(perischoolAuthorizedIndividualDoc.getAddress()));
      
        perischoolAuthorizedIndividual.setFirstName(perischoolAuthorizedIndividualDoc.getFirstName());
      
        perischoolAuthorizedIndividual.setLastName(perischoolAuthorizedIndividualDoc.getLastName());
      
        perischoolAuthorizedIndividual.setHomePhone(perischoolAuthorizedIndividualDoc.getHomePhone());
      
        return perischoolAuthorizedIndividual;
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

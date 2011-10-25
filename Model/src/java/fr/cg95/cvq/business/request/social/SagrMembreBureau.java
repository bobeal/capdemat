
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
@Table(name="sagr_membre_bureau")
public class SagrMembreBureau implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        SportsAssociationsGrantRequest.conditions;

    public SagrMembreBureau() {
        super();
      
    }

    public final String modelToXmlString() {
        SagrMembreBureauType object = (SagrMembreBureauType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final SagrMembreBureauType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        SagrMembreBureauType sagrMembreBureau = SagrMembreBureauType.Factory.newInstance();
        int i = 0;
    
        sagrMembreBureau.setPrenomMembre(this.prenomMembre);
      
        sagrMembreBureau.setNomMembre(this.nomMembre);
      
        sagrMembreBureau.setEmailMembre(this.emailMembre);
      
        if (this.roleMembre != null)
            sagrMembreBureau.setRoleMembre(fr.cg95.cvq.xml.request.social.SagrRoleAutreMembreAssociationType.Enum.forString(this.roleMembre.toString()));
      
        sagrMembreBureau.setTelephoneMembre(this.telephoneMembre);
      
        return sagrMembreBureau;
    }

    public static SagrMembreBureau xmlToModel(SagrMembreBureauType sagrMembreBureauDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SagrMembreBureau sagrMembreBureau = new SagrMembreBureau();
    
        sagrMembreBureau.setPrenomMembre(sagrMembreBureauDoc.getPrenomMembre());
      
        sagrMembreBureau.setNomMembre(sagrMembreBureauDoc.getNomMembre());
      
        sagrMembreBureau.setEmailMembre(sagrMembreBureauDoc.getEmailMembre());
      
        if (sagrMembreBureauDoc.getRoleMembre() != null)
            sagrMembreBureau.setRoleMembre(fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType.forString(sagrMembreBureauDoc.getRoleMembre().toString()));
        else
            sagrMembreBureau.setRoleMembre(fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType.getDefaultSagrRoleAutreMembreAssociationType());
      
        sagrMembreBureau.setTelephoneMembre(sagrMembreBureauDoc.getTelephoneMembre());
      
        return sagrMembreBureau;
    }

    @Override
    public SagrMembreBureau clone() {
        SagrMembreBureau result = new SagrMembreBureau();
        
          
            
        result.setPrenomMembre(prenomMembre);
      
          
        
          
            
        result.setNomMembre(nomMembre);
      
          
        
          
            
        result.setEmailMembre(emailMembre);
      
          
        
          
            
        if (roleMembre != null)
            result.setRoleMembre(roleMembre);
        else
            result.setRoleMembre(fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType.getDefaultSagrRoleAutreMembreAssociationType());
      
          
        
          
            
        result.setTelephoneMembre(telephoneMembre);
      
          
        
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
        
          value = 38,
        
        
        profiles = {"bureau"},
        message = "prenomMembre"
      )
    
      @NotNull(
        
        
        profiles = {"bureau"},
        message = "prenomMembre"
      )
    
      @NotBlank(
        
        
        profiles = {"bureau"},
        message = "prenomMembre"
      )
    
    private String prenomMembre;

    public void setPrenomMembre(final String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }


    @Column(name="prenom_membre" , length=38 )
      
    public String getPrenomMembre() {
        return this.prenomMembre;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"bureau"},
        message = "nomMembre"
      )
    
      @NotNull(
        
        
        profiles = {"bureau"},
        message = "nomMembre"
      )
    
      @NotBlank(
        
        
        profiles = {"bureau"},
        message = "nomMembre"
      )
    
    private String nomMembre;

    public void setNomMembre(final String nomMembre) {
        this.nomMembre = nomMembre;
    }


    @Column(name="nom_membre" , length=38 )
      
    public String getNomMembre() {
        return this.nomMembre;
    }
  
    
    private String emailMembre;

    public void setEmailMembre(final String emailMembre) {
        this.emailMembre = emailMembre;
    }


    @Column(name="email_membre"  )
      
    public String getEmailMembre() {
        return this.emailMembre;
    }
  
    
      @NotNull(
        
        
        profiles = {"bureau"},
        message = "roleMembre"
      )
    
    private fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType roleMembre;

    public void setRoleMembre(final fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType roleMembre) {
        this.roleMembre = roleMembre;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="role_membre"  )
      
    public fr.cg95.cvq.business.request.social.SagrRoleAutreMembreAssociationType getRoleMembre() {
        return this.roleMembre;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"bureau"},
        message = "telephoneMembre"
      )
    
    private String telephoneMembre;

    public void setTelephoneMembre(final String telephoneMembre) {
        this.telephoneMembre = telephoneMembre;
    }


    @Column(name="telephone_membre" , length=10 )
      
    public String getTelephoneMembre() {
        return this.telephoneMembre;
    }
  
}

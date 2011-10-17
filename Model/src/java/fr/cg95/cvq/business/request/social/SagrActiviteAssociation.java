
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
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="sagr_activite_association")
public class SagrActiviteAssociation implements Serializable {

    private static final long serialVersionUID = 1L;

    public SagrActiviteAssociation() {
        super();
      
    }

    public final String modelToXmlString() {
        SagrActiviteAssociationType object = (SagrActiviteAssociationType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final SagrActiviteAssociationType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        SagrActiviteAssociationType sagrActiviteAssociation = SagrActiviteAssociationType.Factory.newInstance();
        int i = 0;
    
        sagrActiviteAssociation.setNumeroAffiliationActivite(this.numeroAffiliationActivite);
      
        if (this.nombreLicencieMajeurActivite != null)
            sagrActiviteAssociation.setNombreLicencieMajeurActivite(this.nombreLicencieMajeurActivite.longValue());
      
        if (this.totalLicencieActivite != null)
            sagrActiviteAssociation.setTotalLicencieActivite(this.totalLicencieActivite.longValue());
      
        sagrActiviteAssociation.setSommeAlloueeActivite(this.sommeAlloueeActivite);
      
        sagrActiviteAssociation.setNomFederationSportiveActivite(this.nomFederationSportiveActivite);
      
        sagrActiviteAssociation.setNomActivite(this.nomActivite);
      
        if (this.nombreLicencieMineurActivite != null)
            sagrActiviteAssociation.setNombreLicencieMineurActivite(this.nombreLicencieMineurActivite.longValue());
      
        return sagrActiviteAssociation;
    }

    public static SagrActiviteAssociation xmlToModel(SagrActiviteAssociationType sagrActiviteAssociationDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SagrActiviteAssociation sagrActiviteAssociation = new SagrActiviteAssociation();
    
        sagrActiviteAssociation.setNumeroAffiliationActivite(sagrActiviteAssociationDoc.getNumeroAffiliationActivite());
      
        if (sagrActiviteAssociationDoc.getNombreLicencieMajeurActivite() != 0)
            sagrActiviteAssociation.setNombreLicencieMajeurActivite(new Long(sagrActiviteAssociationDoc.getNombreLicencieMajeurActivite()));
      
        if (sagrActiviteAssociationDoc.getTotalLicencieActivite() != 0)
            sagrActiviteAssociation.setTotalLicencieActivite(new Long(sagrActiviteAssociationDoc.getTotalLicencieActivite()));
      
        sagrActiviteAssociation.setSommeAlloueeActivite(sagrActiviteAssociationDoc.getSommeAlloueeActivite());
      
        sagrActiviteAssociation.setNomFederationSportiveActivite(sagrActiviteAssociationDoc.getNomFederationSportiveActivite());
      
        sagrActiviteAssociation.setNomActivite(sagrActiviteAssociationDoc.getNomActivite());
      
        if (sagrActiviteAssociationDoc.getNombreLicencieMineurActivite() != 0)
            sagrActiviteAssociation.setNombreLicencieMineurActivite(new Long(sagrActiviteAssociationDoc.getNombreLicencieMineurActivite()));
      
        return sagrActiviteAssociation;
    }

    @Override
    public SagrActiviteAssociation clone() {
        SagrActiviteAssociation result = new SagrActiviteAssociation();
        
          
            
        result.setNumeroAffiliationActivite(numeroAffiliationActivite);
      
          
        
          
            
        result.setNombreLicencieMajeurActivite(nombreLicencieMajeurActivite);
      
          
        
          
            
        result.setTotalLicencieActivite(totalLicencieActivite);
      
          
        
          
            
        result.setSommeAlloueeActivite(sommeAlloueeActivite);
      
          
        
          
            
        result.setNomFederationSportiveActivite(nomFederationSportiveActivite);
      
          
        
          
            
        result.setNomActivite(nomActivite);
      
          
        
          
            
        result.setNombreLicencieMineurActivite(nombreLicencieMineurActivite);
      
          
        
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
        
        
        profiles = {"activites"},
        message = "numeroAffiliationActivite"
      )
    
      @NotBlank(
        
        
        profiles = {"activites"},
        message = "numeroAffiliationActivite"
      )
    
    private String numeroAffiliationActivite;

    public void setNumeroAffiliationActivite(final String numeroAffiliationActivite) {
        this.numeroAffiliationActivite = numeroAffiliationActivite;
    }


    @Column(name="numero_affiliation_activite"  )
      
    public String getNumeroAffiliationActivite() {
        return this.numeroAffiliationActivite;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "nombreLicencieMajeurActivite"
      )
    
    private Long nombreLicencieMajeurActivite;

    public void setNombreLicencieMajeurActivite(final Long nombreLicencieMajeurActivite) {
        this.nombreLicencieMajeurActivite = nombreLicencieMajeurActivite;
    }


    @Column(name="nombre_licencie_majeur_activite"  )
      
    public Long getNombreLicencieMajeurActivite() {
        return this.nombreLicencieMajeurActivite;
    }
  
    
    private Long totalLicencieActivite;

    public void setTotalLicencieActivite(final Long totalLicencieActivite) {
        this.totalLicencieActivite = totalLicencieActivite;
    }


    @Column(name="total_licencie_activite"  )
      
    public Long getTotalLicencieActivite() {
        return this.totalLicencieActivite;
    }
  
    
    private String sommeAlloueeActivite;

    public void setSommeAlloueeActivite(final String sommeAlloueeActivite) {
        this.sommeAlloueeActivite = sommeAlloueeActivite;
    }


    @Column(name="somme_allouee_activite"  )
      
    public String getSommeAlloueeActivite() {
        return this.sommeAlloueeActivite;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "nomFederationSportiveActivite"
      )
    
      @NotBlank(
        
        
        profiles = {"activites"},
        message = "nomFederationSportiveActivite"
      )
    
    private String nomFederationSportiveActivite;

    public void setNomFederationSportiveActivite(final String nomFederationSportiveActivite) {
        this.nomFederationSportiveActivite = nomFederationSportiveActivite;
    }


    @Column(name="nom_federation_sportive_activite"  )
      
    public String getNomFederationSportiveActivite() {
        return this.nomFederationSportiveActivite;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "nomActivite"
      )
    
      @NotBlank(
        
        
        profiles = {"activites"},
        message = "nomActivite"
      )
    
    private String nomActivite;

    public void setNomActivite(final String nomActivite) {
        this.nomActivite = nomActivite;
    }


    @Column(name="nom_activite"  )
      
    public String getNomActivite() {
        return this.nomActivite;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "nombreLicencieMineurActivite"
      )
    
    private Long nombreLicencieMineurActivite;

    public void setNombreLicencieMineurActivite(final Long nombreLicencieMineurActivite) {
        this.nombreLicencieMineurActivite = nombreLicencieMineurActivite;
    }


    @Column(name="nombre_licencie_mineur_activite"  )
      
    public Long getNombreLicencieMineurActivite() {
        return this.nombreLicencieMineurActivite;
    }
  
}

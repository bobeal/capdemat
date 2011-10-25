
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
@Table(name="sagr_activite_association")
public class SagrActiviteAssociation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        SportsAssociationsGrantRequest.conditions;

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
    
        if (this.sportPratique != null)
            sagrActiviteAssociation.setSportPratique(fr.cg95.cvq.xml.request.social.SagrSportPratiqueType.Enum.forString(this.sportPratique.toString()));
      
        sagrActiviteAssociation.setNumeroAffiliationActivite(this.numeroAffiliationActivite);
      
        if (this.nombreLicencieMajeurActivite != null)
            sagrActiviteAssociation.setNombreLicencieMajeurActivite(this.nombreLicencieMajeurActivite.longValue());
      
        if (this.totalLicencieActivite != null)
            sagrActiviteAssociation.setTotalLicencieActivite(this.totalLicencieActivite.longValue());
      
        sagrActiviteAssociation.setSommeAlloueeActivite(this.sommeAlloueeActivite);
      
        sagrActiviteAssociation.setFederationSportivePrecision(this.federationSportivePrecision);
      
        if (this.federationSportive != null)
            sagrActiviteAssociation.setFederationSportive(fr.cg95.cvq.xml.request.social.SagrFederationSportiveType.Enum.forString(this.federationSportive.toString()));
      
        if (this.nombreLicencieMineurActivite != null)
            sagrActiviteAssociation.setNombreLicencieMineurActivite(this.nombreLicencieMineurActivite.longValue());
      
        sagrActiviteAssociation.setSportPratiquePrecision(this.sportPratiquePrecision);
      
        return sagrActiviteAssociation;
    }

    public static SagrActiviteAssociation xmlToModel(SagrActiviteAssociationType sagrActiviteAssociationDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SagrActiviteAssociation sagrActiviteAssociation = new SagrActiviteAssociation();
    
        if (sagrActiviteAssociationDoc.getSportPratique() != null)
            sagrActiviteAssociation.setSportPratique(fr.cg95.cvq.business.request.social.SagrSportPratiqueType.forString(sagrActiviteAssociationDoc.getSportPratique().toString()));
        else
            sagrActiviteAssociation.setSportPratique(fr.cg95.cvq.business.request.social.SagrSportPratiqueType.getDefaultSagrSportPratiqueType());
      
        sagrActiviteAssociation.setNumeroAffiliationActivite(sagrActiviteAssociationDoc.getNumeroAffiliationActivite());
      
        if (sagrActiviteAssociationDoc.getNombreLicencieMajeurActivite() != 0)
            sagrActiviteAssociation.setNombreLicencieMajeurActivite(new Long(sagrActiviteAssociationDoc.getNombreLicencieMajeurActivite()));
      
        if (sagrActiviteAssociationDoc.getTotalLicencieActivite() != 0)
            sagrActiviteAssociation.setTotalLicencieActivite(new Long(sagrActiviteAssociationDoc.getTotalLicencieActivite()));
      
        sagrActiviteAssociation.setSommeAlloueeActivite(sagrActiviteAssociationDoc.getSommeAlloueeActivite());
      
        sagrActiviteAssociation.setFederationSportivePrecision(sagrActiviteAssociationDoc.getFederationSportivePrecision());
      
        if (sagrActiviteAssociationDoc.getFederationSportive() != null)
            sagrActiviteAssociation.setFederationSportive(fr.cg95.cvq.business.request.social.SagrFederationSportiveType.forString(sagrActiviteAssociationDoc.getFederationSportive().toString()));
        else
            sagrActiviteAssociation.setFederationSportive(fr.cg95.cvq.business.request.social.SagrFederationSportiveType.getDefaultSagrFederationSportiveType());
      
        if (sagrActiviteAssociationDoc.getNombreLicencieMineurActivite() != 0)
            sagrActiviteAssociation.setNombreLicencieMineurActivite(new Long(sagrActiviteAssociationDoc.getNombreLicencieMineurActivite()));
      
        sagrActiviteAssociation.setSportPratiquePrecision(sagrActiviteAssociationDoc.getSportPratiquePrecision());
      
        return sagrActiviteAssociation;
    }

    @Override
    public SagrActiviteAssociation clone() {
        SagrActiviteAssociation result = new SagrActiviteAssociation();
        
          
            
        if (sportPratique != null)
            result.setSportPratique(sportPratique);
        else
            result.setSportPratique(fr.cg95.cvq.business.request.social.SagrSportPratiqueType.getDefaultSagrSportPratiqueType());
      
          
        
          
            
        result.setNumeroAffiliationActivite(numeroAffiliationActivite);
      
          
        
          
            
        result.setNombreLicencieMajeurActivite(nombreLicencieMajeurActivite);
      
          
        
          
            
        result.setTotalLicencieActivite(totalLicencieActivite);
      
          
        
          
            
        result.setSommeAlloueeActivite(sommeAlloueeActivite);
      
          
        
          
            
        result.setFederationSportivePrecision(federationSportivePrecision);
      
          
        
          
            
        if (federationSportive != null)
            result.setFederationSportive(federationSportive);
        else
            result.setFederationSportive(fr.cg95.cvq.business.request.social.SagrFederationSportiveType.getDefaultSagrFederationSportiveType());
      
          
        
          
            
        result.setNombreLicencieMineurActivite(nombreLicencieMineurActivite);
      
          
        
          
            
        result.setSportPratiquePrecision(sportPratiquePrecision);
      
          
        
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
        message = "sportPratique"
      )
    
    private fr.cg95.cvq.business.request.social.SagrSportPratiqueType sportPratique;

    public void setSportPratique(final fr.cg95.cvq.business.request.social.SagrSportPratiqueType sportPratique) {
        this.sportPratique = sportPratique;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="sport_pratique"  )
      
    public fr.cg95.cvq.business.request.social.SagrSportPratiqueType getSportPratique() {
        return this.sportPratique;
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
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['sagrActiviteAssociation.federationSportive'].test(_this.federationSportive.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"activites"},
        message = "federationSportivePrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['sagrActiviteAssociation.federationSportive'].test(_this.federationSportive.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"activites"},
        message = "federationSportivePrecision"
      )
    
    private String federationSportivePrecision;

    public void setFederationSportivePrecision(final String federationSportivePrecision) {
        this.federationSportivePrecision = federationSportivePrecision;
    }


    @Column(name="federation_sportive_precision"  )
      
    public String getFederationSportivePrecision() {
        return this.federationSportivePrecision;
    }
  
    
      @NotNull(
        
        
        profiles = {"activites"},
        message = "federationSportive"
      )
    
    private fr.cg95.cvq.business.request.social.SagrFederationSportiveType federationSportive;

    public void setFederationSportive(final fr.cg95.cvq.business.request.social.SagrFederationSportiveType federationSportive) {
        this.federationSportive = federationSportive;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="federation_sportive"  )
      
    public fr.cg95.cvq.business.request.social.SagrFederationSportiveType getFederationSportive() {
        return this.federationSportive;
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
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['sagrActiviteAssociation.sportPratique'].test(_this.sportPratique.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"activites"},
        message = "sportPratiquePrecision"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['sagrActiviteAssociation.sportPratique'].test(_this.sportPratique.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"activites"},
        message = "sportPratiquePrecision"
      )
    
    private String sportPratiquePrecision;

    public void setSportPratiquePrecision(final String sportPratiquePrecision) {
        this.sportPratiquePrecision = sportPratiquePrecision;
    }


    @Column(name="sport_pratique_precision"  )
      
    public String getSportPratiquePrecision() {
        return this.sportPratiquePrecision;
    }
  
}

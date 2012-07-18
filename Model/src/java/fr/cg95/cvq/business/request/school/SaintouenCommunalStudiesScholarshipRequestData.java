

package fr.cg95.cvq.business.request.school;

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
@Table(name="saintouen_communal_studies_scholarship_request")
public class SaintouenCommunalStudiesScholarshipRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public SaintouenCommunalStudiesScholarshipRequestData() {
      
        isOtherSituation = fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.TENANT;
      
        vousVivezAvec = fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType.DEUX_PARENTS;
      
    }

    @Override
    public SaintouenCommunalStudiesScholarshipRequestData clone() {
        SaintouenCommunalStudiesScholarshipRequestData result = new SaintouenCommunalStudiesScholarshipRequestData();
        
          
            
        if (isOtherSituation != null)
            result.setIsOtherSituation(isOtherSituation);
        else
            result.setIsOtherSituation(fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType.getDefaultSaintOuenSituationLogementType());
      
          
        
          
            
        result.setMontantBourse(montantBourse);
      
          
        
          
            
        result.setNombreAdultesMajeurs(nombreAdultesMajeurs);
      
          
        
          
            
        result.setNombreEnfantsMineurs(nombreEnfantsMineurs);
      
          
        
          
            
        result.setPrecisionsCompositionFamille(precisionsCompositionFamille);
      
          
        
          
            
        if (saintOuenCurrentStudiesLevel != null)
            result.setSaintOuenCurrentStudiesLevel(saintOuenCurrentStudiesLevel);
        else
            result.setSaintOuenCurrentStudiesLevel(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType.getDefaultSaintOuenCurrentStudiesLevelType());
      
          
        
          
            
        result.setSaintOuenEstablishmentLabel(saintOuenEstablishmentLabel);
      
          
        
          
            
        result.setSaintOuenEtablissementTelephone(saintOuenEtablissementTelephone);
      
          
        
          
            
        if (saintOuenIsInOtherStudies != null)
            result.setSaintOuenIsInOtherStudies(saintOuenIsInOtherStudies);
        else
            result.setSaintOuenIsInOtherStudies(fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType.getDefaultSaintOuenCurrentStudiesType());
      
          
        
          
            
        result.setSaintOuenOtherSituationDetails(saintOuenOtherSituationDetails);
      
          
        
          
            
        result.setSaintOuenOtherStudiesLabel(saintOuenOtherStudiesLabel);
      
          
        
          
            
        result.setSubjectBirthDate(subjectBirthDate);
      
          
        
          
            
        result.setSubjectDomiciliationDate(subjectDomiciliationDate);
      
          
        
          
            
        if (vousVivezAvec != null)
            result.setVousVivezAvec(vousVivezAvec);
        else
            result.setVousVivezAvec(fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType.getDefaultScssrVousVivezAvezType());
      
          
        
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
        
        
        profiles = {"subject"},
        message = "isOtherSituation"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType isOtherSituation;

    public void setIsOtherSituation(final fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType isOtherSituation) {
        this.isOtherSituation = isOtherSituation;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="is_other_situation"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType getIsOtherSituation() {
        return this.isOtherSituation;
    }
  
    
      @NotNull(
        
        
        profiles = {"administration"},
        message = "montantBourse"
      )
    
      @NotBlank(
        
        
        profiles = {"administration"},
        message = "montantBourse"
      )
    
    private String montantBourse;

    public void setMontantBourse(final String montantBourse) {
        this.montantBourse = montantBourse;
    }

 
    @Column(name="montant_bourse"  )
      
    public String getMontantBourse() {
        return this.montantBourse;
    }
  
    
      @NotNull(
        
        
        profiles = {"compositionFamille"},
        message = "nombreAdultesMajeurs"
      )
    
    private Long nombreAdultesMajeurs;

    public void setNombreAdultesMajeurs(final Long nombreAdultesMajeurs) {
        this.nombreAdultesMajeurs = nombreAdultesMajeurs;
    }

 
    @Column(name="nombre_adultes_majeurs"  )
      
    public Long getNombreAdultesMajeurs() {
        return this.nombreAdultesMajeurs;
    }
  
    
      @NotNull(
        
        
        profiles = {"compositionFamille"},
        message = "nombreEnfantsMineurs"
      )
    
    private Long nombreEnfantsMineurs;

    public void setNombreEnfantsMineurs(final Long nombreEnfantsMineurs) {
        this.nombreEnfantsMineurs = nombreEnfantsMineurs;
    }

 
    @Column(name="nombre_enfants_mineurs"  )
      
    public Long getNombreEnfantsMineurs() {
        return this.nombreEnfantsMineurs;
    }
  
    
      @MaxLength(
        
          value = 1024,
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['vousVivezAvec'].test(_this.vousVivezAvec.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"compositionFamille"},
        message = "precisionsCompositionFamille"
      )
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['vousVivezAvec'].test(_this.vousVivezAvec.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"compositionFamille"},
        message = "precisionsCompositionFamille"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['vousVivezAvec'].test(_this.vousVivezAvec.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"compositionFamille"},
        message = "precisionsCompositionFamille"
      )
    
    private String precisionsCompositionFamille;

    public void setPrecisionsCompositionFamille(final String precisionsCompositionFamille) {
        this.precisionsCompositionFamille = precisionsCompositionFamille;
    }

 
    @Column(name="precisions_composition_famille" , length=1024 )
      
    public String getPrecisionsCompositionFamille() {
        return this.precisionsCompositionFamille;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenCurrentStudiesLevel"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType saintOuenCurrentStudiesLevel;

    public void setSaintOuenCurrentStudiesLevel(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType saintOuenCurrentStudiesLevel) {
        this.saintOuenCurrentStudiesLevel = saintOuenCurrentStudiesLevel;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="saint_ouen_current_studies_level"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType getSaintOuenCurrentStudiesLevel() {
        return this.saintOuenCurrentStudiesLevel;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEstablishmentLabel"
      )
    
      @NotBlank(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEstablishmentLabel"
      )
    
    private String saintOuenEstablishmentLabel;

    public void setSaintOuenEstablishmentLabel(final String saintOuenEstablishmentLabel) {
        this.saintOuenEstablishmentLabel = saintOuenEstablishmentLabel;
    }

 
    @Column(name="saint_ouen_establishment_label"  )
      
    public String getSaintOuenEstablishmentLabel() {
        return this.saintOuenEstablishmentLabel;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEtablissementTelephone"
      )
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEtablissementTelephone"
      )
    
      @NotBlank(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenEtablissementTelephone"
      )
    
    private String saintOuenEtablissementTelephone;

    public void setSaintOuenEtablissementTelephone(final String saintOuenEtablissementTelephone) {
        this.saintOuenEtablissementTelephone = saintOuenEtablissementTelephone;
    }

 
    @Column(name="saint_ouen_etablissement_telephone" , length=10 )
      
    public String getSaintOuenEtablissementTelephone() {
        return this.saintOuenEtablissementTelephone;
    }
  
    
      @NotNull(
        
        
        profiles = {"schoolingInformation"},
        message = "saintOuenIsInOtherStudies"
      )
    
    private fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType saintOuenIsInOtherStudies;

    public void setSaintOuenIsInOtherStudies(final fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType saintOuenIsInOtherStudies) {
        this.saintOuenIsInOtherStudies = saintOuenIsInOtherStudies;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="saint_ouen_is_in_other_studies"  )
      
    public fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType getSaintOuenIsInOtherStudies() {
        return this.saintOuenIsInOtherStudies;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isOtherSituation'].test(_this.isOtherSituation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "saintOuenOtherSituationDetails"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['isOtherSituation'].test(_this.isOtherSituation.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"subject"},
        message = "saintOuenOtherSituationDetails"
      )
    
    private String saintOuenOtherSituationDetails;

    public void setSaintOuenOtherSituationDetails(final String saintOuenOtherSituationDetails) {
        this.saintOuenOtherSituationDetails = saintOuenOtherSituationDetails;
    }

 
    @Column(name="saint_ouen_other_situation_details"  )
      
    public String getSaintOuenOtherSituationDetails() {
        return this.saintOuenOtherSituationDetails;
    }
  
    
      @NotNull(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['saintOuenIsInOtherStudies'].test(_this.saintOuenIsInOtherStudies.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"schoolingInformation"},
        message = "saintOuenOtherStudiesLabel"
      )
    
      @NotBlank(
        
        
          when = "groovy:def active = true;" +
          
            "active &= _this.conditions['saintOuenIsInOtherStudies'].test(_this.saintOuenIsInOtherStudies.toString());" +
                
              
            
            
            "return active",
        
        profiles = {"schoolingInformation"},
        message = "saintOuenOtherStudiesLabel"
      )
    
    private String saintOuenOtherStudiesLabel;

    public void setSaintOuenOtherStudiesLabel(final String saintOuenOtherStudiesLabel) {
        this.saintOuenOtherStudiesLabel = saintOuenOtherStudiesLabel;
    }

 
    @Column(name="saint_ouen_other_studies_label"  )
      
    public String getSaintOuenOtherStudiesLabel() {
        return this.saintOuenOtherStudiesLabel;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectBirthDate"
      )
    
    private java.util.Date subjectBirthDate;

    public void setSubjectBirthDate(final java.util.Date subjectBirthDate) {
        this.subjectBirthDate = subjectBirthDate;
    }

 
    @Column(name="subject_birth_date"  )
      
    public java.util.Date getSubjectBirthDate() {
        return this.subjectBirthDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"subject"},
        message = "subjectDomiciliationDate"
      )
    
    private java.util.Date subjectDomiciliationDate;

    public void setSubjectDomiciliationDate(final java.util.Date subjectDomiciliationDate) {
        this.subjectDomiciliationDate = subjectDomiciliationDate;
    }

 
    @Column(name="subject_domiciliation_date"  )
      
    public java.util.Date getSubjectDomiciliationDate() {
        return this.subjectDomiciliationDate;
    }
  
    
      @NotNull(
        
        
        profiles = {"compositionFamille"},
        message = "vousVivezAvec"
      )
    
    private fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType vousVivezAvec;

    public void setVousVivezAvec(final fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType vousVivezAvec) {
        this.vousVivezAvec = vousVivezAvec;
    }

 
    @Enumerated(EnumType.STRING)
    @Column(name="vous_vivez_avec"  )
      
    public fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType getVousVivezAvec() {
        return this.vousVivezAvec;
    }
  
}

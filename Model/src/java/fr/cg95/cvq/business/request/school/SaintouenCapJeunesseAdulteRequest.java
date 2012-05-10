
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
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SaintouenCapJeunesseAdulteRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenCapJeunesseAdulteRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenCapJeunesseAdulteRequestData saintouenCapJeunesseAdulteRequestData;

    public SaintouenCapJeunesseAdulteRequest(RequestData requestData, SaintouenCapJeunesseAdulteRequestData saintouenCapJeunesseAdulteRequestData) {
        super(requestData);
        this.saintouenCapJeunesseAdulteRequestData = saintouenCapJeunesseAdulteRequestData;
    }

    public SaintouenCapJeunesseAdulteRequest() {
        super();
        this.saintouenCapJeunesseAdulteRequestData = new SaintouenCapJeunesseAdulteRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("sujet", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("renseignements", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("reglements", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("administration", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public SaintouenCapJeunesseAdulteRequestData getSpecificData() {
        return saintouenCapJeunesseAdulteRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenCapJeunesseAdulteRequestData saintouenCapJeunesseAdulteRequestData) {
        this.saintouenCapJeunesseAdulteRequestData = saintouenCapJeunesseAdulteRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenCapJeunesseAdulteRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenCapJeunesseAdulteRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenCapJeunesseAdulteRequestDocument saintouenCapJeunesseAdulteRequestDoc = SaintouenCapJeunesseAdulteRequestDocument.Factory.newInstance();
        SaintouenCapJeunesseAdulteRequestDocument.SaintouenCapJeunesseAdulteRequest saintouenCapJeunesseAdulteRequest = saintouenCapJeunesseAdulteRequestDoc.addNewSaintouenCapJeunesseAdulteRequest();
        super.fillCommonXmlInfo(saintouenCapJeunesseAdulteRequest);
        int i = 0;
        
        if (getAcceptationReglement() != null)
            saintouenCapJeunesseAdulteRequest.setAcceptationReglement(getAcceptationReglement().booleanValue());
        ScjarEtablissementScolaireAutreType scjarEtablissementScolaireAutreTypeEtablissementScolaireAutre = saintouenCapJeunesseAdulteRequest.addNewEtablissementScolaireAutre();
        if (getAdresseEtablissementScolaireAutre() != null)
            scjarEtablissementScolaireAutreTypeEtablissementScolaireAutre.setAdresseEtablissementScolaireAutre(Address.modelToXml(getAdresseEtablissementScolaireAutre()));
      
        if (getAutorisationImage() != null)
            saintouenCapJeunesseAdulteRequest.setAutorisationImage(getAutorisationImage().booleanValue());
      
        if (getAutorisationMedicale() != null)
            saintouenCapJeunesseAdulteRequest.setAutorisationMedicale(getAutorisationMedicale().booleanValue());
      
        date = getDateNaissance();
        if (date != null) {
            calendar.setTime(date);
            saintouenCapJeunesseAdulteRequest.setDateNaissance(calendar);
        }
      
        if (getEtudiantTypeEtablissement() != null)
            saintouenCapJeunesseAdulteRequest.setEtudiantTypeEtablissement(fr.cg95.cvq.xml.request.school.ScjarEtudiantTypeEtablissementType.Enum.forString(getEtudiantTypeEtablissement().getLegacyLabel()));
      
        scjarEtablissementScolaireAutreTypeEtablissementScolaireAutre.setNomEtablissementScolaireAutre(getNomEtablissementScolaireAutre());
      
        if (getParticipeActivite() != null)
            saintouenCapJeunesseAdulteRequest.setParticipeActivite(getParticipeActivite().booleanValue());
      
        saintouenCapJeunesseAdulteRequest.setPrecisionActivite(getPrecisionActivite());
      
        scjarEtablissementScolaireAutreTypeEtablissementScolaireAutre.setPrecisionEtablissementScolaireAutre(getPrecisionEtablissementScolaireAutre());
      
        saintouenCapJeunesseAdulteRequest.setProfession(getProfession());
      
        i = 0;
        if (getSecteurHabitation() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] secteurHabitationTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getSecteurHabitation().size()];
            for (LocalReferentialData object : getSecteurHabitation()) {
              secteurHabitationTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenCapJeunesseAdulteRequest.setSecteurHabitationArray(secteurHabitationTypeTab);
        }
      
        if (getSexe() != null)
            saintouenCapJeunesseAdulteRequest.setSexe(fr.cg95.cvq.xml.request.school.ScjarSexeType.Enum.forString(getSexe().getLegacyLabel()));
      
        saintouenCapJeunesseAdulteRequest.setSignatureAdolescent(getSignatureAdolescent());
      
        saintouenCapJeunesseAdulteRequest.setSignatureElu(getSignatureElu());
      
        if (getSituationActuelle() != null)
            saintouenCapJeunesseAdulteRequest.setSituationActuelle(fr.cg95.cvq.xml.request.school.ScjarSituationActuelleType.Enum.forString(getSituationActuelle().getLegacyLabel()));
      
        if (getTypeActivite() != null)
            saintouenCapJeunesseAdulteRequest.setTypeActivite(fr.cg95.cvq.xml.request.school.ScjarTypeActiviteType.Enum.forString(getTypeActivite().getLegacyLabel()));
      
        if (getTypeInscription() != null)
            saintouenCapJeunesseAdulteRequest.setTypeInscription(fr.cg95.cvq.xml.request.school.ScjarTypeInscriptionType.Enum.forString(getTypeInscription().getLegacyLabel()));
      
        return saintouenCapJeunesseAdulteRequestDoc;
    }

    @Override
    public final SaintouenCapJeunesseAdulteRequestDocument.SaintouenCapJeunesseAdulteRequest modelToXmlRequest() {
        return modelToXml().getSaintouenCapJeunesseAdulteRequest();
    }

    public static SaintouenCapJeunesseAdulteRequest xmlToModel(SaintouenCapJeunesseAdulteRequestDocument saintouenCapJeunesseAdulteRequestDoc) {
        SaintouenCapJeunesseAdulteRequestDocument.SaintouenCapJeunesseAdulteRequest saintouenCapJeunesseAdulteRequestXml = saintouenCapJeunesseAdulteRequestDoc.getSaintouenCapJeunesseAdulteRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenCapJeunesseAdulteRequest saintouenCapJeunesseAdulteRequest = new SaintouenCapJeunesseAdulteRequest();
        saintouenCapJeunesseAdulteRequest.fillCommonModelInfo(saintouenCapJeunesseAdulteRequest, saintouenCapJeunesseAdulteRequestXml);
        
        saintouenCapJeunesseAdulteRequest.setAcceptationReglement(Boolean.valueOf(saintouenCapJeunesseAdulteRequestXml.getAcceptationReglement()));
      
        if (saintouenCapJeunesseAdulteRequestXml.getEtablissementScolaireAutre().getAdresseEtablissementScolaireAutre() != null)
            saintouenCapJeunesseAdulteRequest.setAdresseEtablissementScolaireAutre(Address.xmlToModel(saintouenCapJeunesseAdulteRequestXml.getEtablissementScolaireAutre().getAdresseEtablissementScolaireAutre()));
      
        saintouenCapJeunesseAdulteRequest.setAutorisationImage(Boolean.valueOf(saintouenCapJeunesseAdulteRequestXml.getAutorisationImage()));
      
        saintouenCapJeunesseAdulteRequest.setAutorisationMedicale(Boolean.valueOf(saintouenCapJeunesseAdulteRequestXml.getAutorisationMedicale()));
      
        calendar = saintouenCapJeunesseAdulteRequestXml.getDateNaissance();
        if (calendar != null) {
            saintouenCapJeunesseAdulteRequest.setDateNaissance(calendar.getTime());
        }
      
        if (saintouenCapJeunesseAdulteRequestXml.getEtudiantTypeEtablissement() != null)
            saintouenCapJeunesseAdulteRequest.setEtudiantTypeEtablissement(fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType.forString(saintouenCapJeunesseAdulteRequestXml.getEtudiantTypeEtablissement().toString()));
        else
            saintouenCapJeunesseAdulteRequest.setEtudiantTypeEtablissement(fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType.getDefaultScjarEtudiantTypeEtablissementType());
      
        saintouenCapJeunesseAdulteRequest.setNomEtablissementScolaireAutre(saintouenCapJeunesseAdulteRequestXml.getEtablissementScolaireAutre().getNomEtablissementScolaireAutre());
      
        saintouenCapJeunesseAdulteRequest.setParticipeActivite(Boolean.valueOf(saintouenCapJeunesseAdulteRequestXml.getParticipeActivite()));
      
        saintouenCapJeunesseAdulteRequest.setPrecisionActivite(saintouenCapJeunesseAdulteRequestXml.getPrecisionActivite());
      
        saintouenCapJeunesseAdulteRequest.setPrecisionEtablissementScolaireAutre(saintouenCapJeunesseAdulteRequestXml.getEtablissementScolaireAutre().getPrecisionEtablissementScolaireAutre());
      
        saintouenCapJeunesseAdulteRequest.setProfession(saintouenCapJeunesseAdulteRequestXml.getProfession());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenCapJeunesseAdulteRequestXml.sizeOfSecteurHabitationArray());
        for (LocalReferentialDataType object : saintouenCapJeunesseAdulteRequestXml.getSecteurHabitationArray()) {
            secteurHabitationList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenCapJeunesseAdulteRequest.setSecteurHabitation(secteurHabitationList);
      
        if (saintouenCapJeunesseAdulteRequestXml.getSexe() != null)
            saintouenCapJeunesseAdulteRequest.setSexe(fr.cg95.cvq.business.request.school.ScjarSexeType.forString(saintouenCapJeunesseAdulteRequestXml.getSexe().toString()));
        else
            saintouenCapJeunesseAdulteRequest.setSexe(fr.cg95.cvq.business.request.school.ScjarSexeType.getDefaultScjarSexeType());
      
        saintouenCapJeunesseAdulteRequest.setSignatureAdolescent(saintouenCapJeunesseAdulteRequestXml.getSignatureAdolescent());
      
        saintouenCapJeunesseAdulteRequest.setSignatureElu(saintouenCapJeunesseAdulteRequestXml.getSignatureElu());
      
        if (saintouenCapJeunesseAdulteRequestXml.getSituationActuelle() != null)
            saintouenCapJeunesseAdulteRequest.setSituationActuelle(fr.cg95.cvq.business.request.school.ScjarSituationActuelleType.forString(saintouenCapJeunesseAdulteRequestXml.getSituationActuelle().toString()));
        else
            saintouenCapJeunesseAdulteRequest.setSituationActuelle(fr.cg95.cvq.business.request.school.ScjarSituationActuelleType.getDefaultScjarSituationActuelleType());
      
        if (saintouenCapJeunesseAdulteRequestXml.getTypeActivite() != null)
            saintouenCapJeunesseAdulteRequest.setTypeActivite(fr.cg95.cvq.business.request.school.ScjarTypeActiviteType.forString(saintouenCapJeunesseAdulteRequestXml.getTypeActivite().toString()));
        else
            saintouenCapJeunesseAdulteRequest.setTypeActivite(fr.cg95.cvq.business.request.school.ScjarTypeActiviteType.getDefaultScjarTypeActiviteType());
      
        if (saintouenCapJeunesseAdulteRequestXml.getTypeInscription() != null)
            saintouenCapJeunesseAdulteRequest.setTypeInscription(fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType.forString(saintouenCapJeunesseAdulteRequestXml.getTypeInscription().toString()));
        else
            saintouenCapJeunesseAdulteRequest.setTypeInscription(fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType.getDefaultScjarTypeInscriptionType());
      
        return saintouenCapJeunesseAdulteRequest;
    }

    @Override
    public SaintouenCapJeunesseAdulteRequest clone() {
        SaintouenCapJeunesseAdulteRequest clone = new SaintouenCapJeunesseAdulteRequest(getRequestData().clone(), saintouenCapJeunesseAdulteRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("sujet", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("renseignements", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("reglements", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("document", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("administration", stepState);
        
        return clone;
    }

  
    public final void setAcceptationReglement(final Boolean acceptationReglement) {
        saintouenCapJeunesseAdulteRequestData.setAcceptationReglement(acceptationReglement);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglement() {
        return saintouenCapJeunesseAdulteRequestData.getAcceptationReglement();
    }
  
    public final void setAdresseEtablissementScolaireAutre(final fr.cg95.cvq.business.users.Address adresseEtablissementScolaireAutre) {
        saintouenCapJeunesseAdulteRequestData.setAdresseEtablissementScolaireAutre(adresseEtablissementScolaireAutre);
    }

    
    public final fr.cg95.cvq.business.users.Address getAdresseEtablissementScolaireAutre() {
        return saintouenCapJeunesseAdulteRequestData.getAdresseEtablissementScolaireAutre();
    }
  
    public final void setAutorisationImage(final Boolean autorisationImage) {
        saintouenCapJeunesseAdulteRequestData.setAutorisationImage(autorisationImage);
    }

    @IsRulesAcceptance
    public final Boolean getAutorisationImage() {
        return saintouenCapJeunesseAdulteRequestData.getAutorisationImage();
    }
  
    public final void setAutorisationMedicale(final Boolean autorisationMedicale) {
        saintouenCapJeunesseAdulteRequestData.setAutorisationMedicale(autorisationMedicale);
    }

    @IsRulesAcceptance
    public final Boolean getAutorisationMedicale() {
        return saintouenCapJeunesseAdulteRequestData.getAutorisationMedicale();
    }
  
    public final void setDateNaissance(final java.util.Date dateNaissance) {
        saintouenCapJeunesseAdulteRequestData.setDateNaissance(dateNaissance);
    }

    
    public final java.util.Date getDateNaissance() {
        return saintouenCapJeunesseAdulteRequestData.getDateNaissance();
    }
  
    public final void setEtudiantTypeEtablissement(final fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType etudiantTypeEtablissement) {
        saintouenCapJeunesseAdulteRequestData.setEtudiantTypeEtablissement(etudiantTypeEtablissement);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjarEtudiantTypeEtablissementType getEtudiantTypeEtablissement() {
        return saintouenCapJeunesseAdulteRequestData.getEtudiantTypeEtablissement();
    }
  
    public final void setNomEtablissementScolaireAutre(final String nomEtablissementScolaireAutre) {
        saintouenCapJeunesseAdulteRequestData.setNomEtablissementScolaireAutre(nomEtablissementScolaireAutre);
    }

    
    public final String getNomEtablissementScolaireAutre() {
        return saintouenCapJeunesseAdulteRequestData.getNomEtablissementScolaireAutre();
    }
  
    public final void setParticipeActivite(final Boolean participeActivite) {
        saintouenCapJeunesseAdulteRequestData.setParticipeActivite(participeActivite);
    }

    
    public final Boolean getParticipeActivite() {
        return saintouenCapJeunesseAdulteRequestData.getParticipeActivite();
    }
  
    public final void setPrecisionActivite(final String precisionActivite) {
        saintouenCapJeunesseAdulteRequestData.setPrecisionActivite(precisionActivite);
    }

    
    public final String getPrecisionActivite() {
        return saintouenCapJeunesseAdulteRequestData.getPrecisionActivite();
    }
  
    public final void setPrecisionEtablissementScolaireAutre(final String precisionEtablissementScolaireAutre) {
        saintouenCapJeunesseAdulteRequestData.setPrecisionEtablissementScolaireAutre(precisionEtablissementScolaireAutre);
    }

    
    public final String getPrecisionEtablissementScolaireAutre() {
        return saintouenCapJeunesseAdulteRequestData.getPrecisionEtablissementScolaireAutre();
    }
  
    public final void setProfession(final String profession) {
        saintouenCapJeunesseAdulteRequestData.setProfession(profession);
    }

    
    public final String getProfession() {
        return saintouenCapJeunesseAdulteRequestData.getProfession();
    }
  
    public final void setSecteurHabitation(final List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitation) {
        saintouenCapJeunesseAdulteRequestData.setSecteurHabitation(secteurHabitation);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSecteurHabitation() {
        return saintouenCapJeunesseAdulteRequestData.getSecteurHabitation();
    }
  
    public final void setSexe(final fr.cg95.cvq.business.request.school.ScjarSexeType sexe) {
        saintouenCapJeunesseAdulteRequestData.setSexe(sexe);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjarSexeType getSexe() {
        return saintouenCapJeunesseAdulteRequestData.getSexe();
    }
  
    public final void setSignatureAdolescent(final String signatureAdolescent) {
        saintouenCapJeunesseAdulteRequestData.setSignatureAdolescent(signatureAdolescent);
    }

    
    public final String getSignatureAdolescent() {
        return saintouenCapJeunesseAdulteRequestData.getSignatureAdolescent();
    }
  
    public final void setSignatureElu(final String signatureElu) {
        saintouenCapJeunesseAdulteRequestData.setSignatureElu(signatureElu);
    }

    
    public final String getSignatureElu() {
        return saintouenCapJeunesseAdulteRequestData.getSignatureElu();
    }
  
    public final void setSituationActuelle(final fr.cg95.cvq.business.request.school.ScjarSituationActuelleType situationActuelle) {
        saintouenCapJeunesseAdulteRequestData.setSituationActuelle(situationActuelle);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjarSituationActuelleType getSituationActuelle() {
        return saintouenCapJeunesseAdulteRequestData.getSituationActuelle();
    }
  
    public final void setTypeActivite(final fr.cg95.cvq.business.request.school.ScjarTypeActiviteType typeActivite) {
        saintouenCapJeunesseAdulteRequestData.setTypeActivite(typeActivite);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjarTypeActiviteType getTypeActivite() {
        return saintouenCapJeunesseAdulteRequestData.getTypeActivite();
    }
  
    public final void setTypeInscription(final fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType typeInscription) {
        saintouenCapJeunesseAdulteRequestData.setTypeInscription(typeInscription);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjarTypeInscriptionType getTypeInscription() {
        return saintouenCapJeunesseAdulteRequestData.getTypeInscription();
    }
  
}


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
public class SaintouenCapJeunesseEnfantRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SaintouenCapJeunesseEnfantRequestData.conditions;

    @AssertValid(message = "")
    private SaintouenCapJeunesseEnfantRequestData saintouenCapJeunesseEnfantRequestData;

    public SaintouenCapJeunesseEnfantRequest(RequestData requestData, SaintouenCapJeunesseEnfantRequestData saintouenCapJeunesseEnfantRequestData) {
        super(requestData);
        this.saintouenCapJeunesseEnfantRequestData = saintouenCapJeunesseEnfantRequestData;
    }

    public SaintouenCapJeunesseEnfantRequest() {
        super();
        this.saintouenCapJeunesseEnfantRequestData = new SaintouenCapJeunesseEnfantRequestData();
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
    public SaintouenCapJeunesseEnfantRequestData getSpecificData() {
        return saintouenCapJeunesseEnfantRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SaintouenCapJeunesseEnfantRequestData saintouenCapJeunesseEnfantRequestData) {
        this.saintouenCapJeunesseEnfantRequestData = saintouenCapJeunesseEnfantRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SaintouenCapJeunesseEnfantRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SaintouenCapJeunesseEnfantRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SaintouenCapJeunesseEnfantRequestDocument saintouenCapJeunesseEnfantRequestDoc = SaintouenCapJeunesseEnfantRequestDocument.Factory.newInstance();
        SaintouenCapJeunesseEnfantRequestDocument.SaintouenCapJeunesseEnfantRequest saintouenCapJeunesseEnfantRequest = saintouenCapJeunesseEnfantRequestDoc.addNewSaintouenCapJeunesseEnfantRequest();
        super.fillCommonXmlInfo(saintouenCapJeunesseEnfantRequest);
        int i = 0;
        
        if (getAcceptationReglement() != null)
            saintouenCapJeunesseEnfantRequest.setAcceptationReglement(getAcceptationReglement().booleanValue());
      
        if (getAutorisationImage() != null)
            saintouenCapJeunesseEnfantRequest.setAutorisationImage(getAutorisationImage().booleanValue());
      
        if (getAutorisationMedicale() != null)
            saintouenCapJeunesseEnfantRequest.setAutorisationMedicale(getAutorisationMedicale().booleanValue());
      
        saintouenCapJeunesseEnfantRequest.setEmail(getEmail());
      
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutre(getEtablissementScolaireAutre());
      
        if (getEtablissementScolaireAutreAdresse() != null)
            saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutreAdresse(Address.modelToXml(getEtablissementScolaireAutreAdresse()));
      
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutreNom(getEtablissementScolaireAutreNom());
      
        i = 0;
        if (getEtablissementScolaireCollege() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] etablissementScolaireCollegeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getEtablissementScolaireCollege().size()];
            for (LocalReferentialData object : getEtablissementScolaireCollege()) {
              etablissementScolaireCollegeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenCapJeunesseEnfantRequest.setEtablissementScolaireCollegeArray(etablissementScolaireCollegeTypeTab);
        }
      
        i = 0;
        if (getEtablissementScolaireLycee() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] etablissementScolaireLyceeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getEtablissementScolaireLycee().size()];
            for (LocalReferentialData object : getEtablissementScolaireLycee()) {
              etablissementScolaireLyceeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenCapJeunesseEnfantRequest.setEtablissementScolaireLyceeArray(etablissementScolaireLyceeTypeTab);
        }
      
        i = 0;
        if (getSecteurHabitation() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] secteurHabitationTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getSecteurHabitation().size()];
            for (LocalReferentialData object : getSecteurHabitation()) {
              secteurHabitationTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            saintouenCapJeunesseEnfantRequest.setSecteurHabitationArray(secteurHabitationTypeTab);
        }
      
        saintouenCapJeunesseEnfantRequest.setSignatureAdolescent(getSignatureAdolescent());
      
        saintouenCapJeunesseEnfantRequest.setSignatureElu(getSignatureElu());
      
        saintouenCapJeunesseEnfantRequest.setSignatureResponsableLegal(getSignatureResponsableLegal());
      
        saintouenCapJeunesseEnfantRequest.setTelephonePortable(getTelephonePortable());
      
        if (getTypeEtablissementScolaireFrenquente() != null)
            saintouenCapJeunesseEnfantRequest.setTypeEtablissementScolaireFrenquente(fr.cg95.cvq.xml.request.school.ScjerTypeEtablissementScolaireType.Enum.forString(getTypeEtablissementScolaireFrenquente().getLegacyLabel()));
      
        if (getTypeInscription() != null)
            saintouenCapJeunesseEnfantRequest.setTypeInscription(fr.cg95.cvq.xml.request.school.ScjerTypeInscriptionType.Enum.forString(getTypeInscription().getLegacyLabel()));
      
        return saintouenCapJeunesseEnfantRequestDoc;
    }

    @Override
    public final SaintouenCapJeunesseEnfantRequestDocument.SaintouenCapJeunesseEnfantRequest modelToXmlRequest() {
        return modelToXml().getSaintouenCapJeunesseEnfantRequest();
    }

    public static SaintouenCapJeunesseEnfantRequest xmlToModel(SaintouenCapJeunesseEnfantRequestDocument saintouenCapJeunesseEnfantRequestDoc) {
        SaintouenCapJeunesseEnfantRequestDocument.SaintouenCapJeunesseEnfantRequest saintouenCapJeunesseEnfantRequestXml = saintouenCapJeunesseEnfantRequestDoc.getSaintouenCapJeunesseEnfantRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SaintouenCapJeunesseEnfantRequest saintouenCapJeunesseEnfantRequest = new SaintouenCapJeunesseEnfantRequest();
        saintouenCapJeunesseEnfantRequest.fillCommonModelInfo(saintouenCapJeunesseEnfantRequest, saintouenCapJeunesseEnfantRequestXml);
        
        saintouenCapJeunesseEnfantRequest.setAcceptationReglement(Boolean.valueOf(saintouenCapJeunesseEnfantRequestXml.getAcceptationReglement()));
      
        saintouenCapJeunesseEnfantRequest.setAutorisationImage(Boolean.valueOf(saintouenCapJeunesseEnfantRequestXml.getAutorisationImage()));
      
        saintouenCapJeunesseEnfantRequest.setAutorisationMedicale(Boolean.valueOf(saintouenCapJeunesseEnfantRequestXml.getAutorisationMedicale()));
      
        saintouenCapJeunesseEnfantRequest.setEmail(saintouenCapJeunesseEnfantRequestXml.getEmail());
      
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutre(saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireAutre());
      
        if (saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireAutreAdresse() != null)
            saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutreAdresse(Address.xmlToModel(saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireAutreAdresse()));
      
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireAutreNom(saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireAutreNom());
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireCollegeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenCapJeunesseEnfantRequestXml.sizeOfEtablissementScolaireCollegeArray());
        for (LocalReferentialDataType object : saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireCollegeArray()) {
            etablissementScolaireCollegeList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireCollege(etablissementScolaireCollegeList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireLyceeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenCapJeunesseEnfantRequestXml.sizeOfEtablissementScolaireLyceeArray());
        for (LocalReferentialDataType object : saintouenCapJeunesseEnfantRequestXml.getEtablissementScolaireLyceeArray()) {
            etablissementScolaireLyceeList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenCapJeunesseEnfantRequest.setEtablissementScolaireLycee(etablissementScolaireLyceeList);
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitationList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(saintouenCapJeunesseEnfantRequestXml.sizeOfSecteurHabitationArray());
        for (LocalReferentialDataType object : saintouenCapJeunesseEnfantRequestXml.getSecteurHabitationArray()) {
            secteurHabitationList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        saintouenCapJeunesseEnfantRequest.setSecteurHabitation(secteurHabitationList);
      
        saintouenCapJeunesseEnfantRequest.setSignatureAdolescent(saintouenCapJeunesseEnfantRequestXml.getSignatureAdolescent());
      
        saintouenCapJeunesseEnfantRequest.setSignatureElu(saintouenCapJeunesseEnfantRequestXml.getSignatureElu());
      
        saintouenCapJeunesseEnfantRequest.setSignatureResponsableLegal(saintouenCapJeunesseEnfantRequestXml.getSignatureResponsableLegal());
      
        saintouenCapJeunesseEnfantRequest.setTelephonePortable(saintouenCapJeunesseEnfantRequestXml.getTelephonePortable());
      
        if (saintouenCapJeunesseEnfantRequestXml.getTypeEtablissementScolaireFrenquente() != null)
            saintouenCapJeunesseEnfantRequest.setTypeEtablissementScolaireFrenquente(fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType.forString(saintouenCapJeunesseEnfantRequestXml.getTypeEtablissementScolaireFrenquente().toString()));
        else
            saintouenCapJeunesseEnfantRequest.setTypeEtablissementScolaireFrenquente(fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType.getDefaultScjerTypeEtablissementScolaireType());
      
        if (saintouenCapJeunesseEnfantRequestXml.getTypeInscription() != null)
            saintouenCapJeunesseEnfantRequest.setTypeInscription(fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType.forString(saintouenCapJeunesseEnfantRequestXml.getTypeInscription().toString()));
        else
            saintouenCapJeunesseEnfantRequest.setTypeInscription(fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType.getDefaultScjerTypeInscriptionType());
      
        return saintouenCapJeunesseEnfantRequest;
    }

    @Override
    public SaintouenCapJeunesseEnfantRequest clone() {
        SaintouenCapJeunesseEnfantRequest clone = new SaintouenCapJeunesseEnfantRequest(getRequestData().clone(), saintouenCapJeunesseEnfantRequestData.clone());
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
        saintouenCapJeunesseEnfantRequestData.setAcceptationReglement(acceptationReglement);
    }

    @IsRulesAcceptance
    public final Boolean getAcceptationReglement() {
        return saintouenCapJeunesseEnfantRequestData.getAcceptationReglement();
    }
  
    public final void setAutorisationImage(final Boolean autorisationImage) {
        saintouenCapJeunesseEnfantRequestData.setAutorisationImage(autorisationImage);
    }

    @IsRulesAcceptance
    public final Boolean getAutorisationImage() {
        return saintouenCapJeunesseEnfantRequestData.getAutorisationImage();
    }
  
    public final void setAutorisationMedicale(final Boolean autorisationMedicale) {
        saintouenCapJeunesseEnfantRequestData.setAutorisationMedicale(autorisationMedicale);
    }

    @IsRulesAcceptance
    public final Boolean getAutorisationMedicale() {
        return saintouenCapJeunesseEnfantRequestData.getAutorisationMedicale();
    }
  
    public final void setEmail(final String email) {
        saintouenCapJeunesseEnfantRequestData.setEmail(email);
    }

    
    public final String getEmail() {
        return saintouenCapJeunesseEnfantRequestData.getEmail();
    }
  
    public final void setEtablissementScolaireAutre(final String etablissementScolaireAutre) {
        saintouenCapJeunesseEnfantRequestData.setEtablissementScolaireAutre(etablissementScolaireAutre);
    }

    
    public final String getEtablissementScolaireAutre() {
        return saintouenCapJeunesseEnfantRequestData.getEtablissementScolaireAutre();
    }
  
    public final void setEtablissementScolaireAutreAdresse(final fr.cg95.cvq.business.users.Address etablissementScolaireAutreAdresse) {
        saintouenCapJeunesseEnfantRequestData.setEtablissementScolaireAutreAdresse(etablissementScolaireAutreAdresse);
    }

    
    public final fr.cg95.cvq.business.users.Address getEtablissementScolaireAutreAdresse() {
        return saintouenCapJeunesseEnfantRequestData.getEtablissementScolaireAutreAdresse();
    }
  
    public final void setEtablissementScolaireAutreNom(final String etablissementScolaireAutreNom) {
        saintouenCapJeunesseEnfantRequestData.setEtablissementScolaireAutreNom(etablissementScolaireAutreNom);
    }

    
    public final String getEtablissementScolaireAutreNom() {
        return saintouenCapJeunesseEnfantRequestData.getEtablissementScolaireAutreNom();
    }
  
    public final void setEtablissementScolaireCollege(final List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireCollege) {
        saintouenCapJeunesseEnfantRequestData.setEtablissementScolaireCollege(etablissementScolaireCollege);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getEtablissementScolaireCollege() {
        return saintouenCapJeunesseEnfantRequestData.getEtablissementScolaireCollege();
    }
  
    public final void setEtablissementScolaireLycee(final List<fr.cg95.cvq.business.request.LocalReferentialData> etablissementScolaireLycee) {
        saintouenCapJeunesseEnfantRequestData.setEtablissementScolaireLycee(etablissementScolaireLycee);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getEtablissementScolaireLycee() {
        return saintouenCapJeunesseEnfantRequestData.getEtablissementScolaireLycee();
    }
  
    public final void setSecteurHabitation(final List<fr.cg95.cvq.business.request.LocalReferentialData> secteurHabitation) {
        saintouenCapJeunesseEnfantRequestData.setSecteurHabitation(secteurHabitation);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getSecteurHabitation() {
        return saintouenCapJeunesseEnfantRequestData.getSecteurHabitation();
    }
  
    public final void setSignatureAdolescent(final String signatureAdolescent) {
        saintouenCapJeunesseEnfantRequestData.setSignatureAdolescent(signatureAdolescent);
    }

    
    public final String getSignatureAdolescent() {
        return saintouenCapJeunesseEnfantRequestData.getSignatureAdolescent();
    }
  
    public final void setSignatureElu(final String signatureElu) {
        saintouenCapJeunesseEnfantRequestData.setSignatureElu(signatureElu);
    }

    
    public final String getSignatureElu() {
        return saintouenCapJeunesseEnfantRequestData.getSignatureElu();
    }
  
    public final void setSignatureResponsableLegal(final String signatureResponsableLegal) {
        saintouenCapJeunesseEnfantRequestData.setSignatureResponsableLegal(signatureResponsableLegal);
    }

    
    public final String getSignatureResponsableLegal() {
        return saintouenCapJeunesseEnfantRequestData.getSignatureResponsableLegal();
    }
  
    public final void setTelephonePortable(final String telephonePortable) {
        saintouenCapJeunesseEnfantRequestData.setTelephonePortable(telephonePortable);
    }

    
    public final String getTelephonePortable() {
        return saintouenCapJeunesseEnfantRequestData.getTelephonePortable();
    }
  
    public final void setTypeEtablissementScolaireFrenquente(final fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType typeEtablissementScolaireFrenquente) {
        saintouenCapJeunesseEnfantRequestData.setTypeEtablissementScolaireFrenquente(typeEtablissementScolaireFrenquente);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjerTypeEtablissementScolaireType getTypeEtablissementScolaireFrenquente() {
        return saintouenCapJeunesseEnfantRequestData.getTypeEtablissementScolaireFrenquente();
    }
  
    public final void setTypeInscription(final fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType typeInscription) {
        saintouenCapJeunesseEnfantRequestData.setTypeInscription(typeInscription);
    }

    
    public final fr.cg95.cvq.business.request.school.ScjerTypeInscriptionType getTypeInscription() {
        return saintouenCapJeunesseEnfantRequestData.getTypeInscription();
    }
  
}

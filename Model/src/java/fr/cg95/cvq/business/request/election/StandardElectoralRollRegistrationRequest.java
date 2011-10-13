
package fr.cg95.cvq.business.request.election;

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
import fr.cg95.cvq.xml.request.election.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class StandardElectoralRollRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = StandardElectoralRollRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private StandardElectoralRollRegistrationRequestData standardElectoralRollRegistrationRequestData;

    public StandardElectoralRollRegistrationRequest(RequestData requestData, StandardElectoralRollRegistrationRequestData standardElectoralRollRegistrationRequestData) {
        super(requestData);
        this.standardElectoralRollRegistrationRequestData = standardElectoralRollRegistrationRequestData;
    }

    public StandardElectoralRollRegistrationRequest() {
        super();
        this.standardElectoralRollRegistrationRequestData = new StandardElectoralRollRegistrationRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("inscription", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("situation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("radiation", stepState);
        
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
    public StandardElectoralRollRegistrationRequestData getSpecificData() {
        return standardElectoralRollRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(StandardElectoralRollRegistrationRequestData standardElectoralRollRegistrationRequestData) {
        this.standardElectoralRollRegistrationRequestData = standardElectoralRollRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        StandardElectoralRollRegistrationRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final StandardElectoralRollRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        StandardElectoralRollRegistrationRequestDocument standardElectoralRollRegistrationRequestDoc = StandardElectoralRollRegistrationRequestDocument.Factory.newInstance();
        StandardElectoralRollRegistrationRequestDocument.StandardElectoralRollRegistrationRequest standardElectoralRollRegistrationRequest = standardElectoralRollRegistrationRequestDoc.addNewStandardElectoralRollRegistrationRequest();
        super.fillCommonXmlInfo(standardElectoralRollRegistrationRequest);
        int i = 0;
        
        standardElectoralRollRegistrationRequest.setAmbassadeOuPosteConsulaire(getAmbassadeOuPosteConsulaire());
        SerrrPrecedentLieuInscriptionType serrrPrecedentLieuInscriptionTypePrecedentLieuInscription = standardElectoralRollRegistrationRequest.addNewPrecedentLieuInscription();
        serrrPrecedentLieuInscriptionTypePrecedentLieuInscription.setAncienneCommune(getAncienneCommune());
        SerrrLieuDerniereInscriptionType serrrLieuDerniereInscriptionTypeLieuDerniereInscription = standardElectoralRollRegistrationRequest.addNewLieuDerniereInscription();
        serrrLieuDerniereInscriptionTypeLieuDerniereInscription.setCommuneOuLocalitePrecedente(getCommuneOuLocalitePrecedente());
      
        date = getDateNaissance();
        if (date != null) {
            calendar.setTime(date);
            standardElectoralRollRegistrationRequest.setDateNaissance(calendar);
        }
      
        if (getDepartementAncienneCommune() != null)
            serrrPrecedentLieuInscriptionTypePrecedentLieuInscription.setDepartementAncienneCommune(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(getDepartementAncienneCommune().getLegacyLabel()));
      
        standardElectoralRollRegistrationRequest.setDeuxiemePrenom(getDeuxiemePrenom());
        SerrrLieuNaissanceType serrrLieuNaissanceTypeLieuNaissance = standardElectoralRollRegistrationRequest.addNewLieuNaissance();
        if (getLieuNaissanceDepartement() != null)
            serrrLieuNaissanceTypeLieuNaissance.setLieuNaissanceDepartement(fr.cg95.cvq.xml.common.InseeDepartementCodeType.Enum.forString(getLieuNaissanceDepartement().getLegacyLabel()));
      
        if (getLieuNaissancePays() != null)
            serrrLieuNaissanceTypeLieuNaissance.setLieuNaissancePays(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getLieuNaissancePays().getLegacyLabel()));
      
        if (getNationalite() != null)
            standardElectoralRollRegistrationRequest.setNationalite(fr.cg95.cvq.xml.request.election.SerrrNationaliteType.Enum.forString(getNationalite().getLegacyLabel()));
      
        standardElectoralRollRegistrationRequest.setNomMarital(getNomMarital());
      
        standardElectoralRollRegistrationRequest.setNomNaissance(getNomNaissance());
      
        if (getPaysPrecedent() != null)
            serrrLieuDerniereInscriptionTypeLieuDerniereInscription.setPaysPrecedent(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getPaysPrecedent().getLegacyLabel()));
      
        if (getPaysRadiation() != null)
            standardElectoralRollRegistrationRequest.setPaysRadiation(fr.cg95.cvq.xml.common.CountryType.Enum.forString(getPaysRadiation().getLegacyLabel()));
      
        if (getPrecisionNationalite() != null)
            standardElectoralRollRegistrationRequest.setPrecisionNationalite(fr.cg95.cvq.xml.request.election.SerrrPrecisionNationaliteType.Enum.forString(getPrecisionNationalite().getLegacyLabel()));
      
        standardElectoralRollRegistrationRequest.setPrenom(getPrenom());
      
        if (getSexe() != null)
            standardElectoralRollRegistrationRequest.setSexe(fr.cg95.cvq.xml.request.election.SerrrSexeType.Enum.forString(getSexe().getLegacyLabel()));
      
        if (getSituation() != null)
            standardElectoralRollRegistrationRequest.setSituation(fr.cg95.cvq.xml.request.election.SerrrSituationType.Enum.forString(getSituation().getLegacyLabel()));
      
        serrrLieuDerniereInscriptionTypeLieuDerniereInscription.setSubdivisionAdministrativePrecedente(getSubdivisionAdministrativePrecedente());
      
        standardElectoralRollRegistrationRequest.setTroisiemePrenom(getTroisiemePrenom());
      
        if (getTypeElection() != null)
            standardElectoralRollRegistrationRequest.setTypeElection(fr.cg95.cvq.xml.request.election.SerrrTypeElectionType.Enum.forString(getTypeElection().getLegacyLabel()));
      
        if (getTypeInscription() != null)
            standardElectoralRollRegistrationRequest.setTypeInscription(fr.cg95.cvq.xml.request.election.SerrrTypeInscriptionType.Enum.forString(getTypeInscription().getLegacyLabel()));
      
        serrrLieuNaissanceTypeLieuNaissance.setVilleNaissanceCodePostal(getVilleNaissanceCodePostal());
      
        return standardElectoralRollRegistrationRequestDoc;
    }

    @Override
    public final StandardElectoralRollRegistrationRequestDocument.StandardElectoralRollRegistrationRequest modelToXmlRequest() {
        return modelToXml().getStandardElectoralRollRegistrationRequest();
    }

    public static StandardElectoralRollRegistrationRequest xmlToModel(StandardElectoralRollRegistrationRequestDocument standardElectoralRollRegistrationRequestDoc) {
        StandardElectoralRollRegistrationRequestDocument.StandardElectoralRollRegistrationRequest standardElectoralRollRegistrationRequestXml = standardElectoralRollRegistrationRequestDoc.getStandardElectoralRollRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        StandardElectoralRollRegistrationRequest standardElectoralRollRegistrationRequest = new StandardElectoralRollRegistrationRequest();
        standardElectoralRollRegistrationRequest.fillCommonModelInfo(standardElectoralRollRegistrationRequest, standardElectoralRollRegistrationRequestXml);
        
        standardElectoralRollRegistrationRequest.setAmbassadeOuPosteConsulaire(standardElectoralRollRegistrationRequestXml.getAmbassadeOuPosteConsulaire());
      
        standardElectoralRollRegistrationRequest.setAncienneCommune(standardElectoralRollRegistrationRequestXml.getPrecedentLieuInscription().getAncienneCommune());
      
        standardElectoralRollRegistrationRequest.setCommuneOuLocalitePrecedente(standardElectoralRollRegistrationRequestXml.getLieuDerniereInscription().getCommuneOuLocalitePrecedente());
      
        calendar = standardElectoralRollRegistrationRequestXml.getDateNaissance();
        if (calendar != null) {
            standardElectoralRollRegistrationRequest.setDateNaissance(calendar.getTime());
        }
      
        if (standardElectoralRollRegistrationRequestXml.getPrecedentLieuInscription().getDepartementAncienneCommune() != null)
            standardElectoralRollRegistrationRequest.setDepartementAncienneCommune(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(standardElectoralRollRegistrationRequestXml.getPrecedentLieuInscription().getDepartementAncienneCommune().toString()));
        else
            standardElectoralRollRegistrationRequest.setDepartementAncienneCommune(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
        standardElectoralRollRegistrationRequest.setDeuxiemePrenom(standardElectoralRollRegistrationRequestXml.getDeuxiemePrenom());
      
        if (standardElectoralRollRegistrationRequestXml.getLieuNaissance().getLieuNaissanceDepartement() != null)
            standardElectoralRollRegistrationRequest.setLieuNaissanceDepartement(fr.cg95.cvq.business.users.InseeDepartementCodeType.forString(standardElectoralRollRegistrationRequestXml.getLieuNaissance().getLieuNaissanceDepartement().toString()));
        else
            standardElectoralRollRegistrationRequest.setLieuNaissanceDepartement(fr.cg95.cvq.business.users.InseeDepartementCodeType.getDefaultInseeDepartementCodeType());
      
        if (standardElectoralRollRegistrationRequestXml.getLieuNaissance().getLieuNaissancePays() != null)
            standardElectoralRollRegistrationRequest.setLieuNaissancePays(fr.cg95.cvq.business.users.CountryType.forString(standardElectoralRollRegistrationRequestXml.getLieuNaissance().getLieuNaissancePays().toString()));
        else
            standardElectoralRollRegistrationRequest.setLieuNaissancePays(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (standardElectoralRollRegistrationRequestXml.getNationalite() != null)
            standardElectoralRollRegistrationRequest.setNationalite(fr.cg95.cvq.business.request.election.SerrrNationaliteType.forString(standardElectoralRollRegistrationRequestXml.getNationalite().toString()));
        else
            standardElectoralRollRegistrationRequest.setNationalite(fr.cg95.cvq.business.request.election.SerrrNationaliteType.getDefaultSerrrNationaliteType());
      
        standardElectoralRollRegistrationRequest.setNomMarital(standardElectoralRollRegistrationRequestXml.getNomMarital());
      
        standardElectoralRollRegistrationRequest.setNomNaissance(standardElectoralRollRegistrationRequestXml.getNomNaissance());
      
        if (standardElectoralRollRegistrationRequestXml.getLieuDerniereInscription().getPaysPrecedent() != null)
            standardElectoralRollRegistrationRequest.setPaysPrecedent(fr.cg95.cvq.business.users.CountryType.forString(standardElectoralRollRegistrationRequestXml.getLieuDerniereInscription().getPaysPrecedent().toString()));
        else
            standardElectoralRollRegistrationRequest.setPaysPrecedent(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (standardElectoralRollRegistrationRequestXml.getPaysRadiation() != null)
            standardElectoralRollRegistrationRequest.setPaysRadiation(fr.cg95.cvq.business.users.CountryType.forString(standardElectoralRollRegistrationRequestXml.getPaysRadiation().toString()));
        else
            standardElectoralRollRegistrationRequest.setPaysRadiation(fr.cg95.cvq.business.users.CountryType.getDefaultCountryType());
      
        if (standardElectoralRollRegistrationRequestXml.getPrecisionNationalite() != null)
            standardElectoralRollRegistrationRequest.setPrecisionNationalite(fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType.forString(standardElectoralRollRegistrationRequestXml.getPrecisionNationalite().toString()));
        else
            standardElectoralRollRegistrationRequest.setPrecisionNationalite(fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType.getDefaultSerrrPrecisionNationaliteType());
      
        standardElectoralRollRegistrationRequest.setPrenom(standardElectoralRollRegistrationRequestXml.getPrenom());
      
        if (standardElectoralRollRegistrationRequestXml.getSexe() != null)
            standardElectoralRollRegistrationRequest.setSexe(fr.cg95.cvq.business.request.election.SerrrSexeType.forString(standardElectoralRollRegistrationRequestXml.getSexe().toString()));
        else
            standardElectoralRollRegistrationRequest.setSexe(fr.cg95.cvq.business.request.election.SerrrSexeType.getDefaultSerrrSexeType());
      
        if (standardElectoralRollRegistrationRequestXml.getSituation() != null)
            standardElectoralRollRegistrationRequest.setSituation(fr.cg95.cvq.business.request.election.SerrrSituationType.forString(standardElectoralRollRegistrationRequestXml.getSituation().toString()));
        else
            standardElectoralRollRegistrationRequest.setSituation(fr.cg95.cvq.business.request.election.SerrrSituationType.getDefaultSerrrSituationType());
      
        standardElectoralRollRegistrationRequest.setSubdivisionAdministrativePrecedente(standardElectoralRollRegistrationRequestXml.getLieuDerniereInscription().getSubdivisionAdministrativePrecedente());
      
        standardElectoralRollRegistrationRequest.setTroisiemePrenom(standardElectoralRollRegistrationRequestXml.getTroisiemePrenom());
      
        if (standardElectoralRollRegistrationRequestXml.getTypeElection() != null)
            standardElectoralRollRegistrationRequest.setTypeElection(fr.cg95.cvq.business.request.election.SerrrTypeElectionType.forString(standardElectoralRollRegistrationRequestXml.getTypeElection().toString()));
        else
            standardElectoralRollRegistrationRequest.setTypeElection(fr.cg95.cvq.business.request.election.SerrrTypeElectionType.getDefaultSerrrTypeElectionType());
      
        if (standardElectoralRollRegistrationRequestXml.getTypeInscription() != null)
            standardElectoralRollRegistrationRequest.setTypeInscription(fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType.forString(standardElectoralRollRegistrationRequestXml.getTypeInscription().toString()));
        else
            standardElectoralRollRegistrationRequest.setTypeInscription(fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType.getDefaultSerrrTypeInscriptionType());
      
        standardElectoralRollRegistrationRequest.setVilleNaissanceCodePostal(standardElectoralRollRegistrationRequestXml.getLieuNaissance().getVilleNaissanceCodePostal());
      
        return standardElectoralRollRegistrationRequest;
    }

    @Override
    public StandardElectoralRollRegistrationRequest clone() {
        StandardElectoralRollRegistrationRequest clone = new StandardElectoralRollRegistrationRequest(getRequestData().clone(), standardElectoralRollRegistrationRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("inscription", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("situation", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", false);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("radiation", stepState);
        
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

  
    public final void setAmbassadeOuPosteConsulaire(final String ambassadeOuPosteConsulaire) {
        standardElectoralRollRegistrationRequestData.setAmbassadeOuPosteConsulaire(ambassadeOuPosteConsulaire);
    }

    
    public final String getAmbassadeOuPosteConsulaire() {
        return standardElectoralRollRegistrationRequestData.getAmbassadeOuPosteConsulaire();
    }
  
    public final void setAncienneCommune(final String ancienneCommune) {
        standardElectoralRollRegistrationRequestData.setAncienneCommune(ancienneCommune);
    }

    
    public final String getAncienneCommune() {
        return standardElectoralRollRegistrationRequestData.getAncienneCommune();
    }
  
    public final void setCommuneOuLocalitePrecedente(final String communeOuLocalitePrecedente) {
        standardElectoralRollRegistrationRequestData.setCommuneOuLocalitePrecedente(communeOuLocalitePrecedente);
    }

    
    public final String getCommuneOuLocalitePrecedente() {
        return standardElectoralRollRegistrationRequestData.getCommuneOuLocalitePrecedente();
    }
  
    public final void setDateNaissance(final java.util.Date dateNaissance) {
        standardElectoralRollRegistrationRequestData.setDateNaissance(dateNaissance);
    }

    
    public final java.util.Date getDateNaissance() {
        return standardElectoralRollRegistrationRequestData.getDateNaissance();
    }
  
    public final void setDepartementAncienneCommune(final fr.cg95.cvq.business.users.InseeDepartementCodeType departementAncienneCommune) {
        standardElectoralRollRegistrationRequestData.setDepartementAncienneCommune(departementAncienneCommune);
    }

    
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getDepartementAncienneCommune() {
        return standardElectoralRollRegistrationRequestData.getDepartementAncienneCommune();
    }
  
    public final void setDeuxiemePrenom(final String deuxiemePrenom) {
        standardElectoralRollRegistrationRequestData.setDeuxiemePrenom(deuxiemePrenom);
    }

    
    public final String getDeuxiemePrenom() {
        return standardElectoralRollRegistrationRequestData.getDeuxiemePrenom();
    }
  
    public final void setLieuNaissanceDepartement(final fr.cg95.cvq.business.users.InseeDepartementCodeType lieuNaissanceDepartement) {
        standardElectoralRollRegistrationRequestData.setLieuNaissanceDepartement(lieuNaissanceDepartement);
    }

    
    public final fr.cg95.cvq.business.users.InseeDepartementCodeType getLieuNaissanceDepartement() {
        return standardElectoralRollRegistrationRequestData.getLieuNaissanceDepartement();
    }
  
    public final void setLieuNaissancePays(final fr.cg95.cvq.business.users.CountryType lieuNaissancePays) {
        standardElectoralRollRegistrationRequestData.setLieuNaissancePays(lieuNaissancePays);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getLieuNaissancePays() {
        return standardElectoralRollRegistrationRequestData.getLieuNaissancePays();
    }
  
    public final void setNationalite(final fr.cg95.cvq.business.request.election.SerrrNationaliteType nationalite) {
        standardElectoralRollRegistrationRequestData.setNationalite(nationalite);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrNationaliteType getNationalite() {
        return standardElectoralRollRegistrationRequestData.getNationalite();
    }
  
    public final void setNomMarital(final String nomMarital) {
        standardElectoralRollRegistrationRequestData.setNomMarital(nomMarital);
    }

    
    public final String getNomMarital() {
        return standardElectoralRollRegistrationRequestData.getNomMarital();
    }
  
    public final void setNomNaissance(final String nomNaissance) {
        standardElectoralRollRegistrationRequestData.setNomNaissance(nomNaissance);
    }

    
    public final String getNomNaissance() {
        return standardElectoralRollRegistrationRequestData.getNomNaissance();
    }
  
    public final void setPaysPrecedent(final fr.cg95.cvq.business.users.CountryType paysPrecedent) {
        standardElectoralRollRegistrationRequestData.setPaysPrecedent(paysPrecedent);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getPaysPrecedent() {
        return standardElectoralRollRegistrationRequestData.getPaysPrecedent();
    }
  
    public final void setPaysRadiation(final fr.cg95.cvq.business.users.CountryType paysRadiation) {
        standardElectoralRollRegistrationRequestData.setPaysRadiation(paysRadiation);
    }

    
    public final fr.cg95.cvq.business.users.CountryType getPaysRadiation() {
        return standardElectoralRollRegistrationRequestData.getPaysRadiation();
    }
  
    public final void setPrecisionNationalite(final fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType precisionNationalite) {
        standardElectoralRollRegistrationRequestData.setPrecisionNationalite(precisionNationalite);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrPrecisionNationaliteType getPrecisionNationalite() {
        return standardElectoralRollRegistrationRequestData.getPrecisionNationalite();
    }
  
    public final void setPrenom(final String prenom) {
        standardElectoralRollRegistrationRequestData.setPrenom(prenom);
    }

    
    public final String getPrenom() {
        return standardElectoralRollRegistrationRequestData.getPrenom();
    }
  
    public final void setSexe(final fr.cg95.cvq.business.request.election.SerrrSexeType sexe) {
        standardElectoralRollRegistrationRequestData.setSexe(sexe);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrSexeType getSexe() {
        return standardElectoralRollRegistrationRequestData.getSexe();
    }
  
    public final void setSituation(final fr.cg95.cvq.business.request.election.SerrrSituationType situation) {
        standardElectoralRollRegistrationRequestData.setSituation(situation);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrSituationType getSituation() {
        return standardElectoralRollRegistrationRequestData.getSituation();
    }
  
    public final void setSubdivisionAdministrativePrecedente(final String subdivisionAdministrativePrecedente) {
        standardElectoralRollRegistrationRequestData.setSubdivisionAdministrativePrecedente(subdivisionAdministrativePrecedente);
    }

    
    public final String getSubdivisionAdministrativePrecedente() {
        return standardElectoralRollRegistrationRequestData.getSubdivisionAdministrativePrecedente();
    }
  
    public final void setTroisiemePrenom(final String troisiemePrenom) {
        standardElectoralRollRegistrationRequestData.setTroisiemePrenom(troisiemePrenom);
    }

    
    public final String getTroisiemePrenom() {
        return standardElectoralRollRegistrationRequestData.getTroisiemePrenom();
    }
  
    public final void setTypeElection(final fr.cg95.cvq.business.request.election.SerrrTypeElectionType typeElection) {
        standardElectoralRollRegistrationRequestData.setTypeElection(typeElection);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrTypeElectionType getTypeElection() {
        return standardElectoralRollRegistrationRequestData.getTypeElection();
    }
  
    public final void setTypeInscription(final fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType typeInscription) {
        standardElectoralRollRegistrationRequestData.setTypeInscription(typeInscription);
    }

    
    public final fr.cg95.cvq.business.request.election.SerrrTypeInscriptionType getTypeInscription() {
        return standardElectoralRollRegistrationRequestData.getTypeInscription();
    }
  
    public final void setVilleNaissanceCodePostal(final String villeNaissanceCodePostal) {
        standardElectoralRollRegistrationRequestData.setVilleNaissanceCodePostal(villeNaissanceCodePostal);
    }

    
    public final String getVilleNaissanceCodePostal() {
        return standardElectoralRollRegistrationRequestData.getVilleNaissanceCodePostal();
    }
  
}

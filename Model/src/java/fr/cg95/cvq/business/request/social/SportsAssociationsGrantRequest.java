
package fr.cg95.cvq.business.request.social;

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
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class SportsAssociationsGrantRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = SportsAssociationsGrantRequestData.conditions;

    @AssertValid(message = "")
    private SportsAssociationsGrantRequestData sportsAssociationsGrantRequestData;

    public SportsAssociationsGrantRequest(RequestData requestData, SportsAssociationsGrantRequestData sportsAssociationsGrantRequestData) {
        super(requestData);
        this.sportsAssociationsGrantRequestData = sportsAssociationsGrantRequestData;
    }

    public SportsAssociationsGrantRequest() {
        super();
        this.sportsAssociationsGrantRequestData = new SportsAssociationsGrantRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("association", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("president", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("bureau", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("activites", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("subvention", stepState);
        
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
    public SportsAssociationsGrantRequestData getSpecificData() {
        return sportsAssociationsGrantRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(SportsAssociationsGrantRequestData sportsAssociationsGrantRequestData) {
        this.sportsAssociationsGrantRequestData = sportsAssociationsGrantRequestData;
    }

    @Override
    public final String modelToXmlString() {
        SportsAssociationsGrantRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final SportsAssociationsGrantRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        SportsAssociationsGrantRequestDocument sportsAssociationsGrantRequestDoc = SportsAssociationsGrantRequestDocument.Factory.newInstance();
        SportsAssociationsGrantRequestDocument.SportsAssociationsGrantRequest sportsAssociationsGrantRequest = sportsAssociationsGrantRequestDoc.addNewSportsAssociationsGrantRequest();
        super.fillCommonXmlInfo(sportsAssociationsGrantRequest);
        int i = 0;
          SagrContactsAssociationType sagrContactsAssociationTypeContactsAssociation = sportsAssociationsGrantRequest.addNewContactsAssociation();
        if (getAdresseCorrespondantPrincipal() != null)
            sagrContactsAssociationTypeContactsAssociation.setAdresseCorrespondantPrincipal(Address.modelToXml(getAdresseCorrespondantPrincipal()));
      
        i = 0;
        if (getAutreMembreBureau() != null) {
            fr.cg95.cvq.xml.request.social.SagrMembreBureauType[] autreMembreBureauTypeTab = new fr.cg95.cvq.xml.request.social.SagrMembreBureauType[getAutreMembreBureau().size()];
            for (SagrMembreBureau object : getAutreMembreBureau()) {
              autreMembreBureauTypeTab[i++] = object.modelToXml();
            }
            sportsAssociationsGrantRequest.setAutreMembreBureauArray(autreMembreBureauTypeTab);
        }
        SagrSubventionPubliqueFonctionnementType sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement = sportsAssociationsGrantRequest.addNewSubventionPubliqueFonctionnement();
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setBudgetSaisonEcouleeDepenses(getBudgetSaisonEcouleeDepenses());
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setBudgetSaisonEcouleeRecette(getBudgetSaisonEcouleeRecette());
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setCommuneAnneeN(getCommuneAnneeN());
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setCommuneAnneeNPlusUn(getCommuneAnneeNPlusUn());
      
        if (getCompteBancaire() != null)
            sportsAssociationsGrantRequest.setCompteBancaire(BankAccount.modelToXml(getCompteBancaire()));
      
        sagrContactsAssociationTypeContactsAssociation.setEmailClubOuCorrespondant(getEmailClubOuCorrespondant());
        SagrPrecisionPresidentType sagrPrecisionPresidentTypePrecisionPresident = sportsAssociationsGrantRequest.addNewPrecisionPresident();
        sagrPrecisionPresidentTypePrecisionPresident.setEmailPresident(getEmailPresident());
      
        if (getEstAdresseCorrespondantPrincipal() != null)
            sagrContactsAssociationTypeContactsAssociation.setEstAdresseCorrespondantPrincipal(getEstAdresseCorrespondantPrincipal().booleanValue());
      
        sportsAssociationsGrantRequest.setMontantSubvention(getMontantSubvention());
      
        sportsAssociationsGrantRequest.setNomAssociation(getNomAssociation());
      
        sagrContactsAssociationTypeContactsAssociation.setNomCompletCorrespondantPrincipal(getNomCompletCorrespondantPrincipal());
      
        sagrPrecisionPresidentTypePrecisionPresident.setNomPresident(getNomPresident());
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setNombreLicencieMoinsDixHuitSaisonEcoulee(getNombreLicencieMoinsDixHuitSaisonEcoulee());
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setNombreLicenciePlusDixHuitSaisonEcoulee(getNombreLicenciePlusDixHuitSaisonEcoulee());
      
        sportsAssociationsGrantRequest.setNumeroEnregistrementAssociation(getNumeroEnregistrementAssociation());
        SagrNumerosAssociationType sagrNumerosAssociationTypeNumerosAssociation = sportsAssociationsGrantRequest.addNewNumerosAssociation();
        sagrNumerosAssociationTypeNumerosAssociation.setNumeroEnregistrementPrefectureAssociation(getNumeroEnregistrementPrefectureAssociation());
      
        sagrNumerosAssociationTypeNumerosAssociation.setNumeroSiretAssociation(getNumeroSiretAssociation());
      
        sagrPrecisionPresidentTypePrecisionPresident.setPrenomPresident(getPrenomPresident());
      
        if (getRoleDemandeur() != null)
            sportsAssociationsGrantRequest.setRoleDemandeur(fr.cg95.cvq.xml.request.social.SagrRoleAssociationType.Enum.forString(getRoleDemandeur().getLegacyLabel()));
      
        i = 0;
        if (getSagrActiviteAssociation() != null) {
            fr.cg95.cvq.xml.request.social.SagrActiviteAssociationType[] sagrActiviteAssociationTypeTab = new fr.cg95.cvq.xml.request.social.SagrActiviteAssociationType[getSagrActiviteAssociation().size()];
            for (SagrActiviteAssociation object : getSagrActiviteAssociation()) {
              sagrActiviteAssociationTypeTab[i++] = object.modelToXml();
            }
            sportsAssociationsGrantRequest.setSagrActiviteAssociationArray(sagrActiviteAssociationTypeTab);
        }
      
        if (getSiegeSocialAssociation() != null)
            sportsAssociationsGrantRequest.setSiegeSocialAssociation(Address.modelToXml(getSiegeSocialAssociation()));
      
        sagrSubventionPubliqueFonctionnementTypeSubventionPubliqueFonctionnement.setSubventionSolliciteConseilGeneral(getSubventionSolliciteConseilGeneral());
      
        sagrPrecisionPresidentTypePrecisionPresident.setTelephonePresident(getTelephonePresident());
      
        return sportsAssociationsGrantRequestDoc;
    }

    @Override
    public final SportsAssociationsGrantRequestDocument.SportsAssociationsGrantRequest modelToXmlRequest() {
        return modelToXml().getSportsAssociationsGrantRequest();
    }

    public static SportsAssociationsGrantRequest xmlToModel(SportsAssociationsGrantRequestDocument sportsAssociationsGrantRequestDoc) {
        SportsAssociationsGrantRequestDocument.SportsAssociationsGrantRequest sportsAssociationsGrantRequestXml = sportsAssociationsGrantRequestDoc.getSportsAssociationsGrantRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        SportsAssociationsGrantRequest sportsAssociationsGrantRequest = new SportsAssociationsGrantRequest();
        sportsAssociationsGrantRequest.fillCommonModelInfo(sportsAssociationsGrantRequest, sportsAssociationsGrantRequestXml);
        
        if (sportsAssociationsGrantRequestXml.getContactsAssociation().getAdresseCorrespondantPrincipal() != null)
            sportsAssociationsGrantRequest.setAdresseCorrespondantPrincipal(Address.xmlToModel(sportsAssociationsGrantRequestXml.getContactsAssociation().getAdresseCorrespondantPrincipal()));
      
        List<fr.cg95.cvq.business.request.social.SagrMembreBureau> autreMembreBureauList = new ArrayList<fr.cg95.cvq.business.request.social.SagrMembreBureau>(sportsAssociationsGrantRequestXml.sizeOfAutreMembreBureauArray());
        for (SagrMembreBureauType object : sportsAssociationsGrantRequestXml.getAutreMembreBureauArray()) {
            autreMembreBureauList.add(fr.cg95.cvq.business.request.social.SagrMembreBureau.xmlToModel(object));
        }
        sportsAssociationsGrantRequest.setAutreMembreBureau(autreMembreBureauList);
      
        sportsAssociationsGrantRequest.setBudgetSaisonEcouleeDepenses(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getBudgetSaisonEcouleeDepenses());
      
        sportsAssociationsGrantRequest.setBudgetSaisonEcouleeRecette(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getBudgetSaisonEcouleeRecette());
      
        sportsAssociationsGrantRequest.setCommuneAnneeN(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getCommuneAnneeN());
      
        sportsAssociationsGrantRequest.setCommuneAnneeNPlusUn(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getCommuneAnneeNPlusUn());
      
        if (sportsAssociationsGrantRequestXml.getCompteBancaire() != null)
            sportsAssociationsGrantRequest.setCompteBancaire(BankAccount.xmlToModel(sportsAssociationsGrantRequestXml.getCompteBancaire()));
      
        sportsAssociationsGrantRequest.setEmailClubOuCorrespondant(sportsAssociationsGrantRequestXml.getContactsAssociation().getEmailClubOuCorrespondant());
      
        sportsAssociationsGrantRequest.setEmailPresident(sportsAssociationsGrantRequestXml.getPrecisionPresident().getEmailPresident());
      
        sportsAssociationsGrantRequest.setEstAdresseCorrespondantPrincipal(Boolean.valueOf(sportsAssociationsGrantRequestXml.getContactsAssociation().getEstAdresseCorrespondantPrincipal()));
      
        sportsAssociationsGrantRequest.setMontantSubvention(sportsAssociationsGrantRequestXml.getMontantSubvention());
      
        sportsAssociationsGrantRequest.setNomAssociation(sportsAssociationsGrantRequestXml.getNomAssociation());
      
        sportsAssociationsGrantRequest.setNomCompletCorrespondantPrincipal(sportsAssociationsGrantRequestXml.getContactsAssociation().getNomCompletCorrespondantPrincipal());
      
        sportsAssociationsGrantRequest.setNomPresident(sportsAssociationsGrantRequestXml.getPrecisionPresident().getNomPresident());
      
        sportsAssociationsGrantRequest.setNombreLicencieMoinsDixHuitSaisonEcoulee(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getNombreLicencieMoinsDixHuitSaisonEcoulee());
      
        sportsAssociationsGrantRequest.setNombreLicenciePlusDixHuitSaisonEcoulee(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getNombreLicenciePlusDixHuitSaisonEcoulee());
      
        sportsAssociationsGrantRequest.setNumeroEnregistrementAssociation(sportsAssociationsGrantRequestXml.getNumeroEnregistrementAssociation());
      
        sportsAssociationsGrantRequest.setNumeroEnregistrementPrefectureAssociation(sportsAssociationsGrantRequestXml.getNumerosAssociation().getNumeroEnregistrementPrefectureAssociation());
      
        sportsAssociationsGrantRequest.setNumeroSiretAssociation(sportsAssociationsGrantRequestXml.getNumerosAssociation().getNumeroSiretAssociation());
      
        sportsAssociationsGrantRequest.setPrenomPresident(sportsAssociationsGrantRequestXml.getPrecisionPresident().getPrenomPresident());
      
        if (sportsAssociationsGrantRequestXml.getRoleDemandeur() != null)
            sportsAssociationsGrantRequest.setRoleDemandeur(fr.cg95.cvq.business.request.social.SagrRoleAssociationType.forString(sportsAssociationsGrantRequestXml.getRoleDemandeur().toString()));
        else
            sportsAssociationsGrantRequest.setRoleDemandeur(fr.cg95.cvq.business.request.social.SagrRoleAssociationType.getDefaultSagrRoleAssociationType());
      
        List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> sagrActiviteAssociationList = new ArrayList<fr.cg95.cvq.business.request.social.SagrActiviteAssociation>(sportsAssociationsGrantRequestXml.sizeOfSagrActiviteAssociationArray());
        for (SagrActiviteAssociationType object : sportsAssociationsGrantRequestXml.getSagrActiviteAssociationArray()) {
            sagrActiviteAssociationList.add(fr.cg95.cvq.business.request.social.SagrActiviteAssociation.xmlToModel(object));
        }
        sportsAssociationsGrantRequest.setSagrActiviteAssociation(sagrActiviteAssociationList);
      
        if (sportsAssociationsGrantRequestXml.getSiegeSocialAssociation() != null)
            sportsAssociationsGrantRequest.setSiegeSocialAssociation(Address.xmlToModel(sportsAssociationsGrantRequestXml.getSiegeSocialAssociation()));
      
        sportsAssociationsGrantRequest.setSubventionSolliciteConseilGeneral(sportsAssociationsGrantRequestXml.getSubventionPubliqueFonctionnement().getSubventionSolliciteConseilGeneral());
      
        sportsAssociationsGrantRequest.setTelephonePresident(sportsAssociationsGrantRequestXml.getPrecisionPresident().getTelephonePresident());
      
        return sportsAssociationsGrantRequest;
    }

    @Override
    public SportsAssociationsGrantRequest clone() {
        SportsAssociationsGrantRequest clone = new SportsAssociationsGrantRequest(getRequestData().clone(), sportsAssociationsGrantRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("association", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("president", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("bureau", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("activites", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("subvention", stepState);
        
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

  
    public final void setAdresseCorrespondantPrincipal(final fr.cg95.cvq.business.users.Address adresseCorrespondantPrincipal) {
        sportsAssociationsGrantRequestData.setAdresseCorrespondantPrincipal(adresseCorrespondantPrincipal);
    }

    
    public final fr.cg95.cvq.business.users.Address getAdresseCorrespondantPrincipal() {
        return sportsAssociationsGrantRequestData.getAdresseCorrespondantPrincipal();
    }
  
    public final void setAutreMembreBureau(final List<fr.cg95.cvq.business.request.social.SagrMembreBureau> autreMembreBureau) {
        sportsAssociationsGrantRequestData.setAutreMembreBureau(autreMembreBureau);
    }

    
    public final List<fr.cg95.cvq.business.request.social.SagrMembreBureau> getAutreMembreBureau() {
        return sportsAssociationsGrantRequestData.getAutreMembreBureau();
    }
  
    public final void setBudgetSaisonEcouleeDepenses(final String budgetSaisonEcouleeDepenses) {
        sportsAssociationsGrantRequestData.setBudgetSaisonEcouleeDepenses(budgetSaisonEcouleeDepenses);
    }

    
    public final String getBudgetSaisonEcouleeDepenses() {
        return sportsAssociationsGrantRequestData.getBudgetSaisonEcouleeDepenses();
    }
  
    public final void setBudgetSaisonEcouleeRecette(final String budgetSaisonEcouleeRecette) {
        sportsAssociationsGrantRequestData.setBudgetSaisonEcouleeRecette(budgetSaisonEcouleeRecette);
    }

    
    public final String getBudgetSaisonEcouleeRecette() {
        return sportsAssociationsGrantRequestData.getBudgetSaisonEcouleeRecette();
    }
  
    public final void setCommuneAnneeN(final String communeAnneeN) {
        sportsAssociationsGrantRequestData.setCommuneAnneeN(communeAnneeN);
    }

    
    public final String getCommuneAnneeN() {
        return sportsAssociationsGrantRequestData.getCommuneAnneeN();
    }
  
    public final void setCommuneAnneeNPlusUn(final String communeAnneeNPlusUn) {
        sportsAssociationsGrantRequestData.setCommuneAnneeNPlusUn(communeAnneeNPlusUn);
    }

    
    public final String getCommuneAnneeNPlusUn() {
        return sportsAssociationsGrantRequestData.getCommuneAnneeNPlusUn();
    }
  
    public final void setCompteBancaire(final fr.cg95.cvq.business.users.BankAccount compteBancaire) {
        sportsAssociationsGrantRequestData.setCompteBancaire(compteBancaire);
    }

    
    public final fr.cg95.cvq.business.users.BankAccount getCompteBancaire() {
        return sportsAssociationsGrantRequestData.getCompteBancaire();
    }
  
    public final void setEmailClubOuCorrespondant(final String emailClubOuCorrespondant) {
        sportsAssociationsGrantRequestData.setEmailClubOuCorrespondant(emailClubOuCorrespondant);
    }

    
    public final String getEmailClubOuCorrespondant() {
        return sportsAssociationsGrantRequestData.getEmailClubOuCorrespondant();
    }
  
    public final void setEmailPresident(final String emailPresident) {
        sportsAssociationsGrantRequestData.setEmailPresident(emailPresident);
    }

    
    public final String getEmailPresident() {
        return sportsAssociationsGrantRequestData.getEmailPresident();
    }
  
    public final void setEstAdresseCorrespondantPrincipal(final Boolean estAdresseCorrespondantPrincipal) {
        sportsAssociationsGrantRequestData.setEstAdresseCorrespondantPrincipal(estAdresseCorrespondantPrincipal);
    }

    
    public final Boolean getEstAdresseCorrespondantPrincipal() {
        return sportsAssociationsGrantRequestData.getEstAdresseCorrespondantPrincipal();
    }
  
    public final void setMontantSubvention(final String montantSubvention) {
        sportsAssociationsGrantRequestData.setMontantSubvention(montantSubvention);
    }

    
    public final String getMontantSubvention() {
        return sportsAssociationsGrantRequestData.getMontantSubvention();
    }
  
    public final void setNomAssociation(final String nomAssociation) {
        sportsAssociationsGrantRequestData.setNomAssociation(nomAssociation);
    }

    
    public final String getNomAssociation() {
        return sportsAssociationsGrantRequestData.getNomAssociation();
    }
  
    public final void setNomCompletCorrespondantPrincipal(final String nomCompletCorrespondantPrincipal) {
        sportsAssociationsGrantRequestData.setNomCompletCorrespondantPrincipal(nomCompletCorrespondantPrincipal);
    }

    
    public final String getNomCompletCorrespondantPrincipal() {
        return sportsAssociationsGrantRequestData.getNomCompletCorrespondantPrincipal();
    }
  
    public final void setNomPresident(final String nomPresident) {
        sportsAssociationsGrantRequestData.setNomPresident(nomPresident);
    }

    
    public final String getNomPresident() {
        return sportsAssociationsGrantRequestData.getNomPresident();
    }
  
    public final void setNombreLicencieMoinsDixHuitSaisonEcoulee(final String nombreLicencieMoinsDixHuitSaisonEcoulee) {
        sportsAssociationsGrantRequestData.setNombreLicencieMoinsDixHuitSaisonEcoulee(nombreLicencieMoinsDixHuitSaisonEcoulee);
    }

    
    public final String getNombreLicencieMoinsDixHuitSaisonEcoulee() {
        return sportsAssociationsGrantRequestData.getNombreLicencieMoinsDixHuitSaisonEcoulee();
    }
  
    public final void setNombreLicenciePlusDixHuitSaisonEcoulee(final String nombreLicenciePlusDixHuitSaisonEcoulee) {
        sportsAssociationsGrantRequestData.setNombreLicenciePlusDixHuitSaisonEcoulee(nombreLicenciePlusDixHuitSaisonEcoulee);
    }

    
    public final String getNombreLicenciePlusDixHuitSaisonEcoulee() {
        return sportsAssociationsGrantRequestData.getNombreLicenciePlusDixHuitSaisonEcoulee();
    }
  
    public final void setNumeroEnregistrementAssociation(final String numeroEnregistrementAssociation) {
        sportsAssociationsGrantRequestData.setNumeroEnregistrementAssociation(numeroEnregistrementAssociation);
    }

    
    public final String getNumeroEnregistrementAssociation() {
        return sportsAssociationsGrantRequestData.getNumeroEnregistrementAssociation();
    }
  
    public final void setNumeroEnregistrementPrefectureAssociation(final String numeroEnregistrementPrefectureAssociation) {
        sportsAssociationsGrantRequestData.setNumeroEnregistrementPrefectureAssociation(numeroEnregistrementPrefectureAssociation);
    }

    
    public final String getNumeroEnregistrementPrefectureAssociation() {
        return sportsAssociationsGrantRequestData.getNumeroEnregistrementPrefectureAssociation();
    }
  
    public final void setNumeroSiretAssociation(final String numeroSiretAssociation) {
        sportsAssociationsGrantRequestData.setNumeroSiretAssociation(numeroSiretAssociation);
    }

    
    public final String getNumeroSiretAssociation() {
        return sportsAssociationsGrantRequestData.getNumeroSiretAssociation();
    }
  
    public final void setPrenomPresident(final String prenomPresident) {
        sportsAssociationsGrantRequestData.setPrenomPresident(prenomPresident);
    }

    
    public final String getPrenomPresident() {
        return sportsAssociationsGrantRequestData.getPrenomPresident();
    }
  
    public final void setRoleDemandeur(final fr.cg95.cvq.business.request.social.SagrRoleAssociationType roleDemandeur) {
        sportsAssociationsGrantRequestData.setRoleDemandeur(roleDemandeur);
    }

    
    public final fr.cg95.cvq.business.request.social.SagrRoleAssociationType getRoleDemandeur() {
        return sportsAssociationsGrantRequestData.getRoleDemandeur();
    }
  
    public final void setSagrActiviteAssociation(final List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> sagrActiviteAssociation) {
        sportsAssociationsGrantRequestData.setSagrActiviteAssociation(sagrActiviteAssociation);
    }

    
    public final List<fr.cg95.cvq.business.request.social.SagrActiviteAssociation> getSagrActiviteAssociation() {
        return sportsAssociationsGrantRequestData.getSagrActiviteAssociation();
    }
  
    public final void setSiegeSocialAssociation(final fr.cg95.cvq.business.users.Address siegeSocialAssociation) {
        sportsAssociationsGrantRequestData.setSiegeSocialAssociation(siegeSocialAssociation);
    }

    
    public final fr.cg95.cvq.business.users.Address getSiegeSocialAssociation() {
        return sportsAssociationsGrantRequestData.getSiegeSocialAssociation();
    }
  
    public final void setSubventionSolliciteConseilGeneral(final String subventionSolliciteConseilGeneral) {
        sportsAssociationsGrantRequestData.setSubventionSolliciteConseilGeneral(subventionSolliciteConseilGeneral);
    }

    
    public final String getSubventionSolliciteConseilGeneral() {
        return sportsAssociationsGrantRequestData.getSubventionSolliciteConseilGeneral();
    }
  
    public final void setTelephonePresident(final String telephonePresident) {
        sportsAssociationsGrantRequestData.setTelephonePresident(telephonePresident);
    }

    
    public final String getTelephonePresident() {
        return sportsAssociationsGrantRequestData.getTelephonePresident();
    }
  
}

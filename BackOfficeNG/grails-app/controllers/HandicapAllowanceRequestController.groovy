import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.civil.IMarriageDetailsRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.business.civil.MarriageDetailsRequest
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Address
import fr.cg95.cvq.business.users.Individual

import fr.cg95.cvq.business.users.CountryType
import fr.cg95.cvq.business.users.SexType
import fr.cg95.cvq.business.users.TitleType

import fr.cg95.cvq.business.social.HarFamilyDependent
import fr.cg95.cvq.business.social.HarAdultLegalAccessKindType
import fr.cg95.cvq.business.social.HarAdultLegalAccessRepresentativeKindType
import fr.cg95.cvq.business.social.HandicapAllowanceRequest
import fr.cg95.cvq.business.social.HarRequestInformationKindType
import fr.cg95.cvq.business.social.HarRequestInformationProfileType
import fr.cg95.cvq.service.social.IHandicapAllowanceRequestService
import fr.cg95.cvq.service.authority.ICategoryService


import org.w3c.dom.Node

import fr.cg95.cvq.security.SecurityContext

import java.math.BigInteger

import grails.converters.JSON

class HandicapAllowanceRequestController {

    IRequestService defaultRequestService
    ICategoryService categoryService
    
	IHandicapAllowanceRequestService handicapAllowanceRequestService
    IHomeFolderService homeFolderService
    
	HandicapAllowanceRequest har
   
    def translationService
    
    def defaultAction = "edit"
    
    def currentTab = "tab1"
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
    
    def edit = {
		log.debug("edit - START")
       
		if (har == null)
          har = new HandicapAllowanceRequest()
        
        //def requester = new Adult()
        //har.setRequester(requester)
        har.setAdultRequesterAddress(new Address())	
        har.setLessThan20FatherActivityReduction(false)
        har.setLessThan20MotherActivityReduction(false)
		har.setAdultLegalAccessPresence(false)
		har.setLessThan20MotherActivityReduction(false)
		har.setLessThan20MotherActivityReduction(false)
		har.setRequestInformationKind(HarRequestInformationKindType.forString("First"))
		har.setDwellingEstablishmentReception(false)
		har.setDwellingSocialReception(false)

		har.setFamilyDependents((Set)initDependents())

		session["handicapAllowanceRequest"] = har
        render(view:"handicapAllowance/request/edit", model:[har:har,currentTab:currentTab])
    }
      
    def validRequester = {
        log.debug("validRequester - START")
        
		har = session["handicapAllowanceRequest"]

		//def adultRequesterAddress = new Address()	
		def adultLegalAccessRepresentativeAddress = new Address()
		def lessThan20FatherAddress = new Address()	
		def lessThan20MotherAddress = new Address()	
		def lessThan20LegalRepresentativeAddress = new Address()
		def lessThan20Requester = new Individual()
		def lessThan20RequesterAddress = new Address()
		def lessThan20ReferentAddress = new Address()
				
		bindData(har, params)
        
        if (params.requestInformationRequesterProfile != null)
            har.setRequestInformationRequesterProfile(HarRequestInformationProfileType.forString(params.requestInformationRequesterProfile))
        
		//TODO if < 20 ou 18 else 
		// AdultRequester
		if (params.adultRequesterTitle != null)
            har.setAdultRequesterTitle(TitleType.forString(params.adultRequesterTitle)) 
		if (params.adultRequesterBirthPlaceCountry != null)
            har.setAdultRequesterBirthPlaceCountry(CountryType.forString(params.adultRequesterBirthPlaceCountry)) 
		
//		if (params.adultRequesterAddressCity != null)
//			adultRequesterAddress.setCity(params.adultRequesterAddressCity)
//		if (params.adultRequesterAddressStreetName != null)
//			adultRequesterAddress.setStreetName(params.adultRequesterAddressStreetName)
//		if (params.adultRequesterAddressPostalCode != null)
//			adultRequesterAddress.setPostalCode(params.adultRequesterAddressPostalCode)
//		har.setAdultRequesterAddress(adultRequesterAddress)
		
		// AdultLegalRepresentative
		if (params.adultLegalAccessKind != null)
            har.setAdultLegalAccessKind(HarAdultLegalAccessKindType.forString(params.adultLegalAccessKind)) 
		if (params.adultLegalAccessRepresentativeKind != null)
            har.setAdultLegalAccessRepresentativeKind(HarAdultLegalAccessRepresentativeKindType.forString(params.adultLegalAccessRepresentativeKind))

		if (params.adultLegalAccessPresence != null){
			if (params.adultLegalAccessPresence.equalsIgnoreCase("true")){
				har.setAdultLegalAccessPresence(true);
			} else if (params.adultLegalAccessPresence.equalsIgnoreCase("false")){
				har.setAdultLegalAccessPresence(false);
			}
		}
		if (params.adultLegalAccessRepresentativeAddressCity != null)
			adultLegalAccessRepresentativeAddress.setCity(params.adultLegalAccessRepresentativeAddressCity)
		if (params.adultLegalAccessRepresentativeAddressStreetName != null)
			adultLegalAccessRepresentativeAddress.setStreetName(params.adultLegalAccessRepresentativeAddressStreetName)
		if (params.adultLegalAccessRepresentativeAddressPostalCode != null)
			adultLegalAccessRepresentativeAddress.setPostalCode(params.adultLegalAccessRepresentativeAddressPostalCode)
		har.setAdultLegalAccessRepresentativeAddress(adultLegalAccessRepresentativeAddress)
		
		// LessThan20Requester
		// TODO Individual adress --> address 
		if (params.lessThan20RequesterSex != null)
			lessThan20Requester.setSex(SexType.forString(params.lessThan20RequesterSex)) 
		if (params.lessThan20RequesterLastName != null)
			lessThan20Requester.setLastName(params.lessThan20RequesterLastName)
		if (params.lessThan20RequesterFirstName != null)
			lessThan20Requester.setFirstName(params.lessThan20RequesterFirstName)
		if (params.lessThan20RequesterAddressCity != null)
			lessThan20RequesterAddress.setCity(params.lessThan20RequesterAddressCity)
		if (params.lessThan20RequesterAddressStreetName != null)
			lessThan20RequesterAddress.setStreetName(params.lessThan20RequesterAddressStreetName)
		if (params.lessThan20RequesterAddressPostalCode != null)
			lessThan20RequesterAddress.setPostalCode(params.lessThan20RequesterAddressPostalCode)
		lessThan20Requester.setAdress(lessThan20RequesterAddress)
		har.setLessThan20Requester(lessThan20Requester)

		// LessThan20Referent		
		if (params.lessThan20ReferentTitle != null)
            har.setLessThan20ReferentTitle(TitleType.forString(params.lessThan20ReferentTitle)) 
		if (params.lessThan20ReferentBirthPlaceCountry != null)
            har.setLessThan20ReferentBirthPlaceCountry(CountryType.forString(params.lessThan20ReferentBirthPlaceCountry))

		if (params.lessThan20ReferentAddressCity != null)
			lessThan20ReferentAddress.setCity(params.lessThan20ReferentAddressCity)
		if (params.lessThan20ReferentAddressStreetName != null)
			lessThan20ReferentAddress.setStreetName(params.lessThan20ReferentAddressStreetName)
		if (params.lessThan20ReferentAddressPostalCode != null)
			lessThan20ReferentAddress.setPostalCode(params.lessThan20ReferentAddressPostalCode)
		har.setLessThan20ReferentAddress(lessThan20ReferentAddress)

		// LessThan20Father		
		if (params.lessThan20FatherAddressCity != null)
			lessThan20FatherAddress.setCity(params.lessThan20FatherAddressCity)
		if (params.lessThan20FatherAddressStreetName != null)
			lessThan20FatherAddress.setStreetName(params.lessThan20FatherAddressStreetName)
		if (params.lessThan20FatherAddressPostalCode != null)
			lessThan20FatherAddress.setPostalCode(params.lessThan20FatherAddressPostalCode)
		har.setLessThan20FatherAddress(lessThan20FatherAddress)

		if (params.lessThan20FatherActivityReduction != null){
			if (params.lessThan20FatherActivityReduction.equalsIgnoreCase("true")){
				har.setLessThan20FatherActivityReduction(true);
			} else if (params.lessThan20FatherActivityReduction.equalsIgnoreCase("false")){
				har.setLessThan20FatherActivityReduction(false);
			}
		}

		// LessThan20Mother		
		if (params.lessThan20MotherAddressCity != null)
			lessThan20MotherAddress.setCity(params.lessThan20MotherAddressCity)
		if (params.lessThan20MotherAddressStreetName != null)
			lessThan20MotherAddress.setStreetName(params.lessThan20MotherAddressStreetName)
		if (params.lessThan20MotherAddressPostalCode != null)
			lessThan20MotherAddress.setPostalCode(params.lessThan20MotherAddressPostalCode)
		har.setLessThan20MotherAddress(lessThan20MotherAddress)

		if (params.lessThan20MotherActivityReduction != null){
			if (params.lessThan20MotherActivityReduction.equalsIgnoreCase("true")){
				har.setLessThan20MotherActivityReduction(true);
			} else if (params.lessThan20MotherActivityReduction.equalsIgnoreCase("false")){
				har.setLessThan20MotherActivityReduction(false);
			}
		}

		// LessThan20LegalRepresentative	
		if (params.lessThan20LegalRepresentativeAddressCity != null)
			lessThan20LegalRepresentativeAddress.setCity(params.lessThan20LegalRepresentativeAddressCity)
		if (params.lessThan20LegalRepresentativeAddressStreetName != null)
			lessThan20LegalRepresentativeAddress.setStreetName(params.lessThan20LegalRepresentativeAddressStreetName)
		if (params.lessThan20LegalRepresentativeAddressPostalCode != null)
			lessThan20LegalRepresentativeAddress.setPostalCode(params.lessThan20LegalRepresentativeAddressPostalCode)
		har.setLessThan20LegalRepresentativeAddress(lessThan20LegalRepresentativeAddress)

        currentTab = getCurrentTab(params)

		session["handicapAllowanceRequest"] = har
        render(view:"handicapAllowance/request/edit", model:[har:har, currentTab:currentTab])
    }
    
    def validResidence = {
		log.debug("validResidence - START")
        
		har = session["handicapAllowanceRequest"]
        
		currentTab = getCurrentTab(params) 

		session["handicapAllowanceRequest"] = har
        render(view:"handicapAllowance/request/edit", model:[har:har, currentTab:currentTab])
    }
    
    def validFamily = {
    	log.debug("validFamily - START")
        
		har = session["handicapAllowanceRequest"]
		//bindData(har, params)

        currentTab = getCurrentTab(params)
          
		session["handicapAllowanceRequest"] = har
        render(view:"handicapAllowance/request/edit", model:[har:har, currentTab:currentTab])
    }
    
    def validSocialSecurity = {
    	log.debug("validSocialSecurity - START")
        
		har = session["handicapAllowanceRequest"]
		
        currentTab = getCurrentTab(params)

		session["handicapAllowanceRequest"] = har
        render(view:"handicapAllowance/request/edit", model:[har:har, currentTab:currentTab])
    }
    
    
    
    def validDocument = {
    }
    
    def validMeansOfContact = {
    }
    
    def sendRequest = {
      
      log.debug("sendRequest - START")
      
      har = session["handicapAllowanceRequest"]
      
      Node harNode = har.modelToXml().getDomNode()
      SecurityContext.setCurrentSite("valdoise", "frontOffice")
      handicapAllowanceRequestService.create(harNode)
      
      if (params.submitHarSend)
          currentTab = "tab4"
      
      def message = "Demande envoyée !!"
      
      render(view:"handicapAllowance/request/edit", model:[har:har, currentTab:currentTab, message:message])
    }
     
    def getCurrentTab = { currentTab ->
	if (params.submitHarRequester)
       currentTab = "tab1"
    else if (params.submitHarResidence)
       currentTab = "tab2"
    else if (params.submitHarFamily)
       currentTab = "tab3" 
    else if (params.submitHarSocialSecurity)
       currentTab = "tab4" 
    else if (params.submitHarSocialSecurity)
       currentTab = "tab5" 	
    return currentTab
    }    
    
    def initDependents = { 
    	def harFamilyDependent = new HarFamilyDependent()
    	def harFamilyDependent2 = new HarFamilyDependent()
    	def harFamilyDependent3 = new HarFamilyDependent()
    	harFamilyDependent.setFamilyDependentLastName("Dependent1")
    	harFamilyDependent2.setFamilyDependentLastName("Dependent2")
    	harFamilyDependent3.setFamilyDependentLastName("Dependent3")
    	harFamilyDependent.setFamilyDependentFirstName("F1")
    	harFamilyDependent2.setFamilyDependentFirstName("F2")
    	harFamilyDependent3.setFamilyDependentFirstName("F3")
    	Set dependents = new HashSet()
   		dependents.add(harFamilyDependent)
   		dependents.add(harFamilyDependent2)
   		dependents.add(harFamilyDependent3)    		
   		return dependents
    }
}

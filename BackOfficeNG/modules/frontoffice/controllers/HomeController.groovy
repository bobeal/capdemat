import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.impl.LocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.civil.IMarriageDetailsRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Address

import fr.cg95.cvq.business.users.TitleType
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType
import fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType
import fr.cg95.cvq.business.request.civil.MarriageRelationshipType

import fr.cg95.cvq.xml.request.civil.MarriageDetailsRequestDocument
import org.w3c.dom.Node

import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.util.Critere;


import java.math.BigInteger


import grails.converters.JSON

class HomeController {

    EcitizenService ecitizenService
    IRequestService defaultRequestService
    LocalAuthorityRegistry localAuthorityRegistry
    IMarriageDetailsRequestService marriageDetailsRequestService
    IHomeFolderService homeFolderService
    IPaymentService paymentService
    
    Adult currentEcitizen
    MarriageDetailsRequest mdr 
    def translationService
    
    def defaultAction = "index"
    
    def currentTab = "tab1"
    
    def beforeInterceptor = {
        this.currentEcitizen = SecurityContext.getCurrentEcitizen();
    }
    
    def index = {
        def result = [:];
        result.dashBoard = [:];
                            
        File infoFile = localAuthorityRegistry.getCurrentLocalAuthorityResource(
            ILocalAuthorityRegistry.HTML_RESOURCE_TYPE, 
            'information.html',false);
        
        if(infoFile.exists()) result.commonInfo = infoFile.text;
        
        result.dashBoard.requests = this.getTopFiveRequests();
        result.dashBoard.requests = ecitizenService.prepareRecords(result.dashBoard.requests);
        
        result.dashBoard.payments = this.getTopFivePayments();
        result.dashBoard.documents = this.getTopFiveDocuments();
        
        
        //println this.getTopFivePayments();
//        this.getTopFiveDocuments().all.each{
//            println it.id;
//        };
//        println '#######################'
//        this.getTopFiveDocuments().all2.each {
//            println it.id;
//        }
        return result;
    }
    
    def demo = {
        flash.currentMenu = 'home'
        if (mdr == null)
          mdr = new MarriageDetailsRequest()
        
        def requester = new Adult()
        mdr.setRequester(requester)
        session["mariageDetailsRequest"] = mdr
    }
    
    def validRequester = {
        log.debug("validRequester - START")
         
        mdr = session["mariageDetailsRequest"]
        def address = new Address()
        
        bindData(mdr.requester, params)
        // test persistentString managment ...
        mdr.requester.setTitle(TitleType.forString(params.title))
        
        bindData(address, params)
        
        mdr.requester.setAdress(address)
        
        session["mariageDetailsRequest"] = mdr
        
        if (params.submitMdrRequester)
          currentTab = "tab1"
          
        //render(view:"fong/request/edit", model:[mdr:mdr, currentTab:currentTab])
    }
    
    def validDetailsNature = {
        log.debug("validDetailsNature - START")
        
        mdr = session["mariageDetailsRequest"]
        
        bindData(mdr, params)
        
        if (params.requesterQuality != null)
            mdr.setRequesterQuality(MarriageRequesterQualityType.forString(params.requesterQuality))
        if (params.format != null)
            mdr.setFormat(MarriageCertificateFormatType.forString(params.format))
        if (params.relationship != null)
            mdr.setRelationship(MarriageRelationshipType.forString(params.relationship))
            
        if (params.submitMdrDetailsNature)
          currentTab = "tab2"
        else if (params.submitMdrDetailsFormat)
          currentTab = "tab3"
        
        session["mariageDetailsRequest"] = mdr
        render(view:"fong/request/edit", model:[mdr:mdr, currentTab:currentTab])
    }
    
    def validDetailsFormat = {
    }
    
    def validDocument = {
    }
    
    def validMeansOfContact = {
    }
    
    def sendRequest = {
      
      log.debug("sendRequest - START")
      
      mdr = session["mariageDetailsRequest"]
      
      Node mdrNode = mdr.modelToXml().getDomNode()
      SecurityContext.setCurrentSite("valdoise", "frontOffice")
      marriageDetailsRequestService.create(mdrNode)
      
      if (params.submitMdrSend)
          currentTab = "tab6"
      
      def message = "Demande envoyée !!"
      
      //render(view:"fong/request/edit", model:[mdr:mdr, currentTab:currentTab, message:message])
    }
    
    def protected getTopFiveRequests = {
        
        Set criteriaSet = new HashSet<Critere>();
        Critere critere = new Critere();
        
        critere.comparatif = Critere.EQUALS;
        critere.attribut = Request.SEARCH_BY_HOME_FOLDER_ID;
        critere.value = this.currentEcitizen.homeFolder.id
        criteriaSet.add(critere)
        
        return [
            'all' : defaultRequestService.extendedGet(criteriaSet, null, null, 5, 0),
            'count' : defaultRequestService.getCount(criteriaSet),
            'records' : []
        ]
    }
    
    def protected getTopFivePayments = {
        return [
            'all' : paymentService.extendedGet(null, null, null, null, null, null, null, null, 
                this.currentEcitizen.homeFolder.id, null, 'commitDate', 'DESC', 5, 0),
            'count' : paymentService.getPaymentCount(null, null, null, null, null, null, null, 
                null, this.currentEcitizen.homeFolder.id, null)
        ]
        
    }
    
    def protected getTopFiveDocuments = {
        return [
            'all': homeFolderService.getAssociatedDocuments(this.currentEcitizen.homeFolder.id, 5)
        ]
    }
}

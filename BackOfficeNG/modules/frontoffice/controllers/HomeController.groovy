import fr.cg95.cvq.service.request.IRequestService
import fr.cg95.cvq.service.request.civil.IMarriageDetailsRequestService
import fr.cg95.cvq.service.users.IHomeFolderService
import fr.cg95.cvq.exception.CvqException
import fr.cg95.cvq.business.request.civil.MarriageDetailsRequest
import fr.cg95.cvq.business.users.Adult
import fr.cg95.cvq.business.users.Address

import fr.cg95.cvq.business.users.TitleType
import fr.cg95.cvq.business.request.civil.MarriageRequesterQualityType
import fr.cg95.cvq.business.request.civil.MarriageCertificateFormatType
import fr.cg95.cvq.business.request.civil.MarriageRelationshipType

import fr.cg95.cvq.xml.request.civil.MarriageDetailsRequestDocument
import org.w3c.dom.Node

import fr.cg95.cvq.security.SecurityContext


import java.math.BigInteger


import grails.converters.JSON

class HomeController {

    IRequestService defaultRequestService
    
    IMarriageDetailsRequestService marriageDetailsRequestService
    IHomeFolderService homeFolderService
    
    MarriageDetailsRequest mdr 
   
    def translationService
    
    def defaultAction = "index"
    
    def currentTab = "tab1"
    
    def beforeInterceptor = {
        session["currentMenu"] = "request"
    }
    
    def index = {
        flash.currentMenu = 'home'
        if (mdr == null)
          mdr = new MarriageDetailsRequest()
        
        def requester = new Adult()
        mdr.setRequester(requester)
        session["mariageDetailsRequest"] = mdr
    }
    
    def persons = {
        flash.currentMenu = 'persons';
        render '';
    }
    

    def documents = {
        flash.currentMenu = 'documents';
        render '';
    }
    def services = {
        flash.currentMenu = 'services';
        render '';
    }
    def activities = {
        flash.currentMenu = 'activities';
        render '';
    }
    def payments = {
        flash.currentMenu = 'payments';
        render '';
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
}

package fr.cg95.cvq.service.users;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.w3c.dom.Node;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestForm;
import fr.cg95.cvq.business.request.RequestFormType;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.BusinessObjectsFactory;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;


/**
 * The tests for the general request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestServiceTest extends ServiceTestCase {

    public void testRequestType()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        Set requestTypesSet = iRequestService.getAllRequestTypes();
        Assert.assertTrue(requestTypesSet.size() >= 2);
        
        // add a new requirement for the first request type found
        RequestType rt = (RequestType) requestTypesSet.iterator().next();

        int initialRequirementsSize = rt.getRequirements().size();
        
        Iterator allDocumentTypesIt = iDocumentService.getAllDocumentTypes().iterator();
        Requirement requirement = new Requirement();
        requirement.setMultiplicity(new Integer(1));
        requirement.setSpecial(Boolean.valueOf(false));
        requirement.setDocumentType((DocumentType) allDocumentTypesIt.next());
        rt.getRequirements().add(requirement);
        Requirement requirement2 = new Requirement();
        requirement2.setMultiplicity(new Integer(1));
        requirement2.setSpecial(Boolean.valueOf(true));
        requirement2.setDocumentType((DocumentType) allDocumentTypesIt.next());
        rt.getRequirements().add(requirement2);
        
        iDocumentService.getAllDocumentTypes().iterator().next();
        iRequestService.modifyRequestTypeRequirements(rt, rt.getRequirements());
        
        continueWithNewTransaction();
        
        rt = iRequestService.getRequestTypeByLabel(rt.getLabel());
        Assert.assertEquals(rt.getRequirements().size(), initialRequirementsSize + 2);
        
        // validate "order by" behavior
        Iterator requirementsIt = rt.getRequirements().iterator();
        Requirement req1 = (Requirement) requirementsIt.next();
        Requirement req2 = (Requirement) requirementsIt.next();
        Assert.assertTrue(req1.getDocumentType().getId().longValue() 
                < req2.getDocumentType().getId().longValue());
        
        // do some modifications on request types
        boolean shouldBeActive = true;
        if (rt.getActive().booleanValue()) {
            rt.setActive(Boolean.valueOf(false));
            shouldBeActive = false;
        } else {
            rt.setActive(Boolean.valueOf(true));
        }

        iRequestService.modifyRequestType(rt);

        continueWithNewTransaction();
        
        rt = iRequestService.getRequestTypeByLabel(rt.getLabel());
        if (shouldBeActive)
            Assert.assertTrue(rt.getActive().booleanValue());
        else
            Assert.assertFalse(rt.getActive().booleanValue());
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        // requestType by category
        Category category = iCategoryService.getAll().get(0);
        iRequestService.getRequestsTypesByCategory(category.getId());
        int requestTypeNumber = iRequestService.getAllRequestTypes().size();
        int requestTypeInCategory = iRequestService.getRequestsTypesByCategory(category.getId()).size();
        Assert.assertEquals(requestTypeNumber, requestTypeInCategory);
        
        SecurityContext.resetCurrentSite();
    }
    
    public void testRequestCloning() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        CreationBean creationBean = gimmeAnHomeFolder();
        Long requestId = creationBean.getRequestId();
        Request request = iRequestService.getById(requestId);
        Node requestCloneNode = 
            iRequestService.getRequestClone(null, request.getHomeFolder().getId(), 
            		request.getRequestType().getLabel());
        
        SecurityContext.resetCurrentSite();
    }
    
    public void testRequestSearch() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
  
        CreationBean cb = gimmeAnHomeFolder();
        Request request = iRequestService.getById(cb.getRequestId());
        
        Set <Critere> critSet = new HashSet<Critere>();
        // search by ...
        Critere crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUEST_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getId());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_HOME_FOLDER_ID);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getHomeFolder().getId());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getRequester().getLastName());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_FIRSTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getRequester().getFirstName());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_CATEGORY_NAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getRequestType().getCategory().getName());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_STATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getState());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_CREATION_DATE);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getCreationDate());
        critSet.add(crit);
        
        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUEST_TYPE_LABEL);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(request.getRequestType().getLabel());
        critSet.add(crit);
        
        Set fetchRequest = iRequestService.get(critSet, null, false);
        Assert.assertEquals(fetchRequest.size() , 1);
        
        SecurityContext.resetCurrentSite();
    }
    
    public void testRequestTypeForm() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        CreationBean creationBean = gimmeAnHomeFolder();
        Long requestId = creationBean.getRequestId();
        
        Request request = iRequestService.getById(requestId);
        RequestType requestType = request.getRequestType();
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iRequestService.addRequestTypeForm(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE,
                "Courrier Test Add", "CouTesAdd",
                "test.xsl", 
                "<xsl:stylesheet>ADD MAIL TEMPLATE</xsl:stylesheet>".getBytes());
        
        List<RequestForm> resultSet = iRequestService.getRequestTypeForms(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, resultSet.size());
        
        Object[] requestFormArray = resultSet.toArray();
        long requestFormId = ((RequestForm)requestFormArray[0]).getId();
        
        // Modifies labels
        iRequestService.modifyRequestTypeForm(requestType.getId(), requestFormId, 
                "Courrier Test Mod", "CorTesMod", null, null);
        resultSet = iRequestService.getRequestTypeForms(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, resultSet.size());
        
        // Rewrite same labels !
        iRequestService.modifyRequestTypeForm(requestType.getId(), requestFormId, 
                "Courrier Test Mod", "CorTesMod", null , null);
        resultSet = iRequestService.getRequestTypeForms(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, resultSet.size());
        
        iRequestService.modifyRequestTypeForm(requestType.getId(), requestFormId, 
                null, null, "test.xsl", 
                "<xsl:stylesheet>MODIFY MAIL TEMPLATE</xsl:stylesheet>".getBytes());
        resultSet = iRequestService.getRequestTypeForms(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, resultSet.size());
        
        try {
        iRequestService.addRequestTypeForm(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE,
                "Courrier Test Add", "CorTesMod",
                "test2.xsl", 
                "<xsl:stylesheet>ADD MAIL TEMPLATE</xsl:stylesheet>".getBytes());
        } catch (CvqModelException cvqme) {
            Assert.assertEquals("requestForm.shortLabel_already_used", cvqme.getMessage());
        }
        
        iRequestService.removeRequestTypeForm(requestType.getId(), requestFormId);
        resultSet = iRequestService.getRequestTypeForms(requestType.getId(), 
                RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(0, resultSet.size());
        
    }
    
    public void testGetByIds() throws CvqException {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);

        Long[] ids = new Long[12];
        for (int i = 0 ; i < 12; i++)
            ids[i] = gimmeAnHomeFolder().getRequestId();
        
        continueWithNewTransaction();
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        Set<Request> requests = iRequestService.getByIds(ids);
        assertEquals(12, requests.size());
        for (Request request : requests) {
            assertNotNull(request.getId());
            assertNotNull(request.getCreationDate());
            assertNotNull(request.getRequester());
        }
    }
}

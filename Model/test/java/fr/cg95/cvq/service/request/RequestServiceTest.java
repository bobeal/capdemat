package fr.cg95.cvq.service.request;

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
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.Requirement;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.SecurityContext;
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

        Set<RequestType> requestTypesSet = iRequestService.getAllRequestTypes();
        Assert.assertTrue(requestTypesSet.size() >= 2);

        // add a new requirement for the first request type found
        RequestType rt = requestTypesSet.iterator().next();

        int initialRequirementsSize = rt.getRequirements().size();
        
        List<DocumentType> allDocumentTypes = iDocumentTypeService.getAllDocumentTypes();
        Requirement requirement = new Requirement();
        requirement.setMultiplicity(new Integer(1));
        requirement.setSpecial(Boolean.valueOf(false));
        requirement.setDocumentType(allDocumentTypes.get(0));
        rt.getRequirements().add(requirement);
        Requirement requirement2 = new Requirement();
        requirement2.setMultiplicity(new Integer(1));
        requirement2.setSpecial(Boolean.valueOf(true));
        requirement2.setDocumentType(allDocumentTypes.get(1));
        rt.getRequirements().add(requirement2);
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
            iRequestService.getRequestClone(null, request.getHomeFolderId(),
            		request.getRequestType().getLabel());
        assertNotNull(requestCloneNode);
        
        SecurityContext.resetCurrentSite();
    }

    public void testRequestSearch() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        CreationBean cb = gimmeAnHomeFolder();
        Request request = iRequestService.getById(cb.getRequestId());
        Long requesterId = request.getRequesterId();
        Adult requester = iAdultService.getById(requesterId);
        
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
        crit.setValue(request.getHomeFolderId());
        critSet.add(crit);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_LASTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(requester.getLastName());
        critSet.add(crit);

        crit = new Critere();
        crit.setAttribut(Request.SEARCH_BY_REQUESTER_FIRSTNAME);
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(requester.getFirstName());
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

        RequestForm requestForm = new RequestForm();
        requestForm.setLabel("TEST1");
        requestForm.setShortLabel("TEST2");
        requestForm.setTemplateName("template.html");
        requestForm.setType(RequestFormType.REQUEST_MAIL_TEMPLATE);
        requestForm.setPersonalizedData("MyData".getBytes());
        Long id = iRequestService.processRequestTypeForm(requestType.getId(), requestForm);

        List<RequestForm> forms = iRequestService.getRequestTypeForms(
                requestType.getId(), RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, forms.size());

        RequestForm tmpForm = iRequestService.getRequestFormById(id);
        Assert.assertEquals(tmpForm.getLabel(),requestForm.getLabel());
        Assert.assertEquals(tmpForm.getShortLabel(),requestForm.getShortLabel());
        Assert.assertEquals(tmpForm.getTemplateName(),requestForm.getTemplateName());
        Assert.assertEquals(tmpForm.getType(),requestForm.getType());
        Assert.assertEquals(tmpForm.getPersonalizedData(),requestForm.getPersonalizedData());

        tmpForm.setLabel("new label");
        tmpForm.setShortLabel("new short label");
        tmpForm.setPersonalizedData("new data".getBytes());
        tmpForm.setTemplateName("tmp.html");

        Long sameId = iRequestService.processRequestTypeForm(requestType.getId(), tmpForm);
        Assert.assertEquals(sameId,id);

        tmpForm = iRequestService.getRequestFormById(sameId);
        Assert.assertEquals(tmpForm.getLabel(),"new label");
        Assert.assertEquals(tmpForm.getShortLabel(),"new short label");
        Assert.assertEquals(tmpForm.getTemplateName(),"tmp.html");
        Assert.assertEquals(tmpForm.getType(),requestForm.getType());
        Assert.assertEquals(new String(tmpForm.getPersonalizedData()),"new data");

        try {
            RequestForm f = new RequestForm();
            f.setLabel("new label");
            f.setShortLabel("new short label");
            f.setPersonalizedData("new data".getBytes());
            f.setTemplateName("tmp.html");
            iRequestService.processRequestTypeForm(requestType.getId(), f);
            fail("RequestForm data can't be duplicated");
        } catch (CvqModelException cvqme) {
            Assert.assertEquals("requestForm.label_already_used", cvqme.getMessage());
        } finally {
            iRequestService.removeRequestTypeForm(id);
            forms = iRequestService.getRequestTypeForms(requestType.getId(),RequestFormType.REQUEST_MAIL_TEMPLATE);
            Assert.assertEquals(0, forms.size());
        }
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
            assertNotNull(request.getRequesterId());
        }
    }
}

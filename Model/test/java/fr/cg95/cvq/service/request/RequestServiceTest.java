package fr.cg95.cvq.service.request;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Category;
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
import fr.cg95.cvq.util.Critere;


/**
 * The tests for the general request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestServiceTest extends RequestTestCase {

    @Test
    public void testRequestType()
        throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        List<RequestType> requestTypesSet = requestTypeService.getAllRequestTypes();
        assertTrue(requestTypesSet.size() >= 2);
        
        // the first request type found
        RequestType rt = requestTypesSet.get(0);
        int initialRequirementsSize = rt.getRequirements().size();
        List<DocumentType> allDocumentTypes = documentTypeService.getAllDocumentTypes();
        
        // add a new requirement
        requestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(0).getId());
        requestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(1).getId());
        requestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(2).getId());
        
        continueWithNewTransaction();
        rt = requestTypeService.getRequestTypeById(rt.getId());
        assertEquals(initialRequirementsSize + 3, rt.getRequirements().size());

        // test requirement properties consistency
        Iterator<Requirement> requirementsIt = rt.getRequirements().iterator();
        Requirement req1 = requirementsIt.next();
        assertNotNull(req1);
        assertNotNull(req1.getDocumentType());
        assertNotNull(req1.getDocumentType().getId());
        assertNotNull(req1.getRequestType());
        Requirement req2 = requirementsIt.next();
        assertNotNull(req2);
        assertNotNull(req2.getDocumentType());
        assertNotNull(req2.getDocumentType().getId());
        assertNotNull(req2.getRequestType());

        // remove requirement 
        requestTypeService.removeRequestTypeRequirement(rt.getId(), allDocumentTypes.get(2).getId());
        continueWithNewTransaction();
        rt = requestTypeService.getRequestTypeById(rt.getId());
        assertEquals(initialRequirementsSize + 2, rt.getRequirements().size());

        continueWithNewTransaction();
        
        // do some modifications on request types
        boolean shouldBeActive = true;
        if (rt.getActive().booleanValue()) {
            rt.setActive(Boolean.valueOf(false));
            shouldBeActive = false;
        } else {
            rt.setActive(Boolean.valueOf(true));
        }

        requestTypeService.modifyRequestType(rt);

        continueWithNewTransaction();

        rt = requestTypeService.getRequestTypeById(rt.getId());
        if (shouldBeActive)
            assertTrue(rt.getActive().booleanValue());
        else
            assertFalse(rt.getActive().booleanValue());

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // requestType by category
        Category category = categoryService.getAll().get(0);
        Set<Critere> criteriaSet = new HashSet<Critere>();
        Critere categoryCriteria = new Critere();
        categoryCriteria.setAttribut(RequestType.SEARCH_BY_CATEGORY_ID);
        categoryCriteria.setValue(category.getId());
        criteriaSet.add(categoryCriteria);
        requestTypeService.getRequestTypes(criteriaSet);
        int requestTypeNumber = requestTypeService.getAllRequestTypes().size();
        int requestTypeInCategory = 
            requestTypeService.getRequestTypes(criteriaSet).size();
        assertEquals(requestTypeNumber, requestTypeInCategory);

        SecurityContext.resetCurrentSite();
    }

    @Test
    public void testRequestCloning() throws CvqException {

        CreationBean creationBean = gimmeAnHomeFolderWithRequest();
        Long requestId = creationBean.getRequestId();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = requestSearchService.getById(requestId, false);
        Node requestCloneNode =
            requestWorkflowService.getRequestClone(null, request.getHomeFolderId(),
            		request.getRequestType().getLabel());
        assertNotNull(requestCloneNode);
        
        SecurityContext.resetCurrentSite();
    }

    @Test
    public void testRequestSearch() throws CvqException {
        
        CreationBean cb = gimmeAnHomeFolderWithRequest();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = requestSearchService.getById(cb.getRequestId(), false);
        Long requesterId = request.getRequesterId();
        Adult requester = individualService.getAdultById(requesterId);
        
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

        List<Request> fetchRequest = requestSearchService.get(critSet, null, null, -1, 0, false);
        assertEquals(1, fetchRequest.size());

        SecurityContext.resetCurrentSite();
    }

    @Test
    public void testRequestTypeForm() throws CvqException {

        CreationBean creationBean = gimmeAnHomeFolderWithRequest();
        Long requestId = creationBean.getRequestId();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = requestSearchService.getById(requestId, false);
        RequestType requestType = request.getRequestType();

        RequestForm requestForm = new RequestForm();
        requestForm.setLabel("TEST1");
        requestForm.setShortLabel("TEST2");
        requestForm.setTemplateName("template");
        requestForm.setType(RequestFormType.REQUEST_MAIL_TEMPLATE);
        requestForm.setPersonalizedData("MyData".getBytes());
        Long id = requestTypeService.modifyRequestTypeForm(requestType.getId(), requestForm);

        continueWithNewTransaction();
        
        List<RequestForm> forms = requestTypeService.getRequestTypeForms(
                requestType.getId(), RequestFormType.REQUEST_MAIL_TEMPLATE);
        assertEquals(1, forms.size());

        RequestForm tmpForm = requestTypeService.getRequestFormById(id);
        assertEquals(tmpForm.getLabel(),requestForm.getLabel());
        assertEquals(tmpForm.getShortLabel(),requestForm.getShortLabel());
        assertEquals(tmpForm.getTemplateName(),requestForm.getTemplateName());
        assertEquals(tmpForm.getType(),requestForm.getType());
        assertEquals("MyData", new String(tmpForm.getPersonalizedData()));

        tmpForm.setLabel("new label");
        tmpForm.setShortLabel("new short label");
        tmpForm.setPersonalizedData("new data".getBytes());
        tmpForm.setTemplateName("tmp");

        Long sameId = requestTypeService.modifyRequestTypeForm(requestType.getId(), tmpForm);
        
        continueWithNewTransaction();
        
        assertEquals(sameId,id);

        tmpForm = requestTypeService.getRequestFormById(sameId);
        assertEquals(tmpForm.getLabel(),"new label");
        assertEquals(tmpForm.getShortLabel(),"new short label");
        assertEquals(tmpForm.getTemplateName(),"tmp");
        assertEquals(tmpForm.getType(),requestForm.getType());
        assertEquals(new String(tmpForm.getPersonalizedData()),"new data");

        try {
            RequestForm f = new RequestForm();
            f.setLabel("new label");
            f.setShortLabel("new short label");
            f.setPersonalizedData("new data".getBytes());
            f.setTemplateName("tmp");
            requestTypeService.modifyRequestTypeForm(requestType.getId(), f);
            fail("RequestForm data can't be duplicated");
        } catch (CvqModelException cvqme) {
            assertEquals("requestForm.message.labelAlreadyUsed", cvqme.getI18nKey());
        } finally {
            requestTypeService.removeRequestTypeForm(requestType.getId(), tmpForm.getId());
            continueWithNewTransaction();
            forms = requestTypeService.getRequestTypeForms(requestType.getId(),
                RequestFormType.REQUEST_MAIL_TEMPLATE);
            assertEquals(0, forms.size());
        }
    }

}

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
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);

        List<RequestType> requestTypesSet = iRequestTypeService.getAllRequestTypes();
        assertTrue(requestTypesSet.size() >= 2);
        
        // the first request type found
        RequestType rt = requestTypesSet.get(0);
        int initialRequirementsSize = rt.getRequirements().size();
        List<DocumentType> allDocumentTypes = iDocumentTypeService.getAllDocumentTypes();
        
        // add a new requirement
        iRequestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(0).getId());
        iRequestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(1).getId());
        iRequestTypeService.addRequestTypeRequirement(rt.getId(), allDocumentTypes.get(2).getId());
        continueWithNewTransaction();
        rt = iRequestTypeService.getRequestTypeById(rt.getId());
        logger.warn("AAAAAAA " + rt.getLabel());
        Assert.assertEquals(rt.getRequirements().size(), initialRequirementsSize + 3);

        // test requirement properies consistency
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
        iRequestTypeService.removeRequestTypeRequirement(rt.getId(), allDocumentTypes.get(2).getId());
        continueWithNewTransaction();
        rt = iRequestTypeService.getRequestTypeById(rt.getId());
        Assert.assertEquals(rt.getRequirements().size(), initialRequirementsSize + 2);

        continueWithNewTransaction();
        
        // do some modifications on request types
        boolean shouldBeActive = true;
        if (rt.getActive().booleanValue()) {
            rt.setActive(Boolean.valueOf(false));
            shouldBeActive = false;
        } else {
            rt.setActive(Boolean.valueOf(true));
        }

        iRequestTypeService.modifyRequestType(rt);

        continueWithNewTransaction();

        rt = iRequestTypeService.getRequestTypeById(rt.getId());
        if (shouldBeActive)
            Assert.assertTrue(rt.getActive().booleanValue());
        else
            Assert.assertFalse(rt.getActive().booleanValue());

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // requestType by category
        Category category = iCategoryService.getAll().get(0);
        Set<Critere> criteriaSet = new HashSet<Critere>();
        Critere categoryCriteria = new Critere();
        categoryCriteria.setAttribut(RequestType.SEARCH_BY_CATEGORY_ID);
        categoryCriteria.setValue(category.getId());
        criteriaSet.add(categoryCriteria);
        iRequestTypeService.getRequestTypes(criteriaSet);
        int requestTypeNumber = iRequestTypeService.getAllRequestTypes().size();
        int requestTypeInCategory = 
            iRequestTypeService.getRequestTypes(criteriaSet).size();
        Assert.assertEquals(requestTypeNumber, requestTypeInCategory);

        SecurityContext.resetCurrentSite();
    }

    public void testRequestCloning() throws CvqException {

        CreationBean creationBean = gimmeAnHomeFolder();
        Long requestId = creationBean.getRequestId();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = iRequestService.getById(requestId);
        Node requestCloneNode =
            iRequestService.getRequestClone(null, request.getHomeFolderId(),
            		request.getRequestType().getLabel());
        assertNotNull(requestCloneNode);
        
        SecurityContext.resetCurrentSite();
    }

    public void testRequestSearch() throws CvqException {
        
        CreationBean cb = gimmeAnHomeFolder();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = iRequestService.getById(cb.getRequestId());
        Long requesterId = request.getRequesterId();
        Adult requester = iIndividualService.getAdultById(requesterId);
        
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

        List<Request> fetchRequest = iRequestService.get(critSet, null, null, -1, 0);
        assertEquals(1, fetchRequest.size());

        SecurityContext.resetCurrentSite();
    }

    public void testRequestTypeForm() throws CvqException {

        CreationBean creationBean = gimmeAnHomeFolder();
        Long requestId = creationBean.getRequestId();

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Request request = iRequestService.getById(requestId);
        RequestType requestType = request.getRequestType();

        RequestForm requestForm = new RequestForm();
        requestForm.setLabel("TEST1");
        requestForm.setShortLabel("TEST2");
        requestForm.setTemplateName("template");
        requestForm.setType(RequestFormType.REQUEST_MAIL_TEMPLATE);
        requestForm.setPersonalizedData("MyData".getBytes());
        Long id = iRequestTypeService.modifyRequestTypeForm(requestType.getId(), requestForm);

        List<RequestForm> forms = iRequestTypeService.getRequestTypeForms(
                requestType.getId(), RequestFormType.REQUEST_MAIL_TEMPLATE);
        Assert.assertEquals(1, forms.size());

        RequestForm tmpForm = iRequestTypeService.getRequestFormById(id);
        Assert.assertEquals(tmpForm.getLabel(),requestForm.getLabel());
        Assert.assertEquals(tmpForm.getShortLabel(),requestForm.getShortLabel());
        Assert.assertEquals(tmpForm.getTemplateName(),requestForm.getTemplateName());
        Assert.assertEquals(tmpForm.getType(),requestForm.getType());
        Assert.assertEquals(tmpForm.getPersonalizedData(),requestForm.getPersonalizedData());

        tmpForm.setLabel("new label");
        tmpForm.setShortLabel("new short label");
        tmpForm.setPersonalizedData("new data".getBytes());
        tmpForm.setTemplateName("tmp");

        Long sameId = iRequestTypeService.modifyRequestTypeForm(requestType.getId(), tmpForm);
        Assert.assertEquals(sameId,id);

        tmpForm = iRequestTypeService.getRequestFormById(sameId);
        Assert.assertEquals(tmpForm.getLabel(),"new label");
        Assert.assertEquals(tmpForm.getShortLabel(),"new short label");
        Assert.assertEquals(tmpForm.getTemplateName(),"tmp");
        Assert.assertEquals(tmpForm.getType(),requestForm.getType());
        Assert.assertEquals(new String(tmpForm.getPersonalizedData()),"new data");

        try {
            RequestForm f = new RequestForm();
            f.setLabel("new label");
            f.setShortLabel("new short label");
            f.setPersonalizedData("new data".getBytes());
            f.setTemplateName("tmp");
            iRequestTypeService.modifyRequestTypeForm(requestType.getId(), f);
            fail("RequestForm data can't be duplicated");
        } catch (CvqModelException cvqme) {
            Assert.assertEquals("requestForm.message.labelAlreadyUsed", cvqme.getI18nKey());
        } finally {
            iRequestTypeService.removeRequestTypeForm(requestType.getId(), tmpForm.getId());
            forms = iRequestTypeService.getRequestTypeForms(requestType.getId(),
                RequestFormType.REQUEST_MAIL_TEMPLATE);
            Assert.assertEquals(0, forms.size());
        }
    }
}

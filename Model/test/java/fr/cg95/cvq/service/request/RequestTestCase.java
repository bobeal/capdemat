package fr.cg95.cvq.service.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.business.request.LocalReferentialData;
import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.request.technical.TechnicalInterventionRequest;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.document.IDocumentTypeService;
import fr.cg95.cvq.testtool.ServiceTestCase;
import fr.cg95.cvq.util.Critere;

public class RequestTestCase extends ServiceTestCase {

    @Autowired
    protected IDocumentService documentService;
    @Autowired
    protected IDocumentTypeService documentTypeService;
    
    @Autowired
    protected IRequestSearchService requestSearchService;
    @Autowired
    protected IRequestWorkflowService requestWorkflowService;
    @Autowired
    protected IRequestDocumentService requestDocumentService;
    @Autowired
    protected IRequestTypeService requestTypeService;
    @Autowired
    protected ICategoryService categoryService;
    @Autowired
    protected ILocalReferentialService localReferentialService;

    protected String tirLabel = "Technical Intervention";
    protected Request request;

    @Override
    public void onSetUp() throws Exception {
        
        super.onSetUp();
        
        IGenericDAO genericDAO = getApplicationBean("genericDAO");

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        List<Category> categories = categoryService.getAll();
        Category category = null;
        if (categories == null || categories.isEmpty()) {
            logger.warn("No category found, creating one");
            category = new Category();
            category.setName("General");

            genericDAO.create(category);
        } else {
            category = categories.get(0);
        }

        List<RequestType> requestTypesSet = requestTypeService.getAllRequestTypes();
        for (RequestType requestType : requestTypesSet) {
            requestType.setCategory(category);
            genericDAO.update(requestType);
        }
        category.setRequestTypes(new HashSet<RequestType>(requestTypesSet));
        genericDAO.update(category);

        Agent agent = agentService.getByLogin(agentNameWithCategoriesRoles);
        categoryService.addCategoryRole(agent.getId(), category.getId(), 
                CategoryProfile.READ_WRITE);
        agent = agentService.getByLogin(agentNameWithManageRoles);
        categoryService.addCategoryRole(agent.getId(), category.getId(), 
                CategoryProfile.MANAGER);

        continueWithNewTransaction();
        SecurityContext.setCurrentAgent(agentNameWithManageRoles);
        if (!localReferentialService.isLocalReferentialConfigured(tirLabel)) {
            Set<LocalReferentialType> lrts =
                localReferentialService.getLocalReferentialDataByRequestType(tirLabel);
            for (LocalReferentialType lrt : lrts) {
                LocalReferentialEntry entry = new LocalReferentialEntry();
                entry.addLabel("fr", "abc");
                lrt.addEntry(entry, null);
                localReferentialService.setLocalReferentialData(lrt);
            }
            continueWithNewTransaction();
        }
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        request = createRequest();
        continueWithNewTransaction();
    }

    @Override
    public void onTearDown() throws Exception {
        try {
            continueWithNewTransaction();
            SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
            SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
            requestWorkflowService.delete(request);
            continueWithNewTransaction();
            // ensure all requests have been deleted after each test
            assertEquals(0, requestSearchService.get(new HashSet<Critere>(), null, null, -1, 0, false).size());
            rollbackTransaction();
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error during tear down : " + e.getMessage());
        }
        super.onTearDown();
    }

    public Request createRequest()
        throws CvqException {
        String currentContext = SecurityContext.getCurrentContext();
        Agent currentAgent = SecurityContext.getCurrentAgent();
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.FRONT_OFFICE_CONTEXT);
        SecurityContext.setCurrentEcitizen(fake.responsibleId);
        TechnicalInterventionRequest request = (TechnicalInterventionRequest)requestWorkflowService.getSkeletonRequest("Technical Intervention");
        LocalReferentialData lrd = new LocalReferentialData();
        lrd.setName("abc");
        List<LocalReferentialData> interventionTypes = new ArrayList<LocalReferentialData>();
        interventionTypes.add(lrd);
        request.setInterventionType(interventionTypes);
        request.setInterventionDescription("description");
        requestWorkflowService.create(request, null);
        continueWithNewTransaction();
        if (currentContext != null)
            SecurityContext.setCurrentContext(currentContext);
        if (currentAgent != null)
            SecurityContext.setCurrentAgent(currentAgent);
        return request;
    }
}

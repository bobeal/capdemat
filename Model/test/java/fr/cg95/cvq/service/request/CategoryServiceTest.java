package fr.cg95.cvq.service.request;

import java.util.List;

import junit.framework.Assert;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;

public class CategoryServiceTest extends RequestTestCase {

    public void testCreateDelete() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        int nbOfCategories = iCategoryService.getAll().size();

        Category category = new Category("Environnement", "category@blop.fr");
        category.addEmail("category@dummy.fr");
        category.addEmail("blop@valdoise.fr");

        try {
            iCategoryService.create(category);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Long newCategoryId = iCategoryService.create(category);

        assertEquals(nbOfCategories + 1, iCategoryService.getAll().size());
        Category newCategory = iCategoryService.getById(newCategoryId);
        assertEquals("Environnement", newCategory.getName());
        assertEquals("category@blop.fr", newCategory.getPrimaryEmail());
        assertEquals(2, newCategory.getEmails().size());

        newCategory.removeEmail("blop@valdoise.fr");
        iCategoryService.modify(newCategory);

        continueWithNewTransaction();

        newCategory = iCategoryService.getById(newCategoryId);
        assertEquals(1, newCategory.getEmails().size());

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        try {
            iCategoryService.delete(category.getId());
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.delete(category.getId());

        continueWithNewTransaction();
        assertEquals(nbOfCategories, iCategoryService.getAll().size());
    }
    
    public void testListAllFiltering() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        Category category = new Category("Environnement", null);
        iCategoryService.create(category);
        
        continueWithNewTransaction();
        
        assertEquals(2, iCategoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(1, iCategoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.delete(category.getId());
    }

    public void testAgentAssociation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Category category = new Category("Environnement", "category@blop.fr");
        Long associatedCategoryId = iCategoryService.create(category);

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Long associatedAgentId = SecurityContext.getCurrentAgent().getId();
        int agentAssociatedCategories = iCategoryService.getAssociated().size();

        try {
            iCategoryService.addCategoryRole(associatedAgentId, associatedCategoryId,
                CategoryProfile.READ_WRITE);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        try {
            iCategoryService.addCategoryRole(associatedAgentId, associatedCategoryId,
                CategoryProfile.READ_WRITE);
        } catch (PermissionException pe) {
            fail("should not have thrown an exception");
        }

        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(agentAssociatedCategories + 1, iCategoryService.getAssociated().size());

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.removeCategoryRole(associatedAgentId, associatedCategoryId);
        iCategoryService.delete(associatedCategoryId);

        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(agentAssociatedCategories, iCategoryService.getAssociated().size());
}

    public void testRequestTypeAssociation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        List<RequestType> requestTypesSet = iRequestTypeService.getAllRequestTypes();
        int requestTypesNb = requestTypesSet.size();

        List<Category> categoriesList = iCategoryService.getAll();
        assertEquals(1, categoriesList.size());
        Category category1 = categoriesList.get(0);

        // create a category to make some tests with
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Category category2 = new Category("Une autre catégorie", "category@blop.fr");
        Long newCategoryId = iCategoryService.create(category2);

        continueWithNewTransaction();

        // associate the new category with account creation requests
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        RequestType requestTypeToAdd = null;
        for (RequestType rt : requestTypesSet) {
            // add VO Card Request to the new category
            if (rt.getLabel().equals(IRequestService.VO_CARD_REGISTRATION_REQUEST)) {
                requestTypeToAdd = rt;
                break;
            }
        }
        try {
            iCategoryService.addRequestType(newCategoryId, requestTypeToAdd.getId());
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // ok
        }

        // now, be an authorized admin and do the modification
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.addRequestType(newCategoryId, requestTypeToAdd.getId());

        continueWithNewTransaction();

        // be again a simple agent
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // check associations have been correctly saved
        category1 = iCategoryService.getById(category1.getId());
        assertEquals(requestTypesNb - 1, category1.getRequestTypes().size());
        category2 = iCategoryService.getById(category2.getId());
        assertEquals(1, category2.getRequestTypes().size());
        
        continueWithNewTransaction();

        // create an account creation request to make a test on categories rights
        gimmeAnHomeFolderWithRequest();
        
        continueWithNewTransaction();

        // to force re-association of agent within current session
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        try {
            iRequestService.getById(voCardRequestId);
            fail("should have thrown a permission exception");
        } catch (PermissionException pe) {
            // ok, that was expeceted
        }

        continueWithNewTransaction();

        // give agent the rights for the new category and retry to load the request
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        Agent categoryAgent = iAgentService.getByLogin(agentNameWithCategoriesRoles);
        iCategoryService.addCategoryRole(categoryAgent.getId(), category2.getId(),
            CategoryProfile.READ_ONLY);
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iRequestService.getById(voCardRequestId);
        
        continueWithNewTransaction();

        // rebind the original category with the account creation request
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.addRequestType(category1.getId(), requestTypeToAdd.getId());

        continueWithNewTransaction();

        // delete the created category
        iCategoryService.delete(category2.getId());
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        Assert.assertEquals(1, iCategoryService.getAll().size());
    }
}

package fr.cg95.cvq.service.request;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;

public class CategoryServiceTest extends RequestTestCase {

    @Test
    public void testCreateDelete() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        int nbOfCategories = categoryService.getAll().size();

        Category category = new Category("Environnement", "category@blop.fr");
        category.addEmail("category@dummy.fr");
        category.addEmail("blop@valdoise.fr");

        try {
            categoryService.create(category);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Long newCategoryId = categoryService.create(category);

        continueWithNewTransaction();
        
        assertEquals(nbOfCategories + 1, categoryService.getAll().size());
        Category newCategory = categoryService.getById(newCategoryId);
        assertEquals("Environnement", newCategory.getName());
        assertEquals("category@blop.fr", newCategory.getPrimaryEmail());
        assertEquals(2, newCategory.getEmails().size());

        newCategory.removeEmail("blop@valdoise.fr");
        categoryService.modify(newCategory);

        continueWithNewTransaction();

        newCategory = categoryService.getById(newCategoryId);
        assertEquals(1, newCategory.getEmails().size());

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        try {
            categoryService.delete(category.getId());
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryService.delete(category.getId());

        continueWithNewTransaction();
        
        assertEquals(nbOfCategories, categoryService.getAll().size());
    }
    
    @Test
    public void testListAllFiltering() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        Category category = new Category("Environnement", null);
        categoryService.create(category);
        
        continueWithNewTransaction();
        
        assertEquals(2, categoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(1, categoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryService.delete(category.getId());
    }

    @Test
    public void testAgentAssociation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Category category = new Category("Environnement", "category@blop.fr");
        Long associatedCategoryId = categoryService.create(category);

        continueWithNewTransaction();
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Long associatedAgentId = SecurityContext.getCurrentAgent().getId();
        int agentAssociatedCategories = categoryService.getAssociated().size();

        try {
            categoryService.addCategoryRole(associatedAgentId, associatedCategoryId,
                CategoryProfile.READ_WRITE);
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // that was expected
        }

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        try {
            categoryService.addCategoryRole(associatedAgentId, associatedCategoryId,
                CategoryProfile.READ_WRITE);
        } catch (PermissionException pe) {
            fail("should not have thrown an exception");
        }

        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(agentAssociatedCategories + 1, categoryService.getAssociated().size());

        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryService.removeCategoryRole(associatedAgentId, associatedCategoryId);
        categoryService.delete(associatedCategoryId);

        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(agentAssociatedCategories, categoryService.getAssociated().size());
    }

    @Test
    public void testRequestTypeAssociation() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        List<RequestType> requestTypesSet = requestTypeService.getAllRequestTypes();
        int requestTypesNb = requestTypesSet.size();

        List<Category> categoriesList = categoryService.getAll();
        assertEquals(1, categoriesList.size());
        Category category1 = categoriesList.get(0);

        // create a category to make some tests with
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Category category2 = new Category("Une autre catégorie", "category@blop.fr");
        Long newCategoryId = categoryService.create(category2);

        continueWithNewTransaction();

        // associate the new category with account creation requests
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        RequestType requestTypeToAdd = null;
        for (RequestType rt : requestTypesSet) {
            // add VO Card Request to the new category
            if (rt.getLabel().equals(IRequestTypeService.VO_CARD_REGISTRATION_REQUEST)) {
                requestTypeToAdd = rt;
                break;
            }
        }
        try {
            categoryService.addRequestType(newCategoryId, requestTypeToAdd.getId());
            fail("should have thrown an exception");
        } catch (PermissionException pe) {
            // ok
        }

        // now, be an authorized admin and do the modification
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryService.addRequestType(newCategoryId, requestTypeToAdd.getId());

        continueWithNewTransaction();

        // be again a simple agent
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // check associations have been correctly saved
        category1 = categoryService.getById(category1.getId());
        assertEquals(requestTypesNb - 1, category1.getRequestTypes().size());
        category2 = categoryService.getById(category2.getId());
        assertEquals(1, category2.getRequestTypes().size());
        
        continueWithNewTransaction();

        // create an account creation request to make a test on categories rights
        gimmeAnHomeFolderWithRequest();
        
        continueWithNewTransaction();

        // to force re-association of agent within current session
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        try {
            requestSearchService.getById(voCardRequestId);
            fail("should have thrown a permission exception");
        } catch (PermissionException pe) {
            // ok, that was expeceted
        }

        continueWithNewTransaction();

        // give agent the rights for the new category and retry to load the request
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);

        Agent categoryAgent = agentService.getByLogin(agentNameWithCategoriesRoles);
        categoryService.addCategoryRole(categoryAgent.getId(), category2.getId(),
            CategoryProfile.READ_ONLY);
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        requestSearchService.getById(voCardRequestId);
        
        continueWithNewTransaction();

        // rebind the original category with the account creation request
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryService.addRequestType(category1.getId(), requestTypeToAdd.getId());

        continueWithNewTransaction();

        // delete the created category
        categoryService.delete(category2.getId());
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        assertEquals(1, categoryService.getAll().size());
    }
}

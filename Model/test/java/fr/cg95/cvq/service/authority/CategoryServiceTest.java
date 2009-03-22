package fr.cg95.cvq.service.authority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.security.PermissionException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class CategoryServiceTest extends ServiceTestCase {

    public void testCreateDelete() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        Category category = new Category();
        category.setName("Environnement");
        category.setPrimaryEmail("category@blop.fr");
        category.addEmail("category@dummy.fr");
        category.addEmail("blop@valdoise.fr");

        try {
            iCategoryService.create(category);
            fail("should have thrown an exception");
        } catch (CvqPermissionException cpe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.create(category);
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        try {
            iCategoryService.delete(category.getId());
            fail("should have thrown an exception");
        } catch (CvqPermissionException cpe) {
            // that was expected
        }
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.delete(category.getId());
    }
    
    public void testListAllFiltering() throws CvqException {
        
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        
        Category category = new Category();
        category.setName("Environnement");
        iCategoryService.create(category);
        
        continueWithNewTransaction();
        
        Assert.assertEquals(2, iCategoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        Assert.assertEquals(1, iCategoryService.getAll().size());
        
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.delete(category.getId());
    }
    
    public void testAll() throws CvqException {

        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        List<RequestType> requestTypesSet = iRequestTypeService.getAllRequestTypes();
        int requestTypesNb = requestTypesSet.size();

        List categoriesList = iCategoryService.getAll();
        Assert.assertEquals(categoriesList.size(), 1);
        Category category1 = (Category) categoriesList.get(0);

        // create a category to make some tests with
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        Category category2 = new Category();
        category2.setName("Une autre catégorie");
        category2.setPrimaryEmail("category@blop.fr");
        category2.addEmail("category@dummy.fr");
        category2.addEmail("blop@valdoise.fr");
        
        Long categoryId = iCategoryService.create(category2);

        continueWithNewTransaction();

        // test retrieving by name
        Category categoryByName = iCategoryService.getByName("Une autre catégorie");
        Assert.assertNotNull(categoryByName);
        
        // test retrieving by id and do some modifications on it
        category2 = iCategoryService.getById(categoryId);
        Assert.assertEquals(2, category2.getEmails().size());
        category2.removeEmail("blop@valdoise.fr");
        iCategoryService.modify(category2);
        
        continueWithNewTransaction();
        
        category2 = iCategoryService.getById(categoryId);
        Assert.assertEquals(1, category2.getEmails().size());
        
        // associate the new category with account creation requests
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        Set<Long> categoryRtSet = new HashSet<Long>();
        for (RequestType rt : requestTypesSet) {
            // add VO Card Request to the new category
            if (rt.getLabel().equals("VO Card Request")) {
                categoryRtSet.add(rt.getId());
                break;
            }
        }
        try {
            iCategoryService.updateCategoryRequestsAssociation(category2.getId(), categoryRtSet);
            fail("should have thrown an exception");
        } catch (CvqPermissionException cpe) {
            // ok
        }

        continueWithNewTransaction();

        // now, be an authorized admin and do the modification
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        iCategoryService.updateCategoryRequestsAssociation(category2.getId(), categoryRtSet);

        continueWithNewTransaction();

        // be again a simple agent
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);

        // check associations have been correctly saved
        category1 = iCategoryService.getById(category1.getId());
        Assert.assertEquals(category1.getRequestTypes().size(), requestTypesNb - 1);
        category2 = iCategoryService.getById(category2.getId());
        Assert.assertEquals(category2.getRequestTypes().size(), 1);
        
        continueWithNewTransaction();

        // create an account creation request to make a test on categories rights
        CreationBean creationBean = gimmeAnHomeFolder();
        
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
        Set agentCategoriesRolesSet = categoryAgent.getCategoriesRoles();
        CategoryRoles catRole = new CategoryRoles();
        catRole.setAgent(categoryAgent);
        catRole.setCategory(category2);
        catRole.setProfile(CategoryProfile.READ_ONLY);
        agentCategoriesRolesSet.add(catRole);
        iAgentService.modify(categoryAgent);
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        iRequestService.getById(voCardRequestId);
        
        continueWithNewTransaction();

        // rebind the original category with the account creation request
        SecurityContext.setCurrentAgent(agentNameWithSiteRoles);
        categoryRtSet = new HashSet<Long>();
        for (RequestType rt : requestTypesSet) {
            categoryRtSet.add(rt.getId());
        }
        iCategoryService.updateCategoryRequestsAssociation(category1.getId(), categoryRtSet);

        continueWithNewTransaction();

        // delete the created category
        iCategoryService.delete(category2.getId());
        
        continueWithNewTransaction();

        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        List allCategories = iCategoryService.getAll();
        Assert.assertEquals(allCategories.size(), 1);
    }
}

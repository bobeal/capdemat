package fr.cg95.cvq.service.authority.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.authority.ICategoryDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link ICategoryService category service}.
 *
 * @author bor@zenexity.fr
 */
public class CategoryService implements ICategoryService {

    static Logger logger = Logger.getLogger(CategoryService.class);

    private ICategoryDAO categoryDAO;
    private IRequestTypeDAO requestTypeDAO;

    private IAgentService agentService;
    
    @Override
    public Category getById(final Long id)
        throws CvqException, CvqObjectNotFoundException {
        Category category = 
            (Category) categoryDAO.findById(Category.class, id);
        return category;
    }

    private Category getByName(final String name)
        throws CvqException {
        return categoryDAO.findByName(name);
    }

    @Override
    public List<Category> getAll() throws CvqException {
        
        if (SecurityContext.isAdminContext())
            return categoryDAO.listAll();
        
        Agent agent = SecurityContext.getCurrentAgent();
        
        // if agent is admin, return all categories ...
        Set<SiteRoles> agentSiteRoles = agent.getSitesRoles();
        for (SiteRoles siteRole : agentSiteRoles) {
            if (siteRole.getProfile().equals(SiteProfile.ADMIN))
                return categoryDAO.listAll();
        }
        
        // else only return those categories it has a role on
        List<Category> results = new ArrayList<Category>();        
        Set<CategoryRoles> agentCategoriesRoles = agent.getCategoriesRoles();
        for (Object object : categoryDAO.listAll()) {
            Category category = (Category) object;
            if (agentCategoriesRoles != null) {
                for (CategoryRoles categoryRole : agentCategoriesRoles)
                    // it is one of the authorized categories for the current agent
                    if (categoryRole.getCategory().getId().equals(category.getId()))
                        results.add(category);
            }
        }

        return results;
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.NONE)
    public List<Category> getManaged() {
        List<Category> results = new ArrayList<Category>();

        CategoryRoles[] agentCategoryRoles =
            SecurityContext.getCurrentCredentialBean().getCategoryRoles();
        for (CategoryRoles categoryRole : agentCategoryRoles) {
            if (categoryRole.getProfile().equals(CategoryProfile.MANAGER))
                results.add(categoryRole.getCategory());
        }
        
        return results;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Long create(final Category category)
        throws CvqException {

        if (category == null)
            throw new CvqException("No Category object provided !");

        // check there is not yet a category with the same name
        if (getByName(category.getName()) != null) {
            logger.error("create() there is already a category with name : " + category.getName());
            throw new CvqModelException("category.error.nameAlreadyExists");
        }

        Long categoryId = categoryDAO.create(category);

        logger.debug("create() created category object with id : " + categoryId);

        return categoryId;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void modify(final Category category)
        throws CvqException {

        // FIXME : check the new name does not conflit with an existing one
        
        if (category != null)
            categoryDAO.update(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void delete(final Long id)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("delete() gonna delete category object with id : " + id);

        Category category = 
            (Category) categoryDAO.findById(Category.class, id);
        if (category.getRequestTypes() != null) {
            for (RequestType requestType : category.getRequestTypes()) {
                requestType.setCategory(null);
            }
            category.setRequestTypes(null);
        }

        List<Agent> allAgents = agentService.getAll();
        for (Agent agent : allAgents) {
            if (agent.getCategoriesRoles() != null) {
                Set<CategoryRoles> newCategoriesRoles = new HashSet<CategoryRoles>();
                Iterator agentCategoriesIt = agent.getCategoriesRoles().iterator();
                while (agentCategoriesIt.hasNext()) {
                    CategoryRoles categoryRoles = (CategoryRoles) agentCategoriesIt.next();
                    if (!categoryRoles.getCategory().getId().equals(id)) {
                        newCategoriesRoles.add(categoryRoles);
                    }
                }
                agent.setCategoriesRoles(newCategoriesRoles);
                agentService.modify(agent);
            }
        }
        categoryDAO.delete(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public List<Agent> getAuthorizedForCategory(Long categoryId) throws CvqException {

        Critere critere = new Critere(Agent.SEARCH_BY_CATEGORY_ID, categoryId,
            Critere.EQUALS);
        Set<Critere> critereSet = new HashSet<Critere>();
        critereSet.add(critere);

        return agentService.get(critereSet);
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public boolean hasProfileOnCategory(Agent agent, Long categoryId) throws CvqException {

        Set<CategoryRoles> agentCategoryRoles = agent.getCategoriesRoles();
        for (CategoryRoles categoryRole : agentCategoryRoles) {
            if (categoryRole.getCategory().getId().equals(categoryId))
                    return true;
        }
        
        return false;
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public boolean hasWriteProfileOnCategory(Agent agent, Long categoryId) throws CvqException {
        Set<CategoryRoles> agentCategoryRoles = agent.getCategoriesRoles();
        for (CategoryRoles categoryRole : agentCategoryRoles) {
            if (categoryRole.getCategory().getId().equals(categoryId)
                && (categoryRole.getProfile().equals(CategoryProfile.MANAGER)
                || categoryRole.getProfile().equals(CategoryProfile.READ_WRITE )))
                    return true;
        }
        
        return false;        
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Category addRequestType(Long categoryId, Long requestTypeId) throws CvqException {

        Category category = 
            (Category) categoryDAO.findById(Category.class, categoryId);
        RequestType requestType = 
            (RequestType) requestTypeDAO.findById(RequestType.class, requestTypeId);
        requestType.setCategory(category);
        if (category.getRequestTypes() == null)
            category.setRequestTypes(new HashSet<RequestType>());
        category.getRequestTypes().add(requestType);

        categoryDAO.update(category);
        return category;
   }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Category removeRequestType(Long categoryId, Long requestTypeId) throws CvqException {

        Category category = 
            (Category) categoryDAO.findById(Category.class, categoryId);
        RequestType requestType = 
            (RequestType) requestTypeDAO.findById(RequestType.class, requestTypeId);
        requestType.setCategory(null);
        category.getRequestTypes().remove(requestType);

        categoryDAO.update(category);
        return category;
    }

    public void setCategoryDAO(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public void setRequestTypeDAO(IRequestTypeDAO requestTypeDAO) {
        this.requestTypeDAO = requestTypeDAO;
    }

    public void setAgentService(IAgentService agentService) {
        this.agentService = agentService;
    }
}

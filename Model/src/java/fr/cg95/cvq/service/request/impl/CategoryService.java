package fr.cg95.cvq.service.request.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.request.Category;
import fr.cg95.cvq.business.request.CategoryProfile;
import fr.cg95.cvq.business.request.CategoryRoles;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.request.ICategoryDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.IAgentService;
import fr.cg95.cvq.service.request.ICategoryService;

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
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public Category getById(final Long id)
        throws CvqObjectNotFoundException {
        Category category = 
            (Category) categoryDAO.findById(Category.class, id);
        return category;
    }

    private Category getByName(final String name) {
        return categoryDAO.findByName(name);
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public List<Category> getAll() {
        
        if (SecurityContext.isAdminContext())
            return categoryDAO.listAll();
        
        // if agent is an admin, return the whole list
        if (SecurityContext.getCurrentCredentialBean().hasSiteAdminRole())
            return categoryDAO.listAll();
        
        // else only return those categories it has a role on
        return categoryDAO.listByAgent(SecurityContext.getCurrentAgent().getId(), null);
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public List<Category> getManaged() {
        return categoryDAO.listByAgent(SecurityContext.getCurrentUserId(), CategoryProfile.MANAGER);
    }

    @Override
    @Context(type=ContextType.AGENT,privilege=ContextPrivilege.NONE)
    public List<Category> getAssociated() {
        return categoryDAO.listByAgent(SecurityContext.getCurrentUserId(), null);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Long create(final Category category)
        throws CvqException, CvqModelException {

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
    public void modify(final Category category) {
        // FIXME : check the new name does not conflit with an existing one
        if (category != null)
            categoryDAO.update(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void delete(final Long id)
        throws CvqObjectNotFoundException {

        logger.debug("delete() gonna delete category object with id : " + id);

        Category category = 
            (Category) categoryDAO.findById(Category.class, id);
        if (category.getRequestTypes() != null) {
            for (RequestType requestType : category.getRequestTypes()) {
                requestType.setCategory(null);
            }
            category.setRequestTypes(null);
        }

        categoryDAO.delete(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public List<Agent> getAuthorizedForCategory(Long categoryId) throws CvqObjectNotFoundException {

        List<Agent> agentsList = new ArrayList<Agent>();
        Category category = getById(categoryId);
        for (CategoryRoles categoryRoles : category.getCategoriesRoles()) {
            agentsList.add(agentService.getById(categoryRoles.getAgentId()));
        }

        return agentsList;
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public boolean hasProfileOnCategory(Agent agent, Long categoryId) 
        throws CvqObjectNotFoundException {

        if (categoryId == null)
            return false;
        
        Category category = getById(categoryId);
        for (CategoryRoles categoryRoles : category.getCategoriesRoles()) {
            if (categoryRoles.getAgentId().equals(agent.getId()))
                return true;
        }

        return false;
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public boolean hasWriteProfileOnCategory(Agent agent, Long categoryId) 
        throws CvqObjectNotFoundException {
        
        if (categoryId == null)
            return false;

        Category category = getById(categoryId);
        for (CategoryRoles categoryRole : category.getCategoriesRoles()) {
            if (categoryRole.getAgentId().equals(agent.getId())
                && (categoryRole.getProfile().equals(CategoryProfile.MANAGER)
                || categoryRole.getProfile().equals(CategoryProfile.READ_WRITE )))
                return true;
        }

        return false;        
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public CategoryProfile getProfileForCategory(final Long categoryId) 
        throws CvqObjectNotFoundException {
        return getProfileForCategory(SecurityContext.getCurrentAgent().getId(), categoryId);
    }

    @Override
    @Context(type=ContextType.AGENT_ADMIN,privilege=ContextPrivilege.NONE)
    public CategoryProfile getProfileForCategory(final Long agentId, final Long categoryId) 
        throws CvqObjectNotFoundException {
        Category category = getById(categoryId);
        for (CategoryRoles categoryRoles : category.getCategoriesRoles()) {
            if (categoryRoles.getAgentId().equals(agentId))
                return categoryRoles.getProfile();
        }

        return null;
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

        Category category = getById(categoryId);
        RequestType requestType = 
            (RequestType) requestTypeDAO.findById(RequestType.class, requestTypeId);
        requestType.setCategory(null);
        category.getRequestTypes().remove(requestType);

        categoryDAO.update(category);
        return category;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void addCategoryRole(final Long agentId, final  Long categoryId,
            final CategoryProfile categoryProfile ) throws CvqException {

        if (agentId == null)
            throw new CvqException("No agent id provided");
        Category category = getById(categoryId);

        CategoryRoles categoryRoles = new CategoryRoles();
        categoryRoles.setAgentId(agentId);
        categoryRoles.setCategory(category);
        categoryRoles.setProfile(categoryProfile);
        category.addCategoryRole(categoryRoles);

        modify(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void modifyCategoryRole(final Long agentId, final  Long categoryId,
            final CategoryProfile categoryProfile ) throws CvqException {

        if (agentId == null)
            throw new CvqException("No agent id provided");
        Category category = getById(categoryId);

        boolean foundCategoryRole = false;
        for (CategoryRoles categoryRoles : category.getCategoriesRoles()) {
            if (categoryRoles.getAgentId().equals(agentId)) {
                categoryRoles.setProfile(categoryProfile);
                foundCategoryRole = true;
                break;
            }
        }
        if (!foundCategoryRole) {
            CategoryRoles categoryRoles = new CategoryRoles();
            categoryRoles.setAgentId(agentId);
            categoryRoles.setCategory(getById(categoryId));
            categoryRoles.setProfile(categoryProfile);
            category.getCategoriesRoles().add(categoryRoles);
        }

        modify(category);
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void removeCategoryRole(final Long agentId, final  Long categoryId) throws CvqException {

        if (agentId == null)
            throw new CvqException("No agent id provided");
        Category category = getById(categoryId);

        boolean foundCategoryRole = false;
        for (CategoryRoles categoryRoles : category.getCategoriesRoles()) {
            if (categoryRoles.getAgentId().equals(agentId)) {
                category.getCategoriesRoles().remove(categoryRoles);
                foundCategoryRole = true;
                break;
            }
        }
        if (foundCategoryRole)
            modify(category);
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

package fr.cg95.cvq.service.users.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Agent;
import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.dao.users.IRequestDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.permission.CvqPermissionException;
import fr.cg95.cvq.permission.PrivilegeDescriptor;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ICategoryService;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.users.IRequestStatisticsService;
import fr.cg95.cvq.util.Critere;

/**
 * Implementation of the {@link IRequestStatisticsService statistics service}.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class RequestStatisticsService implements IRequestStatisticsService {

    private static Logger logger = Logger.getLogger(RequestStatisticsService.class);
    
    private IRequestDAO requestDAO;
    private ICategoryService categoryService;
    
    public RequestStatisticsService() {
        super();
    }

    /**
     * FIXME : This should be better handled by an aspect. 
     */
    private void checkAgentRights() throws CvqException {
        Agent agent = SecurityContext.getCurrentAgent();
        Set<CategoryRoles> agentCategoriesRoles = agent.getCategoriesRoles();
        for (CategoryRoles categoryRole : agentCategoriesRoles) {
            if (categoryRole.getProfile().equals(CategoryProfile.MANAGER))
                return;
        }
        
        throw new CvqPermissionException("Statistics", PrivilegeDescriptor.MANAGE);
    }
    
    private List<String> getCategoriesWithManagerProfile(Agent agent) 
        throws CvqException {
        
        List<Category> agentCategories = 
            categoryService.getAgentManagedCategories(agent);
        List<String> categoriesNames = new ArrayList<String>();
        for (Category category : agentCategories) {
            categoriesNames.add(category.getName());
        }
        
        return categoriesNames;
    }
    
    public Long getCount(final Set criteriaSet)
        throws CvqException {

        checkAgentRights();
        
        Critere crit = new Critere();
        List<Category> agentCategories = 
            categoryService.getAgentManagedCategories(SecurityContext.getCurrentAgent());
        StringBuffer sb = new StringBuffer();
        for (Category category : agentCategories) {
            if (sb.length() > 0)
                sb.append(",");
            sb.append("'").append(category.getId()).append("'");
        }
        crit.setAttribut("belongsToCategory");
        crit.setComparatif(Critere.EQUALS);
        crit.setValue(sb.toString());
        criteriaSet.add(crit);

        return requestDAO.count(criteriaSet);
    }

    public Long getCountByQuality(final Date startDate, final Date endDate, 
            final String qualityType, final String requestTypeLabel, final String categoryName) 
        throws CvqException {

        checkAgentRights();
        
        LocalAuthorityConfigurationBean lacb = SecurityContext.getCurrentConfigurationBean();
        if (!lacb.getInstructionAlertsEnabled().booleanValue())
            return new Long(0);
            
        Agent agent = SecurityContext.getCurrentAgent();
        
        if (categoryName != null && !categoryName.equals("")) {
            if (categoryService.hasManagerProfileOnCategory(agent, categoryName)) {
                List<String> categoriesNames = new ArrayList<String>();
                categoriesNames.add(categoryName);
                return requestDAO.countByQuality(startDate, endDate, lacb.getInstructionDoneStates(),
                        qualityType, requestTypeLabel, categoriesNames);
            } else {
                logger.debug("getCountByQuality() user has no MANAGER profile on category "
                        + categoryName);
                return new Long(0);
            }
        } else {
            return requestDAO.countByQuality(startDate, endDate, lacb.getInstructionDoneStates(),
                    qualityType, requestTypeLabel, getCategoriesWithManagerProfile(agent));
        }
    }

    public Long getCountByResultingState(final String resultingState, 
            final Date startDate, final Date endDate, final String requestTypeLabel, 
            final String categoryName) 
        throws CvqException {

        checkAgentRights();
        
        Agent agent = SecurityContext.getCurrentAgent();
        
        if (categoryName != null && !categoryName.equals("")) {
            if (categoryService.hasManagerProfileOnCategory(agent, categoryName)) {
                List<String> categoriesNames = new ArrayList<String>();
                categoriesNames.add(categoryName);
                return requestDAO.countByResultingState(resultingState, startDate, endDate, 
                        requestTypeLabel, categoriesNames);
            } else {
                logger.debug("getCountByResultingState() user has no MANAGER profile on category "
                        + categoryName);
                return new Long(0);
            }
        } else {
            return requestDAO.countByResultingState(resultingState, startDate, endDate, 
                    requestTypeLabel, getCategoriesWithManagerProfile(agent));
        }
    }

	public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
}

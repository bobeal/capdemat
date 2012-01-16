package fr.cg95.cvq.service.request.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.jpa.IGenericDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.request.IDisplayGroupService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;

/**
 * @author rdj@zenexity.fr
 */
public class DisplayGroupService implements IDisplayGroupService, ILocalAuthorityLifecycleAware {
    static Logger logger = Logger.getLogger(DisplayGroupService.class);

    private IGenericDAO genericDAO;
    private IRequestTypeDAO requestTypeDAO;
    private IRequestServiceRegistry requestServiceRegistry;

    @Context(types = {ContextType.SUPER_ADMIN})
    private void bootstrap() {
        logger.debug("bootstrap display group");
        if(getAll().size() > 0)
            return;

        Map<String, DisplayGroup> displayGroups = new HashMap<String, DisplayGroup>();
        displayGroups.put("school", new DisplayGroup("school","Scolaire"));
        displayGroups.put("babyhood", new DisplayGroup("babyhood","Petite enfance"));
        displayGroups.put("civil", new DisplayGroup("civil","Etat civil"));
        displayGroups.put("social", new DisplayGroup("social","Social"));
        displayGroups.put("environment", new DisplayGroup("environment","Environnement"));
        displayGroups.put("election", new DisplayGroup("election","Election"));
        displayGroups.put("security", new DisplayGroup("security","Sécurité"));
        displayGroups.put("leisure", new DisplayGroup("leisure","Loisirs"));
        displayGroups.put("culture", new DisplayGroup("culture","Culturel"));
        displayGroups.put("technical", new DisplayGroup("technical","Service technique"));
        displayGroups.put("urbanism", new DisplayGroup("urbanism","Urbanisme"));

        try {
            for (DisplayGroup dg : displayGroups.values())
                create(dg);

            for (RequestType rt : requestTypeDAO.listAll()) {
                IRequestService service = requestServiceRegistry.getRequestService(rt.getLabel());
                DisplayGroup dg =  displayGroups.get(service.getDefaultDisplayGroup());
                if (dg != null)
                    addRequestType(dg.getId(), rt.getId());
            }
        } catch (CvqException cvqe) {
            logger.equals("Display Group init failed !");
            cvqe.printStackTrace();
        }
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN})
    public void addLocalAuthority(String localAuthorityName) {
        bootstrap();
    }

    @Override
    @Context(types = {ContextType.SUPER_ADMIN})
    public void removeLocalAuthority(String localAuthorityName) {
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public DisplayGroup addRequestType(Long displayGroupId, Long requestTypeId) {
        DisplayGroup displayGroup = getById(displayGroupId);
        RequestType requestType = requestTypeDAO.findById(requestTypeId);
        
        requestType.setDisplayGroup(displayGroup);
        displayGroup.getRequestTypes().add(requestType);
        
        genericDAO.update(displayGroup);
        
        return displayGroup;
    }
    
    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public DisplayGroup removeRequestType(Long displayGroupId, Long requestTypeId) {
        DisplayGroup displayGroup = getById(displayGroupId);
        RequestType requestType = requestTypeDAO.findById(requestTypeId);
        
        requestType.setDisplayGroup(null);
        displayGroup.getRequestTypes().remove(requestType);
       
        genericDAO.update(displayGroup);
        
        return displayGroup;
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public void delete(Long id) {
        DisplayGroup displayGroup = 
            (DisplayGroup)genericDAO.findById(DisplayGroup.class, id);
        if (displayGroup.getRequestTypes() != null) {
            for (RequestType requestType : displayGroup.getRequestTypes())
                requestType.setDisplayGroup(null);
            displayGroup.setRequestTypes(null);
        }
        genericDAO.delete(displayGroup);
    }

    @Override
    public List<DisplayGroup> getAll() {
        return this.requestTypeDAO.listAllDisplayGroup();
    }

    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public DisplayGroup getById(Long id) {
        return (DisplayGroup)genericDAO.findById(DisplayGroup.class, id);
    }


    private void checkDisplayGroup(DisplayGroup displayGroup) throws CvqModelException {
        if (displayGroup == null)
            throw new CvqModelException("displayGroup.error.notProvided");
        for(DisplayGroup dg:getAll()) {
            if (dg.getId().equals(displayGroup.getId()))
                continue;
            if(displayGroup.getName().equals(dg.getName()))
                throw new CvqModelException("displayGroup.error.nameAlreadyExists");
            if(displayGroup.getLabel().equals(dg.getLabel()))
                throw new CvqModelException("displayGroup.error.labelAlreadyExists");
        }
    }
    
    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public Long create(DisplayGroup displayGroup) throws CvqModelException {
        checkDisplayGroup(displayGroup);
        return ((DisplayGroup)genericDAO.create(displayGroup)).getId();
    }
    
    @Override
    @Context(types = {ContextType.ADMIN}, privilege = ContextPrivilege.NONE)
    public void modify(DisplayGroup displayGroup) throws CvqModelException {
        checkDisplayGroup(displayGroup);
        genericDAO.saveOrUpdate(displayGroup);
    }

    public void setGenericDAO(IGenericDAO genericDAO) {
        this.genericDAO = genericDAO;
    }

    public void setRequestTypeDAO(IRequestTypeDAO requestTypeDAO) {
        this.requestTypeDAO = requestTypeDAO;
    }

    public void setRequestServiceRegistry(IRequestServiceRegistry requestServiceRegistry) {
        this.requestServiceRegistry = requestServiceRegistry;
    }
}
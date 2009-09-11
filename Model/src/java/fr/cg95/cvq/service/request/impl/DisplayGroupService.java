package fr.cg95.cvq.service.request.impl;

import java.util.List;

import fr.cg95.cvq.business.request.DisplayGroup;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.dao.IGenericDAO;
import fr.cg95.cvq.dao.request.IRequestTypeDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.annotation.Context;
import fr.cg95.cvq.security.annotation.ContextPrivilege;
import fr.cg95.cvq.security.annotation.ContextType;
import fr.cg95.cvq.service.request.IDisplayGroupService;

/**
 * @author rdj@zenexity.fr
 */
public class DisplayGroupService implements IDisplayGroupService {

    private IGenericDAO genericDAO;
    private IRequestTypeDAO requestTypeDAO;

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public DisplayGroup addRequestType(Long displayGroupId, Long requestTypeId) throws CvqException {
        DisplayGroup displayGroup = getById(displayGroupId);
        RequestType requestType = (RequestType)genericDAO.findById(RequestType.class, requestTypeId);
        
        requestType.setDisplayGroup(displayGroup);
        displayGroup.getRequestTypes().add(requestType);
        
        genericDAO.update(displayGroup);
        
        return displayGroup;
    }
    
    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public DisplayGroup removeRequestType(Long displayGroupId, Long requestTypeId)
            throws CvqException {
        DisplayGroup displayGroup = getById(displayGroupId);
        RequestType requestType = (RequestType)genericDAO.findById(RequestType.class, requestTypeId);
        
        requestType.setDisplayGroup(null);
        displayGroup.getRequestTypes().remove(requestType);
       
        genericDAO.update(displayGroup);
        
        return displayGroup;
    }

    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public void delete(Long id) throws CvqObjectNotFoundException {
        DisplayGroup displayGroup = 
            (DisplayGroup) genericDAO.findById(DisplayGroup.class, id);
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
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public DisplayGroup getById(Long id) throws CvqObjectNotFoundException {
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
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
    public Long create(DisplayGroup displayGroup) throws CvqModelException {
        checkDisplayGroup(displayGroup);
        return genericDAO.create(displayGroup);
    }
    
    @Override
    @Context(type=ContextType.ADMIN,privilege=ContextPrivilege.NONE)
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
}

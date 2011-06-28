package fr.cg95.cvq.service.request.school.impl;

import java.util.Date;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.ChildCareCenterRegistrationRequest;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.RoleType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;

public class ChildCareCenterRegistrationRequestService extends RequestService {
    
    private static Logger logger = Logger.getLogger(ChildCareCenterRegistrationRequestService.class);
    private IIndividualService individualService;
    private IHomeFolderService homeFolderService; 	
    
    @Override
    public void onRequestCreated(final Request request) 
        throws CvqException{
        logger.debug("Child care center Request is created !!");
        ChildCareCenterRegistrationRequest cccrr = (ChildCareCenterRegistrationRequest) request;
        Individual child = individualService.getById(cccrr.getSubjectId());
        Individual requester = individualService.getById(cccrr.getRequesterId());
        if(child.getFirstName().equals("A NAITRE") && child.getLastName().equals("NOUVEL ENFANT")){
    		child.setLastName(cccrr.getRequesterLastName());
    		if(!cccrr.getSubjectChoiceBirthDate().equals(null)){
    		    child.setBirthDate(new Date());
    		    child.setSex(cccrr.getSubjectChoiceGender());
    		} else {
    		    child.setBirthDate(new Date()); // a way to ovoid forgotten field
    		}
    		RoleType role = new RoleType();
    		if(requester.getSex().equals(SexType.MALE)){
    		    role = RoleType.CLR_FATHER;
    		} else if (requester.getSex().equals(SexType.FEMALE)){
    		    role = RoleType.CLR_MOTHER;
    		} else {
    		    role = RoleType.CLR_TUTOR;
    		}
    		individualService.modify(child);
    		homeFolderService.addRole(requester, child, role);
    		
    	}else{
    		for(Individual childToDel: homeFolderService.getChildren(cccrr.getHomeFolderId())){
    			if(childToDel.getLastName().equals("NOUVEL ENFANT")){
    				 childToDel.setHomeFolder(null);
    				individualService.modify(childToDel);    				
    			}
    		}
    	}
    }


    @Override
    public void onRequestCancelled(final Request request) throws CvqException {
 	ChildCareCenterRegistrationRequest cccrr = (ChildCareCenterRegistrationRequest) request;
	Child child =(Child) individualService.getById(cccrr.getSubjectId());
        if(child.getFirstName().equals("A NAITRE") ){
            HomeFolder homeFolder = homeFolderService.getById(cccrr.getHomeFolderId());
            homeFolderService.removeRolesOnSubject(cccrr.getHomeFolderId(), cccrr.getSubjectId());
            child.setHomeFolder(null);
            homeFolder.getIndividuals().remove(child);
            individualService.modify(child);
	}

    }
    
    @Override
    public void onRequestRejected(final Request request) throws CvqException {
        ChildCareCenterRegistrationRequest cccrr = (ChildCareCenterRegistrationRequest) request;
        Child child = (Child)individualService.getById(cccrr.getSubjectId());
        if(child.getFirstName().equals("A NAITRE") ){
            HomeFolder homeFolder = homeFolderService.getById(cccrr.getHomeFolderId());
            homeFolderService.removeRolesOnSubject(cccrr.getHomeFolderId(), cccrr.getSubjectId());
            child.setHomeFolder(null);
            homeFolder.getIndividuals().remove(child);
            individualService.modify(child);
        }


    }

    @Override
    public void onRequestValidated(Request request) throws CvqException {
        super.onRequestValidated(request);
        ChildCareCenterRegistrationRequest cccrr = (ChildCareCenterRegistrationRequest) request;
        Child child =(Child) individualService.getById(cccrr.getSubjectId());
        if(child.getFirstName().equals("A NAITRE") ){
            child.setState(ActorState.VALID);
            individualService.modify(child);
        }
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof ChildCareCenterRegistrationRequest;
    }
    
   
    @Override
    public Request getSkeletonRequest() {
        return new ChildCareCenterRegistrationRequest();
    }
    
    @Override
    public void init(){
        ChildCareCenterRegistrationRequest.conditions.put("mondayPeriod", new EqualityChecker("halfDay"));
        ChildCareCenterRegistrationRequest.conditions.put("fridayPeriod", new EqualityChecker("halfDay"));
        ChildCareCenterRegistrationRequest.conditions.put("thursdayPeriod", new EqualityChecker("halfDay"));
        ChildCareCenterRegistrationRequest.conditions.put("tuesdayPeriod", new EqualityChecker("halfDay"));
        ChildCareCenterRegistrationRequest.conditions.put("wednesdayPeriod", new EqualityChecker("halfDay"));
    }
    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }
}

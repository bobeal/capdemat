package fr.cg95.cvq.service.request.election.impl;



import org.apache.log4j.Logger;


import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.election.MultiCerfaElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public class MultiCerfaElectoralRollRegistrationRequestService extends RequestService {
    
    private static Logger logger = Logger.getLogger(MultiCerfaElectoralRollRegistrationRequestService.class);
          
    
    @Override
    public void onRequestCreated(final Request request) 
        throws CvqException{
        MultiCerfaElectoralRollRegistrationRequest mcerrr = (MultiCerfaElectoralRollRegistrationRequest) request;       
        
        Individual subject = (Individual) genericDAO.findById(Individual.class, mcerrr.getSubjectId());
        subject.setBirthDate(mcerrr.getSubjectChoiceBirthDate());
        subject.setBirthCity(mcerrr.getSubjectChoiceBirthCity());
        subject.setBirthPostalCode(mcerrr.getSubjectChoiceBirthPostalCode());
        subject.setBirthCountry(mcerrr.getSubjectChoiceBirthCountry().toString());
                      
        if(subject instanceof Adult){
            Adult subjectAdult = (Adult) genericDAO.findById(Individual.class, mcerrr.getSubjectId());
            subjectAdult.setTitle(mcerrr.getSubjectChoiceTitle());
            if(mcerrr.getSubjectChoiceTitle().equals(TitleType.MADAM) || mcerrr.getSubjectChoiceTitle().equals(TitleType.MISS)){
                subjectAdult.setSex(SexType.FEMALE);
                subjectAdult.setMaidenName(mcerrr.getSubjectChoiceMaidenName());
            } else if(mcerrr.getSubjectChoiceTitle().equals(TitleType.MISTER)){
                subjectAdult.setSex(SexType.MALE);
            } else {
                subjectAdult.setSex(SexType.UNKNOWN);
            }
            subjectAdult.setHomePhone(mcerrr.getSubjectChoiceHomePhone());
            subjectAdult.setMobilePhone(mcerrr.getSubjectChoiceMobilPhone());
            subjectAdult.setOfficePhone(mcerrr.getSubjectChoiceProPhone());
            subjectAdult.setEmail(mcerrr.getSubjectChoiceEmail());
        }
        
    }
    
    @Override
    public void onRequestValidated(final Request request)
        throws CvqException, CvqObjectNotFoundException {
                
    }
    
    @Override
    public boolean accept(Request request) {
        return request instanceof MultiCerfaElectoralRollRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
         MultiCerfaElectoralRollRegistrationRequest request= new MultiCerfaElectoralRollRegistrationRequest();
        if (SecurityContext.getCurrentSite() != null) {           
            request.setRegistrationCity(SecurityContext.getCurrentSite().getDisplayTitle());
            request.setRegistrationPostalCode(SecurityContext.getCurrentSite().getPostalCode().substring(0,2));
        }
        return request;
    }
    
    @Override
    public void init() {
        MultiCerfaElectoralRollRegistrationRequest.conditions.put("choiceNationality",
                new EqualityChecker("FrenchNationality"));
        MultiCerfaElectoralRollRegistrationRequest.conditions.put("electionChoice",
                new EqualityChecker("EuropeanElectoral"));
        MultiCerfaElectoralRollRegistrationRequest.conditions.put("motive",
                new EqualityChecker("MoveOtherSubscription"));
        MultiCerfaElectoralRollRegistrationRequest.conditions.put("subjectChoiceTitle",
                new EqualityChecker("Madam"));
        
    }

}

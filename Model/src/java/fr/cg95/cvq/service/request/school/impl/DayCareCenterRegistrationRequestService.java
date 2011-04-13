package fr.cg95.cvq.service.request.school.impl;

import java.util.Arrays;
import java.util.Calendar;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.ChoixDatePlacement;
import fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType;
import fr.cg95.cvq.business.request.school.ChoixSituationActuelle;
import fr.cg95.cvq.business.request.school.DayCareCenterRegistrationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.users.IUserSearchService;

/**
 *
 * @author vsi@zenexity.fr
 */
public final class DayCareCenterRegistrationRequestService extends RequestService {

    IUserSearchService userSearchService;
    
    @Override
    public void init() {
        DayCareCenterRegistrationRequest.conditions.put("situationActuelleMere", new EqualityChecker(ChoixSituationActuelle.AUTRE.name()));
        DayCareCenterRegistrationRequest.conditions.put("situationActuellePere", new EqualityChecker(ChoixSituationActuelle.AUTRE.name()));
        DayCareCenterRegistrationRequest.conditions.put("estHorairesReguliersMere", new EqualityChecker("true"));
        DayCareCenterRegistrationRequest.conditions.put("estHorairesReguliersPere", new EqualityChecker("true"));
        DayCareCenterRegistrationRequest.conditions.put("choixTypeDatePlacementAccueilRegulier", new EqualityChecker(ChoixDatePlacement.CONNUE.name()));
        DayCareCenterRegistrationRequest.conditions.put("modeAccueil", new EqualityChecker("false"));
        DayCareCenterRegistrationRequest.conditions.put("choixHorairesAccueil",
                new EqualityListChecker(Arrays.asList("estHorairesAccueilRegulier="+ChoixHorairesAccueilType.REGULIER.name(),"estHorairesAccueilIrregulier="+ChoixHorairesAccueilType.IRREGULIER.name())));
    }
    
    @Override
    public boolean accept(final Request request) {
        return request instanceof DayCareCenterRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        DayCareCenterRegistrationRequest dccrr = new DayCareCenterRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null) {
            if (SecurityContext.getCurrentEcitizen().getMobilePhone() != null)
                dccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getMobilePhone());
            else if (SecurityContext.getCurrentEcitizen().getHomePhone() != null)
                dccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getHomePhone());
            else
                dccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getOfficePhone());
        }
        return dccrr;
    }
    
    @Override
    public void onRequestIssued(final Request request) {
        
        DayCareCenterRegistrationRequest dccrr = (DayCareCenterRegistrationRequest) request;
        // this hook is also called at the request's creation, when starting the form filling process
        // in this case, we do not have yet a subject
        if (dccrr.getSubjectId() != null) {
            // get the 18 months date of the subject
            Individual subject = userSearchService.getById(dccrr.getSubjectId());
            Calendar cal = Calendar.getInstance();
            cal.setTime(subject.getBirthDate());
            cal.add(Calendar.MONTH, 18);
            dccrr.setDixHuitMoisEnfant(cal.getTime());
        }
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }
}

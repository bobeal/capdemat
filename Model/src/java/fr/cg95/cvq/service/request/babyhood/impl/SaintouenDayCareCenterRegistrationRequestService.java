package fr.cg95.cvq.service.request.babyhood.impl;

import java.util.Arrays;
import java.util.Calendar;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.babyhood.SaintouenDayCareCenterRegistrationRequest;
import fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement;
import fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType;
import fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.users.IUserSearchService;

public class SaintouenDayCareCenterRegistrationRequestService extends RequestService {


    IUserSearchService userSearchService;

    @Override
    public void init() {
        SaintouenDayCareCenterRegistrationRequest.conditions.put("situationActuelleMere", new EqualityChecker(SdccrrChoixSituationActuelle.AUTRE.name()));
        SaintouenDayCareCenterRegistrationRequest.conditions.put("situationActuellePere", new EqualityChecker(SdccrrChoixSituationActuelle.AUTRE.name()));
        SaintouenDayCareCenterRegistrationRequest.conditions.put("estHorairesReguliersMere", new EqualityChecker("true"));
        SaintouenDayCareCenterRegistrationRequest.conditions.put("estHorairesReguliersPere", new EqualityChecker("true"));
        SaintouenDayCareCenterRegistrationRequest.conditions.put("choixTypeDatePlacementAccueilRegulier", new EqualityChecker(SdccrrChoixDatePlacement.CONNUE.name()));
        SaintouenDayCareCenterRegistrationRequest.conditions.put("choixHorairesAccueil",
                new EqualityListChecker(Arrays.asList("estHorairesAccueilRegulier="+SdccrrChoixHorairesAccueilType.REGULIER.name(),"estHorairesAccueilIrregulier="+SdccrrChoixHorairesAccueilType.IRREGULIER.name())));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SaintouenDayCareCenterRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        SaintouenDayCareCenterRegistrationRequest sdccrr = new SaintouenDayCareCenterRegistrationRequest();
        if (SecurityContext.getCurrentEcitizen() != null) {
            if (SecurityContext.getCurrentEcitizen().getMobilePhone() != null)
                sdccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getMobilePhone());
            else if (SecurityContext.getCurrentEcitizen().getHomePhone() != null)
                sdccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getHomePhone());
            else
                sdccrr.setTelephoneContact(SecurityContext.getCurrentEcitizen().getOfficePhone());
        }
        return sdccrr;
    }

    @Override
    public void onRequestIssued(final Request request) {
        
        SaintouenDayCareCenterRegistrationRequest sdccrr = (SaintouenDayCareCenterRegistrationRequest) request;
        // this hook is also called at the request's creation, when starting the form filling process
        // in this case, we do not have yet a subject
        if (sdccrr.getSubjectId() != null) {
            // get the 18 months date of the subject
            Individual subject = userSearchService.getById(sdccrr.getSubjectId());
            Calendar cal = Calendar.getInstance();
            cal.setTime(subject.getBirthDate());
            cal.add(Calendar.MONTH, 18);
            sdccrr.setDixHuitMoisEnfant(cal.getTime());
        }
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }
}

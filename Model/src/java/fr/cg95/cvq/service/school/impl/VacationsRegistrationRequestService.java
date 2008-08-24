package fr.cg95.cvq.service.school.impl;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.school.OtherIndividual;
import fr.cg95.cvq.business.school.OtherIndividualType;
import fr.cg95.cvq.business.school.VacationsDiary;
import fr.cg95.cvq.business.school.VacationsRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.school.IVacationsRegistrationRequestService;

/**
 * Implementation of the vacations registration request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public final class VacationsRegistrationRequestService
    extends RequestService implements IVacationsRegistrationRequestService {

    private static Logger logger = Logger.getLogger(VacationsRegistrationRequestService.class);

    public Long create(final Request request, final Long requesterId)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("create() Gonna create a vacations registration request");

        VacationsRegistrationRequest vrr = (VacationsRegistrationRequest) request;
        initializeCommonAttributes(vrr, requesterId);

        // create the association with the child
        Individual somebody = (Individual) vrr.getSubject();
        if (somebody instanceof Adult)
            throw new CvqObjectNotFoundException("The provided child id does not match a child object !");
        Child child = (Child) somebody;
        vrr.setChild(child);

        // create the contacts
        Set otherIndividualsSet = vrr.getOtherIndividual();
        if (otherIndividualsSet != null) {
            Iterator otherIndividualsSetIt = otherIndividualsSet.iterator();
            while (otherIndividualsSetIt.hasNext()) {
                OtherIndividual otherIndividual =
                    (OtherIndividual) otherIndividualsSetIt.next();
                // by default, it's a contact person type
                if (otherIndividual.getType() == null)
                    otherIndividual.setType(OtherIndividualType.CONTACT_PERSON);
                try {
                    genericDAO.create(otherIndividual);
                } catch (RuntimeException re) {
                    re.printStackTrace();
                    throw new CvqException("Could not create other individual : " + re.toString());
                }
            }
        }

        // create the vacations diary
        Set vacationsDiarySet = vrr.getVacationsDiary();
        if (vacationsDiarySet != null) {
            Iterator vacationsDiarySetIt = vacationsDiarySet.iterator();
            while (vacationsDiarySetIt.hasNext()) {
                VacationsDiary vacationsDiary =
                    (VacationsDiary) vacationsDiarySetIt.next();
                try {
                    genericDAO.create(vacationsDiary);
                } catch (RuntimeException re) {
                    re.printStackTrace();
                    throw new CvqException("Could not create vacations diary : " + re.toString());
                }
            }
        }

        // FIXME : assocation with recreation center ?

        // also check child has a perischool activity registration
//         boolean hasAPerischoolRegistration = false;
//         List registrationsList =
//             iPerischoolActivityRegistrationRequestDAO.listByChild(child);
//         // FIXME : do a check on registration's year ?
//         for (int i = 0; i < registrationsList.size(); i++) {
//             PerischoolActivityRegistrationRequest parr =
//                 (PerischoolActivityRegistrationRequest) registrationsList.get(i);
//             if (parr.getState() == RequestState.VALIDATED
//                 || parr.getState() == RequestState.NOTIFIED) {
//                 hasAPerischoolRegistration = true;
//             }
//         }
//         if (!hasAPerischoolRegistration) {
//             logger.warn("create() Child does not have a perischool activity registration");
//             throw new CvqException("Child must have a perischool activity registration");
//         }

        vrr.setRequestType(getRequestTypeByLabel(getLabel()));

        return create(vrr);
    }


    public Long create(Node node) throws CvqException {
        throw new CvqException("Not yet implemented !");
    }

    public boolean accept(Request request) {
        return request instanceof VacationsRegistrationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new VacationsRegistrationRequest();
    }
}

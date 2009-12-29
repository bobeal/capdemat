package fr.cg95.cvq.service.request.ecitizen.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.IndividualRole;
import fr.cg95.cvq.dao.request.IRequestDAO;
import fr.cg95.cvq.dao.users.IHistoryEntryDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.ecitizen.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;

/**
 * Implementation of the home folder modification request service.
 * 
 * FIXME : move home folder manipulations to home folder service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HomeFolderModificationRequestService
    extends RequestService implements IHomeFolderModificationRequestService {

    static Logger logger = Logger.getLogger(HomeFolderModificationRequestService.class);

    private IHistoryEntryDAO historyEntryDAO;
    private IRequestDAO requestDAO;

    private IHomeFolderService homeFolderService;
    private IIndividualService individualService;

    @Override
    public Set<HistoryEntry> getHistoryEntries(final Long hfmrId)
        throws CvqException {

        List<HistoryEntry> historyEntriesList = historyEntryDAO.listByRequestId(hfmrId);
        return new LinkedHashSet<HistoryEntry>(historyEntriesList);
    }

    @Override
    public void onRequestValidated(final Request request)
        throws CvqException {

        HomeFolderModificationRequest hfmr = (HomeFolderModificationRequest) request;

        // navigate through all the history entries and persist previous changes
        // (ie clear history entries and delete removed elements from home folder)
        //////////////////////////////////////////////////////////////////////////

        Set<HistoryEntry> historiesSet = getHistoryEntries(hfmr.getId());
        Set<Object> objectsToUpdate = new HashSet<Object>();
        Set<Object> objectsToRemove = new HashSet<Object>();

        for (HistoryEntry he : historiesSet) {

            if (he.getOperation().equals("update")) {

                // "simple" field value change
                if (!he.getProperty().equals("homeFolder")) {
                    logger.debug("validate() simple field value change (" + he.getProperty() + ")");
                    Object object =
                        genericDAO.findById(getClassFromHistoryEntry(he.getClazz()),
                            he.getObjectId());
                    if (!objectsToRemove.contains(object))
                        objectsToUpdate.add(object);
                }

                // TODO REFACTORING : nothing to do for individualRoles ??

                // an individual has been removed
                // (only individuals have an homeFolder property)
                if (he.getProperty().equals("homeFolder")) {

                    Individual individual = individualService.getById(he.getObjectId());

                    // unlink from (eventually) common home folder adress
                    // FIXME : what if alone with this adress ?
                    individual.setAdress(null);

                    // FIXME : can newValue be anything else ??
                    if (he.getNewValue() == null) {
                        logger.debug("validate() an individual has been removed : " + individual);

                        if (individual instanceof Adult) {
                            Adult adult = (Adult) individual;

                            List<Request> requests = requestDAO.listByRequester(adult.getId());
                            for (Request tempRequest : requests) {
                                // don't remove requesterLastName 'coz it can be useful
                                // for history purposes
                                tempRequest.setRequesterId(null);
                                requestDAO.update(tempRequest);
                            }
                        }

                        String oldValue = he.getOldValue();
                        String oldHomeFolderId =
                            oldValue.substring(oldValue.indexOf("id=") + 3,
                            oldValue.lastIndexOf(']'));
                        homeFolderService.removeRolesOnSubject(Long.valueOf(oldHomeFolderId),
                            individual.getId());

                        // update requests whose individual is the subject
                        List<Request> requestsAsSubject =
                            requestDAO.listBySubject(individual.getId());
                        for (Request requestAsSubject : requestsAsSubject) {
                            // don't remove subjectLastName 'coz it can be useful
                            // for history purposes
                            requestAsSubject.setSubjectId(null);
                            requestDAO.update(requestAsSubject);
                        }

                        if (objectsToUpdate.contains(individual)) {
                            logger.debug("validate() was in update list, removing");
                            objectsToUpdate.remove(individual);
                        }

                        objectsToRemove.add(individual);
                    }
                }
            } else if (he.getOperation().equals("created")) {
                Object object =
                    genericDAO.findById(getClassFromHistoryEntry(he.getClazz()), he.getObjectId());
                logger.debug("validate() an object has been created : " + object);
                objectsToUpdate.add(object);
            }
        }

        // clear history entries and persist changes in DB
        //////////////////////////////////////////////////

        updateObjects(objectsToUpdate, objectsToRemove, homeFolderService.getById(request.getHomeFolderId()));

        int deletedEntries = historyEntryDAO.deleteEntries(hfmr.getId());
        logger.debug("validate() deleted " + deletedEntries + " history entries");
    }

    /**
     * Do the real work of making the changes (update or delete) persistent.
     */
    private void updateObjects(final Set<Object> objectsToUpdate,
            final Set<Object> objectsToRemove, HomeFolder homeFolder) throws CvqException {

        List<Individual> individuals = new ArrayList<Individual>(homeFolder.getIndividuals());

        for (Object object : objectsToRemove) {
            logger.debug("updateObjects() Removing " + object);
            if (object instanceof Individual)
                individuals.remove(object);
            genericDAO.delete(object);
        }

        for (Object object : objectsToUpdate) {
            logger.debug("updateObjects() Updating " + object);
            if (object instanceof Individual) {
                Individual individual = (Individual)object;
                if (individuals.contains((individual)))
                    individuals.set(homeFolder.getIndividuals().indexOf(individual), individual);
                else
                    individuals.add(individual);
            }
            homeFolder.setIndividuals(individuals);

            // only for children because new adults are written when calling
            // modify method (because we need their login and pwd)
            // FIXME REFACTORING : validate this
            if (object instanceof Child) {
                Child child = (Child) object;
                individualService.assignLogin(child);
            }
        }
    }

    /**
     * Transform a field name into a setXXX method name
     */
    private String propertyToMethodName(final String property, final String modifier) {

        String charToUpper = property.substring(0,1);
        String methodName = property.replaceFirst(charToUpper, charToUpper.toUpperCase());
        methodName = modifier + methodName;
        return methodName;
    }

    /**
     * Load the class represented by this clazz string.
     */
    private Class<?> getClassFromHistoryEntry(final String clazz) {
        try {
            return Class.forName(clazz);
        } catch (ClassNotFoundException cnfe) {
            // I know this can't happen
        }

        return null;
    }

    /**
     * Restore the original property value on an object using information
     * stored in the {@link fr.cg95.cvq.business.users.HistoryEntry HistoryEntry}.
     * If not specified, assume the property to be of type {@link String String}.
     *
     * @return the object pointed by the history entry with the given property
     *         reset to its original state.
     */
    private Object restoreOldProperty(final HistoryEntry he, final Class<?> oldPropertyClass,
            final Object oldPropertyValue)
        throws CvqException {

        Object object = genericDAO.findById(getClassFromHistoryEntry(he.getClazz()),
            he.getObjectId());
        Method meth = null;
        String methodName = propertyToMethodName(he.getProperty(), "set");

        // retrieve and invoke the method to use for comparisons
        try {
            Class<?>[] paramsTypes = new Class[1];
            // to avoid a parameter type nightmare, each historizable
            // object has a setXXX(String) method for non-association fields that,
            // if needed, call the right setXXX method
            if (oldPropertyClass != null)
                paramsTypes[0] = oldPropertyClass;
            else
                paramsTypes[0] = String.class;
            meth = object.getClass().getMethod(methodName, paramsTypes);
            Object[] params = new Object[1];
            // check on oldPropertyClass because we want to be able to set a null value
            if (oldPropertyClass != null)
                params[0] = oldPropertyValue;
            else
                params[0] = he.getOldValue();
            meth.invoke(object, params);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("restoreOldProperty() Error while restoring property "
                    + he.getProperty() + " on object " + object);
            throw new CvqException("Error while restoring property "
                    + he.getProperty() + " on object " + object);
        }

        return object;
    }

    /**
     * Restore the original home folder as it was before the given request was issued.
     */
    private void restoreOriginalHomeFolder(final HomeFolderModificationRequest request)
        throws CvqException {

        Set<Object> objectsToUpdate = new HashSet<Object>();
        Set<Object> objectsToRemove = new HashSet<Object>();

        // navigate through all the history entries and cancel previous changes

        Set<HistoryEntry> historiesSet = getHistoryEntries(request.getId());
        for (HistoryEntry he : historiesSet) {
            logger.debug("restoreOriginalHomeFolder() history entry : " + he.getId());

            if (he.getOperation().equals("update")) {
                logger.debug("restoreOriginalHomeFolder() update operation");
                logger.debug("restoreOriginalHomeFolder() dealing with property : "
                        + he.getProperty() + " of class " + he.getClazz());

                // simple field value change
                if (!he.getProperty().startsWith("password")
                    && !he.getProperty().equals("homeFolder")
                    && !he.getProperty().equals("adress")
                    && !he.getProperty().equals("individualRoles")
                    && !he.getProperty().equals("individuals")) {
                    logger.debug("restoreOriginalHomeFolder() simple field value change ("
                            + he.getProperty() + ")");
                    Object object = restoreOldProperty(he, null, null);

                    if (!objectsToRemove.contains(object))
                        objectsToUpdate.add(object);
                }

                // a individual has been planed for removal, re-attach it to home folder
                else if (he.getProperty().equals("homeFolder")) {

                    if (he.getNewValue() == null) {
                        logger.debug("restoreOriginalHomeFolder() an object was planned for removal, re-attach it");
                        Object object = genericDAO.findById(getClassFromHistoryEntry(he.getClazz()), he.getObjectId());
                        if (!objectsToRemove.contains(object))
                            objectsToUpdate.add(object);
                    }
                }

                // an adress change was planned, go back to the original one
                else if (he.getProperty().equals("adress")) {
                    logger.debug("restoreOriginalHomeFolder() an adress change was planned, "
                            + "go back");
                    String oldValue = he.getOldValue();
                    String oldAdressId =
                        oldValue.substring(oldValue.indexOf("id=") + 3,
                                oldValue.lastIndexOf(']'));
                    Address oldAdress =
                        (Address) genericDAO.findById(Address.class, Long.valueOf(oldAdressId));
                    Object object = restoreOldProperty(he, Address.class, oldAdress);

                    if (!objectsToRemove.contains(object))
                        objectsToUpdate.add(object);
                }

                else if (he.getProperty().equals("individualRoles")) {
                   logger.debug("restoreOriginalHomeFolder() a role change was planned, go back");

                   // load the owner to restore its original roles
                   Individual individual =
                       (Individual) genericDAO.findById(Individual.class, he.getObjectId());
                   Set<IndividualRole> oldIndividualRoles = new HashSet<IndividualRole>();

                   // take old values and add them back to the set
                   if (he.getOldValue() != null) {
                       String[] oldValues =
                           he.getOldValue().substring(1, he.getOldValue().length() - 1).split(",");
                       for (String oldValue : oldValues) {
                           String oldIndividualRoleId =
                               oldValue.substring(oldValue.indexOf("id=") + 3,
                                       oldValue.lastIndexOf(']'));
                           logger.debug("restoreOriginalHomeFolder() got old role id : "
                                   + oldIndividualRoleId);
                           IndividualRole individualRole =
                               (IndividualRole) genericDAO.findById(IndividualRole.class,
                                       Long.valueOf(oldIndividualRoleId));
                           oldIndividualRoles.add(individualRole);
                       }
                   }

                   if (!oldIndividualRoles.isEmpty()) {
                       logger.debug("restoreOriginalHomeFolder() restoring roles ("
                               + oldIndividualRoles.size() + ") for individual "
                               + individual.getId());
                       individual.setIndividualRoles(oldIndividualRoles);

                       if (!objectsToRemove.contains(individual))
                           objectsToUpdate.add(individual);
                   }
               }
            } else if (he.getOperation().equals("created")) {
                logger.debug("restoreOriginalHomeFolder() creation operation");

                Object object =
                    genericDAO.findById(getClassFromHistoryEntry(he.getClazz()), he.getObjectId());
                logger.debug("restoreOriginalHomeFolder() object " + object
                        + " was planned for addition, unlink it");

                if (object instanceof Individual) {
                    if (!objectsToRemove.contains(object)) {
                        Individual individual = (Individual) object;
                        homeFolderService.deleteIndividual(request.getHomeFolderId(),
                                individual.getId());
                    }
                } else if (object instanceof IndividualRole) {
                    IndividualRole individualRole = (IndividualRole) object;
                    List<Individual> individuals =
                        homeFolderService.getIndividuals(request.getHomeFolderId());
                    for (Individual individual : individuals) {
                        if (individual.getIndividualRoles() == null)
                            continue;
                        if (individual.getIndividualRoles().remove(individualRole)) {
                            logger.debug("restoreOriginalHomeFolder() removed role "
                                    + individualRole.getRole() + " from "
                                    + individual.getId() + " on "
                                    + individualRole.getIndividualId());
                            break;
                        }
                    }
                }

                if (objectsToUpdate.contains(object)) {
                    logger.debug("restoreOriginalHomeFolder() was in update list, removing");
                    objectsToUpdate.remove(object);
                }
                objectsToRemove.add(object);
            }
        }

        // clear history entries and persist changes in DB
        updateObjects(objectsToUpdate, objectsToRemove, homeFolderService.getById(request.getHomeFolderId()));

        historyEntryDAO.deleteEntries(request.getId());
    }

    @Override
    public void onRequestCancelled(final Request request)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException {

        // modification request has been cancelled, restore original home folder state
        restoreOriginalHomeFolder((HomeFolderModificationRequest) request);
    }

    @Override
    public void onRequestRejected(final Request request)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException {

        // modification request has been rejected, restore original home folder state
        restoreOriginalHomeFolder((HomeFolderModificationRequest) request);
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof HomeFolderModificationRequest;
    }

    @Override
    public Request getSkeletonRequest() throws CvqException {

        return new HomeFolderModificationRequest();
    }

    public void setHistoryEntryDAO(IHistoryEntryDAO iDAO) {
        this.historyEntryDAO = iDAO;
    }

    public void setRequestDAO(IRequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public void setIndividualService(IIndividualService individualService) {
        this.individualService = individualService;
    }
}

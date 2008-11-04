package fr.cg95.cvq.service.request.ecitizen.impl;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestSeason;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.business.request.ecitizen.HomeFolderModificationRequest;
import fr.cg95.cvq.business.users.ActorState;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.HistoryEntry;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.dao.hibernate.HibernateUtil;
import fr.cg95.cvq.dao.hibernate.HistoryInterceptor;
import fr.cg95.cvq.dao.users.IHistoryEntryDAO;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqInvalidTransitionException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.ecitizen.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.users.IAdultService;

/**
 * Implementation of the home folder modification request service.
 *
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class HomeFolderModificationRequestService
    extends RequestService implements IHomeFolderModificationRequestService {

    static Logger logger =
        Logger.getLogger(HomeFolderModificationRequestService.class);

    protected IHistoryEntryDAO historyEntryDAO;
    protected HistoryInterceptor historyInterceptor;
    
    // TEMP REFACTORING
    protected IAdultService adultService;
    
    public HomeFolderModificationRequest create(final Long homeFolderId, final Long requesterId)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("create()");

        // load home folder first to check for the existence of another
        // similar request in progress
        HomeFolder homeFolder = homeFolderService.getById(homeFolderId);
        checkIsAuthorized(homeFolder);
        
        HomeFolderModificationRequest hfmr = new HomeFolderModificationRequest();
        hfmr.setHomeFolderId(homeFolderId);
        hfmr.setRequestType(getRequestTypeByLabel(getLabel()));
        initializeCommonAttributes(hfmr, requesterId);

        requestDAO.create(hfmr);
        return hfmr;
    }


    public Long create(Node node) throws CvqException {
        throw new CvqException("Not yet implemented !");
    }

    private boolean hasModificationRequestInProgress(final HomeFolder homeFolder) 
        throws CvqException {

        Set<Request> otherRequests = 
            getByHomeFolderIdAndRequestLabel(homeFolder.getId(), getLabel());
        if (otherRequests != null) {
            for (Request request : otherRequests) {
                if (request.getState().equals(RequestState.PENDING)
                    || request.getState().equals(RequestState.COMPLETE)
                    || request.getState().equals(RequestState.UNCOMPLETE)) {
                    logger.warn("create() Home folder " + homeFolder.getId() 
                            + " already has an home folder modification request in progress");
                    return true;
                }
            }
        }

        return false;
    }
    
    private void checkIsAuthorized(final HomeFolder homeFolder)
        throws CvqException {
        
        if (hasModificationRequestInProgress(homeFolder))
            throw new CvqModelException("Home folder " + homeFolder.getId() 
                    + " already has an home folder modification request in progress");

        if (!homeFolder.getState().equals(ActorState.VALID))
            throw new CvqModelException("Home folder modification requests are only "
                    + "possible for validated home folders");
    }
    
    public Map<Object, Set<RequestSeason>> getAuthorizedSubjects(final Long homeFolderId)
        throws CvqException, CvqObjectNotFoundException {

        logger.debug("getAuthorizedSubjects()");

        HomeFolder homeFolder = homeFolderService.getById(homeFolderId);
        try { 
            checkIsAuthorized(homeFolder);
        } catch (CvqModelException cme) {
            logger.debug("getAuthorizedSubjects() not authorized, returning null");
            return null;
        }
        
        Map<Object, Set<RequestSeason>> result =
            new HashMap<Object, Set<RequestSeason>>();
        result.put(homeFolder, new HashSet<RequestSeason>());
        logger.debug("getAuthorizedSubjects() authorized, returning home folder itself");
        return result;
    }
    
    public CreationBean modify(final HomeFolderModificationRequest hfmr,
            final Set adults, final Set children, final Address adress)
        throws CvqException {
        logger.debug("modify()");

        historyInterceptor.setCurrentRequest(hfmr);
        historyInterceptor.setCurrentUser(SecurityContext.getCurrentUserLogin());
        historyInterceptor.setCurrentSession(HibernateUtil.getSession());
        
        CreationBean cb = null;
        HomeFolder oldHomeFolder = homeFolderService.getById(hfmr.getHomeFolderId());
        // home folder will have to be validated again
        oldHomeFolder.setState(ActorState.PENDING);
        Date modificationDate = new Date();

        // take a snapshot of the "old" home folder
        // (ie as it was before issuing this modification request)
        Set<Child> oldChildren = new HashSet<Child>();
        Set<Adult> oldAdults = new HashSet<Adult>();
        Iterator oldIndividuals = oldHomeFolder.getIndividuals().iterator();
        while (oldIndividuals.hasNext()) {
            Individual tempInd = (Individual) oldIndividuals.next();
            if (tempInd instanceof Adult) {
                oldAdults.add((Adult) tempInd);
            } else {
                oldChildren.add((Child) tempInd);
            }
        }

        // first, deal with modifications related to children
        for (Child child : oldChildren) {
            logger.debug("modify() looking at old child : " + child);
            if (!containsIndividual(children, child)) {
                logger.debug("modify() child removed from home folder : " + child);
                // just unlink from its home folder, don't remove it yet from DB
                // because request can be refused
                // if the request is validated, the child will be removed then
                child.setHomeFolder(null);

                individualService.modify(child);
            }
        }
        Iterator newChildrenIt = children.iterator();
        while (newChildrenIt.hasNext()) {
            Child child = (Child) newChildrenIt.next();
            logger.debug("modify() looking at new child : " + child);
            if (!containsIndividual(oldChildren, child)) {
                logger.debug("modify() child added to home folder : " + child);
                child.setState(ActorState.PENDING);
                child.setCreationDate(modificationDate);
                child.setHomeFolder(oldHomeFolder);
                if (child.getAdress() == null)
                    child.setAdress(adress);

                individualService.modify(child);
                oldChildren.add(child);
            }

            // check if we have a legal responsible which is new and external to
            // home folder
            Set clrSet = child.getLegalResponsibles();
            Iterator clrSetIt = clrSet.iterator();
            while (clrSetIt.hasNext()) {
                ChildLegalResponsible clr = (ChildLegalResponsible) clrSetIt.next();
                logger.debug("modify() looking at clr : " + clr);
                if (clr.getLegalResponsible().getId() == null) {
                    if (!adults.contains(clr.getLegalResponsible())) {
                        Adult tempAdult = clr.getLegalResponsible();
                        logger.debug("modify() out of home folder clr added : " + tempAdult);
                        homeFolderService.addAdult(oldHomeFolder.getId(), tempAdult, null);
                    } else if (!oldAdults.contains(clr.getLegalResponsible())){
                        Adult adult = (Adult) clr.getLegalResponsible();
                        logger.debug("modify() adult implicitely added to home folder (isClr) : " 
                                + adult);
                        adult.setState(ActorState.PENDING);
                        adult.setCreationDate(modificationDate);
                        adult.setHomeFolder(oldHomeFolder);
                        if (adult.getAdress() == null)
                            adult.setAdress(adress);
                        homeFolderService.addAdult(oldHomeFolder.getId(), adult, null);
                        
                        // now, consider it as an already existing home folder adult
                        oldAdults.add(adult);
                    }
                }
            }
        }

        // then, deal with modifications related to home folder adults
        Iterator oldAdultsIt = oldAdults.iterator();
        boolean loggedInUserChange = false;
        while (oldAdultsIt.hasNext()) {
            Adult adult = (Adult) oldAdultsIt.next();
            logger.debug("modify() looking at old adult : " + adult);
            if (!containsIndividual(adults, adult)) {
                logger.debug("modify() adult removed from home folder : " + adult);

                // check if adult was the currently logged in user
                // if so, prepare for a hot swap
                if (SecurityContext.getCurrentEcitizen().getLogin().equals(adult.getLogin())) {
                    logger.info("modify() currently logged in user is going to be removed from its home folder !");
                    loggedInUserChange = true;
                }

                // just unlink from its home folder, don't remove it yet from DB
                // because request can be refused
                // if the request is validated, the adult will be removed then
                adult.setHomeFolder(null);

                individualService.modify(adult);
            } else {
                if (!adult.getLogin().startsWith(adult.getFirstName().toLowerCase() + "." +
                                                 adult.getLastName().toLowerCase())) {
                    logger.debug("modify() adult changed of first or last name");
                    logger.debug("modify() adult login : " + adult.getLogin());
                    logger.debug("modify() adult names : " + adult.getFirstName() + " " + adult.getLastName());
                }
            }
        }

        Iterator newAdultsIt = adults.iterator();
        while (newAdultsIt.hasNext()) {
            Adult adult = (Adult) newAdultsIt.next();
            logger.debug("modify() looking at new adult : " + adult);

            // new passwords generation handling
            //     -> a new adult which is home folder responsible
            //     -> an home folder responsible change inside home folder
            if (adult.getPassword() != null && !adult.getPassword().startsWith("{SHA}")) {
                adult.setPassword(individualService.encryptPassword(adult.getPassword()));
            }

            if (!containsIndividual(oldAdults, adult)) {
                logger.debug("modify() adult added to home folder : " + adult);
                adult.setState(ActorState.PENDING);
                adult.setCreationDate(modificationDate);
                adult.setHomeFolder(oldHomeFolder);
                if (adult.getAdress() == null)
                    adult.setAdress(adress);

                individualService.modify(adult);
            }

            // currently logged in user has been removed from the home folder
            // set the new home folder responsible as the new logged in user
            if (loggedInUserChange && adult.isHomeFolderResponsible()) {

                logger.debug("modify() Got the new logged in user with login :"
                             + adult.getLogin());

                cb = new CreationBean();
                cb.setLogin(adult.getLogin());
                cb.setRequestId(hfmr.getId());
                // and set it as the request's requester, to pass security checks
                hfmr.setRequesterId(adult.getId());
                SecurityContext.setCurrentEcitizen(adult);
            }
        }

        requestDAO.update(hfmr);

        logger.debug("modify() Gonna generate a pdf of the request");
        byte[] pdfData =
            certificateService.generateRequestCertificate(hfmr, this.fopConfig);
        addActionTrace("Creation", null, modificationDate, RequestState.PENDING, hfmr, pdfData);

        super.notifyRequestCreation(hfmr, pdfData);
        
        // inform history interceptor that it could stop intercepting after the next postFlush()
        historyInterceptor.releaseInterceptor();
        
        return cb;
    }

    private boolean containsIndividual(final Set setToSearchIn, 
            final Individual individualToLookFor) {
    
        if (setToSearchIn == null || setToSearchIn.size() == 0)
            return false;
        
        Iterator it = setToSearchIn.iterator();
        while (it.hasNext()) {
            Individual individual = (Individual) it.next();
            if (individual.getId() == null)
                continue;
            if (individual.getId().equals(individualToLookFor.getId()))
                return true;
        }
        
        return false;
    }
    
    public HomeFolder getOriginalHomeFolder(final Long hfmrId)
        throws CvqException {
        return null;
    }

    public Set getHistoryEntries(final Long hfmrId)
        throws CvqException {

        List historyEntriesList = historyEntryDAO.listByRequestId(hfmrId);
        return new LinkedHashSet(historyEntriesList);
    }

    public void validate(final Long id)
        throws CvqException, CvqInvalidTransitionException, CvqObjectNotFoundException {

        HomeFolderModificationRequest request =
            (HomeFolderModificationRequest) getById(id);

        // navigate through all the history entries and persist previous changes
        // (ie clear history entries and delete removed elements from home folder)
        //////////////////////////////////////////////////////////////////////////

        Set historiesSet = getHistoryEntries(id);
        Iterator historiesIt = historiesSet.iterator();
        Set<Object> objectsToUpdate = new HashSet<Object>();
        Set<Object> objectsToRemove = new HashSet<Object>();
        while (historiesIt.hasNext()) {
            HistoryEntry he = (HistoryEntry) historiesIt.next();

            if (he.getOperation().equals("update")) {

                // "simple" field value change
                if (!he.getProperty().equals("legalResponsibles")
                    && !he.getProperty().equals("homeFolder")) {
                    logger.debug("validate() simple field value change (" + he.getProperty() + ")");
                    String clazz = he.getClazz();
                    Class realClass = null;
                    try {
                        realClass = Class.forName(clazz);
                    } catch (ClassNotFoundException cnfe) {
                        // I know this can't happen
                    }
                    Object object = genericDAO.findById(realClass, he.getObjectId());
                    if (!objectsToRemove.contains(object))
                        objectsToUpdate.add(object);
                }

                // a change in legal responsibles for a child
                if (he.getProperty().equals("legalResponsibles")) {
                    logger.debug("validate() got a child's legal responsible change");

                    Set oldClrSet = new HashSet();
                    if (he.getOldValue() != null) {
                        String[] oldValues =
                            he.getOldValue().substring(1, he.getOldValue().length() - 1).split(",");
                        for (int i=0; i < oldValues.length; i++) {
                            String oldClrValue = oldValues[i];
                            String oldClrId =
                                oldClrValue.substring(oldClrValue.indexOf("id=") + 3,
                                                      oldClrValue.lastIndexOf(']'));
//                          logger.debug("validate() got old CLR id : " + oldClrId);
                            Object object =
                                genericDAO.findById(ChildLegalResponsible.class,
                                                     Long.valueOf(oldClrId));

                            oldClrSet.add(object);
                        }
                    }

                    String[] newValues =
                        he.getNewValue().substring(1, he.getNewValue().length() - 1).split(",");
                    for (int i=0; i < newValues.length; i++) {
                        String newClrValue = newValues[i];
//                      logger.debug("validate() got new CLR id : " + newClrValue);
                        String newClrId =
                            newClrValue.substring(newClrValue.indexOf("id=") + 3,
                                                  newClrValue.lastIndexOf(']'));
                        Object object =
                            genericDAO.findById(ChildLegalResponsible.class,
                                                 Long.valueOf(newClrId));

                        if (oldClrSet.remove(object)) {
                            logger.debug("validate() CLR was in old and new values, " 
                                    + "removing from to be removed");
                        }
                    }

                    Iterator oldClrSetIt = oldClrSet.iterator();
                    while (oldClrSetIt.hasNext()) {
                        // if the legal responsible to remove does not belong to
                        // the home folder and is not the legal responsible of
                        // another child, also remove it from DB
                        ChildLegalResponsible clr =
                            (ChildLegalResponsible) oldClrSetIt.next();
                        // FIXME : can it be the legal responsible of another
                        // child in the home folder ??
                        Adult adult = clr.getLegalResponsible();
                        if (adult.getHomeFolder() == null) {
                            adult.setAdress(null);
                            objectsToRemove.add(adult);
                        }
                        objectsToRemove.add(clr);
                    }
                }

                // a individual has been removed
                // (only individuals have an homeFolder property)
                if (he.getProperty().equals("homeFolder")) {

                    Individual individual = individualService.getById(he.getObjectId());

                    // unlink from (eventually) common home folder adress
                    // FIXME : what if alone with this adress ?
                    individual.setAdress(null);

                    if (he.getNewValue() == null) {
                        logger.debug("validate() an individual has been removed : " + individual);

                        if (individual instanceof Adult) {
                            Adult adult = (Adult) individual;

                            Set requests = getByRequesterId(adult.getId());
                            Iterator requestsIt = requests.iterator();
                            while (requestsIt.hasNext()) {
                                Request tempRequest = (Request) requestsIt.next();
                                tempRequest.setRequesterId(null);
                                requestDAO.update(tempRequest);
                            }

                            List clrs = adultService.getClrs(adult.getId());
                            for (int i=0; i < clrs.size(); i++) {
                                objectsToRemove.add(clrs.get(i));
                            }
                        }

                        if (individual instanceof Child) {
                            Child child = (Child) individual;
                            if (child.getLegalResponsibles() != null) {
                                logger.debug("deleting legal responsibles for child : " + child);
                                Iterator clrsIt = child.getLegalResponsibles().iterator();
                                while (clrsIt.hasNext()) {
                                    objectsToRemove.add(clrsIt.next());
                                }

                                // CLR objects are directly removed with
                                // 'legalResponsibles' audit entries
                                child.setLegalResponsibles(null);
                            }
                        }

                        // remove request whose individual is the subject
                        // FIXME : maybe it should be better to move request through all
                        //         workflow states 'till archived then delete it
                        //         this will permit to eventually notify external services
                        Set<Request> requestsAsSubject = getBySubjectId(individual.getId());
                        for (Request requestAsSubject : requestsAsSubject) {
                            delete(requestAsSubject);
                        }

                        if (objectsToUpdate.contains(individual)) {
                            logger.debug("validate() was in update list, removing");
                            objectsToUpdate.remove(individual);
                        }

                        objectsToRemove.add(individual);
                    } 
                }
            } else if (he.getOperation().equals("created")) {
                String clazz = he.getClazz();
                Class realClass = null;
                try {
                    realClass = Class.forName(clazz);
                } catch (ClassNotFoundException cnfe) {
                    // I know this can't happen
                }
                Object object =
                    genericDAO.findById(realClass, he.getObjectId());
                logger.debug("validate() an object has been created : " + object);
                objectsToUpdate.add(object);
            }
        }

        // clear history entries and persist changes in DB
        //////////////////////////////////////////////////

        updateObjects(objectsToUpdate, objectsToRemove, true);

        historyEntryDAO.deleteEntries(request.getId());
        
        homeFolderService.validate(request.getHomeFolderId());
        
        // validate after persisting changes to the home folder
        // (for the pdf certificate to be up-to-date)
        super.validate(request, true);
    }

    private void updateObjects(final Set objectsToUpdate, final Set objectsToRemove,
            final boolean persistToDirectory)
        throws CvqException {

        Iterator objectsToUpdateIt = objectsToUpdate.iterator();
        while (objectsToUpdateIt.hasNext()) {
            Object object = (Object) objectsToUpdateIt.next();
            logger.debug("updateObjects() Updating " + object);

            // only for children because new adults are written when calling
            // modify method (because we need their login and pwd)
            if (persistToDirectory && object instanceof Child) {
                Child child = (Child) object;
                individualService.assignLogin(child);
            }
        }

        Iterator objectsToRemoveIt = objectsToRemove.iterator();
        while (objectsToRemoveIt.hasNext()) {
            Object object = (Object) objectsToRemoveIt.next();
            logger.debug("updateObjects() Removing " + object);

            genericDAO.delete(object);
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
     * Restore the original property value on an object using information
     * stored in the {@link fr.cg95.cvq.business.users.HistoryEntry HistoryEntry}.
     * If not specified, assume the property to be of type {@link String String}.
     *
     * @return the object pointed by the history entry with the given property
     *         reset to its original state.
     */
    private Object restoreOldProperty(final HistoryEntry he, final Class oldPropertyClass,
            final Object oldPropertyValue)
        throws CvqException {

        String clazz = he.getClazz();
        Long objectId = he.getObjectId();
        Class realClass = null;
        try {
            realClass = Class.forName(clazz);
        } catch (ClassNotFoundException cnfe) {
            // I know this can't happen
        }
        Object object = genericDAO.findById(realClass, objectId);
        Method meth = null;
        String methodName = propertyToMethodName(he.getProperty(), "set");

        // retrieve and invoke the method to use for comparisons
        try {
            Class[] paramsTypes = new Class[1];
            // to avoid a parameter type nightmare, each historizable
            // object has a setXXX(String) method for non-association fields that,
            // if needed, call the right setXXX method
            if (oldPropertyClass != null)
                paramsTypes[0] = oldPropertyClass;
            else
                paramsTypes[0] = String.class;
            meth = object.getClass().getMethod(methodName, paramsTypes);
            Object[] params = new Object[1];
            // check on oldPropertyClass because we want to be able to set a
            // null value
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

        Set currentChildren = homeFolderService.getChildren(request.getHomeFolderId());

        // navigate all the history entries and cancel previous changes
        ///////////////////////////////////////////////////////////////

        Set historiesSet = getHistoryEntries(request.getId());
        Iterator historiesIt = historiesSet.iterator();
        while (historiesIt.hasNext()) {
            HistoryEntry he = (HistoryEntry) historiesIt.next();
            logger.debug("restoreOriginalHomeFolder() history entry : " + he);
            
            if (he.getOperation().equals("update")) {
                logger.debug("restoreOriginalHomeFolder() dealing with property : " 
                        + he.getProperty() + " of  class " + he.getClazz());
                
                // simple field value change
                if (!he.getProperty().startsWith("password")
                    && !he.getProperty().equals("homeFolder")
                    && !he.getProperty().equals("adress")
                    && !he.getProperty().equals("legalResponsibles")
                    && !he.getProperty().equals("legalResponsible")
                    && !he.getProperty().equals("individuals")) {
                    logger.debug("restoreOriginalHomeFolder() simple field value change (" 
                            + he.getProperty() + ")");
                    Object object = restoreOldProperty(he, null, null);

                    if (!objectsToRemove.contains(object))
                        objectsToUpdate.add(object);
                }

                // a individual has been planed for removal, re-attach it to
                // home folder
                if (he.getProperty().equals("homeFolder")) {

                    if (he.getNewValue() == null) {
                        logger.debug("restoreOriginalHomeFolder() an object was planned for removal, re-attach it");

                        String oldValue = he.getOldValue();
                        String oldHomeFolderId =
                            oldValue.substring(oldValue.indexOf("id=") + 3,
                                               oldValue.lastIndexOf(']'));
                        HomeFolder oldHomeFolder = homeFolderService.getById(Long.valueOf(oldHomeFolderId));
                        Object object = restoreOldProperty(he, HomeFolder.class, oldHomeFolder);

                        if (!objectsToRemove.contains(object))
                            objectsToUpdate.add(object);
                    } 
                }

               // an adress change was planned, go back to the original one
               if (he.getProperty().equals("adress")) {
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

                if (he.getProperty().equals("legalResponsibles")) {
                    logger.debug("restoreOriginalHomeFolder() a child legal responsible change "
                            + "was planned, go back");
                    // get the child to restore its original responsibles
                    Child child = (Child) genericDAO.findById(Child.class, he.getObjectId());
                    Set oldClrSet = new HashSet();

                    if (he.getOldValue() != null) {
                        String[] oldValues =
                            he.getOldValue().substring(1, he.getOldValue().length() - 1).split(",");
                        for (int i=0; i < oldValues.length; i++) {
                            String oldClrValue = oldValues[i];
                            String oldClrId =
                                oldClrValue.substring(oldClrValue.indexOf("id=") + 3,
                                                      oldClrValue.lastIndexOf(']'));
//                          logger.debug("restoreOriginalHomeFolder() got old CLR id : " + oldClrId);
                            ChildLegalResponsible clr = (ChildLegalResponsible)
                                genericDAO.findById(ChildLegalResponsible.class,
                                        Long.valueOf(oldClrId));
                            oldClrSet.add(clr);
                        }
                    }

                    // if new CLR values are equal to old values, ignore changes
                    Set oldClrSetCopy = new HashSet(oldClrSet);
                    String[] newValues =
                        he.getNewValue().substring(1, he.getNewValue().length() - 1).split(",");
                    for (int i=0; i < newValues.length; i++) {
                        String newClrValue = newValues[i];
                        String newClrId =
                            newClrValue.substring(newClrValue.indexOf("id=") + 3,
                                                  newClrValue.lastIndexOf(']'));
//                      logger.debug("restoreOriginalHomeFolder() got new CLR id : " + newClrId);
                        ChildLegalResponsible clr = (ChildLegalResponsible)
                            genericDAO.findById(ChildLegalResponsible.class,
                                    Long.valueOf(newClrId));

                        if (oldClrSetCopy.remove(clr)) {
                            logger.debug("restoreOriginalHomeFolder() new clr was in old values, removing from list");
                        }
                    }

                    if (oldClrSetCopy.size() > 0) {
                        logger.debug("restoreOriginalHomeFolder() still some entries in old CLR set, updating child");
                        child.setLegalResponsibles(oldClrSet);
                    }
                }
            } else if (he.getOperation().equals("created")) {

                String clazz = he.getClazz();
                Class realClass = null;
                try {
                    realClass = Class.forName(clazz);
                } catch (ClassNotFoundException cnfe) {
                    // I know this can't happen
                }
                Object object = genericDAO.findById(realClass, he.getObjectId());
                logger.debug("restoreOriginalHomeFolder() object " + object 
                        + " was planned for addition, unlink it");

                if (object instanceof Individual) {
                    HomeFolder homeFolder = 
                        homeFolderService.getById(request.getHomeFolderId());
                    Individual individual = (Individual) object;
                    individual.setAdress(null);
                    individual.setHomeFolder(null);
                    homeFolder.getIndividuals().remove(individual);
                }

                // if it's an adult, ensure it is no longer the legal responsible of 
                // an home folder's child
                if (object instanceof Adult) {
                    // FIXME : use directly the child service
                    // FIXME : need to DAO.delete(clr) too ?
                    Adult adult = (Adult) object;
                    Iterator childrenIt = currentChildren.iterator();
                    while (childrenIt.hasNext()) {
                        Child tempChild = (Child) childrenIt.next();
                        Set childClrs = tempChild.getLegalResponsibles();
                        Iterator childCrlIt = childClrs.iterator();
                        while (childCrlIt.hasNext()) {
                            ChildLegalResponsible clr = (ChildLegalResponsible) childCrlIt.next();
                            if (clr.getLegalResponsible().getId().equals(adult.getId())) {
                                logger.debug("restoreOriginalHomeFolder() removing adult from CLRs of "
                                        + tempChild.getFirstName());
                                childClrs.remove(clr);
                                clr.setLegalResponsible(null);
                                break;
                            }
                        }
                    }
                }

                if (object instanceof ChildLegalResponsible) {
                    ChildLegalResponsible clr = (ChildLegalResponsible) object;
                    // remove clr on child side of the association
                    clr.getChild().getLegalResponsibles().remove(clr);
                }

                if (objectsToUpdate.contains(object)) {
                    logger.debug("restoreOriginalHomeFolder() was in update list, removing");
                    objectsToUpdate.remove(object);
                }
                objectsToRemove.add(object);
            }
        }

        // clear history entries and persist changes in DB
        //////////////////////////////////////////////////

        updateObjects(objectsToUpdate, objectsToRemove, true);

        historyEntryDAO.deleteEntries(request.getId());
    }

    public void cancel(final Long id)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException {

        HomeFolderModificationRequest request =
            (HomeFolderModificationRequest) getById(id);
        super.cancel(request);

        // modification request has been cancelled, restore original home
        // folder state
        restoreOriginalHomeFolder(request);
        
        // home folder was supposed to be valid before modification request
        homeFolderService.validate(request.getHomeFolderId());
    }

    public void reject(final Long id, final String motive)
        throws CvqException, CvqInvalidTransitionException,
               CvqObjectNotFoundException {

        HomeFolderModificationRequest request =
            (HomeFolderModificationRequest) getById(id);
        super.reject(request, motive);

        // modification request has been rejected, restore original home
        // folder state
        restoreOriginalHomeFolder(request);

        // home folder was supposed to be valid before modification request
        homeFolderService.validate(request.getHomeFolderId());
    }

    public boolean accept(Request request) {
        return request instanceof HomeFolderModificationRequest;
    }

    public Request getSkeletonRequest() throws CvqException {
        return new HomeFolderModificationRequest();
    }

    public void setHistoryEntryDAO(IHistoryEntryDAO iDAO) {
        this.historyEntryDAO = iDAO;
    }

    public void setHistoryInterceptor(HistoryInterceptor historyInterceptor) {
        this.historyInterceptor = historyInterceptor;
    }

    public void setAdultService(IAdultService adultService) {
        this.adultService = adultService;
    }
}

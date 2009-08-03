package fr.cg95.cvq.service.authority.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.PlaceReservationType;
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.authority.PlaceReservationType.TicketSelection;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqPlaceReservationReferentialException;
import fr.cg95.cvq.schema.referential.PlaceReservationDocument;
import fr.cg95.cvq.schema.referential.PlaceReservationEntryType;
import fr.cg95.cvq.schema.referential.PlaceReservationTicketType;
import fr.cg95.cvq.schema.referential.PlaceReservationEntryType.Label;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestTypeLifecycleAware;

/**
 * Implementation of the place reservation service.
 * 
 * @author bor@zenexity.fr
 */
public class PlaceReservationService implements IPlaceReservationService, 
    IRequestTypeLifecycleAware {

    private static Logger logger = Logger.getLogger(PlaceReservationService.class);
    
    /* a map of (request service label, place reservation filename) */
    private Map<String, String> placeReservationRequestMap = new HashMap<String, String>();

    private ILocalAuthorityRegistry localAuthorityRegistry;
    
    public Set<PlaceReservationType> getPlaceReservationForRequestType(final String requestTypeLabel,
            final boolean forSubscriber) 
        throws CvqModelException, CvqPlaceReservationReferentialException {
        
        PlaceReservationDocument placeReservationDocument = 
            gimmePlaceReservationDocument(requestTypeLabel, true);

        Set<PlaceReservationType> placesReservationSet = new HashSet<PlaceReservationType>();
        PlaceReservationEntryType[] entries = 
            placeReservationDocument.getPlaceReservation().getData().getEntryArray();
        for (int i = 0; i < entries.length; i++) {
            PlaceReservationEntryType placeReservationEntryType = entries[i];
            Date now = new Date();
            
            // don't show past events to e-citizens
            if (SecurityContext.getCurrentContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                    && placeReservationEntryType.getEventDate().getTime().before(now))
                continue;
            
            // non-subscribed e-citizens can only see open reservations
            if (SecurityContext.getCurrentContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                    && !forSubscriber 
                    && (placeReservationEntryType.getReservationStartDate().getTime().after(now)
                            || placeReservationEntryType.getReservationEndDate().getTime().before(now)))
                continue;
            
            PlaceReservationType placeReservationType = 
                transformPlaceReservationToModel(placeReservationEntryType, forSubscriber);
            placesReservationSet.add(placeReservationType);
        }

        return placesReservationSet;
    }

    public PlaceReservationType getPlaceReservationForRequestType(final String requestTypeLabel, 
            final String placeReservationKey, boolean forSubscriber) 
        throws CvqModelException, CvqPlaceReservationReferentialException {

        if (placeReservationKey == null || placeReservationKey.equals(""))
            return null;
        
        PlaceReservationDocument placeReservationDocument = 
            gimmePlaceReservationDocument(requestTypeLabel, true);

        PlaceReservationEntryType[] entries = 
            placeReservationDocument.getPlaceReservation().getData().getEntryArray();
        for (int i = 0; i < entries.length; i++) {
            PlaceReservationEntryType placeReservationEntryType = entries[i];
            if (placeReservationEntryType.getKey().equals(placeReservationKey))
                return transformPlaceReservationToModel(placeReservationEntryType, forSubscriber);
        }

        return null;
    }

    private PlaceReservationType transformPlaceReservationToModel(
            final PlaceReservationEntryType placeReservationEntryType, 
            final boolean forSubscriber) {

        PlaceReservationType placeReservationType = new PlaceReservationType();
        placeReservationType.setKey(placeReservationEntryType.getKey());
        placeReservationType.setQuota(new Integer(placeReservationEntryType.getQuota()));
        placeReservationType.setEventDate(placeReservationEntryType.getEventDate().getTime());
        placeReservationType.setRemainingPlaces(new Integer(placeReservationEntryType.getRemainingPlaces()));
        if (placeReservationEntryType.getReservationStartDate() != null)
            placeReservationType.setReservationStartDate(
                    placeReservationEntryType.getReservationStartDate().getTime());
        if (placeReservationEntryType.getReservationEndDate() != null)
            placeReservationType.setReservationEndDate(
                    placeReservationEntryType.getReservationEndDate().getTime());
        placeReservationType.setMessage(placeReservationEntryType.getMessage());
        Label[] availLabels = placeReservationEntryType.getLabelArray();
        for (int k = 0; k < availLabels.length; k++) {
            placeReservationType.addLabel(availLabels[k].getLang(),
                    availLabels[k].getStringValue());
        }
        
        Date now = new Date();
        boolean isOpenReservation = true;
        if (placeReservationEntryType.getReservationStartDate() != null 
                && placeReservationEntryType.getReservationStartDate().getTime().before(now))
            isOpenReservation = false;
        if (isOpenReservation 
                && placeReservationEntryType.getReservationEndDate() != null 
                && placeReservationEntryType.getReservationEndDate().getTime().after(now))
            isOpenReservation = false;
        
        PlaceReservationTicketType[] availTickets = 
            placeReservationEntryType.getTicketSelectionArray();
        for (int j = 0; j < availTickets.length; j++) {
            PlaceReservationTicketType ticketEntry = availTickets[j];
            // non-subscribed e-citizens can't see subscriber tickets
            if (SecurityContext.getCurrentContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                    && !forSubscriber && ticketEntry.getIsSubscriberPrice())
                continue;
            // subscribers can not see non-subscriber tickets if reservation is closed
            if (SecurityContext.getCurrentContext().equals(SecurityContext.FRONT_OFFICE_CONTEXT)
                    && forSubscriber && !isOpenReservation && !ticketEntry.getIsSubscriberPrice())
                continue;
            
            TicketSelection ticketSelection = 
                placeReservationType.new TicketSelection(ticketEntry.getKey(),
                        new Float(ticketEntry.getPrice()));
            ticketSelection.setIsSubscriberPrice(ticketEntry.getIsSubscriberPrice());
            fr.cg95.cvq.schema.referential.PlaceReservationTicketType.Label[] ticketLabels =
                ticketEntry.getLabelArray();
            for (int l = 0; l < ticketLabels.length; l++) {
                ticketSelection.addLabel(ticketLabels[l].getLang(),
                        ticketLabels[l].getStringValue());
            }
            placeReservationType.addTicketSelection(ticketSelection);
        }

        return placeReservationType;
    }

    private PlaceReservationEntryType transformPlaceReservationToXml(
            PlaceReservationDocument placeReservationDocument, 
            PlaceReservationType placeReservationType, 
            PlaceReservationEntryType placeReservationEntryType) 
        throws CvqPlaceReservationReferentialException {
        
        Calendar calendar = Calendar.getInstance();
        PlaceReservationEntryType newEntry = null;
        if (placeReservationEntryType != null) {
            newEntry = placeReservationEntryType;
            int labelArraySize = newEntry.sizeOfLabelArray();
            for (int i = 0; i < labelArraySize; i++)
                newEntry.removeLabel(0);
            int ticketSelectionArraySize = newEntry.sizeOfTicketSelectionArray();
            for (int i = 0; i < ticketSelectionArraySize; i++) {
                newEntry.removeTicketSelection(0);
            }
        } else {
            newEntry = PlaceReservationEntryType.Factory.newInstance();
        }
        newEntry.setKey(placeReservationType.getKey());

        Map labelsMap = placeReservationType.getLabelsMap();
        if (labelsMap != null) {
            Iterator labelsMapIt = labelsMap.keySet().iterator();
            while (labelsMapIt.hasNext()) {
                String lang = (String) labelsMapIt.next();
                Label newLabel = newEntry.addNewLabel();
                newLabel.setLang(lang);
                newLabel.setStringValue((String) labelsMap.get(lang));
            }
        }
        
        calendar.setTime(placeReservationType.getEventDate());
        newEntry.setEventDate(calendar);
        int currentRemainingPlacesForEntry =
            getCurrentRemainingPlacesForEntry(placeReservationDocument, 
                    placeReservationType.getKey());
        logger.debug("transformPlaceReservationToXml() current remaining for entry " 
                + currentRemainingPlacesForEntry);
        int currentQuotaForEntry = 0;
        if (placeReservationEntryType != null)
            currentQuotaForEntry = placeReservationEntryType.getQuota();
        else
            currentQuotaForEntry = getCurrentQuotaForEntry(placeReservationDocument, 
                        placeReservationType.getKey());
        logger.debug("transformPlaceReservationToXml() current quota for entry " 
                + currentQuotaForEntry);
        if (currentRemainingPlacesForEntry == -1) {
            // entry did not exist yet
            logger.debug("transformPlaceReservationToXml() new entry, setting remaining places to " 
                    + placeReservationType.getQuota().intValue());
            newEntry.setRemainingPlaces(placeReservationType.getQuota().intValue());
        } else {
            if (placeReservationType.getQuota().intValue() == 0) {
                newEntry.setRemainingPlaces(0);
            } else {
                int newRemainingPlaces = currentRemainingPlacesForEntry 
                    + (placeReservationType.getQuota().intValue() - currentQuotaForEntry);
                logger.debug("transformPlaceReservationToXml() existing entry, setting remaining places to " 
                        + newRemainingPlaces);
                if (newRemainingPlaces < 0)
                    throw new CvqPlaceReservationReferentialException("New quota is invalid " 
                            + " since it exceeds the number of already reserved places");
                newEntry.setRemainingPlaces(newRemainingPlaces);
            }
        }
        newEntry.setQuota(placeReservationType.getQuota().intValue());

        if (placeReservationType.getReservationStartDate() != null) {
            calendar.setTime(placeReservationType.getReservationStartDate());
            newEntry.setReservationStartDate(calendar);
        }
        if (placeReservationType.getReservationEndDate() != null) {
            calendar.setTime(placeReservationType.getReservationEndDate());
            newEntry.setReservationEndDate(calendar);
        }
        if (placeReservationType.getMessage() != null)
            newEntry.setMessage(placeReservationType.getMessage());
        
        Collection tickets = placeReservationType.getTicketsSelection();
        if (tickets != null) {
            Iterator ticketsMapIt = tickets.iterator();
            while (ticketsMapIt.hasNext()) {
                TicketSelection ticketSelection = (TicketSelection) ticketsMapIt.next();
                PlaceReservationTicketType placeReservationTicketType =
                    newEntry.addNewTicketSelection();
                placeReservationTicketType.setKey(ticketSelection.getName());
                placeReservationTicketType.setPrice(ticketSelection.getPrice().floatValue());
                placeReservationTicketType.setIsSubscriberPrice(ticketSelection.isSubscriberPrice());
                
                if (ticketSelection.isSubscriberPrice() 
                        && (!ticketSelection.getName().equals(FULL_PRICE_SUBSCRIBER)
                                && !ticketSelection.getName().equals(REDUCED_PRICE_SUBSCRIBER))) {
                    logger.warn("transformPlaceReservationToXml() got a subscriber ticket with "
                            + " an unknown key : " + ticketSelection.getName());
                }
                
                Map ticketLabelsMap = ticketSelection.getLabelsMap();
                Iterator ticketLabelsMapIt = ticketLabelsMap.keySet().iterator();
                while (ticketLabelsMapIt.hasNext()) {
                    String lang = (String) ticketLabelsMapIt.next();
                    fr.cg95.cvq.schema.referential.PlaceReservationTicketType.Label newLabel = 
                        placeReservationTicketType.addNewLabel();
                    newLabel.setLang(lang);
                    newLabel.setStringValue((String) ticketLabelsMap.get(lang));
                }
            }
        }
        
        return newEntry;
    }
    
    public void setPlaceReservationForRequestType(final String requestTypeLabel,
            final Set<PlaceReservationType> placeReservationTypeSet) 
        throws CvqModelException, CvqPlaceReservationReferentialException {

        if (!SecurityContext.getCurrentContext().equals(SecurityContext.BACK_OFFICE_CONTEXT))
            throw new CvqModelException("Method only available to agents");
        
        PlaceReservationDocument placeReservationDocument = 
            gimmePlaceReservationDocument(requestTypeLabel, true);

        PlaceReservationEntryType[] newEntries = 
            new PlaceReservationEntryType[placeReservationTypeSet.size()];
        int i = 0;
        for (PlaceReservationType placeReservationType : placeReservationTypeSet) {
            PlaceReservationEntryType newEntry = 
                transformPlaceReservationToXml(placeReservationDocument, placeReservationType, null);
            newEntries[i] = newEntry;
            i++;
        }

        placeReservationDocument.getPlaceReservation().getData().setEntryArray(newEntries);
        
        validateAndSaveReservationDocument(placeReservationDocument, requestTypeLabel);
    }

    public void setPlaceReservationForRequestType(final String requestTypeLabel, 
            final PlaceReservationType placeReservationType) 
        throws CvqModelException, CvqPlaceReservationReferentialException {
        
        if (!SecurityContext.getCurrentContext().equals(SecurityContext.BACK_OFFICE_CONTEXT))
            throw new CvqModelException("Method only available to agents");
        
        PlaceReservationDocument placeReservationDocument = 
            gimmePlaceReservationDocument(requestTypeLabel, true);

        String queryExpression =
            "declare namespace xq='http://www.cg95.fr/cvq/schema/referential';" 
            + "$this/xq:PlaceReservation/xq:data/xq:entry[@key='" 
            + placeReservationType.getKey() + "']";
        XmlObject[] selectedObjects = placeReservationDocument.selectPath(queryExpression);
        if (selectedObjects == null || selectedObjects.length == 0) {
            // entry does not exist yet, just add it 
            PlaceReservationEntryType placeReservationEntryType =
                transformPlaceReservationToXml(placeReservationDocument, placeReservationType, null);
            int currentNbOfEntries = 
                placeReservationDocument.getPlaceReservation().getData().sizeOfEntryArray();
            placeReservationDocument.getPlaceReservation().getData().addNewEntry();
            placeReservationDocument.getPlaceReservation().getData().setEntryArray(currentNbOfEntries,
                    placeReservationEntryType);
        } else if (selectedObjects.length > 1) {
            // already more than one entry with the same key !!??
            throw new CvqPlaceReservationReferentialException("More than one entry with the same key");
        } else {
            // replace the existing one with the new one
            PlaceReservationEntryType newPlaceReservationEntryType = 
                (PlaceReservationEntryType) selectedObjects[0];
            transformPlaceReservationToXml(placeReservationDocument, placeReservationType, 
                    newPlaceReservationEntryType);
        }

        validateAndSaveReservationDocument(placeReservationDocument, requestTypeLabel);
    }

    public void removePlaceReservationForRequestType(final String requestTypeLabel, 
            final String placeReservationKey) 
        throws CvqModelException, CvqPlaceReservationReferentialException {

        if (placeReservationKey == null || placeReservationKey.equals(""))
            return;
        
        if (!SecurityContext.getCurrentContext().equals(SecurityContext.BACK_OFFICE_CONTEXT))
            throw new CvqModelException("Method only available to agents");
        
        PlaceReservationDocument placeReservationDocument = 
            gimmePlaceReservationDocument(requestTypeLabel, true);
        PlaceReservationEntryType[] entries = 
            placeReservationDocument.getPlaceReservation().getData().getEntryArray();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].getKey().equals(placeReservationKey)) {
                logger.debug("removePlaceReservationForRequestType() gonna remove entry "
                        + placeReservationKey);
                placeReservationDocument.getPlaceReservation().getData().removeEntry(i);
                validateAndSaveReservationDocument(placeReservationDocument, requestTypeLabel);
                return;
            }
        }
    }

    public int updateRemainingPlacesForReservation(final String requestTypeLabel, 
            final String placeReservationKey, final int numberOfPlaces) 
        throws CvqModelException, CvqPlaceReservationReferentialException {
        
        PlaceReservationDocument placeReservationDocument =
            gimmePlaceReservationDocument(requestTypeLabel, false);

        PlaceReservationEntryType[] entries = 
            placeReservationDocument.getPlaceReservation().getData().getEntryArray();
        int currentRemainingPlaces = 0;
        boolean foundPlaceReservationKey = false;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].getKey().equals(placeReservationKey)) {
                currentRemainingPlaces = entries[i].getRemainingPlaces();
                currentRemainingPlaces = currentRemainingPlaces + numberOfPlaces;
                if (currentRemainingPlaces < 0)
                    throw new CvqPlaceReservationReferentialException("Remaining places cannot be negative");
                else if (currentRemainingPlaces > entries[i].getQuota())
                    throw new CvqPlaceReservationReferentialException("Remaining places cannot be above "
                            + " the total number of available places");
                entries[i].setRemainingPlaces(currentRemainingPlaces);
                foundPlaceReservationKey = true;
                break;
            }
        }
        
        if (!foundPlaceReservationKey)
            throw new CvqModelException("Did not find place reservation key : " 
                    + placeReservationKey);
        
        validateAndSaveReservationDocument(placeReservationDocument, requestTypeLabel);
        
        return currentRemainingPlaces;
    }

    public Set<String> getSubscriberTickets(String requestTypeLabel, String placeReservationKey) 
        throws CvqModelException {

        PlaceReservationType placeReservationType = null;
        try {
            placeReservationType = 
                getPlaceReservationForRequestType(requestTypeLabel, placeReservationKey, true);
        } catch (CvqPlaceReservationReferentialException e) {
            // we are just reading ...
        }

        if (placeReservationType == null) {
            logger.warn("getSubscriberTicket() could not retrieve place reservation data for "
                    + placeReservationKey);
            return null;
        }
        
        Collection tickets = placeReservationType.getTicketsSelection();
        if (tickets == null || tickets.size() == 0)
            return null;
        
        Set<String> subscriberTickets = new HashSet<String>();
        Iterator ticketsIt = tickets.iterator();
        while (ticketsIt.hasNext()) {
            TicketSelection ticketSelection = (TicketSelection) ticketsIt.next();
            if (ticketSelection.isSubscriberPrice())
                subscriberTickets.add(ticketSelection.getName());
        }
        
        return subscriberTickets;
    }

    /**
     * Implementation of the {@link IRequestTypeLifecycleAware} interface.
     */
    public void addRequestTypeService(IRequestService service) {
        if (service.getPlaceReservationFilename() != null) {
            logger.debug("addRequestTypeService() service " + service.getLabel() 
                    + " has a place reservation file");
            placeReservationRequestMap.put(service.getLabel(), service.getPlaceReservationFilename());
        }
    }

    /**
     * Implementation of the {@link IRequestTypeLifecycleAware} interface.
     */
    public void removeRequestType(String requestTypeLabel) {
        logger.debug("removeRequestType() removing " + requestTypeLabel);
        placeReservationRequestMap.remove(requestTypeLabel);
    }

    private int getCurrentRemainingPlacesForEntry(final PlaceReservationDocument prdDoc, 
            final String entryKey) {
    
        PlaceReservationEntryType[] currentEntries = 
            prdDoc.getPlaceReservation().getData().getEntryArray();
        for (int i = 0; i < currentEntries.length; i++) {
            if (currentEntries[i].getKey().equals(entryKey)) {
                return currentEntries[i].getRemainingPlaces();
            }
        }
        return -1;
    }
    
    private int getCurrentQuotaForEntry(final PlaceReservationDocument prdDoc, 
            final String entryKey) {
    
        PlaceReservationEntryType[] currentEntries = 
            prdDoc.getPlaceReservation().getData().getEntryArray();
        for (int i = 0; i < currentEntries.length; i++) {
            if (currentEntries[i].getKey().equals(entryKey)) {
                return currentEntries[i].getQuota();
            }
        }
        return -1;
    }
    
    /**
     * Return whether the given request type has a place reservation mechanism associated.
     *   
     * @throws CvqModelException if the given request type has no place reservation mechanism
     *                           associated.
     */
    private void isSupportedRequestType(final String requestTypeLabel)
        throws CvqModelException {
        
        if (placeReservationRequestMap.get(requestTypeLabel) == null) {
            logger.warn("getPlaceReservationForRequestType() No place reservation available for "
                    + requestTypeLabel);
            throw new CvqModelException(requestTypeLabel + " has no place reservation associated");
        }
    }
    
    /**
     * Load the place reservation referential data associated to the given request type from
     * the filesystem.
     */
    private PlaceReservationDocument gimmePlaceReservationDocument(final String requestTypeLabel,
            final boolean fallbackToDefault) 
        throws CvqModelException, CvqPlaceReservationReferentialException {
        
        isSupportedRequestType(requestTypeLabel);
        
        File placeFile = 
            localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.LOCAL_REFERENTIAL,
                (String) placeReservationRequestMap.get(requestTypeLabel),
                fallbackToDefault);
        
        PlaceReservationDocument placeReservationDocument =
            parsePlaceReservationDocument(placeFile);
        
        return placeReservationDocument;
    }
    
    /**
     * Parse a place reservation referential data file loaded from filesystem.
     * 
     * @throws CvqPlaceReservationReferentialException if the XML document is not valid
     */
    private PlaceReservationDocument parsePlaceReservationDocument(File file)
        throws CvqPlaceReservationReferentialException {
        
        PlaceReservationDocument placeReservationDocument = null;
        try {
            placeReservationDocument = PlaceReservationDocument.Factory.parse(file);
        } catch (XmlException e) {
            logger.error("parsePlaceReservationDocument() Parsing error " + e);
            e.printStackTrace();
            throw new CvqPlaceReservationReferentialException();
        } catch (IOException e) {
            logger.error("parsePlaceReservationDocument() IO error " + e);
            e.printStackTrace();
            throw new RuntimeException();
        }

        // we should not have to validate the document here
        // that's just in case someone had the good idea to manually edit it on filesystem
        validateDocument(placeReservationDocument);
        
        return placeReservationDocument;
    }
    
    /**
     * Validate the XML data contained within a place reservation document.
     * 
     * @throws CvqPlaceReservationReferentialException if the document is not valid
     */
    private void validateDocument(PlaceReservationDocument placeReservationDocument)
        throws CvqPlaceReservationReferentialException {
        
        // Set up the validation error listener.
        ArrayList validationErrors = new ArrayList();
        XmlOptions validationOptions = new XmlOptions();
        validationOptions.setErrorListener(validationErrors);
        if (!placeReservationDocument.validate(validationOptions)) {
            Iterator iter = validationErrors.iterator();
            while (iter.hasNext()) {
                logger.error("setPlaceReservationForRequestType() Validation error : " 
                        + iter.next());
            }
            throw new CvqPlaceReservationReferentialException();
        }
    }
    
    private void validateAndSaveReservationDocument(PlaceReservationDocument placeReservationDocument,
            final String requestTypeLabel)
        throws CvqPlaceReservationReferentialException {
        
        validateDocument(placeReservationDocument);

        File referentialFile =
            localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.LOCAL_REFERENTIAL,
                (String) placeReservationRequestMap.get(requestTypeLabel), false);
        try {
            XmlOptions opts = new XmlOptions();
            opts.setSavePrettyPrint();
            opts.setSavePrettyPrintIndent(4);
            opts.setUseDefaultNamespace();
            opts.setCharacterEncoding("UTF-8");
            placeReservationDocument.save(referentialFile, opts);
        } catch (IOException xe) {
            logger.error("validateAndSaveReservationDocument() error while saving place reservation data file");
            xe.printStackTrace();
            throw new RuntimeException("error while saving place reservation data file");
        }
    }
    
    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}

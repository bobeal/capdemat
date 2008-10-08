/*
 * Cartevaloise
 *
 * Copyright (C) 2004, 2005 Conseil Général du Val d'Oise. All Rights
 * Reserved.
 *
 * Managed and developed by
 *        Bruno Perrin, Philippe Usclade and René le Clercq
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 */
package fr.cg95.cvq.fo.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.authority.LocalReferentialEntry;
import fr.cg95.cvq.business.authority.LocalReferentialType;
import fr.cg95.cvq.business.request.MeansOfContact;
import fr.cg95.cvq.business.request.MeansOfContactEnum;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Card;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectAlreadyExistsException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.dispatcher.StartupServlet;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.payment.IPaymentService;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.authority.ILocalReferentialService;
import fr.cg95.cvq.service.authority.IPlaceReservationService;
import fr.cg95.cvq.service.authority.IRecreationCenterService;
import fr.cg95.cvq.service.authority.LocalAuthorityConfigurationBean;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.military.IMilitaryCensusRequestService;
import fr.cg95.cvq.service.request.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.request.IMeansOfContactService;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import fr.cg95.cvq.service.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.service.school.IRecreationActivityRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.ICardService;
import fr.cg95.cvq.service.users.ICertificateService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.util.Critere;
import fr.cg95.cvq.util.mail.IMailService;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.xml.common.MeansOfContactEnumType;

/**
 * @author Laurent MARQUEZ
 */
public class BusinessManager {

    private static BusinessManager _businessManager;

    private WebApplicationContext _applicationContext = null;

    private IHomeFolderService _familyHomeService;

    private IHomeFolderModificationRequestService _familyHomeModificationService;

    private IRequestService _requestService;

    private ISchoolRegistrationRequestService _schoolRegistrationRequestService;

    private IPerischoolActivityRegistrationRequestService _periSchoolRegistrationRequestService;

    private ISchoolCanteenRegistrationRequestService _schoolCanteenRegistrationRequestService;

    private IAuthenticationService _authenticationService;

    private IDocumentService _documentService;

    private IAdultService _adultService;

    private IIndividualService _individualService;

    private IChildService _childService;
    
    private IMeansOfContactService _meansOfContactService;

    public static BusinessManager getInstance() {

        if (null == _businessManager) {

            _businessManager = new BusinessManager();
        }
        return _businessManager;
    }

    // util

    public static WebApplicationContext getAc() {
        return getInstance()._applicationContext;
    }

    public IRequestService getDefaultRequestService() {
        return ((IRequestServiceRegistry) _applicationContext.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getDefaultRequestService();
    }

    public IRequestService getRequestService(Request request) throws CvqObjectNotFoundException, CvqException {
        return ((IRequestServiceRegistry) _applicationContext.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getRequestService(request);
    }

    public IRequestService getRequestService(Long id) throws CvqObjectNotFoundException, CvqException {
        return ((IRequestServiceRegistry) _applicationContext.getBean(IRequestServiceRegistry.SERVICE_NAME))
                .getRequestService(getDefaultRequestService().getById(id));
    }

    private BusinessManager() {

        _applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(StartupServlet
                .getInstance().getServletContext());

        // allocate the different facade service
        _familyHomeService = (IHomeFolderService) _applicationContext
                .getBean(IHomeFolderService.SERVICE_NAME);

        _familyHomeModificationService = (IHomeFolderModificationRequestService) _applicationContext
                .getBean(IHomeFolderModificationRequestService.SERVICE_NAME);

        _requestService = getDefaultRequestService();

        _authenticationService = (IAuthenticationService) _applicationContext
                .getBean(IAuthenticationService.SERVICE_NAME);

        _schoolRegistrationRequestService = (ISchoolRegistrationRequestService) _applicationContext
                .getBean(ISchoolRegistrationRequestService.SERVICE_NAME);

        _periSchoolRegistrationRequestService = (IPerischoolActivityRegistrationRequestService) _applicationContext
                .getBean(IPerischoolActivityRegistrationRequestService.SERVICE_NAME);

        _schoolCanteenRegistrationRequestService = (ISchoolCanteenRegistrationRequestService) _applicationContext
                .getBean(ISchoolCanteenRegistrationRequestService.SERVICE_NAME);

        _documentService = (IDocumentService) _applicationContext.getBean(IDocumentService.SERVICE_NAME);

        _adultService = (IAdultService) _applicationContext.getBean(IAdultService.SERVICE_NAME);

        _individualService = (IIndividualService) _applicationContext
                .getBean(IIndividualService.SERVICE_NAME);

        _childService = (IChildService) _applicationContext.getBean(IChildService.SERVICE_NAME);
        
        _meansOfContactService = (IMeansOfContactService) _applicationContext.getBean(IMeansOfContactService.SERVICE_NAME);
    }

    public Set findRequestsByFamilyHomeId(Long pFamilyHomeId) throws CvqException {

        return getRequestService().getByHomeFolderId(pFamilyHomeId);
    }

    public Long findFamilyHomeIdByRequestId(Long pRequestId) throws CvqException {

        return getHomeFolderService().getByRequestId(pRequestId).getId();
    }

    public HomeFolder findFamilyHomeById(Long pFamilyHomeId) throws CvqException {

        return getHomeFolderService().getById(pFamilyHomeId);
    }

    public HomeFolder findFamilyHome(String name, String firstName) throws CvqException {

        try {
            IIndividualService service = (IIndividualService) _applicationContext
                    .getBean(IIndividualService.SERVICE_NAME);

            // To get the family home id from the facade
            // we must use a criteria set
            Set criteriaSet = new HashSet();

            Critere criteria = new Critere();

            criteria.setAttribut(Individual.SEARCH_BY_LASTNAME);
            criteria.setComparatif(Critere.EQUALS);
            criteria.setValue(name);
            criteriaSet.add(criteria);

            criteria = new Critere();

            criteria.setAttribut(Individual.SEARCH_BY_FIRSTNAME);
            criteria.setComparatif(Critere.EQUALS);
            criteria.setValue(firstName);
            criteriaSet.add(criteria);

            Iterator iter = service.get(criteriaSet, null, false, false).iterator();

            if (iter.hasNext()) {
                Individual individual = (Individual) iter.next();

                return individual.getHomeFolder();
            }
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
        throw new CvqException("HomeFolder not found.");
    }

    public Individual findIndividual(Long id) throws CvqException {

        try {
            return _individualService.getById(id);

        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }

    public Adult findAdult(Long id) throws CvqException {

        try {
            return _adultService.getById(id);

        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }

    public Adult findAdult(String certificate) throws CvqException {

        try {
            IIndividualService service = (IIndividualService) _applicationContext
                    .getBean(IIndividualService.SERVICE_NAME);

            return _adultService.getById(service.getByCertificate(certificate).getId());

        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }

    public static boolean hasModificationRequest(Long familyId) {
        try {
            return getInstance().getFamilyHomeModificationService().getAuthorizedSubjects(familyId) == null;

        } catch (CvqObjectNotFoundException e) {
            e.printStackTrace();
        } catch (CvqException e) {
            e.printStackTrace();
        }
        return false;
    }

    public SchoolRegistrationRequest getChildSchoolRegistration(Long childId) {
        try {
            ISchoolRegistrationRequestService service =
                (ISchoolRegistrationRequestService) _applicationContext.getBean(ISchoolRegistrationRequestService.SERVICE_NAME);
            Set childSchoolRequests = service.getBySubjectIdAndRequestLabel(childId, service.getLabel(), false);
            if (childSchoolRequests != null && !childSchoolRequests.isEmpty())
                return (SchoolRegistrationRequest) childSchoolRequests.iterator().next();
            else
                return null;
        } catch (CvqException e) {
        }
        return null;
    }

    public static void changePassword(Long responsibleId, String oldPassword, String newPassword)
            throws Exception {
        Adult responsible = getInstance().getAdultService().getById(responsibleId);
        getInstance().getAdultService().modifyPassword(responsible, oldPassword, newPassword);
    }

    public String resetPassword(RequestManager requestManager, Long adultId) 
        throws CvqObjectNotFoundException, CvqException {
        
        String result = null;
        Adult adult = getAdultService().getById(adultId);
        String password = getAuthenticationService().generatePassword();
        getAuthenticationService().resetAdultPassword(adult, password);

        IMailService mailService = (IMailService) _applicationContext.getBean(IMailService.SERVICE_NAME);

        String subject = "Nouveau mot de passe.";
        String body = null;
        String destMail = adult.getEmail();
        if ((destMail != null) && (destMail.length() > 5)) {
            body = "Veuillez trouver ci-dessous votre nouveau mot de passe.\n\t" + password;
            result = Constants.MAIL_PASSWORD_VALUE;
        } else {
            RequestType requestType = requestManager.getRequestType("eCitizen");

            destMail = requestType.getCategory().getPrimaryEmail();
            body = "Le mot de passe ci-dessous a été attribué à "
                    + BusinessDictionary.getTitleType(adult.getTitle()) + " " + adult.getFirstName() + " "
                    + adult.getLastName() + ".\n\t" + password;
            result = Constants.TOWN_PASSWORD_VALUE;
        }
        mailService.send(null, destMail, null, subject, body);

        return result;
    }

    public void updateCard(Long individualId, String certificate, String pin)
            throws CvqObjectNotFoundException, CvqException {

        ICardService service = (ICardService) _applicationContext.getBean(ICardService.SERVICE_NAME);

        try {
            Card card = new Card();
            card.setCertificate(certificate);
            card.setPin(pin);
            service.create(card, individualId);

        } catch (CvqObjectAlreadyExistsException oae) {
            Card card = _adultService.getById(individualId).getCard();
            card.setCertificate(certificate);
            card.setPin(pin);
            service.modify(card);
        }
    }

    public void updateCard(Card card) throws CvqObjectNotFoundException, CvqException {

        ICardService service = (ICardService) _applicationContext.getBean(ICardService.SERVICE_NAME);

        service.modify(card);
    }

    public void printRequest(File pdf, Long id) {

        Request request;
        try {
            IRequestService requestService = getRequestService(); 
            request = requestService.getById(id);
            
            byte[] data = requestService.getCertificate(id, RequestState.VALIDATED);
            if ((data == null) || (data.length == 0))
                data = requestService.getCertificate(id, RequestState.PENDING);
                
//            ICertificateService service = (ICertificateService) _applicationContext
//                    .getBean(ICertificateService.SERVICE_NAME);
//
//            byte[] data = service.generateRequestCertificate(request, null);

            if (data != null) {
                FileOutputStream fos = new FileOutputStream(pdf);
                fos.write(data);
                fos.close();
            }
        } catch (CvqObjectNotFoundException e) {
        } catch (CvqException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    public static Collection getReferentialList(String type) {
        ArrayList referentialList = null;
        try {
            ILocalReferentialService service = (ILocalReferentialService) _businessManager._applicationContext
                    .getBean(ILocalReferentialService.SERVICE_NAME);

            referentialList = new ArrayList();
            LocalReferentialType referentialType = service.getLocalReferentialDataByName(type);
            Iterator iter = referentialType.getEntries().iterator();
            while (iter.hasNext()) {
                LocalReferentialEntry entry = (LocalReferentialEntry)iter.next();
                Map value = entry.getLabelsMap();
                ReferentialData data = new ReferentialData(entry.getKey(), (String) value.get("fr"));

                addDataEntries(data, entry);
                referentialList.add(data);
            }

        } catch (CvqException e) {
            e.getMessage();
        }
        if (referentialList == null) {
            referentialList = new ArrayList();
            referentialList.add(new ReferentialData("NoData", "Pas de données"));
        }
        return referentialList;
    }

    private static void addDataEntries(ReferentialData data, LocalReferentialEntry entry) {
        if (entry.getEntries() != null) {
            Iterator iter = entry.getEntries().iterator();
            while (iter.hasNext()) {
                LocalReferentialEntry childEntry = (LocalReferentialEntry)iter.next();
                ReferentialData childData = 
                    data.addDetail(childEntry.getKey(), childEntry.getLabelsMap().get("fr").toString());
    
                addDataEntries(childData, childEntry);
            }
        }
    }
    
    public static Collection getReferentialData(String type) {
        try {
            ILocalReferentialService service = (ILocalReferentialService) _businessManager._applicationContext
                    .getBean(ILocalReferentialService.SERVICE_NAME);

            LocalReferentialType data = service.getLocalReferentialDataByName(type);
            return data.getEntries();

        } catch (CvqException e) {
            e.getMessage();
        }
        return null;
    }

    public static Set getReservationData(String typeLabel, boolean forSubscriber) {
        try {
            IPlaceReservationService service = (IPlaceReservationService)_businessManager._applicationContext.
                                                        getBean(IPlaceReservationService.SERVICE_NAME);
            
            return service.getPlaceReservationForRequestType(typeLabel,forSubscriber);
            
        } catch (CvqException e) {
            e.getMessage();
        }
        return null;
    }
    
    public static Integer updateReservationData(String typeLabel, String reservation, int places) {
        try {
            IPlaceReservationService service = (IPlaceReservationService)_businessManager._applicationContext.
                                                        getBean(IPlaceReservationService.SERVICE_NAME);
            
            int remaining = service.updateRemainingPlacesForReservation(typeLabel, reservation, places * (-1));
            
            return new Integer(remaining);
            
        } catch (CvqException e) {
            e.getMessage();
        }
        return null;
    }
    
    public MeansOfContact getMeansOfContactByType(MeansOfContactEnum type) throws CvqException {
       return _meansOfContactService.getMeansOfContactByType(type);
    }

    public Collection getCurrentEcitizenEnabledMeansOfContact() throws CvqException {
        return meansOfContactListToReferentialDataList(
                _meansOfContactService.getCurrentEcitizenEnabledMeansOfContact());
    }
    
    public List<MeansOfContact> getAdultEnabledMeansOfContact(Adult adult) throws CvqException {
        return  _meansOfContactService.getAdultEnabledMeansOfContact(adult);
    }
    
    public Collection getEnabledMeansOfContact() throws CvqException {
        return meansOfContactListToReferentialDataList(
                _meansOfContactService.getEnabledMeansOfContact());
    }
    
    private Collection meansOfContactListToReferentialDataList(List<MeansOfContact> mocList){
        Collection referentialDataList = new ArrayList();
        
        for (MeansOfContact moc : mocList) {
            ReferentialData data = new ReferentialData(
                    moc.getType().toString(),
                    BusinessDictionary.getMeansofContactEnum(moc.getType())
                    );
            referentialDataList.add(data);
        }
            
        if (referentialDataList.size() == 0)
            referentialDataList.add(new ReferentialData("NoData", "Pas de données"));
        return referentialDataList;
    }
    
    /**
     * @return Returns the familyHomeService.
     */
    public IHomeFolderService getHomeFolderService() {
        return _familyHomeService;
    }

    /**
     * @return Returns the requestService.
     */
    public IRequestService getRequestService() {
        return _requestService;
    }

    /**
     * @return Returns the authenticationService.
     */
    public IAuthenticationService getAuthenticationService() {
        return _authenticationService;
    }

    /**
     * @return Returns the schoolRegistrationRequestService.
     */
    public ISchoolRegistrationRequestService getSchoolRegistrationRequestService() {
        return _schoolRegistrationRequestService;
    }

    /**
     * @return Returns the perischoolActivityRegistrationRequestService.
     */
    public IPerischoolActivityRegistrationRequestService getPeriSchoolRegistrationRequestService() {
        return _periSchoolRegistrationRequestService;
    }

    /**
     * @return Returns the recreationActivityRegistrationRequestService.
     */
    public IRecreationActivityRegistrationRequestService getRecreationRegistrationRequestService() {
        return (IRecreationActivityRegistrationRequestService)getAc().getBean(IRecreationActivityRegistrationRequestService.SERVICE_NAME);
    }

    public IMilitaryCensusRequestService getMilitaryCensusRequestService() {
        return (IMilitaryCensusRequestService) getAc().getBean(IMilitaryCensusRequestService.SERVICE_NAME);
    }
    
    /**
     * @return Returns the documentService.
     */
    public IDocumentService getDocumentService() {
        return _documentService;
    }

    /**
     * @return Returns the adultService.
     */
    public IAdultService getAdultService() {
        return _adultService;
    }

    public IIndividualService getIndividualService() {
        return _individualService;
    }

    public IChildService getChildService() {
        return _childService;
    }

    /**
     * @param pApplicationContext
     *            The applicationContext to set.
     */
    public void setApplicationContext(WebApplicationContext pApplicationContext) {
        _applicationContext = pApplicationContext;
    }

    /**
     * @return Returns the schoolCanteenRegistrationRequestService.
     */
    public ISchoolCanteenRegistrationRequestService getSchoolCanteenRegistrationRequestService() {
        return _schoolCanteenRegistrationRequestService;
    }

    public IPaymentService getPaymentService() {
        return (IPaymentService) _applicationContext.getBean(IPaymentService.SERVICE_NAME);
    }

    public IHomeFolderModificationRequestService getFamilyHomeModificationService() {
        return _familyHomeModificationService;
    }
    
    public IMeansOfContactService getMeansOfContactService() {
        return _meansOfContactService;
    }

    public static boolean scanDocumentData(String site) {
        if (BusinessManager.getAc() != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)BusinessManager.getAc().getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            LocalAuthorityConfigurationBean localAuthority = registry.getLocalAuthorityBeanByName(site);
            return localAuthority.isDocumentDigitalizationEnabled().booleanValue();
        }
        return true;
    }

    public static LocalAuthorityConfigurationBean getCurrentSiteData() {
        if (BusinessManager.getAc() != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)BusinessManager.getAc().getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            String site = SecurityContext.getCurrentSite().getName();
            LocalAuthorityConfigurationBean localAuthority = registry.getLocalAuthorityBeanByName(site);
            return localAuthority;
        }
        return null;
    }

    public static String getAssetsBase() {
        if (BusinessManager.getAc() != null) {
            ILocalAuthorityRegistry registry = (ILocalAuthorityRegistry)BusinessManager.getAc().getBean(ILocalAuthorityRegistry.SERVICE_NAME);
            return registry.getAssetsBase();
        }
        return null;
    }

}

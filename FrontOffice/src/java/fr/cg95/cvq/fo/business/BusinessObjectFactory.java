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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import fr.cg95.cvq.business.document.Document;
import fr.cg95.cvq.business.document.DocumentBinary;
import fr.cg95.cvq.business.document.DocumentType;
import fr.cg95.cvq.business.request.RequestType;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.fo.common.FamilyHome;
import fr.cg95.cvq.fo.common.Request;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.StartupServlet;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.fo.util.ImageHandler;
import fr.cg95.cvq.fo.util.TimeHandler;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.document.IDocumentService;
import fr.cg95.cvq.service.request.IRequestService;

/**
 * @author Laurent MARQUEZ
 * 
 */
public class BusinessObjectFactory implements Constants {

    public static void setFamilyHomeForm(HomeFolder pFamilyHome, FamilyHome pSessionFamilyHome) {

        // get entities
        Set entities = pFamilyHome.getIndividuals();

        // sort entities
        HashMap adults = new HashMap();
        ArrayList children = new ArrayList();

        // family login
        LoginForm loginForm = new LoginForm();
        setFrontOfficeLoginFromBusiness(pFamilyHome.getHomeFolderResponsible(), loginForm);
        pSessionFamilyHome.setLogin(loginForm);

        // family home responsible
        AdultForm familyHomeResponsibleAdult = convertAdultFromBusiness(pFamilyHome
                .getHomeFolderResponsible());
        familyHomeResponsibleAdult.setFamilyHomeResponsible(true);
        adults.put(familyHomeResponsibleAdult.getId(), familyHomeResponsibleAdult);

        // Keep the original responsibleId for reference while modifying homeFolder
        pSessionFamilyHome.setResponsibleId(familyHomeResponsibleAdult.getId());

        // Iterating over the individuals in the home foilder
        // Convert first all adults
        Iterator it = entities.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof Adult) {
                Adult adult = (Adult) element;
                AdultForm adultForm = convertAdultFromBusiness(adult);

                // we had the adult to the family home
                // only when it's not the family home responsible adult.
                if (!sameAdult(familyHomeResponsibleAdult, adultForm)) {
                    adults.put(adultForm.getId(), adultForm);
                }
            }
        }
        // Next convert all children
        it = entities.iterator();
        while (it.hasNext()) {
            Object element = it.next();
            if (element instanceof Child) {
                Child child = (Child) element;
                children.add(convertChildFromBusiness(child, adults));
            }
        }

        // set the adults and children collection to the session family home
        pSessionFamilyHome.setAdults(adults.values());
        pSessionFamilyHome.setChildren(children);

        // set family home id to the session family home
        pSessionFamilyHome.setId(pFamilyHome.getId());
        pSessionFamilyHome.setBoundToRequest(pFamilyHome.getBoundToRequest().booleanValue());
        pSessionFamilyHome.setFamilyQuotient(pFamilyHome.getFamilyQuotient());
    }

    public static void loadDocumentPages(HttpSession session, DocumentForm documentForm) {
        IDocumentService service = BusinessManager.getInstance().getDocumentService();

        try {
            Iterator data = service.getAllPages(Long.valueOf(documentForm.getId())).iterator();
            while (data.hasNext()) {
                DocumentBinary binary = (DocumentBinary) data.next();

                try {
                    if (binary.getPageNumber().intValue() == 0) {
                        File file = StartupServlet.getTempContextFile(session, "document", ".lp7");
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(binary.getData());
                        fos.close();
                        documentForm.setCertifiedFile(file);
                        
                    } else {
                        File file = StartupServlet.getTempContextFile(session, "paper");
    
                        ImageHandler.createFileFromBytes(file, ImageHandler.JPG_FORMAT, binary.getData());
                        documentForm.addServerFile(binary.getPageNumber().intValue(), file);
                    }

                } catch (IOException ioe) {
                }
            }
        } catch (CvqException ce) {
        }
    }

    public static void setHomeFolderDocuments(FamilyHome familyHome, Set documents) {
        Iterator it = documents.iterator();
        while (it.hasNext()) {
            Document document = (Document) it.next();
            DocumentForm documentForm = new DocumentForm();

            documentForm.setId(document.getId().toString());
            documentForm.setType(BusinessDictionary.getDocumentType(document.getDocumentType().getType()));
            documentForm.setTypeId(document.getDocumentType().getType());
            documentForm.setAvailable(true);
            documentForm.setSelected(true);
            
            if (document.getCertified().booleanValue())
                documentForm.setState(STATE_CERTIFIED);
            else
                documentForm.setState(BusinessDictionary.getDocumentState(document.getState()));
            documentForm.setPerson(document.getIndividual());
            documentForm.setExpirationDate(document.getEndValidityDate());
            documentForm.setSubmissionDate(document.getCreationDate());
            documentForm.setValidationDate(document.getValidationDate());
            documentForm.setCertified(document.getCertified().booleanValue());

            familyHome.addDocument(documentForm);
        }
    }

    public static Collection getRequestsDone(RequestManager requestManager, Set pRequest) {
        ArrayList requests = new ArrayList();
        Iterator it = pRequest.iterator();
        while (it.hasNext()) {
            fr.cg95.cvq.business.request.Request request = (fr.cg95.cvq.business.request.Request) it.next();

            requests.add(convertRequestFromBusiness(requestManager, request));
        }
        return requests;
    }

    public static AdultForm convertAdultFromBusiness(Adult pAdult) {
        AdultForm adult = new AdultForm();
        if (null != pAdult.getId()) {
            adult.setId(pAdult.getId());
        }
        adult.setFirstName(pAdult.getFirstName());
        adult.setFirstNameTwo(pAdult.getFirstName2());
        adult.setFirstNameThree(pAdult.getFirstName3());
        adult.setLastName(pAdult.getLastName());
        adult.setBirthDate(pAdult.getBirthDate());
        if (null != pAdult.getBirthDate()) {
            adult.setBirthDay(TimeHandler.parseDate(pAdult.getBirthDate(), DAY_DATE_FORMAT));

            adult.setBirthMonth(TimeHandler.parseDate(pAdult.getBirthDate(), MONTH_DATE_FORMAT));

            adult.setBirthYear(TimeHandler.parseDate(pAdult.getBirthDate(), YEAR_DATE_FORMAT));
        }
        adult.setBirthPlaceCountry(BusinessDictionary.getCountry(pAdult.getBirthCountry()));
        adult.setBirthPlaceCity(pAdult.getBirthCity());
        adult.setBirthPlacePostalCode(pAdult.getBirthPostalCode());

        adult.setAdditionalDeliveryInformation(pAdult.getAdress().getAdditionalDeliveryInformation());
        adult.setAdditionalGeographicalInformation(pAdult.getAdress().getAdditionalGeographicalInformation());
        adult.setStreetNumber(pAdult.getAdress().getStreetNumber());
        adult.setStreetName(pAdult.getAdress().getStreetName());
        adult.setPlaceNameOrService(pAdult.getAdress().getPlaceNameOrService());
        adult.setPostalCode(pAdult.getAdress().getPostalCode());
        adult.setCity(pAdult.getAdress().getCity());
        
        adult.setDomicilePhone(pAdult.getHomePhone());
        adult.setMobilePhone(pAdult.getMobilePhone());
        adult.setOfficePhone(pAdult.getOfficePhone());
        adult.setEmail(pAdult.getEmail());
        adult.setTitle(BusinessDictionary.getTitleType(pAdult.getTitle()));
        adult.setFamilyStatus(BusinessDictionary.getFamilyStatus(pAdult.getFamilyStatus()));

        adult.setUserName(pAdult.getNameOfUse());
        adult.setMaidenName(pAdult.getMaidenName());
        adult.setProfession(pAdult.getProfession());

        adult.setLogin(pAdult.getLogin());
        adult.setQuestion(pAdult.getQuestion());
        adult.setAnswer(pAdult.getAnswer());

        adult.setExternalToHomeFolder(pAdult.getHomeFolder() == null);

        if (pAdult.getTitle().equals(TitleType.MISTER))
            adult.setSex(BusinessDictionary.getSexType(SexType.MALE));
        else if (pAdult.getTitle().equals(TitleType.MADAM))
            adult.setSex(BusinessDictionary.getSexType(SexType.FEMALE));
        else if (pAdult.getTitle().equals(TitleType.MISS))
            adult.setSex(BusinessDictionary.getSexType(SexType.FEMALE));

        return adult;
    }

    public static void setFrontOfficeLoginFromBusiness(Adult pAdult, LoginForm pLogin) {

        pLogin.setUserName(pAdult.getLogin());
        pLogin.setPassword(pAdult.getPassword());
        pLogin.setQuestion(pAdult.getQuestion());
        pLogin.setAnswer(pAdult.getAnswer());

    }

    public static ChildForm convertChildFromBusiness(Child pChild, HashMap adults) {
        ChildForm child = new ChildForm();

        if (null != pChild.getId()) {
            child.setId(pChild.getId());
        }
        if (null != pChild.getSex()) {
            child.setSex(BusinessDictionary.getSexType(pChild.getSex()));
        }
        child.setFirstName(pChild.getFirstName());
        child.setFirstNameTwo(pChild.getFirstName2());
        child.setFirstNameThree(pChild.getFirstName3());
        child.setLastName(pChild.getLastName());
        child.setBirthDate(pChild.getBirthDate());
        if (null != pChild.getBirthDate()) {
            child.setBirthDay(TimeHandler.parseDate(pChild.getBirthDate(), DAY_DATE_FORMAT));
            child.setBirthMonth(TimeHandler.parseDate(pChild.getBirthDate(), MONTH_DATE_FORMAT));
            child.setBirthYear(TimeHandler.parseDate(pChild.getBirthDate(), YEAR_DATE_FORMAT));
        }
        child.setBirthPlaceCountry(BusinessDictionary.getCountry(pChild.getBirthCountry()));
        child.setBirthPlaceCity(pChild.getBirthCity());
        child.setBirthPlacePostalCode(pChild.getBirthPostalCode());
        // child.setNationality(pChild.getNationality());
        child.setAdditionalDeliveryInformation(pChild.getAdress().getAdditionalDeliveryInformation());
        child.setAdditionalGeographicalInformation(pChild.getAdress().getAdditionalGeographicalInformation());
        child.setStreetNumber(pChild.getAdress().getStreetNumber());
        child.setStreetName(pChild.getAdress().getStreetName());
        child.setPlaceNameOrService(pChild.getAdress().getPlaceNameOrService());
        child.setPostalCode(pChild.getAdress().getPostalCode());
        child.setCity(pChild.getAdress().getCity());

        // legacy responsible
        Set legacyResponsibles = pChild.getLegalResponsibles();
        Iterator itLegacyResponsible = legacyResponsibles.iterator();

        while (itLegacyResponsible.hasNext()) {
            ChildLegalResponsible legacyResponsible = (ChildLegalResponsible) itLegacyResponsible.next();

            AdultForm frontOfficeLegacyResponsible = (AdultForm) adults.get(legacyResponsible
                    .getLegalResponsible().getId());
            if (frontOfficeLegacyResponsible == null)
                frontOfficeLegacyResponsible = convertAdultFromBusiness(legacyResponsible
                        .getLegalResponsible());

            frontOfficeLegacyResponsible.setQuality(BusinessDictionary.getQualityType(legacyResponsible
                    .getRole()));
            child.addAdultResponsible(frontOfficeLegacyResponsible);
        }

        return child;
    }

    private static boolean sameAdult(AdultForm pAdultResponsible, AdultForm pAdult) {
        if (pAdultResponsible.getFirstName().equals(pAdult.getFirstName())
                && pAdultResponsible.getLastName().equals(pAdult.getLastName())) {
            return true;
        }
        return false;
    }

    private static Request convertRequestFromBusiness(RequestManager requestManager, fr.cg95.cvq.business.request.Request pRequest) {
        Request request = new Request();
        request.setId(pRequest.getId());

        request.setType(requestManager.getRequestTypeLabel(pRequest.getRequestType().getLabel()));
        request.setState(BusinessDictionary.getRequestState(pRequest.getState()));
        request.setCreationDate(pRequest.getCreationDate());

        Individual subject = (Individual)pRequest.getSubject();
        if (subject != null) {
            request.setSubjectId(subject.getId());
            request.setSubjectName(subject.getFirstName());
        }
        return request;
    }

    public static String convertBoolean(boolean pBoolean) {
        return (pBoolean) ? YES : NO;
    }

    public static void setRequiredDocuments(RequestManager requestManager, Request cvqRequest) throws CvqException {
        IRequestService iRequestService = BusinessManager.getInstance().getRequestService();

        RequestType requestType = requestManager.getRequestType(cvqRequest);

        String site = SecurityContext.getCurrentSite().getName();
        cvqRequest.setScanDocuments(BusinessManager.scanDocumentData(site));
        
        if (requestType != null) {
            // get the documents associated to the request
            Set associatedDocuments = iRequestService.getAllowedDocuments(requestType);

            //
            Iterator it = associatedDocuments.iterator();

            while (it.hasNext()) {
                DocumentType documentType = (DocumentType) it.next();

                DocumentForm document = new DocumentForm();
                document.setType(BusinessDictionary.getDocumentType(documentType.getType()));
                document.setTypeId(documentType.getType());

                cvqRequest.addDocument(document);
            }
        }
    }
    
    public static void setExpectedDocuments(FamilyHome familyHome, Request cvqRequest) throws CvqException {
        
        Iterator iter = familyHome.getDocuments().iterator();
        while (iter.hasNext()) {
            DocumentForm documentForm = (DocumentForm)iter.next();

            if (cvqRequest.getDocument(documentForm.getTypeId()) != null) {
                // Check current date is before the expiration date
                Calendar expirationDate = documentForm.getExpirationCalendar();
                if ((expirationDate == null) || Calendar.getInstance().before(expirationDate)) {
                
                    // Get the id of the person related to the document
                    Long personId = null;
                    if (documentForm.getPerson() != null)
                        personId = documentForm.getPerson().getId();
                    
                    // If the document is not related to a person or related to the requester or the subject
                    if ((personId == null) || 
                         personId.equals(cvqRequest.getRequesterId()) || 
                         personId.equals(cvqRequest.getSubjectId())) {
                        cvqRequest.changeDocument(documentForm);
                    }
                }
            }
        }
    }

    public static DocumentBinary createDocumentBinaryFromFront(byte[] data, int pageNumber)
            throws java.io.IOException {

        DocumentBinary docBin = new DocumentBinary();
        docBin.setData(data);
        docBin.setPageNumber(new Integer(pageNumber + 1));

        return docBin;
    }

}

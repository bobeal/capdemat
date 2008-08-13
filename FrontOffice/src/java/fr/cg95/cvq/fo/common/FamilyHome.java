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
package fr.cg95.cvq.fo.common;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.payment.Payment;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.fo.business.BusinessObjectFactory;
import fr.cg95.cvq.fo.common.form.AdultForm;
import fr.cg95.cvq.fo.common.form.ChildForm;
import fr.cg95.cvq.fo.common.form.DocumentForm;
import fr.cg95.cvq.fo.common.form.IndividualForm;
import fr.cg95.cvq.fo.common.form.LoginForm;
import fr.cg95.cvq.fo.dispatcher.DispatchFilter;
import fr.cg95.cvq.fo.dispatcher.SessionManager;
import fr.cg95.cvq.fo.util.Constants;
import fr.cg95.cvq.service.users.IRequestService;
import fr.cg95.cvq.wizard.IProcessWizard;

public class FamilyHome implements Serializable {

    public static final String SESSION_NAME = "familyHome";

    private static Logger logger = Logger.getLogger(FamilyHome.class);
    
	private Long id;

	private Long responsibleId;

	private HashMap adults = new HashMap();

    private HashMap children = new HashMap();

    private HashMap<String,DocumentForm> documents = new HashMap<String,DocumentForm>();
    private DocumentForm currentDocument = null;

	private Collection selectionList = null;
    private IndividualForm individualToRegister = null;
    private boolean spouse = false;
    
	private LoginForm login = new LoginForm();

    private boolean boundToRequest = false;
    private String familyQuotient = null;
   
    private HttpSession session = null;
    
	public FamilyHome(HttpSession session) {
		super();
        this.session = session;
	}

	public void addDocument(DocumentForm documentForm) {
		this.documents.put(documentForm.getId().toString(), documentForm);
	}

    public DocumentForm getDocumentByTypeId(Integer typeId) {
        
        Iterator iter = getDocuments().iterator();
        while (iter.hasNext()) {
            DocumentForm documentForm = (DocumentForm)iter.next();
            if (documentForm.getTypeId().equals(typeId))
                return documentForm;
        }
        return null;
    }

    public DocumentForm getDocumentById(String id) {
        return this.documents.get(id);
    }

    public Collection getChildren() {
		return this.children.values();
	}

	public Collection getAdults() {
		return this.adults.values();
	}
    
    public Collection getIndividuals() {
        ArrayList individuals = new ArrayList(getAdults());
        individuals.addAll(getChildren());

        return individuals;
    }

    public Collection getIndividuals(Set people) {
        ArrayList individuals = new ArrayList();
        
        HashMap allPeople = new HashMap(adults);
        allPeople.putAll(children);
        
        Iterator iter = people.iterator();
        while (iter.hasNext()) {
            Individual individual = (Individual)iter.next();
            individuals.add(allPeople.get(individual.getFirstName()+individual.getLastName()));
        }
        return individuals;
    }
    
    public Collection getAdults(Set adults) {
        ArrayList individuals = new ArrayList();
        Iterator iter = adults.iterator();
        while (iter.hasNext()) {
            Individual individual = (Individual)iter.next();
            individuals.add(this.adults.get(individual.getFirstName()+individual.getLastName()));
        }
        return individuals;
    }
    
    public Collection getChildren(Set children) {
        ArrayList individuals = new ArrayList();
        Iterator iter = children.iterator();
        while (iter.hasNext()) {
            Individual individual = (Individual)iter.next();
            individuals.add(this.children.get(individual.getFirstName()+individual.getLastName()));
        }
        return individuals;
    }
    
    public Collection getSelectionList() {
        return selectionList;
    }

    public List getSelectionListWithoutCurrent() {
        List individuals = new ArrayList(selectionList);

        IndividualForm individual = getIndividualToRegister();
        if (individual != null)
            individuals.remove(individual);

        return individuals;
    }

    public void setSelectionList(Collection selectionList) {
        this.selectionList = selectionList;
    }

    public Collection getRequestsDone() {
        try {
            Set requests = BusinessManager.getInstance().findRequestsByFamilyHomeId(this.getId());
            return BusinessObjectFactory.getRequestsDone(SessionManager.getRequestManager(session), requests);
        } catch (CvqException e) {
            logger.error("getRequestsDone()", e);
        }
        return null;
    }

    public Collection getDocuments() {
        // Get the documents for the homefolder
        try {
            Set documents = BusinessManager.getInstance().getHomeFolderService().getAssociatedDocuments(this.getId());
            this.documents.clear();
            BusinessObjectFactory.setHomeFolderDocuments(this, documents);
        } catch (CvqObjectNotFoundException e) {
            logger.error("getDocuments()", e);
        } catch (CvqException e) {
            logger.error("getDocuments()", e);
        }
        return this.documents.values();
    }

    public Collection getGroupedDocuments() {
        HashMap<Integer, DocumentForm> groupedDocuments = new HashMap<Integer, DocumentForm>();
        HashMap<String, DocumentForm> groups = new HashMap<String, DocumentForm>();
        
        Iterator iter = getDocuments().iterator();
        while (iter.hasNext()) {
            DocumentForm documentForm = (DocumentForm)iter.next();
            if (groupedDocuments.get(documentForm.getTypeId()) == null) {
                groupedDocuments.put(documentForm.getTypeId(), documentForm);
            } else {
                ArrayList<DocumentForm> docs = groupedDocuments.get(documentForm.getTypeId()).getDocuments();
                if (docs == null) {
                    // Take the first inserted document, place it in the list and create a new group
                    DocumentForm first = groupedDocuments.get(documentForm.getTypeId());
                    docs = new ArrayList<DocumentForm>();
                    docs.add(first);
                    
                    DocumentForm group = new DocumentForm();
                    group.setId("g" + first.getId());
                    group.setTypeId(first.getTypeId());
                    group.setType(first.getType());
                    group.setDocuments(docs);
                    groupedDocuments.put(group.getTypeId(), group);
                    groups.put(group.getId(), group);
                }
                docs.add(documentForm);
            }
        }
        this.documents.putAll(groups);
        return groupedDocuments.values();
    }
    
	/**
	 * @param pAdults
	 *            The adults to set.
	 */
	public void setAdults(Collection pAdults) {
		this.adults = convertAdult(pAdults);
	}

	/**
	 * @param pChildren
	 *            The children to set.
	 */
	public void setChildren(Collection pChildren) {
		this.children = convertChild(pChildren);
	}

	public ChildForm getChildById(Long pChildId) throws Exception {
		Iterator it = this.children.values().iterator();

		// Iterating over the elements in the collection
		while (it.hasNext()) {
			// Get Child
			ChildForm child = (ChildForm) it.next();
			if (child.getId().equals(pChildId)) {
				return child;
			}
		}
		// must never arrived !
		throw new Exception("There is no child with this Id!");
	}

	public AdultForm getFamilyHomeResponsible() throws Exception {

		Iterator it = this.adults.values().iterator();

		// Iterating over the elements in the collection
		while (it.hasNext()) {
			// Get Adult
			AdultForm adult = (AdultForm) it.next();
			if (adult.isFamilyHomeResponsible()) {
				return adult;
			}
		}
		// must never arrived !
		throw new Exception("There is no family home responsible!");
	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param pId
	 *            The id to set.
	 */
	public void setId(Long pId) {
		this.id = pId;
	}

	/**
	 * @return Returns the login.
	 */
	public LoginForm getLogin() {
		return this.login;
	}

	/**
	 * @param pLogin
	 *            The login to set.
	 */
	public void setLogin(LoginForm pLogin) {
		this.login = pLogin;
	}

	private HashMap convertChild(Collection pCollection) {

		HashMap map = new HashMap();

		for (Iterator it = pCollection.iterator(); it.hasNext();) {
			ChildForm child = (ChildForm) it.next();
			map.put(child.getFirstName() + child.getLastName(), child);

		}

		return map;
	}

	private HashMap convertAdult(Collection pCollection) {

		HashMap map = new HashMap();

		for (Iterator it = pCollection.iterator(); it.hasNext();) {
			AdultForm adult = (AdultForm) it.next();
			map.put(adult.getFirstName() + adult.getLastName(), adult);

		}

		return map;
	}

	public Collection getEmails() {

		// hashset to exclude the doublon
		Set emails = new HashSet();

		// parse the adults
		Collection adults = this.adults.values();
		Iterator itAdults = adults.iterator();

		while (itAdults.hasNext()) {
			AdultForm adult = (AdultForm) itAdults.next();
			String email = adult.getEmail();

			if ((null != email) && (false == email.equals(""))) {
				emails.add(email);
			}

		}
		// parse the legal responsibles
		// Collection children = this.children.values();
		// Iterator itChildren = children.iterator();
		//
		// while (itChildren.hasNext()) {
		// ChildForm child = (ChildForm) itChildren.next();
		//
		// Collection externalLegacyResponsibles = child
		// .getExternalAdultResponsibles();
		// Iterator itExternalLegacyResponsibles = externalLegacyResponsibles
		// .iterator();
		//
		// while (itExternalLegacyResponsibles.hasNext()) {
		// AdultForm externalLegacyResponsible = (AdultForm) itExternalLegacyResponsibles
		// .next();
		// String email = externalLegacyResponsible.getEmail();
		//
		// if ((null != email) && (false == email.equals(""))) {
		// emails.add(email);
		// }
		// }
		// }

		return emails;
	}

	public Collection getOfficePhones() {

		// hashset to exclude the doublon
		Set officePhones = new HashSet();

		// parse the adults
		Collection adults = this.adults.values();
		Iterator itAdults = adults.iterator();
		while (itAdults.hasNext()) {
			AdultForm adult = (AdultForm) itAdults.next();
			String officePhone = adult.getOfficePhone();
			if ((null != officePhone) && (false == officePhone.equals(""))) {
				officePhones.add(officePhone);
			}
		}

		// parse the legal responsibles
		// Collection children = this.children.values();
		// Iterator itChildren = children.iterator();
		//
		// while (itChildren.hasNext()) {
		// ChildForm child = (ChildForm) itChildren.next();
		//
		// Collection externalLegacyResponsibles = child
		// .getExternalAdultResponsibles();
		// Iterator itExternalLegacyResponsibles = externalLegacyResponsibles
		// .iterator();
		//
		// while (itExternalLegacyResponsibles.hasNext()) {
		// AdultForm externalLegacyResponsible = (AdultForm) itExternalLegacyResponsibles
		// .next();
		// String officePhone = externalLegacyResponsible.getOfficePhone();
		//
		// if ((null != officePhone) && (false == officePhone.equals(""))) {
		// officePhones.add(officePhone);
		// }
		// }
		// }

		return officePhones;
	}

	public Collection getMobilePhones() {

		// hashset to exclude the doublon
		Set mobilePhones = new HashSet();

		Collection adults = this.adults.values();
		Iterator itAdults = adults.iterator();
		while (itAdults.hasNext()) {
			AdultForm adult = (AdultForm) itAdults.next();
			String mobilePhone = adult.getMobilePhone();
			if ((null != mobilePhone) && (false == mobilePhone.equals(""))) {
				mobilePhones.add(mobilePhone);
			}
		}

		// parse the legal responsibles
		// Collection children = this.children.values();
		// Iterator itChildren = children.iterator();
		//
		// while (itChildren.hasNext()) {
		// ChildForm child = (ChildForm) itChildren.next();
		//
		// Collection externalLegacyResponsibles = child
		// .getExternalAdultResponsibles();
		// Iterator itExternalLegacyResponsibles = externalLegacyResponsibles
		// .iterator();
		//
		// while (itExternalLegacyResponsibles.hasNext()) {
		// AdultForm externalLegacyResponsible = (AdultForm) itExternalLegacyResponsibles
		// .next();
		// String mobilePhone = externalLegacyResponsible.getMobilePhone();
		//
		// if ((null != mobilePhone) && (false == mobilePhone.equals(""))) {
		// mobilePhones.add(mobilePhone);
		// }
		// }
		// }

		return mobilePhones;
	}

	public Collection getDomicilePhones() {

		// hashset to exclude the doublon
		Set domicilePhones = new HashSet();

		Collection adults = this.adults.values();
		Iterator itAdults = adults.iterator();
		while (itAdults.hasNext()) {
			AdultForm adult = (AdultForm) itAdults.next();
			String domicilePhone = adult.getDomicilePhone();
			if ((null != domicilePhone) && (false == domicilePhone.equals(""))) {
				domicilePhones.add(domicilePhone);
			}

		}

		// parse the legal responsibles
		// Collection children = this.children.values();
		// Iterator itChildren = children.iterator();
		//
		// while (itChildren.hasNext()) {
		// ChildForm child = (ChildForm) itChildren.next();
		//
		// Collection externalLegacyResponsibles = child
		// .getExternalAdultResponsibles();
		// Iterator itExternalLegacyResponsibles = externalLegacyResponsibles
		// .iterator();
		//
		// while (itExternalLegacyResponsibles.hasNext()) {
		// AdultForm externalLegacyResponsible = (AdultForm) itExternalLegacyResponsibles
		// .next();
		// String domicilePhone = externalLegacyResponsible
		// .getDomicilePhone();
		//
		// if ((null != domicilePhone)
		// && (false == domicilePhone.equals(""))) {
		// domicilePhones.add(domicilePhone);
		// }
		// }
		// }

		return domicilePhones;
	}

	public String getEmergencyPhone() {

		// String emergencyPhoneSchool =
		// getSchoolChildRegistrationRequest().getSchool().getEmergencyPhone();
		// String emergencyPhonePeriSchool =
		// getPeriSchoolChildRegistrationRequest().getPeriSchool().getEmergencyPhone();
		// String emergencyPhoneSchoolCanteen =
		// getSchoolCanteenChildRegistrationRequest().getSchoolCanteen().getEmergencyPhone();
		String emergencyPhone = "";

		// if ((null != emergencyPhoneSchool) && (false == emergencyPhoneSchool.equals(""))) {
		// emergencyPhone = emergencyPhoneSchool;
		// }
		// if (emergencyPhonePeriSchool != null) {
		// emergencyPhone = emergencyPhonePeriSchool;
		// }
		// if (emergencyPhoneSchoolCanteen != null) {
		// emergencyPhone = emergencyPhoneSchoolCanteen;
		// }
		return emergencyPhone;
	}

	public Collection getPhones() {

		// hashset to exclude the doublon
		Set phones = new HashSet();
		phones.addAll(getMobilePhones());
		phones.addAll(getOfficePhones());
		phones.addAll(getDomicilePhones());
		phones.add(getEmergencyPhone());

		return phones;
	}

	public boolean isNewResponsible() {

		try {
			return (this.responsibleId == null)
					|| !this.responsibleId.equals(getFamilyHomeResponsible().getId());
		} catch (Exception e) {
		}
		return true;
	}

	public void setResponsibleId(Long long1) {
		this.responsibleId = long1;
	}

	public Long getResponsibleId() {
		return this.responsibleId;
	}

	public IndividualForm getIndividualToRegister() {
		return this.individualToRegister;
	}

	public void setIndividualToRegister(IndividualForm childToRegister) {
		this.individualToRegister = childToRegister;
	}

    public boolean getSpouse() {
        return spouse;
    }

    public void setSpouse(boolean spouse) {
        this.spouse = spouse;
    }

    public boolean getNoModificationRequest() {
        return !BusinessManager.hasModificationRequest(getId());
    }

    public boolean getHasOpenSeasons() {
        String processName = (String)session.getAttribute(IProcessWizard.PROCESS_NAME);
        return SessionManager.getRequestManager(session).hasOpenSeasons(processName);
    }

    public boolean getHasAuthorizedSubjects() {
        String processName = (String)session.getAttribute(IProcessWizard.PROCESS_NAME);
        Map people = SessionManager.getRequestManager(session).getAuthorizedSubjects(processName, this.id);
        return (people != null) && people.size() > 0;
    }

    public boolean getHasMilitaryChildren() {
        try {
//            BaseAction.setCurrentEcitizen(session);
            return BusinessManager.getInstance().getMilitaryCensusRequestService().getAuthorizedSubjects(this.id).size() > 0;
        } catch (CvqObjectNotFoundException e) {
        } catch (CvqException e) {
        } catch (NullPointerException e) {
        }
        return false;
    }

    public boolean getBoundToRequest() {
        return this.boundToRequest;
    }

    public void setBoundToRequest(boolean boundToRequest) {
        this.boundToRequest = boundToRequest;
    }

    public boolean getPurchaseItems() {
        Payment payment = (Payment) session.getAttribute(Constants.CADDY);
        if (payment != null)
            return (payment.getPurchaseItems() != null) && (payment.getPurchaseItems().size() > 0);
            
        return false;
    }
    
    public DocumentForm getCurrentDocument() {
        return this.currentDocument;
    }

    public void setCurrentDocument(DocumentForm currentDocument) {
        this.currentDocument = currentDocument;
    }
    
    public boolean getAccountData() {
        return (familyQuotient != null) && (familyQuotient.length() > 0);
    }

    public String getFamilyQuotient() {
        return familyQuotient;
    }

    public void setFamilyQuotient(String familyQuotient) {
        this.familyQuotient = familyQuotient;
    }

}

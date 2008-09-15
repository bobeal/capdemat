package fr.cg95.cvq.bo.citizen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;

import fr.cg95.cvq.bo.Utils;
import fr.cg95.cvq.bo.business.BusinessDictionary;
import fr.cg95.cvq.bo.business.BusinessManager;
import fr.cg95.cvq.bo.record.AdultRecord;
import fr.cg95.cvq.bo.record.ChildRecord;
import fr.cg95.cvq.bo.record.IPersistence;
import fr.cg95.cvq.bo.record.IndividualRecord;
import fr.cg95.cvq.bo.record.RequestRecord;
import fr.cg95.cvq.business.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.ChildLegalResponsible;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.request.IHomeFolderModificationRequestService;
import fr.cg95.cvq.service.users.IAdultService;
import fr.cg95.cvq.service.users.IChildService;
import fr.cg95.cvq.service.users.IIndividualService;
import fr.cg95.cvq.xml.common.AddressType;
import fr.cg95.cvq.xml.common.AdultType;
import fr.cg95.cvq.xml.common.ChildType;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.RequestType;

public class VoCardPersistence extends IPersistence {

    static Logger logger = Logger.getLogger(VoCardPersistence.class);

    public VoCardPersistence() {
        super();
    }

    public String getServiceName(String definitionName) {
        if (definitionName.equals("eCitizen"))
            return IVoCardRequestService.SERVICE_NAME;

        if (definitionName.equals("eFamily"))
            return IHomeFolderModificationRequestService.SERVICE_NAME;
        
        return "";
    }

    public void initRequest(RequestRecord requestRecord) {
    }
    
    public void loadRequest(Request request, RequestRecord requestRecord) {
        VoCardRequestRecord record = (VoCardRequestRecord)requestRecord;

        HomeFolder family = request.getHomeFolder();
        
        record.setDataId(family.getId());
        record.setPublicKey(family.getHomeFolderResponsible().getPublicKey());
    }

    public void saveRequest(Request request, RequestRecord requestRecord) throws CvqException {
        if (BusinessManager.getAc() != null) {
            IIndividualService service = (IIndividualService) BusinessManager.getAc().getBean(IIndividualService.SERVICE_NAME);

            try {
                VoCardRequestRecord record = (VoCardRequestRecord)requestRecord;
                
                Individual responsible = (Individual) service.getById(record.getFamily().getResponsible()
                        .getId());

                responsible.setPublicKey(record.getPublicKey());

                service.modify(responsible);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveSchoolRequest", e);
                throw e;
            } catch (CvqException e) {
                logger.error("saveSchoolRequest", e);
                throw e;
            }
        }
    }

    public void saveRequestData(Request request, RequestRecord requestRecord) throws CvqException {
        VoCardRequestRecord record = (VoCardRequestRecord)requestRecord;
        
        ArrayList individuals = record.getFamily().getAdults();
        
        for (int i = 0; i < individuals.size(); i++) {
            if (((AdultRecord)individuals.get(i)).isModified()) {
                saveAdult((AdultRecord)individuals.get(i));
                ((AdultRecord)individuals.get(i)).reset();
            }
        }

        individuals = record.getFamily().getChildren();
        
        if (individuals != null) {
            for (int i = 0; i < individuals.size(); i++) {
                if (((ChildRecord)individuals.get(i)).isModified()) {
                    saveChild((ChildRecord)individuals.get(i));
                    ((ChildRecord)individuals.get(i)).reset();
                }
            }
        }
    }

    public Long importRequest(RequestType xmlRequest) throws CvqException {
        if (xmlRequest instanceof fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest) {
            fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest request = 
                (fr.cg95.cvq.xml.ecitizen.VoCardRequestDocument.VoCardRequest)xmlRequest;

            IVoCardRequestService service = 
                (IVoCardRequestService)BusinessManager.getAc().getBean(IVoCardRequestService.SERVICE_NAME);
            
            HashSet<Adult> adults = new HashSet<Adult>();
            HashSet<Child> children = new HashSet<Child>();

            IndividualType individuals[] = request.getHomeFolder().getIndividualsArray();
            for (int i = 0; i < individuals.length; i++) {
                Node type = individuals[i].getDomNode().getAttributes().getNamedItem("xsi:type");
                if (type != null) {
                    if (type.getNodeValue().endsWith("ChildType")) {
                        ChildType xmlChild = (ChildType)individuals[i].changeType(ChildType.type);
    
                        Child child = Child.xmlToModel(xmlChild);
                        child.setId(null);
                        child.setLogin(null);
                        children.add(child);
                    }
                    else if (type.getNodeValue().endsWith("AdultType")) {
                        AdultType xmlAdult = (AdultType)individuals[i].changeType(AdultType.type);
    
                        Adult adult = Adult.xmlToModel(xmlAdult);
                        adult.setId(null);
                        adult.setLogin(null);
                        adults.add(adult);
                    }
                }
            }
            AddressType xmlAddress = request.getHomeFolder().getAddress();
            Address address = Address.xmlToModel(xmlAddress);
            address.setId(null);

            // Check legal responsibles in adult array
            for (Child child : children) {
                Iterator iter = child.getLegalResponsibles().iterator();
                while (iter.hasNext()) {
                    ChildLegalResponsible clr = (ChildLegalResponsible)iter.next();
                    Adult adult = checkWithAdults(adults, clr.getLegalResponsible());
                    if (adult != null)
                        clr.setLegalResponsible(adult);
                }
                
            }
            // create the request
            VoCardRequest voCardRequest = new VoCardRequest();

            //
//            BusinessManager.getReferentialData("MeansOfContact")
//            voCardRequest.setMeansOfContact(meansOfContactSet);

            service.create(voCardRequest, adults, children, address);
            
            return voCardRequest.getId();
        }
        return super.importRequest(xmlRequest);
    }

    private Adult checkWithAdults(HashSet<Adult> adults, Adult responsible) {
        for (Adult adult : adults) {
            if (adult.getLastName().equals(responsible.getLastName()) &&
                adult.getFirstName().equals(responsible.getFirstName()) &&
               (adult.getAdress() != null) && (responsible.getAdress() != null) &&
               // TODO Better refactor this, to respect Address Normalisation
                adult.getAdress().getStreetName().equals(responsible.getAdress().getStreetName()) &&
                adult.getAdress().getPostalCode().equals(responsible.getAdress().getPostalCode()) &&
                adult.getAdress().getCity().equals(responsible.getAdress().getCity()))
                    return adult;
        }
        return null;
    }
    
    private void saveAdult(AdultRecord record) {
        if (BusinessManager.getAc() != null) {
            IAdultService service = (IAdultService) BusinessManager.getAc().getBean(IAdultService.SERVICE_NAME);

            try {
                Adult adult = service.getById(record.getId());

                saveIndividual(adult, record);

                adult.setCfbn(record.getCaseOfFamilyBenifitsNumber());
                adult.setEmail(record.getEmail());
                adult.setFamilyStatus(BusinessDictionary.getFamilyStatus(record.getFamilyStatus()));
                adult.setHomePhone(record.getHomePhone());
                adult.setMaidenName(record.getMaidenName());
                adult.setMobilePhone(record.getMobilePhone());
                adult.setNameOfUse(record.getUserName());
                adult.setOfficePhone(record.getOfficePhone());
                adult.setProfession(record.getProfession());
                adult.setTitle(BusinessDictionary.getTitle(record.getTitle()));

                // adultRecord.setQuality();
                // adult.setFamilyHomeResponsible(bResponsible);
                // adultRecord.setMethod();

                service.modify(adult);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveAdult", e);
            } catch (CvqException e) {
                logger.error("saveAdult", e);
            }
        }
    }

    private void saveChild(ChildRecord record) {
        if (BusinessManager.getAc() != null) {
            IChildService service = (IChildService) BusinessManager.getAc().getBean(IChildService.SERVICE_NAME);

            try {
                Child child = service.getById(record.getId());

                saveIndividual(child, record);

                child.setNote(record.getObservations());

                service.modify(child);

            } catch (CvqObjectNotFoundException e) {
                logger.error("saveChild", e);
            } catch (CvqException e) {
                logger.error("saveChild", e);
            }
        }
    }

    private void saveIndividual(Individual individual, IndividualRecord record) {
        individual.setBirthDate(Utils.getStringAsDate(record.getBirthDate()));
        individual.setBirthCity(record.getBirthPlace());
        individual.setBirthPostalCode(record.getBirthPostalCode());
        individual.setBirthCountry(record.getBirthCountry());

        if (individual.getAdress() != null) {
            // TODO Better refactor this, to respect Address Normalisation
            individual.getAdress().setStreetName(record.getAddress());
            individual.getAdress().setPostalCode(record.getPostalCode());
            individual.getAdress().setCity(record.getCity());
        }
        individual.setFirstName(record.getFirstName());
        individual.setFirstName2(record.getFirstName2());
        individual.setFirstName3(record.getFirstName3());
        individual.setLastName(record.getLastName());
        individual.setSex(BusinessDictionary.getSex(record.getSex()));
    }

}

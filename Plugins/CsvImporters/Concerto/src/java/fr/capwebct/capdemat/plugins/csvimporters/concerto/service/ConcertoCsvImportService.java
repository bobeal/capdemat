package fr.capwebct.capdemat.plugins.csvimporters.concerto.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import fr.capwebct.capdemat.plugins.csvimporters.concerto.business.ConcertoLine;
import fr.cg95.cvq.authentication.IAuthenticationService;
import fr.cg95.cvq.business.authority.School;
import fr.cg95.cvq.business.request.ecitizen.VoCardRequest;
import fr.cg95.cvq.business.request.school.PerischoolActivityRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.LocalReferentialData;
import fr.cg95.cvq.business.users.RoleEnum;
import fr.cg95.cvq.business.users.TitleType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ISchoolService;
import fr.cg95.cvq.service.importer.ICsvImportProviderService;
import fr.cg95.cvq.service.request.ecitizen.IVoCardRequestService;
import fr.cg95.cvq.service.request.school.IPerischoolActivityRegistrationRequestService;
import fr.cg95.cvq.service.request.school.ISchoolCanteenRegistrationRequestService;
import fr.cg95.cvq.service.request.school.ISchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.IHomeFolderService;
import fr.cg95.cvq.util.mail.IMailService;

public final class ConcertoCsvImportService implements ICsvImportProviderService {

    private static Logger logger = Logger.getLogger(ConcertoCsvImportService.class);
    
    private String label;
    
    private Boolean enableSummaryEmail;
    private String[] summaryEmailRecipients;
    
    private byte[] xmlMappingData;
    private byte[] formatterConfigurationData;
    
    private IVoCardRequestService voCardRequestService;
    private ISchoolRegistrationRequestService schoolRegistrationRequestService;
    private ISchoolCanteenRegistrationRequestService schoolCanteenRegistrationRequestService;
    private IPerischoolActivityRegistrationRequestService perischoolActivityRegistrationRequestService;
    private IHomeFolderService homeFolderService;
    private IAuthenticationService authenticationService;
    private IMailService mailService;
    private ISchoolService schoolService;
    
    public void init() {
    	logger.debug("init() loading mapping and formatter configuration data");
    	xmlMappingData = loadStreamData("/csv-mapping.xml");
    	formatterConfigurationData = loadStreamData("/csv-formatter.xml");
    }

    private byte[] loadStreamData(final String path) {

    	InputStream inputStream = getClass().getResourceAsStream(path);
        byte[] inputStreamData = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream(inputStream.available());
            do {
                bytesRead = inputStream.read(inputStreamData);
                if (bytesRead > 0)
                    baos.write(inputStreamData, 0, bytesRead);
            } while (bytesRead > 0);
            
            inputStream.close();
            baos.close();
        } catch (IOException e1) {
            logger.error("Unable to load " + path);
            throw new RuntimeException();
        }

        return baos.toByteArray();
    }
    
	public byte[] getFormatterConfigurationData() {
		return formatterConfigurationData;
	}

	public byte[] getXmlMappingData() {
		return xmlMappingData;
	}

    public void importData(List<Object> parsedLines) throws CvqException {

        logger.debug("importData() Got " + parsedLines.size() + " lines");

        Map<Long, List<ConcertoLine> > homeFoldersData =
            new HashMap<Long, List<ConcertoLine>>();
        
        // go through each parsed CSV line and organize them by concerto ids
        logger.info("importData() Starting CSV data parsing");
        for (Object bean : parsedLines) {
            final ConcertoLine concertoLine = (ConcertoLine) bean;
            if (homeFoldersData.get(concertoLine.getIdConcerto()) != null) {
                List<ConcertoLine> homeFolderLines = 
                    homeFoldersData.get(concertoLine.getIdConcerto());
                logger.debug("importData() Adding line to concerto id " 
                        + concertoLine.getIdConcerto());
                homeFolderLines.add(concertoLine);
            } else {
                logger.debug("importData() Creating line for concerto id " 
                        + concertoLine.getIdConcerto());
                List<ConcertoLine> homeFolderLines = new ArrayList<ConcertoLine>();
                homeFolderLines.add(concertoLine);
                homeFoldersData.put(concertoLine.getIdConcerto(), homeFolderLines);
            }
        }
        
        StringBuffer mailBody = new StringBuffer();
        StringBuffer homeFoldersDetailsBody = new StringBuffer();
        
        logger.info("importData() Starting to import parsed CSV data");
        logger.info("importData() # of different home folders : " + homeFoldersData.size());
        mailBody.append("Nombre de foyers lus dans le fichier d'import : ")
            .append(homeFoldersData.size()).append("\n");
        
        int createdHomeFolders = 0;
        List<Long> rejectedConcertoIds = new ArrayList<Long>();
        for (Long concertoId : homeFoldersData.keySet()) {
            logger.debug("importData() Dealing with concerto id " + concertoId);
            List<ConcertoDataTransfertObject> stackedHomeFolders =
                new ArrayList<ConcertoDataTransfertObject>();
            
            // go through data extracted from CSV file and organize them
            boolean isLineValid = true;
            for (ConcertoLine concertoLine : homeFoldersData.get(concertoId)) {

                // check validity of home folder responsible information
                Adult currentHomeFolderResponsible = concertoLine.getHomeFolderResponsible();
                if (!isValidIndividual(currentHomeFolderResponsible)) {
                    logger.error("importData() Invalid home folder responsible "
                            + "(missing last or first name) "
                            + ", aborting import of line " + concertoId);
                    isLineValid = false;
                    break;
                }

                // set home folder's address if not yet done
                Address currentAddress = concertoLine.getHomeFolderResponsible().getAdress();
                ConcertoDataTransfertObject cdto = 
                    getStackedHomeFolderByAddress(stackedHomeFolders, currentAddress);
                if (cdto == null) {
                    cdto = new ConcertoDataTransfertObject();
                    cdto.setAddress(currentAddress);
                    
                    homeFolderService.addHomeFolderRole(currentHomeFolderResponsible, 
                            null, RoleEnum.HOME_FOLDER_RESPONSIBLE);
                    currentHomeFolderResponsible.setPassword(authenticationService.generatePassword());
                    cdto.setHomeFolderResponsible(currentHomeFolderResponsible);
                    cdto.getAdults().add(currentHomeFolderResponsible);
                    
                    stackedHomeFolders.add(cdto);
                } else {
                    // FIXME : check home folder responsible correct match
                }

                Child child = concertoLine.getChild();
                addLegalResponsibleToChild(child, currentHomeFolderResponsible);
                cdto.getChildren().add(child);
                
                // get or create associated school
                School school = getSchool(concertoLine.getSchoolName());
                
                // queue the child school registration
                SchoolRegistrationRequest srr = concertoLine.getSrr();
                srr.setSubjectId(child.getId());
                srr.setRulesAndRegulationsAcceptance(Boolean.TRUE);
                srr.setSchool(school);
                cdto.getChildrenSchoolRegistrations().add(srr);
                
                // queue the child for upcoming school canteen registration
                if (concertoLine.isRegisteredToSchoolCanteen()) {
                    SchoolCanteenRegistrationRequest scrr = concertoLine.getScrr();
                    scrr.setSubjectId(child.getId());
                    scrr.setHospitalizationPermission(Boolean.TRUE);
                    scrr.setRulesAndRegulationsAcceptance(Boolean.TRUE);
                    scrr.setSchool(school);
                    cdto.getChildrenSchoolCanteenRegistrations().add(scrr);
                }

                // queue the child for upcoming perischool activity registration
                if (concertoLine.isRegisteredToPerischoolActivity()) {
                    PerischoolActivityRegistrationRequest parr = 
                        new PerischoolActivityRegistrationRequest();
                    parr.setSubjectId(child.getId());
                    parr.setHospitalizationPermission(Boolean.TRUE);
                    parr.setRulesAndRegulationsAcceptance(Boolean.TRUE);
                    parr.setChildPhotoExploitationPermission(Boolean.TRUE);
                    parr.setClassTripPermission(Boolean.TRUE);
                    List<LocalReferentialData> perischoolActivities =
                        new ArrayList<LocalReferentialData>();
                    LocalReferentialData lrdEvening = new LocalReferentialData();
                    lrdEvening.setName("EveningNursery");
                    perischoolActivities.add(lrdEvening);
                    LocalReferentialData lrdMorning = new LocalReferentialData();
                    lrdMorning.setName("MorningNursery");
                    perischoolActivities.add(lrdMorning);
                    LocalReferentialData lrdMorningEvening = new LocalReferentialData();
                    lrdMorningEvening.setName("MorningAndEveningNursery");
                    perischoolActivities.add(lrdMorningEvening);
                    parr.setPerischoolActivity(perischoolActivities);

                    cdto.getChildrenPerischoolActivityRegistrations().add(parr);
                }

                Adult otherHomeFolderAdult = concertoLine.getOtherHomeFolderAdult();
                if (!isValidIndividual(otherHomeFolderAdult)) {
                    logger.warn("importData() Invalid or absent other home folder adult "
                            + "(missing last or first name), ignoring it");
                } else {
                    Adult otherHomeFolderAdultCopy =
                        getAdultCopyFromAdults(cdto.getAdults(), otherHomeFolderAdult);
                    if (otherHomeFolderAdultCopy == null) {
                        otherHomeFolderAdult.setPassword(authenticationService.generatePassword());
                        cdto.getAdults().add(otherHomeFolderAdult);
                        addLegalResponsibleToChild(child, otherHomeFolderAdult);
                    } else {
                        addLegalResponsibleToChild(child, otherHomeFolderAdultCopy);
                    }
                }
                
                if (concertoLine.getFamilyQuotient() != null)
                    cdto.setFamilyQuotient(concertoLine.getFamilyQuotient());
            }
            
            if (!isLineValid) {
                logger.warn("importData() Ignoring entry with concerto id : " + concertoId);
                rejectedConcertoIds.add(concertoId);
                continue;
            }
            
            for (ConcertoDataTransfertObject cdto : stackedHomeFolders) {
                
                Adult homeFolderResponsible = cdto.getHomeFolderResponsible();
                
                // keep the clear password for the summary email report
                String clearPassword = homeFolderResponsible.getPassword();

                // create an home folder through account creation request
                VoCardRequest voCardRequest = new VoCardRequest();
                voCardRequestService.create(voCardRequest, cdto.getAdults(), 
                        cdto.getChildren(), cdto.getAddress());
                HomeFolder homeFolder = homeFolderService.getById(voCardRequest.getHomeFolderId());

                // if known, add family quotient information to home folder
                String familyQuotient = cdto.getFamilyQuotient();
                if (familyQuotient != null && !familyQuotient.equals("")) {
                    homeFolder.setFamilyQuotient(familyQuotient);
                    logger.debug("importData() Setting family quotient to " + familyQuotient
                            + " for home folder " + homeFolder.getId());
                    homeFolderService.modify(homeFolder);
                }
                
                // create school registrations
                for (SchoolRegistrationRequest srr : cdto.getChildrenSchoolRegistrations()) {
                    schoolRegistrationRequestService.create(srr, 
                            homeFolderService.getHomeFolderResponsible(homeFolder.getId()).getId(), null);
                    schoolRegistrationRequestService.complete(srr);
                    schoolRegistrationRequestService.validate(srr);
                    logger.debug("importData() created school registration request : " + srr.getId());
                }
                
                // create school canteen registrations
                for (SchoolCanteenRegistrationRequest scrr : cdto.getChildrenSchoolCanteenRegistrations()) {
                    schoolCanteenRegistrationRequestService.create(scrr, 
                            homeFolderService.getHomeFolderResponsible(homeFolder.getId()).getId(), null);
                    logger.debug("importData() created school canteen registration request : " 
                            + scrr.getId());
                }
                
                // create perischool activity registrations
                for (PerischoolActivityRegistrationRequest parr : cdto.getChildrenPerischoolActivityRegistrations()) {
                    perischoolActivityRegistrationRequestService.create(parr, 
                            homeFolderService.getHomeFolderResponsible(homeFolder.getId()).getId(), null);
                    logger.debug("importData() created perischool activity registration request : " 
                            + parr.getId());
                }
                
                createdHomeFolders++;
                
                homeFoldersDetailsBody.append("Foyer : \n")
                    .append("\tIdentifiant Concerto : ").append(concertoId).append("\n")
                    .append("\tIdentitiant CapDémat : ").append(homeFolder.getId()).append("\n")
                    .append("\tResponsable Foyer : ").append(homeFolderResponsible.getFirstName())
                        .append(" ").append(homeFolderResponsible.getLastName()).append("\n")
                    .append("\t\tLogin : ").append(homeFolderResponsible.getLogin()).append("\n")
                    .append("\t\tMot de passe : ").append(clearPassword)
                    .append("\n\n");
            }
        }
        
        logger.info("importData() Created " + createdHomeFolders + " home folders");
        mailBody.append("Nombre de foyers crées : ")
            .append(createdHomeFolders).append("\n");
        mailBody.append("Nombre d'entrées rejetées : ").append(rejectedConcertoIds.size());
        if (rejectedConcertoIds.size() > 0) {
            mailBody.append("\n").append("Détail des entrées rejetées : \n");
            for (Long concertoId : rejectedConcertoIds) {
                mailBody.append("\tConcerto Id : ").append(concertoId).append("\n");
            }
        }
        mailBody.append("\n\n\n");
        
        if (enableSummaryEmail) {
            logger.debug("importData() Gonna send summary email to : ");
            for (String email : summaryEmailRecipients) {
                logger.debug("\t" + email);
                try {
                    mailService.send(null, email, null, "Rapport d'import des données Concerto", 
                            mailBody.toString() + homeFoldersDetailsBody.toString());
                } catch (CvqException e) {
                    logger.error("importData() Unable to send summary email ", e);
                }
            }
        }
    }

    // TODO Better refactor this, to respect Address Normalisation
    private ConcertoDataTransfertObject getStackedHomeFolderByAddress(List<ConcertoDataTransfertObject> stackedHomeFolders, 
            Address address) {

        if (address == null)
            return null;
        
        for (ConcertoDataTransfertObject cdto : stackedHomeFolders) {
            Address cdtoAddress = cdto.getAddress();
            if (cdtoAddress == null)
                return null;
            if (cdtoAddress.getStreetNumber().equals(address.getStreetNumber())
                    && cdtoAddress.getStreetName().equals(address.getStreetName())
                    && cdtoAddress.getPostalCode().equals(address.getPostalCode())) {
                logger.debug("isHomeFolderAlreadyStacked() Address found in stacked home folders");
                return cdto;
            }
        }
        
        return null;
    }

    private boolean isValidIndividual(Individual individual) {
        
        // special case for Poitiers : I.D.E.F is an organism that takes care
        // of children
        if ((individual.getFirstName() == null || individual.getFirstName().equals(""))
                && individual.getLastName().equals("I.D.E.F"))
            return true;
        
        if (individual.getFirstName() == null 
                || individual.getFirstName().trim().length() == 0
                || individual.getLastName() == null
                || individual.getLastName().trim().length() == 0)
            return false;
        
        return true;
    }
    
    private void addLegalResponsibleToChild(Child child, Adult adult) throws CvqException {

        if (adult.getTitle().equals(TitleType.MISTER)) {
            homeFolderService.addIndividualRole(adult, child, RoleEnum.CLR_FATHER);
        } else if (adult.getTitle().equals(TitleType.MADAM)
                || adult.getTitle().equals(TitleType.MISS)) {
            homeFolderService.addIndividualRole(adult, child, RoleEnum.CLR_MOTHER);
        } else {
            homeFolderService.addIndividualRole(adult, child, RoleEnum.CLR_TUTOR);
        }
    }
    
    private Adult getAdultCopyFromAdults(Set<Adult> adults, Adult adult) {
        for (Adult tempAdult : adults) {
            if ((tempAdult.getLastName() != null 
                    && tempAdult.getLastName().equals(adult.getLastName()))
                    && (tempAdult.getFirstName() != null
                            && tempAdult.getFirstName().equals(adult.getFirstName()))) {
                return tempAdult;
            }
        }
        return null;
    }
    
    private School getSchool(final String schoolName) throws CvqException {
    
        School school = schoolService.getByName(schoolName);
        if (school == null) {
            logger.info("getSchool() school " + schoolName + " not found, creating it");
            school = new School();
            school.setActive(true);
            school.setName(schoolName);
            schoolService.create(school);
        }
        
        return school;
    }
    
    private class ConcertoDataTransfertObject {
        
        private Set<Child> children = new HashSet<Child>();
        private Set<Adult> adults = new HashSet<Adult>();
        private Set<SchoolCanteenRegistrationRequest> childrenSchoolCanteenRegistrations = 
            new HashSet<SchoolCanteenRegistrationRequest>();
        private Set<SchoolRegistrationRequest> childrenSchoolRegistrations =
            new HashSet<SchoolRegistrationRequest>();
        private Set<PerischoolActivityRegistrationRequest> childrenPerischoolActivityRegistrations =
            new HashSet<PerischoolActivityRegistrationRequest>();
        private Address address = null;
        private String familyQuotient = null;
        private Adult homeFolderResponsible = null;
        
        public ConcertoDataTransfertObject() {
        }
        
        public final Address getAddress() {
            return address;
        }
        
        public final void setAddress(Address address) {
            this.address = address;
        }
        
        public final Set<Adult> getAdults() {
            return adults;
        }
        
        public final void setAdults(Set<Adult> adults) {
            this.adults = adults;
        }
        
        public final Set<Child> getChildren() {
            return children;
        }
        
        public final void setChildren(Set<Child> children) {
            this.children = children;
        }
        
        public final Set<SchoolCanteenRegistrationRequest> getChildrenSchoolCanteenRegistrations() {
            return childrenSchoolCanteenRegistrations;
        }
        
        public final void setChildrenSchoolCanteenRegistrations(
                Set<SchoolCanteenRegistrationRequest> childrenSchoolCanteenRegistrations) {
            this.childrenSchoolCanteenRegistrations = childrenSchoolCanteenRegistrations;
        }
        
        public final Set<SchoolRegistrationRequest> getChildrenSchoolRegistrations() {
            return childrenSchoolRegistrations;
        }
        
        public final void setChildrenSchoolRegistrations(
                Set<SchoolRegistrationRequest> childrenSchoolRegistrations) {
            this.childrenSchoolRegistrations = childrenSchoolRegistrations;
        }
        
        public final String getFamilyQuotient() {
            return familyQuotient;
        }
        
        public final void setFamilyQuotient(String familyQuotient) {
            this.familyQuotient = familyQuotient;
        }
        
        public final Adult getHomeFolderResponsible() {
            return homeFolderResponsible;
        }
        
        public final void setHomeFolderResponsible(Adult homeFolderResponsible) {
            this.homeFolderResponsible = homeFolderResponsible;
        }

        public Set<PerischoolActivityRegistrationRequest> getChildrenPerischoolActivityRegistrations() {
            return childrenPerischoolActivityRegistrations;
        }

        public void setChildrenPerischoolActivityRegistrations(
                Set<PerischoolActivityRegistrationRequest> perischoolActivityRegistrations) {
            this.childrenPerischoolActivityRegistrations = perischoolActivityRegistrations;
        }
    }
    
    public final String getLabel() {
        return label;
    }

    public final void setLabel(String label) {
        this.label = label;
    }

    public final void setVoCardRequestService(IVoCardRequestService voCardRequestService) {
        this.voCardRequestService = voCardRequestService;
    }

    public final void setHomeFolderService(IHomeFolderService homeFolderService) {
        this.homeFolderService = homeFolderService;
    }

    public final void setSchoolCanteenRegistrationRequestService(
            ISchoolCanteenRegistrationRequestService schoolCanteenRegistrationRequestService) {
        this.schoolCanteenRegistrationRequestService = schoolCanteenRegistrationRequestService;
    }

    public final void setSchoolRegistrationRequestService(
            ISchoolRegistrationRequestService schoolRegistrationRequestService) {
        this.schoolRegistrationRequestService = schoolRegistrationRequestService;
    }

    public final void setAuthenticationService(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public final void setMailService(IMailService mailService) {
        this.mailService = mailService;
    }

    public final void setEnableSummaryEmail(Boolean enableSummaryEmail) {
        this.enableSummaryEmail = enableSummaryEmail;
    }

    public final void setSummaryEmailRecipients(String[] summaryEmailRecipients) {
        this.summaryEmailRecipients = summaryEmailRecipients;
    }

    public void setSchoolService(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    public void setPerischoolActivityRegistrationRequestService(
            IPerischoolActivityRegistrationRequestService perischoolActivityRegistrationRequestService) {
        this.perischoolActivityRegistrationRequestService = perischoolActivityRegistrationRequestService;
    }
}

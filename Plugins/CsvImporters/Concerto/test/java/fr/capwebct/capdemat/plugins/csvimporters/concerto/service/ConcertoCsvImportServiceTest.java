package fr.capwebct.capdemat.plugins.csvimporters.concerto.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.SchoolCanteenRegistrationRequest;
import fr.cg95.cvq.business.request.school.SchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.SectionType;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.importer.ICsvParserService;
import fr.cg95.cvq.service.request.RequestTestCase;
import fr.cg95.cvq.util.Critere;

public class ConcertoCsvImportServiceTest extends RequestTestCase {

    private ByteArrayOutputStream loadData(String path) throws CvqException {

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
            fail("Unable to load resource : " + path);
            throw new CvqException();
        }
        
        return baos;
    }
    
    public void testConcertoImport() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        try {
            ByteArrayOutputStream csvBaos = loadData("/data/export_inscrits.csv");
            
            ICsvParserService csvParserService =
                super.<ICsvParserService>getApplicationBean("cvsParserService");
            
            csvParserService.parseData("Concerto", csvBaos.toByteArray());
            
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
    }
    
    public void testTwoChildrenSimpleHomeFolder() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        try {
            ByteArrayOutputStream csvBaos = loadData("/data/two_children_simple_home_folder.csv");
            
            ICsvParserService csvParserService =
                super.<ICsvParserService>getApplicationBean("cvsParserService");
            
            csvParserService.parseData("Concerto", csvBaos.toByteArray());
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
        }
        
        List<HomeFolder> allHomeFolders = homeFolderService.getAll(true, true);
        assertEquals(allHomeFolders.size(), 1);
        
        HomeFolder homeFolder = allHomeFolders.iterator().next();
        assertNotNull(homeFolder);
        assertNotNull(homeFolder.getFamilyQuotient());
        assertTrue(homeFolder.getFamilyQuotient().contains("013,09"));
        
        Adult homeFolderResponsible = 
            homeFolderService.getHomeFolderResponsible(homeFolder.getId());
        assertNotNull(homeFolderResponsible);
        assertEquals(homeFolderResponsible.getLastName(), "KAFKA");
        assertEquals(homeFolderResponsible.getFirstName(), "Julie");
        assertEquals(homeFolderResponsible.getHomePhone(), "0606060606");
        assertEquals(homeFolderResponsible.getTitle().toString(), "Madam");
        
        Address address = homeFolder.getAddress();
        assertEquals(address.getPostalCode(), "75012");
        assertEquals(address.getCity(), "PARIS");
        // TODO Better refactor this, to respect Address Normalisation
        assertEquals(address.getStreetName(), "12 RUE DE COTTE");
        
        List<Child> children = homeFolderService.getChildren(homeFolder.getId());
        assertEquals(children.size(), 2);
        for (Child child : children) {
            assertEquals(child.getLastName(), "KAFKA");

            if (child.getFirstName().equals("Franz")) {
                assertEquals(child.getSex(), SexType.MALE);
                Calendar now = GregorianCalendar.getInstance();
                now.setTime(child.getBirthDate());
                assertEquals(now.get(Calendar.YEAR), 2001);
                assertEquals(now.get(Calendar.MONTH), 10);
                assertEquals(now.get(Calendar.DAY_OF_MONTH), 18);
            } else if (child.getFirstName().equals("Elli")) {
                assertEquals(child.getSex(), SexType.FEMALE);
                Calendar now = GregorianCalendar.getInstance();
                now.setTime(child.getBirthDate());
                assertEquals(now.get(Calendar.YEAR), 1998);
                assertEquals(now.get(Calendar.MONTH), 6);
                assertEquals(now.get(Calendar.DAY_OF_MONTH), 15);
            } else {
                fail("Found a child with an unexpected first name");
            }

            Set<Critere> criteriaSet = new HashSet<Critere>(1);
            criteriaSet.add(
                new Critere(Request.SEARCH_BY_SUBJECT_ID, child.getId(), Critere.EQUALS));
            List<Request> childRequests =
                requestSearchService.get(criteriaSet, null, null, 0, 0, true);
            assertEquals(2, childRequests.size());
            for (Request request : childRequests) {
                if (request instanceof SchoolRegistrationRequest) {
                    SchoolRegistrationRequest srr = (SchoolRegistrationRequest) request;
                    if (child.getFirstName().equals("Franz"))
                        assertEquals(srr.getSection(), SectionType.THIRD_SECTION);
                    else
                        assertEquals(srr.getSection(), SectionType.CE2);
                } else if (request instanceof SchoolCanteenRegistrationRequest) {
                    
                } else {
                    fail("Child has an unexpected request registration");
                }
            }
        }
        
        SecurityContext.resetCurrentSite();
    }
}

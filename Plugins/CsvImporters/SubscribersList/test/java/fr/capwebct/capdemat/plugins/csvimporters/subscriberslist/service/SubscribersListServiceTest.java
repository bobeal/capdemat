package fr.capwebct.capdemat.plugins.csvimporters.subscriberslist.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.importer.ICsvParserService;
import fr.cg95.cvq.testtool.ServiceTestCase;

public class SubscribersListServiceTest extends ServiceTestCase {

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
    
    public void testListImport() throws Exception {
        SecurityContext.setCurrentSite(localAuthorityName, SecurityContext.BACK_OFFICE_CONTEXT);
        SecurityContext.setCurrentAgent(agentNameWithCategoriesRoles);
        
        try {
            ByteArrayOutputStream csvBaos = loadData("/data/ListeAbonnesNumeroSlt.csv");
            
            ICsvParserService csvParserService =
                super.<ICsvParserService>getApplicationBean("cvsParserService");
            
            csvParserService.parseData("SubscribersList", csvBaos.toByteArray());
            
            SecurityContext.resetCurrentSite();
        } catch (Exception e) {
            throw new CvqException(e.getMessage());
         }
    }
}

package fr.capwebct.capdemat.plugins.csvimporters.subscriberslist.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import fr.capwebct.capdemat.plugins.csvimporters.subscriberslist.business.SubscriberLine;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.importer.ICsvImportProviderService;
import fr.cg95.cvq.service.request.IRequestService;

public class SubscribersListService  implements ICsvImportProviderService {

    private static Logger logger = Logger.getLogger(SubscribersListService.class);
    
    private String label;
    
    private byte[] xmlMappingData;
    private byte[] formatterConfigurationData;

    private ILocalAuthorityRegistry localAuthorityRegistry;
    private IRequestService placeReservationRequestService;
    
    public void init() {
        logger.debug("init() loading mapping and formatter configuration data");
        xmlMappingData = loadStreamData("/csv-mapping-subscriberslist.xml");
        formatterConfigurationData = loadStreamData("/csv-formatter-subscriberslist.xml");
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public byte[] getXmlMappingData() {
        return xmlMappingData;
    }

    public void importData(List<Object> parsedLines) throws CvqException {
        logger.debug("importData() Got " + parsedLines.size() + " lines");

        String filename = placeReservationRequestService.getExternalReferentialFilename();
        logger.debug("importData() Gonna write in " + filename);
        File file = localAuthorityRegistry.getCurrentLocalAuthorityResource(
                ILocalAuthorityRegistry.EXTERNAL_REFERENTIAL_RESOURCE_TYPE, 
                filename, false);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioe) {
                logger.error("importData() Error while creating " + file + ", giving up");
                throw new CvqException();
            }
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // impossible since we just created it
        }
        for (Object bean : parsedLines) {
            final SubscriberLine subscriberLine = (SubscriberLine) bean;
            logger.debug("importData() Got data : " + subscriberLine.getIdSubscriber()
                    + " / " + subscriberLine.getFullPriceSubscriber() 
                    + " / " + subscriberLine.getReducedPriceSubscriber());
            try {
                fos.write((subscriberLine.getIdSubscriber().trim() + "," 
                        + subscriberLine.getFullPriceSubscriber() + ","
                        + subscriberLine.getReducedPriceSubscriber()
                        + "\n").getBytes());
            } catch (IOException e) {
                logger.error("importData() Error while writing CSV data to referential file");
                throw new CvqException();
            }
        }
        
        try {
            fos.flush();
            fos.close();
        } catch (IOException e) {
            logger.error("importData() Error while writing CSV data to referential file");
            throw new CvqException();
        }
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }

    public void setPlaceReservationRequestService(IRequestService placeReservationRequestService) {
        this.placeReservationRequestService = placeReservationRequestService;
    }

}

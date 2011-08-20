package fr.cg95.cvq.util.admin;

import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type;
import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.dao.request.xml.LocalReferentialXml;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqLocalReferentialException;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialDocument.LocalReferential;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialDocument.LocalReferential.Data;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialDocument.LocalReferential.Data.Label;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialEntryType;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialEntryType.Entry;
import fr.cg95.cvq.schema.oldreferential.LocalReferentialEntryType.Entry.Message;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.service.request.IRequestService;
import fr.cg95.cvq.service.request.IRequestServiceRegistry;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Migration helper toward the new xml format of local referantials.
 * @author julien
 */
public class LocalReferentialTransformer {
    
    private static final Logger logger = Logger.getLogger(LocalReferentialImporter.class);
    
    private ILocalAuthorityRegistry laRegistry;
    private IRequestServiceRegistry rsRegistry;

    private LocalReferentialTransformer(ILocalAuthorityRegistry laRegistry, IRequestServiceRegistry rsRegistry) {
        this.laRegistry = laRegistry;
        this.rsRegistry = rsRegistry;
    }
    
    private void modelToXml(Set<LocalReferentialType> lr, File file) {
        try {
            LocalReferentialXml.modelToXml(lr, file);
        } catch (CvqException ex) {
            logger.error("Unable to write in file: " + file.getAbsolutePath(), ex);
        }
    }
    
    public void migrate() {
        logger.info(" ~ Starting local referentials migration");
        String siteName = SecurityContext.getCurrentSite().getName();
        for (IRequestService service : rsRegistry.getAllRequestServices()) {
            String serviceFileName = service.getLocalReferentialFilename();
            if (serviceFileName != null) {
                logger.info("Migrating " + service.getLabel() + " local referential…");
                File file = laRegistry.getLocalAuthorityResourceFileForLocalAuthority(siteName, Type.LOCAL_REFERENTIAL, serviceFileName, false);
                
                if (file == null) {
                    logger.warn("No existing local referential for " + service.getLabel() + ", going to the next");
                    continue;
                }

                // Parse the old XML file
                Set<LocalReferentialType> lr = LocalReferentialOldXml.oldXmlToModel(file);
                
                if (lr != null) {
                    // Serialize the local referential in the new format
                    modelToXml(lr, file);
                }
            }
        }
        logger.info(" ~ Ok, local referential migration is done");
    }
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpxa = SpringApplicationContextLoader.loadContext(null);
        ILocalAuthorityRegistry laRegistry = (ILocalAuthorityRegistry)cpxa.getBean("localAuthorityRegistry");
        IRequestServiceRegistry rsRegistry = (IRequestServiceRegistry)cpxa.getBean(IRequestServiceRegistry.class);
        laRegistry.browseAndCallback(new LocalReferentialTransformer(laRegistry, rsRegistry), "migrate", null);
        System.exit(0);
    }
    
    private static class LocalReferentialOldXml {
        
        /**
         * @param lretXml
         * @param lrt
         * @param lre
         * @return True if at least one of the tree level was set to support multiples choices
         */
        private static boolean parseXmlEntries(LocalReferentialEntryType lretXml, LocalReferentialType lrt,
                LocalReferentialEntry lre) {
            
            boolean multiple = lretXml.getSupportMultiple();

            for (Entry entry : lretXml.getEntryArray()) {

                LocalReferentialEntry tempLre = new LocalReferentialEntry();
                tempLre.setKey(entry.getKey());

                // set label
                if (entry.sizeOfLabelArray() > 0) {
                    for (Entry.Label label : entry.getLabelArray()) {
                        if ("fr".equals(label.getLang())) {
                            tempLre.setLabel(label.getStringValue());
                        }
                    }
                }
                
                // set message
                if (entry.sizeOfMessageArray() > 0) {
                    for (Message message : entry.getMessageArray()) {
                        if ("fr".equals(message.getLang())) {
                            tempLre.setMessage(message.getStringValue());
                        }
                    }
                }

                // set children entries
                if (entry.isSetEntries()) {
                    LocalReferentialEntryType innerLretXml = entry.getEntries();
                    multiple = parseXmlEntries(innerLretXml, lrt, tempLre) || multiple;
                }
                try {
                    lrt.addEntry(tempLre, lre);
                } catch (CvqLocalReferentialException ex) {
                    // This should not happen
                }
            }
            
            return multiple;
        }

        /**
         * Transform a local referential data type from an XML Beans object
         * to a Model object
         * @throws CvqLocalReferentialException 
         */
        public static LocalReferentialType oldXmlToModel(final Data refData) {

            LocalReferentialType lrt = new LocalReferentialType();
            
            lrt.setName(refData.getName());

            for (Label label : refData.getLabelArray()) {
                if ("fr".equals(label.getLang())) {
                    lrt.setLabel(label.getStringValue());
                }
            }

            if (refData.getEntries() != null) {
                LocalReferentialEntryType lret = refData.getEntries();
                boolean multiple = parseXmlEntries(lret, lrt, null);

                lrt.setMultiple(multiple);
            }

            return lrt;
        }
        
        public static Set<LocalReferentialType> oldXmlToModel(File file) {
            try {
                Set<LocalReferentialType> lrts = new LinkedHashSet<LocalReferentialType>();
                // Parse the old xml file
                fr.cg95.cvq.schema.oldreferential.LocalReferentialDocument lrd =
                        fr.cg95.cvq.schema.oldreferential.LocalReferentialDocument.Factory.parse(file);
                LocalReferential lr = lrd.getLocalReferential();
                if (lr != null && lr.sizeOfDataArray() > 0) {
                    for (Data data : lr.getDataArray()) {
                        lrts.add(oldXmlToModel(data));
                    }

                    return lrts;
                }
            } catch (XmlException ex) {
                logger.error("Unable to parse XML file: " + file.getAbsolutePath());
            } catch (IOException ex) {
                logger.error("Unable to read file: " + file.getAbsolutePath());
            }
            return null;
        }
    }
}

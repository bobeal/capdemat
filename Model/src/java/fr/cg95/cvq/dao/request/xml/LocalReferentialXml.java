package fr.cg95.cvq.dao.request.xml;

import fr.cg95.cvq.business.request.LocalReferentialEntry;
import fr.cg95.cvq.business.request.LocalReferentialType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqLocalReferentialException;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential;
import fr.cg95.cvq.schema.referential.LocalReferentialDocument.LocalReferential.Data;
import fr.cg95.cvq.schema.referential.LocalReferentialEntryType;
import fr.cg95.cvq.schema.referential.LocalReferentialEntryType.Entry;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;

/**
 * Helper for serialization deserialization of local referentials
 * @author julien
 */
public class LocalReferentialXml {
    
    private static Logger logger = Logger.getLogger(LocalReferentialXml.class);
    
    /**
     * Serialize a whole local referential in a file
     * @param lr
     * @param file
     * @throws CvqException 
     */
    public static void modelToXml(final Set<LocalReferentialType> lrts, File file) throws CvqException {
        final LocalReferentialDocument refDoc = LocalReferentialDocument.Factory.newInstance();
        final LocalReferential lr = refDoc.addNewLocalReferential();
        
        Data[] datas = new Data[lrts.size()];
        int i = 0;
        for (LocalReferentialType lrt : lrts) {
            datas[i] = modelToXml(lrt);
            i++;
        }
        
        lr.setDataArray(datas);
        
        saveXml(refDoc, file);
    }
    
    /**
     * Serialize a single local referential type in a file
     * This operation will try to replace an existing local referential type with
     * the same name in the given file.
     * @param lrt
     * @param file
     * @throws CvqException 
     */
    public static void modelToXml(final LocalReferentialType lrt, File file) throws CvqException {
        final LocalReferentialDocument refDoc = getLocalReferentialDocument(file);
        
        // Retrieve the index of the LocalReferentialType
        final LocalReferential lr = refDoc.getLocalReferential();
        int dataIndex = -1;
        if (lr != null) {
            int i = 0;
            for (Data data : lr.getDataArray()) {
                if (data.getName().equals(lrt.getName())) {
                    dataIndex = i;
                    break;
                }
                i++;
            }
        }

        refDoc.getLocalReferential().setDataArray(dataIndex, modelToXml(lrt));
        
        saveXml(refDoc, file);
    }

    private static void saveXml(LocalReferentialDocument refDoc, File file) throws CvqException {
        // Set up the validation error listener.
        ArrayList<Object> validationErrors = new ArrayList<Object>();
        XmlOptions validationOptions = new XmlOptions();
        validationOptions.setErrorListener(validationErrors);
        if (!refDoc.validate(validationOptions)) {
            for (Object object : validationErrors) {
                logger.error("setLocalReferentialData() Validation error : " + object);
            }
            throw new CvqLocalReferentialException();
        }

        try {
            XmlOptions opts = new XmlOptions();
            opts.setSavePrettyPrint();
            opts.setSavePrettyPrintIndent(4);
            opts.setUseDefaultNamespace();
            opts.setCharacterEncoding("UTF-8");
            refDoc.save(file, opts);
        } catch (IOException xe) {
            logger.error("setLocalReferentialData() error while saving referential data file");
            xe.printStackTrace();
            throw new CvqException("error while saving referential data file");
        }
    }
    
    private static void parseModelEntry(LocalReferentialEntry lre, LocalReferentialEntryType lretXml) {

        logger.debug("parseModelEntries() for LRE : " + lre);

        Entry entry = lretXml.addNewEntry();

        entry.setKey(lre.getKey());

        // set label
        entry.setLabel(lre.getLabel());

        // set message
        if (lre.getMessage() != null) {
            entry.setMessage(lre.getMessage());
        }

        // set children entries
        if (!lre.getEntries().isEmpty()) {
            LocalReferentialEntryType innerLretXml = entry.addNewEntries();
            for (LocalReferentialEntry innerLre : lre.getEntries()) {
                parseModelEntry(innerLre, innerLretXml);
            }
        }
    }

    private static Data modelToXml(final LocalReferentialType lrt) {

        Data data = Data.Factory.newInstance();
        data.setName(lrt.getName());
        
        data.setLabel(lrt.getLabel());
        
        data.setAllowMultipleChoices(lrt.isMultiple());

        if (!lrt.getEntries().isEmpty()) {
            LocalReferentialEntryType lret = data.addNewEntries();

            for (LocalReferentialEntry lre : lrt.getEntries()) {
                parseModelEntry(lre, lret);
            }
        }

        return data;
    }
    
    public static Set<LocalReferentialType> xmlToModel(final File file) throws CvqException {
        final Set<LocalReferentialType> lrts = new LinkedHashSet<LocalReferentialType>();
        
        final LocalReferential lr = getLocalReferentialDocument(file).getLocalReferential();
        
        if (lr != null) {
            for (Data data : lr.getDataArray()) {
                lrts.add(xmlToModel(data));
            }
        }
        
        return lrts;
    }

    private static LocalReferentialDocument getLocalReferentialDocument(final File file) throws CvqException {
        try {
            logger.debug("getLocalReferentialDocument("+file.getCanonicalPath()+")");
            return LocalReferentialDocument.Factory.parse(file);
        } catch (XmlException ex) {
            throw new CvqException("Unable to parse the file");
        } catch (IOException ex) {
            throw new CvqException("Unable to write the file");
        }
    }
    
    /**
     * Transform a local referential data type from an XML Beans object
     * to a Model object
     */
    private static LocalReferentialType xmlToModel(final Data refData) {

        logger.debug("xmlToModel()");

        LocalReferentialType lrt = new LocalReferentialType();
        
        lrt.setName(refData.getName());

        lrt.setLabel(refData.getLabel());
        
        lrt.setMultiple(refData.getAllowMultipleChoices());

        if (refData.getEntries() != null) {
            logger.debug("xmlToModel() parsing data entries");
            LocalReferentialEntryType lret = refData.getEntries();
            xmlEntriesToModel(lret, lrt, null);
        }

        return lrt;
    }
    
    private static void xmlEntriesToModel(final LocalReferentialEntryType lretXml, final LocalReferentialType lrt,
            LocalReferentialEntry parentLre) {

        logger.debug("parseXmlEntries()");

        for (Entry entry : lretXml.getEntryArray()) {

            LocalReferentialEntry tempLre = new LocalReferentialEntry();
            tempLre.setKey(entry.getKey());
            
            // set label
            tempLre.setLabel(entry.getLabel());

            // set message
            if (entry.isSetMessage()) {
                tempLre.setMessage(entry.getMessage());
            }

            // set children entries
            if (entry.isSetEntries()) {
                xmlEntriesToModel(entry.getEntries(), lrt, tempLre);
            }
            
            try {
                lrt.addEntry(tempLre, parentLre);
            } catch (CvqLocalReferentialException ex) {
                // Why would this happen?
            }
        }
    }
}

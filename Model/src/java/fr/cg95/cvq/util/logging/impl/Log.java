package fr.cg95.cvq.util.logging.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import au.com.bytecode.opencsv.CSVWriter;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.authority.ILocalAuthorityLifecycleAware;
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry;
import fr.cg95.cvq.util.logging.ILog;

public class Log implements ILog, ILocalAuthorityLifecycleAware {

    private ILocalAuthorityRegistry localAuthorityRegistry;
    
    private static String assetBase;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private void initLogger(String localAuthorityName) {
        Logger logger = Logger.getLogger(localAuthorityName);
        String logFileName = assetBase + SecurityContext.getCurrentSite().getName()
                + "/log/business.log";
        try {
            logger.addAppender(new FileAppender(new PatternLayout("%d %-5p - %m%n"), logFileName));
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger logger (String localAuthorityName) {
        return Logger.getLogger(localAuthorityName);
    }

    @Override
    public void addLocalAuthority(String localAuthorityName) {
        if (assetBase == null)
            assetBase = localAuthorityRegistry.getAssetsBase();
        initLogger(localAuthorityName);
    }

    public static void adultToCsV (Adult adult) {
        try {
            SecurityContext.getCurrentSite().getName();
            String homeFolderFile =  assetBase + SecurityContext.getCurrentSite().getName()
                    + "/log/homeFolder-" + dateFormat.format(new Date()) + ".csv";

            CSVWriter writer = new CSVWriter(new FileWriter(homeFolderFile, true));

            List<String> line = new ArrayList<String>();
            line.add(adult.getTitle().name());
            line.add(adult.getLastName());
            line.add(adult.getFirstName());
            line.add(adult.getEmail());
            line.add(adult.getHomePhone());
            line.add(adult.getMobilePhone());
            line.add(adult.getOfficePhone());
            line.add(adult.getAddress().getAdditionalDeliveryInformation());
            line.add(adult.getAddress().getAdditionalGeographicalInformation());
            line.add(adult.getAddress().getStreetNumber());
            line.add(adult.getAddress().getStreetName());
            line.add(adult.getAddress().getPlaceNameOrService());
            line.add(adult.getAddress().getPostalCode());
            line.add(adult.getAddress().getCity());
            line.add(adult.getAddress().getCountryName());
            line.add(adult.getQuestion());
            line.add(adult.getAnswer());

            writer.writeNext(line.toArray(new String[]{}));
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeLocalAuthority(String localAuthorityName) {
    }

    public void setLocalAuthorityRegistry(ILocalAuthorityRegistry localAuthorityRegistry) {
        this.localAuthorityRegistry = localAuthorityRegistry;
    }
}

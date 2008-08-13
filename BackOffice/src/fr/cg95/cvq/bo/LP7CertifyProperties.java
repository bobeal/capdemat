package fr.cg95.cvq.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.Security;
import java.util.Properties;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import fr.cg95.cvq.bo.dispatcher.DispatchFilter;

public class LP7CertifyProperties {

    // URL of the TSA for any client
    private String tsaClientUrl;

    // Appellation server signature
    private String appellationSignatureFile;

    private String appellationSignaturePassword;

    // Transaction server signature
    private String transactionSignatureFile;

    private String transactionSignaturePassword;

    // Appellation server signature production place
    private String appellationSppCountryName;

    private String appellationSppCity;

    private String appellationSppPostalCode;

    private String appellationSppStateOrProvince;

    // URL of the TSA for appellation server signature
    private String tsaServerUrl;

    // Name of the PKCS#11 library used by LP7Certify applet
    private String lp7CertifyPkcs11Library;

    // JCE provider
    private Provider jceProvider;

    public LP7CertifyProperties() {
        super();
    }
    
    public static boolean isConfigured() {
        File propertiesFile = getPropertiesFile();
        return propertiesFile.exists();
    }

    public void init(String site) {
        // Load properties file
        Properties properties = new Properties();
        try {
            File propertiesFile = getPropertiesFile();
            properties.load(new FileInputStream(propertiesFile));
        } catch (IOException exception) {
            System.out.println("FATAL ERROR: Cannot load configuration file: " + exception);
            return;
        }

        // Load the JCE provider
        try {
            jceProvider = new BouncyCastleProvider();
            Security.addProvider(jceProvider);
        } catch (Throwable exception) {
            jceProvider = null;
            exception.printStackTrace();
        }

        // Appellation signature file
        appellationSignatureFile = properties.getProperty("appellation.signature.file.path");

        // Appellation signature password
        appellationSignaturePassword = properties.getProperty("appellation.signature.password");
        if (appellationSignaturePassword == null) {
            // Empty password
            appellationSignaturePassword = "";
        }

        // Appellation signature production place
        appellationSppCountryName = properties.getProperty("appellation.spp.country.name");
        appellationSppCity = properties.getProperty("appellation.spp.city");
        appellationSppPostalCode = properties.getProperty("appellation.spp.postal.code");
        appellationSppStateOrProvince = properties.getProperty("appellation.spp.state.or.province");

        // Transaction signature file
        transactionSignatureFile = properties.getProperty("transaction.signature.file.path");

        // Transaction signature password
        transactionSignaturePassword = properties.getProperty("transaction.signature.password");
        if (transactionSignaturePassword == null) {
            // Empty password
            transactionSignaturePassword = "";
        }

        // TSA server url
        tsaServerUrl = properties.getProperty("tsa.server.url");

        // TSA client url
        tsaClientUrl = properties.getProperty("tsa.client.url");
        
        //
        lp7CertifyPkcs11Library = properties.getProperty("lp7.certify.pkcs11.library");
    }
    
    private static File getPropertiesFile() {
        return DispatchFilter.getAssetsBaseFile("lp7/lp7certify.properties");
    }

    public String getAppellationSignatureFile() {
        return appellationSignatureFile;
    }

    public void setAppellationSignatureFile(String appellationSignatureFile) {
        this.appellationSignatureFile = appellationSignatureFile;
    }

    public String getAppellationSignaturePassword() {
        return appellationSignaturePassword;
    }

    public void setAppellationSignaturePassword(String appellationSignaturePassword) {
        this.appellationSignaturePassword = appellationSignaturePassword;
    }

    public String getAppellationSppCity() {
        return appellationSppCity;
    }

    public void setAppellationSppCity(String appellationSppCity) {
        this.appellationSppCity = appellationSppCity;
    }

    public String getAppellationSppCountryName() {
        return appellationSppCountryName;
    }

    public void setAppellationSppCountryName(String appellationSppCountryName) {
        this.appellationSppCountryName = appellationSppCountryName;
    }

    public String getAppellationSppPostalCode() {
        return appellationSppPostalCode;
    }

    public void setAppellationSppPostalCode(String appellationSppPostalCode) {
        this.appellationSppPostalCode = appellationSppPostalCode;
    }

    public String getAppellationSppStateOrProvince() {
        return appellationSppStateOrProvince;
    }

    public void setAppellationSppStateOrProvince(String appellationSppStateOrProvince) {
        this.appellationSppStateOrProvince = appellationSppStateOrProvince;
    }

    public Provider getJceProvider() {
        return jceProvider;
    }

    public void setJceProvider(Provider jceProvider) {
        this.jceProvider = jceProvider;
    }

    public String getLp7CertifyPkcs11Library() {
        return lp7CertifyPkcs11Library;
    }

    public void setLp7CertifyPkcs11Library(String lp7CertifyPkcs11Library) {
        this.lp7CertifyPkcs11Library = lp7CertifyPkcs11Library;
    }

    public String getTransactionSignatureFile() {
        return transactionSignatureFile;
    }

    public void setTransactionSignatureFile(String transactionSignatureFile) {
        this.transactionSignatureFile = transactionSignatureFile;
    }

    public String getTransactionSignaturePassword() {
        return transactionSignaturePassword;
    }

    public void setTransactionSignaturePassword(String transactionSignaturePassword) {
        this.transactionSignaturePassword = transactionSignaturePassword;
    }

    public String getTsaClientUrl() {
        return tsaClientUrl;
    }

    public void setTsaClientUrl(String tsaClientUrl) {
        this.tsaClientUrl = tsaClientUrl;
    }

    public String getTsaServerUrl() {
        return tsaServerUrl;
    }

    public void setTsaServerUrl(String tsaServerUrl) {
        this.tsaServerUrl = tsaServerUrl;
    }

}

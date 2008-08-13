package fr.cg95.cvq.bo.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Vector;

/**
 * General class for handling signature and certificate.
 *
 * @author Julien PASQUIER
 */
public class CertificateManager
{
    private X509Certificate cert;
    private Certificate[] certChain;
    private PrivateKey privateKey;

    /**
     * Constructs a signature manager.
     */
    public CertificateManager()
    {
        cert = null;
        certChain = null;
        privateKey = null;
    }

    /**
     * Returns the certificate.
     */
    public X509Certificate getCertificate()
    {
        if (certChain != null)
        {
            return (X509Certificate) certChain[0];
        }
        else
        {
            return cert;
        }
    }

    /**
     * Returns the privatekey.
     */
    public PrivateKey getPrivateKey()
    {
        return privateKey;
    }

    /**
     * Returns the publickey.
     */
    public PublicKey getPublicKey()
    {
        return cert.getPublicKey();
    }

    /**
     * Returns the certificates path (including user certificate).
     */
    public Certificate[] getAllCertificates()
    {
        if (certChain != null)
        {
            return certChain;
        }
        else
        {
            return new Certificate[]{cert};
        }
    }


    /**
     * Load a pkcs#12 file and extract its content.
     *
     * @param fileName name of the pkcs#12 file
     * @param password password of the signature (private key)
     */
    public void loadFromPkcs12File(
        String fileName,
        char[] password)
        throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyStoreException,
            CertificateException, UnrecoverableKeyException
    {
        loadFromPkcs12File(fileName, password, null);
    }

    /**
     * Load a pkcs#12 file and extract its content.
     *
     * @param fileName name of the pkcs#12 file
     * @param password password of the signature (private key)
     * @param provider PKCS#12 provider
     */
    public void loadFromPkcs12File(
        String fileName,
        char[] password,
        Provider provider)
        throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyStoreException,
            CertificateException, UnrecoverableKeyException
    {
        loadFromPkcs12Stream(new FileInputStream(fileName), password, provider);
    }

    /**
     * Load PKCS#12 stream with the default provider.
     * @param inputStream
     * @param password
     */
    public void loadFromPkcs12Stream(
        InputStream inputStream,
        char[] password)
        throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyStoreException,
            CertificateException, UnrecoverableKeyException
    {
        loadFromPkcs12Stream(inputStream, password, null);
    }

    /**
     * Load a PKCS#12 stream.
     * @param inputStream
     * @param password
     * @param provider
     */
    public void loadFromPkcs12Stream(
        InputStream inputStream,
        char[] password,
        Provider provider)
        throws NoSuchAlgorithmException, NoSuchProviderException, IOException, KeyStoreException,
            CertificateException, UnrecoverableKeyException
    {
        // Load a pkcs#12 file into a KeyStore object
        KeyStore keyStore;
        if (provider == null)
        {
            keyStore = KeyStore.getInstance("PKCS12");
        }
        else
        {
            keyStore = KeyStore.getInstance("PKCS12", provider.getName());
        }
        keyStore.load(inputStream, password);

        // Get the KeyStore object elements (certificates, private key and publickey)
        Enumeration enumeration = keyStore.aliases();
        String alias = "";
        Vector vectorAliases = new Vector();

        while (enumeration.hasMoreElements()) {
            vectorAliases.add(enumeration.nextElement());
        }

        String[] aliases = (String []) (vectorAliases.toArray(new String[0]));
        for (int i = 0; i < aliases.length; i++) {
            if (keyStore.isKeyEntry(aliases[i])) {
                alias = aliases[i];
                break;
            }
        }

        certChain = keyStore.getCertificateChain(alias);
        if (certChain == null)
        {
            cert = (X509Certificate)keyStore.getCertificate(alias);
        }
        else
        {
            cert = null;
        }
        privateKey = (PrivateKey)keyStore.getKey(alias, password);
    }


    /**
     * Load a X509 certificate file and extract its content.
     *
     * @param fileName name of the x509 certificate file
     */
    public void loadFromCertificateFile(String fileName)
        throws FileNotFoundException,CertificateException, IOException
    {
        loadFromCertificateFile(fileName, null);
    }

    public void loadFromCertificateFile(String fileName, Provider provider)
        throws FileNotFoundException,CertificateException, IOException
    {
        InputStream inStream = new FileInputStream(fileName);
        CertificateFactory cf = null;
        if (provider == null)
        {
            cf = CertificateFactory.getInstance("X.509");
        }
        else
        {
            cf = CertificateFactory.getInstance("X.509", provider);
        }

        cert = (X509Certificate)cf.generateCertificate(inStream);
        inStream.close();
    }
}
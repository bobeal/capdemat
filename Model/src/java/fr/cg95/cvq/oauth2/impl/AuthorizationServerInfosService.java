package fr.cg95.cvq.oauth2.impl;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

import fr.cg95.cvq.oauth2.IAuthorizationServerInfosService;

public class AuthorizationServerInfosService implements IAuthorizationServerInfosService {

    private PublicKey publicKey;
    private String authorizationUri;
    private String tokenUri;
    private String logoutUri;

    public AuthorizationServerInfosService(String publicKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
       KeyFactory keyFactory = KeyFactory.getInstance("RSA");
       byte [] key = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
       this.publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(key));
    }

    @Override
    public PublicKey getPublicKey() {
        return publicKey;
    }

    @Override
    public String getAuthorizationUri() {
        return authorizationUri;
    }

    public void setAuthorizationUri(String authorizationUri) {
        this.authorizationUri = authorizationUri;
    }

    @Override
    public String getTokenUri() {
        return tokenUri;
    }

    public void setTokenUri(String tokenUri) {
        this.tokenUri = tokenUri;
    }

    @Override
    public String getLogoutUri() {
        return logoutUri;
    }

    public void setLogoutUri(String logoutUri) {
        this.logoutUri = logoutUri;
    }

}

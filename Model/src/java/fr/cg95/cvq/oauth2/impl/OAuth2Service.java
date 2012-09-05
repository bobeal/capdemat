package fr.cg95.cvq.oauth2.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.UserState;
import fr.cg95.cvq.dao.users.IAdultDAO;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.oauth2.IAuthorizationServerInfosService;
import fr.cg95.cvq.oauth2.IOAuth2Service;
import fr.cg95.cvq.oauth2.InvalidTokenException;
import fr.cg95.cvq.oauth2.model.AccessToken;
import fr.cg95.cvq.oauth2.model.Token;
import fr.cg95.cvq.util.JSONUtils;
import fr.cg95.cvq.util.web.WS;
import fr.cg95.cvq.util.web.WS.HttpResponse;

public class OAuth2Service implements IOAuth2Service {

    private static final Logger logger = Logger.getLogger(OAuth2Service.class);
    private IAuthorizationServerInfosService authorizationServerInfos;
    private IAdultDAO adultDAO;
    private String resourceServerName;
    private String clientId;
    private String password;
    private String redirectionUri;
    private String identificationScope;

    @Override
    public Adult authenticate(String token) throws CvqModelException,
        CvqUnknownUserException, CvqAuthenticationFailedException, CvqDisabledAccountException {
        AccessToken accessToken;
        try {
           accessToken = valide(token);
        } catch (InvalidTokenException e) {
            logger.info("Authentication error : invalid token.", e);
            throw new CvqAuthenticationFailedException("Authentication error : invalid token.");
        }

        Adult adult = adultDAO.findByLogin(accessToken.getResourceOwnerName());
        if (adult == null)
            throw new CvqUnknownUserException();
        HomeFolder homeFolder = adult.getHomeFolder();
        if (homeFolder == null)
            throw new CvqModelException("authenticate() : no home folder bound to individual " + adult.getId());
        if (homeFolder.getState().equals(UserState.ARCHIVED)) {
            logger.warn("authenticate() user belongs to an archived account");
            throw new CvqUnknownUserException();
        }
        if (!homeFolder.getEnabled()) {
            logger.warn("authenticate() user belongs to a disabled account");
            throw new CvqDisabledAccountException();
        }
        if (UserState.ARCHIVED.equals(adult.getState())) {
            logger.warn("authenticate() user is archived");
            throw new CvqUnknownUserException();
        }
        return adult;
    }

    @Override
    public AccessToken valide(String token) throws InvalidTokenException {
        try {
            String jsonToken = new String(verify(Base64.decodeBase64(token.getBytes("UTF-8"))));
            JsonObject json = JSONUtils.deserialize(jsonToken);
            AccessToken accessToken = new AccessToken(
                json.get("server_name").getAsString(),
                json.get("owner_name").getAsString(),
                json.get("scope").getAsString(),
                json.get("expiration").getAsLong());
            if (!accessToken.isValid(resourceServerName)) {
                throw new InvalidTokenException();
            }
            return accessToken;
        } catch (Exception e) {
            logger.info("Invalid access token.", e);
            throw new InvalidTokenException();
        }
    }

    private byte[] verify(byte[] token)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, authorizationServerInfos.getPublicKey());
        return cipher.doFinal(token);
    }

    @Override
    public String authorizationRequestUri(String state) {
        String redirectUri = null;
        String stateParam = null;
        try {
            redirectUri = URLEncoder.encode(redirectionUri, "UTF-8");
            stateParam = (state != null) ? URLEncoder.encode(state, "UTF-8") : "";
        } catch (UnsupportedEncodingException e) {
            logger.error("Encoding redirectUri error.", e);
            return null;
        }
        return authorizationServerInfos.getAuthorizationUri() +
                "?response_type=code&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=" + identificationScope +
                "&state=" + stateParam;
    }

    @Override
    public Token authorizationCodeGrant(String code) {
        String auth = null;
        try {
            auth = new String(Base64.encodeBase64((clientId + ":" + password).getBytes("UTF-8")), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Encoding authentification error.", e);
            return null;
        }

        HttpResponse response = WS.url(authorizationServerInfos.getTokenUri())
            .setHeader("Content-Type", "application/x-www-form-urlencoded")
            .setHeader("Authorization", "Basic " + auth)
            .body("grant_type=authorization_code&code="+ code +
                  "&redirect_uri=" + redirectionUri +
                  "&resource_server=" + resourceServerName)
            .post();

        if (logger.isDebugEnabled()) {
            logger.debug("Token response status : " + response.getStatus());
        }

        if (response.getStatus() == 200) {
            JsonObject json = JSONUtils.deserialize(response.getString());
            return new Token(
                    json.get("access_token").getAsString(),
                    json.get("token_type").getAsString(),
                    json.get("expires_in").getAsInt(),
                    json.get("scope").getAsString(),
                    json.get("refresh_token").getAsString());
        }
        return null;
    }

    public void setResourceServerName(String resourceServerName) {
        this.resourceServerName = resourceServerName;
    }

    public void setAdultDAO(IAdultDAO adultDAO) {
        this.adultDAO = adultDAO;
    }

    public void setAuthorizationServerInfos(IAuthorizationServerInfosService authorizationServerInfos) {
        this.authorizationServerInfos = authorizationServerInfos;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRedirectionUri(String redirectionUri) {
        this.redirectionUri = redirectionUri;
    }

    public void setIdentificationScope(String identificationScope) {
        this.identificationScope = identificationScope;
    }

}

package fr.cg95.cvq.oauth2;

import java.security.PublicKey;

public interface IAuthorizationServerInfosService {

    PublicKey getPublicKey();

    String getAuthorizationUri();

    String getTokenUri();

    String getLogoutUri();

}

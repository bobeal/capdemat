package fr.cg95.cvq.oauth2;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.exception.CvqAuthenticationFailedException;
import fr.cg95.cvq.exception.CvqDisabledAccountException;
import fr.cg95.cvq.exception.CvqModelException;
import fr.cg95.cvq.exception.CvqUnknownUserException;
import fr.cg95.cvq.oauth2.model.AccessToken;
import fr.cg95.cvq.oauth2.model.Token;

public interface IOAuth2Service {

    Adult authenticate(String token) throws CvqModelException, CvqUnknownUserException,
        CvqAuthenticationFailedException, CvqDisabledAccountException;

    AccessToken valide(String token) throws InvalidTokenException;

    String authorizationRequestUri(String state);

    Token authorizationCodeGrant(String code);
}

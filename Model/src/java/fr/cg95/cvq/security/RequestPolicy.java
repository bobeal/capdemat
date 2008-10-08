package fr.cg95.cvq.security;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.Category;
import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestAction;
import fr.cg95.cvq.business.request.RequestNote;

public class RequestPolicy implements PartOfPolicy {

    private static Logger logger =  Logger.getLogger(RequestPolicy.class);

    public boolean isReadAllowed(CredentialBean user, ObjectBean object) {

        Request request = getRequestFromBean(object);
        if (request == null) {
            logger.warn("isReadAllowed() No request in object bean !");
            return false;
        }

        if (user.isBoContext() || (user.isFoContext() && user.getAgent() != null)) {
            // we are called by the Back Office

            // FIXME : what da hack !!
            if (user.getExternalService() != null) {
                logger.debug("called by an external service, bypassing checks");
                return true;
            }
            
            Category category = request.getRequestType().getCategory();
            // in case this request type is not yet associated to a category
            if (category == null) {
                logger.warn("isReadAllowed() request type " + request.getRequestType()
                        + " is not associated to a category, denying read access to request");
                return false;
            }

            CategoryProfile categoryProfile = user.getProfileForCategory(category);
            if (categoryProfile == null)
                return false;
            if (categoryProfile.equals(CategoryProfile.READ_ONLY)
                    || categoryProfile.equals(CategoryProfile.READ_WRITE)
                    || categoryProfile.equals(CategoryProfile.MANAGER))
                return true;
            
        } else if (user.isFoContext()) {
            // we are called by the Front Office

            // only give read access to adults from the same home folder
            if (user.belongsToSameHomeFolder(request))
                return true;
        }

        return false;
    }

    public boolean isWriteAllowed(CredentialBean user, ObjectBean object) {

        Request request = getRequestFromBean(object);
        if (request == null) {
            logger.warn("isWriteAllowed() No request in object bean !");
            return false;
        }

        // an agent can issue a request on behalf of an e-citizen
        if (user.isBoContext() || (user.isFoContext() && user.getAgent() != null)) {
            // we are called by the Back Office

            Category category = request.getRequestType().getCategory();
            // in case this request type is not yet associated to a category
            if (category == null) {
                logger.warn("isWriteAllowed() request type " + request.getRequestType()
                        + " is not associated to a category, denying write access to request");
                return false;
            }

            CategoryProfile categoryProfile = user.getProfileForCategory(category);
            if (categoryProfile == null)
                return false;
            if (categoryProfile.equals(CategoryProfile.READ_WRITE))
                return true;

        } else if (user.isFoContext()){
            // we are called by the Front Office

            // request notes modifications are not permitted to FO users
            if (object.getObject() instanceof RequestNote) {
                logger.debug("isReadAllowed() request notes are not permitted to FO users");
                return false;
            }

            // authorize VO Card requests creations without control
            // since users can't already be authenticated
            // FIXME : add a CREATE privilege since we can't know here if it's
            // a creation (authorized) or modification (authorized upon some
            // restrictions)
            // FIXME : we can't do it since unauthenticated access is denied
            // by CVQ policy
//          if (request instanceof VOCardRequest) {
//              logger.debug("isReadAllowed() VO card request : user is authorized without access control check");
//              return true;
//          }

            // only give write access to adults from the same home folder
            if (user.belongsToSameHomeFolder(request))
                return true;
        }

        return false;
    }

    /** There is no admin control rights for requests */
    public boolean isAdminAllowed(CredentialBean user, ObjectBean object) {
        logger.warn("isAdminAllowed() should not come here !");
        return false;
    }

    public boolean isManageAllowed(CredentialBean user, ObjectBean object) {

        Request request = getRequestFromBean(object);
        if (request == null) {
            logger.warn("isManageAllowed() No request in object bean !");
            return false;
        }

        if (user.isBoContext()) {

            Category category = request.getRequestType().getCategory();
            // in case this request type is not yet associated to a category
            if (category == null) {
                logger.warn("isManageAllowed() request type " + request.getRequestType()
                        + " is not associated to a category, denying manage access to request");
                return false;
            }

            CategoryProfile categoryProfile = user.getProfileForCategory(category);
            if (categoryProfile == null)
                return false;
            if (categoryProfile.equals(CategoryProfile.MANAGER))
                return true;
        } 
        
        return false;
    }

    protected Request getRequestFromBean(ObjectBean object) {
        Request request = null;
        if (object.getObject() instanceof Request) {
            request = (Request) object.getObject();
        } else if (object.getObject() instanceof RequestNote) {
            RequestNote rn = (RequestNote) object.getObject();
            request = rn.getRequest();
        } else if (object.getObject() instanceof RequestAction) {
            RequestAction ra = (RequestAction) object.getObject();
            request = ra.getRequest();
        }

        return request;
    }
}

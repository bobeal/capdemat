package fr.cg95.cvq.security;

import org.apache.log4j.Logger;

import fr.cg95.cvq.business.authority.CategoryProfile;
import fr.cg95.cvq.business.authority.CategoryRoles;
import fr.cg95.cvq.business.authority.SiteProfile;
import fr.cg95.cvq.business.authority.SiteRoles;
import fr.cg95.cvq.business.document.Document;

public class DocumentPolicy implements PartOfPolicy {

    private static Logger logger =  Logger.getLogger(DocumentPolicy.class);

    public boolean isReadAllowed(CredentialBean user, ObjectBean object) {

        if (user.isBoContext()) {

            // if user has an agent profile on the site, it can see documents
            SiteRoles[] siteRoles = user.getSiteRoles();
            for (SiteRoles siteRole : siteRoles) {
                if (siteRole.getProfile().equals(SiteProfile.AGENT))
                    return true;
            }

            return false;
        } else {
            // we are called by the Front Office

            Document document = getDocumentFromBean(object);
            if (document == null) {
                logger.warn("isReadAllowed() No document in object bean !");
                return false;
            }

            // only give read access to adults from the same home folder
            if (user.belongsToSameHomeFolder(document))
                return true;
        }

        return false;
    }

    public boolean isWriteAllowed(CredentialBean user, ObjectBean object) {
        if (user.isBoContext()) {

            // if user has at least a WRITE profile on one category on the site
            // give it write access to document
            CategoryRoles[] categoryRoles = user.getCategoryRoles();
            for (int i = 0; i < categoryRoles.length; i++) {
                CategoryRoles sr = categoryRoles[i];
                if (sr.getProfile().equals(CategoryProfile.READ_WRITE)) {
                    return true;
                }
            }

            return false;
        } else {

            Document document = getDocumentFromBean(object);
            if (document == null) {
                logger.warn("isWriteAllowed() No document in object bean !");
                return false;
            }

            // only give read access to adults from the same home folder
            if (user.belongsToSameHomeFolder(document))
                return true;
        }

        return false;
    }

    /** There is no admin control rights for requests */
    public boolean isAdminAllowed(CredentialBean user, ObjectBean object) {
        logger.warn("isAdminAllowed() should not come here !");
        return false;
    }

    /** There is no manage control rights for requests */
    public boolean isManageAllowed(CredentialBean user, ObjectBean object) {
        logger.warn("isManageAllowed() should not come here !");
        return false;
    }

    protected Document getDocumentFromBean(ObjectBean object) {
        Document document = null;
        if (object.getObject() instanceof Document) {
            logger.debug("getDocumentFromBean() Document object");
            document = (Document) object.getObject();
        } 

        return document;
    }
}

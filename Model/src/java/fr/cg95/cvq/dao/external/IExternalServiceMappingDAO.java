package fr.cg95.cvq.dao.external;

import java.util.List;

import fr.cg95.cvq.business.external.ExternalServiceIdentifierMapping;
import fr.cg95.cvq.dao.IGenericDAO;

/**
 * @author jsb@zenexity.fr
 */
public interface IExternalServiceMappingDAO extends IGenericDAO {

    ExternalServiceIdentifierMapping
        getIdentifierMapping(String externalServiceLabel, Long homeFolderId);

    List<ExternalServiceIdentifierMapping>
        getIdentifierMappings(Long homeFolderId);
}

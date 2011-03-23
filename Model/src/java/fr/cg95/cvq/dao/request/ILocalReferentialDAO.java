package fr.cg95.cvq.dao.request;

import fr.cg95.cvq.business.request.LocalReferentialType;
import java.util.Set;

/**
 * @author julien
 */
public interface ILocalReferentialDAO {
    
    Set<LocalReferentialType> listByRequestType(String requestTypeLabel);
    
    LocalReferentialType getByRequestTypeAndName(String requestTypeLabel, String typeName);
    
    void save(String requestTypeLabel, LocalReferentialType lrt);
}

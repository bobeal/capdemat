package fr.capwebct.modules.payment.service;

import java.util.List;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.business.ExternalImportAudit;
import fr.capwebct.modules.payment.security.CpmSecurityException;

public interface IAuditService {

    void addAuditTrace(final String importType, final ExternalDataType externalDataType,
            final String externalApplicationLabel)
        throws CpmSecurityException;
    
    List<ExternalImportAudit> getAllAuditTraces();
}

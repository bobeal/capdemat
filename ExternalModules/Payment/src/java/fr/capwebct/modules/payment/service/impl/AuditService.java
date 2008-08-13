package fr.capwebct.modules.payment.service.impl;

import java.util.Date;
import java.util.List;

import fr.capwebct.modules.payment.business.ExternalDataType;
import fr.capwebct.modules.payment.business.ExternalImportAudit;
import fr.capwebct.modules.payment.dao.IExternalImportAuditDAO;
import fr.capwebct.modules.payment.security.CpmSecurityException;
import fr.capwebct.modules.payment.security.SecurityContext;
import fr.capwebct.modules.payment.service.IAuditService;

public class AuditService implements IAuditService {

    private IExternalImportAuditDAO externalImportAuditDAO;
    
    public void addAuditTrace(final String importType,
            final ExternalDataType externalDataType, final String externalApplicationLabel)
        throws CpmSecurityException {
        
        ExternalImportAudit externalImportAudit = new ExternalImportAudit();
        externalImportAudit.setAgent(SecurityContext.getCurrentAgent());
        externalImportAudit.setDate(new Date());
        externalImportAudit.setExternalApplicationLabel(externalApplicationLabel);
        externalImportAudit.setExternalDataType(externalDataType);
        externalImportAudit.setImportType("CSV");
        externalImportAuditDAO.create(externalImportAudit);
    }

    public List<ExternalImportAudit> getAllAuditTraces() {
        return externalImportAuditDAO.findAll();
    }

    public void setExternalImportAuditDAO(IExternalImportAuditDAO externalImportAuditDAO) {
        this.externalImportAuditDAO = externalImportAuditDAO;
    }
}

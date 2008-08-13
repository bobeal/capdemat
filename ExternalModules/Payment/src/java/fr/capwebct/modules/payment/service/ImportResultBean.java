package fr.capwebct.modules.payment.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImportResultBean {

    private boolean successful = true;
    private String failMessage;
    private String successMessage;
    
    private Long importedLines;
    
    private Map<String, Set<String>> failedImports = new HashMap<String, Set<String>>();
    private Set<String> createdEfa = new HashSet<String>();

    public Map<String, Set<String>> getFailedImports() {
        return failedImports;
    }

    public void addFailedImport(String message, String recordId) {
        if (failedImports.get(message) == null)
            failedImports.put(message, new HashSet<String>());
        
        failedImports.get(message).add(recordId);
    }
    
    public Long getImportedLines() {
        return importedLines;
    }

    public void setImportedLines(Long importedLines) {
        this.importedLines = importedLines;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public Set<String> getCreatedEfa() {
        return createdEfa;
    }

    public void setCreatedEfa(Set<String> createdEfa) {
        this.createdEfa = createdEfa;
    }
  
    public void addCreatedEfa(String efaId) {
        this.createdEfa.add(efaId);
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}

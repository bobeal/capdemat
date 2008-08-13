package fr.cg95.cvq.wizard;

public interface IProcessWizard {
    public static final String PROCESS_NAME = "fr.cg95.cvq.wizard.processName";
    
    public String getName();
    public String getTitle();
    public String getPersistence();
    public String getTime();
    public String getInformationLabel();
    public String getInformationFile();
}

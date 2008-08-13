package fr.cg95.cvq.bo.record;


import java.util.HashMap;

import javax.servlet.jsp.PageContext;

public class AccountRecord implements IResultRecord {

    private String externalLabel;
    private String lastName;
    private String firstName;
    
    private DisplayColumn accountColumns[] =
    {
        new DisplayColumn("lastName", "Nom", false, null),
        new DisplayColumn("firstName", "Prénom", false, null),
        new DisplayColumn("externalLabel", "Label", false, null)};

    public AccountRecord() {
        super();
    }

    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        return accountColumns;
    }

    public String getNavigateAction(PageContext pageContext) {
        return null;
    }

    public Long getResultId() {
        return null;
    }
    
    public void load() {
    }

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

    public String getExternalLabel() {
        return externalLabel;
    }

    public void setExternalLabel(String externalLabel) {
        this.externalLabel = externalLabel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

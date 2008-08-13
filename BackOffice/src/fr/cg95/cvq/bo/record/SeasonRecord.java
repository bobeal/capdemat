package fr.cg95.cvq.bo.record;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.jsp.PageContext;

public class SeasonRecord implements IResultRecord {

    private String uuid;
    private String label;
    private Date startDate;
    private Date endDate;
    private Date startInscription;
    private Date endInscription;
    private Date validationDate;
    
    private DisplayColumn seasonColumns[] =
    {
            new DisplayColumn("label", "Libellé pour la saison", false, null),
            new DisplayColumn("startDate", "Début saison", false, null),
            new DisplayColumn("endDate", "Fin saison", false, null),
            new DisplayColumn("startInscription", "Début inscription", false, null),
            new DisplayColumn("endInscription", "Fin inscription", false, null),
            new DisplayColumn("validationDate", "Date de validation", false, null)};

    public SeasonRecord() {
        super();
    }

    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        return seasonColumns;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndInscription() {
        return endInscription;
    }

    public void setEndInscription(Date endInscription) {
        this.endInscription = endInscription;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartInscription() {
        return startInscription;
    }

    public void setStartInscription(Date startInscription) {
        this.startInscription = startInscription;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}

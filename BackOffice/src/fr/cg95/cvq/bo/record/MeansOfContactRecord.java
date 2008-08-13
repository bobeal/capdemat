package fr.cg95.cvq.bo.record;


import java.util.HashMap;

import javax.servlet.jsp.PageContext;

import fr.cg95.cvq.business.users.MeansOfContactEnum;

public class MeansOfContactRecord implements IResultRecord {

    private Long id = null;
    private MeansOfContactEnum type = null;
    private String label = null;
    private boolean enabled = false;
    
    private DisplayColumn meansOfContactColumns[] =
    {
            new DisplayColumn("label", "Moyen de contact", false, null),
            new DisplayColumn("enabled", "Activé", "check", false, null)};

    public MeansOfContactRecord() {
        super();
    }

    public void reset() {
        enabled = false;
    }
    
    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        return meansOfContactColumns;
    }

    public String getNavigateAction(PageContext pageContext) {
        return null;
    }

    public Long getResultId() {
        return id;
    }
    
    public void load() {
    }

    public void loadPage(HashMap<Long,IResultRecord> results) {
    }

    public boolean isLoaded() {
        return false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MeansOfContactEnum getType() {
        return type;
    }

    public void setType(MeansOfContactEnum type) {
        this.type = type;
    }

}

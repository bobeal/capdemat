package fr.cg95.cvq.bo.record;


import java.util.HashMap;

import javax.servlet.jsp.PageContext;

public class DocumentTypeRecord implements IResultRecord {

	private static final long serialVersionUID = -7864051088647088495L;
	
	private Long id = null;
    private Integer type = null;
    private String name = null;
    private String label = null;
    private boolean used = false;
    
    private DisplayColumn documentTypeColumns[] =
    {
            new DisplayColumn("label", "Nature du justificatif", false, null),
            new DisplayColumn("used", "A fournir", "check", false, null)};

    public DocumentTypeRecord() {
        super();
    }

    public void reset() {
        used = false;
    }
    
    public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
        return documentTypeColumns;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}

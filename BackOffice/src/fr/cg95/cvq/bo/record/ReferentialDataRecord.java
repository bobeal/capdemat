package fr.cg95.cvq.bo.record;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.PageContext;

public class ReferentialDataRecord implements IResultRecord {

	private static final long serialVersionUID = -5228135441002200676L;

	private String key = null;
	private Map values = null;
	
	private DisplayColumn referentialColumns[] =
	{
		new DisplayColumn("key", "Clé", false, null),
		new DisplayColumn("label", "Libellé", false, null)};

	public ReferentialDataRecord() {
		super();
	}

	public ReferentialDataRecord(String key, Map values) {
		super();
		this.key = key;
		this.values = values;
	}

	public boolean equals(Object obj) {
        if (this.key == null)
            return false;
        
		if ((obj != null) && (obj instanceof ReferentialDataRecord))
			return this.key.equals(((ReferentialDataRecord)obj).getKey());

		return super.equals(obj);
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

	public String getKey() {
		return key;
	}
	
	public String getLabel() {
		return (String)values.get("fr");
	}
	
	public void setLabel(String label) {
		values.put("fr",label);
	}

	public Map getValues() {
		return values;
	}
	
	public DisplayColumn[] getDisplayColumns(PageContext pageContext, String type) {
		return referentialColumns;
	}

	public String getNavigateAction(PageContext pageContext) {
		return null;
	}

}

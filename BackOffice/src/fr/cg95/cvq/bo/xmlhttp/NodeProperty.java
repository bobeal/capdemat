package fr.cg95.cvq.bo.xmlhttp;

public class NodeProperty {

    private String key = null;
    private String value = null;
    private String type = null;
    
    public NodeProperty(String key, String value, String type) {
        super();
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String write() {
        String tag = "<property key=\"" + key + "\" value=\"" + value + "\" type=\"" + type + "\"/>";
        return tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

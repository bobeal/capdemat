package fr.cg95.cvq.bo.xmlhttp;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeNode {

    private int type = 0;
    private String id = null;
    private String label = null;
    private boolean expand = false;
    private boolean removed = false;
    private TreeNode parent = null;
    
    private Object data = null;
    
    private HashMap<String,TreeNode> search = new HashMap<String,TreeNode>();
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
    private ArrayList<NodeProperty> properties = new ArrayList<NodeProperty>();
    
    public TreeNode(TreeNode parent, int type, String id, String label, Object data) {
        super();
        this.type = type;
        this.parent = parent;
        this.id = id;
        this.label = label;
        this.data = data;
    }

    public String write() {
        return write("node");
    }
    
    public String write(String tagName) {
        String tag = "<" + tagName + " label=\"" + label + "\" id=\"" + id + "\" type=\"" + type + "\"";
        
        if (expand)
            tag += " expand=\"true\"";

        tag += ">";
        
        for (int i = 0; i < properties.size(); i++)
            tag += properties.get(i).write();

        for (int i = 0; i < children.size(); i++)
            tag += children.get(i).write();

        return tag + "</" + tagName + ">";
    }

    public int nbChildren() {
        return children.size();
    }
    
    public TreeNode getChild(int index) {
        return children.get(index);
    }
    
    public TreeNode addChild(TreeNode child) {
        children.add(child);
        search.put(child.getId(), child);
        return child;
    }
    
    public TreeNode setChild(String id, String label, int type, boolean remove) {
        TreeNode child = search.get(id);
        if (child != null) {
            if (remove) {
                search.remove(id);
                children.remove(child);
            } else {
                child.setLabel(label);
            }
            child.setRemoved(remove);
            return child;
        }
        return addChild(new TreeNode(this, type, id, label, null));
    }
    
    public void addProperty(NodeProperty property) {
        properties.add(property);
    }
    
    public void setProperty(String key, String value, String type) {
        for (int i = 0; i < properties.size(); i++) {
            NodeProperty nodeProperty = properties.get(i); 
            if (nodeProperty.getKey().equals(key)) {
                nodeProperty.setValue(value);
                return;
            }
        }
        addProperty(new NodeProperty(key, value, type));
    }

    public String getProperty(String key) {
        for (int i = 0; i < properties.size(); i++) {
            NodeProperty nodeProperty = properties.get(i); 
            if (nodeProperty.getKey().equals(key)) {
                return nodeProperty.getValue();
            }
        }
        return "";
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

}

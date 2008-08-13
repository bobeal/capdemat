// Class DataNode

    function DataNode(parentNode) {
    	this.id = "";
    	this.type = "";
    	this.text = "";
		this.ancestors = "";
		this.treeNode = null;
    	this.parentNode = parentNode;
        this.properties = new Array();
		this.children = new Array();
		this.index = null;
		this.treeIndex = null;
		this.remove = false;
		
		if ((parentNode != null) && (parentNode.id != "")) {
			if (parentNode.ancestors == "")
				this.ancestors = parentNode.text;
			else
				this.ancestors = parentNode.ancestors + " - " + parentNode.text;
		}
    }
    
    DataNode.prototype.addTreeNode = function(treeNode) {
		if ((this.parentNode != null) && (this.parentNode.getTreeNode() != null)) {
			this.parentNode.getTreeNode().addItem(treeNode);
		}
    	this.treeNode = treeNode;	
    }
    
    DataNode.prototype.getTreeNode = function() {
    	return this.treeNode;
    }
    
    DataNode.prototype.addProperty = function(nodeProperty) {
        var newIndex = this.properties.length;
        this.properties[newIndex] = nodeProperty;
        
        return this.properties[newIndex];
    }
    
    DataNode.prototype.getProperty = function(key) {
        for (var i = 0; i < this.properties.length; i++) {
            if (this.properties[i].key == key)
                return this.properties[i];
        }
        return null;
    }
    
    DataNode.prototype.setProperty = function(key, value) {
        for (var i = 0; i < this.properties.length; i++) {
            if (this.properties[i].key == key)
                this.properties[i].value = (value != null) ? value : "";
        }
        if (key == 'key') {
        	if (value != null) {
        		value = value.replace(/ /g,"_");
	        	this.id = value;
        	}
        } else if (key == 'label') {
        	this.text = value;
        	this.treeNode.title = value;
        }
    }
    
    DataNode.prototype.addChild = function(child) {
        var newIndex = this.children.length;
        this.children[newIndex] = child;
        child.index = newIndex;
        
        return this.children[newIndex];
    }
    
    DataNode.prototype.removeChild = function(child) {
		child.remove = true;
//		this.children[child.index] = null;
    }
    
    DataNode.prototype.nbChildren = function() {
    	var count = 0;
    	
    	for (var i = 0; i < this.children.length; i++)
    		if (!this.children[i].remove)
    			count++
    	
    	return count;	
    }
    
    DataNode.prototype.removeBranch = function(child) {
		this.getTreeNode().removeItem(child.getTreeNode());
    }

    DataNode.prototype.write = function(tagName) {
    	if (tagName == null)
    		tagName = "node";

        var tag = "<" + tagName + " label=\"" + this.text + "\" id=\"" + this.id;
        
        if (this.remove) {
        	tag += "\" remove=\"true\">";

        } else {
	        tag += "\">";
	        
	    	for (var i = 0; i < this.properties.length; i++)
	            tag += this.properties[i].write();
	
	        for (var i = 0; i < this.children.length; i++)
				if (this.children[i] != null)
		            tag += this.children[i].write();
		}	
        return tag + "</" + tagName + ">";
    }
    
    DataNode.prototype.writeParent = function(childTag) {
		var tagName = "node";
		if (this.parentNode == null)
	   		tagName = "tree";

		if (childTag != null) {
	        var tag = "<" + tagName + " label=\"" + this.text + "\" id=\"" + this.id + "\">";
	        
		    tag += childTag;
	
	        tag += "</" + tagName + ">";
		}
	    else 
			tag = this.write();
				    	
		if (this.parentNode != null)
			return this.parentNode.writeParent(tag);
			
		return tag;
    }
    
    function NodeProperty(key, value, type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

	NodeProperty.prototype.write = function() {
		var value = this.value;
		if (value == "&nbsp;")
			value = "";

        var tag = "<property key=\"" + this.key + "\" value=\"" + value + "\" type=\"" + this.type + "\"/>";
        return tag;
	}
//    
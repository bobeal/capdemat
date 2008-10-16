import java.beans.PropertyEditorSupport

class PersistentStringEnumEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        def qualifiedEnumString = text.tokenize("_")
        this.value = Class.forName(qualifiedEnumString[0]).forString(qualifiedEnumString[1])
    }
    
}

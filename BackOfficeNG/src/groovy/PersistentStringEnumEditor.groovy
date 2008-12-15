import java.beans.PropertyEditorSupport

class PersistentStringEnumEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        def qualifiedEnumString = text.tokenize("_")
        if (qualifiedEnumString[0] != null && qualifiedEnumString[0] != '')
            this.value = Class.forName(qualifiedEnumString[0]).forString(qualifiedEnumString[1])
        else
            this.value = null
    }
}

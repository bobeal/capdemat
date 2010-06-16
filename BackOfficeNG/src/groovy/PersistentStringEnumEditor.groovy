import java.beans.PropertyEditorSupport

class PersistentStringEnumEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        def qualifiedEnumString = text.tokenize('_')
        def qualifiedClassName = qualifiedEnumString.remove(0)
        def valueAsText = qualifiedEnumString.join('_')
        if (qualifiedClassName != null && qualifiedClassName != '')
            this.value = Class.forName(qualifiedClassName).forString(valueAsText)
        else
            this.value = null
    }
}

import java.beans.PropertyEditorSupport

class StringEditor extends PropertyEditorSupport {

    PropertyEditorSupport editor

    public void setAsText(String text) {
        editor.setAsText(text)
        this.value = editor.value == null || editor.value.trim().isEmpty() ? null : editor.value
    }
}

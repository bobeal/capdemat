import java.beans.PropertyEditorSupport

import org.joda.time.DateMidnight

class DateMidnightEditor extends PropertyEditorSupport {

    PropertyEditorSupport dateEditor

    public void setAsText(String text) {
        dateEditor.setAsText(text)
        this.value = new DateMidnight(dateEditor.value)
    }
}
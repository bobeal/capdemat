import org.codehaus.groovy.grails.web.binding.StructuredPropertyEditor
import java.beans.PropertyEditorSupport

import org.joda.time.LocalTime
import java.util.Map
import java.util.List

class LocalTimeEditor extends PropertyEditorSupport implements  StructuredPropertyEditor {

    public List getOptionalFields() {
        return []
    }

    public List getRequiredFields() {
        return ['hour','minute']
    }

    public Object assemble(Class type, Map fieldValues) throws IllegalArgumentException {
        for (String fieldName : getRequiredFields())
            if (!fieldValues.containsKey(fieldName))
                throw new IllegalArgumentException("_" + fieldName + "key is required")

        if (type == LocalTime.class)
            return new LocalTime(Integer.valueOf(fieldValues['hour']), Integer.valueOf(fieldValues['minute']))
        else
           throw new IllegalArgumentException( LocalTime.class + "is required")
    }
}

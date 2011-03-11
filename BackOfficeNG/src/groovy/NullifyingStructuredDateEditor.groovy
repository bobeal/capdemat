import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.grails.web.binding.StructuredDateEditor

class NullifyingStructuredDateEditor extends StructuredDateEditor {

    public NullifyingStructuredDateEditor(dateFormat) {
        super(dateFormat, true)
    }

    public Object assemble(Class type, Map fieldValues)
        throws IllegalArgumentException {
        def nonEmptyValues = [:]
        fieldValues.each {
            if (!StringUtils.isBlank(it.value)) nonEmptyValues[it.key] = it.value
        }
        return super.assemble(type, nonEmptyValues)
    }
}

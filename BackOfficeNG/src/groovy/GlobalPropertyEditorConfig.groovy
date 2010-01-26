import java.text.DateFormat

import org.codehaus.groovy.grails.web.binding.GrailsDataBinder
import org.codehaus.groovy.grails.web.binding.StructuredDateEditor
import org.joda.time.DateMidnight
import org.springframework.web.servlet.support.RequestContextUtils

import fr.cg95.cvq.dao.hibernate.PersistentStringEnum

class GlobalPropertyEditorConfig {
    static newDataBinder = { request, object ->
        def binder = GrailsDataBinder.createBinder(object, GrailsDataBinder.DEFAULT_OBJECT_NAME, request)
        registerCustomEditors(request, binder)
        return binder
    }

    private static void registerCustomEditors(request, binder) {
        binder.registerCustomEditor(PersistentStringEnum.class, new PersistentStringEnumEditor())
        def dateEditor = new StructuredDateEditor(
            DateFormat.getDateInstance(DateFormat.SHORT, RequestContextUtils.getLocale(request)),
            true)
        binder.registerCustomEditor(Date.class, dateEditor)
        binder.registerCustomEditor(Calendar.class, dateEditor)
        binder.registerCustomEditor(DateMidnight.class,
            new DateMidnightEditor(dateEditor : dateEditor))
    }
}

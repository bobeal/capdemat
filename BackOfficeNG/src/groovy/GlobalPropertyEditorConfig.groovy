import org.codehaus.groovy.grails.web.binding.GrailsDataBinder
import fr.cg95.cvq.dao.hibernate.PersistentStringEnum

class GlobalPropertyEditorConfig {
    static newDataBinder = { request, object ->
        def binder = GrailsDataBinder.createBinder(object, GrailsDataBinder.DEFAULT_OBJECT_NAME, request)
        registerCustomEditors(request, binder)
        return binder
    }

    private static void registerCustomEditors(request, binder) {
        binder.registerCustomEditor(PersistentStringEnum.class, new PersistentStringEnumEditor())
    }
}

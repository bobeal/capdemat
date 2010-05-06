import grails.converters.*
import java.util.*
import fr.cg95.cvq.security.*

class ServiceAutocompleteController {

    def cities = {
        def token = SecurityContext.getCurrentSite().token ?: ""
        withHttp(uri: "http://localhost:9000") {
           render get(path : '/cities', query : [search: params.search, postalCode: params.postalCode?:false, token:token]) as JSON
        }
    }

    def ways = {
        def token = SecurityContext.getCurrentSite().token ?: ""
        withHttp(uri: "http://localhost:9000") {
           render get(path : '/ways', query : [city: params.city, search: params.search, token:token]) as JSON
        }
    }

}


import grails.converters.*
import java.util.*
import fr.cg95.cvq.security.*
import org.codehaus.groovy.grails.commons.*

class ServiceAutocompleteController {

    def tokenValidity = {
        def token = SecurityContext.getCurrentSite().token ?: ""
        def url = ConfigurationHolder.config.addresses_referential_url
        if(url) {
            withHttp(uri: url, contentType: groovyx.net.http.ContentType.JSON) {
                render get(path: '/token', query: [token:token]) as JSON
            }
        }
    }

    def cities = {
        def token = SecurityContext.getCurrentSite().token ?: ""
        def url = ConfigurationHolder.config.addresses_referential_url
        if(url) {
            withHttp(uri: url) {
                render get(path: '/cities', query: [search: params.search, postalCode: params.postalCode?:false, token:token]) as JSON
            }
        }
    }

    def ways = {
        def token = SecurityContext.getCurrentSite().token ?: ""
        def url = ConfigurationHolder.config.addresses_referential_url
        if(url) {
            withHttp(uri: url) {
                render get(path: '/ways', query: [city: params.city, search: params.search, token:token]) as JSON
            }
        }
    }

}


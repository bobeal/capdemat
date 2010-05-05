import grails.converters.*
import java.util.*

class ServiceAutocompleteController {

    def cities = {
        withHttp(uri: "http://localhost:9000") {
           render get(path : '/cities', query : [search: params.search, postalCode: params.search]) as JSON
        }
    }

    def ways = {
        withHttp(uri: "http://localhost:9000") {
           render get(path : '/ways', query : [city: params.city, search: params.search]) as JSON
        }
    }

}


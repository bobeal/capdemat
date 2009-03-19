class UrlMappings {
    static mappings = {
        "/frontoffice/payment/details/$type/$reference" (controller : "frontofficePayment",action: "details" )
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here 
            }
        }
        "500"(controller: "system", action: "error")
    }
}

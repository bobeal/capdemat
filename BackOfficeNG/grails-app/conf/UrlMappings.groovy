class UrlMappings {
    static mappings = {
        "/frontoffice/requestCreation/$action?/$label/$id?" (controller : "frontofficeRequestCreation" )
        "/requestType/deleteSeasons/$requestTypeId/$seasonUuid"(controller:"requestType", action:"deleteSeasons")
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here 
            }
        }
        "500"(controller: "system", action: "error")
    }
}

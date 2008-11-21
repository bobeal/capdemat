class UrlMappings {
    static mappings = {
        "/requestType/deleteSeasons/$requestTypeId/$seasonUuid"(controller:"requestType", action:"deleteSeasons")
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here 
            }
        }
    }
}

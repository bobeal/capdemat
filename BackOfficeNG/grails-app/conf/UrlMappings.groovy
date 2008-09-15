class UrlMappings {
    static mappings = {
        "/category/associateRequestType/$categoryId/$requestTypeId"(controller:"category", action:"associateRequestType")
        "/category/unassociateRequestType/$categoryId/$requestTypeId"(controller:"category", action:"unassociateRequestType")
        
        "/category/associateAgent/$categoryId/$agentId/$profileIndex"(controller:"category", action:"associateAgent")

        "/requestType/deleteSeasons/$requestTypeId/$seasonUuid"(controller:"requestType", action:"deleteSeasons")

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }
    }	
}

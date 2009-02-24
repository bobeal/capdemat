class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here 
            }
        }
        "500"(controller: "system", action: "error")
    }
}

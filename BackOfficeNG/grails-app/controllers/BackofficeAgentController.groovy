import fr.cg95.cvq.service.authority.IAgentService

import grails.converters.JSON

class BackofficeAgentController {

    IAgentService agentService

    def defaultAction = "list"

    def beforeInterceptor = { session["currentMenu"] = "user" }

    def list = {
        def agents = agentService.getAll()
        // hack to load sitesRoles
        agents.each { it.sitesRoles.each {} }        
        
        return ["agents":agents]
    }

    def edit = {
        if (params.agentId != null && params.agentId != "")
           params.id = params.agentId

        def agent = agentService.getById(Long.valueOf(params.id))
        def agents = agentService.getAll()
        // hack to load sitesRoles
        agent.sitesRoles.each {}
              
        return [agents:agents, agent:agent, scope:"Agent"]
    }
}

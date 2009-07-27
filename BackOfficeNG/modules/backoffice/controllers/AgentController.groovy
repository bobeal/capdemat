import fr.cg95.cvq.business.authority.Category
import fr.cg95.cvq.business.authority.CategoryProfile
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.IAgentService

import grails.converters.JSON

class AgentController {

    ICategoryService categoryService
    IAgentService agentService

    def translationService
    def defaultAction = "list"

    def beforeInterceptor = { session["currentMenu"] = "user" }

    def list = {
        def agents = agentService.getAll()
        // hack to load category
        agents.each { it.categoriesRoles.category }
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

    /* Category managment
     * --------------------------------------------------------------------- */

    def categories = {
        def categories = []
        def agent = agentService.getById(Long.valueOf(params.id))
        if (request.post && params.scope == null) 
            categoryService.getAll().each { categories.add(adaptCategory(it, agent)) }
        else if (params.scope == "All")
            categoryService.getAll().each { categories.add(adaptCategory(it, agent)) }
        else if (params.scope == "Agent")
            agent.categoriesRoles.each { categories.add(adaptCategory(it.category, agent))}

        // TODO par id Agent
        categories = categories.sort{ it.name != null ? it.name.toLowerCase() : "zzz"}

        render( template: "agentCategories",
                model: [ "agentId": new Long(params.id), "categories": categories])
    }

    def unassociateCategory = {
        agentService.removeCategoryRole(Long.valueOf(params.agentId), Long.valueOf(params.categoryId))
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    def editCategory = {
        if (request.get) {
            def agent = agentService.getById(Long.valueOf(params.id))
            def category = categoryService.getById(Long.valueOf(params.categoryId));
            def profiles = []
            CategoryProfile.allCategoryProfiles.each { profiles.add(adaptCategoryProfile(it)) }
       
            render( template: "agentCategoryEdit",
                model: [agentId: new Long(params.id), category: adaptCategory(category, agent), profiles: profiles])
        }
        if (request.post) {
            if (params.agentId == null || params.categoryId == null)
                render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)

            agentService.modifyCategoryRole(
                  Long.valueOf(params.agentId),
                  Long.valueOf(params.categoryId),
                  CategoryProfile.allCategoryProfiles[Integer.valueOf(params.profileIndex)])

            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        }
    }

    /* Adaptions closure specific to categories
     * --------------------------------------------------------------------- */

    def adaptCategory (businessCategory, agent) {
        def agentHasProfile = categoryService.hasProfileOnCategory(agent, businessCategory.id)
        
        return [
            id: businessCategory.id,
            name: businessCategory.name,
            agentHasProfile: agentHasProfile,
            agentProfile:agentHasProfile == true ? adaptCategoryProfile(
                agent.categoriesRoles.find { it.category.id == businessCategory.id }.profile) : null
        ]
    }

    // TODO - modify CategoryProfile enum definition to respect string convention
    def adaptCategoryProfile(categoryProfile) {
        def cssClass
        def i18nKey
        if (categoryProfile == CategoryProfile.READ_ONLY) {
            i18nKey = "category.profile.readOnly"
            cssClass = "tag-read_only"
        }
        else if (categoryProfile == CategoryProfile.READ_WRITE) {
            i18nKey = "category.profile.readWrite"
            cssClass = "tag-read_write"
        }
       else if (categoryProfile == CategoryProfile.MANAGER) {
            i18nKey = "category.profile.manager"
            cssClass = "tag-manager"
        }
        return [ i18nKey: i18nKey, cssClass: cssClass ]
    }
}

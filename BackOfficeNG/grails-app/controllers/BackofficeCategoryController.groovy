import fr.cg95.cvq.business.request.Category
import fr.cg95.cvq.business.request.CategoryProfile
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.request.ICategoryService
import fr.cg95.cvq.service.request.IRequestTypeService

import grails.converters.JSON

class BackofficeCategoryController {
    
    ICategoryService categoryService
    IAgentService agentService
    IRequestTypeService requestTypeService
    
    def translationService
    def defaultAction = "list"
    
    def beforeInterceptor = { session["currentMenu"] = "category" }

    def list = {
        def categories = categoryService.getAll()

        def requestTypesByCategory = [:]
        categories.each { category ->
        	requestTypesByCategory[category.id] = []
        	category.requestTypes?.each { rt ->
        		requestTypesByCategory[category.id].add(CapdematUtils.adaptRequestType(translationService, rt))
        	}
        	requestTypesByCategory[category.id].sort {it.label.toLowerCase()}
        }

        def orphanRequestTypes = []
        requestTypeService.getAllRequestTypes().each {
            if (it.category == null)
                orphanRequestTypes.add(CapdematUtils.adaptRequestType(translationService,it))
        }

        return ['categories':categories, 'requestTypesByCategory':requestTypesByCategory,
                'orphanRequestTypes':orphanRequestTypes]
    }
    
    def edit = {
        if (params.categoryId != null && params.categoryId != "")
           params.id = params.categoryId
           
        def category = categoryService.getById(Long.valueOf(params.id))
        def categories = categoryService.getAll()
        return [editMode:"edit", categories:categories, category:category, orderRequestTypeBy:"label",
                scope:"Category"]
    }
    
    def create = {
        render(view:'edit',model:[editMode:"create", categories:categoryService.getAll()])
    }
    
    def save = {
        def category = null
        def create = true
        if (params.id != null && params.id != "") {
            category = categoryService.getById(Long.valueOf(params.id))
            bindData(category, params)
            categoryService.modify(category)
            create = false
        } else {
            category = new Category()
            bindData(category, params)
            categoryService.create(category)
        }

        render ([status:"ok", success_msg:message(code:"message.updateDone"),
                 id: category.id, name:category.name, create:create] as JSON)
    }
    
    def delete = {
        if (request.method.toLowerCase() != "delete") return false
        categoryService.delete(Long.valueOf(params.id))
        render ([status:"ok", id:params.id, success_msg:message(code:"category.message.confirmDelete")] as JSON)
    }
    
    def loadCategoryForm = {
        def category = null
        def create = true
        if (params.id) {
            category = categoryService.getById(Long.valueOf(params.id))
            create = false
        }
        render(template:"categoryForm",model:[category:category, editMode:create ? "create" : "edit"])
    }
    
    /* Category requestType managment
     * --------------------------------------------------------------------- */

    def requestTypes = {
        def requestTypes = []
        
        if ((request.post && params.scope == null) || params.scope == 'All') {
            requestTypeService.getAllRequestTypes().each{
                requestTypes.add(CapdematUtils.adaptRequestType(translationService,it)) 
            }
        } else if (params.scope == 'Category') {
            categoryService.getById(Long.valueOf(params.id)).getRequestTypes().each {
                requestTypes.add(CapdematUtils.adaptRequestType(translationService,it))
            }
        }
        
        def orderRequestTypeBy
        if (params.orderRequestTypeBy == null || params.orderRequestTypeBy == "label") {
            requestTypes = requestTypes.sort{ it.label.toLowerCase() }
            orderRequestTypeBy = "label"
        } else if (params.orderRequestTypeBy == "categoryName") {
            requestTypes = requestTypes.sort{ it.categoryName != null ? it.categoryName.toLowerCase() : "zzz" }
            orderRequestTypeBy = "categoryName"
        }
        
        render( template:"categoryRequests",
                model:[ categoryId: new Long(params.id), requestTypes: requestTypes, 
                        orderRequestTypeBy: orderRequestTypeBy, scope:params.scope ])
    }
    
    def associateRequestType = {
        def category = 
            categoryService.addRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))
        render ([status:"ok",categoryName:category.name, success_msg:message(code:"message.updateDone")] as JSON)
    }

    def unassociateRequestType = {
        def category = 
            categoryService.removeRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))
        render ([status:"ok",categoryName:"", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    /* Category agent managment
     * --------------------------------------------------------------------- */
    
    def agents = {
        def agents = []
        if (request.post && params.scope == null) {
            agentService.getAll().each { agents.add(adaptAgent(it)) }
        }  else if (params.scope == "All")
            agentService.getAll().each { agents.add(adaptAgent(it)) }
        else if (params.scope == "Category")
            categoryService.getAuthorizedForCategory(Long.valueOf(params.id)).each {
                agents.add(adaptAgent(it))
            }
            
        agents = agents.sort{ it.lastName != null ? it.lastName.toLowerCase() : "zzz"}

        render( template: "categoryAgents", 
                model: [ "categoryId": new Long(params.id), "agents": agents])
    }
    
    def unassociateAgent = {
        categoryService.removeCategoryRole(Long.valueOf(params.agentId), Long.valueOf(params.categoryId))
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }
    
    def editAgent = {
        if (request.get) {
            def agent = agentService.getById(Long.valueOf(params.agentId));
            def profiles = []
            CategoryProfile.allCategoryProfiles.each { profiles.add(adaptCategoryProfile(it)) }
            
            render( template: "categoryAgentEdit",
                model: [categoryId: new Long(params.id), agent: adaptAgent(agent), profiles: profiles])
        }
        
        if (request.post) {
            if (params.agentId == null || params.categoryId == null)
                render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            
            categoryService.modifyCategoryRole(
                  Long.valueOf(params.agentId), 
                  Long.valueOf(params.categoryId),
                  CategoryProfile.allCategoryProfiles[Integer.valueOf(params.profileIndex)])

            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        }
    }
    
    /* Adaptions closure specific to categories
     * --------------------------------------------------------------------- */
    
    def adaptAgent (businessAgent) {
        def categoryProfile = 
        	categoryService.getProfileForCategory(businessAgent.id, Long.valueOf(params.id))
        return [
            id: businessAgent.id,
            active: businessAgent.active,
            login: businessAgent.login,
            firstName: businessAgent.firstName,
            lastName: businessAgent.lastName,
            profile: categoryProfile != null ? adaptCategoryProfile(categoryProfile) : null,
            notBelong: categoryProfile == null ? true : false
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

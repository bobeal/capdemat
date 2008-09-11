import fr.cg95.cvq.business.authority.Category
import fr.cg95.cvq.business.authority.CategoryProfile
import fr.cg95.cvq.exception.*
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.request.IRequestService

import grails.converters.JSON

class CategoryController {
    
    ICategoryService categoryService
    IAgentService agentService
    IRequestService defaultRequestService
    
    def translationService
    
    def defaultAction = "list"
    
    def beforeInterceptor = {
        session["currentMenu"] = "category"
    }

    def list = {
        log.debug "list() returning all categories"
        def categories = categoryService.getAll()
        // hack to load request types
        categories.each {
            it.requestTypes.label
        }
        // end hack
        return ["categories":categories]
    }
    
    def edit = {
        if (params.categoryId != null && params.categoryId != "")
           params.id = params.categoryId
           
        def category = categoryService.getById(Long.valueOf(params.id))
        def categories = categoryService.getAll()
        return [editMode:"edit", categories:categories, category:category]
    }
    
    def create = {
    	render(view:'edit',model:[editMode:"create", categories:categoryService.getAll()])
    }
    
    // called asynchronously
    def save = {
        def category = null
        def create = true
		    try {
		        if (params.id != null && params.id != "") {
		            log.debug "save() modifying category ${params.id}"
		            category = categoryService.getById(Long.valueOf(params.id))
                bindData(category, params)
		            categoryService.modify(category)
		            create = false
		        } else {
		            category = new Category()
		            bindData(category, params)
		            def categoryId = categoryService.create(category)
        //            category = categoryService.getById(categoryService.create(category))
                redirect(action:"edit", id:categoryId)
        //		        render(view:"edit", model:[editMode:"edit", categories:categoryService.getAll(), category:category])
		        }
		    } catch (CvqModelException cme) {
		        log.error "save() a category with the same name already exists"
		        render ([status: "error", error_msg:message(code:"category.error.nameAlreadyExists")] as JSON)
		        return
		    } catch (CvqException ce) {
			    log.error "save() error while creating category"
		        render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
		        return
		    }

		    // def baseUrl = grailsAttributes.getApplicationUri(request) + "/$controllerName" 
		    render ([status:"ok", id: category.id, name:category.name, create:create] as JSON)
    }
    
    // called asynchronously
    def delete = {
        log.debug "delete() deleting category ${params.id}"
        try {
            categoryService.delete(Long.valueOf(params.id))
        } catch (CvqObjectNotFoundException cme) {
            log.error "delete() category ${params.id} has not been found"
            render ([status: "error", error_msg:message(code:"category.error.notFound")] as JSON)
            return
        } catch (CvqException ce) {
            log.error "delete() error while creating category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            return
        }
        
        render ([status:"ok", id:params.id, success_msg:message(code:"category.message.confirmDelete")] as JSON)
    }
    
    // called asynchronously
    // return the template used to display the main category form
    def loadCategoryForm = {
        def category = null
        def create = true
        if (params.id) {
            category = categoryService.getById(Long.valueOf(params.id))
            create = false
        }
        render(template:"categoryForm",model:[category:category, editMode:create ? "create" : "edit"])
    }
    
    // called asynchronously
    // return the template used to display a category in the categories menu
	  def loadCategoryMenuItem = {
        def category = categoryService.getById(Long.valueOf(params.id))
        render(template:"categoryItem",model:[id:category.id,name:category.name])
    }

    // called asynchronously
    // return the template used to sort and display all requests types
    def sortAllRequestTypesTemplate = {
        // def category = categoryService.getById(Long.valueOf(params.id))
        def allRequestTypes = []
        defaultRequestService.getAllRequestTypes().each {
            allRequestTypes.add(adaptRequestType(it))
        }
        
        def requestTypes
        if (params.orderRequestTypeBy == "label")
            requestTypes = allRequestTypes.sort{it.label}
        else if (params.orderRequestTypeBy == "categoryName")
            requestTypes = allRequestTypes.sort{it.categoryName}
        else
            requestTypes = allRequestTypes
        
        render(template:"categoryRequests",
               model:[
                  categoryId: new Long(params.id),
                  requestTypes: requestTypes
                  ])
    }
       
    // called asynchronously
    // return the template used to display requests types associated to the given category
    def loadCategoryRequestTypesTemplate = {
        def category = categoryService.getById(Long.valueOf(params.id))
        def categoryRequestTypes = []
        category.getRequestTypes().each {
            categoryRequestTypes.add(adaptRequestType(it))
        }
        render(template:"categoryRequests",
               model:[categoryId: new Long(params.id), requestTypes: categoryRequestTypes])
    }
    
    // called asynchronously
    // return the template used to display all requests types
    def loadAllRequestTypesTemplate = {
        def allRequestTypes = []
        defaultRequestService.getAllRequestTypes().each {
            allRequestTypes.add(adaptRequestType(it))
        }
        
		    render(template:"categoryRequests",
		           model:[categoryId:new Long(params.id), requestTypes:allRequestTypes])
    }
    
    def associateRequestType = {
		log.debug "associateRequestType() associating request type ${params.requestTypeId} to ${params.categoryId}"
        try {
            def category = 
            	categoryService.addRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))

			render ([status:"ok",categoryName:category.name, success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            log.error "associateRequestType() error while associating request type to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            return
        }
    }

    def unassociateRequestType = {
    	log.debug "unassociateRequestType() unassociating request type ${params.requestTypeId} from ${params.categoryId}"
        try {
            def category = 
                categoryService.removeRequestType(Long.valueOf(params.categoryId),Long.valueOf(params.requestTypeId))

    		render ([status:"ok",categoryName:"", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            log.error "associateRequestType() error while unassociating request type from category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            return
        }
    }
    
    // called asynchronously
    // return the template used to display agents associated to the given category
    def loadCategoryAgentsTemplate = {
        def categoryAgents = agentService.getAuthorizedForCategory(Long.valueOf(params.id))
        def agents = []
        categoryAgents.each {
          agents.add(adaptAgent(it))
        }
		    render(template:"categoryAgents",model:[categoryId:new Long(params.id), agents:agents])
    }

    // called asynchronously
    // return the template used to display all agents
    def loadAllAgentsTemplate = {
        log.debug "loadAllAgentsTemplate()"
        def allAgents = agentService.getAll();
        def agents = []
        allAgents.each {
            agents.add(adaptAgent(it))
        }
        render(template:"categoryAgents",model:[categoryId:new Long(params.id), agents:agents])
    }
    
    // called asynchronously
    // return the template used to display agent category profile form ediion
    def loadAgentEditTemplate = {
        log.debug "loadAgentEditTemplate()"
        def agent = agentService.getById(Long.valueOf(params.agentId));
        def profiles = []
        CategoryProfile.allCategoryProfiles.each {
            profiles.add(adaptCategoryProfile(it))
        }
        
        render( template: "categoryAgentEdit",
                model: [categoryId: new Long(params.id),
                       agent: adaptAgent(agent),
                       profiles: profiles])
    }
    
    // TODO - not used
    def associateAgent = {
        log.debug "associateAgent() associating agent ${params.agentId} to ${params.categoryId} with profile ${params.profileIndex}"    
        try {
        	  agentService.addCategoryRole(Long.valueOf(params.agentId), Long.valueOf(params.categoryId),
        	        getProfileFromIndex(0/*Integer.valueOf(params.profileIndex)*/))

    	    	render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
        	  log.error "associateAgent() error while associating agent to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            return
        }            
    }
    
    def unassociateAgent = {
        log.debug "unassociateAgent() unassociating agent ${params.agentId} to ${params.categoryId}"    
        try {
            agentService.removeCategoryRole(Long.valueOf(params.agentId), Long.valueOf(params.categoryId))

    		    render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
        	  log.error "unassociateAgent() error while unassociating agent to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
            return
        }            
    }
    
    def editAgent = {
        if (params.agentId == null || params.categoryId == null) {
//            return
        }
          
        log.debug "editAgent() editAgent agent ${params.agentId} to ${params.categoryId}"
        try {
        	  agentService.modifyCategoryRole(
        	        Long.valueOf(params.agentId), 
        	        Long.valueOf(params.categoryId),
        	        getProfileFromIndex(Integer.valueOf(params.profileIndex)))

    		    render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        } catch (CvqException ce) {
            log.error "editAgent() error while editAgent agent to category"
            render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)
        }            
    }
    
    def adaptRequestType (requestType) {
        return [
            id: requestType.id,
            active: requestType.active,
            label: translationService.getEncodedRequestTypeLabelTranslation(requestType.label),
            categoryId: requestType.category != null ? requestType.category.id : null, 
            categoryName: requestType.category != null ? requestType.category.name : "zzz" // temp hack to enable sort
        ]
    }
    
    def adaptAgent (businessAgent) {
        def matchingCategorieRole = businessAgent.categoriesRoles.find {
                it.category.id == Long.valueOf(params.id)
        }
        return [
            id: businessAgent.id,
            active: businessAgent.active,
            login: businessAgent.login,
            firstName: businessAgent.firstName,
            lastName: businessAgent.lastName,
            profile: matchingCategorieRole != null ? adaptCategoryProfile(matchingCategorieRole.profile) : null,
            notBelong: matchingCategorieRole == null ? true : false
        ]
    }
    
    def adaptCategoryProfile(categoryProfile) {
        def cssClass
        def i18nKey
        if (categoryProfile == CategoryProfile.READ_ONLY) {
   	        i18nKey = "categoryProfile.readOnly"
   	        cssClass = "tag-read_only"
   	    }
   	    else if (categoryProfile == CategoryProfile.READ_WRITE) {
   	        i18nKey = "categoryProfile.readWrite"
   	        cssClass = "tag-read_write"
   	    }
   	    else if (categoryProfile == CategoryProfile.MANAGER) {
            i18nKey = "categoryProfile.manager"
            cssClass = "tag-manager"
        }
        return [i18nKey: i18nKey, cssClass: cssClass]         
    }
    
    def getProfileFromIndex(index) {
    	  return CategoryProfile.allCategoryProfiles[index]
    }
}


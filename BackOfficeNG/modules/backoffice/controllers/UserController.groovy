import fr.cg95.cvq.business.authority.Category
import fr.cg95.cvq.business.authority.CategoryProfile
import fr.cg95.cvq.service.authority.ICategoryService
import fr.cg95.cvq.service.authority.IAgentService

import grails.converters.JSON

class UserController {

    ICategoryService categoryService
    IAgentService agentService

    def translationService
    def defaultAction = "list"

    def beforeInterceptor = { session["currentMenu"] = "user" }

    def list = {
        def users = agentService.getAll()
        // hack to load category
        users.each { it.categoriesRoles.category }
        
        return ["users":users]
    }

    def edit = {
        if (params.userId != null && params.userId != "")
           params.id = params.userId

        def user = agentService.getById(Long.valueOf(params.id))
        def users = agentService.getAll()
        
        return [users:users, user:user, scope:"User"]
    }

    /* Category managment
     * --------------------------------------------------------------------- */

    def categories = {
        def categories = []
        def user = agentService.getById(Long.valueOf(params.id))
        if (request.post && params.scope == null) 
            categoryService.getAll().each { categories.add(adaptCategory(it, user)) }
        else if (params.scope == "All")
            categoryService.getAll().each { categories.add(adaptCategory(it, user)) }
        else if (params.scope == "User")
            user.categoriesRoles.each { categories.add(adaptCategory(it.category, user))}

        // TODO par id User
        categories = categories.sort{ it.name != null ? it.name.toLowerCase() : "zzz"}

        render( template: "userCategories",
                model: [ "userId": new Long(params.id), "categories": categories])
    }

    def unassociateCategory = {
        agentService.removeCategoryRole(Long.valueOf(params.userId), Long.valueOf(params.categoryId))
        render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
    }

    def editCategory = {
        if (request.get) {
            def user = agentService.getById(Long.valueOf(params.id))
            def category = categoryService.getById(Long.valueOf(params.categoryId));
            def profiles = []
            CategoryProfile.allCategoryProfiles.each { profiles.add(adaptCategoryProfile(it)) }
       
            render( template: "userCategoryEdit",
                model: [userId: new Long(params.id), category: adaptCategory(category, user), profiles: profiles])
        }
        if (request.post) {
            if (params.userId == null || params.categoryId == null)
                render ([status: "error", error_msg:message(code:"error.unexpected")] as JSON)

            agentService.modifyCategoryRole(
                  Long.valueOf(params.userId),
                  Long.valueOf(params.categoryId),
                  CategoryProfile.allCategoryProfiles[Integer.valueOf(params.profileIndex)])

            render ([status:"ok", success_msg:message(code:"message.updateDone")] as JSON)
        }
    }

    /* Adaptions closure specific to categories
     * --------------------------------------------------------------------- */

    def adaptCategory (businessCategory, user) {
        def userHasProfile = categoryService.hasProfileOnCategory(user, businessCategory.name)
        
        return [
            id: businessCategory.id,
            name: businessCategory.name,
            userHasProfile: userHasProfile,
            userProfile:userHasProfile == true ? adaptCategoryProfile(
                user.categoriesRoles.find { it.category.id == businessCategory.id }.profile) : null
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

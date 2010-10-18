import java.util.LinkedHashSet
import java.util.List

import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils

import fr.cg95.cvq.business.authority.Agent
import fr.cg95.cvq.business.authority.RecreationCenter
import fr.cg95.cvq.business.authority.School
import fr.cg95.cvq.business.authority.SiteProfile
import fr.cg95.cvq.business.authority.SiteRoles
import fr.cg95.cvq.exception.CvqObjectNotFoundException
import fr.cg95.cvq.security.SecurityContext
import fr.cg95.cvq.service.authority.IAgentService
import fr.cg95.cvq.service.authority.IRecreationCenterService
import fr.cg95.cvq.service.authority.ISchoolService

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

/**
 * @author bor@zenexity.fr
 */
class ServiceProvisioningController {

    IAgentService agentService
    ISchoolService schoolService
    IRecreationCenterService recreationCenterService
    def authorizeAlreadyCreated = Boolean.valueOf(CH.config.provisioning.authorizeAlreadyCreated)

    def beforeInterceptor = {
        def authorization = request.getHeader("Authorization")
        if (authorization == null) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"capdemat provisioning\"")
            render(text: "", status : 401)
            return false
        }
        def credentials = StringUtils.split(new String(Base64.decodeBase64(authorization.substring(6).bytes), "8859_1"), ":")
        if (credentials == null || credentials.length < 2 || credentials[0] != "provisioning"
            || credentials[1] != grailsApplication.config.provisioning.secret) {
            response.setHeader("WWW-Authenticate", "Basic")
            render(text: "", status : 401)
            return false
        }
    }

    def createAgent = {
        def agent
        try {
            agent = agentService.getByLogin(params.login)
            if (!authorizeAlreadyCreated) {
                render(text : "An agent with this login already exists", status : 409)
                return false
            }
        } catch (CvqObjectNotFoundException confe) {
            agent = new Agent()
            agent.login = params.login
        }
        agent.firstName = params.firstName
        agent.lastName = params.lastName
        def isAdmin
        def isContributor
        def groups
        if (params.groups instanceof String) groups = [params.groups]
        else groups = params.groups as List
        if (groups == null || groups.size() == 0 || !SecurityContext.isAuthorizedGroup(groups)) {
            agent.active = false
            isAdmin = false
            isContributor = true
        } else {
            agent.active = true
            isAdmin = SecurityContext.isOfAnAdminGroup(groups)
            isContributor = !isAdmin && SecurityContext.isOfAnAgentGroup(groups)
        }
        def sitesRolesSet = new LinkedHashSet<SiteRoles>()
        def sr = new SiteRoles()
        sr.agent = agent
        sr.profile = isAdmin ? SiteProfile.ADMIN : SiteProfile.AGENT
        sitesRolesSet.add(sr)
        agent.sitesRoles = sitesRolesSet
        if (agent.id) agentService.modify(agent)
        else agentService.create(agent)
        render(text : "", status : 201)
        return false
    }

    def modifyAgent = {
        def agent
        try {
            agent = agentService.getByLogin(params.id)
        } catch (CvqObjectNotFoundException confe) {
            render(status : 404)
            return false
        }
        def groups
        if (params.groups instanceof String) groups = [params.groups]
        else groups = params.groups as List
        if (groups == null || groups.size() == 0 || !SecurityContext.isAuthorizedGroup(groups)) {
            agent.active = false
        } else {
            agentService.modifyProfiles(agent, groups,
                SecurityContext.getAdministratorGroups(), SecurityContext.getAgentGroups())
            agent.active = true
        }
        agent.login = params.login
        agent.firstName = params.firstName
        agent.lastName = params.lastName
        agentService.modify(agent)
        render(status : 200)
        return false
    }

    def deleteAgent = {
        def agent =  agentService.getByLogin(params.id)
        if (agent == null) {
            render(status : 404)
            return false
        }
        agent.active = false
        agentService.modify(agent)
        render(status : 200)
        return false
    }

    def createRecreationCenter = {
        def recreationCenter = recreationCenterService.getByName(params.name)
        if (recreationCenter == null) {
            recreationCenter = new RecreationCenter()
            recreationCenter.name = params.name
        } else if (!authorizeAlreadyCreated) {
            render(text : "A recreation center with this name already exists", status : 409)
            return false
        }
        recreationCenter.address = params.address
        recreationCenter.active = true
        if (recreationCenter.id) recreationCenterService.modify(recreationCenter)
        else recreationCenterService.create(recreationCenter)
        render(status : 201)
        return false
    }

    def modifyRecreationCenter = {
        def recreationCenter = recreationCenterService.getByName(params.id)
        if (recreationCenter == null) {
            render(status : 404)
            return false
        }
        recreationCenter.name = params.name
        recreationCenter.address = params.address
        recreationCenterService.modify(recreationCenter)
        render(status : 200)
        return false
    }

    def deleteRecreationCenter = {
        def recreationCenter = recreationCenterService.getByName(params.id)
        if (recreationCenter == null) {
            render(status : 404)
            return false
        }
        recreationCenter.active = false
        recreationCenterService.modify(recreationCenter)
        render(status : 200)
        return false
    }

    def createSchool = {
        def school = schoolService.getByName(params.name)
        if (school == null) {
            school = new School()
            school.name = params.name
        } else if (!authorizeAlreadyCreated) {
            render(text : "A school with this name already exists", status : 409)
            return false
        }
        school.adress = params.address
        school.active = true
        if (school.id) schoolService.modify(school)
        else schoolService.create(school)
        render(status : 201)
        return false
    }

    def modifySchool = {
        def school = schoolService.getByName(params.id)
        if (school == null) {
            render(status : 404)
            return false
        }
        school.name = params.name
        school.adress = params.address
        schoolService.modify(school)
        render(status : 200)
        return false
    }

    def deleteSchool = {
        def school = schoolService.getByName(params.id)
        if (school == null) {
            render(status : 404)
            return false
        }
        school.active = false
        schoolService.modify(school)
        render(status : 200)
        return false
    }
}

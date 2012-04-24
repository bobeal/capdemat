import java.io.File;

import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import org.apache.commons.codec.binary.Base64
import org.apache.commons.lang.StringUtils
import fr.cg95.cvq.security.PermissionException
import fr.cg95.cvq.security.SecurityContext

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {

    def beforeInterceptor = [action:this.&authenticate, only:['template']]
    /**
     * Check authorization to access local authority resources.
     */
    def authenticate() {
        def authorization = request.getHeader('Authorization')
        if (!authorization) {
            render(text: 'Authorization required', status: 403)
            return false
        }
        def method = authorization.subSequence(0, 6)
        if (!(method.equals('Basic '))){
            render(text: '"' + method + '" unavailable. Use "Basic" instead.', status: 403)
            return false
        }
        def credentials = StringUtils.split(
            new String(Base64.decodeBase64(authorization.substring(6).bytes),
            "UTF-8"),
            ":")
        if (credentials?.length < 2) {
            render(text: '"login" and "password" required', status: 403)
            return false
        }
        def password = localAuthorityRegistry
            .getLocalAuthorityBeanByName(SecurityContext.getCurrentConfigurationBean().getName())
            .getAuthorizations()
            .get(credentials[0])
        if (!password && !(password.equals(credentials[1]))){
            render(text: '"login"/"password" don\'t match', status: 403)
            return false
        }
        params.put('login', credentials[0])
        return true
    }

    ILocalAuthorityRegistry localAuthorityRegistry

    def localAuthorityResourceAdaptorService

    def defaultAction = "resource"

    def resource = {
        def localAuthorityResource = localAuthorityResourceAdaptorService.getLocalAuthorityResources()[params.id]
        File resource
        if (localAuthorityResource != null) {
            resource = localAuthorityRegistry.getLocalAuthorityResourceFile(
                params.id,
                params.version != null ? LocalAuthorityResource.Version.valueOf(params.version) : LocalAuthorityResource.Version.CURRENT)
            if (resource != null)
                renderResponse(resource, params.id, localAuthorityResource.type.contentType)
        } else {
            resource = localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.valueOf(params.type),
                params.filename,
                params.version != null ? LocalAuthorityResource.Version.valueOf(params.version) : LocalAuthorityResource.Version.CURRENT,
                true)
            if (resource != null && resource.exists())
                renderResponse(resource, params.filename, Type.valueOf(params.type).contentType)
        }

    }

    def rule = {
        File pdfFile =
            localAuthorityRegistry.getLocalAuthorityResourceFile(Type.PDF,
                CapdematUtils.requestTypeLabelAsDir(params.requestTypeLabel)
                + "/"  + params.filename, false)
        if (pdfFile.exists()) {
            renderResponse(pdfFile, params.filename, "application/pdf")
        }
    }

    def renderResponse(file, filename, contentType) {
        String extension = "." + StringUtils.substringAfter(contentType, "/")
        def filenameDetail = "attachment;filename=" + filename + extension
        byte[] data = file.readBytes()
        response.contentType = contentType
        response.addHeader("content-disposition", filenameDetail)
        response.contentLength = data.length
        response.outputStream << data
    }

    /**
     * * filename not provided :
     * curl --verbose --request PUT --header "Content-Type: text/html" \
     *      --data-binary @template.html \
     *      http://localhost:8080/CapDemat/service/templates/ \
     *      -u login:password
     *
     * * filename provided :
     * curl --verbose --request PUT --header "Content-Type: text/html" \
     *      --data-binary @template.html \
     *      http://localhost:8080/CapDemat/service/templates/mytemplate
     *      -u login:password
     */
    def template = {
        try {
            if (!(request.getHeader('Content-Type').startsWith('text/html'))) {
                render(text: 'Unsupported type ' + request.getHeader('Content-Type'), status: 415)
                return
            }
            def filename = params.filename ? params.filename : 'default'
            localAuthorityRegistry.saveLocalAuthorityResource(
                LocalAuthorityResource.Type.HTML,
                'templates/fo/' + params.get('login') + '/' + filename,
                request.reader.text.getBytes('utf-8'))
            render(text: 'File uploaded', status: 200)
        } catch (PermissionException pe) {
            render(text: message(code: pe.message), status: 403)
        } catch (Exception e) {
            render(text: message(code: e.message), status: 500)
        }
    }
}

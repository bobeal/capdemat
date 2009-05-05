import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestTypeService

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {
	
    ILocalAuthorityRegistry localAuthorityRegistry
    IRequestTypeService requestTypeService

    def localAuthorityResourceAdaptorService

    def defaultAction = "resource"

    def resource = {
        def localAuthorityResource = localAuthorityResourceAdaptorService.getLocalAuthorityResources()[params.id]
        if (localAuthorityResource != null) {
            File resource = localAuthorityRegistry.getLocalAuthorityResourceFile(
                params.id,
                params.version != null ? LocalAuthorityResource.Version.valueOf(params.version) : LocalAuthorityResource.Version.CURRENT,
                localAuthorityResource.canFallback)
            if (resource != null) {
                renderResponse(resource, localAuthorityResource.contentType)
            }
        }
    }

    def rule = {
        def requestType = requestTypeService.getRequestTypeByLabel(params.requestTypeLabel)
        File pdfFile =
            localAuthorityRegistry.getLocalAuthorityResource(
                session.currentSiteName,
                ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE,
                CapdematUtils.requestTypeLabelAsDir(params.requestTypeLabel)
                    + "/"  + params.filename + ".pdf",
                false)
        if (pdfFile.exists()) {
            renderResponse(pdfFile, "application/pdf")
        }
    }

    def renderResponse(file, contentType) {
        byte[] data = file.readBytes()
        response.contentType = contentType
        response.contentLength = data.length
        response.outputStream << data                
    }
}

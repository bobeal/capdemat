import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry
import fr.cg95.cvq.service.request.IRequestTypeService

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {
	
    ILocalAuthorityRegistry localAuthorityRegistry
    IRequestTypeService requestTypeService

    def cssFo = {
        File cssFile = 
            localAuthorityRegistry.getLocalAuthorityResource(
                session.currentSiteName,
                ILocalAuthorityRegistry.CSS_ASSETS_RESOURCE_TYPE,
                session.currentSiteName + ".css", false)
        renderResponse(cssFile, 'text/css')
    }

    def logoFo = {
        File logoFile = 
            localAuthorityRegistry.getLocalAuthorityResource(
                session.currentSiteName,
                ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                "logoFo.png", false)
        renderResponse(logoFile, 'image/png')
    }

    def image = {
        File logoFile = 
            localAuthorityRegistry.getLocalAuthorityResource(
                session.currentSiteName,
                ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                params.id + ".jpg", false)
        renderResponse(logoFile, 'image/jpeg')
    }
    
    def pdf = {
        File pdfFile =
            localAuthorityRegistry.getLocalAuthorityResource(
                session.currentSiteName,
                ILocalAuthorityRegistry.PDF_ASSETS_RESOURCE_TYPE,
                params.id + ".pdf", false)
        if (pdfFile.exists())
            renderResponse(pdfFile, 'application/pdf')
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

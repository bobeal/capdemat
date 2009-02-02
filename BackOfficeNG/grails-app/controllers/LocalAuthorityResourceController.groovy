import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {
	
    ILocalAuthorityRegistry localAuthorityRegistry

    def cssFo = {
        File cssFile = 
            localAuthorityRegistry.getLocalAuthorityResource(session.currentSiteName,
                    ILocalAuthorityRegistry.CSS_ASSETS_RESOURCE_TYPE,
                    session.currentSiteName + ".css", false)
        renderResponse(cssFile, 'text/css')
    }
    
    def logoFo = {
        File logoFile = 
            localAuthorityRegistry.getLocalAuthorityResource(session.currentSiteName,
                    ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                    "logoFo.png", false)
        renderResponse(logoFile, 'image/png')
    }

    def image = {
        File logoFile = 
            localAuthorityRegistry.getCurrentLocalAuthorityResource(ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                params.id + ".jpg", false)
        renderResponse(logoFile, 'image/jpeg')
    }
    
    def renderResponse(file, contentType) {
        byte[] data = file.readBytes()
        response.contentType = contentType
        response.contentLength = data.length
        response.outputStream << data                
    }
}

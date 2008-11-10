import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {
	
    ILocalAuthorityRegistry localAuthorityRegistry

    def image = {
    	File logoFile = 
            localAuthorityRegistry.getCurrentLocalAuthorityResource(ILocalAuthorityRegistry.IMAGE_ASSETS_RESOURCE_TYPE,
                params.id + ".jpg", false)
        log.debug "returning content from ${logoFile.absolutePath}"
        byte[] b = logoFile.readBytes()
        response.contentType = 'image/jpeg'
        response.contentLength = 'b.length'
        response.outputStream << b
    }
}

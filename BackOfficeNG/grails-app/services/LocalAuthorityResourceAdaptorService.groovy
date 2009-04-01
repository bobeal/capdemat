import fr.cg95.cvq.business.authority.LocalAuthorityResource

public class LocalAuthorityResourceAdaptorService {

    def localAuthorityResources

    public getLocalAuthorityResources() {
        if (localAuthorityResources == null) {

            localAuthorityResources = [:]
            LocalAuthorityResource.localAuthorityResources.each {
                localAuthorityResources.(it.key) = [:]
                localAuthorityResources.(it.key).id = it.value.id
                localAuthorityResources.(it.key).filename = it.value.filename
                localAuthorityResources.(it.key).extension = it.value.extension
                localAuthorityResources.(it.key).resourceType = it.value.resourceType
            }

            localAuthorityResources.cssFO.template = "linkBox"
            localAuthorityResources.logoFO.template = "imageBox"
            localAuthorityResources.logoBO.template = "imageBox"
            localAuthorityResources.banner.template = "imageBox"
            localAuthorityResources.logoPDF.template = "imageBox"
            localAuthorityResources.faqFO.template = "linkBox"
            localAuthorityResources.helpBO.template = "linkBox"
            localAuthorityResources.helpFO.template = "linkBox"
            localAuthorityResources.legal.template = "linkBox"
            localAuthorityResources.use.template = "linkBox"

            localAuthorityResources.cssFO.contentType = "text/css"
            localAuthorityResources.logoFO.contentType = "image/png"
            localAuthorityResources.logoBO.contentType = "image/png"
            localAuthorityResources.banner.contentType = "image/png"
            localAuthorityResources.logoPDF.contentType = "image/png"
            localAuthorityResources.faqFO.contentType = "application/pdf"
            localAuthorityResources.helpBO.contentType = "application/pdf"
            localAuthorityResources.helpFO.contentType = "application/pdf"
            localAuthorityResources.legal.contentType = "application/pdf"
            localAuthorityResources.use.contentType = "application/pdf"
        }
        return localAuthorityResources
    }
}

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
                localAuthorityResources.(it.key).type = it.value.type
                localAuthorityResources.(it.key).canFallback = it.value.canFallback()
            }

            localAuthorityResources.cssFo.template = "linkBox"
            localAuthorityResources.logoFo.template = "imageBox"
            localAuthorityResources.logoBo.template = "imageBox"
            localAuthorityResources.banner.template = "imageBox"
            localAuthorityResources.logoPdf.template = "imageBox"
            localAuthorityResources.faqFo.template = "linkBox"
            localAuthorityResources.helpBo.template = "linkBox"
            localAuthorityResources.helpFo.template = "linkBox"
            localAuthorityResources.legal.template = "linkBox"
            localAuthorityResources.use.template = "linkBox"
        }
        return localAuthorityResources
    }
}

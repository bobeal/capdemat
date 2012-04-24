import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Version

class LayoutTagLib {
    def localAuthorityRegistry

    def layoutFO = { attrs ->

        if (params.owner) {
            session.setAttribute(
                'templatePath',
                'templates/fo/' + params.owner + '/' + (params.template?: 'default'))
        }

        def path = session.getAttribute('templatePath')?: 'templates/fo/default'
        def template

        // Try …/fo/$owner/$template, then …/fo/$owner/default, then …/fo/default
        [path,
         (path =~ /(.*\/).*/)[0][1] + 'default',
         'templates/fo/default'].each {
            if (!template) {
                session.setAttribute('templatePath', it)
                template = localAuthorityRegistry.getLocalAuthorityResourceFile(
                    Type.HTML,
                    it,
                    Version.CURRENT,
                    true)?.text
            }
        }

        def layout = template.replace('#[HEAD]', attrs.head)
                             .replace('#[HEADER]', attrs.header)
                             .replace('#[LOGIN]', attrs.login)
                             .replace('#[NAV]', attrs.nav)
                             .replace('#[CONTENTS]', attrs.contents)
                             .replace('#[FOOTER]', attrs.footer)

        out << layout
    }
}

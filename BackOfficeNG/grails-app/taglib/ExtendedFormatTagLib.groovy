import org.springframework.web.servlet.support.RequestContextUtils as RCU;
import org.codehaus.groovy.grails.plugins.web.taglib.FormatTagLib;

class ExtendedFormatTagLib extends FormatTagLib {
    
    def format = { attrs ->
        def value = attrs.get('value')
        def formatName = attrs.get('formatName')

        if (formatName) {
            def locale = RCU.getLocale(request)
            def messageSource = grailsAttributes.getApplicationContext().getBean('messageSource')
            attrs.format = messageSource.getMessage(formatName, null, null, locale)
        }

        if (value instanceof Date) {
            formatDate.call(attrs + [date:value])
        }
        else if (value instanceof Number) {
            formatNumber.call(attrs + [number:value])
        }
        else {
            out << value
        }
    }
}
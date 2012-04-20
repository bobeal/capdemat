<% import org.apache.commons.lang.StringUtils %>
${acronym}.label = ${requestI18n?.get(lang)?.get('short')}
${acronym}.description = ${requestI18n?.get(lang)?.get('long') != null ? requestI18n?.get(lang)?.get('long') : ''}
<% elements.each { el -> %>
${el.i18nPrefixCode}.label=${el.i18nUserDoc.get(lang) != null ? el.i18nUserDoc.get(lang).text : ''}
<% if(el.i18nUserDoc.get('fr') != null) el.i18nUserDoc.get('fr').xmlTranslationNodes.each { entry -> %> ${el.i18nPrefixCode}.${StringUtils.uncapitalize(entry.key)} = ${el.i18nUserDoc?.get(lang)?.xmlTranslationNodes != null ? el.i18nUserDoc?.get(lang)?.xmlTranslationNodes?.get(entry.key) : ''}
<% } %><% } %>

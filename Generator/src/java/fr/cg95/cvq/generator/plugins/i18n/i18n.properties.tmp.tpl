${acronym}.duration.value =
<% steps.each { if (!['document','validation'].contains(it.name)) { %>
${acronym}.step.${it.name}.label =
${acronym}.step.${it.name}.desc =
<% } } %>
<% elements.each { %>
${it.i18nPrefixCode}.help =
${it.i18nPrefixCode}.validationError =
<% if (it.typeClass == "COLLECTION") { %>
${it.i18nPrefixCode}.elementAdditionSuccess =
<% } %>
<% } %>

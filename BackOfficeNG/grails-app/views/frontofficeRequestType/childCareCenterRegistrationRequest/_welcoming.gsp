


  
    <label class="required"><g:message code="cccrr.property.welcomingChoice.label" /> *  <span><g:message code="cccrr.property.welcomingChoice.help" /></span></label>
            <g:set var="welcomingChoiceIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'welcomingChoice', 'i18nPrefixCode':'cccrr.property.welcomingChoice', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.welcomingChoice.entries, 'depth':0]" />
            

  


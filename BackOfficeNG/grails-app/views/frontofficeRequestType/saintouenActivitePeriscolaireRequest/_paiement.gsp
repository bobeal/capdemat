


  
    <label class="required"><g:message code="sapr.property.saprModeReglement.label" /> *  <span><g:message code="sapr.property.saprModeReglement.help" /></span></label>
            <g:set var="saprModeReglementIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'saprModeReglement', 'i18nPrefixCode':'sapr.property.saprModeReglement', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.saprModeReglement.entries, 'depth':0]" />
            

  


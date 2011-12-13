


  
    <label class="required"><g:message code="sisgr.property.modeReglement.label" /> *  <span><g:message code="sisgr.property.modeReglement.help" /></span></label>
            <g:set var="modeReglementIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'modeReglement', 'i18nPrefixCode':'sisgr.property.modeReglement', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.modeReglement.entries, 'depth':0]" />
            

  


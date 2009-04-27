


  
    <label class="required"><g:message code="cwc.property.compostableWasteType.label" /> *  <span><g:message code="cwc.property.compostableWasteType.help" /></span></label>
            <g:set var="compostableWasteTypeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'compostableWasteType', 'i18nPrefixCode':'cwc.property.compostableWasteType', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.compostableWasteType.entries, 'depth':0]" />
            

  

  
    <label class=""><g:message code="cwc.property.otherWaste.label" />   <span><g:message code="cwc.property.otherWaste.help" /></span></label>
            <input type="text" name="otherWaste" value="${rqt.otherWaste}" 
                    class="  validate-string" title="<g:message code="cwc.property.otherWaste.validationError" />"  />
            

  

  
    <label class=""><g:message code="cwc.property.collectionAddress.label" />   <span><g:message code="cwc.property.collectionAddress.help" /></span></label>
            <input type="text" name="collectionAddress" value="${rqt.collectionAddress}" 
                    class="  validate-string" title="<g:message code="cwc.property.collectionAddress.validationError" />"  />
            

  


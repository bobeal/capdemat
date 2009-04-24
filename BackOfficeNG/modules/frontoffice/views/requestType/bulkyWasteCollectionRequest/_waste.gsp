


  
    <label class="required"><g:message code="bwc.property.bulkyWasteType.label" /> *  <span><g:message code="bwc.property.bulkyWasteType.help" /></span></label>
            <g:set var="bulkyWasteTypeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'bulkyWasteType', 'i18nPrefixCode':'bwc.property.bulkyWasteType', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.bulkyWasteType.entries, 'depth':0]" />
            

  

  
    <label class=""><g:message code="bwc.property.otherWaste.label" />   <span><g:message code="bwc.property.otherWaste.help" /></span></label>
            <input type="text" name="otherWaste" value="${rqt.otherWaste}" 
                    class="  validate-string" title="<g:message code="bwc.property.otherWaste.validationError" />"  />
            

  

  
    <label class=""><g:message code="bwc.property.collectionAddress.label" />   <span><g:message code="bwc.property.collectionAddress.help" /></span></label>
            <input type="text" name="collectionAddress" value="${rqt.collectionAddress}" 
                    class="  validate-string" title="<g:message code="bwc.property.collectionAddress.validationError" />"  />
            

  


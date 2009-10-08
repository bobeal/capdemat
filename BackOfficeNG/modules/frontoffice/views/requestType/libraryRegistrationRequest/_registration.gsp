


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="lrr.property.subscription.label" /> *  <span><g:message code="lrr.property.subscription.help" /></span></label>
            <g:set var="subscriptionIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'subscription', 'i18nPrefixCode':'lrr.property.subscription', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.subscription.entries, 'depth':0]" />
            

  


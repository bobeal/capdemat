


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="msrr.property.activity.label" /> *  <span><g:message code="msrr.property.activity.help" /></span></label>
            <g:set var="activityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'activity', 'i18nPrefixCode':'msrr.property.activity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.activity.entries, 'depth':0]" />
            

  


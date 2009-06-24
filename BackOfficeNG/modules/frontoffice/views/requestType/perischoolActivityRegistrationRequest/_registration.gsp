


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first " title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="parr.property.perischoolActivity.label" /> *  <span><g:message code="parr.property.perischoolActivity.help" /></span></label>
            <g:set var="perischoolActivityIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'perischoolActivity', 'i18nPrefixCode':'parr.property.perischoolActivity', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.perischoolActivity.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="parr.property.urgencyPhone.label" /> *  <span><g:message code="parr.property.urgencyPhone.help" /></span></label>
            <input type="text" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone" title="<g:message code="parr.property.urgencyPhone.validationError" />"  maxLength="10"/>
            

  


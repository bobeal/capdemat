


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" class="required validate-not-first autofill-subjectFilling-trigger" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class=""><g:message code="sms.property.mobilePhone.label" />   <span><g:message code="sms.property.mobilePhone.help" /></span></label>
            <input type="text" name="mobilePhone" value="${rqt.mobilePhone}" 
                    class=" autofill-subjectFilling-listener-MobilePhone validate-phone" title="<g:message code="sms.property.mobilePhone.validationError" />"  maxLength="10"/>
            

  

  
    <label class="required"><g:message code="sms.property.subscription.label" /> *  <span><g:message code="sms.property.subscription.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-boolean" title="" value="${it}" name="subscription" ${it == rqt.subscription ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sms.property.interests.label" /> *  <span><g:message code="sms.property.interests.help" /></span></label>
            <g:set var="interestsIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'interests', 'i18nPrefixCode':'sms.property.interests', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.interests.entries, 'depth':0]" />
            

  


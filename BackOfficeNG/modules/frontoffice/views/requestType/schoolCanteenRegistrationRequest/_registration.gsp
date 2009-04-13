


  
    <label class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select name="subjectId" class="required validate-not-first" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label class="required"><g:message code="scrr.property.urgencyPhone.label" /> *  <span><g:message code="scrr.property.urgencyPhone.help" /></span></label>
            <input type="text" name="urgencyPhone" value="${rqt.urgencyPhone}" 
                    class="required validate-phone" title="<g:message code="scrr.property.urgencyPhone.validationError" />"  maxLength="10"/>
            

  

  
    <label class="required"><g:message code="scrr.property.foodDiet.label" /> *  <span><g:message code="scrr.property.foodDiet.help" /></span></label>
            <g:set var="foodDietIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'foodDiet', 'i18nPrefixCode':'scrr.property.foodDiet', 'htmlClass':'required ', 
                              'lrEntries': lrTypes.foodDiet.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="scrr.property.canteenAttendingDays.label" /> *  <span><g:message code="scrr.property.canteenAttendingDays.help" /></span></label>
            <g:set var="canteenAttendingDaysIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'canteenAttendingDays', 'i18nPrefixCode':'scrr.property.canteenAttendingDays', 'htmlClass':'required ', 
                              'lrEntries': lrTypes.canteenAttendingDays.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="scrr.property.foodAllergy.label" /> *  <span><g:message code="scrr.property.foodAllergy.help" /></span></label>
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="foodAllergy" ${it == rqt.foodAllergy ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="scrr.property.doctorName.label" />   <span><g:message code="scrr.property.doctorName.help" /></span></label>
            <input type="text" name="doctorName" value="${rqt.doctorName}" 
                    class=" validate-string" title="<g:message code="scrr.property.doctorName.validationError" />"  />
            

  

  
    <label class=""><g:message code="scrr.property.doctorPhone.label" />   <span><g:message code="scrr.property.doctorPhone.help" /></span></label>
            <input type="text" name="doctorPhone" value="${rqt.doctorPhone}" 
                    class=" validate-phone" title="<g:message code="scrr.property.doctorPhone.validationError" />"  maxLength="10"/>
            

  


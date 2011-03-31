


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first  ${stepStates != null && stepStates['registration']?.invalidFields?.contains('subjectId') ? 'validation-failed' : ''}" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="urgencyPhone" class="required"><g:message code="scrr.property.urgencyPhone.label" /> *  <span><g:message code="scrr.property.urgencyPhone.help" /></span></label>
            <input type="text" id="urgencyPhone" name="urgencyPhone" value="${rqt.urgencyPhone?.toString()}" 
                    class="required  validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('urgencyPhone') ? 'validation-failed' : ''}" title="<g:message code="scrr.property.urgencyPhone.validationError" />"  maxlength="10" />
            

  

  
    <label class="required"><g:message code="scrr.property.foodDiet.label" /> *  <span><g:message code="scrr.property.foodDiet.help" /></span></label>
            <g:set var="foodDietIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'foodDiet', 'i18nPrefixCode':'scrr.property.foodDiet', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.foodDiet.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="scrr.property.canteenAttendingDays.label" /> *  <span><g:message code="scrr.property.canteenAttendingDays.help" /></span></label>
            <g:set var="canteenAttendingDaysIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'canteenAttendingDays', 'i18nPrefixCode':'scrr.property.canteenAttendingDays', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.canteenAttendingDays.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="scrr.property.foodAllergy.label" /> *  <span><g:message code="scrr.property.foodAllergy.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['registration']?.invalidFields?.contains('foodAllergy') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="foodAllergy_${it ? 'yes' : 'no'}" class="required condition-foodAllergy-trigger  validate-one-required boolean" title="" value="${it}" name="foodAllergy" ${it == rqt.foodAllergy ? 'checked="checked"': ''} />
                <label for="foodAllergy_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="whichFoodAllergy" class="required condition-foodAllergy-filled"><g:message code="scrr.property.whichFoodAllergy.label" /> *  <span><g:message code="scrr.property.whichFoodAllergy.help" /></span></label>
            <input type="text" id="whichFoodAllergy" name="whichFoodAllergy" value="${rqt.whichFoodAllergy?.toString()}" 
                    class="required condition-foodAllergy-filled  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('whichFoodAllergy') ? 'validation-failed' : ''}" title="<g:message code="scrr.property.whichFoodAllergy.validationError" />"   />
            

  

  
    <label for="doctorName" class=""><g:message code="scrr.property.doctorName.label" />   <span><g:message code="scrr.property.doctorName.help" /></span></label>
            <input type="text" id="doctorName" name="doctorName" value="${rqt.doctorName?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['registration']?.invalidFields?.contains('doctorName') ? 'validation-failed' : ''}" title="<g:message code="scrr.property.doctorName.validationError" />"   />
            

  

  
    <label for="doctorPhone" class=""><g:message code="scrr.property.doctorPhone.label" />   <span><g:message code="scrr.property.doctorPhone.help" /></span></label>
            <input type="text" id="doctorPhone" name="doctorPhone" value="${rqt.doctorPhone?.toString()}" 
                    class="  validate-phone ${stepStates != null && stepStates['registration']?.invalidFields?.contains('doctorPhone') ? 'validation-failed' : ''}" title="<g:message code="scrr.property.doctorPhone.validationError" />"  maxlength="10" />
            

  


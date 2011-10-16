


  
    <label class="required"><g:message code="llrr.property.llrrSubscription.label" /> *  <span><g:message code="llrr.property.llrrSubscription.help" /></span></label>
            <g:set var="llrrSubscriptionIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'llrrSubscription', 'i18nPrefixCode':'llrr.property.llrrSubscription', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.llrrSubscription.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="llrr.property.llrrBirthDate.label" /> *  <span><g:message code="llrr.property.llrrBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['registration'].invalidFields.contains('llrrBirthDate') ? 'validation-failed' : ''}"
                id="llrrBirthDate_day"
                name="llrrBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.llrrBirthDate?.date == it
                      || (rqt.llrrBirthDate == null && params['llrrBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['registration'].invalidFields.contains('llrrBirthDate') ? 'validation-failed' : ''}"
                id="llrrBirthDate_month"
                name="llrrBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.llrrBirthDate?.month == (it - 1)
                      || (rqt.llrrBirthDate == null && params['llrrBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['registration'].invalidFields.contains('llrrBirthDate') ? 'validation-failed' : ''}"
                id="llrrBirthDate_year"
                name="llrrBirthDate_year"
                value="${rqt.llrrBirthDate ? rqt.llrrBirthDate.year + 1900 : params['llrrBirthDate_year']}"
                title="<g:message code="llrr.property.llrrBirthDate.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="llrr.property.llrrCareer.label" /> *  <span><g:message code="llrr.property.llrrCareer.help" /></span></label>
            <g:set var="llrrCareerIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'llrrCareer', 'i18nPrefixCode':'llrr.property.llrrCareer', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.llrrCareer.entries, 'depth':0]" />
            

  

  
    <label class=""><g:message code="llrr.property.llrrSchoolType.label" />   <span><g:message code="llrr.property.llrrSchoolType.help" /></span></label>
            <g:set var="llrrSchoolTypeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'llrrSchoolType', 'i18nPrefixCode':'llrr.property.llrrSchoolType', 'htmlClass':'  ', 
                              'lrEntries': lrTypes.llrrSchoolType.entries, 'depth':0]" />
            

  

  
    <label for="llrrSchoolName" class=""><g:message code="llrr.property.llrrSchoolName.label" />   <span><g:message code="llrr.property.llrrSchoolName.help" /></span></label>
            <input type="text" id="llrrSchoolName" name="llrrSchoolName" value="${rqt.llrrSchoolName?.toString()}" 
                    class="  validate-string ${rqt.stepStates['registration'].invalidFields.contains('llrrSchoolName') ? 'validation-failed' : ''}" title="<g:message code="llrr.property.llrrSchoolName.validationError" />"   />
            

  

  
    <label for="llrrSchoolClass" class=""><g:message code="llrr.property.llrrSchoolClass.label" />   <span><g:message code="llrr.property.llrrSchoolClass.help" /></span></label>
            <input type="text" id="llrrSchoolClass" name="llrrSchoolClass" value="${rqt.llrrSchoolClass?.toString()}" 
                    class="  validate-string ${rqt.stepStates['registration'].invalidFields.contains('llrrSchoolClass') ? 'validation-failed' : ''}" title="<g:message code="llrr.property.llrrSchoolClass.validationError" />"   />
            

  


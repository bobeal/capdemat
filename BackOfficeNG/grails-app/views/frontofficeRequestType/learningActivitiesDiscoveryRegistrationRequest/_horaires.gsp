


  
    <label class="required"><g:message code="ladrr.property.atelierEveil.label" /> *  <span><g:message code="ladrr.property.atelierEveil.help" /></span></label>
            <g:set var="atelierEveilIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'atelierEveil', 'i18nPrefixCode':'ladrr.property.atelierEveil', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.atelierEveil.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="ladrr.property.dateInscription.label" /> *  <span><g:message code="ladrr.property.dateInscription.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${stepStates != null && stepStates['horaires']?.invalidFields.contains('dateInscription') ? 'validation-failed' : ''}"
                id="dateInscription_day"
                name="dateInscription_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.dateInscription?.date == it
                      || (rqt.dateInscription == null && params['dateInscription_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${stepStates != null && stepStates['horaires']?.invalidFields.contains('dateInscription') ? 'validation-failed' : ''}"
                id="dateInscription_month"
                name="dateInscription_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.dateInscription?.month == (it - 1)
                      || (rqt.dateInscription == null && params['dateInscription_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${stepStates != null && stepStates['horaires']?.invalidFields.contains('dateInscription') ? 'validation-failed' : ''}"
                id="dateInscription_year"
                name="dateInscription_year"
                value="${rqt.dateInscription ? rqt.dateInscription.year + 1900 : params['dateInscription_year']}"
                title="<g:message code="ladrr.property.dateInscription.validationError" />" />
            </div>
            

  

  
    <label class="required"><g:message code="ladrr.property.jour.label" /> *  <span><g:message code="ladrr.property.jour.help" /></span></label>
            <g:set var="jourIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'jour', 'i18nPrefixCode':'ladrr.property.jour', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.jour.entries, 'depth':0]" />
            

  

  
    <label class="required"><g:message code="ladrr.property.horaires.label" /> *  <span><g:message code="ladrr.property.horaires.help" /></span></label>
            <g:set var="horairesIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'horaires', 'i18nPrefixCode':'ladrr.property.horaires', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.horaires.entries, 'depth':0]" />
            

  


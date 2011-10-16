


  
    <label for="selectedRequestType" class="required"><g:message code="lcr.property.selectedRequestType.label" /> *  <span><g:message code="lcr.property.selectedRequestType.help" /></span></label>
            <select id="selectedRequestType" name="selectedRequestType" class="required condition-isExtension-trigger  validate-not-first ${rqt.stepStates['work'].invalidFields.contains('selectedRequestType') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.selectedRequestType.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['INITIAL','EXTENSION']}">
                <option value="${it}" ${it == rqt.selectedRequestType?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="lcr.property.selectedRequestType" /></option>
              </g:each>
            </select>
            

  

  
    <label for="autorizationNumber" class="required condition-isExtension-filled"><g:message code="lcr.property.autorizationNumber.label" /> *  <span><g:message code="lcr.property.autorizationNumber.help" /></span></label>
            <input type="text" id="autorizationNumber" name="autorizationNumber" value="${rqt.autorizationNumber?.toString()}" 
                    class="required condition-isExtension-filled  validate-string ${rqt.stepStates['work'].invalidFields.contains('autorizationNumber') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.autorizationNumber.validationError" />"   />
            

  

  
    <label for="lcrCompteDe" class="required"><g:message code="lcr.property.lcrCompteDe.label" /> *  <span><g:message code="lcr.property.lcrCompteDe.help" /></span></label>
            <input type="text" id="lcrCompteDe" name="lcrCompteDe" value="${rqt.lcrCompteDe?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrCompteDe') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrCompteDe.validationError" />"   />
            

  

  
    <label for="lcrWorkAddress" class="required"><g:message code="lcr.property.lcrWorkAddress.label" /> *  <span><g:message code="lcr.property.lcrWorkAddress.help" /></span></label>
            <textarea id="lcrWorkAddress" name="lcrWorkAddress" class="required  validate-textarea ${rqt.stepStates['work'].invalidFields.contains('lcrWorkAddress') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrWorkAddress.validationError" />" rows="5" cols=""  >${rqt.lcrWorkAddress}</textarea>
            

  

  
    <label for="lcrWorkNature" class="required"><g:message code="lcr.property.lcrWorkNature.label" /> *  <span><g:message code="lcr.property.lcrWorkNature.help" /></span></label>
            <textarea id="lcrWorkNature" name="lcrWorkNature" class="required  validate-textarea ${rqt.stepStates['work'].invalidFields.contains('lcrWorkNature') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrWorkNature.validationError" />" rows="3" cols=""  >${rqt.lcrWorkNature}</textarea>
            

  

  
    <label for="lcrDuration" class="required"><g:message code="lcr.property.lcrDuration.label" /> *  <span><g:message code="lcr.property.lcrDuration.help" /></span></label>
            <input type="text" id="lcrDuration" name="lcrDuration" value="${rqt.lcrDuration?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrDuration') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrDuration.validationError" />"   />
            

  

  
    <label for="lcrStartWork" class="required"><g:message code="lcr.property.lcrStartWork.label" /> *  <span><g:message code="lcr.property.lcrStartWork.help" /></span></label>
            <input type="text" id="lcrStartWork" name="lcrStartWork" value="${rqt.lcrStartWork?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrStartWork') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrStartWork.validationError" />"   />
            

  

  
    <label for="lcrEndWork" class="required"><g:message code="lcr.property.lcrEndWork.label" /> *  <span><g:message code="lcr.property.lcrEndWork.help" /></span></label>
            <input type="text" id="lcrEndWork" name="lcrEndWork" value="${rqt.lcrEndWork?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['work'].invalidFields.contains('lcrEndWork') ? 'validation-failed' : ''}" title="<g:message code="lcr.property.lcrEndWork.validationError" />"   />
            

  

  
    <div class="collection required summary-box">
      <h4 class="required"><g:message code="lcr.property.lcrDescription.label" /> 
        <span><g:message code="lcr.property.lcrDescription.help" /></span>
      </h4>
      <p>
        <g:message code="request.message.howToAddCollectionItem" />
        <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'work', 'currentCollection':'lcrDescription', 'collectionIndex':(rqt.lcrDescription ? rqt.lcrDescription.size() : 0)])}" style="font-size:1.3em;" />
          ${message(code:'request.action.newCollectionItem')}
        </a>
      </p>
    <g:each var="it" in="${rqt.lcrDescription}" status="index">
      <div class="item">
        <dl>
        <dt class="head"><g:message code="lcr.property.lcrDescription.label" /> : ${index + 1}</dt>
        <dd class="head">
          <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id':rqt.id, 'currentStep':'work', 'currentCollection':'lcrDescription', 'collectionIndex':index])}">
           ${message(code:'request.action.editCollectionItem')}
         </a>&nbsp;
         <a href="${createLink(controller : 'frontofficeRequest', action : 'collectionRemove', params:['id':rqt.id, 'currentStep':'work', 'currentCollection':'lcrDescription', 'collectionIndex':index])}">
           ${message(code:'request.action.deleteCollectionItem')}
         </a>
        </dd>
    
        <dt><g:message code="lcr.property.lcrDetailDescription.label" /></dt>
        
              <dd class="${rqt.stepStates['work'].invalidFields.contains('lcrDescription[' + index + '].lcrDetailDescription') ? 'validation-failed' : ''}">
                <g:if test="${it.lcrDetailDescription}">
                  <g:capdematEnumToField var="${it.lcrDetailDescription}" i18nKeyPrefix="lcr.property.lcrDetailDescription" />
                </g:if>
              </dd>
              
    
        <dt><g:message code="lcr.property.lcrDetailLength.label" /></dt>
        <dd class="${rqt.stepStates['work'].invalidFields.contains('lcrDescription[' + index + '].lcrDetailLength') ? 'validation-failed' : ''}">${it.lcrDetailLength?.toString()}</dd>
    
        <dt><g:message code="lcr.property.lcrDetailWidth.label" /></dt>
        <dd class="${rqt.stepStates['work'].invalidFields.contains('lcrDescription[' + index + '].lcrDetailWidth') ? 'validation-failed' : ''}">${it.lcrDetailWidth?.toString()}</dd>
    
        <dt><g:message code="lcr.property.lcrDetailHeight.label" /></dt>
        <dd class="${rqt.stepStates['work'].invalidFields.contains('lcrDescription[' + index + '].lcrDetailHeight') ? 'validation-failed' : ''}">${it.lcrDetailHeight?.toString()}</dd>
    
        <dt><g:message code="lcr.property.lcrDetailOther.label" /></dt>
        <dd class="${rqt.stepStates['work'].invalidFields.contains('lcrDescription[' + index + '].lcrDetailOther') ? 'validation-failed' : ''}">${it.lcrDetailOther?.toString()}</dd>
    
        </dl>
      </div>
    </g:each>
    </div>
  


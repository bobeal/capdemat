


  
    <label class="required"><g:message code="scssr.property.vousVivezAvec.label" /> *  <span><g:message code="scssr.property.vousVivezAvec.help" /></span></label>
            <ul class="required ${rqt.stepStates['compositionFamille'].invalidFields.contains('vousVivezAvec') ? 'validation-failed' : ''}">
              <g:each in="${['DEUX_PARENTS','UN_PARENT','AUTRES']}">
              <li>
                <input type="radio" id="vousVivezAvec_${it}" class="required condition-vousVivezAvecAutre-trigger  validate-one-required" value="${it}" name="vousVivezAvec" ${it == rqt.vousVivezAvec.toString() ? 'checked="checked"': ''} title="<g:message code="scssr.property.vousVivezAvec.validationError" />" />
                <label for="vousVivezAvec_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scssr.property.vousVivezAvec" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="precisionsCompositionFamille" class="required condition-vousVivezAvecAutre-filled"><g:message code="scssr.property.precisionsCompositionFamille.label" /> *  <span><g:message code="scssr.property.precisionsCompositionFamille.help" /></span></label>
            <textarea id="precisionsCompositionFamille" name="precisionsCompositionFamille" class="required condition-vousVivezAvecAutre-filled  validate-textarea ${rqt.stepStates['compositionFamille'].invalidFields.contains('precisionsCompositionFamille') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.precisionsCompositionFamille.validationError" />" rows="5" cols=""  maxlength="1024">${rqt.precisionsCompositionFamille}</textarea>
            

  

  
    <fieldset class="required">
    <legend><g:message code="scssr.property.nombreIndividusFoyer.label" /></legend>
    
      <label for="nombreAdultesMajeurs" class="required"><g:message code="scssr.property.nombreAdultesMajeurs.label" /> *  <span><g:message code="scssr.property.nombreAdultesMajeurs.help" /></span></label>
            <input type="text" id="nombreAdultesMajeurs" name="nombreAdultesMajeurs" value="${rqt.nombreAdultesMajeurs?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['compositionFamille'].invalidFields.contains('nombreAdultesMajeurs') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.nombreAdultesMajeurs.validationError" />"   />
            

    
      <label for="nombreEnfantsMineurs" class="required"><g:message code="scssr.property.nombreEnfantsMineurs.label" /> *  <span><g:message code="scssr.property.nombreEnfantsMineurs.help" /></span></label>
            <input type="text" id="nombreEnfantsMineurs" name="nombreEnfantsMineurs" value="${rqt.nombreEnfantsMineurs?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['compositionFamille'].invalidFields.contains('nombreEnfantsMineurs') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.nombreEnfantsMineurs.validationError" />"   />
            

    
    </fieldset>
  


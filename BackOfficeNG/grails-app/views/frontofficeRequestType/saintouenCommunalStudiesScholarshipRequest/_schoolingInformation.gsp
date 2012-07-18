


  
    <label for="saintOuenEstablishmentLabel" class="required"><g:message code="scssr.property.saintOuenEstablishmentLabel.label" /> *  <span><g:message code="scssr.property.saintOuenEstablishmentLabel.help" /></span></label>
            <input type="text" id="saintOuenEstablishmentLabel" name="saintOuenEstablishmentLabel" value="${rqt.saintOuenEstablishmentLabel?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['schoolingInformation'].invalidFields.contains('saintOuenEstablishmentLabel') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenEstablishmentLabel.validationError" />"   />
            

  

  
    <label for="saintOuenEtablissementTelephone" class="required"><g:message code="scssr.property.saintOuenEtablissementTelephone.label" /> *  <span><g:message code="scssr.property.saintOuenEtablissementTelephone.help" /></span></label>
            <input type="text" id="saintOuenEtablissementTelephone" name="saintOuenEtablissementTelephone" value="${rqt.saintOuenEtablissementTelephone?.toString()}" 
                    class="required  validate-phone ${rqt.stepStates['schoolingInformation'].invalidFields.contains('saintOuenEtablissementTelephone') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenEtablissementTelephone.validationError" />"  maxlength="10" />
            

  

  
    <label for="saintOuenIsInOtherStudies" class="required"><g:message code="scssr.property.saintOuenIsInOtherStudies.label" /> *  <span><g:message code="scssr.property.saintOuenIsInOtherStudies.help" /></span></label>
            <select id="saintOuenIsInOtherStudies" name="saintOuenIsInOtherStudies" class="required condition-saintOuenIsInOtherStudies-trigger  validate-not-first ${rqt.stepStates['schoolingInformation'].invalidFields.contains('saintOuenIsInOtherStudies') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenIsInOtherStudies.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['LICENCE','LICENCE_PRO','MASTER','BTS','DUT','OTHER_STUDIES']}">
                <option value="${it}" ${it == rqt.saintOuenIsInOtherStudies?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scssr.property.saintOuenIsInOtherStudies" /></option>
              </g:each>
            </select>
            

  

  
    <label for="saintOuenOtherStudiesLabel" class="required condition-saintOuenIsInOtherStudies-filled"><g:message code="scssr.property.saintOuenOtherStudiesLabel.label" /> *  <span><g:message code="scssr.property.saintOuenOtherStudiesLabel.help" /></span></label>
            <input type="text" id="saintOuenOtherStudiesLabel" name="saintOuenOtherStudiesLabel" value="${rqt.saintOuenOtherStudiesLabel?.toString()}" 
                    class="required condition-saintOuenIsInOtherStudies-filled  validate-string ${rqt.stepStates['schoolingInformation'].invalidFields.contains('saintOuenOtherStudiesLabel') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenOtherStudiesLabel.validationError" />"   />
            

  

  
    <label for="saintOuenCurrentStudiesLevel" class="required"><g:message code="scssr.property.saintOuenCurrentStudiesLevel.label" /> *  <span><g:message code="scssr.property.saintOuenCurrentStudiesLevel.help" /></span></label>
            <select id="saintOuenCurrentStudiesLevel" name="saintOuenCurrentStudiesLevel" class="required  validate-not-first ${rqt.stepStates['schoolingInformation'].invalidFields.contains('saintOuenCurrentStudiesLevel') ? 'validation-failed' : ''}" title="<g:message code="scssr.property.saintOuenCurrentStudiesLevel.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['FIRST_YEAR','SECOND_YEAR','THIRD_YEAR','FOURTH_YEAR','FIRTH_YEAR']}">
                <option value="${it}" ${it == rqt.saintOuenCurrentStudiesLevel?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scssr.property.saintOuenCurrentStudiesLevel" /></option>
              </g:each>
            </select>
            

  





  
    <label class="required"><g:message code="serrr.property.situation.label" /> *  <span><g:message code="serrr.property.situation.help" /></span></label>
            <ul class="required ${rqt.stepStates['situation'].invalidFields.contains('situation') ? 'validation-failed' : ''}">
              <g:each in="${['PREMIERE_INSCRIPTION','DEMENAGEMENT_MEME_COMMUNE','CHANGEMENT_COMMUNE']}">
              <li>
                <input type="radio" id="situation_${it}" class="required condition-estChangementCommune-trigger  validate-one-required" value="${it}" name="situation" ${it == rqt.situation.toString() ? 'checked="checked"': ''} title="<g:message code="serrr.property.situation.validationError" />" />
                <label for="situation_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.situation" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <fieldset class="required condition-estChangementCommune-filled">
    <legend><g:message code="serrr.property.precedentLieuInscription.label" /></legend>
    
      <label for="ancienneCommune" class="required"><g:message code="serrr.property.ancienneCommune.label" /> *  <span><g:message code="serrr.property.ancienneCommune.help" /></span></label>
            <input type="text" id="ancienneCommune" name="ancienneCommune" value="${rqt.ancienneCommune?.toString()}" 
                    class="required  validate-city ${rqt.stepStates['situation'].invalidFields.contains('ancienneCommune') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.ancienneCommune.validationError" />"  maxlength="32" />
            

    
      <label for="departementAncienneCommune" class="required"><g:message code="serrr.property.departementAncienneCommune.label" /> *  <span><g:message code="serrr.property.departementAncienneCommune.help" /></span></label>
            <select id="departementAncienneCommune" name="departementAncienneCommune" class="required  validate-not-first ${rqt.stepStates['situation'].invalidFields.contains('departementAncienneCommune') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.departementAncienneCommune.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','D_E_P01','D_E_P02','D_E_P03','D_E_P04','D_E_P05','D_E_P06','D_E_P07','D_E_P08','D_E_P09','D_E_P10','D_E_P11','D_E_P12','D_E_P13','D_E_P14','D_E_P15','D_E_P16','D_E_P17','D_E_P18','D_E_P19','D_E_P2_A','D_E_P2_B','D_E_P21','D_E_P22','D_E_P23','D_E_P24','D_E_P25','D_E_P26','D_E_P27','D_E_P28','D_E_P29','D_E_P30','D_E_P31','D_E_P32','D_E_P33','D_E_P34','D_E_P35','D_E_P36','D_E_P37','D_E_P38','D_E_P39','D_E_P40','D_E_P41','D_E_P42','D_E_P43','D_E_P44','D_E_P45','D_E_P46','D_E_P47','D_E_P48','D_E_P49','D_E_P50','D_E_P51','D_E_P52','D_E_P53','D_E_P54','D_E_P55','D_E_P56','D_E_P57','D_E_P58','D_E_P59','D_E_P60','D_E_P61','D_E_P62','D_E_P63','D_E_P64','D_E_P65','D_E_P66','D_E_P67','D_E_P68','D_E_P69','D_E_P70','D_E_P71','D_E_P72','D_E_P73','D_E_P74','D_E_P75','D_E_P76','D_E_P77','D_E_P78','D_E_P79','D_E_P80','D_E_P81','D_E_P82','D_E_P83','D_E_P84','D_E_P85','D_E_P86','D_E_P87','D_E_P88','D_E_P89','D_E_P90','D_E_P91','D_E_P92','D_E_P93','D_E_P94','D_E_P95','D_E_P971','D_E_P972','D_E_P973','D_E_P974']}">
                <option value="${it}" ${it == rqt.departementAncienneCommune?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.departementAncienneCommune" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  


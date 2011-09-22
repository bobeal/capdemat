


  
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
              <g:each in="${['NONE','D_E_P_01','D_E_P_02','D_E_P_03','D_E_P_04','D_E_P_05','D_E_P_06','D_E_P_07','D_E_P_08','D_E_P_09','D_E_P_10','D_E_P_11','D_E_P_12','D_E_P_13','D_E_P_14','D_E_P_15','D_E_P_16','D_E_P_17','D_E_P_18','D_E_P_19','D_E_P_2_A','D_E_P_2_B','D_E_P_21','D_E_P_22','D_E_P_23','D_E_P_24','D_E_P_25','D_E_P_26','D_E_P_27','D_E_P_28','D_E_P_29','D_E_P_30','D_E_P_31','D_E_P_32','D_E_P_33','D_E_P_34','D_E_P_35','D_E_P_36','D_E_P_37','D_E_P_38','D_E_P_39','D_E_P_40','D_E_P_41','D_E_P_42','D_E_P_43','D_E_P_44','D_E_P_45','D_E_P_46','D_E_P_47','D_E_P_48','D_E_P_49','D_E_P_50','D_E_P_51','D_E_P_52','D_E_P_53','D_E_P_54','D_E_P_55','D_E_P_56','D_E_P_57','D_E_P_58','D_E_P_59','D_E_P_60','D_E_P_61','D_E_P_62','D_E_P_63','D_E_P_64','D_E_P_65','D_E_P_66','D_E_P_67','D_E_P_68','D_E_P_69','D_E_P_70','D_E_P_71','D_E_P_72','D_E_P_73','D_E_P_74','D_E_P_75','D_E_P_76','D_E_P_77','D_E_P_78','D_E_P_79','D_E_P_80','D_E_P_81','D_E_P_82','D_E_P_83','D_E_P_84','D_E_P_85','D_E_P_86','D_E_P_87','D_E_P_88','D_E_P_89','D_E_P_90','D_E_P_91','D_E_P_92','D_E_P_93','D_E_P_94','D_E_P_95','D_E_P_971','D_E_P_972','D_E_P_973','D_E_P_974']}">
                <option value="${it}" ${it == rqt.departementAncienneCommune?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.departementAncienneCommune" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  


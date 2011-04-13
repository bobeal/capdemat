


  
    <fieldset class="required">
    <legend><g:message code="mcr.property.familySituationInformation.label" /></legend>
    
      <label for="aliveChildren" class="required"><g:message code="mcr.property.aliveChildren.label" /> *  <span><g:message code="mcr.property.aliveChildren.help" /></span></label>
            <input type="text" id="aliveChildren" name="aliveChildren" value="${rqt.aliveChildren?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['situation'].invalidFields.contains('aliveChildren') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.aliveChildren.validationError" />"   />
            

    
      <label for="childStatus" class="required"><g:message code="mcr.property.childStatus.label" /> *  <span><g:message code="mcr.property.childStatus.help" /></span></label>
            <select id="childStatus" name="childStatus" class="required  validate-not-first ${rqt.stepStates['situation'].invalidFields.contains('childStatus') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['MARRIED','SINGLE','DIVORCED','WIDOW','COMMON_LAW_MARRIAGE','SEPARATED','P_A_C_S','OTHER']}">
                <option value="${it}" ${it == rqt.childStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childStatus" /></option>
              </g:each>
            </select>
            

    
      <label for="childrenInCharge" class="required"><g:message code="mcr.property.childrenInCharge.label" /> *  <span><g:message code="mcr.property.childrenInCharge.help" /></span></label>
            <input type="text" id="childrenInCharge" name="childrenInCharge" value="${rqt.childrenInCharge?.toString()}" 
                    class="required  validate-positiveInteger ${rqt.stepStates['situation'].invalidFields.contains('childrenInCharge') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childrenInCharge.validationError" />"   />
            

    
      <label for="otherSituation" class=""><g:message code="mcr.property.otherSituation.label" />   <span><g:message code="mcr.property.otherSituation.help" /></span></label>
            <input type="text" id="otherSituation" name="otherSituation" value="${rqt.otherSituation?.toString()}" 
                    class="  validate-string ${rqt.stepStates['situation'].invalidFields.contains('otherSituation') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.otherSituation.validationError" />"   />
            

    
      <label class="required"><g:message code="mcr.property.statePupil.label" /> *  <span><g:message code="mcr.property.statePupil.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['situation'].invalidFields.contains('statePupil') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="statePupil_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="statePupil" ${it == rqt.statePupil ? 'checked="checked"': ''} />
                <label for="statePupil_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="mcr.property.prefectPupil.label" /> *  <span><g:message code="mcr.property.prefectPupil.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['situation'].invalidFields.contains('prefectPupil') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="prefectPupil_${it ? 'yes' : 'no'}" class="required condition-isPrefectPupil-trigger  validate-one-required boolean" title="" value="${it}" name="prefectPupil" ${it == rqt.prefectPupil ? 'checked="checked"': ''} />
                <label for="prefectPupil_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="prefectPupilDepartment" class="required condition-isPrefectPupil-filled"><g:message code="mcr.property.prefectPupilDepartment.label" /> *  <span><g:message code="mcr.property.prefectPupilDepartment.help" /></span></label>
            <select id="prefectPupilDepartment" name="prefectPupilDepartment" class="required condition-isPrefectPupil-filled  validate-not-first ${rqt.stepStates['situation'].invalidFields.contains('prefectPupilDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.prefectPupilDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','D_E_P_01','D_E_P_02','D_E_P_03','D_E_P_04','D_E_P_05','D_E_P_06','D_E_P_07','D_E_P_08','D_E_P_09','D_E_P_10','D_E_P_11','D_E_P_12','D_E_P_13','D_E_P_14','D_E_P_15','D_E_P_16','D_E_P_17','D_E_P_18','D_E_P_19','D_E_P_2_A','D_E_P_2_B','D_E_P_21','D_E_P_22','D_E_P_23','D_E_P_24','D_E_P_25','D_E_P_26','D_E_P_27','D_E_P_28','D_E_P_29','D_E_P_30','D_E_P_31','D_E_P_32','D_E_P_33','D_E_P_34','D_E_P_35','D_E_P_36','D_E_P_37','D_E_P_38','D_E_P_39','D_E_P_40','D_E_P_41','D_E_P_42','D_E_P_43','D_E_P_44','D_E_P_45','D_E_P_46','D_E_P_47','D_E_P_48','D_E_P_49','D_E_P_50','D_E_P_51','D_E_P_52','D_E_P_53','D_E_P_54','D_E_P_55','D_E_P_56','D_E_P_57','D_E_P_58','D_E_P_59','D_E_P_60','D_E_P_61','D_E_P_62','D_E_P_63','D_E_P_64','D_E_P_65','D_E_P_66','D_E_P_67','D_E_P_68','D_E_P_69','D_E_P_70','D_E_P_71','D_E_P_72','D_E_P_73','D_E_P_74','D_E_P_75','D_E_P_76','D_E_P_77','D_E_P_78','D_E_P_79','D_E_P_80','D_E_P_81','D_E_P_82','D_E_P_83','D_E_P_84','D_E_P_85','D_E_P_86','D_E_P_87','D_E_P_88','D_E_P_89','D_E_P_90','D_E_P_91','D_E_P_92','D_E_P_93','D_E_P_94','D_E_P_95','D_E_P_971','D_E_P_972','D_E_P_973','D_E_P_974']}">
                <option value="${it}" ${it == rqt.prefectPupilDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.prefectPupilDepartment" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mcr.property.professionalSituationInformation.label" /></legend>
    
      <label for="childSituation" class="required"><g:message code="mcr.property.childSituation.label" /> *  <span><g:message code="mcr.property.childSituation.help" /></span></label>
            <select id="childSituation" name="childSituation" class="required  validate-not-first ${rqt.stepStates['situation'].invalidFields.contains('childSituation') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['COLLEGE','HIGHSCHOOL','STUDENT','EMPLOYEE','APPRENTICE','OTHER','UNKNOWN']}">
                <option value="${it}" ${it == rqt.childSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childSituation" /></option>
              </g:each>
            </select>
            

    
      <label for="childDiploma" class="required"><g:message code="mcr.property.childDiploma.label" /> *  <span><g:message code="mcr.property.childDiploma.help" /></span></label>
            <select id="childDiploma" name="childDiploma" class="required  validate-not-first ${rqt.stepStates['situation'].invalidFields.contains('childDiploma') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childDiploma.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['B_A_C','B_E_P','B_E_P_C','BREVET','C_F_G','C_A_P','D_A_E_U','D_E_A','D_E_U_G','LICENCE','MAITRISE','UNKNOWN']}">
                <option value="${it}" ${it == rqt.childDiploma?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childDiploma" /></option>
              </g:each>
            </select>
            

    
      <label for="childSpeciality" class=""><g:message code="mcr.property.childSpeciality.label" />   <span><g:message code="mcr.property.childSpeciality.help" /></span></label>
            <input type="text" id="childSpeciality" name="childSpeciality" value="${rqt.childSpeciality?.toString()}" 
                    class="  validate-string ${rqt.stepStates['situation'].invalidFields.contains('childSpeciality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childSpeciality.validationError" />"   />
            

    
      <label for="childProfession" class=""><g:message code="mcr.property.childProfession.label" />   <span><g:message code="mcr.property.childProfession.help" /></span></label>
            <input type="text" id="childProfession" name="childProfession" value="${rqt.childProfession?.toString()}" 
                    class="  validate-string ${rqt.stepStates['situation'].invalidFields.contains('childProfession') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childProfession.validationError" />"   />
            

    
    </fieldset>
  


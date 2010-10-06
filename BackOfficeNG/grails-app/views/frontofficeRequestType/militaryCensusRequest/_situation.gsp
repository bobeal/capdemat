


  
    <fieldset class="required">
    <legend><g:message code="mcr.property.familySituationInformation.label" /></legend>
    
      <label for="aliveChildren" class="required"><g:message code="mcr.property.aliveChildren.label" /> *  <span><g:message code="mcr.property.aliveChildren.help" /></span></label>
            <input type="text" id="aliveChildren" name="aliveChildren" value="${rqt.aliveChildren?.toString()}" 
                    class="required  validate-positiveInteger ${stepStates != null && stepStates['situation']?.invalidFields?.contains('aliveChildren') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.aliveChildren.validationError" />"   />
            

    
      <label for="childStatus" class="required"><g:message code="mcr.property.childStatus.label" /> *  <span><g:message code="mcr.property.childStatus.help" /></span></label>
            <select id="childStatus" name="childStatus" class="required  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childStatus') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childStatus.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Married','Single','Divorced','Widow','CommonLawMarriage','PACS','Other']}">
                <option value="fr.cg95.cvq.business.users.FamilyStatusType_${it}" ${it == rqt.childStatus?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childStatus" /></option>
              </g:each>
            </select>
            

    
      <label for="childrenInCharge" class="required"><g:message code="mcr.property.childrenInCharge.label" /> *  <span><g:message code="mcr.property.childrenInCharge.help" /></span></label>
            <input type="text" id="childrenInCharge" name="childrenInCharge" value="${rqt.childrenInCharge?.toString()}" 
                    class="required  validate-positiveInteger ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childrenInCharge') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childrenInCharge.validationError" />"   />
            

    
      <label for="otherSituation" class=""><g:message code="mcr.property.otherSituation.label" />   <span><g:message code="mcr.property.otherSituation.help" /></span></label>
            <input type="text" id="otherSituation" name="otherSituation" value="${rqt.otherSituation?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('otherSituation') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.otherSituation.validationError" />"   />
            

    
      <label class="required"><g:message code="mcr.property.statePupil.label" /> *  <span><g:message code="mcr.property.statePupil.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['situation']?.invalidFields?.contains('statePupil') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="statePupil_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="statePupil" ${it == rqt.statePupil ? 'checked="checked"': ''} />
                <label for="statePupil_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label class="required"><g:message code="mcr.property.prefectPupil.label" /> *  <span><g:message code="mcr.property.prefectPupil.help" /></span></label>
            <ul class="yes-no required ${stepStates != null && stepStates['situation']?.invalidFields?.contains('prefectPupil') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="prefectPupil_${it ? 'yes' : 'no'}" class="required condition-isPrefectPupil-trigger  validate-one-required boolean" title="" value="${it}" name="prefectPupil" ${it == rqt.prefectPupil ? 'checked="checked"': ''} />
                <label for="prefectPupil_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="prefectPupilDepartment" class="required condition-isPrefectPupil-filled"><g:message code="mcr.property.prefectPupilDepartment.label" /> *  <span><g:message code="mcr.property.prefectPupilDepartment.help" /></span></label>
            <select id="prefectPupilDepartment" name="prefectPupilDepartment" class="required condition-isPrefectPupil-filled  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('prefectPupilDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.prefectPupilDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','DEP_01','DEP_02','DEP_03','DEP_04','DEP_05','DEP_06','DEP_07','DEP_08','DEP_09','DEP_10','DEP_11','DEP_12','DEP_13','DEP_14','DEP_15','DEP_16','DEP_17','DEP_18','DEP_19','DEP_2A','DEP_2B','DEP_21','DEP_22','DEP_23','DEP_24','DEP_25','DEP_26','DEP_27','DEP_28','DEP_29','DEP_30','DEP_31','DEP_32','DEP_33','DEP_34','DEP_35','DEP_36','DEP_37','DEP_38','DEP_39','DEP_40','DEP_41','DEP_42','DEP_43','DEP_44','DEP_45','DEP_46','DEP_47','DEP_48','DEP_49','DEP_50','DEP_51','DEP_52','DEP_53','DEP_54','DEP_55','DEP_56','DEP_57','DEP_58','DEP_59','DEP_60','DEP_61','DEP_62','DEP_63','DEP_64','DEP_65','DEP_66','DEP_67','DEP_68','DEP_69','DEP_70','DEP_71','DEP_72','DEP_73','DEP_74','DEP_75','DEP_76','DEP_77','DEP_78','DEP_79','DEP_80','DEP_81','DEP_82','DEP_83','DEP_84','DEP_85','DEP_86','DEP_87','DEP_88','DEP_89','DEP_90','DEP_91','DEP_92','DEP_93','DEP_94','DEP_95','DEP_971','DEP_972','DEP_973','DEP_974']}">
                <option value="fr.cg95.cvq.business.users.InseeDepartementCodeType_${it}" ${it == rqt.prefectPupilDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.prefectPupilDepartment" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mcr.property.professionalSituationInformation.label" /></legend>
    
      <label for="childSituation" class="required"><g:message code="mcr.property.childSituation.label" /> *  <span><g:message code="mcr.property.childSituation.help" /></span></label>
            <select id="childSituation" name="childSituation" class="required  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childSituation') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childSituation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['College','Highschool','Student','Employee','Apprentice','Other','Unknown']}">
                <option value="fr.cg95.cvq.business.request.military.ChildSituationType_${it}" ${it == rqt.childSituation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childSituation" /></option>
              </g:each>
            </select>
            

    
      <label for="childDiploma" class="required"><g:message code="mcr.property.childDiploma.label" /> *  <span><g:message code="mcr.property.childDiploma.help" /></span></label>
            <select id="childDiploma" name="childDiploma" class="required  validate-not-first ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childDiploma') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childDiploma.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['BAC','BEP','BEPC','Brevet','CFG','CAP','DAEU','DEA','DEUG','Licence','Maitrise','Unknown']}">
                <option value="fr.cg95.cvq.business.request.military.ChildDiplomaType_${it}" ${it == rqt.childDiploma?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childDiploma" /></option>
              </g:each>
            </select>
            

    
      <label for="childSpeciality" class=""><g:message code="mcr.property.childSpeciality.label" />   <span><g:message code="mcr.property.childSpeciality.help" /></span></label>
            <input type="text" id="childSpeciality" name="childSpeciality" value="${rqt.childSpeciality?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childSpeciality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childSpeciality.validationError" />"   />
            

    
      <label for="childProfession" class=""><g:message code="mcr.property.childProfession.label" />   <span><g:message code="mcr.property.childProfession.help" /></span></label>
            <input type="text" id="childProfession" name="childProfession" value="${rqt.childProfession?.toString()}" 
                    class="  validate-string ${stepStates != null && stepStates['situation']?.invalidFields?.contains('childProfession') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.childProfession.validationError" />"   />
            

    
    </fieldset>
  


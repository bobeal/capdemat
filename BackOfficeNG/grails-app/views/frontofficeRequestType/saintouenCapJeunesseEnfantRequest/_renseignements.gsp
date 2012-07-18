


  
    <label class="required"><g:message code="scjer.property.typeInscription.label" /> *  <span><g:message code="scjer.property.typeInscription.help" /></span></label>
            <ul class="required ${rqt.stepStates['renseignements'].invalidFields.contains('typeInscription') ? 'validation-failed' : ''}">
              <g:each in="${['PREMIERE_FOIS','RENOUVELLEMENT']}">
              <li>
                <input type="radio" id="typeInscription_${it}" class="required  validate-one-required" value="${it}" name="typeInscription" ${it == rqt.typeInscription.toString() ? 'checked="checked"': ''} title="<g:message code="scjer.property.typeInscription.validationError" />" />
                <label for="typeInscription_${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjer.property.typeInscription" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="scjer.property.secteurHabitation.label" /> *  <span><g:message code="scjer.property.secteurHabitation.help" /></span></label>
            <g:set var="secteurHabitationIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'secteurHabitation', 'i18nPrefixCode':'scjer.property.secteurHabitation', 'htmlClass':'required  ', 
                              'lrEntries': lrTypes.secteurHabitation.entries, 'depth':0]" />
            

  

  
    <label for="typeEtablissementScolaireFrenquente" class="required"><g:message code="scjer.property.typeEtablissementScolaireFrenquente.label" /> *  <span><g:message code="scjer.property.typeEtablissementScolaireFrenquente.help" /></span></label>
            <select id="typeEtablissementScolaireFrenquente" name="typeEtablissementScolaireFrenquente" class="required condition-estEtablissementFrequenteCollege-trigger condition-estEtablissementFrequenteLycee-trigger condition-estEtablissementFrequenteAutre-trigger  validate-not-first ${rqt.stepStates['renseignements'].invalidFields.contains('typeEtablissementScolaireFrenquente') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.typeEtablissementScolaireFrenquente.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['COLLEGE','LYCEE','AUTRE']}">
                <option value="${it}" ${it == rqt.typeEtablissementScolaireFrenquente?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="scjer.property.typeEtablissementScolaireFrenquente" /></option>
              </g:each>
            </select>
            

  

  
    <label class="required condition-estEtablissementFrequenteCollege-filled"><g:message code="scjer.property.etablissementScolaireCollege.label" /> *  <span><g:message code="scjer.property.etablissementScolaireCollege.help" /></span></label>
            <g:set var="etablissementScolaireCollegeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'etablissementScolaireCollege', 'i18nPrefixCode':'scjer.property.etablissementScolaireCollege', 'htmlClass':'required condition-estEtablissementFrequenteCollege-filled  ', 
                              'lrEntries': lrTypes.etablissementScolaireCollege.entries, 'depth':0]" />
            

  

  
    <label class="required condition-estEtablissementFrequenteLycee-filled"><g:message code="scjer.property.etablissementScolaireLycee.label" /> *  <span><g:message code="scjer.property.etablissementScolaireLycee.help" /></span></label>
            <g:set var="etablissementScolaireLyceeIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'etablissementScolaireLycee', 'i18nPrefixCode':'scjer.property.etablissementScolaireLycee', 'htmlClass':'required condition-estEtablissementFrequenteLycee-filled  ', 
                              'lrEntries': lrTypes.etablissementScolaireLycee.entries, 'depth':0]" />
            

  

  
    <label for="etablissementScolaireAutre" class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutre.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutre.help" /></span></label>
            <input type="text" id="etablissementScolaireAutre" name="etablissementScolaireAutre" value="${rqt.etablissementScolaireAutre?.toString()}" 
                    class="required condition-estEtablissementFrequenteAutre-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutre') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.etablissementScolaireAutre.validationError" />"   />
            

  

  
    <label for="etablissementScolaireAutreNom" class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreNom.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutreNom.help" /></span></label>
            <input type="text" id="etablissementScolaireAutreNom" name="etablissementScolaireAutreNom" value="${rqt.etablissementScolaireAutreNom?.toString()}" 
                    class="required condition-estEtablissementFrequenteAutre-filled  validate-string ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreNom') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.etablissementScolaireAutreNom.validationError" />"   />
            

  

  
    <label for="etablissementScolaireAutreAdresse" class="required condition-estEtablissementFrequenteAutre-filled"><g:message code="scjer.property.etablissementScolaireAutreAdresse.label" /> *  <span><g:message code="scjer.property.etablissementScolaireAutreAdresse.help" /></span></label>
            <textarea id="etablissementScolaireAutreAdresse" name="etablissementScolaireAutreAdresse" class="required condition-estEtablissementFrequenteAutre-filled  validate-textarea ${rqt.stepStates['renseignements'].invalidFields.contains('etablissementScolaireAutreAdresse') ? 'validation-failed' : ''}" title="<g:message code="scjer.property.etablissementScolaireAutreAdresse.validationError" />" rows="5" cols=""  maxlength="1024">${rqt.etablissementScolaireAutreAdresse}</textarea>
            

  


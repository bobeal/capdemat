


  
    <label class="required"><g:message code="gsrr.property.estRestauration.label" /> *  <span><g:message code="gsrr.property.estRestauration.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['restauration'].invalidFields.contains('estRestauration') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="estRestauration_${it ? 'yes' : 'no'}" class="required condition-estRestauration-trigger  validate-one-required boolean" title="" value="${it}" name="estRestauration" ${it == rqt.estRestauration ? 'checked="checked"': ''} />
                <label for="estRestauration_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required condition-estRestauration-filled"><g:message code="gsrr.property.regimeAlimentaire.label" /> *  <span><g:message code="gsrr.property.regimeAlimentaire.help" /></span></label>
            <g:set var="regimeAlimentaireIndex" value="${0}" scope="flash" />
            <g:render template="/frontofficeRequestType/widget/localReferentialData" 
                      model="['javaName':'regimeAlimentaire', 'i18nPrefixCode':'gsrr.property.regimeAlimentaire', 'htmlClass':'required condition-estRestauration-filled  ', 
                              'lrEntries': lrTypes.regimeAlimentaire.entries, 'depth':0]" />
            

  


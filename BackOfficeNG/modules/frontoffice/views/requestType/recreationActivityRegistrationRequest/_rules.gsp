


  
    
              <label class="required">
                <g:message code="rarr.property.rulesAndRegulationsAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="rarr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="rarr.property.classTripPermission.label" /> *
                <g:if test="${availableRules.contains('classTripPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'classTripPermission'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="rarr.property.classTripPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="classTripPermission" ${it == rqt.classTripPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="rarr.property.childPhotoExploitationPermission.label" /> *
                <g:if test="${availableRules.contains('childPhotoExploitationPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'childPhotoExploitationPermission'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="rarr.property.childPhotoExploitationPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="childPhotoExploitationPermission" ${it == rqt.childPhotoExploitationPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="rarr.property.hospitalizationPermission.label" /> *
                <g:if test="${availableRules.contains('hospitalizationPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'hospitalizationPermission'])}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="rarr.property.hospitalizationPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="hospitalizationPermission" ${it == rqt.hospitalizationPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  


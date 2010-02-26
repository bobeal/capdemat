


  
    
              <label class="required">
                <g:message code="parr.property.rulesAndRegulationsAcceptance.label" /> *
                <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="parr.property.rulesAndRegulationsAcceptance.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <label for="rulesAndRegulationsAcceptance_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="parr.property.classTripPermission.label" /> *
                <g:if test="${availableRules.contains('classTripPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'classTripPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="parr.property.classTripPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="classTripPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="classTripPermission" ${it == rqt.classTripPermission ? 'checked="checked"': ''} />
                    <label for="classTripPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="parr.property.childPhotoExploitationPermission.label" /> *
                <g:if test="${availableRules.contains('childPhotoExploitationPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'childPhotoExploitationPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="parr.property.childPhotoExploitationPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="childPhotoExploitationPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="childPhotoExploitationPermission" ${it == rqt.childPhotoExploitationPermission ? 'checked="checked"': ''} />
                    <label for="childPhotoExploitationPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  

  
    
              <label class="required">
                <g:message code="parr.property.hospitalizationPermission.label" /> *
                <g:if test="${availableRules.contains('hospitalizationPermission')}">
                  <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'hospitalizationPermission']).encodeAsXML()}"><span><g:message code="request.action.consult.rules" /></span></a>
                </g:if>
                <span><g:message code="parr.property.hospitalizationPermission.help" /></span>
              </label>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" id="hospitalizationPermission_${it ? 'yes' : 'no'}" class="required  validate-acceptance" title="" value="${it}" name="hospitalizationPermission" ${it == rqt.hospitalizationPermission ? 'checked="checked"': ''} />
                    <label for="hospitalizationPermission_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
                  </li>
                </g:each>
              </ul>
            

  





  
    <label class="required"><g:message code="parr.property.rulesAndRegulationsAcceptance.label" /> *  <span><g:message code="parr.property.rulesAndRegulationsAcceptance.help" /></span></label>
              <g:if test="${availableRules.contains('rulesAndRegulationsAcceptance')}">
                <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'rulesAndRegulationsAcceptance'])}"><g:message code="action.consult" /></a>
              </g:if>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="rulesAndRegulationsAcceptance" ${it == rqt.rulesAndRegulationsAcceptance ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    <label class="required"><g:message code="parr.property.classTripPermission.label" /> *  <span><g:message code="parr.property.classTripPermission.help" /></span></label>
              <g:if test="${availableRules.contains('classTripPermission')}">
                <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'classTripPermission'])}"><g:message code="action.consult" /></a>
              </g:if>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="classTripPermission" ${it == rqt.classTripPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    <label class="required"><g:message code="parr.property.childPhotoExploitationPermission.label" /> *  <span><g:message code="parr.property.childPhotoExploitationPermission.help" /></span></label>
              <g:if test="${availableRules.contains('childPhotoExploitationPermission')}">
                <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'childPhotoExploitationPermission'])}"><g:message code="action.consult" /></a>
              </g:if>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="childPhotoExploitationPermission" ${it == rqt.childPhotoExploitationPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  

  
    <label class="required"><g:message code="parr.property.hospitalizationPermission.label" /> *  <span><g:message code="parr.property.hospitalizationPermission.help" /></span></label>
              <g:if test="${availableRules.contains('hospitalizationPermission')}">
                <a target="_blank" href="${createLink(controller:'localAuthorityResource', action:'rule', params:['requestTypeLabel':requestTypeLabel, 'filename':'hospitalizationPermission'])}"><g:message code="action.consult" /></a>
              </g:if>
              <ul class="yes-no required">
                <g:each in="${[true,false]}">
                  <li>
                    <input type="radio" class="required  validate-acceptance" title="" value="${it}" name="hospitalizationPermission" ${it == rqt.hospitalizationPermission ? 'checked="checked"': ''} />
                    <g:message code="message.${it ? 'yes' : 'no'}" />
                  </li>
                </g:each>
              </ul>
            

  


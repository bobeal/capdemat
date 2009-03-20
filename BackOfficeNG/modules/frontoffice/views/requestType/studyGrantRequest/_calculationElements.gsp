




  
    <label class="required"><g:message code="sgr.property.distance.label" /> *  <span><g:message code="sgr.property.distance.help" /></span></label>
    
            <select name="distance" class="required validate-not-first" title="<g:message code="sgr.property.distance.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['lessThan30km','between30and250km','moreThan250kmAndAbroad']}">
                <option value="fr.cg95.cvq.business.request.school.DistanceType_${it}" ${it == rqt.distance?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.distance" /></option>
              </g:each>
            </select>
            
  


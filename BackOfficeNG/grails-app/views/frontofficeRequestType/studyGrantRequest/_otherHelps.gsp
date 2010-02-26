


  
    <label class="required"><g:message code="sgr.property.hasCROUSHelp.label" /> *  <span><g:message code="sgr.property.hasCROUSHelp.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="hasCROUSHelp_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="hasCROUSHelp" ${it == rqt.hasCROUSHelp ? 'checked="checked"': ''} />
                <label for="hasCROUSHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sgr.property.hasRegionalCouncilHelp.label" /> *  <span><g:message code="sgr.property.hasRegionalCouncilHelp.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="hasRegionalCouncilHelp_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="hasRegionalCouncilHelp" ${it == rqt.hasRegionalCouncilHelp ? 'checked="checked"': ''} />
                <label for="hasRegionalCouncilHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sgr.property.hasEuropeHelp.label" /> *  <span><g:message code="sgr.property.hasEuropeHelp.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="hasEuropeHelp_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="hasEuropeHelp" ${it == rqt.hasEuropeHelp ? 'checked="checked"': ''} />
                <label for="hasEuropeHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="sgr.property.hasOtherHelp.label" /> *  <span><g:message code="sgr.property.hasOtherHelp.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="hasOtherHelp_${it ? 'yes' : 'no'}" class="required  validate-one-required boolean" title="" value="${it}" name="hasOtherHelp" ${it == rqt.hasOtherHelp ? 'checked="checked"': ''} />
                <label for="hasOtherHelp_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  


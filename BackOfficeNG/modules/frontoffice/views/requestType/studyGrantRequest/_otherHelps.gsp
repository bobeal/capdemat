




  
    <label class="required"><g:message code="sgr.property.hasCROUSHelp.label" /> *  <span><g:message code="sgr.property.hasCROUSHelp.help" /></span></label>
    
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required validate-boolean" title="" value="${it}" name="hasCROUSHelp" ${it == rqt.hasCROUSHelp ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
  

  
    <label class="required"><g:message code="sgr.property.hasOtherHelp.label" /> *  <span><g:message code="sgr.property.hasOtherHelp.help" /></span></label>
    
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-otherHelpObtained-trigger validate-boolean" title="" value="${it}" name="hasOtherHelp" ${it == rqt.hasOtherHelp ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
  

  
    <label class="required condition-otherHelpObtained-filled"><g:message code="sgr.property.otherHelpInformations.label" /> *  <span><g:message code="sgr.property.otherHelpInformations.help" /></span></label>
    
            <input type="text" name="otherHelpInformations" value="${rqt.otherHelpInformations}" 
                    class="required condition-otherHelpObtained-filled validate-string" title="<g:message code="sgr.property.otherHelpInformations.validationError" />"  />
            
  


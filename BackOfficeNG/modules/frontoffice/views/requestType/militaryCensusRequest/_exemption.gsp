


  
    <label class="required"><g:message code="mcr.property.japdExemption.label" /> *  <span><g:message code="mcr.property.japdExemption.help" /></span></label>
            <ul class="yes-no required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required  validate-one-required" title="" value="${it}" name="japdExemption" ${it == rqt.japdExemption ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="mcr.property.highlyInfirm.label" />   <span><g:message code="mcr.property.highlyInfirm.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-one-required" title="" value="${it}" name="highlyInfirm" ${it == rqt.highlyInfirm ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class=""><g:message code="mcr.property.affectionOrDisease.label" />   <span><g:message code="mcr.property.affectionOrDisease.help" /></span></label>
            <ul class="yes-no ">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="  validate-one-required" title="" value="${it}" name="affectionOrDisease" ${it == rqt.affectionOrDisease ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

  


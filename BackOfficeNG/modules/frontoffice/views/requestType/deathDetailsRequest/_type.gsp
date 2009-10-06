


  
    <label class="required"><g:message code="ddr.property.format.label" /> *  <span><g:message code="ddr.property.format.help" /></span></label>
            <ul class="required">
              <g:each in="${['FullCopy','MultilingualExtract']}">
              <li>
                <input type="radio" class="required  validate-one-required" value="fr.cg95.cvq.business.request.civil.DeathCertificateFormatType_${it}" name="format" ${it == rqt.format.toString() ? 'checked="checked"': ''} title="<g:message code="ddr.property.format.validationError" />" />
                <g:capdematEnumToField var="${it}" i18nKeyPrefix="ddr.property.format" />
              </li>
              </g:each>
            </ul>
            

  

  
    <label class="required"><g:message code="ddr.property.copies.label" /> *  <span><g:message code="ddr.property.copies.help" /></span></label>
            <input type="text" name="copies" value="${rqt.copies?.toString()}" 
                    class="required  validate-positiveInteger" title="<g:message code="ddr.property.copies.validationError" />"   />
            

  

  
    <label class=""><g:message code="ddr.property.comment.label" />   <span><g:message code="ddr.property.comment.help" /></span></label>
            <textarea name="comment" class="  validate-textarea" title="<g:message code="ddr.property.comment.validationError" />" rows="3" cols="" >${rqt.comment}</textarea>
            

  

  
    <label class=""><g:message code="ddr.property.motive.label" />   <span><g:message code="ddr.property.motive.help" /></span></label>
            <select name="motive" class="  validate-select" title="<g:message code="ddr.property.motive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NotaryAct','Marriage','Passport','Pension','Other']}">
                <option value="fr.cg95.cvq.business.request.civil.DeathCertificateMotiveType_${it}" ${it == rqt.motive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ddr.property.motive" /></option>
              </g:each>
            </select>
            

  


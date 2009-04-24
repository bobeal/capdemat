


  
    <label class=""><g:message code="parr.property.otherIndividual.label" /> <span><g:message code="parr.property.otherIndividual.help" /></span></label>
    <div class="collection-fieldset  validation-scope">
      <g:set var="listIndex" value="${editList?.name == 'otherIndividual' ? editList?.index : ( rqt.otherIndividual ? rqt.otherIndividual.size() : 0 ) }" />
      <fieldset class="collection-fieldset-add ">
    
        <g:if test="${editList?.name == 'otherIndividual'}">
          <input type="submit" id="submit-collectionModify-contact-otherIndividual[${listIndex}]" name="submit-collectionModify-contact-otherIndividual[${listIndex}]" value="${message(code:'action.save')}" />
        </g:if>
        <g:else>
          <input type="submit" id="submit-collectionAdd-contact-otherIndividual[${listIndex}]" name="submit-collectionAdd-contact-otherIndividual[${listIndex}]" value="${message(code:'action.add')}" />
        </g:else>
      </fieldset>
    <g:each var="it" in="${rqt.otherIndividual}" status="index">
      <fieldset class="collection-fieldset-edit">
        <dl>
    
        </dl>
        <input type="submit" value="${message(code:'action.modify')}" name="submit-collectionEdit-contact-otherIndividual[${index}]" />
        <input type="submit" value="${message(code:'action.remove')}" name="submit-collectionDelete-contact-otherIndividual[${index}]" />
      </fieldset>
    </g:each>
    </div>
  


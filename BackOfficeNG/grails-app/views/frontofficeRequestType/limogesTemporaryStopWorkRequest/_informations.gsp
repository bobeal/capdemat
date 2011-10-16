


  
    <label for="noParking" class=""><g:message code="ltswr.property.noParking.label" />   <span><g:message code="ltswr.property.noParking.help" /></span></label>
            <select id="noParking" name="noParking" class="condition-noParking-trigger  validate-select ${rqt.stepStates['informations'].invalidFields.contains('noParking') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.noParking.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['ALLWAY','PROGRESS','RIGHT','FRONT']}">
                <option value="${it}" ${it == rqt.noParking?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.noParking" /></option>
              </g:each>
            </select>
            

  

  
    <label for="noParkingStraightNumber" class="required condition-noParking-filled"><g:message code="ltswr.property.noParkingStraightNumber.label" /> *  <span><g:message code="ltswr.property.noParkingStraightNumber.help" /></span></label>
            <input type="text" id="noParkingStraightNumber" name="noParkingStraightNumber" value="${rqt.noParkingStraightNumber?.toString()}" 
                    class="required condition-noParking-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('noParkingStraightNumber') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.noParkingStraightNumber.validationError" />"   />
            

  

  
    <label for="noParkingStraightMeter" class="required condition-noParking-filled"><g:message code="ltswr.property.noParkingStraightMeter.label" /> *  <span><g:message code="ltswr.property.noParkingStraightMeter.help" /></span></label>
            <input type="text" id="noParkingStraightMeter" name="noParkingStraightMeter" value="${rqt.noParkingStraightMeter?.toString()}" 
                    class="required condition-noParking-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('noParkingStraightMeter') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.noParkingStraightMeter.validationError" />"   />
            

  

  
    <label for="alternateTraffic" class=""><g:message code="ltswr.property.alternateTraffic.label" />   <span><g:message code="ltswr.property.alternateTraffic.help" /></span></label>
            <select id="alternateTraffic" name="alternateTraffic" class="condition-direction-trigger condition-alternate-trigger  validate-select ${rqt.stepStates['informations'].invalidFields.contains('alternateTraffic') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.alternateTraffic.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['INFO','MANUAL','AUTO']}">
                <option value="${it}" ${it == rqt.alternateTraffic?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.alternateTraffic" /></option>
              </g:each>
            </select>
            

  

  
    <label for="alternateTrafficDirection" class="required condition-direction-filled"><g:message code="ltswr.property.alternateTrafficDirection.label" /> *  <span><g:message code="ltswr.property.alternateTrafficDirection.help" /></span></label>
            <input type="text" id="alternateTrafficDirection" name="alternateTrafficDirection" value="${rqt.alternateTrafficDirection?.toString()}" 
                    class="required condition-direction-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('alternateTrafficDirection') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.alternateTrafficDirection.validationError" />"   />
            

  

  
    <label for="alternateTrafficMeter" class="required condition-alternate-filled"><g:message code="ltswr.property.alternateTrafficMeter.label" /> *  <span><g:message code="ltswr.property.alternateTrafficMeter.help" /></span></label>
            <input type="text" id="alternateTrafficMeter" name="alternateTrafficMeter" value="${rqt.alternateTrafficMeter?.toString()}" 
                    class="required condition-alternate-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('alternateTrafficMeter') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.alternateTrafficMeter.validationError" />"   />
            

  

  
    <label for="drivingBan" class=""><g:message code="ltswr.property.drivingBan.label" />   <span><g:message code="ltswr.property.drivingBan.help" /></span></label>
            <select id="drivingBan" name="drivingBan" class="condition-ban-trigger condition-banBetween-trigger condition-deviation-trigger  validate-select ${rqt.stepStates['informations'].invalidFields.contains('drivingBan') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.drivingBan.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['ALLWAY','PARTWAY','ONEWAY']}">
                <option value="${it}" ${it == rqt.drivingBan?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="ltswr.property.drivingBan" /></option>
              </g:each>
            </select>
            

  

  
    <label for="drivingBanBetween" class="required condition-banBetween-filled"><g:message code="ltswr.property.drivingBanBetween.label" /> *  <span><g:message code="ltswr.property.drivingBanBetween.help" /></span></label>
            <input type="text" id="drivingBanBetween" name="drivingBanBetween" value="${rqt.drivingBanBetween?.toString()}" 
                    class="required condition-banBetween-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('drivingBanBetween') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.drivingBanBetween.validationError" />"   />
            

  

  
    <label for="drivingBanDirection" class="required condition-ban-filled"><g:message code="ltswr.property.drivingBanDirection.label" /> *  <span><g:message code="ltswr.property.drivingBanDirection.help" /></span></label>
            <input type="text" id="drivingBanDirection" name="drivingBanDirection" value="${rqt.drivingBanDirection?.toString()}" 
                    class="required condition-ban-filled  validate-string ${rqt.stepStates['informations'].invalidFields.contains('drivingBanDirection') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.drivingBanDirection.validationError" />"   />
            

  

  
    <label for="deviation" class="required condition-deviation-filled"><g:message code="ltswr.property.deviation.label" /> *  <span><g:message code="ltswr.property.deviation.help" /></span></label>
            <textarea id="deviation" name="deviation" class="required condition-deviation-filled  validate-textarea ${rqt.stepStates['informations'].invalidFields.contains('deviation') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.deviation.validationError" />" rows="5" cols=""  >${rqt.deviation}</textarea>
            

  

  
    <label for="comment" class=""><g:message code="ltswr.property.comment.label" />   <span><g:message code="ltswr.property.comment.help" /></span></label>
            <textarea id="comment" name="comment" class="  validate-textarea ${rqt.stepStates['informations'].invalidFields.contains('comment') ? 'validation-failed' : ''}" title="<g:message code="ltswr.property.comment.validationError" />" rows="5" cols=""  >${rqt.comment}</textarea>
            

  


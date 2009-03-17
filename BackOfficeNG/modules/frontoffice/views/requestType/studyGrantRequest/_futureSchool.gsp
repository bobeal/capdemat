




  
    <label class="required"><g:message code="sgr.property.futureSchoolName.label" /> *  <span><g:message code="sgr.property.futureSchoolName.help" /></span></label>
    
            <input type="text" name="futureSchoolName" value="${rqt.futureSchoolName}" 
                    class="required validate-string" title="<g:message code="sgr.property.futureSchoolName.validationError" />"  />
            
  

  
    <label class="required"><g:message code="sgr.property.futureSchoolAddress.label" /> *  <span><g:message code="sgr.property.futureSchoolAddress.help" /></span></label>
    
            <div class="address-fieldset required">
            <label><g:message code="address.property.additionalDeliveryInformation" /></label>
            <input type="text" value="${rqt.futureSchoolAddress?.additionalDeliveryInformation}" maxlength="38" name="futureSchoolAddress.additionalDeliveryInformation"/>  
            <label><g:message code="address.property.additionalGeographicalInformation" /></label>
            <input type="text" value="${rqt.futureSchoolAddress?.additionalGeographicalInformation}" maxlength="38" name="futureSchoolAddress.additionalGeographicalInformation"/>
            <label><g:message code="address.property.streetNumber" /> - <strong><g:message code="address.property.streetName" /> *</strong></label>
            <input type="text" class="line1" value="${rqt.futureSchoolAddress?.streetNumber}" maxlength="5" name="futureSchoolAddress.streetNumber"/>
            <input type="text" class="line2 required" value="${rqt.futureSchoolAddress?.streetName}" maxlength="32" name="futureSchoolAddress.streetName" title="<g:message code="address.property.streetName.validationError" />" />
            <label><g:message code="address.property.placeNameOrService" /></label>
            <input type="text" value="${rqt.futureSchoolAddress?.placeNameOrService}" maxlength="38" name="futureSchoolAddress.placeNameOrService"/>
            <label class="required"><g:message code="address.property.postalCode" /> * - <g:message code="address.property.city" /> *</label>
            <input type="text" class="line1 required" value="${rqt.futureSchoolAddress?.postalCode}" maxlength="5" name="futureSchoolAddress.postalCode" title="<g:message code="address.property.postalCode.validationError" />" />
            <input type="text" class="line2 required" value="${rqt.futureSchoolAddress?.city}" maxlength="32" name="futureSchoolAddress.city" title="<g:message code="address.property.city.validationError" />" />
            <label><g:message code="address.property.countryName" /></label>
            <input type="text" value="${rqt.futureSchoolAddress?.countryName}" maxlength="38" name="futureSchoolAddress.countryName"/>
            </div>
            
  

  
    <label class="required"><g:message code="sgr.property.futureSchoolPhone.label" /> *  <span><g:message code="sgr.property.futureSchoolPhone.help" /></span></label>
    
            <input type="text" name="futureSchoolPhone" value="${rqt.futureSchoolPhone}" 
                    class="required validate-phone" title="<g:message code="sgr.property.futureSchoolPhone.validationError" />"  maxLength="10"/>
            
  

  
    <label class="required"><g:message code="sgr.property.futureDiplomaName.label" /> *  <span><g:message code="sgr.property.futureDiplomaName.help" /></span></label>
    
            <input type="text" name="futureDiplomaName" value="${rqt.futureDiplomaName}" 
                    class="required validate-string" title="<g:message code="sgr.property.futureDiplomaName.validationError" />"  />
            
  

  
    <label class="required"><g:message code="sgr.property.futureDiplomaLevel.label" /> *  <span><g:message code="sgr.property.futureDiplomaLevel.help" /></span></label>
    
            <input type="text" name="futureDiplomaLevel" value="${rqt.futureDiplomaLevel}" 
                    class="required validate-string" title="<g:message code="sgr.property.futureDiplomaLevel.validationError" />"  />
            
  

  
    <label class="required"><g:message code="sgr.property.futureSchoolIsAbroad.label" /> *  <span><g:message code="sgr.property.futureSchoolIsAbroad.help" /></span></label>
    
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-willBeAbroad-trigger validate-boolean" title="" value="${it}" name="futureSchoolIsAbroad" ${it == rqt.futureSchoolIsAbroad ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            
  

  
    <label class="required condition-willBeAbroad-filled"><g:message code="sgr.property.abroadInternshipSchoolName.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolName.help" /></span></label>
    
            <input type="text" name="abroadInternshipSchoolName" value="${rqt.abroadInternshipSchoolName}" 
                    class="required condition-willBeAbroad-filled validate-string" title="<g:message code="sgr.property.abroadInternshipSchoolName.validationError" />"  />
            
  

  
    <label class="required condition-willBeAbroad-filled"><g:message code="sgr.property.abroadInternshipSchoolAddress.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolAddress.help" /></span></label>
    
            <input type="text" name="abroadInternshipSchoolAddress" value="${rqt.abroadInternshipSchoolAddress}" 
                    class="required condition-willBeAbroad-filled validate-string" title="<g:message code="sgr.property.abroadInternshipSchoolAddress.validationError" />"  />
            
  

  
    <label class="required condition-willBeAbroad-filled"><g:message code="sgr.property.abroadInternshipSchoolCountry.label" /> *  <span><g:message code="sgr.property.abroadInternshipSchoolCountry.help" /></span></label>
    
            <select name="abroadInternshipSchoolCountry" class="required condition-willBeAbroad-filled validate-not-first" title="<g:message code="sgr.property.abroadInternshipSchoolCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.abroadInternshipSchoolCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="sgr.property.abroadInternshipSchoolCountry" /></option>
              </g:each>
            </select>
            
  


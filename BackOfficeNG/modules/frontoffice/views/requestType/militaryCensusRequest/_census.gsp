


  
    
            <label for="subjectId" class="required"><g:message code="request.property.subject.label" /> *  <span><g:message code="request.property.subject.help" /></span></label>
            <select id="subjectId" name="subjectId" <g:if test="${isEdition}">disabled="disabled"</g:if> class="required validate-not-first autofill-subjectFilling-trigger" title="<g:message code="request.property.subject.validationError" /> ">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${subjects}">
                <option value="${it.key}" ${it.key == rqt.subjectId ? 'selected="selected"': ''}>${it.value}</option>
              </g:each>
            </select>
            

  

  
    <label for="childTitle" class="required"><g:message code="mcr.property.childTitle.label" /> *  <span><g:message code="mcr.property.childTitle.help" /></span></label>
            <select id="childTitle" name="childTitle" class="required  validate-not-first" title="<g:message code="mcr.property.childTitle.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Mister','Madam','Miss','Agency','Unknown']}">
                <option value="fr.cg95.cvq.business.users.TitleType_${it}" ${it == rqt.childTitle?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childTitle" /></option>
              </g:each>
            </select>
            

  

  
    <label for="maidenName" class=""><g:message code="mcr.property.maidenName.label" />   <span><g:message code="mcr.property.maidenName.help" /></span></label>
            <input type="text" id="maidenName" name="maidenName" value="${rqt.maidenName?.toString()}" 
                    class=" autofill-subjectFilling-listener-LastName validate-lastName" title="<g:message code="mcr.property.maidenName.validationError" />"  maxlength="38" />
            

  

  
    <label for="childBirthCountry" class="required"><g:message code="mcr.property.childBirthCountry.label" /> *  <span><g:message code="mcr.property.childBirthCountry.help" /></span></label>
            <select id="childBirthCountry" name="childBirthCountry" class="required  validate-not-first" title="<g:message code="mcr.property.childBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.childBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childBirthCountry" /></option>
              </g:each>
            </select>
            

  

  
    <label for="childResidenceCountry" class=""><g:message code="mcr.property.childResidenceCountry.label" />   <span><g:message code="mcr.property.childResidenceCountry.help" /></span></label>
            <select id="childResidenceCountry" name="childResidenceCountry" class="  validate-select" title="<g:message code="mcr.property.childResidenceCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.childResidenceCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childResidenceCountry" /></option>
              </g:each>
            </select>
            

  

  
    <label for="childPhone" class="required"><g:message code="mcr.property.childPhone.label" /> *  <span><g:message code="mcr.property.childPhone.help" /></span></label>
            <input type="text" id="childPhone" name="childPhone" value="${rqt.childPhone?.toString()}" 
                    class="required  validate-phone" title="<g:message code="mcr.property.childPhone.validationError" />"  maxlength="10" />
            

  

  
    <label for="childMail" class=""><g:message code="mcr.property.childMail.label" />   <span><g:message code="mcr.property.childMail.help" /></span></label>
            <input type="text" id="childMail" name="childMail" value="${rqt.childMail?.toString()}" 
                    class="  validate-email" title="<g:message code="mcr.property.childMail.validationError" />"   />
            

  

  
    <label for="childCountry" class="required"><g:message code="mcr.property.childCountry.label" /> *  <span><g:message code="mcr.property.childCountry.help" /></span></label>
            <select id="childCountry" name="childCountry" class="required  validate-not-first" title="<g:message code="mcr.property.childCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.childCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childCountry" /></option>
              </g:each>
            </select>
            

  

  
    <label for="childOtherCountry" class=""><g:message code="mcr.property.childOtherCountry.label" />   <span><g:message code="mcr.property.childOtherCountry.help" /></span></label>
            <select id="childOtherCountry" name="childOtherCountry" class="  validate-select" title="<g:message code="mcr.property.childOtherCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.childOtherCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.childOtherCountry" /></option>
              </g:each>
            </select>
            

  

  
    <label for="childConvention" class=""><g:message code="mcr.property.childConvention.label" />   <span><g:message code="mcr.property.childConvention.help" /></span></label>
            <textarea id="childConvention" name="childConvention" class="  validate-textarea" title="<g:message code="mcr.property.childConvention.validationError" />" rows="3" cols=""  >${rqt.childConvention}</textarea>
            

  


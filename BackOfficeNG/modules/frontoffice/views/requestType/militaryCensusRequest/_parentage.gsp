


  
    <fieldset class="required">
    <legend><g:message code="mcr.property.fatherInformation.label" /></legend>
    
      <label class=""><g:message code="mcr.property.fatherLastName.label" />   <span><g:message code="mcr.property.fatherLastName.help" /></span></label>
            <input type="text" name="fatherLastName" value="${rqt.fatherLastName}" 
                    class="  validate-lastName" title="<g:message code="mcr.property.fatherLastName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="mcr.property.fatherFirstName.label" />   <span><g:message code="mcr.property.fatherFirstName.help" /></span></label>
            <input type="text" name="fatherFirstName" value="${rqt.fatherFirstName}" 
                    class="  validate-firstName" title="<g:message code="mcr.property.fatherFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class=""><g:message code="mcr.property.fatherBirthDate.label" />   <span><g:message code="mcr.property.fatherBirthDate.help" /></span></label>
            <input type="text" name="fatherBirthDate" value="${formatDate(formatName:'format.date',date:rqt.fatherBirthDate)}" 
                   class="  validate-date" title="<g:message code="mcr.property.fatherBirthDate.validationError" />" />
            

    
      <label class=""><g:message code="mcr.property.fatherBirthCity.label" />   <span><g:message code="mcr.property.fatherBirthCity.help" /></span></label>
            <input type="text" name="fatherBirthCity" value="${rqt.fatherBirthCity}" 
                    class="  validate-string" title="<g:message code="mcr.property.fatherBirthCity.validationError" />"  />
            

    
      <label class=""><g:message code="mcr.property.fatherBirthDepartment.label" />   <span><g:message code="mcr.property.fatherBirthDepartment.help" /></span></label>
            <select name="fatherBirthDepartment" class="  validate-not-first" title="<g:message code="mcr.property.fatherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','DEP_01','DEP_02','DEP_03','DEP_04','DEP_05','DEP_06','DEP_07','DEP_08','DEP_09','DEP_10','DEP_11','DEP_12','DEP_13','DEP_14','DEP_15','DEP_16','DEP_17','DEP_18','DEP_19','DEP_2A','DEP_2B','DEP_21','DEP_22','DEP_23','DEP_24','DEP_25','DEP_26','DEP_27','DEP_28','DEP_29','DEP_30','DEP_31','DEP_32','DEP_33','DEP_34','DEP_35','DEP_36','DEP_37','DEP_38','DEP_39','DEP_40','DEP_41','DEP_42','DEP_43','DEP_44','DEP_45','DEP_46','DEP_47','DEP_48','DEP_49','DEP_50','DEP_51','DEP_52','DEP_53','DEP_54','DEP_55','DEP_56','DEP_57','DEP_58','DEP_59','DEP_60','DEP_61','DEP_62','DEP_63','DEP_64','DEP_65','DEP_66','DEP_67','DEP_68','DEP_69','DEP_70','DEP_71','DEP_72','DEP_73','DEP_74','DEP_75','DEP_76','DEP_77','DEP_78','DEP_79','DEP_80','DEP_81','DEP_82','DEP_83','DEP_84','DEP_85','DEP_86','DEP_87','DEP_88','DEP_89','DEP_90','DEP_91','DEP_92','DEP_93','DEP_94','DEP_95','DEP_971','DEP_972','DEP_973','DEP_974']}">
                <option value="fr.cg95.cvq.business.users.InseeDepartementCodeType_${it}" ${it == rqt.fatherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.fatherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label class=""><g:message code="mcr.property.fatherBirthCountry.label" />   <span><g:message code="mcr.property.fatherBirthCountry.help" /></span></label>
            <select name="fatherBirthCountry" class="  validate-not-first" title="<g:message code="mcr.property.fatherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.fatherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.fatherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label class=""><g:message code="mcr.property.fatherNationality.label" />   <span><g:message code="mcr.property.fatherNationality.help" /></span></label>
            <select name="fatherNationality" class="  validate-not-first" title="<g:message code="mcr.property.fatherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.fatherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.fatherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mcr.property.motherInformation.label" /></legend>
    
      <label class="required"><g:message code="mcr.property.motherLastName.label" /> *  <span><g:message code="mcr.property.motherLastName.help" /></span></label>
            <input type="text" name="motherLastName" value="${rqt.motherLastName}" 
                    class="required  validate-lastName" title="<g:message code="mcr.property.motherLastName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="mcr.property.motherFirstName.label" /> *  <span><g:message code="mcr.property.motherFirstName.help" /></span></label>
            <input type="text" name="motherFirstName" value="${rqt.motherFirstName}" 
                    class="required  validate-firstName" title="<g:message code="mcr.property.motherFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="mcr.property.motherBirthDate.label" /> *  <span><g:message code="mcr.property.motherBirthDate.help" /></span></label>
            <input type="text" name="motherBirthDate" value="${formatDate(formatName:'format.date',date:rqt.motherBirthDate)}" 
                   class="required  validate-date" title="<g:message code="mcr.property.motherBirthDate.validationError" />" />
            

    
      <label class="required"><g:message code="mcr.property.motherBirthCity.label" /> *  <span><g:message code="mcr.property.motherBirthCity.help" /></span></label>
            <input type="text" name="motherBirthCity" value="${rqt.motherBirthCity}" 
                    class="required  validate-string" title="<g:message code="mcr.property.motherBirthCity.validationError" />"  />
            

    
      <label class=""><g:message code="mcr.property.motherBirthDepartment.label" />   <span><g:message code="mcr.property.motherBirthDepartment.help" /></span></label>
            <select name="motherBirthDepartment" class="  validate-not-first" title="<g:message code="mcr.property.motherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','DEP_01','DEP_02','DEP_03','DEP_04','DEP_05','DEP_06','DEP_07','DEP_08','DEP_09','DEP_10','DEP_11','DEP_12','DEP_13','DEP_14','DEP_15','DEP_16','DEP_17','DEP_18','DEP_19','DEP_2A','DEP_2B','DEP_21','DEP_22','DEP_23','DEP_24','DEP_25','DEP_26','DEP_27','DEP_28','DEP_29','DEP_30','DEP_31','DEP_32','DEP_33','DEP_34','DEP_35','DEP_36','DEP_37','DEP_38','DEP_39','DEP_40','DEP_41','DEP_42','DEP_43','DEP_44','DEP_45','DEP_46','DEP_47','DEP_48','DEP_49','DEP_50','DEP_51','DEP_52','DEP_53','DEP_54','DEP_55','DEP_56','DEP_57','DEP_58','DEP_59','DEP_60','DEP_61','DEP_62','DEP_63','DEP_64','DEP_65','DEP_66','DEP_67','DEP_68','DEP_69','DEP_70','DEP_71','DEP_72','DEP_73','DEP_74','DEP_75','DEP_76','DEP_77','DEP_78','DEP_79','DEP_80','DEP_81','DEP_82','DEP_83','DEP_84','DEP_85','DEP_86','DEP_87','DEP_88','DEP_89','DEP_90','DEP_91','DEP_92','DEP_93','DEP_94','DEP_95','DEP_971','DEP_972','DEP_973','DEP_974']}">
                <option value="fr.cg95.cvq.business.users.InseeDepartementCodeType_${it}" ${it == rqt.motherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.motherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label class=""><g:message code="mcr.property.motherBirthCountry.label" />   <span><g:message code="mcr.property.motherBirthCountry.help" /></span></label>
            <select name="motherBirthCountry" class="  validate-not-first" title="<g:message code="mcr.property.motherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['Unknown','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bj','bs','bh','bd','bb','pw','be','bz','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','ci','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gp','gu','gt','gn','gq','gw','gy','gf','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.CountryType_${it}" ${it == rqt.motherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.motherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label class="required"><g:message code="mcr.property.motherNationality.label" /> *  <span><g:message code="mcr.property.motherNationality.help" /></span></label>
            <select name="motherNationality" class="required  validate-not-first" title="<g:message code="mcr.property.motherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['None','af','za','al','dz','de','ad','ao','ai','aq','ag','an','sa','ar','am','aw','au','at','az','bs','bh','bd','bb','be','bz','bj','bm','bt','by','mm','bo','ba','bw','br','bn','bg','bf','bi','kh','cm','ca','cv','cl','cn','cy','co','km','cg','kp','kr','cr','hr','cu','dk','dj','dm','eg','ae','ec','er','es','ee','us','et','fi','fr','ge','ga','gm','gh','gi','gr','gd','gl','gu','gt','gn','gq','gw','ht','hn','hk','hu','ck','fj','mh','sb','in','id','ir','iq','ie','is','il','it','ci','jm','jp','jo','kz','ke','kg','ki','kw','la','ls','lv','lb','lr','ly','li','lt','lu','mg','my','mw','mv','ml','mt','ma','mu','mr','mx','fm','md','mc','mn','mz','np','na','nr','ni','ne','ng','nu','no','nz','om','ug','uz','pe','pk','pa','pg','py','nl','ph','pl','pt','qa','cf','cd','do','cz','ro','gb','ru','rw','sn','kn','sm','va','vc','lc','sv','ws','st','sc','sl','sg','si','sk','so','sd','lk','se','ch','sr','sz','sy','tw','tj','tz','td','th','tl','tg','to','vt','tn','tm','tr','tv','ua','uy','vu','ve','vn','ye','zm','zw','mk']}">
                <option value="fr.cg95.cvq.business.users.FullNationalityType_${it}" ${it == rqt.motherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToField var="${it}" i18nKeyPrefix="mcr.property.motherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  


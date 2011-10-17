


  
    <fieldset class="required">
    <legend><g:message code="mcr.property.fatherInformation.label" /></legend>
    
      <label for="fatherLastName" class=""><g:message code="mcr.property.fatherLastName.label" />   <span><g:message code="mcr.property.fatherLastName.help" /></span></label>
            <input type="text" id="fatherLastName" name="fatherLastName" value="${rqt.fatherLastName?.toString()}" 
                    class="  validate-lastName ${rqt.stepStates['parentage'].invalidFields.contains('fatherLastName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="fatherFirstName" class=""><g:message code="mcr.property.fatherFirstName.label" />   <span><g:message code="mcr.property.fatherFirstName.help" /></span></label>
            <input type="text" id="fatherFirstName" name="fatherFirstName" value="${rqt.fatherFirstName?.toString()}" 
                    class="  validate-firstName ${rqt.stepStates['parentage'].invalidFields.contains('fatherFirstName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class=""><g:message code="mcr.property.fatherBirthDate.label" />   <span><g:message code="mcr.property.fatherBirthDate.help" /></span></label>
            <div class="date   validate-date  ">
              <select class="day ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_day"
                name="fatherBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.fatherBirthDate?.date == it
                      || (rqt.fatherBirthDate == null && params['fatherBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_month"
                name="fatherBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.fatherBirthDate?.month == (it - 1)
                      || (rqt.fatherBirthDate == null && params['fatherBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDate') ? 'validation-failed' : ''}"
                id="fatherBirthDate_year"
                name="fatherBirthDate_year"
                value="${rqt.fatherBirthDate ? rqt.fatherBirthDate.year + 1900 : params['fatherBirthDate_year']}"
                title="<g:message code="mcr.property.fatherBirthDate.validationError" />" />
            </div>
            

    
      <label for="fatherBirthCity" class=""><g:message code="mcr.property.fatherBirthCity.label" />   <span><g:message code="mcr.property.fatherBirthCity.help" /></span></label>
            <input type="text" id="fatherBirthCity" name="fatherBirthCity" value="${rqt.fatherBirthCity?.toString()}" 
                    class="  validate-string ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthCity') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthCity.validationError" />"   />
            

    
      <label for="fatherBirthDepartment" class=""><g:message code="mcr.property.fatherBirthDepartment.label" />   <span><g:message code="mcr.property.fatherBirthDepartment.help" /></span></label>
            <select id="fatherBirthDepartment" name="fatherBirthDepartment" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','D_E_P01','D_E_P02','D_E_P03','D_E_P04','D_E_P05','D_E_P06','D_E_P07','D_E_P08','D_E_P09','D_E_P10','D_E_P11','D_E_P12','D_E_P13','D_E_P14','D_E_P15','D_E_P16','D_E_P17','D_E_P18','D_E_P19','D_E_P2_A','D_E_P2_B','D_E_P21','D_E_P22','D_E_P23','D_E_P24','D_E_P25','D_E_P26','D_E_P27','D_E_P28','D_E_P29','D_E_P30','D_E_P31','D_E_P32','D_E_P33','D_E_P34','D_E_P35','D_E_P36','D_E_P37','D_E_P38','D_E_P39','D_E_P40','D_E_P41','D_E_P42','D_E_P43','D_E_P44','D_E_P45','D_E_P46','D_E_P47','D_E_P48','D_E_P49','D_E_P50','D_E_P51','D_E_P52','D_E_P53','D_E_P54','D_E_P55','D_E_P56','D_E_P57','D_E_P58','D_E_P59','D_E_P60','D_E_P61','D_E_P62','D_E_P63','D_E_P64','D_E_P65','D_E_P66','D_E_P67','D_E_P68','D_E_P69','D_E_P70','D_E_P71','D_E_P72','D_E_P73','D_E_P74','D_E_P75','D_E_P76','D_E_P77','D_E_P78','D_E_P79','D_E_P80','D_E_P81','D_E_P82','D_E_P83','D_E_P84','D_E_P85','D_E_P86','D_E_P87','D_E_P88','D_E_P89','D_E_P90','D_E_P91','D_E_P92','D_E_P93','D_E_P94','D_E_P95','D_E_P971','D_E_P972','D_E_P973','D_E_P974']}">
                <option value="${it}" ${it == rqt.fatherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label for="fatherBirthCountry" class=""><g:message code="mcr.property.fatherBirthCountry.label" />   <span><g:message code="mcr.property.fatherBirthCountry.help" /></span></label>
            <select id="fatherBirthCountry" name="fatherBirthCountry" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.fatherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label for="fatherNationality" class=""><g:message code="mcr.property.fatherNationality.label" />   <span><g:message code="mcr.property.fatherNationality.help" /></span></label>
            <select id="fatherNationality" name="fatherNationality" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('fatherNationality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.fatherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BS','BH','BD','BB','BE','BZ','BJ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GU','GT','GN','GQ','GW','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','CI','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.fatherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.fatherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  

  
    <fieldset class="required">
    <legend><g:message code="mcr.property.motherInformation.label" /></legend>
    
      <label for="motherLastName" class="required"><g:message code="mcr.property.motherLastName.label" /> *  <span><g:message code="mcr.property.motherLastName.help" /></span></label>
            <input type="text" id="motherLastName" name="motherLastName" value="${rqt.motherLastName?.toString()}" 
                    class="required  validate-lastName ${rqt.stepStates['parentage'].invalidFields.contains('motherLastName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherLastName.validationError" />"  maxlength="38" />
            

    
      <label for="motherFirstName" class="required"><g:message code="mcr.property.motherFirstName.label" /> *  <span><g:message code="mcr.property.motherFirstName.help" /></span></label>
            <input type="text" id="motherFirstName" name="motherFirstName" value="${rqt.motherFirstName?.toString()}" 
                    class="required  validate-firstName ${rqt.stepStates['parentage'].invalidFields.contains('motherFirstName') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="mcr.property.motherBirthDate.label" /> *  <span><g:message code="mcr.property.motherBirthDate.help" /></span></label>
            <div class="date required  validate-date required ">
              <select class="day ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_day"
                name="motherBirthDate_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.motherBirthDate?.date == it
                      || (rqt.motherBirthDate == null && params['motherBirthDate_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_month"
                name="motherBirthDate_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.motherBirthDate?.month == (it - 1)
                      || (rqt.motherBirthDate == null && params['motherBirthDate_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDate') ? 'validation-failed' : ''}"
                id="motherBirthDate_year"
                name="motherBirthDate_year"
                value="${rqt.motherBirthDate ? rqt.motherBirthDate.year + 1900 : params['motherBirthDate_year']}"
                title="<g:message code="mcr.property.motherBirthDate.validationError" />" />
            </div>
            

    
      <label for="motherBirthCity" class="required"><g:message code="mcr.property.motherBirthCity.label" /> *  <span><g:message code="mcr.property.motherBirthCity.help" /></span></label>
            <input type="text" id="motherBirthCity" name="motherBirthCity" value="${rqt.motherBirthCity?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthCity') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthCity.validationError" />"   />
            

    
      <label for="motherBirthDepartment" class=""><g:message code="mcr.property.motherBirthDepartment.label" />   <span><g:message code="mcr.property.motherBirthDepartment.help" /></span></label>
            <select id="motherBirthDepartment" name="motherBirthDepartment" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthDepartment') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthDepartment.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','D_E_P01','D_E_P02','D_E_P03','D_E_P04','D_E_P05','D_E_P06','D_E_P07','D_E_P08','D_E_P09','D_E_P10','D_E_P11','D_E_P12','D_E_P13','D_E_P14','D_E_P15','D_E_P16','D_E_P17','D_E_P18','D_E_P19','D_E_P2_A','D_E_P2_B','D_E_P21','D_E_P22','D_E_P23','D_E_P24','D_E_P25','D_E_P26','D_E_P27','D_E_P28','D_E_P29','D_E_P30','D_E_P31','D_E_P32','D_E_P33','D_E_P34','D_E_P35','D_E_P36','D_E_P37','D_E_P38','D_E_P39','D_E_P40','D_E_P41','D_E_P42','D_E_P43','D_E_P44','D_E_P45','D_E_P46','D_E_P47','D_E_P48','D_E_P49','D_E_P50','D_E_P51','D_E_P52','D_E_P53','D_E_P54','D_E_P55','D_E_P56','D_E_P57','D_E_P58','D_E_P59','D_E_P60','D_E_P61','D_E_P62','D_E_P63','D_E_P64','D_E_P65','D_E_P66','D_E_P67','D_E_P68','D_E_P69','D_E_P70','D_E_P71','D_E_P72','D_E_P73','D_E_P74','D_E_P75','D_E_P76','D_E_P77','D_E_P78','D_E_P79','D_E_P80','D_E_P81','D_E_P82','D_E_P83','D_E_P84','D_E_P85','D_E_P86','D_E_P87','D_E_P88','D_E_P89','D_E_P90','D_E_P91','D_E_P92','D_E_P93','D_E_P94','D_E_P95','D_E_P971','D_E_P972','D_E_P973','D_E_P974']}">
                <option value="${it}" ${it == rqt.motherBirthDepartment?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherBirthDepartment" /></option>
              </g:each>
            </select>
            

    
      <label for="motherBirthCountry" class=""><g:message code="mcr.property.motherBirthCountry.label" />   <span><g:message code="mcr.property.motherBirthCountry.help" /></span></label>
            <select id="motherBirthCountry" name="motherBirthCountry" class="  validate-select ${rqt.stepStates['parentage'].invalidFields.contains('motherBirthCountry') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherBirthCountry.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.motherBirthCountry?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherBirthCountry" /></option>
              </g:each>
            </select>
            

    
      <label for="motherNationality" class="required"><g:message code="mcr.property.motherNationality.label" /> *  <span><g:message code="mcr.property.motherNationality.help" /></span></label>
            <select id="motherNationality" name="motherNationality" class="required  validate-not-first ${rqt.stepStates['parentage'].invalidFields.contains('motherNationality') ? 'validation-failed' : ''}" title="<g:message code="mcr.property.motherNationality.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['NONE','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BS','BH','BD','BB','BE','BZ','BJ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GU','GT','GN','GQ','GW','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','CI','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.motherNationality?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="mcr.property.motherNationality" /></option>
              </g:each>
            </select>
            

    
    </fieldset>
  


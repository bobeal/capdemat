


  
    <label for="ambassadeOuPosteConsulaire" class=""><g:message code="serrr.property.ambassadeOuPosteConsulaire.label" />   <span><g:message code="serrr.property.ambassadeOuPosteConsulaire.help" /></span></label>
            <input type="text" id="ambassadeOuPosteConsulaire" name="ambassadeOuPosteConsulaire" value="${rqt.ambassadeOuPosteConsulaire?.toString()}" 
                    class="  validate-string ${rqt.stepStates['radiation'].invalidFields.contains('ambassadeOuPosteConsulaire') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.ambassadeOuPosteConsulaire.validationError" />"   />
            

  

  
    <label for="paysRadiation" class=""><g:message code="serrr.property.paysRadiation.label" />   <span><g:message code="serrr.property.paysRadiation.help" /></span></label>
            <select id="paysRadiation" name="paysRadiation" class="  validate-select ${rqt.stepStates['radiation'].invalidFields.contains('paysRadiation') ? 'validation-failed' : ''}" title="<g:message code="serrr.property.paysRadiation.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['UNKNOWN','AF','ZA','AL','DZ','DE','AD','AO','AI','AQ','AG','AN','SA','AR','AM','AW','AU','AT','AZ','BJ','BS','BH','BD','BB','PW','BE','BZ','BM','BT','BY','MM','BO','BA','BW','BR','BN','BG','BF','BI','CI','KH','CM','CA','CV','CL','CN','CY','CO','KM','CG','KP','KR','CR','HR','CU','DK','DJ','DM','EG','AE','EC','ER','ES','EE','US','ET','FI','FR','GE','GA','GM','GH','GI','GR','GD','GL','GP','GU','GT','GN','GQ','GW','GY','GF','HT','HN','HK','HU','CK','FJ','MH','SB','IN','ID','IR','IQ','IE','IS','IL','IT','JM','JP','JO','KZ','KE','KG','KI','KW','LA','LS','LV','LB','LR','LY','LI','LT','LU','MG','MY','MW','MV','ML','MT','MA','MU','MR','MX','FM','MD','MC','MN','MZ','NP','NA','NR','NI','NE','NG','NU','NO','NZ','OM','UG','UZ','PE','PK','PA','PG','PY','NL','PH','PL','PT','QA','CF','CD','DO','CZ','RO','GB','RU','RW','SN','KN','SM','VA','VC','LC','SV','WS','ST','SC','SL','SG','SI','SK','SO','SD','LK','SE','CH','SR','SZ','SY','TW','TJ','TZ','TD','TH','TL','TG','TO','VT','TN','TM','TR','TV','UA','UY','VU','VE','VN','YE','ZM','ZW','MK']}">
                <option value="${it}" ${it == rqt.paysRadiation?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="serrr.property.paysRadiation" /></option>
              </g:each>
            </select>
            

  


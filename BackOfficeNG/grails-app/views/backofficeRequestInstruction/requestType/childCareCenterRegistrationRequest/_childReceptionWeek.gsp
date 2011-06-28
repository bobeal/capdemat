

  <g:set var="listSize" value="${rqt.childReceptionWeek.size()}" />
  <h3>
    <a class="addListItem" id="add_childReceptionWeek[${listSize}]"></a>
    <span><g:message code="cccrr.property.childReceptionWeek.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.childReceptionWeek.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_childReceptionWeek[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
      <dt class="required"><g:message code="cccrr.property.day.label" /> * : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].day" class="action-editField validate-capdematEnum required-true i18n-cccrr.property.day javatype-fr.cg95.cvq.business.request.school.DaysType" >
        <g:capdematEnumToField var="${it?.day}" i18nKeyPrefix="cccrr.property.day" />
      </dd>
    
      <dt class="required"><g:message code="cccrr.property.period.label" /> * : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].period" class="action-editField validate-capdematEnum required-true i18n-cccrr.property.period javatype-fr.cg95.cvq.business.request.school.DayPeriodType" >
        <g:capdematEnumToField var="${it?.period}" i18nKeyPrefix="cccrr.property.period" />
      </dd>
    
      <dt class="required"><g:message code="cccrr.property.firstPeriodBegining.label" /> * : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].firstPeriodBegining" class="action-editField validate-string required-true i18n-cccrr.property.firstPeriodBegining" >
        <span>${it?.firstPeriodBegining}</span>
      </dd>
    
      <dt class="required"><g:message code="cccrr.property.firstPeriodEnding.label" /> * : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].firstPeriodEnding" class="action-editField validate-string required-true i18n-cccrr.property.firstPeriodEnding" >
        <span>${it?.firstPeriodEnding}</span>
      </dd>
    
      <dt class=""><g:message code="cccrr.property.secondPeriodBegining.label" />  : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].secondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.secondPeriodBegining" >
        <span>${it?.secondPeriodBegining}</span>
      </dd>
    
      <dt class=""><g:message code="cccrr.property.secondPeriodEnding.label" />  : </dt>
      <dd id="childReceptionWeek[${listSize - 1 - index}].secondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.secondPeriodEnding" >
        <span>${it?.secondPeriodEnding}</span>
      </dd>
    
  </dl>
  </g:each>

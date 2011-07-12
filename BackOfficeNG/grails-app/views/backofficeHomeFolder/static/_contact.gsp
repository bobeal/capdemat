<dt class="required">${message(code:'homeFolder.adult.property.email')}</dt>
<dd class="required">${adult.email}</dd>
<dt <g:if test="${adult.homePhone != null}">class="required"</g:if>>${message(code:'homeFolder.adult.property.homePhone')}</dt>
<dd class="required">${adult.homePhone}</dd>
<dt <g:if test="${adult.mobilePhone != null}">class="required"</g:if>>${message(code:'homeFolder.adult.property.mobilePhone')}</dt>
<dd class="required">${adult.mobilePhone}</dd>
<dt <g:if test="${adult.officePhone != null}">class="required"</g:if>>${message(code:'homeFolder.adult.property.officePhone')}</dt>
<dd class="required">${adult.officePhone}</dd>

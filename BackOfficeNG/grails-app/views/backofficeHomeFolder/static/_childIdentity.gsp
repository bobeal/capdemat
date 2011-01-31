<dt class="required">${message(code:'homeFolder.individual.property.lastName')}'</dt> 
<dd class="required">${child.lastName}</dd>
<dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
<dd class="required">${child.firstName}</dd>
<dt>${message(code:'homeFolder.individual.property.firstName2')}</dt>
<dd>${child.firstName2}</dd>
<dt>${message(code:'homeFolder.individual.property.firstName3')}</dt>
<dd>${child.firstName3}</dd>
<dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
<dd class="required"><g:formatDate formatName="format.date" date="${child.birthDate}"/></dd>
<dt>${message(code:'homeFolder.individual.property.birthPostalCode')}</dt>
<dd>${child.birthPostalCode}</dd>
<dt>${message(code:'homeFolder.individual.property.birthCity')}</dt>
<dd>${child.birthCity}</dd>
<dt>${message(code:'homeFolder.individual.property.birthCountry')}</dt>
<dd>${child.birthCountry}</dd>

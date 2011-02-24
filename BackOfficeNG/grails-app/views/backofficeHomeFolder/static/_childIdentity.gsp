<dt class="required">${message(code:'homeFolder.individual.property.lastName')}'</dt> 
<dd class="required">${individual.lastName}</dd>
<dt class="required">${message(code:'homeFolder.individual.property.firstName')}</dt>
<dd class="required">${individual.firstName}</dd>
<dt>${message(code:'homeFolder.individual.property.firstName2')}</dt>
<dd>${individual.firstName2}</dd>
<dt>${message(code:'homeFolder.individual.property.firstName3')}</dt>
<dd>${individual.firstName3}</dd>
<dt class="required">${message(code:'homeFolder.individual.property.birthDate')}</dt>
<dd class="required"><g:formatDate formatName="format.date" date="${individual.birthDate}"/></dd>
<dt>${message(code:'homeFolder.individual.property.birthPostalCode')}</dt>
<dd>${individual.birthPostalCode}</dd>
<dt>${message(code:'homeFolder.individual.property.birthCity')}</dt>
<dd>${individual.birthCity}</dd>
<dt>${message(code:'homeFolder.individual.property.birthCountry')}</dt>
<dd>${individual.birthCountry}</dd>

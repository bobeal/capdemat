<option value="">${message(code:'message.select.defaultOption')}</option>
<g:each var="school" in="${schoolSectors}">
    <option value="${school.key}">${school.value}</option>
</g:each>
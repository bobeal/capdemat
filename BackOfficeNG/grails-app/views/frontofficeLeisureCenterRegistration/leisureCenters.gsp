<option value="">${message(code:'message.select.defaultOption')}</option>
<g:each var="center" in="${leisureCenters}">
    <option value="${center.key}">${center.value}</option>
</g:each>
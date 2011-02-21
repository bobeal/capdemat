<option value="">${message(code:'message.select.defaultOption')}</option>
<g:each var="stop" in="${stops}">
    <option value="${stop.key}">${stop.value}</option>
</g:each>
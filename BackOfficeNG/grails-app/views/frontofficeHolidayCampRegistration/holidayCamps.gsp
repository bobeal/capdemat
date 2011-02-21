<option value="">${message(code:'message.select.defaultOption')}</option>
<g:each var="camp" in="${holidayCamps}">
    <option value="${camp.key}">${camp.value}</option>
</g:each>
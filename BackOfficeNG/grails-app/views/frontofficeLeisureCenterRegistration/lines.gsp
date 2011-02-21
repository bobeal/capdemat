<option value="">${message(code:'message.select.defaultOption')}</option>
<g:each var="line" in="${lines}">
    <option value="${line.key}">${line.value}</option>
</g:each>
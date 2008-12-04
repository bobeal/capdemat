<g:if test="${regex != null}">
	<input type="text" name="${name}" value="${value}" class="${validation} ${condition}" title="${title}" regex="${regex}"/>
</g:if>
<g:else>
	<input type="text" name="${name}" value="${value}" class="${validation} ${condition}" title="${title}"/>
</g:else>

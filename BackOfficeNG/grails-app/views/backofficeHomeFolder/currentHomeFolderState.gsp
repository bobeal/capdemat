<g:if test="${isValidable}">
<form method="post" action="${g.createLink(action:'validateHomeFolder',id:homeFolder.id)}">
<button id="validateHomeFolder">Valider le compte</button>
</g:if>
<span id="homeFolderState" class="tag-${homeFolderState}" style="float: right; font-size:1.1em">
            ${message(code:'user.state.' + homeFolderState)}
</span>
</form>

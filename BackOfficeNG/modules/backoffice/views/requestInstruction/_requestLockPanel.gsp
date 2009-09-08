<g:if test="${locked || lockedByCurrentUser}">
  <p>
    <g:message code="request.lock.locked.since" args="${[age, lifetime, lockerName]}" />
  </p>
</g:if>
<g:else>
  <p><g:message code="request.lock.free" /></p>
</g:else>
<g:if test="${lockedByCurrentUser}">
  <p>
    <input type="button" rel="lockRequest" value="Prolonger" />
    <input type="button" rel="releaseRequest" value="Libérer" />
  </p>
</g:if>
<g:elseif test="${!locked}">
  <p>
    <input type="button" rel="lockRequest" name="lock" value="Verrouiller" />
  </p>
</g:elseif>
<p>
  <input type="button" rel="refreshRequestLock" value="Actualiser" />
  <input type="button" rel="hideRequestLockPanel" value="Annuler" />
</p>
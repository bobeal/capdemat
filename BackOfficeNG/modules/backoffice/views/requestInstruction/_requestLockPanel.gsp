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
    <input type="button" rel="lockRequest" value="<g:message code='action.extend' />" />
    <input type="button" rel="releaseRequest" value="<g:message code='action.free' />" />
  </p>
</g:if>
<g:elseif test="${!locked}">
  <p>
    <input type="button" rel="lockRequest" name="lock" value="<g:message code='action.lock' />" />
  </p>
</g:elseif>
<p>
  <input type="button" rel="refreshRequestLock" value="<g:message code='action.refresh' />" />
  <input type="button" rel="hideRequestLockPanel" value="<g:message code='action.cancel' />" />
</p>
<%
ulCondition = ""
liCondition = ""
if(condition.contains("trigger")) liCondition = condition
else ulCondition = condition
%>

<ul class="${ulCondition}">
  <g:if test="${checked == true}">
    <li style="display: inline;">
       <input type="radio" class="${validation} ${liCondition}" title="${title}" value="true" name="${name}" checked="true"/>
	   <g:message code="widget.yesno.yes" />
    </li>
    <li style="display: inline;">
       <input type="radio" class="${liCondition}" value="false" name="${name}"/>
	   <g:message code="widget.yesno.no" />
    </li>
  </g:if>
   <g:else>
    <li style="display: inline;">
       <input type="radio" class="${validation} ${liCondition}" title="${title}" value="true" name="${name}"/>
	   <g:message code="widget.yesno.yes" />
    </li>
    <li style="display: inline;">
       <input type="radio" class="${liCondition}" value="false" name="${name}" checked="true" />
	   <g:message code="widget.yesno.no" />
    </li>
  </g:else>
  
</ul>


<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
    <c:if test="${error == 'error.remote_exception'}">
      <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
    </c:if>
  </p>
</c:if>
<c:if test="${error == null}">
  <c:if test="${tasksCount == null}">
    <p><fmt:message key="cvq.error.agent_not_configured"/>.</p>
  </c:if>
  <c:if test="${tasksCount != null}">
  <ul>
    <c:forEach items="${tasksCount}" var="currentTask">
      <c:if test="${currentTask.key == 'cvq.tasks.pending'}">
        <li>
          <a href="javascript:void(0);" onclick="javascript:window.open('${backofficeUrl}/searchAction.do?request=validate&name=request');">
            <fmt:message key="cvq.tasks.pending">
              <fmt:param>${currentTask.value}</fmt:param>
            </fmt:message>
          </a>
        </li>
      </c:if>
      <c:if test="${currentTask.key == 'cvq.tasks.opened'}">
        <li>
          <a href="javascript:void(0);" onclick="javascript:window.open('${backofficeUrl}/searchAction.do?request=open&name=request');">
            <fmt:message key="cvq.tasks.opened">
              <fmt:param>${currentTask.value}</fmt:param>
            </fmt:message>
          </a>
        </li>
      </c:if>
      <c:if test="${currentTask.key == 'cvq.tasks.validated'}">
        <li>
          <a href="javascript:void(0);" onclick="javascript:window.open('${backofficeUrl}/searchAction.do?request=notify&name=request');">
            <fmt:message key="cvq.tasks.validated">
              <fmt:param>${currentTask.value}</fmt:param>
            </fmt:message>
          </a>
        </li>
      </c:if>
    </c:forEach>
  </ul>
  </c:if>
  <p>
    <a href="javascript:void(0);" onclick="javascript:window.open('${backofficeUrl}');"><fmt:message key="cvq.common.goto_backoffice"/></a>
  </p>
</c:if>



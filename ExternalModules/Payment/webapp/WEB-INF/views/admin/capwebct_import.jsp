<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="admin.capwebct_import.title"/></title>
    <script type="text/javascript">	
		YAHOO.util.Event.onContentReady('capwebctImportFieldset', onDefaultSubmitButtonsMarkupReady);
    </script>
    
  </head>
  
  <body>
    <form method="post" action="#" >
      <fieldset id="capwebctImportFieldset">
        <legend><fmt:message key="admin.capwebct_import.import_legend"/></legend>
        <c:if test="${success_message != null}">
        	<div class="message">
        		<fmt:message key="${success_message}">
        			<fmt:param value="${success_message_param_created}" />
        			<fmt:param value="${success_message_param_modified}" />
        		</fmt:message>
        	</div>
        </c:if>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<c:if test="${error_message_param}">
        				<fmt:param value="${error_message_param}"></fmt:param>
        			</c:if>
        		</fmt:message>
        	</div>
        </c:if>
        <label for="wrappedSubmit">&nbsp;</label>
        <input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
        	value="<fmt:message key="action.import"/>"/>
      </fieldset>
    </form>
  </body>  
</html>

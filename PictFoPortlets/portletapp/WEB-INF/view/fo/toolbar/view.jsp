<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://cvq.pict.org/jsp/taglib" prefix="cvq"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
    <c:if test="${error == 'error.remote_exception'}">
      <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
    </c:if>
  </p>
</c:if>
<c:if test="${error == null}">


  <div class="cvqfo-toolbar-menu cvqfo-toolbar-individual-menu" onclick="Effect.Fade('documents'); Effect.toggle('adults', 'slide', { duration: 0.5 }); return false;">Les adultes</div>
  <div id="adults" style="display:none;">
    <c:forEach items="${adults}" var="adult">
      <div class="cvqfo-toolbar-menu-entry cvqfo-toolbar-adult-menu-entry" id="${adult.id}">${adult.firstName}</div>
    </c:forEach>
    <script type="text/javascript" language="javascript">
    	  function registerAdultDraggables() {
	    <c:forEach items="${adults}" var="adult">
			new Draggable('${adult.id}',{revert:true});
	    </c:forEach>
	  }
	  initFunctions.push(registerAdultDraggables);
    </script>
  </div>
	
  <div class="cvqfo-toolbar-menu cvqfo-toolbar-document-menu" onclick="Effect.Fade('adults'); Effect.toggle('documents','slide', { duration: 0.5 }); return false;">Les justificatifs</div>
  <div id="documents" style="display:none">
    <c:forEach items="${homeFolderDocuments}" var="document">
      <div class="cvqfo-toolbar-menu-entry cvqfo-toolbar-document-menu-entry" id="${document.id}">${document.documentType.name}</div>
    </c:forEach>
    <script type="text/javascript" language="javascript">
    	  function registerDocumentDraggables() {
	    <c:forEach items="${homeFolderDocuments}" var="document">
			new Draggable('${document.id}',{revert:true});
	    </c:forEach>
	  }
	  initFunctions.push(registerDocumentDraggables);
    </script>
  </div>
	
</c:if>


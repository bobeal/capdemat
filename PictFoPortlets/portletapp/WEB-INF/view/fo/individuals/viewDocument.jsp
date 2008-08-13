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

 <fieldset>
   
   <c:if test="${homeFolderDocuments != null}" >
        <div class="cvqfo-toolbar-menu cvqfo-toolbar-document-menu" onclick="Effect.Fade('adults');Effect.Fade('children'); 
           Effect.toggle('documents','slide', { duration: 0.5 }); return false;">   
          
          <label class="portlet-form-label">Foyer</label>   
        </div>
        
        <div id="documents" style="display:none">
           <ul>
                 <c:forEach items="${homeFolderDocuments}" var="document">
                     <li class="cvqfo-request">
                         <div class="cvqfo-toolbar-menu-entry cvqfo-toolbar-document-menu-entry" id="${document.id}">
                              <a href="@cvq/documents?documentId=${document.id}&name=${currentUser}">
                                 ${document.documentType.name}
                              </a>
                         </div>
                     </li>
                 </c:forEach>
           </ul>
        </div>
   </c:if>
 
   <c:if test="${adult != null}" >
        <div class="cvqfo-toolbar-menu cvqfo-toolbar-document-menu" onclick="Effect.Fade('adults');Effect.Fade('children'); 
            Effect.toggle('adultDocuments','slide', { duration: 0.5 }); return false;">   
     
           <label class="portlet-form-label">${adult.firstName} ${adult.lastName}</label>   
        </div>
         
         <div id="adultDocuments" style="display:none">
              <ul>
                 <c:forEach items="${adult.documents}" var="document">
                    <li class="cvqfo-request">
                        <a href="@cvq/documents?documentId=${document.id}&name=${adult.login}">    
                                  ${document.documentType.name} 
                        </a>
                    </li> 
                 </c:forEach>
              </ul>
                     
         </div>
   </c:if>

   <c:if test="${child != null}" >
         <div class="cvqfo-toolbar-menu cvqfo-toolbar-document-menu" onclick="Effect.Fade('adults');Effect.Fade('children'); 
              Effect.toggle('childDocuments','slide', { duration: 0.5 }); return false;" >   
     
            <label class="portlet-form-label">${child.firstName} ${child.lastName}</label>   
         </div>
         
         <div id="childDocuments" style="display:none">
              <ul>
                 <c:forEach items="${child.documents}" var="document">
                    <li class="cvqfo-request">
                        <a href="@cvq/documents?documentId=${document.id}&name=${currentUser}">    
                                  ${document.documentType.name}
                        </a>
                    </li> 
                 </c:forEach>
              </ul>
         </div>
   </c:if>
 </fieldset>
</c:if>
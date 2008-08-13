<%@ page contentType="text/html ; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources" />

<c:if test="${error != null}">
  <p>
     <c:if test="${error == 'error.remote_exception'}">
         <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception" />.</span>
     </c:if>
  </p>
</c:if>

<c:if test="${error == null}">

 <fieldset>
    <a href="@cvq/individu/details?homeFolderId=${homeFolderId}"> <label class="portlet-form-label">Accueil Foyer</label></a>
    <c:if test="${adults != null}">
        
         <div onclick="Effect.toggle('adults','blind'); return false;"><label
              class="portlet-form-label">Les adultes</label>
         </div>
         <div id='adults' style="display:none;">
            <ul id="sortableList">
       
                <c:forEach items="${adults}" var="adult">
                    <li class="cvqfo-request">
       
                       <div onclick="Effect.toggle('${adult.id}','blind'); return false;">  
                             <!--  <a href="@cvq/individu/details?idAdult=${adult.id}"  > -->
                             ${adult.firstName} ${adult.lastName} 
                             <!--  </a> -->
                       </div>
                       <div id='${adult.id}' style="display:none;">
                          <ul id="innerList">
                             <li><a href="@cvq/individu/deletion?supprim=ok&idAdult=${adult.id}"  >supprimer</a> 
                             </li>
                             <li><a href="@cvq/individu/details?idAdult=${adult.id}"  >voir/modifier</a> 
                             </li>
                          </ul>
                          <p id="list-info2"></p>
                       </div>
          
                    </li>
                </c:forEach>
                
            </ul>
            <p id="list-info"></p>
         </div>
    </c:if> 
    <c:if test="${children != null}">
         <div onclick="Effect.toggle('children','slide'); return false;"><label
              class="portlet-form-label">Les enfants</label>
         </div>
         <div id='children' style="display:none;">
            <ul id="sortableListChildren">
            
                <c:forEach items="${children}" var="child">
                    <li class="cvqfo-request">
       
                       <div onclick="Effect.toggle('${child.id}','blind'); return false;">  
                             <!--  <a href="@cvq/individu/details?idAdult=${adult.id}"  > -->
                             ${child.firstName} ${child.lastName} 
                             <!--  </a> -->
                       </div>
                       <div id='${child.id}' style="display:none;">
                          <ul>
                             <li><a href="@cvq/individu/deletion?supprim=ok&idChild=${child.id}"  >supprimer</a></li>
                             <li><a href="@cvq/individu/details?idChild=${child.id}"  >voir/modifier</a>
                             </li>
                          </ul>
                       </div>
                       
                    </li>
                </c:forEach>
            </ul>
            <p id="list-info2"></p>
         </div>
    </c:if>
</fieldset>

</c:if>



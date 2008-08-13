<%@ page contentType="text/html ; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources" />
<portlet:defineObjects/>
<fieldset>
                       
      <c:if test="${adult != null}">
           <form method="post" action="<portlet:actionURL>
                                          <portlet:param name='action' value='deleteIndividual' />
                                          <portlet:param name='isAdult' value='true' />
                                          <portlet:param name='idAdult' value='${adult.id}' />
                                       </portlet:actionURL>" 
           >
                
                <h3 align="center"> Vous etes sur de supprimer : <c:out value="${adult.lastName} ${adult.firstName}" /> <h3>
                
                <center><input type="submit" value="supprimer" /></center>
           </form>
      </c:if>
      <c:if test="${child != null}">
            <form method="post" action="<portlet:actionURL>
                                            <portlet:param name='action' value="deleteIndividual"/>
                                            <portlet:param name="isAdult" value="false" />
                                            <portlet:param name="idChild" value="${child.id}" />
                                        </portlet:actionURL>"  
             >
                         
                <h3 align="center"> Vous etes sur de supprimer : <c:out value="${child.lastName} ${child.firstName}" /> <h3>
               <center> <input type="submit" value="supprimer" /> </center>
           
           </form>
      </c:if>
      <br/>
</fieldset>
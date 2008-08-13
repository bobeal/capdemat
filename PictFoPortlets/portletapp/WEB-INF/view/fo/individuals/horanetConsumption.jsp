
<%@ page contentType="text/html ; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ page   import="java.util.Set,java.util.Map" %>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources" />

<c:if test="${error != null}">
  <p>
     <c:if test="${error == 'error.remote_exception'}">
         <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception" />.</span>
     </c:if>
  </p>
</c:if>

<portlet:defineObjects/>
<fieldset>
<c:if test="${adults != null}">
       
         <div onclick="Effect.toggle('adultsHoranet','blind'); return false;"><label
              class="portlet-form-label">Les adultes</label>
         </div>
  
         <div id='adultsHoranet' style="display:none;">
            <ul id="sortableList">
       
                <c:forEach items="${adults}" var="adult">
                    <li class="cvqfo-request">
       
                     <a  href="<portlet:actionURL><portlet:param name="idAdult" value="${adult.id}" /><portlet:param name="action" value="consumption" /></portlet:actionURL>" > 
                    
                           ${adult.firstName} ${adult.lastName} 
                    </a> 
                    </li>
                </c:forEach>
            </ul>
         </div>
    </c:if> 
    <c:if test="${children != null}">
         <div onclick="Effect.toggle('childrenHoranet','slide'); return false;"><label
              class="portlet-form-label">Les enfants</label>
         </div>
         <div id='childrenHoranet' style="display:none;">
            <ul id="sortableListChildren">
            
                <c:forEach items="${children}" var="child">
                    <li class="cvqfo-request">
       
                      <a  href="<portlet:actionURL><portlet:param name="idChild" value="${child.id}" /><portlet:param name="action" value="consumption" /></portlet:actionURL>" > 
                    
                           ${child.firstName} ${child.lastName} 
                    </a> 
                       
                    </li>
                </c:forEach>
            </ul>
            <p id="list-info2"></p>
         </div>
    </c:if>

    <br/>
    <br/>
   <!-- <div id='consomationHoranet' style="display:none;"> -->
         
             
               <c:if test="${consumptionAdultRequests != null}" >
                 <fieldset>
                  <label class="portlet-form-label">Consommations</label>  
                  <form id="formHoranet" action="<portlet:actionURL>
                                                      <portlet:param name="idAdult"     value="${idAdult}" />
                                                      <portlet:param name="action"      value="showDetailsConsumption" />
                                                      <portlet:param name="fromForm"    value="true" />
                                                 </portlet:actionURL>" method="post">
                           <br/>       
                           <table>
                             <tr> 
                                <td colspan="2">
                                   <select name="requests">        
                                        <c:forEach items="${consumptionAdultRequests}" var="request">
                                           <option value="${request.requestType.label}"> ${request.requestType.label} </option>
                                        </c:forEach>
                                   </select>
                                </td>
                                
                              </tr>
                              <tr>
                                <td colspan="2">&nbsp;</td>
                              </tr>
                              <tr>
                                 <td colspan="2"> 
                                   <script>DateInput('fromdate', true, 'DD-MON-YYYY')</script>
                               </td>
                              </tr>
                              <tr>
                                <td colspan="2">&nbsp;</td>
                              </tr>
                              <tr>  
                                <td>  
                                <td colspan="2"> 
                                  <input type="radio" name="displayType" value="Détaillé" checked="true" >Détaillé</input>
                                  <input type="radio" name="displayType" value="Résumé" >Résumé</input>
                                </td>
                              </tr>
                              <tr>
                                <td colspan="2">&nbsp;</td>
                              </tr>
                              <tr>
                                 <td colspan="2" align="center">  <input type="submit" value="Consulter" /> </td>
                              </tr>
                           </table>
                   </form>
                 </fieldset>           
                </c:if>
                <c:if test="${consumptionChildRequests != null}" >
                   <fieldset>
                    <label class="portlet-form-label">Consommations</label> 
                    <form id="formHoranet2" action="<portlet:actionURL>
                                                        <portlet:param name="idChild"     value="${idChild}" />
                                                        <portlet:param name="action"      value="showDetailsConsumption" />
                                                        <portlet:param name="fromForm"    value="true" />
                                                    </portlet:actionURL>" method="post">  
                           <br/>     
                           <table>
                            <tr> 
                               <td colspan="2">
                                  <select name="requests">        
                                       <c:forEach items="${consumptionChildRequests}" var="request">
                                          <option value="${request.requestType.label}"> ${request.requestType.label} </option>
                                       </c:forEach>
                                  </select>
                               </td>
                               
                             </tr>
                             <tr>
                               <td colspan="2">&nbsp;</td>
                             </tr>
                             <tr>
                               <td colspan"2"> 
                                   <script>DateInput('fromdate', true, 'DD-MON-YYYY')</script>
                               </td>
                             </tr>
                             <tr>
                               <td colspan="2">&nbsp;</td>
                             </tr>
                             <tr>  
                               <td colspan="2"> <input type="radio" name="displayType"  value="Détaillé" checked="true" >Détaillé</input>
                                 <input type="radio" name="displayType" value="Résumé" >Résumé</input>
                               </td>
                             </tr>
                             <tr>
                               <td colspan="2">&nbsp;</td>
                             </tr>
                             <tr>
                             
                                <td  align="center" colspan="2">  
                                  <input type="submit" value="Consulter" /> 
                                </td>
                             </tr>
                          </table>
                   </form>
                  </fieldset>            
                </c:if>
                <br/>
                <c:if test="${detailsConsumption != null}">
                <fieldset>
                    <div class="cvqfo-requestlist">
                     <c:if test="${Résumer != 'yes'}" >
                           <table width="100%">
                            <tr>
                              <td>Type consommation</td>
                              <td>Date</td>
                            </tr>
                            <c:forEach items="${detailsConsumption}" var="req">
                                <tr>
                                  <td> 
                                    ${req.value}
                                  </td>
                                  <td>${req.key}</td>
                                </tr>
                            </c:forEach>
                           </table>
                     </c:if>
                     <c:if test="${Résumer == 'yes'}" >
                       <table width="100%">
                          
                          <c:forEach items="${detailsConsumption}" var="req">
                              <tr>
                                  <td> 
                                    ${req.key}
                                  </td>
                                  <td> 
                                    ${req.value}
                                  </td>
                              </tr>   
                          </c:forEach>
                       </table>
                     </c:if>
                    </div>
                    
                </fieldset>
                </c:if>
                                                        
           </form>
   <!-- </div> -->



</fieldset>
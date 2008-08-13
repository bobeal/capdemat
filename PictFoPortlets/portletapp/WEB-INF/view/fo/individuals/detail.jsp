<%@ page contentType="text/html ; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources" />

<c:if test="${error != null}">
	<p><c:if test="${error == 'error.remote_exception'}">
		<span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception" />.</span>
	</c:if></p>
</c:if>

<portlet:defineObjects/>

<c:if test="${error == null}">
	<div >
      <fieldset >
        <c:if test="${adult == null and child == null or homeFolderId != null}" >
            
            <div id="accueil">
             <br/>
               <center><h2>Espace Foyer </h2></center>
              <p> 
                 <i>
                  Bienvenue sur votre espace foyer. Vous pouvez consulter tous les individus de votre compte,
                  les modifier, les supprimer. Aussi vous pouvez voir les pieces justificatives liées à tout le foyer 
                  ou seulement celles d'un individu particulier.
                  Bonne visite
                </i>
              </p>
              <br/>
            </div>
        </c:if>
		<c:if test="${adult != null and homeFolderId == null}">

         <form id="formModifIndividu" name="modifyIndividu" 
               action="<portlet:actionURL>
                         <portlet:param name="action" value="updateAdult" />
                         <portlet:param name="isAdult" value="true" />
                         <portlet:param name="id"     value="${adult.id}" />
                       </portlet:actionURL>"  method="post">
                       
    	   <table border="0" width="100%">
              <script type="text/javascript">
                
               function editForm(){
                 new Ajax.InPlaceEditor('lastname', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})       ;
                 new Ajax.InPlaceEditor('firstname1', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('firstname2', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('firstname3', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('birthDate', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})      ;
                 new Ajax.InPlaceEditor('birthCity', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})      ;
                 new Ajax.InPlaceEditor('birthPostalCode', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30});
                // new Ajax.InPlaceEditor('sex', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})            ;
                 new Ajax.InPlaceEditor('adress', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})         ;
                 new Ajax.InPlaceEditor('city', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})           ;
                 new Ajax.InPlaceEditor('postalCode', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceCollectionEditor('sex', '', {collection: ['Unknown','Male','Female'],cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ"});
                }
                initFunctions.push (editForm)  ;
               
            </script>
            <tr>
                <th>Nom  :</th>
                <td>
                   <p id="lastname"><c:out value="${adult.lastName}" /> 
                    </p>
                  </td>
            </tr>
			<tr>
				<th>Prenom 1 :</th>
				<td>
                    <p id="firstname1"><c:out value="${adult.firstName}" /> 
                   </p>
				</td>
			</tr>
            <tr>
               <th>Prenom 2 :</th>
               <td>
                   <p id="firstname2"><c:out value="${adult.firstName2}" /> 
                   </p>
               </td>
            </tr>
            <tr>
               <th>Prenom 3 :</th>
               <td>
                   <p id="firstname3"><c:out value="${adult.firstName3}" />          
                   </p>
               </td>
            </tr>
			<tr>
				<th>Date de naissance :</th>
				<td>
                 <p id="birthDate"><fmt:formatDate value="${adult.birthDate}" type="date" pattern="dd MMMM yyyy"/> 
                 </p>
				</td>
			</tr>
			<tr>
				<th>Lieu de naissance :</th>
                 <td> 
                   <p id="birthCity"><c:out value="${adult.birthCity}" />
                   </p>                 
                </td>   
			</tr>
             <tr>
               <th>Code postal ville naiss :</th>
               <td>
                 <p id="birthPostalCode"><c:out value="${adult.birthPostalCode}" /> 
                 </p>
               </td>
             </tr> 
            <tr>
               <th>Sexe :</th>
               <td>
                   <p id="sex"><c:out value="${adult.sex}" /> 
                  </p>
               </td>
            </tr>
            <tr>
               <th>Adresse :</th>
               <td>
                  <p id="adress"><c:out value="${adult.adress.adress}" /> 
                  </p>
               </td>
            </tr>
             <tr>
               <th>Ville :</th>
                 <td>
                   <p id="city"><c:out value="${adult.adress.city}" /> 
                   </p>
               </td>
            </tr> 
            <tr>
               <th>Code postal :</th>
               <td>
                 <p id="postalCode"><c:out value="${adult.adress.postalCode}" />        
                  </p>
               </td>
            </tr> 
            <tr align="center"><td colspan="2" > <INPUT class="cvq-input" type="submit" value="valider" /></td></tr>
          </table>
          </form>  
		</c:if>
		<c:if test="${child != null and homeFolderId == null}">
           <form id="formModifIndividu" name="modifyIndividu" 
                 action="<portlet:actionURL>
                         <portlet:param name="action" value="updateChild" />
                         <portlet:param name="id"     value="${child.id}" />
                       </portlet:actionURL>"  method="post">
                 
             <table border="0" width="100%">
              <script type="text/javascript">
                      
                 function editForm(){
                 new Ajax.InPlaceEditor('lastname', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})       ;
                 new Ajax.InPlaceEditor('firstname1', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('firstname2', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('firstname3', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceEditor('birthDate', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})      ;
                 new Ajax.InPlaceEditor('birthCity', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})      ;
                 new Ajax.InPlaceEditor('birthPostalCode', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30});
                 //new Ajax.InPlaceEditor('sex', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})            ;
                 new Ajax.InPlaceEditor('adress', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})         ;
                 new Ajax.InPlaceEditor('city', '',{clickToEditText:"cliquer pour changer la valeur du champ",cols:30})           ;
                 new Ajax.InPlaceEditor('postalCode', '',{cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ",cols:30})     ;
                 new Ajax.InPlaceCollectionEditor('sex', '', {collection: ['Unknown','Male','Female'],cancelText:"annuler",clickToEditText:"cliquer pour changer la valeur du champ"});
                 
                }
                initFunctions.push (editForm) ;
               
             </script>
                <tr>
                     <th>Nom :</th>
                     <td><p id="lastname"><c:out value="${child.lastName}" /> 
                         </p>
                     </td>
                 </tr>
                 <tr>
                 <th>Prenom 1 :</th>
                     <td>
                         <p id="firstname1"><c:out value="${child.firstName}" /> </p>
                     </td>
                 </tr>
                 <tr>
                    <th>Prenom 2 :</th>
                    <td>
                     <p id="firstname2"><c:out value="${child.firstName2}" /> </p>
                    </td>
                 </tr>
                 <tr>
                    <th>Prenom 3 :</th>
                    <td>
                      <p id="firstname3"> <c:out value="${child.firstName3}" /> 
                    </td>
                 </tr>
                 <tr>
                 <th>Date de naissance :</th>
                    <td>
                      <p id="birthDate"><fmt:formatDate value="${child.birthDate}" type="date" pattern="dd MMMM yyyy"/> </p>
                    </td>
                 </tr>
                 <tr>
                   <th>Lieu de naissance :</th>
                   <td> <p id="birthCity"><c:out value="${child.birthCity}" /> </p>
                   </td>   
                 </tr>
                  <tr>
                    <th>Code postal ville naiss :</th>
                    <td>
                      <p id="birthPostalCode"><c:out value="${child.birthPostalCode}" /> </p>
                    </td>
                  </tr> 
                 <tr>
                    <th>Sexe :</th>
                    <td>
                        <p id="sex"> <c:out value="${child.sex}" /></p>
                    </td>
                 </tr>
                 <tr>
                    <th>Adresse :</th>
                    <td>
                       <p id="adress"> <c:out value="${child.adress.adress}" /> </p>
                    </td>
                 </tr>
                  <tr>
                    <th>Ville :</th>
                    <td>  <p id="city">  <c:out value="${child.adress.city}" /> </p>
                    </td>
                 </tr>
                 <tr>
                    <th>Code postal</th>
                    <td>
                      <p id="postalCode"><c:out value="${child.adress.postalCode}" /> </p>
                    </td>
                 </tr>
                 <tr align="center"><td colspan="2" > <INPUT class="cvq-input" type="submit" value="valider" /></td></tr>
    	   </table>
    	   </fieldset>
    	  </form>
		</c:if>
	</div>
</c:if>

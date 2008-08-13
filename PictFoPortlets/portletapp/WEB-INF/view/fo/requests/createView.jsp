<%@ page contentType="text/html ; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://cvq.pict.org/jsp/taglib" prefix="cvq"%>

<portlet:actionURL var="actionURL"/>

<script type="text/javascript" language="javascript">
  function setCurrentUser() {
    currentUser = '${currentUser}';
  }
  initFunctions.push(setCurrentUser);
</script>

<fmt:setBundle basename="com.zenexity.pict.cvq.bo.TranslationResources"/>

<c:if test="${error != null}">
  <p>
    <c:if test="${error == 'error.remote_exception'}">
      <span class="portlet-msg-error"><fmt:message key="cvq.error.remote_exception"/>.</span>
    </c:if>
  </p>
</c:if>
<c:if test="${error == null}">
  <div id="requestCreationStatus"></div>
  <form method="POST" action="${actionURL}" id="createRequestForm">

	<fieldset class="cvqfo-newrequest" id="requestSubject">
	  <legend>Sujet de la demande</legend>
	    <p>
      		<label class="portlet-form-field-label">Nom :</label>
      		<input type="hidden" id="id" name="id" />
      		<input type="text" id="lastName" name="lastName" class="portlet-form-input-field" />
    		</p>
	    <p>
      		<label class="portlet-form-field-label">Prénom :</label>
      		<input type="text" id="firstName" name="firstName" class="portlet-form-input-field" />
    		</p>
	    <script type="text/javascript" language="javascript">
    		  function registerSubjectDroppable() {
    		  	 Droppables.add('requestSubject', {
    		  	 	accept: 'cvqfo-toolbar-adult-menu-entry',
   				hoverclass: 'cvqfo-newrequest-drophover',
   				onDrop: function(draggable, droppable) {
					ECitizenDataCache.getAdultByKeyAndId(fillSubjectForm, currentUser, draggable.id); 
        			}
        		 });
	  	  }
	  	  initFunctions.push(registerSubjectDroppable);
	  	  function fillSubjectForm(aperson) {
		    person = aperson;
    			DWRUtil.setValues(aperson);
		  }
    		</script>
	</fieldset>

	<fieldset class="cvqfo-newrequest" id="requestSpecifics">
	  <legend>Informations spécifiques</legend>
	    <p>
      		<label class="portlet-form-field-label">Nationalité :</label>
      		<input type="text" id="subjectNationality" name="subjectNationality" class="portlet-form-input-field" />
    		</p>
	    <p>
      		<label class="portlet-form-field-label">Raison de la demande :</label>
      		<select id="motive" name="motive" class="portlet-form-input-field">
      			<option value="NewCityResident">Domicilié dans la commune ou y habitant depuis six mois au moins<option>
      			<option value="DirectCityContribution">Participe aux contributions directes communales pour la cinquième fois sans interruption</option>
      			<option value="CivilServantObligatoryResident">Fonctionnaire public assujetti à résidence obligatoire dans la commune</option>
      			<option value="FutureAuthorizedCitizen">Remplira les conditions d'âge et de résidence d'ici la clôture définitive des listes</option>
      		</select>
    		</p>
	    <p>
      		<label class="portlet-form-field-label">Ancienne commune :</label>
      		<input type="text" id="subjectOldCity" name="subjectOldCity" class="portlet-form-input-field" />
    		</p>
	    <script type="text/javascript" language="javascript">
    		  function createRequestObject() {
			RequestCreator.getNewElectoralRollRegistrationRequest(setRequestObject); 
	  	  }
	  	  initFunctions.push(createRequestObject);
	  	  function setRequestObject(arequest) {
		    request = arequest;
    			DWRUtil.setValues(request);
		  }
    		</script>
	</fieldset>

	<fieldset class="cvqfo-newrequest" id="requestDocuments">
	  <legend>Pièces justificatives</legend>
	    <p>Déposez ici les pièces justificatives que vous voulez joindre à votre demande</p>
	    <div id="documentDisplayer"></div>
	    <script type="text/javascript" language="javascript">
    		  function registerDocumentDroppable() {
    		  	 Droppables.add('requestDocuments', {
    		  	 	accept: 'cvqfo-toolbar-document-menu-entry',
   				hoverclass: 'cvqfo-newrequest-drophover',
   				onDrop: function(draggable, droppable) {
					ECitizenDataCache.getDocumentByKeyAndId(fillDocumentForm, currentUser, draggable.id); 
        			}
        		 });
	  	  }
	  	  initFunctions.push(registerDocumentDroppable);

		  documentList = new Array();

	  	  function fillDocumentForm(adocument) {
			var imageDiv = document.createElement('div');
			imageDiv.setAttribute('id', adocument.id);
			imageDiv.setAttribute('class', 'cvqfo-newrequest-document-gallery');
			var imgElement = document.createElement('img');
			imgElement.setAttribute('width', '40%');
			imgElement.setAttribute('src', '/ppa-com.zenexity.pict.cvq/image?documentId=' + adocument.id + '&name=' + currentUser);
			imageDiv.appendChild(imgElement);
    			document.getElementById('documentDisplayer').appendChild(imageDiv);
			documentList.push(adocument.id);
		  }
    		</script>
	</fieldset>
	<input class="portlet-form-button" type="button" onclick="javascript:createRequest();" value="enregistrer" />
	<input class="portlet-form-button" type="button" onclick="javascript:window.location.href='@cvq/requests/category';" value="annuler" />
	<script type="text/javascript">
		function createRequest() {
			DWRUtil.getValues(person);
			DWRUtil.getValues(request);
			RequestCreator.create(displayCreationResult, request, person, documentList, currentUser);
		}
		function displayCreationResult(requestId) {
			var resultParagraph = document.createElement('p');
			if (requestId == '-1') {
				resultParagraph.setAttribute('class', 'portlet-msg-error');
				resultParagraph.innerHTML = 'Une erreur s\'est produite lors de l\'enregistrement de votre demande. Merci de ré-essayer ultérieurement';
			} else {
				resultParagraph.setAttribute('class', 'portlet-msg-info');
				resultParagraph.innerHTML = 'Votre demande a été enregitré avec le numéro ' + requestId;
			}
			document.getElementById('requestCreationStatus').appendChild(resultParagraph);
		}
	</script>
  </form>
</c:if>

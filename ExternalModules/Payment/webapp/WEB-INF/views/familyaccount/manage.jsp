<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="familyaccount.manage.title"/></title>
	<script type="text/javascript">
		<c:if test="${bindings != null}">
		YAHOO.example.Data = {
    		familybindings: [
    		  	<c:forEach items="${bindings}" var="binding" varStatus="status">
  					{externalFamilyAccountId:"<c:out value="${binding.externalFamilyAccountId}" />+<c:out value="${binding.externalApplication.id}" />+<c:out value="${binding.capwebctFamilyAccount.capwebctFamilyAccountId}" />",
  					 externalApplicationLabel:"<c:out value="${binding.externalApplication.label}" />"}
  					 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < bindingsSize}">,</c:if>
  				</c:forEach>
			]
    	};

		function formatActionColumn(elCell, oRecord, oColumn, oData) {
			var idTab = oData.split('+');
			var urlEdit = '<c:url value="/homefolder/manage.jsp?action=manage' 
				+ '&cfaId=' + idTab[2]
				+ '&efaId=' + idTab[0] 
				+ '&externalApplicationId=' + idTab[1] 
				+ '"/>';
			elCell.innerHTML = "<a href='" + urlEdit + "'>" 
				+ idTab[0] + "</a>";
		}

		YAHOO.util.Event.addListener(window, "load", function() {
    		YAHOO.example.Basic = new function() {
        		var myColumnDefs = [
            		{key:"externalFamilyAccountId", sortable:true, formatter:formatActionColumn,
            			label:"<fmt:message key='table.header.id'/>"},
            		{key:"externalApplicationLabel", sortable:true,
            			label:"<fmt:message key='table.header.application'/>"},
            		{key:"delete", label:' ', 
            			formatter:function(elCell) {
        					elCell.innerHTML = '<img src="<c:url value="/img/icon_delete.gif"/>" title="<fmt:message key="action.delete"/>" />';
        					elCell.style.cursor = 'pointer';
        				}
        			}
        		];

        		this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.familybindings);
        		this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        		this.myDataSource.responseSchema = {
            		fields: ["externalFamilyAccountId", "externalApplicationLabel"]
        		};

        		this.myDataTable = new YAHOO.widget.DataTable("familyBindingsData",
                	myColumnDefs, this.myDataSource, 
                	{sortedBy:{key:"externalFamilyAccountId", dir:"asc"}});
                	
                this.myDataTable.subscribe('cellClickEvent',function(ev) {
    				var target = YAHOO.util.Event.getTarget(ev);
    				var column = this.getColumn(target);
    				if (column.key == 'delete') {
    					var record = this.getRecord(target);
    					var dataTable = this;
    					var handleYes = function() {
    						var efaIdColumnData = record.getData('externalFamilyAccountId');
    						var splittedEfaIdColumnData = efaIdColumnData.split('+');
							var url = '<c:url value="/homefolder/efaLoader.jsp"/>' 
									+ '?action=deleteFamilyAccountBinding'
									+ '&externalApplicationId=' + splittedEfaIdColumnData[1]
									+ '&externalFamilyAccountId=' + splittedEfaIdColumnData[0];
							YAHOO.util.Connect.asyncRequest('GET', url,
								{
									success: function (o) {
										if (o.responseText == 'OK') {
                            				dataTable.deleteRow(target);
                            				this.hide();
                        				} else {
                            				alert(o.responseText);
                        				}
                    				},
                    				failure: function (o) {
                        				alert(o.statusText);
                    				},
                    				scope:this
                				}
                			);
    					}
						var deleteDialog = 
							new YAHOO.widget.SimpleDialog("deleteDialog", 
			 					{ 
			 						width: "300px",
			   						fixedcenter: true,
			   						visible: false,
			   						draggable: false,
			   						close: true,
			   						text: "<fmt:message key='action.confirm_delete' />",
			   						icon: YAHOO.widget.SimpleDialog.ICON_WARN,
			   						constraintoviewport: true,
			   						buttons: [ { text:"<fmt:message key='common.yes' />", handler:handleYes, isDefault:true },
						  							{ text:"<fmt:message key='common.no' />", handler:function() {this.hide();}  } ]
			 					} 
			 				);
			 			deleteDialog.render(document.body);
			 			deleteDialog.show();
    				}
    			});
	  		}
	  	});
	  </c:if>
	  
	  function updateEfaList(efaList) {
	  	var efaIdElement = document.getElementById('efaId');
		efaIdElement.parentNode.removeChild(efaIdElement);
		if (efaList == null || efaList.length == 0) {
			var efaInput = document.createElement("input");
			efaInput.setAttribute("id", "efaId");
			efaInput.setAttribute("name", "efaId");
			efaInput.setAttribute("type", "text");
			YAHOO.util.Dom.insertAfter(efaInput, document.getElementById('efaIdLabel'));
		} else {
			var efaSelect = document.createElement('select');
			efaSelect.setAttribute("id", "efaId");
			efaSelect.setAttribute("name", "efaId");
			for (var i = 0; i < efaList.length; i++) {
				var efa = efaList[i];
				var optionEfa = document.createElement("option");
				optionEfa.setAttribute("value", efa.efaId);
				optionEfa.innerHTML = efa.efaId;
				efaSelect.appendChild(optionEfa);
			}
			YAHOO.util.Dom.insertAfter(efaSelect, document.getElementById('efaIdLabel'));
		}
	  }
	  
	  function updateEfaListCallback(o) {
	  	var resultData = eval('('+o.responseText+')');
		updateEfaList(resultData.efaList);
	  }
	  
	  function loadExternalFamilyAccounts() {
	  	var extAppId = document.getElementById('externalApplicationId');
		var url = '<c:url value="/homefolder/efaLoader.jsp"/>' 
			+ '?action=loadExternalFamilyAccounts'
			+ '&externalApplicationId=' + extAppId.value;
		var callback = {
			success: updateEfaListCallback
		}
		var transaction = YAHOO.util.Connect.asyncRequest('GET', url, callback, null);
	  }
	  
	  YAHOO.util.Event.onContentReady('homefolderAssociateFieldset', onDefaultSubmitButtonsMarkupReady);
    </script>
  </head>
  
  <body>

	<div class="information">  	
		<div class="information-title">
			<fmt:message key="familyaccount.capwebct_id"/> : 
			<c:out value="${cfa.capwebctFamilyAccountId}"/>
		</div>
		<fmt:message key="familyaccount.capwebct_responsible_lastname"/> : 
		<c:out value="${cfa.capwebctFamilyAccountResponsible}"/>
		<br/>
		<fmt:message key="familyaccount.capwebct_other_individuals" /> :
		<c:forEach items="${cfa.individuals}" var="cfaIndividual">
			<c:if test="${!cfaIndividual.responsible}">
				<c:out value="${cfaIndividual.lastName}"/>&nbsp;<c:out value="${cfaIndividual.firstName}"/>,
			</c:if>
		</c:forEach>
		<br/>
		<div style="float:right;">
			<a href="<c:url value="/homefolder/accounts.jsp?cfaId=${cfa.capwebctFamilyAccountId}"/>">
				<fmt:message key="familyaccount.link.see_accounts"/>
			</a>
		</div>
		<br/>
    </div>
    
    <div style="margin-top: 10px;">&nbsp;</div>
    
    <form method="post" action="<c:url value="/homefolder/manage.jsp?action=associate"/>">
      <fieldset id="homefolderAssociateFieldset">
        <legend><fmt:message key="familyaccount.associate_legend"/></legend>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="externalApplicationId" class="required">
			<fmt:message key="external_application.label"/> * : 
		</label>
		<c:if test="${mode == 'bindAccounts'}">
			<select id="externalApplicationId" name="externalApplicationId"
				onchange="loadExternalFamilyAccounts();">
				<option value=""><fmt:message key="common.no_choice"/></option>
				<c:forEach items="${externalApplications}" var="externalApplication">
					<option value="<c:out value="${externalApplication.id}" />">
						<c:out value="${externalApplication.label}" />
					</option>
				</c:forEach>
			</select>
		</c:if>
		<c:if test="${mode == 'bindIndividuals'}">
			<c:out value="${efa.externalApplication.label}" />
			<input type="hidden" id="externalApplicationId" 
				name="externalApplicationId" value="<c:out value="${efa.externalApplication.label}" />" />
		</c:if>
		<br/>
		<label for="efaId" class="required" id="efaIdLabel">
			<fmt:message key="familyaccount.external_account_id"/> * : 
		</label>
		<c:if test="${mode == 'bindAccounts'}">
			<input type="text" id="efaId" name="efaId" />
		</c:if>
		<c:if test="${mode == 'bindIndividuals'}">
			<c:out value="${efa.externalFamilyAccountId}" />
			<input type="hidden" id="efaId" name="efaId" value="<c:out value="${efa.externalFamilyAccountId}" />" />
		</c:if>
		<br/>
		<c:if test="${mode == 'bindIndividuals'}">
			<label>
				<fmt:message key="familyaccount.external_individuals_association"/> :
			</label>
			<br/>
			<c:forEach items="${cfa.individuals}" var="cfaIndividual">
				<label>
					<c:out value="${cfaIndividual.lastName}"/>&nbsp;<c:out value="${cfaIndividual.firstName}"/> 
					&nbsp;(<c:out value="${cfaIndividual.capwebctIndividualId}"/>) :
				</label>
				<select id="EI-<c:out value='${cfaIndividual.capwebctIndividualId}'/>"
					name="EI-<c:out value='${cfaIndividual.capwebctIndividualId}'/>">
					<option value=""><fmt:message key="common.none_choice"/></option>
					<c:forEach items="${efa.individuals}" var="efaIndividual">
						<c:if test="${efaIndividual.capwebctIndividual.capwebctIndividualId == cfaIndividual.capwebctIndividualId}">
							<option value="<c:out value='${efaIndividual.externalIndividualId}'/>" selected="selected">
						</c:if>
						<c:if test="${efaIndividual.capwebctIndividual.capwebctIndividualId != cfaIndividual.capwebctIndividualId}">
							<option value="<c:out value='${efaIndividual.externalIndividualId}'/>">
						</c:if>
							<c:out value="${efaIndividual.lastName}"/>&nbsp;<c:out value="${efaIndividual.firstName}"/> 
							&nbsp;(<c:out value="${efaIndividual.externalIndividualId}"/>)
						</option>
					</c:forEach>
				</select>
				<br/>
			</c:forEach>
		</c:if>
        <label for="wrappedSubmit">&nbsp;</label>
   		<input type="submit" id="wrappedSubmit" name="wrappedSubmit" 
       		value="<fmt:message key="action.save"/>"/>
        <input type="hidden" name="cfaId" value="<c:out value="${cfa.capwebctFamilyAccountId}"/>" />
        <input type="hidden" name="mode" value="<c:out value="${mode}"/>" />
      </fieldset>
    </form>

    <!--  where family bindings data will appear in a table -->
    <div  class="search-results yui-skin-sam">
    	<div id="familyBindingsData"></div>
    </div>

  </body>
</html>

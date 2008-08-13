<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
  <head>
    <title><fmt:message key="application.name" /> - <fmt:message key="admin.external_application.title"/></title>
	<script type="text/javascript"><!--
		<c:if test="${allExternalApplications != null}">
		YAHOO.example.Data = {
    		externalapplications: [
    		  	<c:forEach items="${allExternalApplications}" var="externalApplication" varStatus="status">
  					{label:"<c:out value="${externalApplication.label}" />+<c:out value="${externalApplication.id}" />",
  					 description:"<c:out value="${externalApplication.description}" />",
  					 brokers:"<c:out value="${externalApplication.formattedBrokers}" />"}  					 
  					 // IE6 will see a extra null element if there is a trailing comma after the last element
        			 <c:if test="${status.count < allExternalApplicationsSize}">,</c:if>
  				</c:forEach>
			]
    	};

		function formatActionColumn(elCell, oRecord, oColumn, oData) {
			var idTab = oData.split('+');
			var urlEdit = '<c:url value="/admin/external_application.jsp?action=load' 
				+ '&externalApplicationId=' + idTab[1]	+ '"/>';
			elCell.innerHTML = "<a href='" + urlEdit + "'>" 
				+ idTab[0] + "</a>";
		}

		YAHOO.util.Event.addListener(window, "load", function() {
    		YAHOO.example.Basic = new function() {
        		var myColumnDefs = [
            		{key:"label", formatter:formatActionColumn,
            			label:"<fmt:message key='table.header.label'/>"},
            		{key:"description", 
            			label:"<fmt:message key='table.header.description'/>"},
            		{key:"brokers",
            			label:"<fmt:message key='table.header.brokers'/>"},
            		{key:"delete", label:' ', 
            			formatter:function(elCell) {
        					elCell.innerHTML = '<img src="<c:url value="/img/icon_delete.gif"/>" title="<fmt:message key="action.delete"/>" />';
        					elCell.style.cursor = 'pointer';
        				}
        			}
        		];

        		this.myDataSource = new YAHOO.util.DataSource(YAHOO.example.Data.externalapplications);
        		this.myDataSource.responseType = YAHOO.util.DataSource.TYPE_JSARRAY;
        		this.myDataSource.responseSchema = {
            		fields: ["label", "description", "brokers"]
        		};

        		this.myDataTable = new YAHOO.widget.DataTable("externalApplicationsData",
                	myColumnDefs, this.myDataSource, 
                	{sortedBy:{key:"label", dir:"asc"}});
                	
                this.myDataTable.subscribe('cellClickEvent',function(ev) {
    				var target = YAHOO.util.Event.getTarget(ev);
    				var column = this.getColumn(target);
    				if (column.key == 'delete') {
    					var record = this.getRecord(target);
    					var dataTable = this;
    					var handleYes = function() {
    						var extAppColumnData = record.getData('label');
    						var splittedExtAppColumnData = extAppColumnData.split('+');
							var url = '<c:url value="/admin/extapp_json.jsp"/>' 
									+ '?action=deleteExternalApplication'
									+ '&externalApplicationId=' + splittedExtAppColumnData[1];
							YAHOO.util.Connect.asyncRequest('GET', url,
								{
									success: function (o) {
										if (o.responseText == 'OK') {
                            				dataTable.deleteRow(target);
                            				this.hide();
                            				document.getElementById('id').value = '';
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
    					loadConfirmationDialog(handleYes,'<fmt:message key="common.warning" />',
								'<fmt:message key="external_application.delete_confirmation_message" />','<fmt:message key="common.yes" />','<fmt:message key="common.no" />');
    				}
    			});
	  		}
	  	});
	  </c:if>
	  
      function submitSaveExternalApplicationForm(ev) {
      		document.getElementById('externalApplicationForm').submit()
      }

	  function initButton() {
	  	var submitSaveExternalApplicationButton = new YAHOO.widget.Button("submitSaveExternalApplication");
    	submitSaveExternalApplicationButton.on("click", FIC_checkForm, 
        	document.getElementById('externalApplicationFormError'));
       	submitSaveExternalApplicationButton.on("click", submitSaveExternalApplicationForm);
	  }
	  YAHOO.util.Event.onDOMReady(initButton);
    --></script>
  </head>
  
  <body>
  
	<form method="post" id="externalApplicationForm" name="externalApplicationForm"
		action="<c:url value="/admin/external_application.jsp?action=createOrUpdate"/>">
      <fieldset id="externalApplicationCreateFieldset">
        <legend><fmt:message key="admin.external_application.create_update_legend"/></legend>
        <div class="errors-form" id="externalApplicationFormError"></div>
        <c:if test="${error_message != null}">
        	<div class="errors">
        		<fmt:message key="${error_message}">
        			<fmt:param value="${error_message_param}"></fmt:param>
        		</fmt:message>
        	</div>
        </c:if>
		<label for="label" class="required">
			<fmt:message key="external_application.short_label"/> * : 
		</label>
		<input type="text" id="label" name="label" class="required" 
			title="<fmt:message key='admin.external_application.label_required'/>"
			value="<c:out value="${externalApplication.label}"/>" />
		<br/>
		<label for="description">
			<fmt:message key="external_application.description"/> : 
		</label>
		<input type="text" id="description" name="description" size="50"
			value="<c:out value="${externalApplication.description}"/>" />
		<br/>
		<label for="broker1" class="required">
			<fmt:message key="external_application.broker1"/> * : 
		</label>
		<input type="text" id="broker1" name="broker1" size="30" class="required" 
			title="<fmt:message key='admin.external_application.broker1_required'/>"
			value="<c:out value="${externalApplication.broker1}"/>" />
		<br/>
		<label for="broker2">
			<fmt:message key="external_application.broker2"/> : 
		</label>
		<input type="text" id="broker2" name="broker2" size="30"
			value="<c:out value="${externalApplication.broker2}"/>" />
		<br/>
		<label for="broker3">
			<fmt:message key="external_application.broker3"/> : 
		</label>
		<input type="text" id="broker3" name="broker3" size="30"
			value="<c:out value="${externalApplication.broker3}"/>" />
		<br/>
        <label for="submitSaveExternalApplication">&nbsp;</label>
       	<input type="button" id="submitSaveExternalApplication" 
                name="submitSaveExternalApplication" value="<fmt:message key="action.save"/>" />
       	<input type="hidden" name="id" id="id" value="<c:out value="${externalApplication.id}"/>" />
      </fieldset>
    </form>
  
    <!--  where external applications data will appear in a table -->
    <div class="search-results-nopaginator yui-skin-sam">
    	<div id="externalApplicationsData"></div>
    </div>
  
  </body>
</html>

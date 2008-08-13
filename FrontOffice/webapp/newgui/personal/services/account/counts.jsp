<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

<div class="block_type5">
  <div class="box">
    <div class="box_top"></div>
    <div class="box_middle">
      <p class="paragraph caution">Les * indiquent des zones de saisie obligatoire.</p>
      <h1 class="title child">Relevés de : 
        <strong>
          <bean:write name="childForm" property="lastName" scope="request"/>
		  <bean:write name="childForm" property="firstName" scope="request"/>
        </strong>
      </h1>
	  <cvqf:form name="childCountForm" action="personal_showChildCountsAction.do?transition=counts">
        <fieldset class="fieldset_type1">
          <ul class="list_type8">
            <li class="row">
              <label for="demande" class="label_type1">DEMANDE <span class="required">*</span></label>
        	  <cvqf:select name="requestLabel" repository="requests" mode="" styleClass="select_type1"/>
            </li>
            <li class="row">
              <label for="date_month" class="label_type1">DATE <span class="required">*</span></label>
	          <cvqf:select name="month" mode="" styleClass="select_type2">
				<option value="0">Janvier</option>
				<option value="1">Février</option>
	            <option value="2">Mars</option>
	            <option value="3">Avril</option>
	            <option value="4">Mai</option>
	            <option value="5">Juin</option>
	            <option value="6">Juillet</option>
	            <option value="7">Août</option>
	            <option value="8">Septembre</option>
	            <option value="9">Octobre</option>
	            <option value="10">Novembre</option>
	            <option value="11">Décembre</option>
	          </cvqf:select>
	          <cvqf:select name="year" repository="consumptionYears" mode="" styleClass="select_type3"/>
            </li>
            <li class="row row_type2">
              <span class="text_type4">Affichage des résultats <span class="required">*</span></span>
			  <cvqf:radio name="format" mode="">
    			<option value="full"><bean:message key="request.consumptions.results.format.full"/></option>
    			<option value="short"><bean:message key="request.consumptions.results.format.short"/></option>
   			  </cvqf:radio>
            </li>
		    <input type="hidden" name="navigate" id="navigate" value=""/>
            <li class="row">
              <input type="submit" class="submit_type1" value="AFFICHER" />
            </li>
          </ul>
        </fieldset>
	  </cvqf:form>

	  <logic:notEmpty name="childCountForm" property="requestConsumptions" scope="session">
	    <div class="block_type8">
	      <cvq:displayRequestConsumptions name="childCountForm" scope="session"/>
	    </div>
	  </logic:notEmpty>
	  <logic:empty name="childCountForm" property="requestConsumptions" scope="session">
	    <logic:equal name="childCountForm" property="issuedSearch" scope="session" value="true">
	      <div class="block_type8">
	        <bean:message key="request.consumptions.no_result"/>
	      </div>
	    </logic:equal>
	  </logic:empty>
	
	  <logic:equal name="childCountForm" property="associatedToConsumptions" scope="session" value="false">
	    <div class="block_type8">
	      <bean:message key="request.consumptions.no_request"/>
	    </div>
	  </logic:equal>

    </div>
    <div class="box_bottom"></div>
  </div>
</div>

	<script type="text/javascript">
		function validationData() {
 		  this.requestLabel = new Function("key","this.label='Demande'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
 		  this.month = new Function("key","this.label='Date'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
 		  this.year = new Function("key","this.label='Date'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
 		  this.format = new Function("key","this.label='Format d;quote;affichage'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
		}
	</script>
  
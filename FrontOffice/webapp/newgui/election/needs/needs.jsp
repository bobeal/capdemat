<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Needs" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="radio_row">
			<label for="hopesAndNeeds" class="large_radio_label">Souhaits et besoins de la personne permettant d'élaborer le plan de compensation le plus adapté possible<span class="required">*</span></label>
		  </li>
          <cvqf:radio name="hopesAndNeeds" mode="" label="[Oui,Non]" />
        </ul>
        <ul class="insert_list" id="Oui">
          <li class="text_row">
			<label for="hopes" class="label">Souhaits</label>
            <cvqf:text name="hopes" mode="" rows="3"/>
          </li>
          <li class="text_row">
			<label for="needs" class="label">Besoins</label>
            <cvqf:text name="needs" mode="" rows="3"/>
          </li>
          <li class="text_row">
			<label for="comments" class="label">Observations</label>
            <cvqf:text name="comments" mode="" rows="3"/>
          </li>
        </ul>
		<br class="clear-both" />
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.hopesAndNeeds = new Function("key","this.label='Souhaits et besoins de la personne permettant d&quote;élaborer le plan de compensation le plus adapté possible'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.hopes = new Function("key","this.label='Souhaits'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.needs = new Function("key","this.label='Besoins'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.comments = new Function("key","this.label='Observations'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("hopesAndNeeds");
  		setFocus("Needs");
	</script>

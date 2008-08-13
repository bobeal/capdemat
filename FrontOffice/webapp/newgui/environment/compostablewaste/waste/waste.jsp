<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Waste" action="#" >
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Type de végétaux<span class="required">*</span> :</h3>
        <ul class="insert_list">
            <cvqf:check name="compostableWasteType" mode="blockrequired" repository="compostablewaste">
            </cvqf:check>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <ul class="insert_list" id="Other">
          <li class="text_row">
			<label for="otherWaste" class="label">Autre, préciser</label>
            <cvqf:text name="otherWaste" mode=""/>
          </li>
        </ul>
		<br class="clear-both" />
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Adresse du compte :</h3>
        <ul class="insert_list">
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Si l'adresse de collecte des végétaux est différente, merci de la préciser :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="collectionAddress" class="label">Adresse de collecte</label>
            <cvqf:text name="collectionAddress" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  	  		  this.compostableWasteType = new Function("key","this.label='Type de végétaux'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type='list:Other'; return this[key];");
     		  this.otherWaste = new Function("key","this.label='Autre, préciser'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.collectionAddress = new Function("key","this.label='Adresse de collecte'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("compostableWasteType");
  		setFocus("Waste");
	</script>

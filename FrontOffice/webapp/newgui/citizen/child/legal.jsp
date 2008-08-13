<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Child" action="#" >
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Choix du responsable légal parmi les adultes du compte :</h3>
        <ul class="insert_list">
            <cvqf:check name="childAdult" mode="" repository="adults">
            </cvqf:check>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   			  this.childAdult = new Function("key","this.label='Choix du responsable légal parmi les adultes du compte'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type='list'; return this[key];");
  		}
        updateDisplay("childAdult");
  		setFocus("Child");
	</script>

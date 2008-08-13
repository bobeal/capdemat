<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Places" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <cvqf:ticket name="placeReservation" mode="" repository="Place Reservation" />
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   			  this.placeReservation = new Function("key","this.label='A l&quote;affiche'; this.msg='Pour continuer, vous devez avoir acheté au moins une place de spectacle.'; this.required=true; this.minlength=0; this.maxlength=0; this.type='ticket'; return this[key];");
  		}
        updateDisplay("placeReservation");
  		setFocus("Places");
	</script>

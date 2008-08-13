<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Activities" action="#" mode="static">
      <ul class="confirm_list">
          <cvqf:referential name="activity" mode="static" repository="Activity" />
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Activities");
	</script>

<div class="mainbox mainbox-yellow" id="requestTypeSteps">
	<form class="edit" action="${createLink(action:"saveSteps")}" id="requestTypeStepsForm" method="post">
	    <div class="error" id="dialogRequestTypeStepsFormError"></div>
		<ul>
			<li>
				<input type="checkbox" value="active" ${requestType.getStepAccountCompletion() ? 'checked' : ''} name="stepAccountCompletion" id="stepAccountCompletion"/>
				<label for="stepAccountCompletion">${message(code:'requestType.property.homeFolder')}</label>
			</li>
		</ul>
		<input type="hidden" value="${id}" name="id" />
		<input id="saveRequestTypeSteps" name="saveRequestTypeSteps" class="submitStepChange bt" type="button" value="${message(code:'action.save')}" />
	</form>
</div>

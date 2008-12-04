var Condition = {

  handleSuccess:function(o) {
    var conditions = o.responseText.substring(1, o.responseText.length - 1).split(",");
    for(i = 0; i < conditions.length; i++) {
      var condition = conditions[i].split(":");
 	  var conditionName = condition[0].substring(condition[0].indexOf('"') + 1 , condition[0].length - 1);
 	  var conditionValue = condition[1];
 	  var filled = YAHOO.util.Dom.getElementsByClassName(conditionName + "-filled");
      var unfilled = YAHOO.util.Dom.getElementsByClassName(conditionName + "-unfilled");	  
      if (conditionValue == "true") {
        for (var j=0; j<filled.length; j++) {
          filled[j].style.display = "block";
        }
	    for (var j=0; j<unfilled.length; j++) {
	      unfilled[j].style.display = "none";
        }
      } else {
        for (var j=0; j<filled.length; j++) {
	      filled[j].style.display = "none";
        }
        for (var j=0; j<unfilled.length; j++) {
	      unfilled[j].style.display = "block";
        }
      }
    }	
  },
	
  handleFailure:function(o) {
    alert(o.status);
  },
	
  startRequest:function(conditionsName, triggersParam, requestName) {
    var transaction;
    var conditionsNameParam;
	  var sUrl = "/BackOfficeNG/" + requestName + "/checkConditions";
	  for(i = 0; i < conditionsName.length; i++) {
	  if (conditionsName[i] != null) {
	    if (conditionsNameParam == null) {
	      conditionsNameParam = "cn_" + conditionsName[i] + "=" + conditionsName[i]; 
	    } else {
	   	  conditionsNameParam += "&cn_" + conditionsName[i] + "=" + conditionsName[i];
	   	}
	  }
	}
	transaction = YAHOO.util.Connect.asyncRequest('POST', sUrl, callback, conditionsNameParam + triggersParam);
  },
	
  getTriggersParam:function(conditionsName) {
    var triggersParam = "";
	for(i = 0; i < conditionsName.length; i++) {
	  if (conditionsName[i] != null) {
	    var triggers = YAHOO.util.Dom.getElementsByClassName(conditionsName[i] + "-trigger");
 	    for (var j=0; j<triggers.length; j++)	{
          if (triggers[j].value != null) {
    	    if (triggers[j].type == "radio") {
    	      if (triggers[j].checked == true) 
    		    triggersParam += "&" + conditionsName[i] + "_" + triggers[j].name + "=" + triggers[j].value;
    	    } else {
    	      triggersParam += "&" + conditionsName[i] + "_" +  triggers[j].name + "=" + triggers[j].value;
    	    }		
    	  }
 	    }
	  } 
 	}
  	return triggersParam;
  },
	
  checkConditions:function(conditionsName, requestName) {
    triggersParam = Condition.getTriggersParam(conditionsName);
 	Condition.startRequest(conditionsName, triggersParam, requestName);
  },
	
  change:function(className, requestName) {
    var conditionsName = [];
    var classNames = className.split(" ");
    for(i = 0; i < classNames.length; i++) {
 	  var index = classNames[i]. indexOf("-trigger");
	  if (index != -1) {
	    conditionsName[i] =  classNames[i].substring(0, index);
	  }
	}
 	Condition.checkConditions(conditionsName, requestName);
  }
};

var callback = {
  success:Condition.handleSuccess,
  failure:Condition.handleFailure,
  scope: Condition
}

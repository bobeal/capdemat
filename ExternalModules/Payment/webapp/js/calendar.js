function showCalendar(docId, calIndex) {
	var link1 = document.getElementById(docId);
	var pos = YAHOO.util.Dom.getXY(link1);
	YAHOO.payment_module.calendar.cal[calIndex].oDomContainer.style.display='block';
	YAHOO.util.Dom.setXY(YAHOO.payment_module.calendar.cal[calIndex].oDomContainer, 
										  [pos[0],pos[1]+link1.offsetHeight+1]);
}

YAHOO.namespace("payment_module.calendar");
YAHOO.payment_module.calendar.init = function(arg1, arg2, arg3) {

	function handleSelect(type,args,obj) {
		var dates = args[0]; 
		var date = dates[0];
		var year = date[0], month = date[1], day = date[2];
			
		var txtDate1 = document.getElementById(arg3.label);
		txtDate1.value = day + "/" + month + "/" + year;
	};

	YAHOO.payment_module.calendar.cal[arg3.id] = 
		new YAHOO.widget.Calendar( arg3.label + "Cal", arg3.label + "CalContainer", 
				{ close:true } );
	YAHOO.payment_module.calendar.cal[arg3.id].selectEvent.subscribe(handleSelect, 
		YAHOO.payment_module.calendar.cal[arg3.id], true);
	YAHOO.payment_module.calendar.cal[arg3.id].render();

	// Listener to show the calendar when the image is clicked
	YAHOO.util.Event.addListener(arg3.label + "Show", "click", 
		YAHOO.payment_module.calendar.cal[arg3.id].show, 
		YAHOO.payment_module.calendar.cal[arg3.id], true);
}



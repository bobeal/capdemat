YAHOO.namespace("request.multi.cerfa.electoral.roll");

var yrmcec = YAHOO.request.multi.cerfa.electoral.roll;
var yu = YAHOO.util;
var yue = yu.Event;
var yuel = yu.Element;
var yud = yu.Dom;
var yw = YAHOO.widget;
var yuc = yu.Connect;
var yus = yu.Selector;

yrmcec.creation = function() {
	
	var changeDate = function(e){ 
		
		
		
		function resetHandler() {
	        // Reset the current calendar page to the select date, or 
	        // to today if nothing is selected.
	        var selDates = calendar.getSelectedDates();
	        var resetDate;
	
	        if (selDates.length > 0) {
	            resetDate = selDates[0];
	        } else {
	            resetDate = calendar.today;
	        }
	
	        calendar.cfg.setProperty("pagedate", resetDate);
	        calendar.render();
	    }
	
	    function closeHandler() {
	        dialog.hide();
	    }
		 dialog = new yw.Dialog("container", {
             visible:false,
             context:["dateBtn", "tl", "bl"],
             buttons:[ {text:"Reset", handler: resetHandler, isDefault:true}, {text:"Close", handler: closeHandler}],
             draggable:false,
             close:true
         });
         dialog.setHeader('Date de naissance');
         dialog.setBody('<div id="cal"></div>');
         dialog.render(document.body);
         
        
         dialog.showEvent.subscribe(function() {
 	        if (YAHOO.env.ua.ie) {
 	            // Since we're hiding the table using yui-overlay-hidden, we 
 	            // want to let the dialog know that the content size has changed, when
 	            // shown
 	            dialog.fireEvent("changeContent");
 	        }
 	    });
         
         calendar = new YAHOO.widget.Calendar("cal", {
        	 navigator: true,
        	 LOCALE_MONTHS: "short", 
        	 LOCALE_WEEKDAYS: "medium",
             iframe:false,          // Turn iframe off, since container has iframe support.
             hide_blank_weeks:true  // Enable, to demonstrate how we handle changing height, using changeContent
         });
         calendar.render();
         calendar.cfg.setProperty("start_weekday", "1");
     	 var monthDef = ["Janv","Fév","Mars","Avr","Mai","Juin","Jui","Aoû","Sep","Oct","Nov","Dec"];
     	 var dayDef = ["Lun","Mar","Mer","Jeu","Ven","Sam","Dim"];
     	 calendar.cfg.setProperty("MONTHS_SHORT", monthDef);
     	 calendar.cfg.setProperty("WEEKDAYS_MEDIUM", dayDef);
         
     	var subjectDate = yud.get('subjectChoiceBirthDate').value;
		if(subjectDate != ""){
			var inverse = subjectDate.split('/');
			calendar.select(inverse[1]+"/"+inverse[0]+"/"+inverse[2]);
		}
         var monthNumber = {0:'01',1:'02',2:'03',3:'04',4:'05',5:'06',6:'07',7:'08',8:'09',9:'10',10:'11',11:'12'};
         
         calendar.selectEvent.subscribe(function() {
             if (calendar.getSelectedDates().length > 0) {

                 var selDate = calendar.getSelectedDates()[0];

                 // Pretty Date Output, using Calendar's Locale values: Friday, 8 February 2008
                 
                 var dStr = selDate.getDate();
                 var mStr = monthNumber[selDate.getMonth()];
                 var yStr = selDate.getFullYear();
 
                 yud.get("subjectChoiceBirthDate").value =  dStr + "/" + mStr + "/" + yStr;
             } else {
                 yud.get("subjectChoiceBirthDate").value = "";
             }
             dialog.hide();
         });

         calendar.renderEvent.subscribe(function() {
             // Tell Dialog it's contents have changed, which allows 
             // container to redraw the underlay (for IE6/Safari2)
             dialog.fireEvent("changeContent");
         });

         
         var seldate = calendar.getSelectedDates();

         if (seldate.length > 0) {
             // Set the pagedate to show the selected date if it exists
             calendar.cfg.setProperty("pagedate", seldate[0]);
             calendar.render();
         }

         
         dialog.show();
	}
	
	var myDateBtn = new yw.Button("dateBtn");
	myDateBtn.on("click", changeDate);
	
	
	var ShowMaiden = function(e){
		var stitle = yud.get("subjectChoiceTitle");
		stitle.value = "";
	}
	var subjectId = yud.get("subjectId");
	yue.addListener(subjectId, "change", ShowMaiden);
	
	
	
};
yue.onDOMReady(yrmcec.creation);
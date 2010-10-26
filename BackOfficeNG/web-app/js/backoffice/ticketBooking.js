// Simple JavaScript Templating
// John Resig - http://ejohn.org/ - MIT Licensed
(function(){
  var cache = {};
 
  this.tmpl = function tmpl(str, data){
    // Figure out if we're getting a template, or if we need to
    // load the template - and be sure to cache the result.
    var fn = !/\W/.test(str) ?
      cache[str] = cache[str] ||
        tmpl(document.getElementById(str).innerHTML) :
     
      // Generate a reusable function that will serve as a template
      // generator (and which will be cached).
      new Function("obj",
        "var p=[],print=function(){p.push.apply(p,arguments);};" +
       
        // Introduce the data as local variables using with(){}
        "with(obj){p.push('" +
       
        // Convert the template into pure JavaScript
        str
          .replace(/[\r\t\n]/g, " ")
          .split("<!").join("\t")
          .replace(/((^|!>)[^\t]*)'/g, "$1\r")
          .replace(/\t=(.*?)!>/g, "',$1,'")
          .split("\t").join("');")
          .split("!>").join("p.push('")
          .split("\r").join("\\'")
      + "');}return p.join('');");
   
    // Provide some basic currying to the user
    return data ? fn( data ) : fn;
  };
})();


zenexity.capdemat.tools.namespace('zenexity.capdemat.bong');
(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcb = zenexity.capdemat.bong;
  var zca = zenexity.capdemat.aspect;

  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.TicketBooking = function() {

    var toggleEntries = function(dataName, displayPolicy) {
      zct.each(yus.query('ul', yud.get('entertainments')), function(){
        zct.style(this, {display:displayPolicy});
      });
      zct.toggleClass(yud.get('expandEntries_' + dataName), 'current');
      zct.toggleClass(yud.get('collapseEntries_' + dataName), 'current');
    };

    // TODO: move to tools
    var randomString = function() {
      return new String(Math.random()).split('.')[1];
    }

    return {
      clickEvent: undefined,

      prepareEvent : function(e) {
        return (yue.getTarget(e).getAttribute('id') || '').split('_')[0];
      },

      init : function() {
        zct.doAjaxCall('/',[],function(o){
          zct.html(yud.get('requestTypeTicketBooking'),o.responseText);
          zcb.TicketBooking.clickEvent = new zct.Event(zcb.TicketBooking, zcb.TicketBooking.prepareEvent);
          yue.on(yud.get('entertainmentsReferential'),'click',zcb.TicketBooking.clickEvent.dispatch,zcb.TicketBooking.clickEvent,true);
          yue.on(yud.get('subscribersReferential'),'click',zcb.TicketBooking.clickEvent.dispatch,zcb.TicketBooking.clickEvent,true);

          yue.on('importSubscribersForm','submit', zcb.TicketBooking.importReferential);
          yue.on('importEntertainmentsForm','submit', zcb.TicketBooking.importReferential);
          yue.on('defaultLogoForm','submit', zcb.TicketBooking.saveDefaultLogo);
          zcb.TicketBooking.initSubscribers('lastName', '0', '');
        });

        zcb.TicketBooking.confirmRemoveEntertainmentDialog = new zct.ConfirmationDialog(
          { head : 'Attention', body : 'Voulez-vous supprimer<br/>ce spectacle ?' },
          zcb.TicketBooking.removeEntertainment);
        zcb.TicketBooking.confirmRemoveEventDialog = new zct.ConfirmationDialog(
          { head : 'Attention', body : 'Voulez-vous supprimer<br/>cette représentation ?' },
          zcb.TicketBooking.removeEvent);
      },

      initEntertainment : function() {
        zct.doAjaxCall('/entertainments',[],function(o){
          zct.html(yud.get('entertainmentsReferential'),o.responseText);
        });
      },

      collapseEntries : function(e) {
        var target = (yue.getTarget(e)||e); 
        toggleEntries(target.id.split('_')[1],'none'); 
      },

      expandEntries : function(e) { 
        var target = (yue.getTarget(e)||e); 
        toggleEntries(target.id.split('_')[1], 'block'); 
      },

      discard : function(e) {
        var target = (yue.getTarget(e)||e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        zct.style(formEl, {display:'none'});
        if (formEl.getAttribute('id').indexOf('event') >= 0)
          zcb.TicketBooking.initEntertainment();
      },

      editEntertainment: function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        zct.doAjaxCall(['/entertainment/','?id=',id].join(''),[],function(o){
          var wrapperEl = yud.get('formContainer_entertainment_' + (!!id ? id : '') );
          zct.style(wrapperEl, {display:'block'});
          zct.html(wrapperEl,o.responseText);
        });
      },

      saveEntertainment : function(e) {
        var target = (yue.getTarget(e)||e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        var formElId = formEl.getAttributeNode('id').value;
        var errorEl = yud.get(formElId + '_Errors');
        if (!zcv.check(e, errorEl))
          return;
        zct.doAjaxFormSubmitCall(formElId, [], function(o) {
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
          var id = target.id.split('_')[1];
          if (id === '') {
            zcb.TicketBooking.initEntertainment();
            return;
          } else if (json.status === 'success') {
            var ar = yud.get('logo_' + id).src.split('/?rand=');
            yud.get('logo_' + id).src = ar[0] + '/?rand=' + randomString();
            yud.getAncestorByTagName(target, 'li').children[0].innerHTML = formEl.name.value;
          }
        },true);
      },

      confirmRemoveEntertainment :function(e) { zcb.TicketBooking.confirmRemoveEntertainmentDialog.show(e); },
      removeEntertainment: function(e, se) {
        var target = (yue.getTarget(se)||se);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/removeEntertainment/' + id,[],function(o){
          zcb.TicketBooking.initEntertainment();
        });
      },

      editEvent: function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[2];
        var entertainmentId = target.id.split('_')[1];
        zct.doAjaxCall(['/event/','?entertainmentId=', entertainmentId,'&id=',id].join(''),[],function(o){
          var wrapperEl = yud.get('formContainer_event_' + entertainmentId + '_' + id );
          zct.style(wrapperEl, {display:'block'});
          zct.html(wrapperEl,o.responseText);
          zcb.Calendar("date_" + entertainmentId + '_' + id);
          zcb.Calendar("bookingStart_" + entertainmentId + '_' + id);
          zcb.Calendar("bookingEnd_" + entertainmentId + '_' + id);
        });
      },

      saveEvent : function(e) {
        var target = (yue.getTarget(e)||e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        var formElId = formEl.getAttribute('id');
        var errorEl = yud.get(formElId + '_Errors');
        if (!zcv.check(e, errorEl))
          return;
        zct.doAjaxFormSubmitCall(formElId, [], function(o) {
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
           if (formElId.split('_')[2] === '') {
            zcb.TicketBooking.initEntertainment();
            return;
          } else if (json.status === 'success') {
            yud.getAncestorByTagName(target, 'li').children[0].innerHTML = json.eventAsItem;
          }
        });
      },

      confirmRemoveEvent :function(e) { zcb.TicketBooking.confirmRemoveEventDialog.show(e); },
      removeEvent: function(e, se) {
        var target = (yue.getTarget(se)||se);
        var id = target.id.split('_')[1];
        zct.doAjaxCall(['/removeEvent/','?eventId=',id].join(''),[],function(o){
          zcb.TicketBooking.initEntertainment();
        });
      },

      getEvent: function(id) {
        zct.doAjaxCall('/fares/?eventId=' + id,[],function(o){
          var wrapperEl = yud.get('formContainer_fares_' + id);
          zct.style(wrapperEl, {display:'block'});
          zct.html(wrapperEl,o.responseText);
        });
      },

      editFares: function(e) {
        var target = (yue.getTarget(e)||e);
        var eventId = target.id.split('_')[1];
        zcb.TicketBooking.getEvent(eventId);
      },

      addPlaceCategory : function(e) {
        var target = (yue.getTarget(e)||e);
        var eventId = target.id.split('_')[1];
        var selectEl = yud.get('placeCategoryName_' + eventId);
        if (selectEl.selectedIndex === 0){
          // FIXME: JS i18nize message
          zct.Notifier.processMessage('warning', 'Vous devez choisir une catégorie', null, target);
          return false;
        }
        zct.doAjaxCall(['/addPlaceCategory/','?eventId=',eventId,
            '&placeCategoryName=',selectEl.value].join(''),[],function(o){
          zcb.TicketBooking.getEvent(eventId);
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
        });
      },

      deletePlaceCategory : function(e) {
        var target = (yue.getTarget(e)||e);
        var eventId = yud.getAncestorByTagName(target, 'form').eventId.value;
        var placeCategoryId = target.id.split('_')[1];
        zct.doAjaxCall(['/removePlaceCategory/','?eventId=',eventId,
            '&placeCategoryId=',placeCategoryId].join(''),[],function(o){
          zcb.TicketBooking.getEvent(eventId);
        });
      },

      savePlaceCategory : function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        //TODO: refactor fetching strategy (decouple to DOM)
        var placeNumber = yud.get('placeNumber_' + id).value;        
        zct.doAjaxCall(['/savePlaceCategory/?id=', id,'&placeNumber=',placeNumber].join(''),[],function(o){
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
        });
      },

      addFare : function(e) {
        var target = (yue.getTarget(e)||e); 
        var placeCategoryId = target.id.split('_')[1];
        zct.doAjaxCall('/addFare/?placeCategoryId=' + placeCategoryId,[],function(o){
          var json = ylj.parse(o.responseText);
          var fare = { id:json.fareId, name:'', withSubscribtion:'false', price:'' };
          zcb.TicketBooking.editingFare[fare.id] = fare;
          var newDdEl = document.createElement('dd');
          newDdEl.innerHTML = tmpl('fareEditTmpl', fare);
          yud.getAncestorByTagName(target, 'dl').appendChild(newDdEl);  
        });
      },

      // Cache to save current editing fare. That enable to rollback in error cases
      // FIXME: remove element is not managed because data's size is small
      editingFare : {},

      editFare : function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        var fare = {
          name: yud.get('name_' + id).innerHTML,
          id: id,
          withSubscribtion: yud.get('withSubscribtion_' + id).innerHTML,
          price: yud.get('price_' + id).innerHTML
        };
        zcb.TicketBooking.editingFare[id] = fare;
        yud.getAncestorByTagName(target, 'dd').innerHTML = tmpl('fareEditTmpl', fare); 
      },

      saveFare : function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        var fare = {
          name: yud.get('name_' + id).value,
          id: id,
          withSubscribtion: yud.get('withSubscribtion_' + id).value,
          price: yud.get('price_' + id).value
        };
        zct.doAjaxCall(['/saveFare/?id=',fare.id,'&name=',fare.name,'&price=',fare.price,
            '&withSubscribtion=',fare.withSubscribtion].join(''),[],function(o){
          zcb.TicketBooking.editToStaticFare(target, fare);
        });
      },

      deleteFare : function(e) {
        var target = (yue.getTarget(e)||e);
        var fareId = target.id.split('_')[1];
        var placeCategoryId = yud.getAncestorByTagName(target, 'div').id.split('_')[1];
        zct.doAjaxCall(['/removeFare/','?fareId=',fareId,
            '&placeCategoryId=',placeCategoryId].join(''),[],function(o){
          var ddEl = yud.getAncestorByTagName(target, 'dd');
          var dlEl = yud.getAncestorByTagName(target, 'dl').removeChild(ddEl); 
        });
      },

      cancelEditFare : function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        zcb.TicketBooking.editToStaticFare(target, zcb.TicketBooking.editingFare[id]);
      },

      editToStaticFare : function(target, fare) {
        var newDdEl = document.createElement('dd');
        newDdEl.innerHTML += tmpl('fareStaticTmpl', fare);
        var ddEl = yud.getAncestorByTagName(target, 'dd');
        var dlEl = yud.getAncestorByTagName(target, 'dl');
        dlEl.insertBefore(newDdEl, ddEl);
        dlEl.removeChild(ddEl);
      },

      importReferential: function(e) {
        yue.preventDefault(e);
        var formEl = yue.getTarget(e)
        zct.doAjaxFormSubmitCall(formEl.id,[],function(o){
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, formEl);
          if (formEl.id == 'importEntertainmentsForm')
            zcb.TicketBooking.initEntertainment();
          else if (formEl.id == 'importSubscribersForm')
            zcb.TicketBooking.initSubscribers('lastName', '0', '');
        }, true);
      },

      saveDefaultLogo: function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        zct.doAjaxFormSubmitCall('defaultLogoForm',[],function(o){
          var json = ylj.parse(o.responseText);
          var ar = yud.get('defaultLogoImg').src.split('&rand=')
          yud.get('defaultLogoImg').src = ar[0] + '&rand=' + randomString();
          zct.Notifier.processMessage(json.status, json.message, null, target);
        }, true);
      },

      orderBySubscriber: function(e) {
        if (e.type == 'click') return false;
        var startIndex = yud.get('startIndexSubscriber').value;
        zcb.TicketBooking.initSubscribers(yue.getTarget(e).value, startIndex, '');
      },

      previousSubscribers: function(e) {
        var orderBy = yud.get('orderBySubscriber').value;
        var startIndex = yud.get('startIndexSubscriber').value;
        zcb.TicketBooking.initSubscribers(orderBy, startIndex, 'prev');
      },

      nextSubscribers: function(e) {
        var orderBy = yud.get('orderBySubscriber').value;
        var startIndex = yud.get('startIndexSubscriber').value;
        zcb.TicketBooking.initSubscribers(orderBy, startIndex, 'next');
      },

      initSubscribers : function(orderBy, startIndex, dir) {
        zct.doAjaxCall(['/subscribers/','?orderBy=', orderBy,
            '&startIndex=', startIndex, '&dir=', dir].join(''),[],function(o){
          zct.html(yud.get('subscribersReferential'),o.responseText);
          yue.on('orderBySubscriber','change', zcb.TicketBooking.orderBySubscriber);
        });
      },

      editSubscriber: function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        zct.doAjaxCall(['/subscriber/','?id=',id].join(''),[],function(o){
          var wrapperEl = yud.get('formContainer_subscriber_' + (!!id ? id : '') );
          zct.style(wrapperEl, {display:'block'});
          zct.html(wrapperEl,o.responseText);
        });
      },

      saveSubscriber : function(e) {
        var target = (yue.getTarget(e)||e);
        var formEl = yud.getAncestorByTagName(target, 'form');
        var formElId = formEl.getAttributeNode('id').value;
        var errorEl = yud.get(formElId + '_Errors');
        if (!zcv.check(e, errorEl))
          return;
        zct.doAjaxFormSubmitCall(formElId, [], function(o) {
          if (formEl.id.value == '') {
            var orderBy = yud.get('orderBySubscriber').value;
            var startIndex = yud.get('startIndexSubscriber').value;
            zcb.TicketBooking.initSubscribers(orderBy, startIndex, '');
          } else {
            var liEl = yud.getAncestorByTagName(formEl, 'li')
            liEl.children[2].innerHTML = formEl.firstName.value + ' ' + formEl.lastName.value;
            var json = ylj.parse(o.responseText);
            zct.Notifier.processMessage(json.status, json.message, null, target);
          }
        });
      },

      removeSubscriber: function(e) {
        var target = (yue.getTarget(e)||e);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/removeSubscriber/' + id,[],function(o){
          var orderBy = yud.get('orderBySubscriber').value;
          var startIndex = yud.get('startIndexSubscriber').value;
          zcb.TicketBooking.initSubscribers(orderBy, startIndex, '');
        });
      }

    };

  }();

}());

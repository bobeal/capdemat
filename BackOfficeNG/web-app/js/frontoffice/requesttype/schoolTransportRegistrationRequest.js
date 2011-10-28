zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zcf.requesttype;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcfr.SchoolTransportRegistrationRequest = function() {

    var fill = function(callUrl, callback, callbackParams) {
      var selector = this;
      zct.doAjaxCall(callUrl, null, function(o) {
        var json = ylj.parse(o.responseText);
        var index = 1;
        for (var key in json) {
          selector.options[index++] = new Option(json[key], key);
        }
        if (zct.isFunction(callback))
          callback.apply(selector, callbackParams);
      }, true);
    };

    var empty = function() {
      while (this.options.length > 1) {
        this.options[1].parentNode.removeChild(this.options[1]);
      }
      yud.get(this.id.replace('id', 'label')).value = '';
    };

    var select = function(value) {
      var i = 0;
      for (i; i<this.length; i++){
        if (this.options[i].value === value){
          if (this.selectedIndex !== i)
            this.selectedIndex = i;
          break;
        }
      }
      this.updateLabelInput();
    };

    var updateLabelInput = function() {
      var oldInput = yud.get(this.id.replace('id', 'label'));
      var newInput = document.createElement('input');
      newInput.className = oldInput.className;
      newInput.id = oldInput.id;
      newInput.name = oldInput.name;
      newInput.type = 'hidden';
      newInput.value = this.selectedIndex > 0 ? this.options[this.selectedIndex].innerHTML : '';
      oldInput.parentNode.replaceChild(newInput, oldInput);
    };

    function Selector(id) {
      var selector = document.createElement('select');
      selector.id = id;
      selector.className = 'required validate-not-first';
      selector.name = id;
      selector.options[0] = new Option('Choisissez...', '');
      // Add methods
      selector.fill = fill;
      selector.empty = empty;
      selector.updateLabelInput = updateLabelInput;
      // Add event handler
      yue.on(selector, 'change', function(event) {
        this.updateLabelInput();
      });
      return selector;
    };

    var changeLayout = function() {
      zct.each(yus.query('legend, label[for^="label"]'), function() {
        yud.addClass(this, 'unactive');
      });
      zct.each(yus.query('label[for^="id"]'), function() {
        this.innerHTML = yud.getPreviousSibling(this).innerHTML + ' *';
      });
    };

    /**
     * Dynamically fill selectors for the bus line and stop depending on the selected child.
     */
    var initTransports = function() {
      var linesCallUrlPrefix = zenexity.capdemat.contextPath + '/frontoffice/schoolTransportRegistration/transportLines';
      var stopsCallUrlPrefix = zenexity.capdemat.contextPath + '/frontoffice/schoolTransportRegistration/stops';

      var subject = yud.get('subjectId');
      var requestId = yud.get("stepForm").id.value;

      changeLayout();

      // If we come back from step 2, save last line and stop values.
      var lastLineValue, lastStopValue;
      if (subject.value !== '') {
        lastLineValue = yud.get('idLigne').value;
        lastStopValue = yud.get('idArret').value;
      }

      yud.get('idLigne').parentNode.replaceChild(new Selector('idLigne'), yud.get('idLigne'));
      yud.get('idLigne').updateLabelInput();
      yud.get('idArret').parentNode.replaceChild(new Selector('idArret'), yud.get('idArret'));
      yud.get('idArret').updateLabelInput();

      // Then refill selectors and reselect last values.
      if (subject.value !== '') {
        yud.get('idLigne').fill(linesCallUrlPrefix + '/?requestId=' + requestId + '&childId=' + subject.value,
            select, [lastLineValue]);
        yud.get('idArret').fill(stopsCallUrlPrefix + '/?requestId=' + requestId + '&childId=' + subject.value + '&lineId=' + lastLineValue,
            select, [lastStopValue]);
      }

      yue.on('subjectId', 'change', function(event) {
        if (this.value !== '') {
          yud.get('idLigne').fill(linesCallUrlPrefix + '/?requestId=' + requestId + '&childId=' + subject.value);
        } else {
          yud.get('idLigne').empty();
          yud.get('idArret').empty();
        }
      });

      yue.on('idLigne', 'change', function(event) {
        if (this.value !== '') {
          yud.get('idArret').fill(stopsCallUrlPrefix + '/?requestId=' + requestId + '&childId=' + subject.value + '&lineId=' + this.value);
        } else {
          yud.get('idArret').empty();
        }
      });
    };

    /**
     * Problem:
     * If we choose "no" in the checkbox, then authorise someone to pick up the child and finally change "no" to "yes".
     * > The person authorised remains visible on screen.
     *
     * Solution:
     * It would work if authorised persons were in a complex type. Unfortunately we don't support collections in
     * complex types. So this JS.
     */
    var initConditions = function() {
      yue.on(yud.get('estMaternelleElementaireAutorisations_no'), 'click', hideAllAuthorisationListeners);
      yue.on(yud.get('estMaternelleElementaireAutorisations_yes'), 'click', displaySelectedAuthorisationListener);
    };

    var hideAllAuthorisationListeners = function() {
      zct.each(yus.query('.condition-autoriseTiers-filled, .condition-autoriseFrereOuSoeur-filled'), function() {
        this.className += ' unactive';
      });
    };

    var displaySelectedAuthorisationListener = function() {
      var selector = yud.get('autorisation');
      var value = selector.options.item(selector.selectedIndex).value;

      switch (value) {
        case 'AVEC_FRERE_SOEUR':
          yud.removeClass(yus.query('.condition-autoriseFrereOuSoeur-filled'), 'unactive');
          break;
        case 'AVEC_TIERS':
          yud.removeClass(yus.query('.condition-autoriseTiers-filled'), 'unactive');
          break;
      }
    };

    return {
      init: function() {
        // Switch on step name.
        switch (yus.query('div.form', 'request', true).id) {
          case 'enfant':
            initTransports();
            break;
          case 'autorisations':
            initConditions();
            break;
        }
      }
    };

  }();

}());

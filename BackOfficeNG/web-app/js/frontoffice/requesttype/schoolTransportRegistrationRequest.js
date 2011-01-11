zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zcf.requesttype;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;

  zcfr.SchoolTransportRegistrationRequest = function() {

    var fill = function(callUrl, callback, callbackParams) {
      var selector = this;
      zct.doAjaxCall(callUrl, null, function(o) {
        selector.innerHTML = o.responseText;
        if (zct.isFunction(callback))
          callback.apply(selector, callbackParams);
      }, true);
    };

    var empty = function() {
      this.innerHTML = '<option value="">Choisissez ...</option>';
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
      selector.innerHTML = '<option value="">Choisissez ...</option>';
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
      yus.query('fieldset').forEach(function(fieldset) {
        yud.setStyle(fieldset, 'padding', '0');
        yud.setStyle(fieldset, 'margin', '0');
      });
      yus.query('legend, label[for^="label"]').forEach(function(legend) {
        yud.addClass(legend, 'unactive');
      });
      yus.query('label[for^="id"]').forEach(function(label) {
        label.innerHTML = yud.getPreviousSibling(label).innerHTML + ' *';
      });
    };

    return {
      init: function() {
        var subject = yud.get('subjectId');

        // Return if we aren't on step 1
        if (subject == undefined)
          return;

        var linesCallUrlPrefix = zenexity.capdemat.contextPath + '/frontoffice/schoolTransportRegistration/transportLines';
        var stopsCallUrlPrefix = zenexity.capdemat.contextPath + '/frontoffice/schoolTransportRegistration/stops';

        changeLayout();

        // If we come back from step 2, save last line and stop values
        var lastLineValue, lastStopValue;
        if (subject.value !== '') {
          lastLineValue = yud.get('idLigne').value;
          lastStopValue = yud.get('idArret').value;
        }

        yud.get('idLigne').parentNode.replaceChild(new Selector('idLigne'), yud.get('idLigne'));
        yud.get('idLigne').updateLabelInput();
        yud.get('idArret').parentNode.replaceChild(new Selector('idArret'), yud.get('idArret'));
        yud.get('idArret').updateLabelInput();

        // Then refill selectors and reselect last values
        if (subject.value !== '') {
          yud.get('idLigne').fill(linesCallUrlPrefix + '/?childId=' + subject.value,
              select, [lastLineValue]);
          yud.get('idArret').fill(stopsCallUrlPrefix + '/?childId=' + subject.value + '&lineId=' + lastLineValue,
              select, [lastStopValue]);
        }

        yue.on('subjectId', 'change', function(event) {
          if (this.value !== '') {
            yud.get('idLigne').fill(linesCallUrlPrefix + '/?childId=' + this.value);
          } else {
            yud.get('idLigne').empty();
            yud.get('idArret').empty();
          }
        });

        yue.on('idLigne', 'change', function(event) {
          if (this.value !== '') {
            yud.get('idArret').fill(stopsCallUrlPrefix + '/?childId=' + subject.value + '&lineId=' + this.value);
          } else {
            yud.get('idArret').empty();
          }
        });

      }
    };

  }();

}());

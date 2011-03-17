zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong
  var zcfr = zcf.requesttype;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcfr.LeisureCenterRegistrationRequest = function() {

    var createSelect = function(id) {
      var el = yud.get(id);
      var newNode = document.createElement('select');
      newNode.className = el.className;
      newNode.name = el.name;
      newNode.id = el.id;
      newNode.options[0] = new Option('Choisissez...','');
      newNode.initOptions = function(jsonAsText) {
        var json = ylj.parse(jsonAsText);
        var index = 1;
        for (var key in json) {
            newNode.options[index++] = new Option(json[key],key);
        }
      };
      newNode.previousValue = yud.get('subjectId').value !== '' ? el.value : undefined;
      newNode.select = function(value) {
        var i = 0;
        for (i; i<this.length; i++){
          if (this.options[i].value === value){
            if (this.selectedIndex !== i)
              this.selectedIndex = i;
            break;
          }
        }
        replaceInput(this.id);
      };
      newNode.empty = function() {
        while (this.options.length > 1) {
          this.options[1].parentNode.removeChild(this.options[1]);
        }
        replaceInput(this.id);
      };
      el.parentNode.replaceChild(newNode,el);
      yue.on(newNode, 'change', function(e) { replaceInput(id); });
      return newNode;
    };

    var replaceInput = function(id) {
      var select = yud.get(id)
      var input = yud.get(id.replace('id', 'label'));
      var newNode = document.createElement('input');
      newNode.className = input.className;
      newNode.id = input.id;
      newNode.name = input.name;
      newNode.type = 'hidden';
      newNode.value = select.selectedIndex > 0 ? select.options[select.selectedIndex].innerHTML : '';
      input.parentNode.replaceChild(newNode,input);
    }

    var updateLayout = function() {
      zct.each(yus.query('fieldset'), function() {
        yud.setStyle(this, 'padding', 0);
        var legend = yud.getFirstChild(this);
        yud.setStyle(legend, 'color', '#000');
        legend.innerHTML = legend.innerHTML + ' *';
        zct.each(this.getElementsByTagName('label'), function() {
          yud.addClass(this, 'unactive');
        });
      });
    };

    return {
      init: function() {
        if (!yud.get('subjectId'))
          return;
        updateLayout();
        zcfr.LeisureCenterRegistrationRequest.initLines();
        zcfr.LeisureCenterRegistrationRequest.initCenters();
        yue.on('subjectId','change', zcfr.LeisureCenterRegistrationRequest.initCenters);
        yue.on('estTransport_yes', 'click', zcfr.LeisureCenterRegistrationRequest.initLines);
        yue.on('estTransport_yes', 'click', zcfr.LeisureCenterRegistrationRequest.initStops);
      },

      initCenters: function() {
        var centers = createSelect('idCentreLoisirs');

        var childId = yud.get('subjectId').value;
        if (childId !== '') {
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/leisureCenterRegistration/leisureCenters/?childId=' + childId, null, function(o){
            centers.initOptions(o.responseText);
            centers.select(centers.previousValue);
          }, true);
        } else {
          centers.empty();
        }
      },

      initLines: function() {
        var lines = createSelect('idLigne');
        yue.on('idLigne', 'change', zcfr.LeisureCenterRegistrationRequest.initStops);
        var childId = yud.get('subjectId').value;
        if (childId !== '') {
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/leisureCenterRegistration/lines/?childId=' + childId, null, function(o){
            lines.initOptions(o.responseText);
            lines.select(lines.previousValue);
          }, true);
        } else {
          lines.empty();
        }
      },

      initStops: function() {
        var stops = createSelect('idArret');

        var childId = yud.get('subjectId').value;
        var lineId = yud.get('idLigne').value;
        if (lineId !== '') {
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/leisureCenterRegistration/stops/?childId=' + childId
                  + '&lineId=' + lineId, null, function(o){
            stops.initOptions(o.responseText);
            stops.select(stops.previousValue);
          }, true);
        } else {
          stops.empty();
        }
      }

    };

  }();
}());

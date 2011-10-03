zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong
  var zcfr = zcf.requesttype;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcfr.HolidayCampRegistrationRequest = function() {

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
        var legend = yud.getFirstChild(this);
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
        zcfr.HolidayCampRegistrationRequest.initCamps();
        yue.on('subjectId','change', zcfr.HolidayCampRegistrationRequest.initCamps);
      },

      initCamps: function() {
        var camps = createSelect('idCentreSejours');

        var childId = yud.get('subjectId').value;
        var requestId = yud.get("stepForm").id.value;
        if (childId !== '') {
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/holidayCampRegistration/holidayCamps/?requestId=' + requestId + '&childId=' + childId, null, function(o){
            camps.initOptions(o.responseText);
            camps.select(camps.previousValue);
          }, true);
        } else {
          camps.empty();
        }
      }
    };

  }();
}());

zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong
  var zcfr = zcf.requesttype;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;

  zcfr.GlobalSchoolRegistrationRequest = function() {

    var createSelect = function(id) {
      var el = yud.get(id);
      var newNode = document.createElement('select');
      newNode.className = el.className;
      newNode.name = el.name;
      newNode.id = el.id;
      newNode.innerHTML = '<option value="">Choisissez ...</option>';
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
      yue.on(newNode, 'click', function(e) { toogleError(newNode); });
      yue.on(newNode, 'change', function(e) { replaceInput(id); });
      return newNode;
    };

    var replaceInput = function(id) {
      var select = yud.get(id);
      var input = yud.get(id.replace('id', 'label'));
      var newNode = document.createElement('input');
      newNode.className = input.className;
      newNode.id = input.id;
      newNode.name = input.name;
      newNode.type = 'hidden';
      newNode.value = select.selectedIndex > 0 ? select.options[select.selectedIndex].innerHTML : '';
      input.parentNode.replaceChild(newNode,input);
    }

    var toogleError = function(select) {
      if (!yud.hasClass(select, 'unactive')
          && select.options.length < 2
          && yud.get('subjectId').value !== '') {
        yud.get('stepForm-error').innerHTML = zcfr.GlobalSchoolRegistrationRequest.errorMessage;
        yud.addClass(yus.query("#request div.form")[0], 'invalid');
        yud.addClass(yus.query("#request div.steps li.current")[0], 'invalid');
      } else {
        yud.get('stepForm-error').innerHTML = '';
        yud.removeClass(yus.query("#request div.form")[0], 'invalid');
        yud.removeClass(yus.query("#request div.steps li.current")[0], 'invalid');
      }
    };

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
        zcfr.GlobalSchoolRegistrationRequest.initSchools();
        yue.on('subjectId','change', zcfr.GlobalSchoolRegistrationRequest.initSchools);
      },

      errorMessage : 'Aucune école de secteur ne vous est proposée.'
            + 'Si vous résidez hors de la ville, vous devez faire une demande de dérogation.'
            + 'Si vous résidez dans la ville, votre adresse est peut-être non conforme aux normes'
            + ' de la poste ou votre rue est nouvelle et non référencée. Contactez votre mairie.',

      initSchools: function() {
        var schoolSector = createSelect('idEcoleSecteur');
        var schoolDerog = createSelect('idEcoleDerog');

        var childId = yud.get('subjectId').value;
        if (childId !== '') {
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/globalSchoolRegistration/schoolSectors/?childId=' + childId, null, function(o){
            schoolSector.innerHTML = o.responseText;
            schoolSector.select(schoolSector.previousValue);
          }, true);
          zct.doAjaxCall(zenexity.capdemat.contextPath + '/frontoffice/globalSchoolRegistration/schoolDerogs/?childId=' + childId, null, function(o){
            schoolDerog.innerHTML = o.responseText;
            schoolDerog.select(schoolDerog.previousValue);
          }, true);
        } else {
          schoolSector.empty();
          schoolDerog.empty();
        }
      }
    };

  }();
}());

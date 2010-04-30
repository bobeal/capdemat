zenexity.capdemat.tools.namespace('zenexity.capdemat.common');

(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var yuc = YAHOO.util.Connect;
  var yl = YAHOO.lang;
  var ylj = yl.JSON;

  zcc.AutoCompleteStatic = function() {
    return {
      KEY: {
        UP: 38,
        DOWN: 40,
        DEL: 46,
        TAB: 9,
        RETURN: 13,
        ESC: 27,
        COMMA: 188,
        PAGEUP: 33,
        PAGEDOWN: 34,
        BACKSPACE: 8
      }
    };
  }();

  zcc.AutoComplete = function(options) {
    this.inputId = options.inputId;
    this.modalId = options.modalId;
    this.modalTitle = options.modalTitle;
    this.url = options.url;
    this.urlParams = options.urlParams;
    this.resultText = options.resultText;
    this.inputValue = options.inputValue;
    this.idField = options.idField;
    this.onSelectedResult = options.onSelectedResult;
    this.jsonp = options.jsonp;
    this.classes = (options.classes==undefined ? "" : options.classes);
    if(options.delay) this.delay = options.delay;
    this.bindEvents();
    document.getElementById(this.inputId).autocomplete = "off";
    if(options.offset) this.offset = options.offset;

    var that = this;
    yue.on(document, "click", function() {
      if(that.eventTimer) {
        clearTimeout(that.eventTimer);
        that.hide();
      }
    });
  };

  zcc.AutoComplete.prototype = {

    // Options
    modalId: "",
    modalTitle: "",
    results: [],
    input: null,
    url: "",
    urlParams: {},
    resultText: null,
    delay: 200,
    inputValue: null,
    offset: {left: 0, top: 0},
    idField: "",
    classes: "",
    onSelectedResult: undefined,
    jsonp: false,

    // Internals
    val: "",
    timeout: null,
    blockSubmit: false,
    blur: false,
    eventTimer: null,
    keyEvent: false,

    getModalNodes: function() {
      var div = document.createElement("div");
      div.id = this.modalId;
      div.className = "autocomplete modal " + this.classes;
      if(this.modalTitle) {
        var h3 = document.createElement("h3");
        h3.innerHTML = this.modalTitle;
        div.appendChild(h3);
      }
      var ul = document.createElement("ul");
      ul.className = "results";
      div.appendChild(ul);
      return div;
    },

    drawResults: function() {
      if(this.results.length>0) {
        var resultsNode = yus.query("#" + this.modalId + " .results", document, true);
        for(var i=0; i<this.results.length; i++) {
          var li = document.createElement("li");
          li.id = this.inputId.replace("_","") + "AutoComplete_" + this.results[i][this.idField];
          li.innerHTML = this.resultText(this.results[i]);
          resultsNode.appendChild(li);
        }
      }
    },

    valChange: function() {
      var input = document.getElementById(this.inputId);
      if(input.value != this.val) {
        this.val = input.value;
        this.search();
      }
    },

    onKeydown: function(event) {
      var that = this;
      var KEY = zcc.AutoCompleteStatic.KEY;
      switch(event.keyCode) {
        case KEY.RETURN:
          if(this.isShow()) {
            event.preventDefault();
            this.blockSubmit = true;
            this.selectHighlighted();
            this.hide();
            return false;
          }
          break;
        case KEY.UP:
          event.preventDefault();
          if(this.isShow()) {
            this.highligthPrevious();
          }
          break;
        case KEY.DOWN:
          event.preventDefault();
          if(this.isShow()) {
            this.highligthNext();
          }
          break;
        case KEY.TAB:
          this.hide();
          break;
        default:
          if(this.timeout!=null) {
            clearTimeout(this.timeout);
          }
          this.timeout = setTimeout(function() { that.valChange.call(that); }, this.delay);
          break;
      }
    },

    bindEvents: function() {
      var that = this;
      var input = document.getElementById(this.inputId);
      var onKeyDown = function(event) {
        that.onKeydown.call(that, event);
      };
      if(!YAHOO.env.ua.opera) {
        input.onkeydown = onKeyDown;
      }
      else {
        input.onkeypress = onKeyDown;
      }
    },

    search: function() {
      var that = this;
      if(this.val) {
        var callback = function(results) {
          if(results==null || results.length<=0) {
            that.hide();
          }
          else {
            that.results = results;
            that.show.call(that);
          }
        };
        var allParams = this.urlParams || {};
        allParams.search = this.val;
        if(this.jsonp) {
          new JSONP(this.url, {
            onSuccess: callback,
            params: allParams
          });
        }
        else {
          yuc.asyncRequest("GET", this.url + zct.param(allParams), callback);
        }
      }
      else {
        this.hide();
      }
    },

    highligthPrevious: function() {
      var prevElem = yud.getPreviousSibling(yus.query("#" + this.modalId + " .selected", document, true));
      if(prevElem) {
        this.highlight(prevElem);
      }
    },

    highligthNext: function() {
      var nextElem = yud.getNextSibling(yus.query("#" + this.modalId + " .selected", document, true));
      if(nextElem) {
        this.highlight(nextElem);
      }
    },

    highlight: function(elem) {
      zct.each(yus.query("#" + this.modalId + " .results > *"), function() {
        yud.removeClass(this, "selected");
      });
      yud.addClass(elem, "selected");
    },

    selectHighlighted: function() {
      var highlightedElem = yus.query("#" + this.modalId + " .selected", document, true);
      var result = this.getResult(highlightedElem.id.split("_")[1]);
      var input = document.getElementById(this.inputId);
      input.value = this.inputValue(result);
      if(YAHOO.env.ua.opera && this.blockSubmit) {
        this.blockSubmit = false;
        return false;
      };
      if(this.onSelectedResult !== undefined) this.onSelectedResult(result);
    },

    getResult: function(id) {
      if(this.results!=null) {
        for(var i=0; i<this.results.length; i++) {
          if(this.results[i][this.idField]==id) {
            return this.results[i];
          }
        }
      }
      return null;
    },

    show: function() {
      var that = this;

      this.hide();
      this.blockSubmit = false;
      document.getElementsByTagName("body")[0].appendChild(this.getModalNodes());

      var modal = document.getElementById(this.modalId);

      var inputXY = yud.getXY(document.getElementById(this.inputId));
      modal.style.left = this.offset.left + inputXY[0] + "px";
      modal.style.top = this.offset.top + inputXY[1] + "px";

      this.drawResults();

      this.highlight(yus.query("#" + this.modalId + " .results > *:first", document, true));

      zct.each(yus.query("#" + this.modalId + " .results > *"), function() {
        yue.on(this, "click", function(event) {
          that.highlight.call(that, event.target);
          that.selectHighlighted.call(that);
          if(that.eventTimer) {
            clearTimeout(that.eventTimer);
            that.hide();
          }
          return false;
        });
      });

      yue.on(document.getElementById(this.inputId), "blur", function(event) {
        if(that.isShow()) {
          that.eventTimer = setTimeout(function() { that.hide(); }, 2000);
        }
      });
    },

    hide: function() {
      this.blockSubmit = false;
      var modal = document.getElementById(this.modalId)
      if(modal) modal.parentNode.removeChild(modal);
    },

    isShow: function() {
      return !!document.getElementById(this.modalId);
    }
  };

}());

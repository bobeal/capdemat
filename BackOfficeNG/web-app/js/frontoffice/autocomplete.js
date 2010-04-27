zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');

(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var yuc = YAHOO.util.Connect;
  var yl = YAHOO.lang;
  var ylj = yl.JSON;
  
  zcf.AutoCompleteStatic = function() {
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

  zcf.AutoComplete = function(options) {
    this.input = options.input;
    this.hiddenInput = options.hiddenInput;
    this.modalId = options.modalId;
    this.modalTitle = options.modalTitle;
    this.url = options.url;
    this.urlParams = options.urlParams;
    this.tpl_result = options.tpl_result;
    this.tpl_valInput = options.tpl_valInput;
    this.tpl_valHiddenInput = options.tpl_valHiddenInput;
    this.idField = options.idField;
    this.onSelectedResult = options.onSelectedResult;
    this.classes = (options.classes==undefined ? "" : options.classes);
    if(options.delay) {
      this.delay = options.delay;
    }
    this.bindEvents();
    this.input.autocomplete = "off";
    if(options.offset) {
      this.offset = options.offset;
    }
    
    this.submitEvent = yu.CustomEvent();

    // prevent form submit in opera when selecting with return key
    /*
    $.browser.opera && yu.CustomEvent(input.form, "submit.autocomplete", function() {
      if (blockSubmit) {
        blockSubmit = false;
        return false;
      }
    });
    */

    var that = this;
    yue.on(document, "click", function() {
      if(that.eventTimer) {
        clearTimeout(that.eventTimer);
        that.hide();
      }
    });
  };

  zcf.AutoComplete.prototype = {

    // Options
    modalId: "",
    modalTitle: "",
    results: [],
    input: null,
    hiddenInput: null,
    url: "",
    urlParams: {},
    tpl_result: null,
    delay: 200,
    tpl_valHiddenInput: null,
    tpl_valInput: null,
    offset: {left: 0, top: 0},
    idField: "",
    classes: "",
    onSelectedResult: undefined,

    // Internals
    val: "",
    timeout: null,
    blockSubmit: false,
    blur: false,
    isShow: false,
    eventTimer: null,
    keyEvent: false,

    tpl_modal: function() {
      return (
        '<div id="' + this.modalId + '" class="autocomplete modal ' + this.classes + '">' +
        ( this.modalTitle ? '<h3>' + this.modalTitle + '</h3>' : '') +
        '  <ul class="results"></ul>' +
        '</div>'
      );
    },

    drawResults: function() {
      if(this.results.length>0) {
        var htmlResults = "";
        this.resultIds = [];
        for(var i=0; i<this.results.length; i++) {
          htmlResults += this.tpl_result(this.results[i]);
          this.resultid = this.results[i][this.idField];
        }
        yus.query("#" + this.modalId + " .results", true).innerHtml = htmlResults;
      }
    },

    valChange: function() {
      if(this.input.value != this.val) {
        this.val = this.input.value;
        this.search();
      }
    },

    onKeydown: function(jqCtx, event) {
      var that = this;
      var KEY = zzc.AutoCompleteStatic.KEY;
      switch(event.keyCode) {
        case KEY.RETURN:
          if(this.isShow) {
            event.preventDefault();
            // prevent form submit in opera when selecting with return key
            this.blockSubmit = true;
            this.selectHighligthed();
            this.hide();
            return false;
          }
          break;
        case KEY.UP:
          event.preventDefault();
          if(this.isShow) {
            this.highligthPrevious();
          }
          break;
        case KEY.DOWN:
          event.preventDefault();
          if(this.isShow) {
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
      yue.on(this.input, YAHOO.env.ua.opera ? "keypress" : "keydown", function(event) {
        that.onKeydown.call(that,this,event);
      });
    },

    search: function() {
      var that = this;
      if(this.val) {
        yuc.asyncRequest("GET", this.url + zct.param(yl.extend(this.urlParams, {q: this.val})), function(results) {
          if(results==null || results.length<=0) {
            that.hide();
          }
          else {
            that.results = results;
            that.show.call(that);
          }
        })
      }
      else {
        this.hide();
      }
    },

    highligthPrevious: function() {
      var prevElem = yud.getPreviousSibling(yus.query("#" + this.modalId + " .selected", true));
      if(prevElem[0]) {
        this.highlight(prevElem);
      }
    },

    highligthNext: function() {
      var nextElem = yud.getNextSibling(yus.query("#" + this.modalId + " .selected", true));
      if(nextElem[0]) {
        this.highlight(nextElem);
      }
    },

    highlight: function(elem) {
      zct.each(yud.query("#" + this.modalId + " .results > *", true), function() {
        yud.removeClass(this, "selected");
      });
      yud.addClass(elem, "selected");
    },

    selectHighligthed: function() {
      var highlightedElem = yus.query("#" + this.modalId + " .selected", true);
      var result = this.getResult(highlightedElem.resultid);
      this.input.value = this.tpl_valInput(result);
      if(this.hiddenInput) {
        this.hiddenInput.value = this.tpl_valHiddenInput(result);
      }
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
      var modal = document.getElementById(this.modalId);
      if(modal) {
        this.hide();
      }
      this.blockSubmit = false;
      yus.query("body").innerHtml += this.tpl_modal();
      
      var left = this.input.offsetLeft;
      var top = this.input.offsetTop + this.input.offsetHeight + 8;
      
      modal.style.left = this.offset.left + left;
      modal.style.top = this.offset.top + top;
      this.drawResults();

      this.highlight(yus.query("#" + this.modalId + " .results > *:first", true));
      zct.each(yus.query("#" + this.modalId + " .results > *"), function() {
        yue.on(this, "click", function(event) {
          that.highlight.call(that, event.target);
          that.selectHighligthed.call(that);
          if(that.eventTimer) {
            clearTimeout(that.eventTimer);
            that.hide();
          }
          return false;
        });
      });  
      yue.on(this.input, "blur", function(event) {
        if(that.isShow) {
          that.eventTimer = setTimeout(function() { that.hide(); }, 2000);
        }
      });
      this.isShow = true;
    },

    hide: function() {
      this.blockSubmit = false;
      if(this.isShow) {
        yu.Element.removeChild(document.getElementById(this.modalId));
      }
      this.isShow = false;
    }
  };

}());

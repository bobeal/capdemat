/**
 * Provides collection of tools customized/optimized for capdemat client-side needs.
 * Partially inspired by jQuery and partially based on jQuery syntactic sugar.
 *
 * @namespace zenexity.capdemat.tools
 * @author vba@zenexity.fr
 *
 **/
(function(){
  
  window.zenexity = {
    capdemat: {
      tools: {},
      common: {}
    }
  };

  var userAgent = navigator.userAgent.toLowerCase();
  var s = YAHOO.util.Selector;
  var zct = zenexity.capdemat.tools;
  
  zct.browser = {
    version: (userAgent.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [])[1],
    safari: /webkit/.test(userAgent),
    opera: /opera/.test(userAgent),
    msie: /msie/.test(userAgent) && !/opera/.test(userAgent),
    mozilla: /mozilla/.test(userAgent) && !/(compatible|webkit)/.test(userAgent)
  };

  /**
   * @description Returns the namespace specified and creates it if it doesn't exist
   * @method namespace
   * @namespace zenexity.capdemat.tools
   * @param  {String*} arguments 1-n namespaces to create
   * @return {Object}  A reference to the last namespace object created
   *
   * @author vba@zenexity.fr
   **/
  zct.namespace = function(){
    var a = arguments, o = null, i, j, d;
    for (i = 0; i < a.length; i = i + 1) {
      d = a[i].split(".");
      o = window;
      for (j = 0; j < d.length; j = j + 1) {
        o[d[j]] = o[d[j]] || {};
        o = o[d[j]];
      }
    }
    return o;
  };
  
  /**
   * @description Execute a function within the context of passed element
   * @method each
   * @namespace zenexity.capdemat.tools
   * @param {Object|Array} object context element
   * @param {Function} callback function that will be executed in the context of each element
   * @param {Array} args additional params to be passed in callback function
   *
   * @author vba@zenexity.fr
   **/
  zct.each = function(object, callback, args){
    var name, i = 0, length = object.length;
    if (args) {
      if (length == undefined) {
        for (name in object)
          if (callback.apply(object[name], args) === false)
            break;
      }
      else
        for (; i < length;)
          if (callback.apply(object[i++], args) === false)
            break;
    }
    else {
      if (length == undefined) {
        for (name in object)
          if (callback.call(object[name], name, object[name]) === false)
            break;
      }
      else
        for (var value = object[0]; i < length && callback.call(value, i, value) !== false; value = object[++i]) {
        }
    }
    return object;
  };

  /**
   * @description Returns an array of elements that pass the test(grep) method.
   * @method grep
   * @namespace zenexity.capdemat.tools
   * @param {Array} array of elements to grep
   * @param {Function} test function that is applied to each element
   * @returns {Array} list of elments passed test
   * 
   * @author vba@zenexity.fr
   **/
  zct.grep = function(elems, callback, inv){
    var ret = [];
    for (var i = 0, length = elems.length; i < length; i++)
      if (!inv != !callback(elems[i], i))
        ret.push(elems[i]);
    return ret;
  };
  
  /**
   * @description Goes through the array, translating each of the items to their new value (or values). 
   * @method map
   * @namespace zenexity.capdemat.tools
   * @param {Array} Array of elements
   * @param {Function} Translation function
   * @returns {Array} translated array
   * 
   * @author vba@zenexity.fr
   **/
  zct.map = function(elems, callback){
    var ret = [];
    for (var i = 0, length = elems.length; i < length; i++) {
      var value = callback(elems[i], i);
      if (value != null)
        ret[ret.length] = value;
    }
    return ret.concat.apply([], ret);
  };

  /**
   * @description Checks if passed node element has indicated name.
   * @method nodeName
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} DOM node
   * @param {String} name to check
   * @returns {Boolean} result of test
   * 
   * @author vba@zenexity.fr
   **/
  zct.nodeName = function(elem, name){
    return elem.nodeName && elem.nodeName.toUpperCase() == name.toUpperCase();
  };

  /**
   * @description Normalize an array or transform an element to an array
   * @method makeArray
   * @namespace zenexity.capdemat.tools
   * @param {Object|Array} array element/array to be processed
   * @returns {Array} new array
   * 
   * @author vba@zenexity.fr
   **/
  zct.makeArray = function(array){
    var ret = [];
    if (array != null) {
      var i = array.length;
      if (i == null || array.split || array.setInterval || array.call)
        ret[0] = array;
      else
        while (i)
          ret[--i] = array[i];
    }
    return ret;
  }

  /**
   * @description Mergs two arrays
   * @method merge
   * @namespace zenexity.capdemat.tools
   * @param {Array} first first array to merge
   * @param {Array} second second array to merge
   * @returns {Array} merged array
   * 
   * @author vba@zenexity.fr
   **/
  zct.merge = function( first, second ) {
    var i = 0, elem, pos = first.length;
    if ( zct.browser.msie ) {
      while ( elem = second[ i++ ] )
        if ( elem.nodeType != 8 )
          first[ pos++ ] = elem;
    } else
      while ( elem = second[ i++ ] )
        first[ pos++ ] = elem;
    return first;
  };
  
  /**
   * @description Gets element position in array if this one is contained in array or gets -1 otherwise
   * @method inArray
   * @namespace zenexity.capdemat.tools
   * @param {Object} elem element to find
   * @param {Array} array array to perorm test
   * @returns {Integer} position if element found or -1 otherwise
   * 
   * @author vba@zenexity.fr
   **/
  zct.inArray = function(elem, array){
    for (var i = 0, length = array.length; i < length; i++)
      if (array[i] === elem)
        return i;
    return -1;
  };

  /**
   * @description Check if an object is a function (more sophisticated check that YUI)
   * @method isFunction
   * @namespace zenexity.capdemat.tools
   * @param {Object} object to be checked
   * @returns {Boolean} test result
   * 
   * @author vba@zenexity.fr
   **/
  zct.isFunction = function(fn){
    return !!fn && typeof fn != "string" && !fn.nodeName &&
    fn.constructor != Array &&
    /^[\s[]?function/.test(fn + "");
  };
  
  /**
   * @description Serialize an array of form elements or a set of key/values into a query string
   * @method param
   * @namespace zenexity.capdemat.tools
   * @param {Array} a array to be serialized
   * @returns {String} query string
   * 
   * @author vba@zenexity.fr
   **/
  zct.param = function(a){
    var s = [];
    var c = zct.grep(a, function(n){
      return (!!n['name'] && typeof n['value'] != 'undefined');
    });
    if (a.constructor == Array && c.length > 0)
      zct.each(c, function(){
        s.push(encodeURIComponent(this.name) + "=" + encodeURIComponent(this.value));
      });
    else
      for (var j in a) {
        if (a[j] && a[j].constructor == Array)
          zct.each(a[j], function(){
            s.push(encodeURIComponent(j) + "=" + encodeURIComponent(this));
          });
        else
          s.push(encodeURIComponent(j) + "=" + encodeURIComponent(zct.isFunction(a[j]) ? a[j]() : a[j]));
      }
    return s.join("&").replace(/%20/g, "+");
  };
  
  /**
   * @description Normalize an array of HTMLElements for query string serialization.
   * @method serializeArray
   * @namespace zenexity.capdemat.tools
   * @param {String} nodeId  An ID of html element-container 
   * @returns {Array} Normalized array
   * 
   * @author vba@zenexity.fr
   **/
  zct.serializeArray = function(nodeId){
    var node = s.query('#' + nodeId)[0];
    var a = [], n = [];
    if (zct.nodeName(node, 'form'))
      a = node.elements;
    else
      a = s.query('#' + nodeId + ' *');

    n = zct.grep(a, function(o){
      return o.name && !o.disabled &&
      (o.checked ||
      /select|textarea/i.test(o.nodeName) ||
      /text|hidden|password/i.test(o.type));
    });

    n = zct.map(n, function(elem, i){
      var val = zct.val(elem);
      return val == null ? null : val.constructor == Array ? zct.map(val, function(val, i){
        return {
          name: elem.name,
          value: val
        };
      }) : {
        name: elem.name,
        value: val
      };
    });
    return zct.makeArray(n);
  };
  
  /**
   * @description Realize a facade for elements serialization
   * @method serialize
   * @namespace zenexity.capdemat.tools
   * @param {String} nodeId  An ID of html element-container
   * @returns {String} query string
   * 
   * @author vba@zenexity.fr
   **/
  zct.serialize = function(nodeId){
    return zct.param(zct.serializeArray(nodeId));
  };
  
  /**
   * @description Gets/sets the content of the value attribute of the passed element.
   * @method val
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} element scope element
   * @param {String|Undefined} value to be set
   * @returns {Object} element value if method used as getter case
   * 
   * @author vba@zenexity.fr
   **/
  zct.val = function(element, value){
    if (value == undefined) {
      if (!!element) {
        if (zct.nodeName(element, "select")) {
          var index = element.selectedIndex, values = [], options = element.options, one = element.type == "select-one";
          if (index < 0)
            return null;
          for (var i = one ? index : 0, max = one ? index + 1 : options.length; i < max; i++) {
            var option = options[i];
            if (option.selected) {
              value = zct.browser.msie && !option.attributes.value.specified ? option.text : option.value;
              if (one)
                return value;
              values.push(value);
            }
          }
          return values;
        }
        else
          return (element.value || "").replace(/\r/g, "");
      }
      return undefined;
    }
    if (value.constructor == Number)
      value += '';
    return (function(){
      if (element.nodeType != 1)
        return;
      if (value.constructor == Array && /radio|checkbox/.test(element.type))
        element.checked = (zct.inArray(element.value, value) >= 0 ||
        zct.inArray(element.name, value) >= 0);
      else
        if (zct.nodeName(element, "select")) {
          var values = zct.makeArray(value);
          var options = s.filter(element, "option");
          zct.each(options, function(i){
            this.selected = (zct.inArray(this.value, values) >= 0 ||
            zct.inArray(this.text, values) >= 0);
          });
          if (!values.length)
            element.selectedIndex = -1;
        }
        else
          this.value = value;
    })();
  };

  /**
   * @description Strips HTML tags
   * @method stripTags
   * @namespace zenexity.capdemat.tools
   * @param {String} string Striping scope.
   * @returns {String} striped string
   * 
   * @author vba@zenexity.fr
   **/
  zct.stripTags = function(string){
    return string.replace(/<\/?[^>]+>/gi, '');
  };

  /**
   * @description HTMLElement styles setter/getter
   * @method style
   * @namespace zenexity.capdemat.tools
   * @param {String | HTMLElement | Array} el Accepts a string to use as an ID, an actual DOM reference, or an Array of IDs and/or HTMLElements.
   * @param {Array} JSON object that describes styles to set
   * @author vba@zenexity.fr
   **/
  zct.style = function(el, styles){
    if (typeof styles != 'undefined') {
      zct.each(styles, function(key){
        var value = this.toString();
        YAHOO.util.Dom.setStyle(el, key.toString(), value);
      });
    }
    else {
      YAHOO.util.Dom.getStyle(el);
    }
  };

  /**
   * @description Generates universally unique identifier in string format.
   * @method generateUID
   * @namespace zenexity.capdemat.tools
   * @returns {String} newly generated UUID
   * 
   * @author vba@zenexity.fr
   */
  zct.generateUUID = function(){
    //return Math.random().toString(16).substring(2);
    var s = [], itoh = '0123456789ABCDEF';

    for (var i = 0; i < 36; i++) {
      s[i] = Math.floor(Math.random() * 0x10);
    }

    s[14] = 4;
    s[19] = (s[19] & 0x3) | 0x8;

    for (var i = 0; i < 36; i++) {
      s[i] = itoh[s[i]];
    }

    s[8] = s[13] = s[18] = s[23] = '-';

    return s.join('');
  };

  /**
   * @description Tries to call a function safely
   * @method tryToCall
   * @namespace zenexity.capdemat.tools
   * @param {Function*} f function object to be called
   * @param {Object*} c context in which function is called
   * @param {Array | Object*} params parameters to be supplied to function call
   * @returns{Object | Undefined} function execution result if this one had place
   * 
   * @author vba@zenexity.fr
   */
  zct.tryToCall = function(){
    var a = arguments;
    var f = a[0], c = a[1];

    if (zct.isFunction(f)) {
      return f.apply(c, zct.makeArray(a).slice(2));
    }
    else {
      return false;
    }
  };

  /**
   * @description Capitalizes entered world/sentence
   * @method capitalize
   * @namespace zenexity.capdemat.tools
   * @param {String} s world to be capitalized
   * @returns {String} Capitalized string
   * 
   * @author vba@zenexity.fr
   */
  zct.capitalize = function(s){
    return [s.charAt(0).toUpperCase(), s.substring(1)].join('');
  };

  /**
   * @description Get a set of elements containing all of siblings of passed element.
   * @method siblings
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} el scope element to retrieve siblings
   * @param {Function} callback function applied to each sibling
   * @returns {Array} siblings collection
   * @author vba@zenexity.fr
   */
  zct.siblings = function(el, callback){
    if (!!el.parentNode) {
      var parent = el.parentNode;
      return YAHOO.util.Dom.getChildrenBy(parent, function(node){
        var result = false;
        if (node !== el) {
          result = true;
          zct.tryToCall(callback, node, node);
        }
        return result;
      });
    }
    else {
      return false
    }
  };

  /**
   * @description Set the combined text contents to indicated DOM element. Escapes HTML (replace "<" and ">" with their HTML entities). Cannot be used on input elements.
   * @method text
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} node scope element.
   * @param {String} text to append/apply to node.
   * @param {Boolean} append flag to indicate if specified text has to be append as new text node.
   * @returns {String} element textual value (if used as getter)
   * @author vba@zenexity.fr
   */
  zct.text = function(node,text, append) {
    var el = new YAHOO.util.Element(node);
    if (typeof text != "object" && text != null) {
      if(!append) el.get('element').innerHTML = "";
      el.appendChild((!!node && node.ownerDocument || document).createTextNode(text));
    }
  };

  /**
   * @description Gets/Sets specified node html. Cannot be used on input elements.
   * @method html
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} node scope element.
   * @param {String} html text to apply as node HTML.
   * @returns {String} element html content "as is" (if used as getter)
   * @author vba@zenexity.fr
   *
   */
  zct.html = function(node,html) {
    if(!node.nodeType) return undefined;
    if(!html) {
      return node.innerHTML;
    }else {
      node.innerHTML = "";
      node.innerHTML = html;
      return true;
    }
  };
  
  /**
   * @description Toggles css class for specified DOM element
   * @method toggleClass
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} node scope element
   * @param {String} className class to be toggled
   * 
   * @author vba@zenexity.fr
   **/
  zct.toggleClass = function(node,className) {
    if(YAHOO.util.Dom.hasClass(node,className)) YAHOO.util.Dom.removeClass(node,className);
    else YAHOO.util.Dom.addClass(node,className);
  }
  
  /**
   * @description Fade in passed element by adjusting its opacity and firing an optional callback after completion
   * @method fadeIn
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} el element to be processed
   * @param {Float} speed animation speed(in seconds) 
   * @param {Function} callback function that is called after adjusting
   * 
   * @author vba@zenexity.fr
   **/
  zct.fadeIn = function(el,speed,callback){ /* implementation below */ };
  
  /**
   * @description Fade out passed element by adjusting its opacity and firing an optional callback after completion
   * @method fadeOut
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} el element to be processed
   * @param {Float} speed animation speed(in seconds) 
   * @param {Function} callback function that is called after adjusting
   * 
   * @author vba@zenexity.fr
   **/
  zct.fadeOut = function(el,speed,callback){/* implementation below */ };
  
  /**
   * @description Cover method that "freeze" element opacity during an interval and fire an optional callback after completion
   * @method fadeNone
   * @namespace zenexity.capdemat.tools
   * @param {HTMLElement} el element to be processeda
   * @param {Float} speed animation speed(in seconds) 
   * @param {Function} callback function that is called after freezing
   * 
   * @author vba@zenexity.fr
   **/
  zct.fadeNone = function(el,speed,callback){/* implementation below */ };
  
  //Create innerHeight, innerWidth, outerHeight and outerWidth methods
  zct.each(["Height", "Width"], function(i, name){
    var type = name.toLowerCase();
    var browser = zct.browser;
    zct[type] = function(element, size){
      var el = new YAHOO.util.Element(element);

      return element == window ? browser.opera && document.body["client" + name] ||
      browser.safari && window["inner" + name] ||
      document.compatMode == "CSS1Compat" && document.documentElement["client" + name] ||
      document.body["client" + name] : element == document ? Math.max(Math.max(document.body["scroll" + name], document.documentElement["scroll" + name]), Math.max(document.body["offset" + name], document.documentElement["offset" + name])) : size == undefined ? parseInt(el.getStyle(type)) : (el.setStyle(type, size.constructor == String ? size : size + "px"));
    };
  });

  zct.each(["In","None","Out"], function(i,name){
    var method = ['fade',name].join('');
    var map = {
      "In" : {from:0,to:1},
      "None" : {from:1,to:1},
      "Out" : {from:1,to:0}
    };
    zct[method] = function(el,speed,callback) {
      if(!el || !el.nodeName) return;
      var a = new YAHOO.util.Anim(el,{opacity:map[name]},speed);
      a.animate();
      a.onComplete.subscribe(callback);
    }
  });




}());





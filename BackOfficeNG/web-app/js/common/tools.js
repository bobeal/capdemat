/**
 * Partially inspired by jQuery and partially based on jQuery syntactic sugar.
 *
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

  zct.grep = function(elems, callback, inv){
    var ret = [];
    for (var i = 0, length = elems.length; i < length; i++)
      if (!inv != !callback(elems[i], i))
        ret.push(elems[i]);
    return ret;
  };

  zct.map = function(elems, callback){
    var ret = [];
    for (var i = 0, length = elems.length; i < length; i++) {
      var value = callback(elems[i], i);
      if (value != null)
        ret[ret.length] = value;
    }
    return ret.concat.apply([], ret);
  };

  zct.nodeName = function(elem, name){
    return elem.nodeName && elem.nodeName.toUpperCase() == name.toUpperCase();
  };

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

  zct.inArray = function(elem, array){
    for (var i = 0, length = array.length; i < length; i++)
      if (array[i] === elem)
        return i;
    return -1;
  };

  zct.isFunction = function(fn){
    return !!fn && typeof fn != "string" && !fn.nodeName &&
    fn.constructor != Array &&
    /^[\s[]?function/.test(fn + "");
  };

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

  zct.serialize = function(nodeId){
    return zct.param(zct.serializeArray(nodeId));
  };

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
   * @param {String} string Striping scope.
   * @author vba@zenexity.fr
   **/
  zct.stripTags = function(string){
    return string.replace(/<\/?[^>]+>/gi, '');
  };

  /**
   * @description HTMLElement styles setter/getter
   * @method style
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
   * @description Tries to call a function safetly
   * @method tryToCall
   * @param {Function} f function object to be called
   * @param {Object} c context in which function is called
   * @param {Array | Object} params parameters to be suplied to function call
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
   * @param {String} s world to be capitalized
   * @author vba@zenexity.fr
   */
  zct.capitalize = function(s){
    return [s.charAt(0).toUpperCase(), s.substring(1)].join('');
  };

  /**
   * @description Get a set of elements containing all of siblings of passed element.
   * @method siblings
   * @param {HTMLElement} el scope element to retrive siblings
   * @param {Function} callback function applied to each sibling
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
   * @param {HTMLElement} node scope element.
   * @param {String} text to append/apply to node.
   * @param {Boolean} append flag to indicate if specified text has to be append as new text node.
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
   * @param {HTMLElement} node scope element.
   * @param {String} html text to apply as node HTML.
   * @author vba@zenexity.fr
   *
   */
  zct.html = function(node,html) {
    if(!node.nodeType || !node.innerHTML) return undefined;
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
   * @param node {HTMLElement} scope element
   * @param className {String} class to be toggled
   * 
   * @author vba@zenexity.fr
   **/
  zct.toggleClass = function(node,className) {
    if(YAHOO.util.Dom.hasClass(node,className)) YAHOO.util.Dom.removeClass(node,className);
    else YAHOO.util.Dom.addClass(node,className);
  }

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





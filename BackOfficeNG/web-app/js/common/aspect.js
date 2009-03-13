
/**
 * @description This file contains PUT YOUR DESCRIPTION
 * 
 * @author rdj@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.aspect');

(function(){

  var zct = zenexity.capdemat.tools;
  var zca = zenexity.capdemat.aspect;
  
  var yl = YAHOO.lang;
  
  var ap = Array.prototype, contextStack = [], context;
  
  zca._stack = [];
  
  zca.Advice = function(type,func) {
    this.type = type;
    this.func = func;
    
    this.uniqueId = zct.generateUUID();
    this.children = [];
  };
  
  zca.Advice.prototype = {
    isAdvice : function() {return true;}
  };
  
  zca.advise = function(method,advice,scope) {
    var part = typeof scope != 'undefined' ? 'With' : 'WithNo';
    return zca[['_proceed',part,'Scope'].join('')].apply(zca,[method,advice,scope]);
  };
  
  zca._proceedWithNoScope = function(method,advice) {
    
    //zct.each()
  };
  
  zca._proceedWithScope = function(method,advice,scope) {
    var methods = []; var advices = zct.makeArray(advice);
    if(!(method instanceof Array)) method = [method];
    if(typeof scope != "object") scope = scope.prototype;
    if(!scope) return false;
    
    zct.each(method,function(i){
      var that = this;
      if(that instanceof RegExp){
        zct.each(scope,function(k){ if(zct.isFunction(this) && that.test(k)) methods.push(k);});
      }
      else if (that instanceof String && zct.isFunction(scope[method[i]])){
        methods.push(method[i]);
      }
    });
    
    var b = zct.grep(advices,function(n){return n.type == "before" && !!n['isAdvice'];});
    var bs = zct.grep(advices,function(n){return n.type == 'beforeSuccess' && !!n['isAdvice'];});
    //var a = zct.grep(advices,function(n){return n.type == 'around';});
    var ar = zct.grep(advices,function(n){return n.type == 'afterReturn';});
    var at = zct.grep(advices,function(n){return n.type == 'afterThrow';});
    
    zct.each(methods,function(){
      var method=this+'',prev=scope[method];
      
      scope[method] = function() {
        var result = undefined;
        if(zca._callBeforeSuccess(bs,zct.makeArray(arguments),scope)){
          zca._callBasic(b,zct.makeArray(arguments),scope);
          try {
            result = prev.apply(scope,zct.makeArray(arguments));
          }catch(ex) {
            zca._callBasic(at,zct.merge(zct.makeArray(arguments),zct.makeArray(ex)||[]),scope);
          }finally {
            zca._callBasic(ar,zct.merge(zct.makeArray(arguments),zct.makeArray(result)||[]),scope);
          }
        }
      };
    });
  };
  
  zca._callBasic = function(advice,argz,scope) {
    zct.each(zct.makeArray(advice),function(){this.func.apply(scope||this,argz);});
  };
  
  zca._callBeforeSuccess = function(advice,argz,scope) {
    var result = true;
    zct.each(zct.makeArray(advice),function(){result = result && this.func.apply(scope||this,argz);});
    return result;
  };
  
  zca._around = function() {throw 'advise around is not yet implemented !';};
  
  

  /**
   * @description Attach AOP-style advices to a method. Attaches AOP-style advices to a method. Can attach several advices at once and operate on several methods of an object. The latter is achieved when a RegExp is specified as a method name, or an array of strings and regular expressions is used. In this case all functional methods that satisfy the RegExp condition are processed. This function returns a handle, which can be used to unadvise, or null, if advising has failed.
   * @namespace zenexity.capdemat.aspect
   * @method advise
   * @param obj {Object} A source object for the advised function. Cannot be a DOM node. If this object is a constructor, its prototype is advised.
   * @param method {String|RegExp|Array} A string name of the function in obj. In case of RegExp all methods of obj matching the regular expression are advised.
   * @param advice {Object|Function|Array} An object, which defines advises, or a function, which returns such object, or an array of previous items. The advice object can define following member functions: before, around, afterReturning, afterThrowing, after. If the function is supplied, it is called with a context object once per call to create a temporary advice object, which is destroyed after the processing. The temporary advice object can implement a destroy() method, if it wants to be called when not needed.
   */
  zca.advise2 = function(obj,method,advice){
    var methods = [];
    
    if(typeof obj != "object") obj = obj.prototype;
    if(!(method instanceof Array)) method = [method];
    
    // identify advised methods
    for(var j = 0; j < method.length; ++j){
      var t = method[j];
      if(t instanceof RegExp){
        for(var i in obj){
          if(zct.isFunction(obj[i]) && t.test(i)){
            methods.push(i);
          }
        }
      }else{
        if(zct.isFunction(obj[t])) methods.push(t);
      }
    }
  
    if(!yl.isArray(advice)) advice = [advice];
    return zca.adviseRaw(obj, methods, advice);
  };
  
}());

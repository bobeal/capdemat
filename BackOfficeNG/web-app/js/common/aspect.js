zenexity.capdemat.tools.namespace('zenexity.capdemat.aspect');

(function(){

  var zct = zenexity.capdemat.tools;
  var zca = zenexity.capdemat.aspect;
  
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

  /**
   * @description Attachs AOP-style advices to a method. Can be used with classes(must idicate scope) and with local functions(no scope needed).
   * @namespace zenexity.capdemat.aspect
   * @method advise
   * 
   * @param method {Array|RegExp|Function|String} Method/List of methods to be advised, in case of RegExp all methods of obj matching the regular expression are advised
   * @param advice {Object|Array} Advice class examplar(s), which define(s) advise behavior.
   * @param scope {Object} Scope object, is optional
   * @return If no scope supplied - method/array of method with attached advices, otherwise nothing
   */
  zca.advise = function(method,advice,scope) {
    var part = typeof scope != 'undefined' ? 'With' : 'WithNo';
    if(!(method instanceof Array)) method = [method];
    if(!(advice instanceof Array)) advice = [advice];
    
    return zca[['_proceed',part,'Scope'].join('')].apply(zca,[method,advice,scope]);
  };
  
  zca._proceedWithNoScope = function(method,advices) {
    var res = [];
    var b = zct.grep(advices,function(n){return n.type == "before" && !!n['isAdvice'];});
    var bs = zct.grep(advices,function(n){return n.type == 'beforeSuccess' && !!n['isAdvice'];});
    var ar = zct.grep(advices,function(n){return n.type == 'afterReturn';});
    var at = zct.grep(advices,function(n){return n.type == 'afterThrow';});
    var methods = zct.grep(method,function(n){return zct.isFunction(n);});
    
    zct.each(methods,function(i){
      var current = methods[i];
      
      var m1 = function() {
        var result = undefined;
        if(zca._callBeforeSuccess(bs,zct.makeArray(arguments))){
          zca._callBasic(b,zct.makeArray(arguments));
          try {
            result = current.apply(this,zct.makeArray(arguments));
          }catch(ex) {
            zca._callBasic(at,zct.merge(zct.makeArray(arguments),zct.makeArray(ex)||[]));
          }finally {
            zca._callBasic(ar,zct.merge(zct.makeArray(arguments),zct.makeArray(result)||[]));
          }
        }
        return result;
      };
      res.push(m1);
    });
    
    if(res.length == 1) return res[0];
    else return res;
  };
  
  zca._proceedWithScope = function(method,advices,scope) {
    var methods = [];
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
        return result;
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
  
}());

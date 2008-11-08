(function() {

  var zctc = zenexity.capdemat.tools.cascade;
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var yus = YAHOO.util.Selector;
  var yue = YAHOO.util.Event;
  var yuc = YAHOO.util.Connect;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;


  /**
   * @description Provides advanced support for firebug-lite console.
   * @author vba@zenexity.fr
   */
  zcc.debug = {
    injectFirebug : function(name,scope) {
      var src = 'http://getfirebug.com/releases/lite/1.2/firebug-lite-compressed.js';
      var head = document.getElementsByTagName("head")[0];
      var scripts = zct.grep(yud.getChildren(head),function(n){
        return(n['src']==src);
      });

      if(scripts.length == 0) {
        var newscript = document.createElement('script');
        newscript.type = 'text/javascript';
        newscript.src = src;

        newscript.onload = newscript.onreadystatechange = function(){
          if (!this.readyState || this.readyState == "loaded" || this.readyState == "complete") {
            firebug.init();
            zcc.debug.initXHR();
            firebug.d.console[name](scope);
            zcc.debug.loading = false;
          }
        };

        head.appendChild(newscript);
      }
      return undefined;
    },
    initXHR : function() {
      if(!!firebug && !yuc.oldAsyncRequest) {
        yuc.oldAsyncRequest = yuc.asyncRequest;

        yuc.asyncRequest = function(method, uri, callback, postData) {
          var log = {
            'method' : method,
            'uri' : uri,
            'callback' : callback,
            'postData' : postData
          };
          var local = {
            success : callback.success,
            failure :  callback.faulure
          };

          zct.each(local,function(k,v){
            callback[k] = function(o) {
              if(zct.isFunction(v))v(o);
              log.status = o.status;
              log.statusText = o.statusText;
              log.response = o.responseText;
              zcc.debug.log(log);
            }
          });

          var res = yuc.oldAsyncRequest(method, uri, callback, postData);
          return res;
        }
      }
    }
  }

  zct.each(['log','print','dir'],function(i,name){
    zcc.debug[name] = function(o) {
      if(!o)o=o+'';
      if(typeof firebug == 'undefined') zcc.debug.injectFirebug(name,o);
      else firebug.d.console[name](o);
    }
  });

}());
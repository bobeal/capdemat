/**
 * Partially inspired by jQuery and partially based on jQuery syntactic sugar.
 *
 * @author vba@zenexity.fr
 * 
 **/
(function() {
	
  zenexity = { capdemat : {tools : {}}};
  
	var userAgent = navigator.userAgent.toLowerCase();
	var s = YAHOO.util.Selector;
	var zct = zenexity.capdemat.tools;
	
	zct.ajaxError = function(o) {
		throw(o.statusText);
	};
	
	zct.browser = {
		version: (userAgent.match( /.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ) || [])[1],
		safari: /webkit/.test( userAgent ),
		opera: /opera/.test( userAgent ),
		msie: /msie/.test( userAgent ) && !/opera/.test( userAgent ),
		mozilla: /mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )
	};
	
	zct.namespace = function () {
		var a=arguments, o=null, i, j, d;
		for (i=0; i<a .length; i=i+1) {
			d=a[i].split(".");
			o=window;
			for (j=0; j<d.length; j=j+1) {
				o[d[j]]=o[d[j]] || {};
				o=o[d[j]];
			}
		}
		return o;
	};
	
	zct.each = function(object, callback, args ) {
		var name, i = 0, length = object.length;
		if ( args ) {
			if ( length == undefined ) {
				for ( name in object )
					if ( callback.apply( object[ name ], args ) === false )
						break;
			} else
				for ( ; i < length; )
					if ( callback.apply( object[ i++ ], args ) === false )
						break;
		} else {
			if ( length == undefined ) {
				for ( name in object )
					if ( callback.call( object[ name ], name, object[ name ] ) === false )
						break;
			} else
				for ( var value = object[0];
					i < length && callback.call( value, i, value ) !== false; value = object[++i] ){}
		}
		return object;
	};
	
	zct.grep = function( elems, callback, inv ) {
		var ret = [];
		for ( var i = 0, length = elems.length; i < length; i++ )
			if ( !inv != !callback( elems[ i ], i ) )
				ret.push( elems[ i ] );
		return ret;
	};
	
	zct.map = function( elems, callback ) {
		var ret = [];
		for ( var i = 0, length = elems.length; i < length; i++ ) {
			var value = callback( elems[ i ], i );
			if ( value != null )
				ret[ ret.length ] = value;
		}
		return ret.concat.apply( [], ret );
	};
	
	zct.nodeName = function( elem, name ) {
		return elem.nodeName && elem.nodeName.toUpperCase() == name.toUpperCase();
	};
	
	zct.makeArray = function( array ) {
		var ret = [];
		if( array != null ){
			var i = array.length;
			if( i == null || array.split || array.setInterval || array.call )
				ret[0] = array;
			else
				while( i )
					ret[--i] = array[i];
		}
		return ret;
	}
	
	zct.merge =  function( first, second ) {
		var browser = zct.browser;
		var i = 0, elem, pos = first.length;
		
		if ( browser.msie ) {
			while ( elem = second[ i++ ] )
				if ( elem.nodeType != 8 )
					first[ pos++ ] = elem;

		} else
			while ( elem = second[ i++ ] )
				first[ pos++ ] = elem;
		return first;
	};
	
	zct.inArray = function( elem, array ) {
		for ( var i = 0, length = array.length; i < length; i++ )
			if ( array[ i ] === elem )
				return i;
		return -1;
	};
	
	zct.swap =  function( elem, options, callback ) {
		var old = {};
		for ( var name in options ) {
			old[ name ] = elem.style[ name ];
			elem.style[ name ] = options[ name ];
		}
		callback.call( elem );
		for ( var name in options )
			elem.style[ name ] = old[ name ];
	};
		
	zct.isFunction = function( fn ) {
		return !!fn && typeof fn != "string" && !fn.nodeName &&
			fn.constructor != Array && /^[\s[]?function/.test( fn + "" );
	};
	
	zct.param = function(a) {
		var s = [];
		var c = zct.grep(a,function(n){
			return (!!n['name'] && typeof n['value'] != 'undefined');
		});
		if ( a.constructor == Array && c.length > 0)
			zct.each(c, function(){
				s.push( encodeURIComponent(this.name) + "=" + encodeURIComponent( this.value ) );
			});
		else
			for ( var j in a ) {
				if ( a[j] && a[j].constructor == Array )
					zct.each( a[j], function(){
						s.push( encodeURIComponent(j) + "=" + encodeURIComponent( this ) );
					});
				else
					s.push( encodeURIComponent(j) + "=" + encodeURIComponent( zct.isFunction(a[j]) ? a[j]() : a[j] ) );
			}
		return s.join("&").replace(/%20/g, "+");
	};
	
	zct.serializeArray = function(nodeId) {
		var node = s.query('#'+nodeId)[0];
		var a = [], n = [];
		if(zct.nodeName(node,'form')) a = node.elements;
		else a = s.query('#'+nodeId+' *');
		
		n = zct.grep(a,function(o){
			return o.name && !o.disabled &&
				(o.checked ||
					/select|textarea/i.test(o.nodeName) ||
					/text|hidden|password/i.test(o.type)
				);
		});
		
		n = zct.map(n,function(elem,i){
			var val = zct.val(elem);
			return val == null ? null :
				val.constructor == Array ?
					zct.map( val, function(val, i){
						return {name: elem.name, value: val};
					}) :
					{name: elem.name, value: val};
		});
		return zct.makeArray(n);
	};
	
	zct.serialize = function(nodeId) {
		return zct.param(zct.serializeArray(nodeId));
	};
	
	zct.val = function( element, value ) {
		if ( value == undefined ) {
			if ( !!element ) {
				if ( zct.nodeName( element, "select" ) ) {
					var index = element.selectedIndex,
						values = [],
						options = element.options,
						one = element.type == "select-one";
					if ( index < 0 )
						return null;
					for ( var i = one ? index : 0, max = one ? index + 1 : options.length; i < max; i++ ) {
						var option = options[ i ];
						if ( option.selected ) {
							value = zct.browser.msie && !option.attributes.value.specified ? option.text : option.value;
							if ( one )
								return value;
							values.push( value );
						}
					}
					return values;
				} else
					return (element.value || "").replace(/\r/g, "");
			}
			return undefined;
		}
		if( value.constructor == Number ) value += '';
		return (function(){
			if ( element.nodeType != 1 ) return;
			if ( value.constructor == Array && /radio|checkbox/.test( element.type ) )
				element.checked = (zct.inArray(element.value, value) >= 0 ||
					zct.inArray(element.name, value) >= 0);
			else if ( zct.nodeName( element, "select" ) ) {
				var values = zct.makeArray(value);
				var options = s.filter(element,"option");
				zct.each(options,function(i){
					this.selected = (zct.inArray( this.value, values ) >= 0 ||
						zct.inArray( this.text, values ) >= 0);
				});
				if ( !values.length )
					element.selectedIndex = -1;
			} else
				this.value = value;
		})();
	};
	
	/**
	 * Sends data to the server side via post request, in async mode 
	 * 
	 * @author vba@zenexity.fr
	 * @param url {string} The URL of the page to load.
	 * @param data {string} Key/value pairs that will be sent to the server.
	 * @param callback {function} A function to be executed whenever the data is loaded successfully.
   *
	**/
	zct.post = function(url, data, callback) {
		var hanlers = {
			success:callback,
			failure: zct.ajaxError
		};
		
		YAHOO.util.Connect.asyncRequest('POST', url, hanlers, data);
	};
	
	zct.each([ "Height", "Width" ], function(i, name){
		var type = name.toLowerCase();
		var browser = zct.browser;
		zct[ type ] = function(element ,size) {
			var el = new YAHOO.util.Element(element);
			
			return element == window ?
				browser.opera && document.body[ "client" + name ] ||
				browser.safari && window[ "inner" + name ] ||
				document.compatMode == "CSS1Compat" && document.documentElement[ "client" + name ] ||
				document.body[ "client" + name ] :
				element == document ?
					Math.max(
						Math.max(document.body["scroll" + name], document.documentElement["scroll" + name]),
						Math.max(document.body["offset" + name], document.documentElement["offset" + name])
					) :
					size == undefined ? parseInt(el.getStyle(type)) :
						(el.setStyle(type,size.constructor == String ? size : size + "px"));
		};
	});
	
}());

/*
 * Jiro Iwamoto. <jirokun@no spam@gmail.com>
 * http://d.hatena.ne.jp/sukesam
 * 
 * The MIT License
 * --------
 * Copyright (c) 2007 Jiro Iwamoto.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

var JSONP = function JSONP(url, options) {
	this.options = {callbackParamName: 'callback'};
	for (var prop in options) this.options[prop] = options[prop];
	this.options= options;
	this.url = url;
	this.head = document.getElementsByTagName('head')[0];

	var _this = this;
	this.request();
	this.timer = setTimeout(function() {_this.timeoutHandler();}, options.timeout || 30000);
}

JSONP.sequence = 0;
JSONP.prototype = {
	constructor: JSONP,

	request: function() {
		var url;
		var script = this.script = document.createElement('script');
		var options = this.options;
		var _this = this;
		this.currentCallbackName = "callback_" + JSONP.sequence++;

		var parameters = (this.options.callbackParamName || "callback") + '=JSONP.' + this.currentCallbackName + '&' + this.composeParams();

		if (this.url.indexOf('?') > -1) url = this.url + '&' + parameters;
		else url = this.url + '?' + parameters;

		JSONP[this.currentCallbackName] = function(json) {
			clearTimeout(_this.timer);
			_this.head.removeChild(script);
			delete JSONP[_this.currentCallbackName];
			if (options.onSuccess) options.onSuccess.call(_this, json);
		};
		script.setAttribute('src', url);
		script.setAttribute('type', 'text/javascript');
		this.head.appendChild(script);
	},

	timeoutHandler: function() {
		if (JSONP[this.currentCallbackName]) {
			JSONP[this.currentCallbackName] = this.nop;
			this.head.removeChild(this.script);
		}
		if(this.options.onFailure) this.options.onFailure();
	},

	nop: function() {
	},

	composeParams: function() {
		var ret = '';
		var params = this.options.params;
		var tmpArray = [];
		for (var key in params) {
			tmpArray.push(encodeURIComponent(key) + "=" + encodeURIComponent(params[key]));
		}
		return tmpArray.join('&');
	}
}
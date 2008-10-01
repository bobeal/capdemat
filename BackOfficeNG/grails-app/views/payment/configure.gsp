
<html>
  <head>
    <title><g:message code="payment.header.paymentConfiguration" /></title>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="${createLinkTo(dir:'css/yui/editor',file:'simpleeditor.css')}" />
		<link rel="stylesheet" href="${createLinkTo(dir:'css',file:'configuration.css')}" />
    <script type="text/javascript" src="${createLinkTo(dir:'js/yui/editor',file:'simpleeditor-beta.js')}"></script>
    <script type="text/javascript">
		
			zenexity.tools.namespace("zenexity.bong.payment");
			
			zenexity.tools.ajaxError = function(o) {
				displayResponseResult('unexpectedError',o.statusText);
			};
			
			zenexity.bong.payment.Config = function() {
				var s = YAHOO.util.Selector;
				var t = zenexity.tools;
				
				var initButtons = function() {
					var buttons = s.query('input[id^=submit]');
					t.each(buttons,function(i){
						var o = new YAHOO.widget.Button(this);
						o.on('click',function(e){
							zenexity.bong.payment.Config.editor.saveHTML();
							var form = s.query('#form1')[0];
							
							t.post(form['action'],t.serialize(form['id']),function(r){
								var json = YAHOO.lang.JSON.parse(r.responseText);
								displayResponseResult('success',json.success_msg);
								return false;
							});
						})
					});
				};
				var getToolbar = function() {
					return {
						titlebar: "Text editor",
						buttons: [
							{
								group: 'textstyle', label: 'Font name & size',
								buttons: [
									{ type: 'select', label: 'Arial', value: 'fontname', disabled: true,
										menu: [
											{ text: 'Arial', checked: true },
											{ text: 'Arial Black' },
											{ text: 'Comic Sans MS' },
											{ text: 'Courier New' },
											{ text: 'Lucida Console' },
											{ text: 'Tahoma' },
											{ text: 'Times New Roman' },
											{ text: 'Trebuchet MS' },
											{ text: 'Verdana' }
										]},
									{ type: 'spin', label: '13', value: 'fontsize', range: [ 9, 75 ], disabled: true },
									{ type: 'separator' }
									]
							},
							{
								group: 'textstyle', label: 'Font style',
								buttons: [
									{ type: 'push', label: 'Bold', value: 'bold' },
									{ type: 'push', label: 'Italic', value: 'italic' },
									{ type: 'push', label: 'Underline', value: 'underline' },
									{ type: 'separator' }
								]
							},
							{
								group: 'textstyle', label: 'Colors',
								buttons: [
									{ type: 'color', label: 'Font Color', value: 'forecolor', disabled: true },
									{ type: 'color', label: 'Background Color', value: 'backcolor', disabled: true },
									{ type: 'separator' }
								]
							},
							{
								group: 'textstyle', label: 'Lists',
								buttons: [
									{ type: 'push', label: 'Ordered list', value: 'insertorderedlist' },
									{ type: 'push', label: 'Unordered list', value: 'insertunorderedlist' }                  
								]
							}
						]
					}
				};
				return {
					editor : undefined,
					init : function() {
						var conf = zenexity.bong.payment.Config;
						var ta = s.query('textarea[id=editor]')[0];
						
						conf.editor = new YAHOO.widget.SimpleEditor('editor', {
							focusAtStart: true,
							toolbar : getToolbar(),
							width: t.width(ta.parentNode)+'px',
							height : '400px'
						});
						conf.editor.render();
						initButtons();
					}
				}
			}();
			
			(function(config) {
				YAHOO.util.Event.onDOMReady(config.init);
				return false;
			})(zenexity.bong.payment.Config);
    </script>
  </head>
  <body>
    
    <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>Payment configuration</h1>
        </div>
			<form method="post" id="form1" action="configure" class="editorForm">
				<textarea id="editor" name="editor">${editorContent}</textarea>
				<input type="button" id="submit" name="submitEditor" value="Save">
			</form>
      </div>
    </div>
    
    <!-- filters and sorters -->
    <div id="narrow" class="yui-b">
    
      <div class="nobox">
        <h3><g:message code="header.sortBy" /></h3>
        <div class="body">
        </div>
      </div>
      
      <div class="nobox">
        <h3><g:message code="header.filterBy" /></h3>
        <div class="body">
        </div>
      </div>
      
    </div>    
  </body>
</html>

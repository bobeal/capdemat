
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.editor.toolbars');

(function() {
  
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  zcbet.def = {
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
          { type: 'push', label: 'Unordered list', value: 'insertunorderedlist' },
          { type: 'separator' }
        ]
      }
    ]
  };
}());
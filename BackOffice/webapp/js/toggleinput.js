//
// Cartevaloise 
//
// Copyright (C) 2004 Conseil Général du Val d'Oise. All Rights
// Reserved.
//
// Developed by René le Clercq
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License as
// published by the Free Software Foundation; either version 2 of the
// License, or (at your option) any later version.
// 
// This program is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// General Public License for more details.
// 
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
// 02111-1307, USA.

d = window.document;

oldHtml = null;

var selection = null;

function toggleText(id) {
	elem = d.getElementById(id);
	if (oldHtml != null) {
		v = elem.firstChild.value;
		elem.innerHTML = v;

		with(elem.style) {
			color = '#ff0000';
		}
		oldHtml = null;
	}
}

function getSelect(type) {
	if (selection == null)
		selection = new selectionData();

	return selection[type];
}

function toggleInput(id, selection, style, action, form, dynavalues) {
	elem = d.getElementById(id);
	if (oldHtml == null) {
		oldHtml = elem.innerHTML;
		oldHtml = oldHtml.replace(/<wbr>/,"");
		oldHtml = oldHtml.replace(/<WBR>/,"");
		
		htmlForm =
			'<form name="' + form + '" mode="post" class="nomargin" action="' + action + '" > ' +
			'<input type=hidden name="field" value="' + id + '">';
		
		select = getSelect(selection);
		if (select == null) {
			htmlInput =
				'<input class="'
					+ style
					+ '" type=text name="'
					+ id
					+ '" value="'
					+ oldHtml
					+ '" >'
		} else {
			multiple = '';

			selvalues = select("values");
			
			if ((selvalues.length == 0) && (dynavalues != null))
				selvalues = dynavalues;
			
			if (select("multiple"))
				multiple = ' MULTIPLE size="'+ selvalues.length + '"';

			htmlInput = '<select class="'+style + '" name="'+id + '"' + multiple + '>';

			for (var i = 0; i < selvalues.length; i++) {
				selected = '';
				if (oldHtml.indexOf(selvalues[i]) != -1)
					selected = 'selected';

				htmlInput =
					htmlInput
						+ '<option value="'
						+ selvalues[i]
						+ '" '
						+ selected
						+ '>'
						+ selvalues[i]
						+ '</option>';
			}

			htmlInput = htmlInput + '</select>';
		}
		newHtml =
			htmlForm + htmlInput + '<input class="'+style + '"type=submit value="ok" > ';newHtml = newHtml + '</form>';
		elem.innerHTML = newHtml;
	}
}

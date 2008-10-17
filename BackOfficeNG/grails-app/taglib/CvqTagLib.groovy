import java.util.StringTokenizer;

class CvqTagLib {
	static namespace = "cvq"
	
	//CVQ TAG CONSTANTES
	def YESNO_TAG_END = "</yesno>"
	def RADIO_TAG_END = "</radio>"
	def CHECKBOX_TAG_END = "</checkbox>"
	def OPTION_TAG_END = "</option>"
	
	// HTML TAG CONSTANTES
	def SELECT_TAG_END = "</select>"

	
	// CVQ TAGS
	def outputText = { attrs, body ->
		out << attrs.value
	}
	
	def label = { attrs, body ->
		out << '<label for="' + attrs.for + '">'
		out <<	'<strong>' + attrs.value + '</strong>'
		out <<	'</label>'
	}
	
	def text = { attrs, body ->
		def value = ""
		if (attrs.value != null) { value = attrs.value }			
		if (attrs.rows != null){
			int rows = Math.abs(Integer.valueOf( attrs["rows"] ))
			if (rows > 1) {
				out << '<textarea id="' + attrs.name +'" '
				out	<< 'name="' +  attrs.name +'" '
				out	<< 'rows="' +  rows +'" '
				if (attrs.minlength != null) out << 'minlength="' + attrs.minlength + '" '
				if (attrs.regex != null) out << 'regex="' + attrs.regex + '" '
				//out << 'cols="41" '
				if (attrs.class != null) out << ' class="' + attrs.class 
				if (attrs.isCondition != null) out << ' condition-' + attrs.name
				out << ' " '
				if (attrs.title != null) out << ' title="' + attrs.title +'" '
				out	<< '> ' + value +'\n</textarea>'			
			} else {
				out << '<input type="text" ' 				out	<< 'name="' +  attrs.name +'" '
				if (attrs.class != null) out << ' class="' + attrs.class
				if (attrs.isCondition != null) out << ' condition-' + attrs.name
				out << ' " '
				if (attrs.title != null) out << ' title="' + attrs.title +'" '
				if (attrs.minlength != null) out << 'minlength="' + attrs.minlength + '" '
				if (attrs.regex != null) out << 'regex="' + attrs.regex + '" '
				out << 'value="' + value + '"/>'
			}
		} else {
			out << '<input type="text" ' 			out	<< 'name="' +  attrs.name +'" '
			if (attrs.class != null) out << ' class="' + attrs.class
			if (attrs.isCondition != null) out << ' condition-' + attrs.name
			out << ' " '
			if (attrs.title != null) out << ' title="' + attrs.title +'" '
			if (attrs.minlength != null) out << 'minlength="' + attrs.minlength + '" '
			if (attrs.regex != null) out << 'regex="' + attrs.regex + '" '
			out << 'value="' + value + '"/>'
		}
	}
	
	def select = { attrs, body ->
		out << '<select name="'+ attrs.name +'" '
		if (attrs.mode.equals("static")) out << ' disabled="true" ' 
		if (attrs.class != null) out << ' class="' + attrs.class
		if (attrs.isCondition != null) out << ' condition-' + attrs.name
		out << ' " '
		if (attrs.title != null) out << ' title="' + attrs.title +'" '
		out << ' >'
		String[] options = body.call().split(OPTION_TAG_END);
		options.each {
			if (it.indexOf(">") != -1){
				def option = it.substring(0, it.indexOf(">"))
				def value = it.substring(it.indexOf(">"), it.length())
				out << option
				if (option.contains('"' + attrs.selected + '"')) out << ' selected="true" '
				out << value + OPTION_TAG_END
			}	
		}
		out << SELECT_TAG_END
	} 
	
	def calendar = { attrs, body ->
		out << '<input type="text" name="' + attrs.name + '" '
		out << 'id="' + attrs.name + '" '
		if (attrs.value != null) out << 'value="' + attrs.value + '" '
		if (attrs.class != null) out << ' class="' + attrs.class 
		if (attrs.isCondition != null) out << ' condition-' + attrs.name
		out << '" '
		if (attrs.title != null) out << ' title="' + attrs.title +'" '
		out << ' />'
		out << '<a onClick="showCalendar(\'' + attrs.name + 'Show\', ' + attrs.index + ');">'
		out << '<img id="' +attrs.name + 'Show" src="/BackOfficeNG/css/yui/calendar/calendar.gif"/>'
		out << '</a>'
		out << '<div id="' + attrs.name + 'CalContainer" class="yui-cal"></div>'
	}
		
	def yesno = { attrs, body ->
		createYesno(attrs.name, attrs.mode, attrs.checked, attrs.class, attrs.title, attrs.isCondition)
	}
	
	def radioList = { attrs, body ->
		createRadioList(attrs, body.call().split(RADIO_TAG_END))
	}
	
	def yesnoList = { attrs, body ->
		def VALUE_ATTRIBUTE = "value=\"";
		def TITLE_ATTRIBUTE = "title=\"";
		def CLASS_ATTRIBUTE = "class=\"";
		def name = ""
		def clazz = ""
		def title = ""
		String[] yesnos = body.call().split(YESNO_TAG_END)
		out << '<ul>'
		yesnos.each {
			if (it.indexOf(">") != -1){
				def yesno = it.substring(0, it.indexOf(">"))

				if (yesno.indexOf(VALUE_ATTRIBUTE) != -1 ) {
					 name = yesno.substring(yesno.indexOf(VALUE_ATTRIBUTE) + VALUE_ATTRIBUTE.length(), yesno.length())
					 name = name.substring(0, name.indexOf("\""))
				}
				if (yesno.indexOf(CLASS_ATTRIBUTE) != -1 ) {
					 clazz = yesno.substring(yesno.indexOf(CLASS_ATTRIBUTE) + CLASS_ATTRIBUTE.length(), yesno.length())
					 clazz = clazz.substring(0, clazz.indexOf("\""))
				}
				if (yesno.indexOf(TITLE_ATTRIBUTE) != -1 ) {
					 title = yesno.substring(yesno.indexOf(TITLE_ATTRIBUTE) + TITLE_ATTRIBUTE.length(), yesno.length())
					 title = title.substring(0, title.indexOf("\""))
				}
				def label = it.substring(it.indexOf(">") + 1, it.length())
				out << '<li style="display:inline;">'
				out << '<strong>' + label + '</strong>'
				out << '</li>'
				createYesno(name, attrs.mode, attrs.checked, clazz, title, attrs.isCondition)
			}
		}
		out << '</ul>'
	}
	
	def checkList = { attrs, body ->
		def VALUE_ATTRIBUTE = "value=\"";
		def name = ""
		String[] checkboxes = body.call().split(CHECKBOX_TAG_END)
		out << '<ul>'
		boolean first = true;
		checkboxes.each {
			if (it.indexOf(">") != -1){
				def checkbox = it.substring(0, it.indexOf("\">"))
				if (checkbox.indexOf(VALUE_ATTRIBUTE) != -1 )
					 name = checkbox.substring(checkbox.indexOf("value=\"") + VALUE_ATTRIBUTE.length(), checkbox.length())
				def label = it.substring(it.indexOf(">") + 1, it.length())
				createCheckBox(name, label, attrs.mode, attrs.class, attrs.title, first)
				first = false
			}
		}
		out << '</ul>'
	}
	
	def createRadioList = { attrs, radios ->
		out << '<ul>'
		int i = 0;
		radios.each {
			if (it.indexOf(">") != -1){
				def radio = it.substring(0, it.indexOf(">"))
				def value = it.substring(it.indexOf(">") + 1, it.length())
				out << '<li'
				if (attrs.mode != null && attrs.mode.equalsIgnoreCase("inline")) out << ' style="display:inline;"'
				out << '>'
				out << '<input type="radio" '
				out << 'name="' + attrs.name + '" '
				if (i == 0) {
					if (attrs.class != null) out << ' class="' + attrs.class +'" '
					if (attrs.title != null) out << ' title="' + attrs.title +'" '
					i = 1
				}
				if (radio.contains('"' + attrs.checked + '"')) out << ' checked="true" '
				out << ' />' + value
				out << '</li>'
			}
		}
		out << '</ul>'
	}
	
	def createYesno = { name, mode, checked, clazz, title, isCondition   ->
	    out << '<ul id="' + name + '" >'
		out << '<li'
		if (mode != null && mode.equalsIgnoreCase("inline")) out << ' style="display:inline;"'
		out << '>'
		out << '<input type="radio" '
		out << 'name="' + name + '" '
		out << 'value="true" '
		if (checked == true) out << ' checked="true" '
		if (clazz != null) out << ' class="' + clazz
		if (isCondition != null) out << ' condition-' + name
		out << ' " '
		if (title != null) out << ' title="' + title +'" '
		out << ' />' + message(code:"taglib.yes") + '</li>'
		out << '<li'
		if (mode != null && mode.equalsIgnoreCase("inline")) out << ' style="display:inline;"'
		out << '>'
		out << '<input type="radio" '
		out << 'name="' + name + '" '
		out << 'value="false" '
		if (isCondition != null) out << ' class="condition-' + name +'" '
		if (checked == false) out << ' checked="true" '
		out << ' />' + message(code:"taglib.no") +'</li>'
		out << '</ul>'	
	}
	
	def createCheckBox = { name, label, mode, clazz, title, first ->
		out << '<li'
		if (mode != null && mode.equalsIgnoreCase("inline")) out << ' style="display:inline;"'
		out << '>'
		out << '<input type="checkbox" '
		out << 'name="' + name + '" '
		out << 'value="' + name + '" '
		if (first == true) {
			if (clazz != null) out << ' class="' + clazz +'" '
			if (title != null) out << ' title="' + title +'" '
		}
		out << '/>'
		out << '<label '
		out << 'for="' + name + '" '
		out << '>'
		out << label + '</label>'
		out << '</li>'
	}}

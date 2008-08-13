/* 
	calendar-cs-win.js
	language: Czech
	encoding: windows-1250
	author: Lubos Jerabek (xnet@seznam.cz)
	        Jan Uhlir (espinosa@centrum.cz)
*/

// ** I18N
Calendar._DN  = new Array('Nedle','Pondl','ter','Steda','tvrtek','Ptek','Sobota','Nedle');
Calendar._SDN = new Array('Ne','Po','t','St','t','P','So','Ne');
Calendar._MN  = new Array('Leden','nor','Bezen','Duben','Kvten','erven','ervenec','Srpen','Z','jen','Listopad','Prosinec');
Calendar._SMN = new Array('Led','no','Be','Dub','Kv','rv','vc','Srp','Z','j','Lis','Pro');

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "O komponent kalend";
Calendar._TT["TOGGLE"] = "Zmna prvnho dne v tdnu";
Calendar._TT["PREV_YEAR"] = "Pedchoz rok (pidr pro menu)";
Calendar._TT["PREV_MONTH"] = "Pedchoz msc (pidr pro menu)";
Calendar._TT["GO_TODAY"] = "Dnen datum";
Calendar._TT["NEXT_MONTH"] = "Dal msc (pidr pro menu)";
Calendar._TT["NEXT_YEAR"] = "Dal rok (pidr pro menu)";
Calendar._TT["SEL_DATE"] = "Vyber datum";
Calendar._TT["DRAG_TO_MOVE"] = "Chy a thni, pro pesun";
Calendar._TT["PART_TODAY"] = " (dnes)";
Calendar._TT["MON_FIRST"] = "Uka jako prvn Pondl";
//Calendar._TT["SUN_FIRST"] = "Uka jako prvn Nedli";

Calendar._TT["ABOUT"] =
"DHTML Date/Time Selector\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"For latest version visit: http://www.dynarch.com/projects/calendar/\n" +
"Distributed under GNU LGPL.  See http://gnu.org/licenses/lgpl.html for details." +
"\n\n" +
"Vbr datumu:\n" +
"- Use the \xab, \xbb buttons to select year\n" +
"- Pouijte tlatka " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " k vbru msce\n" +
"- Podrte tlatko myi na jakmkoliv z tch tlatek pro rychlej vbr.";

Calendar._TT["ABOUT_TIME"] = "\n\n" +
"Vbr asu:\n" +
"- Kliknte na jakoukoliv z st vbru asu pro zven.\n" +
"- nebo Shift-click pro snen\n" +
"- nebo kliknte a thnte pro rychlej vbr.";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "Zobraz %s prvn";

// This may be locale-dependent.  It specifies the week-end days, as an array
// of comma-separated numbers.  The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "Zavt";
Calendar._TT["TODAY"] = "Dnes";
Calendar._TT["TIME_PART"] = "(Shift-)Klikni nebo thni pro zmnu hodnoty";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "d.m.yy";
Calendar._TT["TT_DATE_FORMAT"] = "%a, %b %e";

Calendar._TT["WK"] = "wk";
Calendar._TT["TIME"] = "as:";

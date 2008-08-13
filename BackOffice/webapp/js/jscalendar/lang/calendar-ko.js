// ** I18N

// Calendar EN language
// Author: Mihai Bazon, <mihai_bazon@yahoo.com>
// Translation: Yourim Yi <yyi@yourim.net>
// Encoding: EUC-KR
// lang : ko
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible.  We strongly believe that
// Unicode is the answer to a real internationalized world.  Also please
// include your contact information in the header, as can be seen above.

// full day names

Calendar._DN = new Array
("ÀÏ¿äÀÏ",
 "¿ù¿äÀÏ",
 "È­¿äÀÏ",
 "Œö¿äÀÏ",
 "žñ¿äÀÏ",
 "±Ý¿äÀÏ",
 "Åä¿äÀÏ",
 "ÀÏ¿äÀÏ");

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary.  We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
//   Calendar._SDN_len = N; // short day name length
//   Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
Calendar._SDN = new Array
("ÀÏ",
 "¿ù",
 "È­",
 "Œö",
 "žñ",
 "±Ý",
 "Åä",
 "ÀÏ");

// full month names
Calendar._MN = new Array
("1¿ù",
 "2¿ù",
 "3¿ù",
 "4¿ù",
 "5¿ù",
 "6¿ù",
 "7¿ù",
 "8¿ù",
 "9¿ù",
 "10¿ù",
 "11¿ù",
 "12¿ù");

// short month names
Calendar._SMN = new Array
("1",
 "2",
 "3",
 "4",
 "5",
 "6",
 "7",
 "8",
 "9",
 "10",
 "11",
 "12");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "calendar ¿¡ ŽëÇØŒ­";

Calendar._TT["ABOUT"] =
"DHTML Date/Time Selector\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"\n"+
"ÃÖœÅ ¹öÀüÀ» ¹ÞÀžœÃ·Ážé http://www.dynarch.com/projects/calendar/ ¿¡ ¹æ¹®ÇÏŒŒ¿ä\n" +
"\n"+
"GNU LGPL ¶óÀÌŒŸœº·Î ¹èÆ÷µËŽÏŽÙ. \n"+
"¶óÀÌŒŸœº¿¡ ŽëÇÑ ÀÚŒŒÇÑ ³»¿ëÀº http://gnu.org/licenses/lgpl.html À» ÀÐÀžŒŒ¿ä." +
"\n\n" +
"³¯Â¥ Œ±ÅÃ:\n" +
"- ¿¬µµžŠ Œ±ÅÃÇÏ·Ážé \xab, \xbb ¹öÆ°À» »ç¿ëÇÕŽÏŽÙ\n" +
"- ŽÞÀ» Œ±ÅÃÇÏ·Ážé " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " ¹öÆ°À» Ž©ž£ŒŒ¿ä\n" +
"- °èŒÓ Ž©ž£°í ÀÖÀžžé À§ °ªµéÀ» ºüž£°Ô Œ±ÅÃÇÏœÇ Œö ÀÖœÀŽÏŽÙ.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"œÃ°£ Œ±ÅÃ:\n" +
"- ž¶¿ìœº·Î Ž©ž£žé œÃ°£ÀÌ Áõ°¡ÇÕŽÏŽÙ\n" +
"- Shift Å°¿Í ÇÔ²² Ž©ž£žé °šŒÒÇÕŽÏŽÙ\n" +
"- Ž©ž¥ »óÅÂ¿¡Œ­ ž¶¿ìœºžŠ ¿òÁ÷ÀÌžé Á» Žõ ºüž£°Ô °ªÀÌ º¯ÇÕŽÏŽÙ.\n";

Calendar._TT["PREV_YEAR"] = "Áö³­ ÇØ (±æ°Ô Ž©ž£žé žñ·Ï)";
Calendar._TT["PREV_MONTH"] = "Áö³­ ŽÞ (±æ°Ô Ž©ž£žé žñ·Ï)";
Calendar._TT["GO_TODAY"] = "¿ÀŽÃ ³¯Â¥·Î";
Calendar._TT["NEXT_MONTH"] = "ŽÙÀœ ŽÞ (±æ°Ô Ž©ž£žé žñ·Ï)";
Calendar._TT["NEXT_YEAR"] = "ŽÙÀœ ÇØ (±æ°Ô Ž©ž£žé žñ·Ï)";
Calendar._TT["SEL_DATE"] = "³¯Â¥žŠ Œ±ÅÃÇÏŒŒ¿ä";
Calendar._TT["DRAG_TO_MOVE"] = "ž¶¿ìœº µå·¡±×·Î ÀÌµ¿ ÇÏŒŒ¿ä";
Calendar._TT["PART_TODAY"] = " (¿ÀŽÃ)";
Calendar._TT["MON_FIRST"] = "¿ù¿äÀÏÀ» ÇÑ ÁÖÀÇ œÃÀÛ ¿äÀÏ·Î";
Calendar._TT["SUN_FIRST"] = "ÀÏ¿äÀÏÀ» ÇÑ ÁÖÀÇ œÃÀÛ ¿äÀÏ·Î";
Calendar._TT["CLOSE"] = "ŽÝ±â";
Calendar._TT["TODAY"] = "¿ÀŽÃ";
Calendar._TT["TIME_PART"] = "(Shift-)Å¬ž¯ ¶ÇŽÂ µå·¡±× ÇÏŒŒ¿ä";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%Y-%m-%d";
Calendar._TT["TT_DATE_FORMAT"] = "%b/%e [%a]";

Calendar._TT["WK"] = "ÁÖ";

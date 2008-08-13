/**
 #header="@header-color@"
 #background-color="@background-color@"
 #button="@button-color@"
 #streamer="@streamer-color@"
*/
body { 
	background-color: #fff; 
	color: @header-color@;
}

#navigation {
	color: @header-color@;
}

#navigation div.previous {
	background-color: @background-color@;
}

#navigation div.previous:hover {
	background-color: @header-color@;
	color: @background-color@;
}

#navigation div.next {
	background-color: @background-color@;
}

#navigation div.next:hover {
	background-color: @header-color@;
	color: @background-color@;
}

#navigation #stages div {
	background-color: @background-color@;
}

#navigation #stages li {
	background-color: #fff;
}

/** Navigation stage classes reflect the state of three stages: 
 *   x - no neighbour
 *   s - selected stage
 *   u - unselected stage
 *
 *  Posibilities:
 *    xuu - first stage unselected with unselected second stage 
 *    xsu - first stage selected with unselected second stage
 *    xss - first stage selected with selected second stage
 *    uuu - three stages unselected
 *    suu - previous stage selected
 *    ssu - next stage unselected
 *    sss - all three stages selected
 *    uux - last stage unselected, with previous stage unselected
 *    sux - last stage unselected, with previous stage selected
 *    ssx - last stage selected, with previous stage selected
 *
 *  For this style sheets purposes the uuu and suu, and the uux and sux posibilities are treated the same way.
 */
#navigation #stages div.xuu {
	background-color: @background-color@;
}

#navigation #stages div.xsu {
	background-color: @header-color@;
}

#navigation #stages div.xss {
	background-color: @header-color@;
}

#navigation #stages div.uuu {
	background-color: @background-color@;
}

#navigation #stages div.suu {
	background-color: @background-color@;
}

#navigation #stages div.ssu {
	background-color: @header-color@;
}

#navigation #stages div.sss {
	background-color: @header-color@;
}

#navigation #stages div.uux {
	background-color: @background-color@;
}

#navigation #stages div.sux {
	background-color: @background-color@;
}

#navigation #stages div.ssx {
	background-color: @header-color@;
}

/***** information block *****/
#information {
	color: @header-color@;
}

#information #title h1 {
	background-color: @header-color@;
	color: #354f6d;
}

#information #explanation p.help {
	background-color: @header-color@;
}

#contents {
	color: @header-color@;
}

#contents #action #body #title h1 {
	color: @header-color@;
}

#contents #action #body { 
	color: @button-color@;
}

#contents #action #body div.select {
	background-color: @background-color@;
	color: #000;
}

#contents #action #body div.select:hover {
	background-color: @button-color@;
	color: @background-color@;
}

#contents #action #body div.action {
	background-color: @background-color@;
}

#contents #action #body div.action:hover {
	background-color: @button-color@;
	color: @background-color@;
}

#contents #form #body { 
	background-color: @background-color@;
}

#contents #form #button-area div { 
	color: @button-color@;
}

#contents #form #button-area div:hover {
	background-color: @button-color@;
	color: @background-color@;
}

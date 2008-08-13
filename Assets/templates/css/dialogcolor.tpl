/**
 #header="@header-color@"
 #background-color="@background-color@"
 #button="@button-color@"
 #streamer="@streamer-color@"
*/

#banner {
        background: url(../img/banner.jpg) no-repeat;
        width: 100%;
        height: 78px;
}

#banner div.productlogo {
	display: @product-logo@;
}

#navigation div.back {
    background-color: @background-color@;
    color: @button-color@;
}

#navigation div.back:hover {
    background-color: @button-color@;
    color: @background-color@;
}

#contents #form #title h1 {
    color: @header-color@;
}

#contents #form #body { 
	background-color: @background-color@;
}

#contents #form #body div.button {
    background-color: @background-color@;
    color: @button-color@;
}

#contents #form #body div.button:hover {
    background-color: @button-color@;
    color: @background-color@;
}


<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/tags/struts-cvq" prefix="cvq" %>
<%@ taglib uri="/cvq-wizard" prefix="cvqw" %>

<!--
<cvq:exception/>
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
	<cvqw:baseref/>
    <meta http-equiv="Content-Language" content="fr">
    <cvq:htmltitle/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
	<!--
		/* MAIN */
		* { margin: 0; padding: 0; }
		a img, a:hover img { border: none; }
		a { text-decoration: none; }
		a:hover { text-decoration: underline; }
		body {
		  text-align: center;
		  background-color: white; 
		}
		#mainframe {
		  width: 781px;
		  position: relative;
		  margin: 0 auto;
		  font: 0.7em/1em Arial, Helvetica, sans-serif;
		}
		
		/* HEADER */
		#header {
		  float: left;
		  height: 110px;
		  width: 768px;
		}
		#logo {
		  float: left;
		  height: 110px;
		  width: 88px;
		  display:none;
		}
		#logo a {
		  display: block;
		  height: 100%;
		  width: 100%;
		}
		#logo img {
		  margin-top: 25px;
		  margin-left: 8px;
		}
		#banner {
		  float: left;
		  height: 110px;
		  width: 680px;
		}
		
		/* FOOTER */
		#footer {
		  clear: both;
		  float: left;
		  width: 765px;
		  margin-top: 20px;
		  background: url(assets/common/css/new/img/footer_border.gif) repeat-x left top;
		  color: #6e6e6e;
		}
		#footer ul {
		  position: relative;
		  list-style-type: none;
		}
		#footer ul li.logo {
		  display: inline;
		  margin-top: 10px;
		}
		#footer ul li.logo span.logo_img {
		  float: left;
		  display: block;
		  width: 40px;
		  margin-top: 10px;
		  text-align: center;
		}
		#footer ul li.right span.logo_img
		{
		  float: right;
		  display: none;
		}
		#footer a { color: #6e6e6e; }
		#footer a.info {
		  position: relative;
		  text-decoration: none;
		  z-index: 24;
		}
		#footer a.info span.logo_legend {
		  display: none;
		  background-color: #fff;
		}
		#footer a.info:hover {
		  background: none;
		  z-index: 25;
		}
		#footer a.info:hover span.logo_legend {
		  display: block;
		  position: absolute;
		  width: 580px;
		  text-align: center;
		  font-size: 0.8em;
		  left: 105px;
		  top: 10px;
		  padding-bottom: 20px;
		} 
		#footer ul li.legend {
		  position: absolute;
		  right: 0;
		  width: 580px;
		  text-align: center;
		  margin-top: 10px;
		}
		#footer ul li p.legend_text {
		  font-size: 0.8em;
		}
		
		/* CONTENT */
		#content {
		  clear: both;
		  float: left;
		  width: 768px;
		}
		.block_information {
		  margin: 100px 56px 100px 100px;
		  height: 160px;
		  text-align: center;
		  background: url(assets/common/css/new/img/block_info_bg.gif) no-repeat left top;
		}
		.block_information .title {
		  padding: 22px 0;
		  color: #8b2b2e;
		  font-size: 1.2em;
		  font-weight: bold;
		}
		.block_information .error_paragraph {
		  padding-bottom: 20px;
		  color: #6e6e6e;
		  font-size: 1.3em;
		}
		.block_information .link {
		  padding: 22px 0;
		  font-size: 1.2em;
		  font-weight: bold;
		}
		.block_information .link a {
		  padding: 8px 25px 8px 40px;
		  color: #8b2b2e;
		  background: #fff url(assets/common/css/new/img/link_bg.gif) no-repeat left top;
		  border: 1px solid #cdcdcd ;
		}
	-->
	</style>
	<link rel="stylesheet" type="text/css" media="screen" href="assets/common/css/new/account/colors.css" />
</head>
<body id="body">
  <div id="mainframe">
    <div id="header">
      <div id="logo"><a href="http://www.capwebct.fr" title=""><img src="img/logo_capwebct.gif" alt="" /></a></div>
      <div id="banner"><img src="assets/common/img/banner.jpg" alt="" /></div>
    </div>
    <div id="content">
      <div class="block_information">
        <p class="title">INFORMATION :</p>
        <p class="error_paragraph">Le serveur est actuellement indisponible. Veuillez ressayer ultrieurement.</p>
        <p class="link"><a href="javascript:window.history.back();" title="">RETOUR</a></p>
      </div>
    </div>
    <div id="footer">
      <ul>
        <li class="logo firstlogo"><a href="http://www.capwebct.fr" title="" class="info"><span class="logo_img"><img src="img/logo_capwebct.gif" alt="" /></span><span class="logo_legend">CapWebCT.</span></a></li>
        <li class="logo secondlogo"><a href="http://www.prai-idf.fr/public/rubrique.tpl?id=8364&titre=8364"" title="" class="info"><span class="logo_img"><img src="img/logoUE.png" alt="" /></span><span class="logo_legend">Projet cofinanc par lUnion Europenne (FEDER).</span></a></li>
        <li class="legend"><p class="legend_text"><a href="javascript:popup('assets/common/pdf/legal.pdf');" title="">Mentions lgales.</a></p></li>
        <li class="logo right"><a href="http://www.capwebct.fr" title="" class="info"><span class="logo_img"><img src="img/logo_capwebct.gif" alt="" /></span><span class="logo_legend">CapWebCT.</span></a></li>
      </ul>
    </div>
  </div>
</body>
</html>

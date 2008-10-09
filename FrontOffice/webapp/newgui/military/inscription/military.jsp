<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Inscription" action="#" >
      <fieldset class="fieldset_zone">
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectChildLastName" class="label">Nom</label>
            <cvqf:text name="subjectChildLastName" mode="disabled" maxlength="38"/>
          </li>
          <li class="text_row">
			<label for="subjectChildFirstName" class="label">Prénom</label>
            <cvqf:text name="subjectChildFirstName" mode="disabled" maxlength="38"/>
          </li>
          <li class="select_row">
			<label for="childTitle" class="label">Civilité<span class="required">*</span></label>
            <cvqf:select name="childTitle" mode="">
              <option value="">Choisissez une civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </li>
          <li class="text_row">
			<label for="maidenName" class="label">Nom d'usage</label>
            <cvqf:text name="maidenName" mode="" maxlength="38"/>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Lieu de naissance :</h3>
        <ul class="insert_list">
          <li class="text_row">
			<label for="subjectChildBirthPlaceCity" class="label">Ville<span class="required">*</span></label>
            <cvqf:text name="subjectChildBirthPlaceCity" mode="" maxlength="32"/>
          </li>
          <li class="text_row">
			<label for="subjectChildBirthPlacePostalCode" class="label">Code Postal<span class="required">*</span></label>
            <cvqf:text name="subjectChildBirthPlacePostalCode" mode="" maxlength="5"/>
          </li>
          <li class="select_row">
			<label for="childBirthCountry" class="label">Pays de naissance<span class="required">*</span></label>
            <cvqf:select name="childBirthCountry" mode="">
              <option value="">Choisissez un pays de naissance</option>
              <option value="Unknown">Inconnu</option>
              <option value="af">Afghanistan (AF)</option>
              <option value="za">Afrique du Sud (ZA)</option>
              <option value="al">Albanie (AL)</option>
              <option value="dz">Algérie(DZ)</option>
              <option value="de">Allemagne (DE)</option>
              <option value="ad">Andorre (AD)</option>
              <option value="ao">Angola (AO)</option>
              <option value="ai">Anguilla (AI)</option>
              <option value="aq">Antarctique (AQ)</option>
              <option value="ag">Antigua-et-Barbuda (AG)</option>
              <option value="an">Antilles néerlandaises (AN)</option>
              <option value="sa">Arabie saoudite (SA)</option>
              <option value="ar">Argentine (AR)</option>
              <option value="am">Arménie (AM)</option>
              <option value="aw">Aruba (AW)</option>
              <option value="au">Australie (AU)</option>
              <option value="at">Autriche (AT)</option>
              <option value="az">Azerbaïdjan (AZ)</option>
              <option value="bj">Bénin (BJ)</option>
              <option value="bs">Bahamas (BS)</option>
              <option value="bh">Bahreïn (BH)</option>
              <option value="bd">Bangladesh (BD)</option>
              <option value="bb">Barbade (BB)</option>
              <option value="pw">Belau (PW)</option>
              <option value="be">Belgique (BE)</option>
              <option value="bz">Belize (BZ)</option>
              <option value="bm">Bermudes (BM)</option>
              <option value="bt">Bhoutan (BT)</option>
              <option value="by">Biélorussie (BY)</option>
              <option value="mm">Birmanie (MM)</option>
              <option value="bo">Bolivie (BO)</option>
              <option value="ba">Bosnie-Herzégovine (BA)</option>
              <option value="bw">Botswana (BW)</option>
              <option value="br">Brésil (BR)</option>
              <option value="bn">Brunei (BN)</option>
              <option value="bg">Bulgarie (BG)</option>
              <option value="bf">Burkina Faso (BF)</option>
              <option value="bi">Burundi (BI)</option>
              <option value="ci">Côte d'Ivoire (CI)</option>
              <option value="kh">Cambodge (KH)</option>
              <option value="cm">Cameroun (CM)</option>
              <option value="ca">Canada (CA)</option>
              <option value="cv">Cap-Vert (CV)</option>
              <option value="cl">Chili (CL)</option>
              <option value="cn">Chine (CN)</option>
              <option value="cy">Chypre (CY)</option>
              <option value="co">Colombie (CO)</option>
              <option value="km">Comores (KM)</option>
              <option value="cg">Congo (CG)</option>
              <option value="kp">Corée du Nord (KP)</option>
              <option value="kr">Corée du Sud (KR)</option>
              <option value="cr">Costa Rica (CR)</option>
              <option value="hr">Croatie (HR)</option>
              <option value="cu">Cuba (CU)</option>
              <option value="dk">Danemark (DK)</option>
              <option value="dj">Djibouti (DJ)</option>
              <option value="dm">Dominique (DM)</option>
              <option value="eg">Égypte (EG)</option>
              <option value="ae">Émirats arabes unis (AE)</option>
              <option value="ec">Équateur (EC)</option>
              <option value="er">Érythrée (ER)</option>
              <option value="es">Espagne (ES)</option>
              <option value="ee">Estonie (EE)</option>
              <option value="us">États-Unis (US)</option>
              <option value="et">Éthiopie (ET)</option>
              <option value="fi">Finlande (FI)</option>
              <option value="fr">France (FR)</option>
              <option value="ge">Géorgie (GE)</option>
              <option value="ga">Gabon (GA)</option>
              <option value="gm">Gambie (GM)</option>
              <option value="gh">Ghana (GH)</option>
              <option value="gi">Gibraltar (GI)</option>
              <option value="gr">Grèce (GR)</option>
              <option value="gd">Grenade (GD)</option>
              <option value="gl">Groenland (GL)</option>
              <option value="gp">Guadeloupe (GP)</option>
              <option value="gu">Guam (GU)</option>
              <option value="gt">Guatemala (GT)</option>
              <option value="gn">Guinée (GN)</option>
              <option value="gq">Guinée équatoriale (GQ)</option>
              <option value="gw">Guinée-Bissao (GW)</option>
              <option value="gy">Guyana (GY)</option>
              <option value="gf">Guyane française (GF)</option>
              <option value="ht">Haïti (HT)</option>
              <option value="hn">Honduras (HN)</option>
              <option value="hk">Hong Kong (HK)</option>
              <option value="hu">Hongrie (HU)</option>
              <option value="ck">Iles Cook (CK)</option>
              <option value="fj">Iles Fidji (FJ)</option>
              <option value="mh">Iles Marshall (MH)</option>
              <option value="sb">Iles Salomon (SB)</option>
              <option value="in">Inde (IN)</option>
              <option value="id">Indonésie (ID)</option>
              <option value="ir">Iran (IR)</option>
              <option value="iq">Iraq (IQ)</option>
              <option value="ie">Irlande (IE)</option>
              <option value="is">Islande (IS)</option>
              <option value="il">Israël (IL)</option>
              <option value="it">Italie (IT)</option>
              <option value="jm">Jamaïque (JM)</option>
              <option value="jp">Japon (JP)</option>
              <option value="jo">Jordanie (JO)</option>
              <option value="kz">Kazakhstan (KZ)</option>
              <option value="ke">Kenya (KE)</option>
              <option value="kg">Kirghizistan (KG)</option>
              <option value="ki">Kiribati (KI)</option>
              <option value="kw">Koweït (KW)</option>
              <option value="la">Laos (LA)</option>
              <option value="ls">Lesotho (LS)</option>
              <option value="lv">Lettonie (LV)</option>
              <option value="lb">Liban (LB)</option>
              <option value="lr">Liberia (LR)</option>
              <option value="ly">Libye (LY)</option>
              <option value="li">Liechtenstein (LI)</option>
              <option value="lt">Lituanie (LT)</option>
              <option value="lu">Luxembourg (LU)</option>
              <option value="mg">Madagascar (MG)</option>
              <option value="my">Malaisie (MY)</option>
              <option value="mw">Malawi (MW)</option>
              <option value="mv">Maldives (MV)</option>
              <option value="ml">Mali (ML)</option>
              <option value="mt">Malte (MT)</option>
              <option value="ma">Maroc (MA)</option>
              <option value="mu">Maurice (MU)</option>
              <option value="mr">Mauritanie (MR)</option>
              <option value="mx">Mexique (MX)</option>
              <option value="fm">Micronésie (FM)</option>
              <option value="md">Moldavie (MD)</option>
              <option value="mc">Monaco (MC)</option>
              <option value="mn">Mongolie (MN)</option>
              <option value="mz">Mozambique (MZ)</option>
              <option value="np">Népal (NP)</option>
              <option value="na">Namibie (NA)</option>
              <option value="nr">Nauru (NR)</option>
              <option value="ni">Nicaragua (NI)</option>
              <option value="ne">Niger (NE)</option>
              <option value="ng">Nigeria (NG)</option>
              <option value="nu">Nioué (NU)</option>
              <option value="no">Norvège (NO)</option>
              <option value="nz">Nouvelle-Zélande (NZ)</option>
              <option value="om">Oman (OM)</option>
              <option value="ug">Ouganda (UG)</option>
              <option value="uz">Ouzbékistan (UZ)</option>
              <option value="pe">Pérou (PE)</option>
              <option value="pk">Pakistan (PK)</option>
              <option value="pa">Panama (PA)</option>
              <option value="pg">Papouasie-Nouvelle-Guinée (PG)</option>
              <option value="py">Paraguay (PY)</option>
              <option value="nl">Pays-Bas (NL)</option>
              <option value="ph">Philippines (PH)</option>
              <option value="pl">Pologne (PL)</option>
              <option value="pt">Portugal (PT)</option>
              <option value="qa">Qatar (QA)</option>
              <option value="cf">République centrafricaine (CF)</option>
              <option value="cd">République démocratique du Congo (CD)</option>
              <option value="do">République dominicaine (DO)</option>
              <option value="cz">République tchèque (CZ)</option>
              <option value="ro">Roumanie (RO)</option>
              <option value="gb">Royaume-Uni (GB)</option>
              <option value="ru">Russie (RU)</option>
              <option value="rw">Rwanda (RW)</option>
              <option value="sn">Sénégal (SN)</option>
              <option value="kn">Saint-Christophe-et-Niévès (KN)</option>
              <option value="sm">Saint-Marin (SM)</option>
              <option value="va">Saint-Siège (VA)</option>
              <option value="vc">Saint-Vincent-et-les-Grenadines (VC)</option>
              <option value="lc">Sainte-Lucie (LC)</option>
              <option value="sv">Salvador (SV)</option>
              <option value="ws">Samoa (WS)</option>
              <option value="st">Sao Tomé-et-Principe (ST)</option>
              <option value="sc">Seychelles (SC)</option>
              <option value="sl">Sierra Leone (SL)</option>
              <option value="sg">Singapour (SG)</option>
              <option value="si">Slovénie (SI)</option>
              <option value="sk">Slovaquie (SK)</option>
              <option value="so">Somalie (SO)</option>
              <option value="sd">Soudan (SD)</option>
              <option value="lk">Sri Lanka (LK)</option>
              <option value="se">Suède (SE)</option>
              <option value="ch">Suisse (CH)</option>
              <option value="sr">Suriname (SR)</option>
              <option value="sz">Swaziland (SZ)</option>
              <option value="sy">Syrie (SY)</option>
              <option value="tw">Taïwan (TW)</option>
              <option value="tj">Tadjikistan (TJ)</option>
              <option value="tz">Tanzanie (TZ)</option>
              <option value="td">Tchad (TD)</option>
              <option value="th">Thaïlande (TH)</option>
              <option value="tl">Timor Oriental (TL)</option>
              <option value="tg">Togo (TG)</option>
              <option value="to">Tonga (TO)</option>
              <option value="vt">Trinité-et-Tobago (VT)</option>
              <option value="tn">Tunisie (TN)</option>
              <option value="tm">Turkménistan (TM)</option>
              <option value="tr">Turquie (TR)</option>
              <option value="tv">Tuvalu (TV)</option>
              <option value="ua">Ukraine (UA)</option>
              <option value="uy">Uruguay (UY)</option>
              <option value="vu">Vanuatu (VU)</option>
              <option value="ve">Venezuela (VE)</option>
              <option value="vn">Viêt Nam (VN)</option>
              <option value="ye">Yémen (YE)</option>
              <option value="zm">Zambie (ZM)</option>
              <option value="zw">Zimbabwe (ZW)</option>
              <option value="mk">ex-République yougoslave de Macédoine (MK)</option>
            </cvqf:select>
          </li>
        </ul>
      </fieldset>
      <fieldset class="fieldset_zone">
        <h3 class="fieldset_subtitle">Lieu de résidence :</h3>
        <ul class="insert_list">
          <li class="text_row">
  			<label for="subjectChildAddressAdditionalDeliveryInformation" class="label">
				Etg. - Esc. - App.
			</label>
    		<cvqf:text name="subjectChildAddressAdditionalDeliveryInformation" mode="" maxlength="38"/>
          </li>
          <li class="text_row">
  			<label for="subjectChildAddressAdditionalGeographicalInformation" class="label">
				Imm. - Bât. - Rés.
			</label>
    		<cvqf:text name="subjectChildAddressAdditionalGeographicalInformation" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectChildAddressStreetName" class="label">
				N&deg;, libellé de la voie<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectChildAddressStreetNumber" mode="" maxlength="5"/>
    		<cvqf:text name="subjectChildAddressStreetName" mode="" maxlength="32" size="35"/>
          </li>
          <li class="text_row">
  			<label for="subjectChildAddressPlaceNameOrService" class="label">
				Lieu-dit, boite postale
			</label>
    		<cvqf:text name="subjectChildAddressPlaceNameOrService" mode="" maxlength="38"/>
          </li>
          <li class="town_row">
  			<label for="subjectChildAddressPostalCode" class="label">
				Code postal, Localité<span class="required">*</span>
			</label>
    		<cvqf:text name="subjectChildAddressPostalCode" mode="" maxlength="5" validEvents="2"/>
    		<cvqf:text name="subjectChildAddressCity" mode="" maxlength="32" size="35"/>
          </li>

          <li class="select_row">
			<label for="childResidenceCountry" class="label">Pays de résidence</label>
            <cvqf:select name="childResidenceCountry" mode="">
              <option value="">Choisissez un pays de résidence</option>
              <option value="Unknown">Inconnu</option>
              <option value="af">Afghanistan (AF)</option>
              <option value="za">Afrique du Sud (ZA)</option>
              <option value="al">Albanie (AL)</option>
              <option value="dz">Algérie(DZ)</option>
              <option value="de">Allemagne (DE)</option>
              <option value="ad">Andorre (AD)</option>
              <option value="ao">Angola (AO)</option>
              <option value="ai">Anguilla (AI)</option>
              <option value="aq">Antarctique (AQ)</option>
              <option value="ag">Antigua-et-Barbuda (AG)</option>
              <option value="an">Antilles néerlandaises (AN)</option>
              <option value="sa">Arabie saoudite (SA)</option>
              <option value="ar">Argentine (AR)</option>
              <option value="am">Arménie (AM)</option>
              <option value="aw">Aruba (AW)</option>
              <option value="au">Australie (AU)</option>
              <option value="at">Autriche (AT)</option>
              <option value="az">Azerbaïdjan (AZ)</option>
              <option value="bj">Bénin (BJ)</option>
              <option value="bs">Bahamas (BS)</option>
              <option value="bh">Bahreïn (BH)</option>
              <option value="bd">Bangladesh (BD)</option>
              <option value="bb">Barbade (BB)</option>
              <option value="pw">Belau (PW)</option>
              <option value="be">Belgique (BE)</option>
              <option value="bz">Belize (BZ)</option>
              <option value="bm">Bermudes (BM)</option>
              <option value="bt">Bhoutan (BT)</option>
              <option value="by">Biélorussie (BY)</option>
              <option value="mm">Birmanie (MM)</option>
              <option value="bo">Bolivie (BO)</option>
              <option value="ba">Bosnie-Herzégovine (BA)</option>
              <option value="bw">Botswana (BW)</option>
              <option value="br">Brésil (BR)</option>
              <option value="bn">Brunei (BN)</option>
              <option value="bg">Bulgarie (BG)</option>
              <option value="bf">Burkina Faso (BF)</option>
              <option value="bi">Burundi (BI)</option>
              <option value="ci">Côte d'Ivoire (CI)</option>
              <option value="kh">Cambodge (KH)</option>
              <option value="cm">Cameroun (CM)</option>
              <option value="ca">Canada (CA)</option>
              <option value="cv">Cap-Vert (CV)</option>
              <option value="cl">Chili (CL)</option>
              <option value="cn">Chine (CN)</option>
              <option value="cy">Chypre (CY)</option>
              <option value="co">Colombie (CO)</option>
              <option value="km">Comores (KM)</option>
              <option value="cg">Congo (CG)</option>
              <option value="kp">Corée du Nord (KP)</option>
              <option value="kr">Corée du Sud (KR)</option>
              <option value="cr">Costa Rica (CR)</option>
              <option value="hr">Croatie (HR)</option>
              <option value="cu">Cuba (CU)</option>
              <option value="dk">Danemark (DK)</option>
              <option value="dj">Djibouti (DJ)</option>
              <option value="dm">Dominique (DM)</option>
              <option value="eg">Égypte (EG)</option>
              <option value="ae">Émirats arabes unis (AE)</option>
              <option value="ec">Équateur (EC)</option>
              <option value="er">Érythrée (ER)</option>
              <option value="es">Espagne (ES)</option>
              <option value="ee">Estonie (EE)</option>
              <option value="us">États-Unis (US)</option>
              <option value="et">Éthiopie (ET)</option>
              <option value="fi">Finlande (FI)</option>
              <option value="fr">France (FR)</option>
              <option value="ge">Géorgie (GE)</option>
              <option value="ga">Gabon (GA)</option>
              <option value="gm">Gambie (GM)</option>
              <option value="gh">Ghana (GH)</option>
              <option value="gi">Gibraltar (GI)</option>
              <option value="gr">Grèce (GR)</option>
              <option value="gd">Grenade (GD)</option>
              <option value="gl">Groenland (GL)</option>
              <option value="gp">Guadeloupe (GP)</option>
              <option value="gu">Guam (GU)</option>
              <option value="gt">Guatemala (GT)</option>
              <option value="gn">Guinée (GN)</option>
              <option value="gq">Guinée équatoriale (GQ)</option>
              <option value="gw">Guinée-Bissao (GW)</option>
              <option value="gy">Guyana (GY)</option>
              <option value="gf">Guyane française (GF)</option>
              <option value="ht">Haïti (HT)</option>
              <option value="hn">Honduras (HN)</option>
              <option value="hk">Hong Kong (HK)</option>
              <option value="hu">Hongrie (HU)</option>
              <option value="ck">Iles Cook (CK)</option>
              <option value="fj">Iles Fidji (FJ)</option>
              <option value="mh">Iles Marshall (MH)</option>
              <option value="sb">Iles Salomon (SB)</option>
              <option value="in">Inde (IN)</option>
              <option value="id">Indonésie (ID)</option>
              <option value="ir">Iran (IR)</option>
              <option value="iq">Iraq (IQ)</option>
              <option value="ie">Irlande (IE)</option>
              <option value="is">Islande (IS)</option>
              <option value="il">Israël (IL)</option>
              <option value="it">Italie (IT)</option>
              <option value="jm">Jamaïque (JM)</option>
              <option value="jp">Japon (JP)</option>
              <option value="jo">Jordanie (JO)</option>
              <option value="kz">Kazakhstan (KZ)</option>
              <option value="ke">Kenya (KE)</option>
              <option value="kg">Kirghizistan (KG)</option>
              <option value="ki">Kiribati (KI)</option>
              <option value="kw">Koweït (KW)</option>
              <option value="la">Laos (LA)</option>
              <option value="ls">Lesotho (LS)</option>
              <option value="lv">Lettonie (LV)</option>
              <option value="lb">Liban (LB)</option>
              <option value="lr">Liberia (LR)</option>
              <option value="ly">Libye (LY)</option>
              <option value="li">Liechtenstein (LI)</option>
              <option value="lt">Lituanie (LT)</option>
              <option value="lu">Luxembourg (LU)</option>
              <option value="mg">Madagascar (MG)</option>
              <option value="my">Malaisie (MY)</option>
              <option value="mw">Malawi (MW)</option>
              <option value="mv">Maldives (MV)</option>
              <option value="ml">Mali (ML)</option>
              <option value="mt">Malte (MT)</option>
              <option value="ma">Maroc (MA)</option>
              <option value="mu">Maurice (MU)</option>
              <option value="mr">Mauritanie (MR)</option>
              <option value="mx">Mexique (MX)</option>
              <option value="fm">Micronésie (FM)</option>
              <option value="md">Moldavie (MD)</option>
              <option value="mc">Monaco (MC)</option>
              <option value="mn">Mongolie (MN)</option>
              <option value="mz">Mozambique (MZ)</option>
              <option value="np">Népal (NP)</option>
              <option value="na">Namibie (NA)</option>
              <option value="nr">Nauru (NR)</option>
              <option value="ni">Nicaragua (NI)</option>
              <option value="ne">Niger (NE)</option>
              <option value="ng">Nigeria (NG)</option>
              <option value="nu">Nioué (NU)</option>
              <option value="no">Norvège (NO)</option>
              <option value="nz">Nouvelle-Zélande (NZ)</option>
              <option value="om">Oman (OM)</option>
              <option value="ug">Ouganda (UG)</option>
              <option value="uz">Ouzbékistan (UZ)</option>
              <option value="pe">Pérou (PE)</option>
              <option value="pk">Pakistan (PK)</option>
              <option value="pa">Panama (PA)</option>
              <option value="pg">Papouasie-Nouvelle-Guinée (PG)</option>
              <option value="py">Paraguay (PY)</option>
              <option value="nl">Pays-Bas (NL)</option>
              <option value="ph">Philippines (PH)</option>
              <option value="pl">Pologne (PL)</option>
              <option value="pt">Portugal (PT)</option>
              <option value="qa">Qatar (QA)</option>
              <option value="cf">République centrafricaine (CF)</option>
              <option value="cd">République démocratique du Congo (CD)</option>
              <option value="do">République dominicaine (DO)</option>
              <option value="cz">République tchèque (CZ)</option>
              <option value="ro">Roumanie (RO)</option>
              <option value="gb">Royaume-Uni (GB)</option>
              <option value="ru">Russie (RU)</option>
              <option value="rw">Rwanda (RW)</option>
              <option value="sn">Sénégal (SN)</option>
              <option value="kn">Saint-Christophe-et-Niévès (KN)</option>
              <option value="sm">Saint-Marin (SM)</option>
              <option value="va">Saint-Siège (VA)</option>
              <option value="vc">Saint-Vincent-et-les-Grenadines (VC)</option>
              <option value="lc">Sainte-Lucie (LC)</option>
              <option value="sv">Salvador (SV)</option>
              <option value="ws">Samoa (WS)</option>
              <option value="st">Sao Tomé-et-Principe (ST)</option>
              <option value="sc">Seychelles (SC)</option>
              <option value="sl">Sierra Leone (SL)</option>
              <option value="sg">Singapour (SG)</option>
              <option value="si">Slovénie (SI)</option>
              <option value="sk">Slovaquie (SK)</option>
              <option value="so">Somalie (SO)</option>
              <option value="sd">Soudan (SD)</option>
              <option value="lk">Sri Lanka (LK)</option>
              <option value="se">Suède (SE)</option>
              <option value="ch">Suisse (CH)</option>
              <option value="sr">Suriname (SR)</option>
              <option value="sz">Swaziland (SZ)</option>
              <option value="sy">Syrie (SY)</option>
              <option value="tw">Taïwan (TW)</option>
              <option value="tj">Tadjikistan (TJ)</option>
              <option value="tz">Tanzanie (TZ)</option>
              <option value="td">Tchad (TD)</option>
              <option value="th">Thaïlande (TH)</option>
              <option value="tl">Timor Oriental (TL)</option>
              <option value="tg">Togo (TG)</option>
              <option value="to">Tonga (TO)</option>
              <option value="vt">Trinité-et-Tobago (VT)</option>
              <option value="tn">Tunisie (TN)</option>
              <option value="tm">Turkménistan (TM)</option>
              <option value="tr">Turquie (TR)</option>
              <option value="tv">Tuvalu (TV)</option>
              <option value="ua">Ukraine (UA)</option>
              <option value="uy">Uruguay (UY)</option>
              <option value="vu">Vanuatu (VU)</option>
              <option value="ve">Venezuela (VE)</option>
              <option value="vn">Viêt Nam (VN)</option>
              <option value="ye">Yémen (YE)</option>
              <option value="zm">Zambie (ZM)</option>
              <option value="zw">Zimbabwe (ZW)</option>
              <option value="mk">ex-République yougoslave de Macédoine (MK)</option>
            </cvqf:select>
          </li>
          <li class="phone_row">
			<label for="childPhone" class="label">Téléphone<span class="required">*</span></label>
            <cvqf:text name="childPhone" mode="" maxlength="10"/>
          </li>
          <li class="text_row">
			<label for="childMail" class="label">Courriel</label>
            <cvqf:text name="childMail" mode=""/>
          </li>
        </ul>
      </fieldset>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
   		  this.childTitle = new Function("key","this.label='Civilité'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.maidenName = new Function("key","this.label='Nom d&quote;usage'; this.msg=null; this.required=false; this.mask=/[A-Z.]*/; this.minlength=0; this.maxlength=38; this.transform='uppercase'; this.type=null; return this[key];");
     		  this.subjectChildBirthPlaceCity = new Function("key","this.label='Ville'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.subjectChildBirthPlacePostalCode = new Function("key","this.label='Code Postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
     		  this.childBirthCountry = new Function("key","this.label='Pays de naissance'; this.msg=null; this.required=true; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
         	  this.subjectChildAddressAdditionalDeliveryInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectChildAddressAdditionalGeographicalInformation = new Function("key","this.label=''; this.msg=null; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectChildAddressStreetNumber = new Function("key","this.label='Numéro'; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.subjectChildAddressStreetName = new Function("key","this.label='Voie'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
	  this.subjectChildAddressPlaceNameOrService = new Function("key","this.label=''; this.msg=null; this.transform='uppercase'; this.required=false; this.minlength=0; this.maxlength=38; this.type=null; return this[key];");
	  this.subjectChildAddressPostalCode = new Function("key","this.label='Code postal'; this.msg=null; this.required=true; this.mask=/[0-9]{5}/; this.minlength=0; this.maxlength=5; this.type=null; return this[key];");
	  this.subjectChildAddressCity = new Function("key","this.label='Localité'; this.msg=null; this.transform='uppercase'; this.required=true; this.minlength=0; this.maxlength=32; this.type=null; return this[key];");
     		  this.childResidenceCountry = new Function("key","this.label='Pays de résidence'; this.msg=null; this.required=false; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
     		  this.childPhone = new Function("key","this.label='Téléphone'; this.msg=null; this.required=true; this.mask=/^0[1-9][0-9]{8}/; this.minlength=0; this.maxlength=10; this.type=null; return this[key];");
     		  this.childMail = new Function("key","this.label='Courriel'; this.msg=null; this.required=false; this.mask=/[a-zA-Z0-9._%\-]+@[a-zA-Z0-9._%\-]+\.[a-zA-Z0-9._%\-]{2,4}/; this.minlength=0; this.maxlength=0; this.type=null; return this[key];");
  		}
        updateDisplay("childTitle");
        updateDisplay("childBirthCountry");
        window.onload = function () {
	        addresseTypeAhead("subjectChildAddressCity", "subjectChildAddressPostalCode");
        }
        updateDisplay("childResidenceCountry");
  		setFocus("Inscription");
	</script>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/cvq-forms" prefix="cvqf" %>

	<cvqf:form name="Inscription" action="#" mode="static">
      <ul class="confirm_list">
        <li class="text_row">
          <p class="label">            
            Nom
          </p>
          <p class="text">
            <cvqf:text name="subjectChildLastName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Prénom
          </p>
          <p class="text">
            <cvqf:text name="subjectChildFirstName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Civilité
          </p>
          <p class="text">
            <cvqf:select name="childTitle" mode="static">
              <option value="">Choisissez un civilité</option>
              <option value="Mister">Monsieur</option>
              <option value="Madam">Madame</option>
              <option value="Miss">Mademoiselle</option>
              <option value="Agency">Organisme</option>
              <option value="Unknown">Inconnue</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nom d'usage
          </p>
          <p class="text">
            <cvqf:text name="maidenName" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Ville de naissance
          </p>
          <p class="text">
            <cvqf:text name="subjectChildBirthPlaceCity" mode="static" maxlength="32"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Code de postal de naissance
          </p>
          <p class="text">
            <cvqf:text name="subjectChildBirthPlacePostalCode" mode="static" maxlength="5"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Pays de naissance
          </p>
          <p class="text">
            <cvqf:select name="childBirthCountry" mode="static">
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
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Etg. - Esc. - App.				
          </p>
          <p class="text">
    		<cvqf:text name="subjectChildAddressAdditionalDeliveryInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Imm. - Bât. - Rés.				
          </p>
          <p class="text">
    		<cvqf:text name="subjectChildAddressAdditionalGeographicalInformation" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				N&deg;, libellé de la voie				
          </p>
          <p class="text">
    		<cvqf:text name="subjectChildAddressStreetNumber" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectChildAddressStreetName" mode="static" maxlength="32" size="35"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Lieu-dit, boite postale				
          </p>
          <p class="text">
    		<cvqf:text name="subjectChildAddressPlaceNameOrService" mode="static" maxlength="38"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">
				Code postal, Localité				
          </p>
          <p class="text">
    		<cvqf:text name="subjectChildAddressPostalCode" mode="static" maxlength="5"/>
    		<cvqf:text name="subjectChildAddressCity" mode="static" maxlength="32" size="35"/>
          </p>
        </li>

        <li class="text_row">
          <p class="label">            
            Pays de résidence
          </p>
          <p class="text">
            <cvqf:select name="childResidenceCountry" mode="static">
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
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Téléphone
          </p>
          <p class="text">
            <cvqf:text name="childPhone" mode="static" maxlength="10"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Courriel
          </p>
          <p class="text">
            <cvqf:text name="childMail" mode="static"/>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Nationalité
          </p>
          <p class="text">
            <cvqf:select name="childCountry" mode="static">
              <option value="">Choisissez un nationalité</option>
              <option value="None">Aucune</option>
              <option value="af">Afghan(e)</option>
              <option value="za">Sud-africain(e)</option>
              <option value="al">Albanais(e)</option>
              <option value="dz">Algérien(ne)</option>
              <option value="de">Allemand(e)</option>
              <option value="ad">Andorran(e)</option>
              <option value="ao">Angolais(e)</option>
              <option value="ai">d'Anguilla</option>
              <option value="aq">d'Antarctique</option>
              <option value="ag">d'Antigua-et-Barbuda</option>
              <option value="an">des Antilles néerlandaises</option>
              <option value="sa">Saoudien(nne)</option>
              <option value="ar">Argentin(e)</option>
              <option value="am">Arménien(ne)</option>
              <option value="aw">d'Aruba</option>
              <option value="au">Australien(ne)</option>
              <option value="at">Autrichien(ne)</option>
              <option value="az">Azerbaïdjanais(e)</option>
              <option value="bs">Bahamien(ne)</option>
              <option value="bh">Bahreïnien(ne)</option>
              <option value="bd">Bangladais(e)</option>
              <option value="bb">Barbadien(ne)</option>
              <option value="be">Belge</option>
              <option value="bz">Belizien(ne)</option>
              <option value="bj">Béninois(e)</option>
              <option value="bm">des Bermudes</option>
              <option value="bt">Bhoutanais(e)</option>
              <option value="by">Biélorusse</option>
              <option value="mm">Birman(e)</option>
              <option value="bo">Bolivien(ne)</option>
              <option value="ba">de Bosnie-et-Herzégovine</option>
              <option value="bw">Botswanais(e)</option>
              <option value="br">Brésilien(ne)</option>
              <option value="bn">du Brunei</option>
              <option value="bg">Bulgare</option>
              <option value="bf">Burkinabè</option>
              <option value="bi">Burundais(e)</option>
              <option value="kh">Cambodgien(ne)</option>
              <option value="cm">Camerounais(e)</option>
              <option value="ca">Canadien(ne)</option>
              <option value="cv">Cap-Verdien(ne)</option>
              <option value="cl">Chilien(ne)</option>
              <option value="cn">Chinois(e)</option>
              <option value="cy">Chypriote</option>
              <option value="co">Colombien(ne)</option>
              <option value="km">Comorien(ne)</option>
              <option value="cg">Congolais(e)</option>
              <option value="kp">Nord-Coréen(ne)</option>
              <option value="kr">Sud-Coréen(ne)</option>
              <option value="cr">Costaricien(ne)</option>
              <option value="hr">Croate</option>
              <option value="cu">Cubain(e)</option>
              <option value="dk">Danois(e)</option>
              <option value="dj">Djiboutien(ne)</option>
              <option value="dm">Dominiquais(e)</option>
              <option value="eg">Égyptien(ne)</option>
              <option value="ae">des Émirats arabes unis</option>
              <option value="ec">Équatorien(ne)</option>
              <option value="er">Érythréen(ne)</option>
              <option value="es">Espagnol(e)</option>
              <option value="ee">Estonien(ne)</option>
              <option value="us">Américain(e)</option>
              <option value="et">Éthiopien(ne)</option>
              <option value="fi">Finlandais(e)</option>
              <option value="fr">Français(e)</option>
              <option value="ge">Géorgien(ne)</option>
              <option value="ga">Gabonais(e)</option>
              <option value="gm">Gambien(ne)</option>
              <option value="gh">Ghanéen(ne)</option>
              <option value="gi">de Gibraltar</option>
              <option value="gr">Grec(que)</option>
              <option value="gd">Grenadin(e)</option>
              <option value="gl">du Groenland</option>
              <option value="gu">du Guam</option>
              <option value="gt">Guatemaltèque</option>
              <option value="gn">Guinéen(ne)</option>
              <option value="gq">Equato-guinéen(ne)</option>
              <option value="gw">de Guinée-Bissao</option>
              <option value="ht">Haïtien(ne)</option>
              <option value="hn">Hondurien(ne)</option>
              <option value="hk">de Hong Kong</option>
              <option value="hu">Hongrois(e)</option>
              <option value="ck">des Iles Cook (CK)</option>
              <option value="fj">des Iles Fidji</option>
              <option value="mh">Marshallais(e)</option>
              <option value="sb">Salomonais(e)</option>
              <option value="in">Indien(ne)</option>
              <option value="id">Indonésien(ne)</option>
              <option value="ir">Iranien(ne)</option>
              <option value="iq">Iraquien(ne)</option>
              <option value="ie">Irlandais(e)</option>
              <option value="is">Islandais(e)</option>
              <option value="il">Israëlien(ne)</option>
              <option value="it">Italien(ne)</option>
              <option value="ci">Ivoirien(ne)</option>
              <option value="jm">Jamaïquain(e)</option>
              <option value="jp">Japonais(e)</option>
              <option value="jo">Jordanien(ne)</option>
              <option value="kz">Kazakh(e)</option>
              <option value="ke">Kényan(e)</option>
              <option value="kg">Kirghize</option>
              <option value="ki">Kiribatien(ne)</option>
              <option value="kw">Koweïtien(ne)</option>
              <option value="la">Laotien(ne)</option>
              <option value="ls">du Lesotho</option>
              <option value="lv">Lettonien(ne)</option>
              <option value="lb">Libanais(e)</option>
              <option value="lr">Liberien(ne)</option>
              <option value="ly">Libyen(ne)</option>
              <option value="li">Liechtensteinois(e)</option>
              <option value="lt">Lituanien(ne)</option>
              <option value="lu">Luxembourgeois(e)</option>
              <option value="mg">Malgache</option>
              <option value="my">Malaisien(ne)</option>
              <option value="mw">Malawien(ne)</option>
              <option value="mv">Maldivien(ne)</option>
              <option value="ml">Malien(ne)</option>
              <option value="mt">Maltais(e)</option>
              <option value="ma">Marocain(e)</option>
              <option value="mu">Mauricien(ne)</option>
              <option value="mr">Mauritanien(ne)</option>
              <option value="mx">Mexicain(e)</option>
              <option value="fm">Micronésien(ne)</option>
              <option value="md">Moldove</option>
              <option value="mc">Monégasque</option>
              <option value="mn">Mongolien(ne)</option>
              <option value="mz">Mozambicain(e)</option>
              <option value="np">Népalais(e)</option>
              <option value="na">Namibien(ne)</option>
              <option value="nr">Nauruan(e)</option>
              <option value="ni">Nicaraguayen(ne)</option>
              <option value="ne">Nigérien(ne)</option>
              <option value="ng">Nigérian(ne)</option>
              <option value="nu">Niuéan(e)</option>
              <option value="no">Norvégien(ne)</option>
              <option value="nz">Néo-Zélandais(e)</option>
              <option value="om">Omanais(e)</option>
              <option value="ug">Ougandais(e)</option>
              <option value="uz">Ouzbèk(e)</option>
              <option value="pe">Péruvien(ne)</option>
              <option value="pk">Pakistanais(e)</option>
              <option value="pa">Panaméen(ne)</option>
              <option value="pg">de Papouasie-Nouvelle-Guinée</option>
              <option value="py">Paraguayen(ne)</option>
              <option value="nl">Néerlandais(e)</option>
              <option value="ph">Philippin(e)</option>
              <option value="pl">Polonais(e)</option>
              <option value="pt">Portugais(e)</option>
              <option value="qa">Qatarien(ne)</option>
              <option value="cf">Centrafricain(e)</option>
              <option value="cd">Congolais(e)</option>
              <option value="do">Dominicain(e)</option>
              <option value="cz">Tchèque</option>
              <option value="ro">Roumain(e)</option>
              <option value="gb">Britannique</option>
              <option value="ru">Russe</option>
              <option value="rw">Rwandais(e)</option>
              <option value="sn">Sénégalais(e)</option>
              <option value="kn">de Saint-Christophe-et-Niévès</option>
              <option value="sm">Saint-Marinais(e)</option>
              <option value="va">du Saint-Siège</option>
              <option value="vc">de Saint-Vincent-et-les-Grenadines</option>
              <option value="lc">Saint-Lucien(ne)</option>
              <option value="sv">Salvadorien(ne)</option>
              <option value="ws">Samoan(e)</option>
              <option value="st">de Sao Tomé-et-Principe</option>
              <option value="sc">Seychellois(e)</option>
              <option value="sl">de Sierra Leone</option>
              <option value="sg">Singapourien(ne)</option>
              <option value="si">Slovénien(ne)</option>
              <option value="sk">Slovaque</option>
              <option value="so">Somalien(ne)</option>
              <option value="sd">Soudanais(e)</option>
              <option value="lk">Sri Lankais(e)</option>
              <option value="se">Suèdois(e)</option>
              <option value="ch">Suisse</option>
              <option value="sr">Surinamais(e)</option>
              <option value="sz">Swazi(e)</option>
              <option value="sy">Syrien(ne)</option>
              <option value="tw">Taïwanais(e)</option>
              <option value="tj">Tadjik(e)</option>
              <option value="tz">Tanzanien(ne)</option>
              <option value="td">Tchadien(ne)</option>
              <option value="th">Thaïlandais(e)</option>
              <option value="tl">Est-Timorais(e)</option>
              <option value="tg">Togolais(e)</option>
              <option value="to">Tongan(e)</option>
              <option value="vt">Trinidadien(ne)</option>
              <option value="tn">Tunisien(ne)</option>
              <option value="tm">Turkmène</option>
              <option value="tr">Turc(que)</option>
              <option value="tv">Tuvaluan(e)</option>
              <option value="ua">Ukrainien(ne)</option>
              <option value="uy">Uruguayen(ne)</option>
              <option value="vu">Vanuatuan(e)</option>
              <option value="ve">Venezuelien(ne)</option>
              <option value="vn">Viêtnamien(ne)</option>
              <option value="ye">Yéménite</option>
              <option value="zm">Zambien(ne)</option>
              <option value="zw">Zimbabwéen(ne)</option>
              <option value="mk">de l'ancienne République yougoslave de Macédoine</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Deuxième nationalité
          </p>
          <p class="text">
            <cvqf:select name="childOtherCountry" mode="static">
              <option value="">Choisissez un deuxième nationalité</option>
              <option value="None">Aucune</option>
              <option value="af">Afghan(e)</option>
              <option value="za">Sud-africain(e)</option>
              <option value="al">Albanais(e)</option>
              <option value="dz">Algérien(ne)</option>
              <option value="de">Allemand(e)</option>
              <option value="ad">Andorran(e)</option>
              <option value="ao">Angolais(e)</option>
              <option value="ai">d'Anguilla</option>
              <option value="aq">d'Antarctique</option>
              <option value="ag">d'Antigua-et-Barbuda</option>
              <option value="an">des Antilles néerlandaises</option>
              <option value="sa">Saoudien(nne)</option>
              <option value="ar">Argentin(e)</option>
              <option value="am">Arménien(ne)</option>
              <option value="aw">d'Aruba</option>
              <option value="au">Australien(ne)</option>
              <option value="at">Autrichien(ne)</option>
              <option value="az">Azerbaïdjanais(e)</option>
              <option value="bs">Bahamien(ne)</option>
              <option value="bh">Bahreïnien(ne)</option>
              <option value="bd">Bangladais(e)</option>
              <option value="bb">Barbadien(ne)</option>
              <option value="be">Belge</option>
              <option value="bz">Belizien(ne)</option>
              <option value="bj">Béninois(e)</option>
              <option value="bm">des Bermudes</option>
              <option value="bt">Bhoutanais(e)</option>
              <option value="by">Biélorusse</option>
              <option value="mm">Birman(e)</option>
              <option value="bo">Bolivien(ne)</option>
              <option value="ba">de Bosnie-et-Herzégovine</option>
              <option value="bw">Botswanais(e)</option>
              <option value="br">Brésilien(ne)</option>
              <option value="bn">du Brunei</option>
              <option value="bg">Bulgare</option>
              <option value="bf">Burkinabè</option>
              <option value="bi">Burundais(e)</option>
              <option value="kh">Cambodgien(ne)</option>
              <option value="cm">Camerounais(e)</option>
              <option value="ca">Canadien(ne)</option>
              <option value="cv">Cap-Verdien(ne)</option>
              <option value="cl">Chilien(ne)</option>
              <option value="cn">Chinois(e)</option>
              <option value="cy">Chypriote</option>
              <option value="co">Colombien(ne)</option>
              <option value="km">Comorien(ne)</option>
              <option value="cg">Congolais(e)</option>
              <option value="kp">Nord-Coréen(ne)</option>
              <option value="kr">Sud-Coréen(ne)</option>
              <option value="cr">Costaricien(ne)</option>
              <option value="hr">Croate</option>
              <option value="cu">Cubain(e)</option>
              <option value="dk">Danois(e)</option>
              <option value="dj">Djiboutien(ne)</option>
              <option value="dm">Dominiquais(e)</option>
              <option value="eg">Égyptien(ne)</option>
              <option value="ae">des Émirats arabes unis</option>
              <option value="ec">Équatorien(ne)</option>
              <option value="er">Érythréen(ne)</option>
              <option value="es">Espagnol(e)</option>
              <option value="ee">Estonien(ne)</option>
              <option value="us">Américain(e)</option>
              <option value="et">Éthiopien(ne)</option>
              <option value="fi">Finlandais(e)</option>
              <option value="fr">Français(e)</option>
              <option value="ge">Géorgien(ne)</option>
              <option value="ga">Gabonais(e)</option>
              <option value="gm">Gambien(ne)</option>
              <option value="gh">Ghanéen(ne)</option>
              <option value="gi">de Gibraltar</option>
              <option value="gr">Grec(que)</option>
              <option value="gd">Grenadin(e)</option>
              <option value="gl">du Groenland</option>
              <option value="gu">du Guam</option>
              <option value="gt">Guatemaltèque</option>
              <option value="gn">Guinéen(ne)</option>
              <option value="gq">Equato-guinéen(ne)</option>
              <option value="gw">de Guinée-Bissao</option>
              <option value="ht">Haïtien(ne)</option>
              <option value="hn">Hondurien(ne)</option>
              <option value="hk">de Hong Kong</option>
              <option value="hu">Hongrois(e)</option>
              <option value="ck">des Iles Cook (CK)</option>
              <option value="fj">des Iles Fidji</option>
              <option value="mh">Marshallais(e)</option>
              <option value="sb">Salomonais(e)</option>
              <option value="in">Indien(ne)</option>
              <option value="id">Indonésien(ne)</option>
              <option value="ir">Iranien(ne)</option>
              <option value="iq">Iraquien(ne)</option>
              <option value="ie">Irlandais(e)</option>
              <option value="is">Islandais(e)</option>
              <option value="il">Israëlien(ne)</option>
              <option value="it">Italien(ne)</option>
              <option value="ci">Ivoirien(ne)</option>
              <option value="jm">Jamaïquain(e)</option>
              <option value="jp">Japonais(e)</option>
              <option value="jo">Jordanien(ne)</option>
              <option value="kz">Kazakh(e)</option>
              <option value="ke">Kényan(e)</option>
              <option value="kg">Kirghize</option>
              <option value="ki">Kiribatien(ne)</option>
              <option value="kw">Koweïtien(ne)</option>
              <option value="la">Laotien(ne)</option>
              <option value="ls">du Lesotho</option>
              <option value="lv">Lettonien(ne)</option>
              <option value="lb">Libanais(e)</option>
              <option value="lr">Liberien(ne)</option>
              <option value="ly">Libyen(ne)</option>
              <option value="li">Liechtensteinois(e)</option>
              <option value="lt">Lituanien(ne)</option>
              <option value="lu">Luxembourgeois(e)</option>
              <option value="mg">Malgache</option>
              <option value="my">Malaisien(ne)</option>
              <option value="mw">Malawien(ne)</option>
              <option value="mv">Maldivien(ne)</option>
              <option value="ml">Malien(ne)</option>
              <option value="mt">Maltais(e)</option>
              <option value="ma">Marocain(e)</option>
              <option value="mu">Mauricien(ne)</option>
              <option value="mr">Mauritanien(ne)</option>
              <option value="mx">Mexicain(e)</option>
              <option value="fm">Micronésien(ne)</option>
              <option value="md">Moldove</option>
              <option value="mc">Monégasque</option>
              <option value="mn">Mongolien(ne)</option>
              <option value="mz">Mozambicain(e)</option>
              <option value="np">Népalais(e)</option>
              <option value="na">Namibien(ne)</option>
              <option value="nr">Nauruan(e)</option>
              <option value="ni">Nicaraguayen(ne)</option>
              <option value="ne">Nigérien(ne)</option>
              <option value="ng">Nigérian(ne)</option>
              <option value="nu">Niuéan(e)</option>
              <option value="no">Norvégien(ne)</option>
              <option value="nz">Néo-Zélandais(e)</option>
              <option value="om">Omanais(e)</option>
              <option value="ug">Ougandais(e)</option>
              <option value="uz">Ouzbèk(e)</option>
              <option value="pe">Péruvien(ne)</option>
              <option value="pk">Pakistanais(e)</option>
              <option value="pa">Panaméen(ne)</option>
              <option value="pg">de Papouasie-Nouvelle-Guinée</option>
              <option value="py">Paraguayen(ne)</option>
              <option value="nl">Néerlandais(e)</option>
              <option value="ph">Philippin(e)</option>
              <option value="pl">Polonais(e)</option>
              <option value="pt">Portugais(e)</option>
              <option value="qa">Qatarien(ne)</option>
              <option value="cf">Centrafricain(e)</option>
              <option value="cd">Congolais(e)</option>
              <option value="do">Dominicain(e)</option>
              <option value="cz">Tchèque</option>
              <option value="ro">Roumain(e)</option>
              <option value="gb">Britannique</option>
              <option value="ru">Russe</option>
              <option value="rw">Rwandais(e)</option>
              <option value="sn">Sénégalais(e)</option>
              <option value="kn">de Saint-Christophe-et-Niévès</option>
              <option value="sm">Saint-Marinais(e)</option>
              <option value="va">du Saint-Siège</option>
              <option value="vc">de Saint-Vincent-et-les-Grenadines</option>
              <option value="lc">Saint-Lucien(ne)</option>
              <option value="sv">Salvadorien(ne)</option>
              <option value="ws">Samoan(e)</option>
              <option value="st">de Sao Tomé-et-Principe</option>
              <option value="sc">Seychellois(e)</option>
              <option value="sl">de Sierra Leone</option>
              <option value="sg">Singapourien(ne)</option>
              <option value="si">Slovénien(ne)</option>
              <option value="sk">Slovaque</option>
              <option value="so">Somalien(ne)</option>
              <option value="sd">Soudanais(e)</option>
              <option value="lk">Sri Lankais(e)</option>
              <option value="se">Suèdois(e)</option>
              <option value="ch">Suisse</option>
              <option value="sr">Surinamais(e)</option>
              <option value="sz">Swazi(e)</option>
              <option value="sy">Syrien(ne)</option>
              <option value="tw">Taïwanais(e)</option>
              <option value="tj">Tadjik(e)</option>
              <option value="tz">Tanzanien(ne)</option>
              <option value="td">Tchadien(ne)</option>
              <option value="th">Thaïlandais(e)</option>
              <option value="tl">Est-Timorais(e)</option>
              <option value="tg">Togolais(e)</option>
              <option value="to">Tongan(e)</option>
              <option value="vt">Trinidadien(ne)</option>
              <option value="tn">Tunisien(ne)</option>
              <option value="tm">Turkmène</option>
              <option value="tr">Turc(que)</option>
              <option value="tv">Tuvaluan(e)</option>
              <option value="ua">Ukrainien(ne)</option>
              <option value="uy">Uruguayen(ne)</option>
              <option value="vu">Vanuatuan(e)</option>
              <option value="ve">Venezuelien(ne)</option>
              <option value="vn">Viêtnamien(ne)</option>
              <option value="ye">Yéménite</option>
              <option value="zm">Zambien(ne)</option>
              <option value="zw">Zimbabwéen(ne)</option>
              <option value="mk">de l'ancienne République yougoslave de Macédoine</option>
            </cvqf:select>
          </p>
        </li>
        <li class="text_row">
          <p class="label">            
            Convention internationale
          </p>
          <p class="text">
            <cvqf:text name="childConvention" mode="static"/>
          </p>
        </li>
      </ul>
	</cvqf:form>
	<script type="text/javascript">
		function validationData() {
		}
  		setFocus("Inscription");
	</script>

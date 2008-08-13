<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<bean:define id="record" name="stateManager" property="selectedRecord" scope="session"/>
 
 <div class="grid_cell">
    <div class="block009">
     <p class="text005 pictoTable">Formulaire</p>
   </div>
   <div class="block010">
     <fieldset class="fieldset005">
 
         <div class="form_cell form_cell1">
         <label for="subjectChildLastName" class="label">Nom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildLastName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildFirstName" class="label">Prénom :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildFirstName"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childTitle" class="label">Civilité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childTitle" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="maidenName" class="label">Nom d'usage :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="maidenName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildBirthDate" class="label">Date de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildBirthDate"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildBirthPlaceCity" class="label">Ville de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildBirthPlaceCity"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="subjectChildBirthPlacePostalCode" class="label">Code postal de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="subjectChildBirthPlacePostalCode"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childBirthCountry" class="label">Pays de naissance :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childBirthCountry" id="id" profile="profile"/>
    	</span>
       </div>
               <div class="form_cell form_cell1">
         <label for="subjectChildAddressAdditionalDeliveryInformation" class="label">Etg. - Esc. - App. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressAdditionalDeliveryInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressAdditionalGeographicalInformation" class="label">Imm. - Bât. - Rés. :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressAdditionalGeographicalInformation" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressStreetNumber" class="label">Numéro :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressStreetNumber" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressStreetName" class="label">Libellé de la voie :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressStreetName" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressPlaceNameOrService" class="label">Lieu-dit, boite postale :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressPlaceNameOrService" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressPostalCode" class="label">Code postal :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressPostalCode" id="id" profile="profile" />
         </span>
       </div>
       <div class="form_cell form_cell1">
         <label for="subjectChildAddressCity" class="label">Localité :</label>
         <span class="input">
		<cvq:toggleInput name="record" property="subjectChildAddressCity" id="id" profile="profile" />
         </span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childResidenceCountry" class="label">Pays de résidence :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childResidenceCountry" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childPhone" class="label">Téléphone :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childPhone"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childMail" class="label">Courriel :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childMail" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childCountry" class="label">Nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childCountry"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childOtherCountry" class="label">Deuxième nationalité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childOtherCountry"/>
    
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childConvention" class="label">Convention internationale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childConvention" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherLastName" class="label">Nom du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherFirstName" class="label">Prénom du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherFirstName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherBirthDate" class="label">Date de naissance du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherBirthDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherBirthCity" class="label">Ville de naissance du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherBirthCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherBirthDepartment" class="label">Département de naissance du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherBirthDepartment" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherBirthCountry" class="label">Pays de naissance du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherBirthCountry" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="fatherNationality" class="label">Nationalité du père :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="fatherNationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherLastName" class="label">Nom de jeune fille de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherLastName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherFirstName" class="label">Prénom de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherFirstName" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherBirthDate" class="label">Date de naissance de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherBirthDate" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherBirthCity" class="label">Ville de naissance de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherBirthCity" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherBirthDepartment" class="label">Département de naissance de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherBirthDepartment" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherBirthCountry" class="label">Pays de naissance de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherBirthCountry" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="motherNationality" class="label">Nationalité de la mère :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="motherNationality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="aliveChildren" class="label">Nombre de frères et soeurs vivants :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="aliveChildren" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childStatus" class="label">Situation familiale :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childStatus" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childrenInCharge" class="label">Nombre d'enfants à charge :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childrenInCharge" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="otherSituation" class="label">Autre situation :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="otherSituation" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="statePupil" class="label">Pupille de l'état :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="statePupil" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="prefectPupil" class="label">Pupille du préfet :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="prefectPupil" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="prefectPupilDepartment" class="label">Pupille du préfet du département :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="prefectPupilDepartment" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childSituation" class="label">Situation scolaire ou professionnelle :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childSituation" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childDiploma" class="label">Diplôme :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childDiploma" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childSpeciality" class="label">Spécialité :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childSpeciality" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="childProfession" class="label">Profession :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="childProfession" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="japdExemption" class="label">Exemption JAPD :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="japdExemption" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="highlyInfirm" class="label">Grand Infirme :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="highlyInfirm" id="id" profile="profile"/>
    	</span>
       </div>
           <div class="form_cell form_cell1">
         <label for="affectionOrDisease" class="label">Affection ou maladie :</label>
         <span class="input">
   
    

    	 <cvq:toggleInput name="record" property="affectionOrDisease" id="id" profile="profile"/>
    	</span>
       </div>
       </fieldset>
   </div>
 </div>

<script type="text/javascript">
	function selectionData() {
                  		this.childTitle = new Function("key","this.values=new Array('Monsieur','Madame','Mademoiselle','Organisme','Inconnue'); return this[key];");
                                                        		this.childBirthCountry = new Function("key","this.values=new Array('Inconnu','Afghanistan (AF)','Afrique du Sud (ZA)','Albanie (AL)','Algérie(DZ)','Allemagne (DE)','Andorre (AD)','Angola (AO)','Anguilla (AI)','Antarctique (AQ)','Antigua-et-Barbuda (AG)','Antilles néerlandaises (AN)','Arabie saoudite (SA)','Argentine (AR)','Arménie (AM)','Aruba (AW)','Australie (AU)','Autriche (AT)','Azerbaïdjan (AZ)','Bénin (BJ)','Bahamas (BS)','Bahreïn (BH)','Bangladesh (BD)','Barbade (BB)','Belau (PW)','Belgique (BE)','Belize (BZ)','Bermudes (BM)','Bhoutan (BT)','Biélorussie (BY)','Birmanie (MM)','Bolivie (BO)','Bosnie-Herzégovine (BA)','Botswana (BW)','Brésil (BR)','Brunei (BN)','Bulgarie (BG)','Burkina Faso (BF)','Burundi (BI)','Côte d&rsquo;Ivoire (CI)','Cambodge (KH)','Cameroun (CM)','Canada (CA)','Cap-Vert (CV)','Chili (CL)','Chine (CN)','Chypre (CY)','Colombie (CO)','Comores (KM)','Congo (CG)','Corée du Nord (KP)','Corée du Sud (KR)','Costa Rica (CR)','Croatie (HR)','Cuba (CU)','Danemark (DK)','Djibouti (DJ)','Dominique (DM)','Égypte (EG)','Émirats arabes unis (AE)','Équateur (EC)','Érythrée (ER)','Espagne (ES)','Estonie (EE)','États-Unis (US)','Éthiopie (ET)','Finlande (FI)','France (FR)','Géorgie (GE)','Gabon (GA)','Gambie (GM)','Ghana (GH)','Gibraltar (GI)','Grèce (GR)','Grenade (GD)','Groenland (GL)','Guadeloupe (GP)','Guam (GU)','Guatemala (GT)','Guinée (GN)','Guinée équatoriale (GQ)','Guinée-Bissao (GW)','Guyana (GY)','Guyane française (GF)','Haïti (HT)','Honduras (HN)','Hong Kong (HK)','Hongrie (HU)','Iles Cook (CK)','Iles Fidji (FJ)','Iles Marshall (MH)','Iles Salomon (SB)','Inde (IN)','Indonésie (ID)','Iran (IR)','Iraq (IQ)','Irlande (IE)','Islande (IS)','Israël (IL)','Italie (IT)','Jamaïque (JM)','Japon (JP)','Jordanie (JO)','Kazakhstan (KZ)','Kenya (KE)','Kirghizistan (KG)','Kiribati (KI)','Koweït (KW)','Laos (LA)','Lesotho (LS)','Lettonie (LV)','Liban (LB)','Liberia (LR)','Libye (LY)','Liechtenstein (LI)','Lituanie (LT)','Luxembourg (LU)','Madagascar (MG)','Malaisie (MY)','Malawi (MW)','Maldives (MV)','Mali (ML)','Malte (MT)','Maroc (MA)','Maurice (MU)','Mauritanie (MR)','Mexique (MX)','Micronésie (FM)','Moldavie (MD)','Monaco (MC)','Mongolie (MN)','Mozambique (MZ)','Népal (NP)','Namibie (NA)','Nauru (NR)','Nicaragua (NI)','Niger (NE)','Nigeria (NG)','Nioué (NU)','Norvège (NO)','Nouvelle-Zélande (NZ)','Oman (OM)','Ouganda (UG)','Ouzbékistan (UZ)','Pérou (PE)','Pakistan (PK)','Panama (PA)','Papouasie-Nouvelle-Guinée (PG)','Paraguay (PY)','Pays-Bas (NL)','Philippines (PH)','Pologne (PL)','Portugal (PT)','Qatar (QA)','République centrafricaine (CF)','République démocratique du Congo (CD)','République dominicaine (DO)','République tchèque (CZ)','Roumanie (RO)','Royaume-Uni (GB)','Russie (RU)','Rwanda (RW)','Sénégal (SN)','Saint-Christophe-et-Niévès (KN)','Saint-Marin (SM)','Saint-Siège (VA)','Saint-Vincent-et-les-Grenadines (VC)','Sainte-Lucie (LC)','Salvador (SV)','Samoa (WS)','Sao Tomé-et-Principe (ST)','Seychelles (SC)','Sierra Leone (SL)','Singapour (SG)','Slovénie (SI)','Slovaquie (SK)','Somalie (SO)','Soudan (SD)','Sri Lanka (LK)','Suède (SE)','Suisse (CH)','Suriname (SR)','Swaziland (SZ)','Syrie (SY)','Taïwan (TW)','Tadjikistan (TJ)','Tanzanie (TZ)','Tchad (TD)','Thaïlande (TH)','Timor Oriental (TL)','Togo (TG)','Tonga (TO)','Trinité-et-Tobago (VT)','Tunisie (TN)','Turkménistan (TM)','Turquie (TR)','Tuvalu (TV)','Ukraine (UA)','Uruguay (UY)','Vanuatu (VU)','Venezuela (VE)','Viêt Nam (VN)','Yémen (YE)','Zambie (ZM)','Zimbabwe (ZW)','ex-République yougoslave de Macédoine (MK)'); return this[key];");
                              		this.childResidenceCountry = new Function("key","this.values=new Array('Inconnu','Afghanistan (AF)','Afrique du Sud (ZA)','Albanie (AL)','Algérie(DZ)','Allemagne (DE)','Andorre (AD)','Angola (AO)','Anguilla (AI)','Antarctique (AQ)','Antigua-et-Barbuda (AG)','Antilles néerlandaises (AN)','Arabie saoudite (SA)','Argentine (AR)','Arménie (AM)','Aruba (AW)','Australie (AU)','Autriche (AT)','Azerbaïdjan (AZ)','Bénin (BJ)','Bahamas (BS)','Bahreïn (BH)','Bangladesh (BD)','Barbade (BB)','Belau (PW)','Belgique (BE)','Belize (BZ)','Bermudes (BM)','Bhoutan (BT)','Biélorussie (BY)','Birmanie (MM)','Bolivie (BO)','Bosnie-Herzégovine (BA)','Botswana (BW)','Brésil (BR)','Brunei (BN)','Bulgarie (BG)','Burkina Faso (BF)','Burundi (BI)','Côte d&rsquo;Ivoire (CI)','Cambodge (KH)','Cameroun (CM)','Canada (CA)','Cap-Vert (CV)','Chili (CL)','Chine (CN)','Chypre (CY)','Colombie (CO)','Comores (KM)','Congo (CG)','Corée du Nord (KP)','Corée du Sud (KR)','Costa Rica (CR)','Croatie (HR)','Cuba (CU)','Danemark (DK)','Djibouti (DJ)','Dominique (DM)','Égypte (EG)','Émirats arabes unis (AE)','Équateur (EC)','Érythrée (ER)','Espagne (ES)','Estonie (EE)','États-Unis (US)','Éthiopie (ET)','Finlande (FI)','France (FR)','Géorgie (GE)','Gabon (GA)','Gambie (GM)','Ghana (GH)','Gibraltar (GI)','Grèce (GR)','Grenade (GD)','Groenland (GL)','Guadeloupe (GP)','Guam (GU)','Guatemala (GT)','Guinée (GN)','Guinée équatoriale (GQ)','Guinée-Bissao (GW)','Guyana (GY)','Guyane française (GF)','Haïti (HT)','Honduras (HN)','Hong Kong (HK)','Hongrie (HU)','Iles Cook (CK)','Iles Fidji (FJ)','Iles Marshall (MH)','Iles Salomon (SB)','Inde (IN)','Indonésie (ID)','Iran (IR)','Iraq (IQ)','Irlande (IE)','Islande (IS)','Israël (IL)','Italie (IT)','Jamaïque (JM)','Japon (JP)','Jordanie (JO)','Kazakhstan (KZ)','Kenya (KE)','Kirghizistan (KG)','Kiribati (KI)','Koweït (KW)','Laos (LA)','Lesotho (LS)','Lettonie (LV)','Liban (LB)','Liberia (LR)','Libye (LY)','Liechtenstein (LI)','Lituanie (LT)','Luxembourg (LU)','Madagascar (MG)','Malaisie (MY)','Malawi (MW)','Maldives (MV)','Mali (ML)','Malte (MT)','Maroc (MA)','Maurice (MU)','Mauritanie (MR)','Mexique (MX)','Micronésie (FM)','Moldavie (MD)','Monaco (MC)','Mongolie (MN)','Mozambique (MZ)','Népal (NP)','Namibie (NA)','Nauru (NR)','Nicaragua (NI)','Niger (NE)','Nigeria (NG)','Nioué (NU)','Norvège (NO)','Nouvelle-Zélande (NZ)','Oman (OM)','Ouganda (UG)','Ouzbékistan (UZ)','Pérou (PE)','Pakistan (PK)','Panama (PA)','Papouasie-Nouvelle-Guinée (PG)','Paraguay (PY)','Pays-Bas (NL)','Philippines (PH)','Pologne (PL)','Portugal (PT)','Qatar (QA)','République centrafricaine (CF)','République démocratique du Congo (CD)','République dominicaine (DO)','République tchèque (CZ)','Roumanie (RO)','Royaume-Uni (GB)','Russie (RU)','Rwanda (RW)','Sénégal (SN)','Saint-Christophe-et-Niévès (KN)','Saint-Marin (SM)','Saint-Siège (VA)','Saint-Vincent-et-les-Grenadines (VC)','Sainte-Lucie (LC)','Salvador (SV)','Samoa (WS)','Sao Tomé-et-Principe (ST)','Seychelles (SC)','Sierra Leone (SL)','Singapour (SG)','Slovénie (SI)','Slovaquie (SK)','Somalie (SO)','Soudan (SD)','Sri Lanka (LK)','Suède (SE)','Suisse (CH)','Suriname (SR)','Swaziland (SZ)','Syrie (SY)','Taïwan (TW)','Tadjikistan (TJ)','Tanzanie (TZ)','Tchad (TD)','Thaïlande (TH)','Timor Oriental (TL)','Togo (TG)','Tonga (TO)','Trinité-et-Tobago (VT)','Tunisie (TN)','Turkménistan (TM)','Turquie (TR)','Tuvalu (TV)','Ukraine (UA)','Uruguay (UY)','Vanuatu (VU)','Venezuela (VE)','Viêt Nam (VN)','Yémen (YE)','Zambie (ZM)','Zimbabwe (ZW)','ex-République yougoslave de Macédoine (MK)'); return this[key];");
                                                                                                                                                                      		this.fatherBirthDepartment = new Function("key","this.values=new Array('Aucun','Ain','Aisne','Allier','Alpes-de-Haute-Provence','Hautes-Alpes','Alpes-Maritimes','Ardèche','Ardennes','Ariège','Aube','Aude','Aveyron','Bouches-du-Rhône','Calvados','Cantal','Charente','Charente-Maritime','Cher','Corrèze','Corse-du-Sud','Haute-Corse','Côte-d&rsquo;Or','Côtes-d&rsquo;Armor','Creuse','Dordogne','Doubs','Drôme','Eure','Eure-et-Loir','Finistère','Gard','Haute-Garonne','Gers','Gironde','Hérault','Ille-et-Vilaine','Indre','Indre-et-Loire','Isère','Jura','Landes','Loir-et-Cher','Loire','Haute-Loire','Loire-Atlantique','Loiret','Lot','Lot-et-Garonne','Lozère','Maine-et-Loire','Manche','Marne','Haute-Marne','Mayenne','Meurthe-et-Moselle','Meuse','Morbihan','Moselle','Nièvre','Nord','Oise','Orne','Pas-de-Calais','Puy-de-Dôme','Pyrénes-Atlantiques','Hautes-Pyrénées','Pyrénées-Orientales','Bas-Rhin','Haut-Rhin','Rhône','Haute-Saône','Saône-et-Loire','Sarthe','Savoie','Haute-Savoie','Paris','Seine-Maritime','Seine-et-Marne','Yvelines','Deux-Sèvres','Somme','Tarn','Tarn-et-Garonne','Var','Vaucluse','Vendée','Vienne','Haute-Vienne','Vosges','Yonne','Territoire de Belfort','Essonne','Hauts-de-Seine','Seine-Saint-Denis','Val-de-Marne','Val-d&rsquo;Oise','Guadeloupe','Martinique','Guyane','Réunion'); return this[key];");
                            		this.fatherBirthCountry = new Function("key","this.values=new Array('Inconnu','Afghanistan (AF)','Afrique du Sud (ZA)','Albanie (AL)','Algérie(DZ)','Allemagne (DE)','Andorre (AD)','Angola (AO)','Anguilla (AI)','Antarctique (AQ)','Antigua-et-Barbuda (AG)','Antilles néerlandaises (AN)','Arabie saoudite (SA)','Argentine (AR)','Arménie (AM)','Aruba (AW)','Australie (AU)','Autriche (AT)','Azerbaïdjan (AZ)','Bénin (BJ)','Bahamas (BS)','Bahreïn (BH)','Bangladesh (BD)','Barbade (BB)','Belau (PW)','Belgique (BE)','Belize (BZ)','Bermudes (BM)','Bhoutan (BT)','Biélorussie (BY)','Birmanie (MM)','Bolivie (BO)','Bosnie-Herzégovine (BA)','Botswana (BW)','Brésil (BR)','Brunei (BN)','Bulgarie (BG)','Burkina Faso (BF)','Burundi (BI)','Côte d&rsquo;Ivoire (CI)','Cambodge (KH)','Cameroun (CM)','Canada (CA)','Cap-Vert (CV)','Chili (CL)','Chine (CN)','Chypre (CY)','Colombie (CO)','Comores (KM)','Congo (CG)','Corée du Nord (KP)','Corée du Sud (KR)','Costa Rica (CR)','Croatie (HR)','Cuba (CU)','Danemark (DK)','Djibouti (DJ)','Dominique (DM)','Égypte (EG)','Émirats arabes unis (AE)','Équateur (EC)','Érythrée (ER)','Espagne (ES)','Estonie (EE)','États-Unis (US)','Éthiopie (ET)','Finlande (FI)','France (FR)','Géorgie (GE)','Gabon (GA)','Gambie (GM)','Ghana (GH)','Gibraltar (GI)','Grèce (GR)','Grenade (GD)','Groenland (GL)','Guadeloupe (GP)','Guam (GU)','Guatemala (GT)','Guinée (GN)','Guinée équatoriale (GQ)','Guinée-Bissao (GW)','Guyana (GY)','Guyane française (GF)','Haïti (HT)','Honduras (HN)','Hong Kong (HK)','Hongrie (HU)','Iles Cook (CK)','Iles Fidji (FJ)','Iles Marshall (MH)','Iles Salomon (SB)','Inde (IN)','Indonésie (ID)','Iran (IR)','Iraq (IQ)','Irlande (IE)','Islande (IS)','Israël (IL)','Italie (IT)','Jamaïque (JM)','Japon (JP)','Jordanie (JO)','Kazakhstan (KZ)','Kenya (KE)','Kirghizistan (KG)','Kiribati (KI)','Koweït (KW)','Laos (LA)','Lesotho (LS)','Lettonie (LV)','Liban (LB)','Liberia (LR)','Libye (LY)','Liechtenstein (LI)','Lituanie (LT)','Luxembourg (LU)','Madagascar (MG)','Malaisie (MY)','Malawi (MW)','Maldives (MV)','Mali (ML)','Malte (MT)','Maroc (MA)','Maurice (MU)','Mauritanie (MR)','Mexique (MX)','Micronésie (FM)','Moldavie (MD)','Monaco (MC)','Mongolie (MN)','Mozambique (MZ)','Népal (NP)','Namibie (NA)','Nauru (NR)','Nicaragua (NI)','Niger (NE)','Nigeria (NG)','Nioué (NU)','Norvège (NO)','Nouvelle-Zélande (NZ)','Oman (OM)','Ouganda (UG)','Ouzbékistan (UZ)','Pérou (PE)','Pakistan (PK)','Panama (PA)','Papouasie-Nouvelle-Guinée (PG)','Paraguay (PY)','Pays-Bas (NL)','Philippines (PH)','Pologne (PL)','Portugal (PT)','Qatar (QA)','République centrafricaine (CF)','République démocratique du Congo (CD)','République dominicaine (DO)','République tchèque (CZ)','Roumanie (RO)','Royaume-Uni (GB)','Russie (RU)','Rwanda (RW)','Sénégal (SN)','Saint-Christophe-et-Niévès (KN)','Saint-Marin (SM)','Saint-Siège (VA)','Saint-Vincent-et-les-Grenadines (VC)','Sainte-Lucie (LC)','Salvador (SV)','Samoa (WS)','Sao Tomé-et-Principe (ST)','Seychelles (SC)','Sierra Leone (SL)','Singapour (SG)','Slovénie (SI)','Slovaquie (SK)','Somalie (SO)','Soudan (SD)','Sri Lanka (LK)','Suède (SE)','Suisse (CH)','Suriname (SR)','Swaziland (SZ)','Syrie (SY)','Taïwan (TW)','Tadjikistan (TJ)','Tanzanie (TZ)','Tchad (TD)','Thaïlande (TH)','Timor Oriental (TL)','Togo (TG)','Tonga (TO)','Trinité-et-Tobago (VT)','Tunisie (TN)','Turkménistan (TM)','Turquie (TR)','Tuvalu (TV)','Ukraine (UA)','Uruguay (UY)','Vanuatu (VU)','Venezuela (VE)','Viêt Nam (VN)','Yémen (YE)','Zambie (ZM)','Zimbabwe (ZW)','ex-République yougoslave de Macédoine (MK)'); return this[key];");
                            		this.fatherNationality = new Function("key","this.values=new Array('Aucune','Afghan(e)','Sud-africain(e)','Albanais(e)','Algérien(ne)','Allemand(e)','Andorran(e)','Angolais(e)','d&rsquo;Anguilla','d&rsquo;Antarctique','d&rsquo;Antigua-et-Barbuda','des Antilles néerlandaises','Saoudien(nne)','Argentin(e)','Arménien(ne)','d&rsquo;Aruba','Australien(ne)','Autrichien(ne)','Azerbaïdjanais(e)','Bahamien(ne)','Bahreïnien(ne)','Bangladais(e)','Barbadien(ne)','Belge','Belizien(ne)','Béninois(e)','des Bermudes','Bhoutanais(e)','Biélorusse','Birman(e)','Bolivien(ne)','de Bosnie-et-Herzégovine','Botswanais(e)','Brésilien(ne)','du Brunei','Bulgare','Burkinabè','Burundais(e)','Cambodgien(ne)','Camerounais(e)','Canadien(ne)','Cap-Verdien(ne)','Chilien(ne)','Chinois(e)','Chypriote','Colombien(ne)','Comorien(ne)','Congolais(e)','Nord-Coréen(ne)','Sud-Coréen(ne)','Costaricien(ne)','Croate','Cubain(e)','Danois(e)','Djiboutien(ne)','Dominiquais(e)','Égyptien(ne)','des Émirats arabes unis','Équatorien(ne)','Érythréen(ne)','Espagnol(e)','Estonien(ne)','Américain(e)','Éthiopien(ne)','Finlandais(e)','Français(e)','Géorgien(ne)','Gabonais(e)','Gambien(ne)','Ghanéen(ne)','de Gibraltar','Grec(que)','Grenadin(e)','du Groenland','du Guam','Guatemaltèque','Guinéen(ne)','Equato-guinéen(ne)','de Guinée-Bissao','Haïtien(ne)','Hondurien(ne)','de Hong Kong','Hongrois(e)','des Iles Cook (CK)','des Iles Fidji','Marshallais(e)','Salomonais(e)','Indien(ne)','Indonésien(ne)','Iranien(ne)','Iraquien(ne)','Irlandais(e)','Islandais(e)','Israëlien(ne)','Italien(ne)','Ivoirien(ne)','Jamaïquain(e)','Japonais(e)','Jordanien(ne)','Kazakh(e)','Kényan(e)','Kirghize','Kiribatien(ne)','Koweïtien(ne)','Laotien(ne)','du Lesotho','Lettonien(ne)','Libanais(e)','Liberien(ne)','Libyen(ne)','Liechtensteinois(e)','Lituanien(ne)','Luxembourgeois(e)','Malgache','Malaisien(ne)','Malawien(ne)','Maldivien(ne)','Malien(ne)','Maltais(e)','Marocain(e)','Mauricien(ne)','Mauritanien(ne)','Mexicain(e)','Micronésien(ne)','Moldove','Monégasque','Mongolien(ne)','Mozambicain(e)','Népalais(e)','Namibien(ne)','Nauruan(e)','Nicaraguayen(ne)','Nigérien(ne)','Nigérian(ne)','Niuéan(e)','Norvégien(ne)','Néo-Zélandais(e)','Omanais(e)','Ougandais(e)','Ouzbèk(e)','Péruvien(ne)','Pakistanais(e)','Panaméen(ne)','de Papouasie-Nouvelle-Guinée','Paraguayen(ne)','Néerlandais(e)','Philippin(e)','Polonais(e)','Portugais(e)','Qatarien(ne)','Centrafricain(e)','Congolais(e)','Dominicain(e)','Tchèque','Roumain(e)','Britannique','Russe','Rwandais(e)','Sénégalais(e)','de Saint-Christophe-et-Niévès','Saint-Marinais(e)','du Saint-Siège','de Saint-Vincent-et-les-Grenadines','Saint-Lucien(ne)','Salvadorien(ne)','Samoan(e)','de Sao Tomé-et-Principe','Seychellois(e)','de Sierra Leone','Singapourien(ne)','Slovénien(ne)','Slovaque','Somalien(ne)','Soudanais(e)','Sri Lankais(e)','Suèdois(e)','Suisse','Surinamais(e)','Swazi(e)','Syrien(ne)','Taïwanais(e)','Tadjik(e)','Tanzanien(ne)','Tchadien(ne)','Thaïlandais(e)','Est-Timorais(e)','Togolais(e)','Tongan(e)','Trinidadien(ne)','Tunisien(ne)','Turkmène','Turc(que)','Tuvaluan(e)','Ukrainien(ne)','Uruguayen(ne)','Vanuatuan(e)','Venezuelien(ne)','Viêtnamien(ne)','Yéménite','Zambien(ne)','Zimbabwéen(ne)','de l&rsquo;ancienne République yougoslave de Macédoine'); return this[key];");
                                                                                                                    		this.motherBirthDepartment = new Function("key","this.values=new Array('Aucun','Ain','Aisne','Allier','Alpes-de-Haute-Provence','Hautes-Alpes','Alpes-Maritimes','Ardèche','Ardennes','Ariège','Aube','Aude','Aveyron','Bouches-du-Rhône','Calvados','Cantal','Charente','Charente-Maritime','Cher','Corrèze','Corse-du-Sud','Haute-Corse','Côte-d&rsquo;Or','Côtes-d&rsquo;Armor','Creuse','Dordogne','Doubs','Drôme','Eure','Eure-et-Loir','Finistère','Gard','Haute-Garonne','Gers','Gironde','Hérault','Ille-et-Vilaine','Indre','Indre-et-Loire','Isère','Jura','Landes','Loir-et-Cher','Loire','Haute-Loire','Loire-Atlantique','Loiret','Lot','Lot-et-Garonne','Lozère','Maine-et-Loire','Manche','Marne','Haute-Marne','Mayenne','Meurthe-et-Moselle','Meuse','Morbihan','Moselle','Nièvre','Nord','Oise','Orne','Pas-de-Calais','Puy-de-Dôme','Pyrénes-Atlantiques','Hautes-Pyrénées','Pyrénées-Orientales','Bas-Rhin','Haut-Rhin','Rhône','Haute-Saône','Saône-et-Loire','Sarthe','Savoie','Haute-Savoie','Paris','Seine-Maritime','Seine-et-Marne','Yvelines','Deux-Sèvres','Somme','Tarn','Tarn-et-Garonne','Var','Vaucluse','Vendée','Vienne','Haute-Vienne','Vosges','Yonne','Territoire de Belfort','Essonne','Hauts-de-Seine','Seine-Saint-Denis','Val-de-Marne','Val-d&rsquo;Oise','Guadeloupe','Martinique','Guyane','Réunion'); return this[key];");
                            		this.motherBirthCountry = new Function("key","this.values=new Array('Inconnu','Afghanistan (AF)','Afrique du Sud (ZA)','Albanie (AL)','Algérie(DZ)','Allemagne (DE)','Andorre (AD)','Angola (AO)','Anguilla (AI)','Antarctique (AQ)','Antigua-et-Barbuda (AG)','Antilles néerlandaises (AN)','Arabie saoudite (SA)','Argentine (AR)','Arménie (AM)','Aruba (AW)','Australie (AU)','Autriche (AT)','Azerbaïdjan (AZ)','Bénin (BJ)','Bahamas (BS)','Bahreïn (BH)','Bangladesh (BD)','Barbade (BB)','Belau (PW)','Belgique (BE)','Belize (BZ)','Bermudes (BM)','Bhoutan (BT)','Biélorussie (BY)','Birmanie (MM)','Bolivie (BO)','Bosnie-Herzégovine (BA)','Botswana (BW)','Brésil (BR)','Brunei (BN)','Bulgarie (BG)','Burkina Faso (BF)','Burundi (BI)','Côte d&rsquo;Ivoire (CI)','Cambodge (KH)','Cameroun (CM)','Canada (CA)','Cap-Vert (CV)','Chili (CL)','Chine (CN)','Chypre (CY)','Colombie (CO)','Comores (KM)','Congo (CG)','Corée du Nord (KP)','Corée du Sud (KR)','Costa Rica (CR)','Croatie (HR)','Cuba (CU)','Danemark (DK)','Djibouti (DJ)','Dominique (DM)','Égypte (EG)','Émirats arabes unis (AE)','Équateur (EC)','Érythrée (ER)','Espagne (ES)','Estonie (EE)','États-Unis (US)','Éthiopie (ET)','Finlande (FI)','France (FR)','Géorgie (GE)','Gabon (GA)','Gambie (GM)','Ghana (GH)','Gibraltar (GI)','Grèce (GR)','Grenade (GD)','Groenland (GL)','Guadeloupe (GP)','Guam (GU)','Guatemala (GT)','Guinée (GN)','Guinée équatoriale (GQ)','Guinée-Bissao (GW)','Guyana (GY)','Guyane française (GF)','Haïti (HT)','Honduras (HN)','Hong Kong (HK)','Hongrie (HU)','Iles Cook (CK)','Iles Fidji (FJ)','Iles Marshall (MH)','Iles Salomon (SB)','Inde (IN)','Indonésie (ID)','Iran (IR)','Iraq (IQ)','Irlande (IE)','Islande (IS)','Israël (IL)','Italie (IT)','Jamaïque (JM)','Japon (JP)','Jordanie (JO)','Kazakhstan (KZ)','Kenya (KE)','Kirghizistan (KG)','Kiribati (KI)','Koweït (KW)','Laos (LA)','Lesotho (LS)','Lettonie (LV)','Liban (LB)','Liberia (LR)','Libye (LY)','Liechtenstein (LI)','Lituanie (LT)','Luxembourg (LU)','Madagascar (MG)','Malaisie (MY)','Malawi (MW)','Maldives (MV)','Mali (ML)','Malte (MT)','Maroc (MA)','Maurice (MU)','Mauritanie (MR)','Mexique (MX)','Micronésie (FM)','Moldavie (MD)','Monaco (MC)','Mongolie (MN)','Mozambique (MZ)','Népal (NP)','Namibie (NA)','Nauru (NR)','Nicaragua (NI)','Niger (NE)','Nigeria (NG)','Nioué (NU)','Norvège (NO)','Nouvelle-Zélande (NZ)','Oman (OM)','Ouganda (UG)','Ouzbékistan (UZ)','Pérou (PE)','Pakistan (PK)','Panama (PA)','Papouasie-Nouvelle-Guinée (PG)','Paraguay (PY)','Pays-Bas (NL)','Philippines (PH)','Pologne (PL)','Portugal (PT)','Qatar (QA)','République centrafricaine (CF)','République démocratique du Congo (CD)','République dominicaine (DO)','République tchèque (CZ)','Roumanie (RO)','Royaume-Uni (GB)','Russie (RU)','Rwanda (RW)','Sénégal (SN)','Saint-Christophe-et-Niévès (KN)','Saint-Marin (SM)','Saint-Siège (VA)','Saint-Vincent-et-les-Grenadines (VC)','Sainte-Lucie (LC)','Salvador (SV)','Samoa (WS)','Sao Tomé-et-Principe (ST)','Seychelles (SC)','Sierra Leone (SL)','Singapour (SG)','Slovénie (SI)','Slovaquie (SK)','Somalie (SO)','Soudan (SD)','Sri Lanka (LK)','Suède (SE)','Suisse (CH)','Suriname (SR)','Swaziland (SZ)','Syrie (SY)','Taïwan (TW)','Tadjikistan (TJ)','Tanzanie (TZ)','Tchad (TD)','Thaïlande (TH)','Timor Oriental (TL)','Togo (TG)','Tonga (TO)','Trinité-et-Tobago (VT)','Tunisie (TN)','Turkménistan (TM)','Turquie (TR)','Tuvalu (TV)','Ukraine (UA)','Uruguay (UY)','Vanuatu (VU)','Venezuela (VE)','Viêt Nam (VN)','Yémen (YE)','Zambie (ZM)','Zimbabwe (ZW)','ex-République yougoslave de Macédoine (MK)'); return this[key];");
                            		this.motherNationality = new Function("key","this.values=new Array('Aucune','Afghan(e)','Sud-africain(e)','Albanais(e)','Algérien(ne)','Allemand(e)','Andorran(e)','Angolais(e)','d&rsquo;Anguilla','d&rsquo;Antarctique','d&rsquo;Antigua-et-Barbuda','des Antilles néerlandaises','Saoudien(nne)','Argentin(e)','Arménien(ne)','d&rsquo;Aruba','Australien(ne)','Autrichien(ne)','Azerbaïdjanais(e)','Bahamien(ne)','Bahreïnien(ne)','Bangladais(e)','Barbadien(ne)','Belge','Belizien(ne)','Béninois(e)','des Bermudes','Bhoutanais(e)','Biélorusse','Birman(e)','Bolivien(ne)','de Bosnie-et-Herzégovine','Botswanais(e)','Brésilien(ne)','du Brunei','Bulgare','Burkinabè','Burundais(e)','Cambodgien(ne)','Camerounais(e)','Canadien(ne)','Cap-Verdien(ne)','Chilien(ne)','Chinois(e)','Chypriote','Colombien(ne)','Comorien(ne)','Congolais(e)','Nord-Coréen(ne)','Sud-Coréen(ne)','Costaricien(ne)','Croate','Cubain(e)','Danois(e)','Djiboutien(ne)','Dominiquais(e)','Égyptien(ne)','des Émirats arabes unis','Équatorien(ne)','Érythréen(ne)','Espagnol(e)','Estonien(ne)','Américain(e)','Éthiopien(ne)','Finlandais(e)','Français(e)','Géorgien(ne)','Gabonais(e)','Gambien(ne)','Ghanéen(ne)','de Gibraltar','Grec(que)','Grenadin(e)','du Groenland','du Guam','Guatemaltèque','Guinéen(ne)','Equato-guinéen(ne)','de Guinée-Bissao','Haïtien(ne)','Hondurien(ne)','de Hong Kong','Hongrois(e)','des Iles Cook (CK)','des Iles Fidji','Marshallais(e)','Salomonais(e)','Indien(ne)','Indonésien(ne)','Iranien(ne)','Iraquien(ne)','Irlandais(e)','Islandais(e)','Israëlien(ne)','Italien(ne)','Ivoirien(ne)','Jamaïquain(e)','Japonais(e)','Jordanien(ne)','Kazakh(e)','Kényan(e)','Kirghize','Kiribatien(ne)','Koweïtien(ne)','Laotien(ne)','du Lesotho','Lettonien(ne)','Libanais(e)','Liberien(ne)','Libyen(ne)','Liechtensteinois(e)','Lituanien(ne)','Luxembourgeois(e)','Malgache','Malaisien(ne)','Malawien(ne)','Maldivien(ne)','Malien(ne)','Maltais(e)','Marocain(e)','Mauricien(ne)','Mauritanien(ne)','Mexicain(e)','Micronésien(ne)','Moldove','Monégasque','Mongolien(ne)','Mozambicain(e)','Népalais(e)','Namibien(ne)','Nauruan(e)','Nicaraguayen(ne)','Nigérien(ne)','Nigérian(ne)','Niuéan(e)','Norvégien(ne)','Néo-Zélandais(e)','Omanais(e)','Ougandais(e)','Ouzbèk(e)','Péruvien(ne)','Pakistanais(e)','Panaméen(ne)','de Papouasie-Nouvelle-Guinée','Paraguayen(ne)','Néerlandais(e)','Philippin(e)','Polonais(e)','Portugais(e)','Qatarien(ne)','Centrafricain(e)','Congolais(e)','Dominicain(e)','Tchèque','Roumain(e)','Britannique','Russe','Rwandais(e)','Sénégalais(e)','de Saint-Christophe-et-Niévès','Saint-Marinais(e)','du Saint-Siège','de Saint-Vincent-et-les-Grenadines','Saint-Lucien(ne)','Salvadorien(ne)','Samoan(e)','de Sao Tomé-et-Principe','Seychellois(e)','de Sierra Leone','Singapourien(ne)','Slovénien(ne)','Slovaque','Somalien(ne)','Soudanais(e)','Sri Lankais(e)','Suèdois(e)','Suisse','Surinamais(e)','Swazi(e)','Syrien(ne)','Taïwanais(e)','Tadjik(e)','Tanzanien(ne)','Tchadien(ne)','Thaïlandais(e)','Est-Timorais(e)','Togolais(e)','Tongan(e)','Trinidadien(ne)','Tunisien(ne)','Turkmène','Turc(que)','Tuvaluan(e)','Ukrainien(ne)','Uruguayen(ne)','Vanuatuan(e)','Venezuelien(ne)','Viêtnamien(ne)','Yéménite','Zambien(ne)','Zimbabwéen(ne)','de l&rsquo;ancienne République yougoslave de Macédoine'); return this[key];");
                                                  		this.childStatus = new Function("key","this.values=new Array('Marié(e)','Célibataire','Divorcé(e)','Veuf(ve)','Concubinage','Autre'); return this[key];");
                                                                        		this.statePupil = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.prefectPupil = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.prefectPupilDepartment = new Function("key","this.values=new Array('Aucun','Ain','Aisne','Allier','Alpes-de-Haute-Provence','Hautes-Alpes','Alpes-Maritimes','Ardèche','Ardennes','Ariège','Aube','Aude','Aveyron','Bouches-du-Rhône','Calvados','Cantal','Charente','Charente-Maritime','Cher','Corrèze','Corse-du-Sud','Haute-Corse','Côte-d&rsquo;Or','Côtes-d&rsquo;Armor','Creuse','Dordogne','Doubs','Drôme','Eure','Eure-et-Loir','Finistère','Gard','Haute-Garonne','Gers','Gironde','Hérault','Ille-et-Vilaine','Indre','Indre-et-Loire','Isère','Jura','Landes','Loir-et-Cher','Loire','Haute-Loire','Loire-Atlantique','Loiret','Lot','Lot-et-Garonne','Lozère','Maine-et-Loire','Manche','Marne','Haute-Marne','Mayenne','Meurthe-et-Moselle','Meuse','Morbihan','Moselle','Nièvre','Nord','Oise','Orne','Pas-de-Calais','Puy-de-Dôme','Pyrénes-Atlantiques','Hautes-Pyrénées','Pyrénées-Orientales','Bas-Rhin','Haut-Rhin','Rhône','Haute-Saône','Saône-et-Loire','Sarthe','Savoie','Haute-Savoie','Paris','Seine-Maritime','Seine-et-Marne','Yvelines','Deux-Sèvres','Somme','Tarn','Tarn-et-Garonne','Var','Vaucluse','Vendée','Vienne','Haute-Vienne','Vosges','Yonne','Territoire de Belfort','Essonne','Hauts-de-Seine','Seine-Saint-Denis','Val-de-Marne','Val-d&rsquo;Oise','Guadeloupe','Martinique','Guyane','Réunion'); return this[key];");
                            		this.childSituation = new Function("key","this.values=new Array('Lycéen(ne)','Collégien(ne)','Etudiant(e)','Salarié(e)','Apprenti(e)','Autre','Inconnue'); return this[key];");
                            		this.childDiploma = new Function("key","this.values=new Array('BAC','BEP','BEPC','Brevet','CFG','CAP','DAEU','DEA','DEUG','Licence','Maîtrise','Inconnu'); return this[key];");
                                                                        		this.japdExemption = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.highlyInfirm = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
                            		this.affectionOrDisease = new Function("key","this.values=new Array('Oui','Non'); return this[key];");
              		}
</script>
 <div class="clear-both"></div>


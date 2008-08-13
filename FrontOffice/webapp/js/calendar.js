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

divCalendar = null;

aujourdhui = new Date();
aujourdhuiJ = aujourdhui.getDate();			//Jour contractuel
aujourdhuiM = aujourdhui.getMonth();		//Mois contractuel
aujourdhuiA = aujourdhui.getFullYear();		//Année contractuellle

cejour = null;
cemois = null;
cetan = null;

firstUse = false;					//Deja une utilisation avec selection de date (o/n)
nav=false;						//Mode navigation (o/n)
navencours=false;					//Navigation en cours (o/n)
nodeVisible=false;					//Visibilité du node TABLE (0/n)

moisSelect=aujourdhuiM;						//Mois selectionné
anSelect=aujourdhuiA;						//Année selectionnée

an = null;
mois = null;
dates = null;

var DateCible;

function fDrawTable(){
	//Def. styles DIV id=calendar
	divCalendar = d.getElementById('calendar'); 
	with(divCalendar.style) {
		if (position == '')
			position = 'absolute';

		width = '182px';
		height = '191px';

		if ((left == 0) && (top== 0)) {
			left = '656px';
			top = '232px';
		}
		
	}

//	Set default values for parameters
	if (divCalendar.img == null) 
		divCalendar.img = '/';

	if (divCalendar.fcolor == null) 
		divCalendar.fcolor = '#0000FF';

	if (divCalendar.bcolor == null) 
		divCalendar.bcolor = '#FFFFFF';
	
	if (divCalendar.scolor == null) 
		divCalendar.scolor = '#FF0000';
	
	if (divCalendar.mode == null) 
		divCalendar.mode = 'rw';

	if (divCalendar.fontsize == null) 
		divCalendar.fontsize = '11px';

	if (divCalendar.cellsize == null) 
		divCalendar.cellsize = '20';

	dates = divCalendar.innerHTML;
	
	if (divCalendar.mode == "rw") { 
		prevMonth = "<div class='link' onClick='fCalendrier(mois-=1,true)' title='Mois précédent'><img src='" + divCalendar.img + "/c_mp.gif' border='0' /></div>";
		nextMonth = "<div class='link' onClick='fCalendrier(mois+=1,true)' title='Mois suivant'><img src='" + divCalendar.img + "/c_ms.gif' border='0' /></div>";
		prevYear = "<div class='link' onClick='fCalendrier(mois-=12,true)' title='Année précédent'><img src='" + divCalendar.img + "/c_mp.gif' border='0' /></div>";
		nextYear = "<div class='link' onClick='fCalendrier(mois+=12,true)' title='Année suivant'><img src='" + divCalendar.img + "/c_ms.gif' border='0' /></div>";
		bottomRight = "<div class='link' onClick='fEraseTable(this,true);' title='Fermer'><img src='" + divCalendar.img + "/c_bdf.gif' border='0' /></div>";
	} else {
		prevMonth = "<div class='link' >&nbsp;</div>";
		nextMonth = "<div class='link' >&nbsp;</div>";
		prevYear = "<div class='link' >&nbsp;</div>";
		nextYear = "<div class='link' >&nbsp;</div>";
		bottomRight = "<div class='link'><img src='" + divCalendar.img + "/c_bd.gif' border='0' /></div>"
	}
	//Structure HTML du tableau Calendrier
	tbHTML = "<table id='tbCal'>"
	+ "<tr><td><img src='" + divCalendar.img + "/c_hg.gif' /></td><td colspan='7'></td><td><img src='" + divCalendar.img + "/c_hd.gif' /></td></tr>"
	+ "<tr><td rowspan='8'>" + prevMonth + "</td><td id='lemois' colspan='7'></td><td rowspan='8'>" + nextMonth + "</td></tr>"
	+ "<tr><td>L</td><td>M</td><td>M</td><td>J</td><td>V</td><td>S</td><td>D</td></tr>"
	+ "<tr><td id='0'></td><td id='1'></td><td id='2'></td><td id='3'></td><td id='4'></td><td id='5'></td><td id='6'></td></tr>"
	+ "<tr><td id='7'></td><td id='8'></td><td id='9'></td><td id='10'></td><td id='11'></td><td id='12'></td><td id='13'></td></tr>"
	+ "<tr><td id='14'></td><td id='15'></td><td id='16'></td><td id='17'></td><td id='18'></td><td id='19'></td><td id='20'></td></tr>"
	+ "<tr><td id='21'></td><td id='22'></td><td id='23'></td><td id='24'></td><td id='25'></td><td id='26'></td><td id='27'></td></tr>"
	+ "<tr><td id='28'></td><td id='29'></td><td id='30'></td><td id='31'></td><td id='32'></td><td id='33'></td><td id='34'></td></tr>"
	+ "<tr><td id='35'></td><td id='36'></td><td id='37'></td><td id='38'></td><td id='39'></td><td id='40'></td><td id='41'></td></tr>"
	+ "<tr><td>" + prevYear + "</td><td id='lannee' colspan='7'></td><td>" + nextYear + "</td></tr>"
	+ "<tr><td><img src='" + divCalendar.img + "/c_bg.gif' /></td><td colspan='7'></td><td>" + bottomRight + "</td></tr>"
	+ "</table>";
	
	divCalendar.innerHTML	= tbHTML;	// Ecriture du tableau dans le DIV id=calendar

	eTBL = d.getElementById('tbCal');				// Element TABLE id=tbCal
	cTR = eTBL.getElementsByTagName('tr');			// Collection des TR de la TABLE

	cTD = new Array();			// Collection des TD ligne par ligne
	for (i = 0; i < cTR.length; i++){
		cTD[i] = cTR[i].getElementsByTagName('td');
	}

	tabWidth = 	7 * divCalendar.cellsize;
	tabHeight = 8 * divCalendar.cellsize;
	calWidth = tabWidth + 2 * 21;
	calHeight = tabHeight  + 2 * (11 + 20);
	
	//Def. style TABLE
	with(eTBL.style) {
		width = calWidth + 'px';
		height = calHeight + 'px';
		borderCollapse = 'collapse';
		fontFamily = 'sans-serif';
		fontSize = divCalendar.fontsize;
		background = divCalendar.bcolor;
	}
	//Def. style TABLE : TR 1
	with(cTR[0].style) {
		width = calWidth + 'px';
		height = '11px';
		borderSpacing = '0px';
		padding = '0px';
	}
	//Def. style TABLE : TDs : TR_1
	with(cTD[0].item(0).style) {
		width = '21px';
		height = '11px';
		borderSpacing = '0px';
		padding = '0px';
		textAlign = 'left';
		verticalAlign = 'top';
	}
	with(cTD[0].item(1).style) {
		width = tabWidth + 'px';
		height = '11px';
		borderSpacing = '0px';
		emptyCells = 'show';
		borderTopStyle = 'solid';
		borderTopWidth = '1px'
		borderColor = '#8183A2';
		padding = '0px';
	}
	with(cTD[0].item(2).style) {
		width = '21px';
		height = '11px';
		borderSpacing = '0px';
		padding = '0px';
		textAlign = 'right';
		verticalAlign = 'top';
	}

	//Def. style TABLE : TR 2
	with(cTR[1].style) {
		width = calWidth + 'px';
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		padding = '0px';
		fontSize = '16px';
		fontWeight = 'bold'
	}
	//Def. style TABLE : TDs : TR_2
	with(cTD[1].item(0).style) {
		width = '21px';
		height = tabHeight + 'px';
		borderSpacing = '0px';
		borderLeftStyle = 'solid';
		borderLeftWidth = '1px'
		borderColor = '#8183A2';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'top';
	}
	with(cTD[1].item(1).style) {
		width = tabWidth + 'px';
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		emptyCells = 'show';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'middle';
	}
	with(cTD[1].item(2).style) {
		width = '21px';
		height = tabHeight + 'px';
		borderSpacing = '0px';
		borderRightStyle = 'solid';
		borderRightWidth = '1px'
		borderColor = '#8183A2';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'top';
	}

	//Def. style TABLE : TR 3
	with(cTR[2].style) {
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		padding = '0px';
		fontWeight = 'bold'
		textAlign = 'center';
		verticalAlign = 'middle';
	}
	//Def. style TABLE : TDs : TR_3
	for (i=0;i<7;i++) {
		with(cTD[2].item(i).style) {
			width = divCalendar.cellsize + 'px';
			height = divCalendar.cellsize + 'px';
			borderSpacing = '0px';
			padding = '0px';
		}
	}

	//Def. style TABLE : TR 4 --> TR 9
	for (i=3;i<9;i++) {
		with(cTR[i].style) {
			height = divCalendar.cellsize + 'px';
			borderSpacing = '0px';
			padding = '0px';
			textAlign = 'center';
			verticalAlign = 'middle';
		}
		//Def. style TABLE : TDs : TR_4 --> TR_9
		for (j=0;j<7;j++){
			with(cTD[i].item(j).style) {
				width = divCalendar.cellsize + 'px';
				height = divCalendar.cellsize + 'px';
				borderSpacing = '0px';
				padding = '0px';
			}
		}
	}

	//Def. style TABLE : TR 10
	with(cTR[9].style) {
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		padding = '0px';
		fontSize = '16px';
		fontWeight = 'bold'
	}

	//Def. style TABLE : TDs : TR_10
	with(cTD[9].item(0).style) {
		width = '21px';
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		borderLeftStyle = 'solid';
		borderLeftWidth = '1px'
		borderColor = '#8183A2';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'top';
	}
	with(cTD[9].item(1).style) {
		width = tabWidth + 'px';
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		emptyCells = 'show';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'middle';
	}
	with(cTD[9].item(2).style) {
		width = '21px';
		height = divCalendar.cellsize + 'px';
		borderSpacing = '0px';
		borderRightStyle = 'solid';
		borderRightWidth = '1px'
		borderColor = '#8183A2';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'top';
	}

	//Def. style TABLE : TR 11
	with(cTR[10].style) {
		height = '11px';
		width = calWidth + 'px';
		borderSpacing = '0px';
		padding = '0px';
	}
	//Def. style TABLE : TDs : TR_11
	with(cTD[10].item(0).style) {
		width = '21px';
		height = '11px';
		borderSpacing = '0px';
		padding = '0px';
		textAlign = 'left';
		verticalAlign = 'bottom';
	}
	with(cTD[10].item(1).style) {
		width = tabWidth + 'px';
		height = '11px';
		borderSpacing = '0px';
		borderBottomStyle = 'solid';
		borderBottomWidth = '1px'
		borderColor = '#8183A2';
		emptyCells = 'show';
		padding = '0px';
		textAlign = 'center';
		verticalAlign = 'middle';
	}
	with(cTD[10].item(2).style) {
		width = '21px';
		height = '11px';
		borderSpacing = '0px';
		padding = '0px';
		textAlign = 'right';
		verticalAlign = 'bottom';
	}

}

function fShowTable(DateDeLaCible, pmois) {
	DateCible = DateDeLaCible;
	//Si le calendrier n'est pas affiché
	if (!nodeVisible) {
		// Si il y a eu précédement une selection de date
		//on insère le clone de tabNode.
		if (firstUse){
			divCalendar.appendChild(tabNodeCopy);
			nodeVisible = true;		//Le node est affiché donc visible

		// Sinon, on dessine la table et on passe au remplissage du calendrier
		} else {
			fDrawTable();		//Affichage du tableau
			fCalendrier(pmois, true);		//Remplissage
		}
	}
}

function fCalendrier(pmois,nav) {
	tMois = new Array('Janvier','Février','Mars','Avril','Mai','Juin','Juillet','Août','Septembre','Octobre','Novembre','Décembre');
	dNow = new Date();			//Récupération de la date courante

	if (nav && !navencours){	//Si mode navigation enclenché et qu'il n'y à pas de navigation en cours
		tabNode = divCalendar.firstChild;	//Préserver le node avec le valeurs précédentes
		tabNodeCopy = tabNode.cloneNode(true);		//Puis le cloner
		navencours=true;				//La navigation est en cours
	}

	//Navigation du calendrier
	if (mois == null) {
		mois = dNow.getMonth();		//Mois courant
		an = dNow.getFullYear();	//Année courante
	}
	if (pmois != null) {
		if (pmois<0){
			an = dNow.getFullYear(dNow.setFullYear(an-1));
			mois = dNow.getMonth(dNow.setMonth(pmois+12));
		} else if (pmois>11){
			an = dNow.getFullYear(dNow.setFullYear(an+1));
			mois = dNow.getMonth(dNow.setMonth(pmois-12));
		} else {
			an = dNow.getFullYear(dNow.setFullYear(an));
			mois = dNow.getMonth(dNow.setMonth(pmois));
		}
	}

	//Affichage des informations Mois et Année
	d.getElementById('lemois').innerHTML = tMois[mois];		//Affichage du mois
	d.getElementById('lannee').innerHTML = an;				//Affichage de l'année

	ijour = 1;					//Initialisation de l'index du premiser jour du mois
	dNow.setDate(ijour);		//Initialisation du jour du mois à l'index

	//Effacer le contenu de toutes les cellule du calendrier (de id=0 à id=41)
	for(i=0;i<42;i++) {
		d.getElementById(i).innerHTML = "";
	}

	//Correlation entre le 1er jour du mois, le jour de la semaine correspondant
	//et la cellule du tableau correspondante
	switch (dNow.getDay()) {
		case 0 : id = 6; break;
		case 1 : id = 0; break;
		case 2 : id = 1; break;
		case 3 : id = 2; break;
		case 4 : id = 3; break;
		case 5 : id = 4; break;
		case 6 : id = 5; break;
	}

	//Ecriture des dates pour le mois (remplissage du tableau avec les date)
	while(mois == dNow.getMonth()) {
		if (divCalendar.mode == 'ro')
			d.getElementById(id).innerHTML = "<div class='link'>" + dNow.getDate() + "</div>";
		else
			d.getElementById(id).innerHTML = "<div class='link' onClick='fEraseTable(this,false);'>" + dNow.getDate() + "</div>";

		if (ijour == aujourdhuiJ && mois == aujourdhuiM && an == aujourdhuiA) {
			//Si le date est la date contractuelle
			with(d.getElementById(id).firstChild.style){
				width = "18px";
//				backgroundColor = "#CCCCCC";
//				color = divCalendar.scolor;
				borderStyle = "solid";
				borderColor = divCalendar.fcolor;
				borderWidth = "1pt";
				textDecoration = "none";
			}
		}

		
		if (dates != null && dates.indexOf("-" + ijour + "-") != -1) {
		//If its the date in the date list
			with(d.getElementById(id).firstChild.style){
				color = divCalendar.scolor;
				backgroundColor = divCalendar.bcolor;
				textDecoration = "none";
				fontWeight = 'bold'
			}
		}
		else if (ijour == Number(cejour) && mois == moisSelect && an == anSelect) {
			//Si le date est celle du jour dernièrement selectionné
			with(d.getElementById(id).firstChild.style){
				color = divCalendar.scolor;
				backgroundColor = divCalendar.bcolor;
				textDecoration = "none";
			}
		} else {
			//Pour toutes les autres dates
			with(d.getElementById(id).firstChild.style){
				color = divCalendar.fcolor;
				backgroundColor = divCalendar.bcolor;
				textDecoration = "none";
			}
		}

		ijour++;
		id++;
		dNow.setDate(ijour);		//Jour suivant
	}
}

function fEraseTable(obj,btnfermer){
	if(btnfermer) {
		//Gestion du node Table id=tbCal si fermeture avec bouton Fermer
		//
		//Efface le node Table
		divCalendar.removeChild(divCalendar.firstChild);

		//Si une date a été selectionnée antérieurement
		if(firstUse){
			an = dNow.getFullYear(dNow.setFullYear(anSelect));	//Initialisation de l'année à l'année selectionnée pour la prochaine navigation
			mois = dNow.getMonth(dNow.setMonth(moisSelect));	//Initialisation du compteur de mois au mois selectionné pour la prochaine navigation
			navencours=false;				//Plus de navigation en cours
			nav=false;						//Desactivation du mode navigation
			nodeVisible = false;			//Le node est supprimé donc invisible
		}

		
		with(d.getElementById('calendar').style) {
			width = '0px';
			height = '0px';
			left = '0px';
			top = '0px';
		}
	} else {
	//Gestion du node Table id=tbCal si fermeture avec click sur une date
	//
	//Met en rouge la date choisie
	obj.style.color = divCalendar.scolor;

	//A partir de maintenant on considère qu'une première utilisation
	//du calendrier avec sélection de date a été faite.
	firstUse=true;

	//Mémorise le mois et l'année selectionnés
	moisSelect = mois;
	anSelect = an;


	//Affichage de la date choisie dans le formulaire
	cejour = obj.innerHTML;
	cejour = (cejour<10)? "0"+cejour : cejour;
	cemois = ((mois+1)<10)? "0"+(mois+1) : mois+1;
	cetan = an;

//	window.alert(document.getElementById(DateCible).getAttribute('id'));
	if (DateCible != null)
		d.getElementById(DateCible).value = cejour + "/" + cemois + "/" + an;

	//Gestion du node Table id=tbCal
	tabNode = divCalendar.firstChild;			//Preserve le node Table
	tabNodeCopy = tabNode.cloneNode(true);				//Clone le node Table
	divCalendar.removeChild(divCalendar.firstChild);	//Efface le node Table
	nav=false;						//On est plus en mode Navigation.
	navencours=false;				//Il n'y a plus de navigation en cours.
	nodeVisible = false;			//Le node est supprimé donc invisible
	an = dNow.getFullYear(dNow.setFullYear(anSelect));	//Initialisation de l'année à l'année selectionnée pour la prochaine navigation
	mois = dNow.getMonth(dNow.setMonth(moisSelect));	//Initialisation du compteur de mois au mois selectionné pour la prochaine navigation
	}
}

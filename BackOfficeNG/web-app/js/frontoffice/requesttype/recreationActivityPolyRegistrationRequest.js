YAHOO.namespace("requesttype.activity");

var ra = YAHOO.requesttype.activity;
var yue = YAHOO.util.Event;
var yuel = YAHOO.util.Element;
var yud = YAHOO.util.Dom;
var yw = YAHOO.widget;
var yuc = YAHOO.util.Connect;



ra.getSelectedId=function ()
{
	
	var newValue;
	var par;
	
	
	var decomposeUrl = zenexity.capdemat.baseUrl.split('/');
	decomposeUrl.pop();
	var recreationActivityUrl = decomposeUrl.join('/');

	
	var optionSelected = yud.get('subjectId'); 
	yue.addListener(optionSelected,"change",changeValue);
	
	function changeValue()
	{ 
		newValue=this.options[this.selectedIndex].value;
		if(newValue != null)
		{
			changeListItem(newValue);
		}
	}
	
	function verifierCaseAcocher(Valeurlabel,nbreFois)
	{
		var nomCheckBox=yud.getElementsByClassName('dataTree');
		
		for(var i=0;i<nomCheckBox.length;i++)
		{
			nomCheckBox[i].id="nom"+i;//creation de l'Id
			var noeud = yud.getChildren(nomCheckBox[i].id);	
			for(var k=0;k<noeud.length;k++)
			{
				
				var filsLi=yud.getChildren(noeud[k]);
				for(var j=0;j<filsLi.length;j++)
				{
					//alert("L'element DOM (" + filsLi[j].tagName + ") vaut  : (" + filsLi[j].value+")");
					if(filsLi[j].tagName=='LABEL' && filsLi[j].innerHTML==Valeurlabel)
					{
						//alert("la valeur de l'element Label est : " +filsLi[j].innerHTML);
						var precedant=yud.getPreviousSibling(filsLi[j]);
						//alert("precedant vaut : " + precedant);
						precedant.disabled=true;
					}
				
				}
			}
			
		}
	}
	
	function decocher()
	{
		var nomCheckBox=yud.getElementsByClassName('dataTree');
		
		for(var i=0;i<nomCheckBox.length;i++)
		{
			nomCheckBox[i].id="nom"+i;//creation de l'Id
			var noeud = yud.getChildren(nomCheckBox[i].id);	
		
			
			for(var k=0;k<noeud.length;k++)
			{
				var filsLi=yud.getChildren(noeud[k]);
				for(var j=0;j<filsLi.length;j++)
				{
					//alert("le type est " + filsLi[j].tagName + "---" + filsLi[j].type);
					
					filsLi[j].disabled=false;
					filsLi[j].enabled=true;
					
				}
			}
			
		}
	}
	
	
	function changeListItem(newValue)
	{
		var onSuccess = function(o){
			
				
				var Tablabel= new Array();
				var racine= o.responseXML.documentElement;
				var label = racine.getElementsByTagName("label");
				var nbfoix=label.length;
				decocher();
				//alert("decocher");
				for(var i = 0; i< label.length; i++)
				{
					var Valeurlabel = label[i].firstChild.nodeValue;
				    verifierCaseAcocher(Valeurlabel,nbfoix);
				}
				 
				
			}
		
		
		var onFailure = function(o){

		};
		
		callbackModif = {
				success: onSuccess,
				failure: onFailure
			};
		
		var result = yuc.asyncRequest("POST", recreationActivityUrl+"/getActivyRegistered?", callbackModif, "par="+newValue);
	}
	
	
	
}


yue.onDOMReady(ra.getSelectedId);

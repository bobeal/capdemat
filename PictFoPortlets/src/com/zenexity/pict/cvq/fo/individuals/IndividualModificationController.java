package com.zenexity.pict.cvq.fo.individuals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

import com.zenexity.pict.cvq.fo.util.EcitizenDataCache;
import com.zenexity.pict.portal.security.PictPrincipal;

import fr.cg95.cvq.business.users.Address;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.SexType;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;



public class IndividualModificationController extends AbstractController {
	
	private EcitizenDataCache ecitizenDataCache = null ;
	
	@Override
	protected void handleActionRequestInternal(ActionRequest arg0, ActionResponse arg1) 
	throws Exception {
		
		PictPrincipal principal = ecitizenDataCache.getPictPrincipal() ;
		String username = principal.getName() ;
		Individual individual = null          ;
		
		String isAdult    = arg0.getParameter("isAdult")    ;
		String id         = arg0.getParameter("id")         ;
		String lastName   = arg0.getParameter("lastname")   ;
		String firstname1 = arg0.getParameter("firstname1") ;
		String firstname2 = arg0.getParameter("firstname2") ;
		String firstname3 = arg0.getParameter("firstname3") ;
		String birthDate  = arg0.getParameter("birthDate")  ; 
		String birthCity  = arg0.getParameter("birthCity")  ; 
		String sex        = arg0.getParameter("sex")        ;
		String address    = arg0.getParameter("adress")     ;
		String city       = arg0.getParameter("city")       ;
		String postalCode = arg0.getParameter("postalCode") ;
		
		
		String birthPostalCode    = arg0.getParameter("birthPostalCode") ;
		Set<Individual> individus = null ;
		
		if((isAdult != null)&&("true".equalsIgnoreCase(isAdult))){
			
			try {
				Adult aux = ecitizenDataCache.getAdultById(id) ;
				
				if(lastName != null && (!"".equals(lastName))&& (!"vide".equalsIgnoreCase(lastName))){
					
					aux.setLastName(lastName.trim()) ;
				}
				if(firstname1 != null && (!"".equals(firstname1))&& (!"vide".equalsIgnoreCase(firstname1))){
					
					aux.setFirstName(firstname1.trim()) ;
					
				}
				if(firstname2 != null && (!"".equals(firstname2))&& (!"vide".equalsIgnoreCase(firstname2))){
					
					aux.setFirstName2(firstname2.trim()) ;
					
				}
				if(firstname3 != null && (!"".equals(firstname3))&& (!"vide".equalsIgnoreCase(firstname3))){
					
					aux.setFirstName3(firstname3.trim()) ;
					
				}
				if(birthCity != null && (!"".equals(birthCity))&& (!"vide".equalsIgnoreCase(birthCity))){
					
					aux.setBirthCity(birthCity.trim()) ;
					
				}
				if(birthPostalCode != null && (!"".equals(birthPostalCode))&& (!"vide".equalsIgnoreCase(birthPostalCode))){
					
					aux.setBirthPostalCode(birthPostalCode.trim()) ;
					
				}
				if(sex != null && (!"".equals(sex))&& (!sex.equals(aux.getSex().toString()))){
					
					aux.setSex(SexType.forString(sex)) ;
					
				}
				
				// TODO Better refactor this, to respect Address Normalisation
				Address adr = aux.getAdress() ;
				if(address != null && (!"".equals(address))&& (!"vide".equalsIgnoreCase(address))){
					
					adr.setStreetName(address.trim()) ;
					
				}
				if(city != null && !"".equals(city)&& (!"vide".equalsIgnoreCase(city))){
					
					adr.setCity(city.trim()) ;
					
				}
				if(postalCode != null && (!"".equals(postalCode))&& (!"vide".equalsIgnoreCase(postalCode))){
					
					adr.setPostalCode(postalCode.trim()) ;
					
				}
				if(birthDate != null && (!"".equals(birthDate))&& (!"vide".equalsIgnoreCase(address))){
					
					aux.setBirthDate(parse(birthDate)) ;
					
				}
				
				aux.setAdress(adr) ;
				
				individus= new HashSet();
				individus.add(aux) ;
				CreationBean bean =  ecitizenDataCache.modify(username,individus,true) ;
				
				if(bean != null){
					
					arg1.setRenderParameter("modifSucces","Votre demande de modification est prise en compte")       ;
				
				}else{
				
					arg1.setRenderParameter("modifSucces","Votre demande de modification n'est pas prise en compte") ;
				
				}
				
				
			} catch (CvqObjectNotFoundException e) {
				//probleme de modification
				arg1.setRenderParameter("modifSucces",e.getMessage()) ;
				
			} catch (CvqException e) {
				//probleme de modification
				arg1.setRenderParameter("modifSucces",e.getMessage()) ;
				
			}
			
		}else if((isAdult != null)&&("false".equalsIgnoreCase(isAdult))){
			
			try {
				Child aux = ecitizenDataCache.getChildById(id) ;
				
				//Pour l'instant une simple verification, penser à utiliser la validation Spring et ajax
				if(lastName != null && (!"".equals(lastName))){
					
					aux.setLastName(lastName.trim()) ;
				}
				if(firstname1 != null && (!"".equals(firstname1))){
					
					aux.setFirstName(firstname1.trim()) ;
					
				}
				if(firstname2 != null && (!"".equals(firstname2))){
					
					aux.setFirstName2(firstname2.trim()) ;
					
				}
				if(firstname3 != null && (!"".equals(firstname3))){
					
					aux.setFirstName3(firstname3.trim()) ;
					
				}
				if(birthCity != null && (!"".equals(birthCity))){
					
					aux.setBirthCity(birthCity.trim()) ;
					
				}
				if(birthPostalCode != null && (!"".equals(birthPostalCode))){
					
					aux.setBirthPostalCode(birthPostalCode.trim()) ;
					
				}
				if(sex != null && (!"".equals(sex))){
					
					aux.setSex(SexType.forString(sex)) ;
					
				}
				// TODO Better refactor this, to respect Address Normalisation
				Address adr = aux.getAdress() ;
				if(address != null && (!"".equals(address))){
					
					adr.setStreetName(address.trim()) ;
					
				}
				if(city != null && (!"".equals(city))){
					
					adr.setCity(city.trim()) ;
					
				}
				if(postalCode != null && (!"".equals(postalCode))){
					
					adr.setPostalCode(postalCode.trim()) ;
					
				}
				if(birthDate != null && (!"".equals(birthDate))){
					
					aux.setBirthDate(parse(birthDate)) ;
					
				}
				aux.setAdress(adr) ;
				
				individus= new HashSet();
				individus.add(aux) ;
				CreationBean bean =  ecitizenDataCache.modify(username,individus,false) ;

				if(bean != null){
					
					arg1.setRenderParameter("modifSucces","Votre demande de modification est prise en compte")       ;
					
				}else{
					
					arg1.setRenderParameter("modifSucces","Votre demande de modification n'est pas prise en compte") ;
				}
				
				
			} catch (CvqObjectNotFoundException e) {
				// modification probleme  
				arg1.setRenderParameter("modifSucces",e.getMessage()) ;
			} catch (CvqException e) {
				// modification probleme 
				arg1.setRenderParameter("modifSucces",e.getMessage()) ;
				
			}
		}
		
	}
	
	/**
	 * Cette methode parse une string et retourne un Objet java.util.Date
	 * @param dt la string à parser 
	 * @return la date correspondante
	 * @throws Exception en cas de probleme de parsing
	 */
	private Date parse(String dt)throws Exception{
		
		StringTokenizer tokenizer = new StringTokenizer(dt) ;
		String pattern = "dd/mm/yyyy"            ;
		String day     = tokenizer.nextToken()   ;
		String month   = tokenizer.nextToken()   ;
		String year    = tokenizer.nextToken()   ;
		int numMonth   = getMonthNum(month)      ;
		
		String fullMonth = null      ;
		
		if(numMonth<10){
			
			fullMonth = "0"+numMonth ;
			
		}else{
			
			fullMonth = numMonth+"" ;
			
		}
		
		SimpleDateFormat df = new SimpleDateFormat(pattern) ;
		
		return df.parse(day+"/"+fullMonth+"/"+year) ;
		
	}
	
	/**
	 * Methode pour retourner le nummero d'un moi à partir de son nom
	 * @param month le nom du moi en question
	 * @return  son numero
	 */
	private int getMonthNum(String month) {
		int numMonth = 0 ;
		
		if(month.equalsIgnoreCase("janvier")){
			numMonth = 1 ;
		}else if(month.equalsIgnoreCase("février")||(month.equalsIgnoreCase("fevrier")) ){
			numMonth = 2 ;
		}else if(month.equalsIgnoreCase("mars")){
			numMonth = 3 ;
		}else if(month.equalsIgnoreCase("avril")){
			numMonth = 4 ;
		}else if(month.equalsIgnoreCase("mai")){
			numMonth = 5 ;
		}else if(month.equalsIgnoreCase("juin")){
			numMonth = 6 ;
		}else if(month.equalsIgnoreCase("juillet")){
			numMonth = 7 ;
		}else if(month.equalsIgnoreCase("aout")||month.equalsIgnoreCase("août")){
			numMonth = 8 ;
		}else if(month.equalsIgnoreCase("séptembre")||(month.equalsIgnoreCase("septembre"))){
			numMonth = 9 ;
		}else if(month.equalsIgnoreCase("octobre")){
			numMonth = 10 ;
		}else if(month.equalsIgnoreCase("novembre")){
			numMonth = 11 ;
		}else if(month.equalsIgnoreCase("décembre")||(month.equalsIgnoreCase("decembre"))){
			numMonth = 12 ;
		}else{
			throw new IllegalArgumentException("Le moi entré n'est pas correct.") ;
		}
		return numMonth;
	}
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest arg0, RenderResponse arg1) 
	throws Exception {
		String modifSucces = arg0.getParameter("modifSucces") ;
		
		if(modifSucces == null){
			modifSucces = "la modification n'est pas prise en compte,Vous avez deja une demande en cours" ;
		}
		
		return new ModelAndView("confirmationModification","message",modifSucces) ;
		
		
	}
	
	/**
	 * Setter pour le champ ecitizenDataCache, pour que Spring l'initialise pour nous 
	 * @param ecitizenDataCache le cache à initialiser
	 */
	public void setEcitizenDataCache(EcitizenDataCache ecitizenDataCache) {
		this.ecitizenDataCache = ecitizenDataCache;
	}
	
	
	
}
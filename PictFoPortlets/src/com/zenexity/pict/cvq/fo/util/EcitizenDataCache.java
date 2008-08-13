package com.zenexity.pict.cvq.fo.util;

import java.security.AccessController;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zenexity.pict.portal.security.PictPrincipal;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.Document;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.Request;
import fr.cg95.cvq.business.users.RequestState;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;

public class EcitizenDataCache {
	
	public static final String HOME_FOLDER_ID_KEY = "homeFolderId";
	
	private static Map<String, Map<String, Object>> ecitizenCache = new HashMap<String, Map<String, Object>>();

	private static Log logger = LogFactory.getLog(EcitizenDataCache.class);
	
	private FoHttpInvoker foHttpInvoker;
	
	public synchronized void initHomeFolder(String username) throws Exception {
		
		Map ecitizenMap = ecitizenCache.get(username);
		if (ecitizenMap == null) {
			ecitizenMap = new HashMap<String, Object>();
			ecitizenCache.put(username, ecitizenMap);
		} else {
			ecitizenMap.clear();
		}
		
		String homeFolderId = foHttpInvoker.getHomeFolderId(username);
		ecitizenMap.put(HOME_FOLDER_ID_KEY, homeFolderId);
		Set<Adult> adults = foHttpInvoker.getAdults(username, Long.valueOf(homeFolderId));
		for (Adult adult:adults) {
			if (adult.getLogin().equals(username)) {
				ecitizenMap.put("currentUserId", adult.getId());
				break;
			}
		}
		ecitizenMap.put("adults", adults);
		ecitizenMap.put("children", foHttpInvoker.getChildren(username, Long
				.valueOf(homeFolderId)));
		ecitizenMap.put("homeFolderDocuments", 
				foHttpInvoker.getHomeFolderDocuments(username, Long.valueOf(homeFolderId)));

		fillRequestsCache(username);
	}
	
	public void releaseHomeFolder() throws Exception {
		
		PictPrincipal cvqPrincipal = getPictPrincipal();
		ecitizenCache.remove(cvqPrincipal.getName());
	}
	
	public void refreshRequestsCache(final String username) 
		throws Exception {
		fillRequestsCache(username);
	}
	
	private synchronized void fillRequestsCache(final String username)
		throws Exception {

		Map ecitizenMap = ecitizenCache.get(username);
		if (ecitizenMap == null)
			return;

		String homeFolderId = (String) ecitizenMap.get(HOME_FOLDER_ID_KEY);

		Set<Request> inprogressRequests = new HashSet<Request>();
		Set<Request> acceptedRequests = new HashSet<Request>();
		Set<Request> archivedRequests = new HashSet<Request>();
		Set<Request> failedRequests = new HashSet<Request>();
		Set<Request> requests = 
			foHttpInvoker.getHomeFolderRequests(username, Long.valueOf(homeFolderId));
		for (Request cvqRequest : requests) {
			if (cvqRequest.getState().toString().equals(RequestState.PENDING.toString())
					|| cvqRequest.getState().toString().equals(RequestState.COMPLETE.toString())
					|| cvqRequest.getState().toString().equals(RequestState.UNCOMPLETE.toString())) {
				inprogressRequests.add(cvqRequest);
			} else if (cvqRequest.getState().toString().equals(RequestState.VALIDATED.toString())
					|| cvqRequest.getState().toString().equals(RequestState.NOTIFIED.toString())
					|| cvqRequest.getState().toString().equals(RequestState.CLOSED.toString())) {
				acceptedRequests.add(cvqRequest);
			} else if (cvqRequest.getState().toString().equals(RequestState.ARCHIVED.toString())) {
				archivedRequests.add(cvqRequest);
			} else if (cvqRequest.getState().toString().equals(RequestState.CANCELLED.toString())
					|| cvqRequest.getState().toString().equals(RequestState.REJECTED.toString())) {
				failedRequests.add(cvqRequest);
			}
		}

		ecitizenMap.put("inprogressRequests", inprogressRequests);
		ecitizenMap.put("acceptedRequests", acceptedRequests);
		ecitizenMap.put("archivedRequests", archivedRequests);
		ecitizenMap.put("failedRequests", failedRequests);
		
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Object getObject(String key) throws Exception {
		
		PictPrincipal cvqPrincipal = getPictPrincipal();
		Map ecitizenMap = ecitizenCache.get(cvqPrincipal.getName());
		if (ecitizenMap == null)
			return null;
		else
			return ecitizenMap.get(key);
	}
	
	/**
	 * This method retrieves informations about the connected user
	 * @return
	 * @throws Exception
	 */
	public PictPrincipal getPictPrincipal() throws Exception {
		Subject subject = Subject.getSubject(AccessController.getContext());
		PictPrincipal cvqPrincipal = PictPrincipal.get(subject);
		return cvqPrincipal;
	}
	
	/**
	 * This method retrieves an Adult by his id 
	 * @param homeFolderAdults l'ensemble des adultes du foyer
	 * @param adultId l'identificateur de l'adulte
	 * @return l'adulte dont l'identificateur est passe en parametre
	 */
	private Adult extractAdultFromSet(final Set homeFolderAdults, final String adultId) {
		
		for (Object a:homeFolderAdults){
			if (a instanceof Adult) {
				Adult aux = (Adult) a;
				if (aux.getId().equals(Long.valueOf(adultId))) {
				   return aux;
			   }
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public Long getIndividualId(String userName,String key)throws Exception{
		
		Set adults =(Set) getObject(key) ; 
		
		for(Object a:adults){
			if(a instanceof Adult){
				Adult aux = (Adult)a ;
			   
				if(aux.getLogin().equals(userName)){
				   return aux.getId() ;
			   }
			}
		}
			
		return null ;

	}
	
	/**
	 * This method retrieves an Adult by his id and folder's responsable id
	 * @param key la cle
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Adult getAdultByKeyAndId(final String key, final String id) 
		throws Exception {
		
		Map ecitizenMap = ecitizenCache.get(key);
		if (ecitizenMap == null)
			return null;

		Set adults = (Set) ecitizenMap.get("adults");
		return extractAdultFromSet(adults, id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Adult getAdultById(String id)
		throws Exception {
		
		Set adults = (Set) getObject("adults");
		return extractAdultFromSet(adults, id);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Child getChildById(String id)throws Exception{
		
		Set children =(Set) getObject("children") ; 
		
		for(Object a:children){
			if(a instanceof Child){
				Child aux = (Child)a ;
			   
				if(aux.getId().equals(Long.valueOf(id))){
				  return aux ;
			   }
			}
		}
		return null ;
	}
	
	/**
	 * This method modifies a giving individual
	 * @param username 
	 * @param individus
	 * @param isAdult
	 * @return
	 * @throws CvqException
	 * @throws CvqObjectNotFoundException
	 * @throws Exception
	 */
	public CreationBean modify(String username, Set<Individual> individus,boolean isAdult)
		throws CvqException, CvqObjectNotFoundException,Exception {
		
		Long homeFolderId = Long.valueOf(foHttpInvoker.getHomeFolderId(username)) ;
		CreationBean aux  = null  ;
		
		if(isAdult){
		
			Long requesterId  = getIndividualId(username,"adults") ;
			 aux = foHttpInvoker.modify(username,homeFolderId,requesterId,individus,true) ;
			 if(aux != null){
				 if(logger.isInfoEnabled()){
					 logger.info("["+this.getClass().getName()+" ]  Modification effectuee avec succes") ;
				 
				 }
			 }
		}else if(!isAdult){
			Long requesterId  = getIndividualId(username,"children") ;
			aux = foHttpInvoker.modify(username,homeFolderId,requesterId,individus,false);
					
			if(logger.isInfoEnabled()){
				 logger.info("["+this.getClass().getName()+" ]  Modification effectuee avec succes") ;
				 
			 }
		}
		
		if (aux != null ) {			
			fillRequestsCache(username);
		 }
		
		return aux ;
	}
	
	/**
	 * 
	 * @param key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Document getDocumentByKeyAndId(final String key, final String id) 
		throws Exception {
		
		Map ecitizenMap = ecitizenCache.get(key);
		if (ecitizenMap == null)
			return null;

		Set<Document> homeFolderDocuments = (Set<Document>) ecitizenMap.get("homeFolderDocuments");
		for (Document document: homeFolderDocuments) {
			if (document.getId().longValue() == Long.valueOf(id)) {
				return document;
			}
		}
		
		return null;
	}
	
	/**
	 * Finds up the individual's documents
	 * @param name
	 * @param individualId
	 * @return
	 * @throws CvqException
	 * @throws CvqObjectNotFoundException
	 */
	public Set getIndividualDocuments(String name,Long individualId)
	throws CvqException{
		
		return foHttpInvoker.getIndividualDocuments(name,individualId) ;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getCurrentUser() 
		throws Exception {
		
		return getPictPrincipal().getName();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public Long getUserId(final String name) {
		
		Map ecitizenMap = ecitizenCache.get(name);
		if (ecitizenMap == null)
			return null;

		return (Long) ecitizenMap.get("currentUserId");
	}
	
	public boolean hasConsumptions(final String name,final String requestLabel)
     throws CvqException{
		 return foHttpInvoker.hasConsumptions(name,requestLabel) ;
	 }
	
	public Set getBySubjectId(final String name,final Long subjectId)
    throws CvqException, CvqObjectNotFoundException{
		
		return foHttpInvoker.getBySubjectId(name,subjectId) ;
	}
	
	public Map getConsumptionsByRequest(final String name,final Long requestId,final Date dateFrom,final Date dateTo) 
	 throws CvqException{
		 
		 return foHttpInvoker.getConsumptionsByRequest(name,requestId,dateFrom,dateTo) ;
		 
	 }
    
	/**
	 * 
	 * @param foHttpInvoker
	 */
	public void setFoHttpInvoker(FoHttpInvoker foHttpInvoker) {
		this.foHttpInvoker = foHttpInvoker;
	}
	
	//Interationnalisation service
	public  String getElementTranslation(final String name,final String className, final String elementName,
			final String lang) {
		
		return foHttpInvoker.getElementTranslation(name,className,elementName,lang) ;
	}
	
	public  String getEnumElementTranslation(final String name,final String className, final String elementName,
			final String enumValue, final String lang) {
		
		return foHttpInvoker.getEnumElementTranslation(name,className,elementName,enumValue,lang) ;
	}
}

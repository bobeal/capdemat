package com.zenexity.pict.cvq.fo.util;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import fr.cg95.cvq.business.election.ElectoralRollRegistrationRequest;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.CreationBean;
import fr.cg95.cvq.business.users.DocumentBinary;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.exporter.service.fo.IDocumentService;
import fr.cg95.cvq.exporter.service.fo.IHomeFolderService;
import fr.cg95.cvq.exporter.service.fo.IIndividualService;
import fr.cg95.cvq.exporter.service.fo.IRequestService;
import fr.cg95.cvq.exporter.service.localization.ILocalizationService;

public class FoHttpInvoker {
	
	private String serviceUrl;
	private String contextPath;
	
	public FoHttpInvoker() {
	}
	
	protected IHomeFolderService getHomeFolderService(final String name) {
		
		String url = serviceUrl + contextPath + "/HomeFolderService";
		
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceInterface(IHomeFolderService.class);
		invoker.setServiceUrl(url);
		FoHttpInvokerRequestExecutor requestExecutor = new FoHttpInvokerRequestExecutor();
		requestExecutor.setName(name);
		invoker.setHttpInvokerRequestExecutor(requestExecutor);
		try {
			invoker.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return (IHomeFolderService) invoker.getObject();
	}
	
	protected ILocalizationService getLocalizationService(final String name) {
		
		String url = serviceUrl + contextPath + "/LocalizationService";
		
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceInterface(ILocalizationService.class);
		invoker.setServiceUrl(url);
		FoHttpInvokerRequestExecutor requestExecutor = new FoHttpInvokerRequestExecutor();
		requestExecutor.setName(name);
		invoker.setHttpInvokerRequestExecutor(requestExecutor);
		try {
			invoker.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return (ILocalizationService) invoker.getObject();
	}
	
	protected IRequestService getRequestService(final String name) {
		
		String url = serviceUrl + contextPath + "/RequestService";
		
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceInterface(IRequestService.class);
		invoker.setServiceUrl(url);
		FoHttpInvokerRequestExecutor requestExecutor = new FoHttpInvokerRequestExecutor();
		requestExecutor.setName(name);
		invoker.setHttpInvokerRequestExecutor(requestExecutor);
		try {
			invoker.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return (IRequestService) invoker.getObject();
	}
	protected IDocumentService getDocumentService(final String name) {
		
		String url = serviceUrl + contextPath + "/DocumentService";
		
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceInterface(IDocumentService.class);
		invoker.setServiceUrl(url);
		FoHttpInvokerRequestExecutor requestExecutor = new FoHttpInvokerRequestExecutor();
		requestExecutor.setName(name);
		invoker.setHttpInvokerRequestExecutor(requestExecutor);
		try {
			invoker.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return (IDocumentService) invoker.getObject();
	}
	
	protected IIndividualService getIndividualService(final String name) {
		
		String url = serviceUrl + contextPath + "/IndividualService";
		
		HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
		invoker.setServiceInterface(IIndividualService.class);
		invoker.setServiceUrl(url);
		FoHttpInvokerRequestExecutor requestExecutor = new FoHttpInvokerRequestExecutor();
		requestExecutor.setName(name);
		invoker.setHttpInvokerRequestExecutor(requestExecutor);
		try {
			invoker.afterPropertiesSet();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return (IIndividualService) invoker.getObject();
	}
	
	public String getHomeFolderId(final String name) 
	throws CvqException {
		
		IIndividualService individualService = getIndividualService(name);
		return individualService.getByLogin(name).getHomeFolder().getId().toString();
	}
	
	public Set<Adult> getAdults(final String name, final Long homeFolderId) 
	throws CvqException {
		
		IHomeFolderService homeFolderService = getHomeFolderService(name);
		return homeFolderService.getAdults(homeFolderId);
	}
	
	public Set getChildren(final String name, final Long homeFolderId)
	throws CvqException {
		
		IHomeFolderService homeFolderService = getHomeFolderService(name);
		return homeFolderService.getChildren(homeFolderId);
	}
	
	public Set getHomeFolderDocuments(final String name, final Long homeFolderId)
	throws CvqException {
		
		IHomeFolderService homeFolderService = getHomeFolderService(name);
		return homeFolderService.getAssociatedDocuments(homeFolderId);
	}
	
	public Set getIndividualDocuments(final String name,final Long individualId)
	throws CvqException,CvqObjectNotFoundException{
		
		IIndividualService indiviudalService = getIndividualService(name);
		
		return indiviudalService.getAssociatedDocuments(individualId) ;
	}
	
	public Set<DocumentBinary> getDocumentData(final String name, final Long documentId) 
	throws CvqException {
		
		IDocumentService documentService = getDocumentService(name);
		return documentService.getAllPages(documentId);
	}
	
	public Set getHomeFolderRequests(final String name, final Long homeFolderId)
	throws CvqException {
		
		IRequestService requestService = getRequestService(name);
		return requestService.getByHomeFolderId(homeFolderId);
	}
	
	
	// TEMP
	public Long createElectoralRollRegistrationRequest(final ElectoralRollRegistrationRequest request,
			final String requesterName, final Long requesterId, final Long subjectId)
	throws CvqException {
		
		IRequestService requestService = getRequestService(requesterName);
		return requestService.createElectoralRollRegistrationRequest(request, requesterId, subjectId);
	}
	
	public void addDocumentsToRequest(final String requesterName, final Long requestId, 
			final Set documentsSet) 	throws CvqException {
		
		IRequestService requestService = getRequestService(requesterName);
		requestService.addDocuments(requestId, documentsSet);
	}
	
	public CreationBean modify(final String name,final Long homeFolderId,final Long requesterId,final Set individus,boolean isAdult)
	throws CvqException, CvqObjectNotFoundException {
		
		return getIndividualService(name).modify(homeFolderId,requesterId,individus,isAdult) ;
		
	}
	
	public void setServiceUrl(final String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	
	public boolean hasConsumptions(final String name,final String requestLabel)
	throws CvqException{
		IRequestService reqService = getRequestService(name) ;
		
		return reqService.hasConsumptions(requestLabel) ;
	}
	
	public Set getBySubjectId(final String name,final Long subjectId)
	throws CvqException, CvqObjectNotFoundException {
		
		return getRequestService(name).getBySubjectId(subjectId) ;
	}
	
	public Map getConsumptionsByRequest(final String name,final Long requestId,final Date dateFrom,final Date dateTo) 
	throws CvqException{
		
		return getRequestService(name).getConsumptionsByRequest(requestId,dateFrom,dateTo) ;
		
	}
	
	//Interationnalisation service
	public  String getElementTranslation(final String name,final String className, final String elementName,
			final String lang) {
		
		return getLocalizationService(name).getElementTranslation(className,elementName,lang) ;
	}
	
	public  String getEnumElementTranslation(final String name,final String className, final String elementName,
			final String enumValue, final String lang) {
		
		return getLocalizationService(name).getEnumElementTranslation(className,elementName,enumValue,lang) ;
	}
}

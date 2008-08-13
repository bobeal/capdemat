package fr.cg95.cvq.exporter.service.fo.impl;

import java.util.Set;

import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.exporter.service.fo.IDocumentService;

public class DocumentService implements IDocumentService {

	private fr.cg95.cvq.service.users.IDocumentService documentService;
	
	public Set getAllPages(final Long documentId) 
		throws CvqException {
		
		return documentService.getAllPages(documentId);
	}

	public void setDocumentService(
			fr.cg95.cvq.service.users.IDocumentService documentService) {
		this.documentService = documentService;
	}
}

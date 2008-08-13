package fr.cg95.cvq.exporter.service.fo;

import java.util.Set;

import fr.cg95.cvq.exception.CvqException;

public interface IDocumentService {

	Set getAllPages(final Long documentId) 
		throws CvqException;
}

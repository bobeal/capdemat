package fr.cg95.cvq.service.request.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.Child;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.service.request.IRequestExportService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.xml.common.IndividualType;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.SubjectType;

public class RequestExportService implements IRequestExportService {

    private static Logger logger = Logger.getLogger(RequestExportService.class);

    private IUserSearchService userSearchService;

    @Override
    public XmlObject fillRequestXml(Request request)
        throws CvqException {
        XmlObject result = request.modelToXml();
        RequestType xmlRequestType = null;
        try {
            xmlRequestType = (RequestType) result.getClass()
                .getMethod("get" + result.getClass().getSimpleName().replace("DocumentImpl", ""))
                    .invoke(result);
        } catch (IllegalAccessException e) {
            logger.error("fillRequestXml() Illegal access exception while filling request xml");
            throw new CvqException("Illegal access exception while filling request xml");
        } catch (InvocationTargetException e) {
            logger.error("fillRequestXml() Invocation target exception while filling request xml");
            throw new CvqException("Invocation target exception while filling request xml");
        } catch (NoSuchMethodException e) {
            logger.error("fillRequestXml() No such method exception while filling request xml");
            throw new CvqException("No such method exception while filling request xml");
        }
        if (request.getSubjectId() != null) {
            Individual individual = userSearchService.getById(request.getSubjectId());
            SubjectType subject = xmlRequestType.addNewSubject();
            if (individual instanceof Adult) {
                subject.setAdult(((Adult)individual).modelToXml());
            } else if (individual instanceof Child) {
                subject.setChild(((Child)individual).modelToXml());
            }
        }
        if (request.getHomeFolderId() != null) {
            xmlRequestType.addNewHomeFolder()
                .set(userSearchService.getHomeFolderById(request.getHomeFolderId()).modelToXml());
            List<Individual> externalIndividuals =
                userSearchService.getExternalIndividuals(request.getHomeFolderId());
            if (externalIndividuals != null && !externalIndividuals.isEmpty()) {
                IndividualType[] individualsArray = new IndividualType[externalIndividuals.size()];
                int i = 0;
                for (Individual externalIndividual : externalIndividuals) {
                    if (externalIndividual instanceof Adult) {
                        Adult adult = (Adult) externalIndividual;
                        individualsArray[i] = adult.modelToXml();
                    } else if (externalIndividual instanceof Child) {
                        Child child = (Child) externalIndividual;
                        individualsArray[i] = child.modelToXml();
                    }
                    i++;
                }
                xmlRequestType.getHomeFolder().setExternalIndividualsArray(individualsArray);
            }
        }
        if (request.getRequesterId() != null) {
            xmlRequestType.addNewRequester().set(userSearchService.getAdultById(request.getRequesterId()).modelToXml());
        }
        return result;
    }

    public void setUserSearchService(IUserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }
}

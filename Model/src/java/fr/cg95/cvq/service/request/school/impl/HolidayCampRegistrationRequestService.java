package fr.cg95.cvq.service.request.school.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.soap.Fault;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;

import fr.capwebct.capdemat.Activite;
import fr.capwebct.capdemat.ListeActiviteDocument;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.HolidayCampRegistrationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IHolidayCampRegistrationRequestService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

public final class HolidayCampRegistrationRequestService extends RequestService implements IHolidayCampRegistrationRequestService {

    private static Logger logger = Logger.getLogger(HolidayCampRegistrationRequest.class);
    private static String urlws = "http://193.253.39.123:8081/formation/kiosque/web_methode/web_methode.php";
    private static String externalServiceLabel = "Technocarte";
    private String activityType = "SEJ";

    @Autowired
    private IExternalHomeFolderService externalHomeFolderService;
    @Autowired
    private IUserSearchService userSearchService;

    @Override
    public boolean accept(Request request) {
        return request instanceof HolidayCampRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new HolidayCampRegistrationRequest();
    }

    @Override
    public Map<String, String> getHolidayCamps(Long childId) throws CvqObjectNotFoundException {
        String method = "DetailActivites";
        Map<String, String> camps = new HashMap<String, String>();

        // get child info
        Individual child = userSearchService.getById(childId);
        String externalChildId = "";
        if (externalHomeFolderService.getIndividualMapping(child, externalServiceLabel) != null)
            externalChildId = externalHomeFolderService.getIndividualMapping(child, externalServiceLabel).getExternalCapDematId();
        logger.debug("Get externalCapDematId for " + child.getFullName() + " - " + externalChildId);

        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.addElement(new Parameter("idenfantexterne", String.class, externalChildId, null));
        parameters.addElement(new Parameter("typeactivite", String.class, activityType, null));
        parameters.addElement(new Parameter("codeappli", String.class, "Capdemat", null));
        try {
            Call call = new Call();
            String encodingStyleURI = org.apache.soap.Constants.NS_URI_SOAP_ENC;
            call.setEncodingStyleURI(encodingStyleURI);
            call.setTargetObjectURI ("urn:WSPocketTechno2" );
            call.setMethodName(method);
            call.setParams(parameters);
            Response soap_response = call.invoke(new java.net.URL(urlws), "" );

            if (soap_response.generatedFault()) {
                Fault fault = soap_response.getFault ();
                logger.error("Error : " + fault.getFaultString());
                return camps;
            } else {
                Parameter soap_result = soap_response.getReturnValue();
                // add a header to xml return 'xmlns="http://www.capwebct.fr/capdemat"'
                String xmlresult = soap_result.getValue().toString()
                    .replaceFirst("<ListeActivite>", "<ListeActivite xmlns=\"http://www.capwebct.fr/capdemat\">");
                logger.debug("Get soap response for child " + externalChildId);
                // start treatment
                logger.debug("Parse : " + xmlresult);
                
                ListeActiviteDocument document = ListeActiviteDocument.Factory.parse(xmlresult);
                if (document.getListeActivite() != null)
                    for (Activite camp : document.getListeActivite().getActiviteArray()) {
                        camps.put(camp.getIdActivite(), camp.getNomActivite());
                    }
                return camps;
            }
        } catch (XmlException e) {
            logger.error("XmlException : " + e.getMessage() + " : ");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return camps;
    }

}

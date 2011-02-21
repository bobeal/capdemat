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
import fr.capwebct.capdemat.ArretAller;
import fr.capwebct.capdemat.CircuitAller;
import fr.capwebct.capdemat.ListeActiviteDocument;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.LeisureCenterRegistrationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ILeisureCenterRegistrationRequestService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

/**
 * Implementation of the leisure center registration request service.
 * 
 * @author vsi@zenexity.com
 */
public class LeisureCenterRegistrationRequestService extends RequestService implements ILeisureCenterRegistrationRequestService {

    private static Logger logger = Logger.getLogger(LeisureCenterRegistrationRequest.class);
    private static String urlws = "http://193.253.39.123:8081/formation/kiosque/web_methode/web_methode.php";
    private static String externalServiceLabel = "Technocarte";

    @Autowired
    private IExternalHomeFolderService externalHomeFolderService;
    @Autowired
    private IUserSearchService userSearchService;

    @Override
    public void init() {
        LeisureCenterRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
        LeisureCenterRegistrationRequest.conditions.put("estTransport", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(Request request) {
        return request instanceof LeisureCenterRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new LeisureCenterRegistrationRequest();
    }

    public ListeActiviteDocument getActivities(Long childId, String labelActivity) throws CvqObjectNotFoundException {
        String method = "DetailActivites";
        ListeActiviteDocument activities = null;

        // get child info
        Individual child = userSearchService.getById(childId);
        String externalChildId = "";
        if (externalHomeFolderService.getIndividualMapping(child, externalServiceLabel) != null)
            externalChildId = externalHomeFolderService.getIndividualMapping(child, externalServiceLabel).getExternalCapDematId();
        logger.debug("Get externalCapDematId for " + child.getFullName() + " - " + externalChildId);

        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.addElement(new Parameter("idenfantexterne", String.class, externalChildId, null));
        parameters.addElement(new Parameter("typeactivite", String.class, labelActivity, null));
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
                return activities;
            } else {
                Parameter soap_result = soap_response.getReturnValue();
                // add a header to xml return 'xmlns="http://www.capwebct.fr/capdemat"'
                String xmlresult = soap_result.getValue().toString()
                    .replaceFirst("<ListeActivite>", "<ListeActivite xmlns=\"http://www.capwebct.fr/capdemat\">");
                logger.debug("Get soap response for child " + externalChildId);
                // start treatment
                logger.debug("Parse : " + xmlresult);
                
                activities = ListeActiviteDocument.Factory.parse(xmlresult);
            }
        } catch (XmlException e) {
            logger.error("XmlException : " + e.getMessage() + " : ");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return activities;
    }

    @Override
    public Map<String, String> getLeisureCenters(Long childId) throws CvqObjectNotFoundException {
        Map<String, String> centers = new HashMap<String, String>();
        ListeActiviteDocument activities;
        try {
            activities = getActivities(childId, "LOI");
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return centers;
        }
        for (Activite center : activities.getListeActivite().getActiviteArray()) {
            centers.put(center.getIdActivite(), center.getNomActivite());
        }
        return centers;
    }

    @Override
    public Map<String, String> getTransportLines(Long childId) throws CvqObjectNotFoundException {
        Map<String, String> lines = new HashMap<String, String>();
        ListeActiviteDocument activities;
        try {
            activities = getActivities(childId, "TRANS");
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return lines;
        }
        for (CircuitAller line : activities.getListeActivite().getActiviteArray(0).getListeCircuitAller().getCircuitAllerArray()) {
            lines.put(line.getIdCircuitAller(), line.getNomCircuitAller());
        }
        return lines;
    }

    @Override
    public Map<String, String> getTransportStops(Long childId, String lineId) throws CvqObjectNotFoundException {
        Map<String, String> stops = new HashMap<String, String>();
        ListeActiviteDocument activities;
        try {
            activities = getActivities(childId, "TRANS");
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return stops;
        }
        for (CircuitAller line : activities.getListeActivite().getActiviteArray(0).getListeCircuitAller().getCircuitAllerArray()) {
            if (line.getIdCircuitAller().equals(lineId)) {
                for (ArretAller stop : line.getListeArretAller().getArretAllerArray()) {
                    stops.put(stop.getIdArretAller(), stop.getNomArretAller());
                }
                break;
            }
        }
        return stops;
    }
}

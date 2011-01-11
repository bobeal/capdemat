package fr.cg95.cvq.service.request.school.impl;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.soap.SOAPException;
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
import fr.cg95.cvq.business.request.school.SchoolTransportRegistrationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.condition.EqualityListChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.ISchoolTransportRegistrationRequestService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

public class SchoolTransportRegistrationRequestService extends RequestService implements ISchoolTransportRegistrationRequestService {

    private static Logger logger = Logger.getLogger(SchoolTransportRegistrationRequestService.class);

    @Autowired
    private IExternalHomeFolderService externalHomeFolderService;
    @Autowired
    private IUserSearchService userSearchService;

    private String externalServiceLabel = "Technocarte";
    private String url = "http://193.253.39.123:8081/formation/kiosque/web_methode/web_methode.php";
    private String activityType = "TRANS";

    @Override
    public void init() {
        SchoolTransportRegistrationRequest.conditions.put("estMaternelleElementaireAutorisations", new EqualityChecker("true"));
        SchoolTransportRegistrationRequest.conditions.put("autorisation",
                new EqualityListChecker(Arrays.asList("autoriseTiers=AvecTiers", "autoriseFrereOuSoeur=AvecFrereSoeur")));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof SchoolTransportRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new SchoolTransportRegistrationRequest();
    }

    private ListeActiviteDocument getActivityList(String childId) throws NumberFormatException, CvqObjectNotFoundException,
            MalformedURLException, SOAPException, XmlException {
        ListeActiviteDocument activityList = null;

        Call call = new Call();
        call.setEncodingStyleURI(org.apache.soap.Constants.NS_URI_SOAP_ENC);
        call.setTargetObjectURI ("urn:WSPocketTechno2" );
        call.setMethodName("DetailActivites");

        Individual individual = userSearchService.getById(Long.valueOf(childId));

        String externalCapDematId = null;
        try {
            externalCapDematId = externalHomeFolderService.getIndividualMapping(
                externalHomeFolderService.getHomeFolderMapping(externalServiceLabel,
                    individual.getHomeFolder().getId()), individual.getId())
                .getExternalCapDematId();
        } catch (NullPointerException e) {
            externalCapDematId = "";
        }

        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.addElement(new Parameter("idenfantexterne", String.class, externalCapDematId, null));
        parameters.addElement(new Parameter("typeactivite", String.class, activityType, null));
        parameters.addElement(new Parameter("codeappli", String.class, "Capdemat", null));
        call.setParams(parameters);

        Response soapResponse = call.invoke(new java.net.URL(url), "");
        if (soapResponse.generatedFault()) {
            throw new SOAPException("", "Faulty soap response. Technocarte service might be down.");
        } else {
            Parameter soapResult = soapResponse.getReturnValue();
            String xml = soapResult.getValue().toString();

            // Add our namespace to the xml for parsing
            int index = xml.indexOf("<ListeActivite") + "<ListeActivite".length();
            xml = xml.substring(0, index) + " xmlns=\"http://www.capwebct.fr/capdemat\"" + xml.substring(index);
            activityList = ListeActiviteDocument.Factory.parse(xml);
        }

        return activityList;
    }

    @Override
    public Map<String, String> transportLines(String childId) {
        Map<String, String> lines = new HashMap<String, String>();

        ListeActiviteDocument activityList;
        try {
            activityList = getActivityList(childId);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return lines;
        }

        for (Activite activity : activityList.getListeActivite().getActiviteArray()) {
            if (activity.getTypeActivite().equals(activityType)) {
                for (CircuitAller line : activity.getListeCircuitAller().getCircuitAllerArray()) {
                    lines.put(line.getIdCircuitAller(), line.getNomCircuitAller());
                }
                break; // There should be only one transport activity
            }
        }

        return lines;
    }

    @Override
    public Map<String, String> stops(String childId, String lineId) {
        Map<String, String> stops = new HashMap<String, String>();

        ListeActiviteDocument activityList;
        try {
            activityList = getActivityList(childId);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return stops;
        }

        for (Activite activity : activityList.getListeActivite().getActiviteArray()) {
            if (activity.getTypeActivite().equals(activityType)) {
                for (CircuitAller line : activity.getListeCircuitAller().getCircuitAllerArray()) {
                    if (line.getIdCircuitAller().equals(lineId)) {
                        for (ArretAller stop : line.getListeArretAller().getArretAllerArray()) {
                            stops.put(stop.getIdArretAller(), stop.getNomArretAller());
                        }
                        break;
                    }
                }
                break; // There should be only one transport activity
            }
        }

        return stops;
    }
}
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

import fr.capwebct.capdemat.EcoleDerogType;
import fr.capwebct.capdemat.EcoleSecteurType;
import fr.capwebct.capdemat.ListeEcoleDocument;
import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.GlobalSchoolRegistrationRequest;
import fr.cg95.cvq.business.users.Individual;
import fr.cg95.cvq.business.users.external.HomeFolderMapping;
import fr.cg95.cvq.business.users.external.IndividualMapping;
import fr.cg95.cvq.exception.CvqObjectNotFoundException;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;
import fr.cg95.cvq.service.request.school.IGlobalSchoolRegistrationRequestService;
import fr.cg95.cvq.service.users.IUserSearchService;
import fr.cg95.cvq.service.users.external.IExternalHomeFolderService;

public final class GlobalSchoolRegistrationRequestService extends RequestService implements IGlobalSchoolRegistrationRequestService {

    private static String urlws = "http://193.253.39.123:8081/formation/kiosque/web_methode/web_methode.php";
    private static String externalServiceLabel = "Technocarte";
    private static Logger logger = Logger.getLogger(GlobalSchoolRegistrationRequestService.class);

    @Autowired
    private IUserSearchService userSearchService;
    @Autowired
    private IExternalHomeFolderService externalHomeFolderService;

    @Override
    public void init() {
        GlobalSchoolRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
        GlobalSchoolRegistrationRequest.conditions.put("estRestauration", new EqualityChecker("true"));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof GlobalSchoolRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new GlobalSchoolRegistrationRequest();
    }

    @Override
    public Map<String, Map<String, String>> getSchools(Long childId) throws CvqObjectNotFoundException {
        String method = "ListeEcoles";
        Map<String, Map<String,String>> schools = new HashMap<String, Map<String,String>>();

        // get child info
        Individual child = userSearchService.getById(childId);
        String externalChildId = "";
        HomeFolderMapping hfm = externalHomeFolderService.getHomeFolderMapping(externalServiceLabel, child.getHomeFolder().getId());
        if (hfm != null) {
            IndividualMapping im = externalHomeFolderService.getIndividualMapping(hfm, child.getId());
            if (im != null)
                externalChildId = im.getExternalCapDematId();
        }
        logger.debug("Get externalCapDematId for " + child.getFullName() + " - " + externalChildId);

        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.addElement(new Parameter("idenfantexterne", String.class, externalChildId, null));
        parameters.addElement(new Parameter("nrue", String.class, child.getAddress().getStreetNumber(), null));
        parameters.addElement(new Parameter("rivoli", String.class, child.getAddress().getStreetRivoliCode(), null));
        parameters.addElement(new Parameter("cp", String.class, child.getAddress().getPostalCode(), null));
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
                return schools;
            } else {
                Parameter soap_result = soap_response.getReturnValue();
                // add a header to xml return 'xmlns="http://www.capwebct.fr/capdemat"'
                String xmlresult = soap_result.getValue().toString()
                    .replaceFirst("<ListeEcole>", "<ListeEcole xmlns=\"http://www.capwebct.fr/capdemat\">");
                logger.debug("Get soap response for child " + externalChildId + " and rivoli code " + child.getAddress().getStreetRivoliCode());
                // start treatment
                logger.debug("Parse : " + xmlresult);
                ListeEcoleDocument document = ListeEcoleDocument.Factory.parse(xmlresult);
                Map<String, String> schoolSectors = new HashMap<String, String>();
                Map<String, String> schoolDerogs = new HashMap<String, String>();
                if (document.getListeEcole().getListeEcoleSecteur() != null)
                    for (EcoleSecteurType est : document.getListeEcole().getListeEcoleSecteur().getEcoleSecteurArray()) {
                        schoolSectors.put(est.getIdEcoleSecteur(), est.getNomEcoleSecteur());
                    }
                if (document.getListeEcole().getListeEcoleDerog() != null)
                    for (EcoleDerogType edt : document.getListeEcole().getListeEcoleDerog().getEcoleDerogArray()) {
                        schoolDerogs.put(edt.getIdEcoleDerog(), edt.getNomEcoleDerog());
                    }
                schools.put("schoolSectors", schoolSectors);
                schools.put("schoolDerogs", schoolDerogs);
                return schools;
            }
        } catch (XmlException e) {
            logger.error("XmlException : " + e.getMessage() + " : ");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return schools;
    }
}

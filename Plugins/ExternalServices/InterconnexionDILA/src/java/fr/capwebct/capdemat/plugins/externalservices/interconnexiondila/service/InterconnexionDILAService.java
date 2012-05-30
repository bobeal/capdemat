package fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlObject;

import java.text.SimpleDateFormat;

import fr.cg95.cvq.util.mail.impl.MailService;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.civil.impl.BirthCertificateFormatTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.BirthCertificateMotiveTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.BirthDetailsRequestDocumentImpl.BirthDetailsRequestImpl;
import fr.cg95.cvq.xml.request.civil.impl.DeathCertificateFormatTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.DeathCertificateMotiveTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.DeathDetailsRequestDocumentImpl.DeathDetailsRequestImpl;
import fr.cg95.cvq.xml.request.civil.impl.MarriageCertificateFormatTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.MarriageCertificateMotiveTypeImpl;
import fr.cg95.cvq.xml.request.civil.impl.MarriageDetailsRequestDocumentImpl.MarriageDetailsRequestImpl;
import fr.cg95.cvq.xml.request.civil.MarriageRelationshipType;

import fr.cg95.cvq.security.SecurityContext;
import fr.cg95.cvq.service.request.IRequestTypeService;
import fr.cg95.cvq.business.payment.ExternalAccountItem;
import fr.cg95.cvq.business.payment.ExternalDepositAccountItem;
import fr.cg95.cvq.business.payment.ExternalInvoiceItem;
import fr.cg95.cvq.business.payment.PurchaseItem;
import fr.cg95.cvq.exception.CvqConfigurationException;
import fr.cg95.cvq.exception.CvqException;
import fr.cg95.cvq.external.ExternalServiceBean;
import fr.cg95.cvq.external.impl.ExternalProviderServiceAdapter;
import fr.capwebct.capdemat.plugins.externalservices.interconnexiondila.message.*;

class InterconnexionDILAService extends ExternalProviderServiceAdapter {
    private static Logger logger = Logger.getLogger(InterconnexionDILAService.class);
    private String label;
    private MailService mailService;
    private IRequestTypeService requestTypeService;

    private Map<String, ExternalServiceBean> localAuthoritySpecificConfiguration =
        new HashMap<String, ExternalServiceBean>();
    private Map<String, String> globalConfiguration = new HashMap<String, String>();

    public static final String idOriginApp = "A025";
    public static final String idDestinataire = "Hub_Illicom";
    public static final String canalNormal = "NORMAL";
    public static final String typeActeNaissance = "0";
    public static final String typeActeMarriage = "1";
    public static final String typeActeDeces = "2";


    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String sendRequest(XmlObject requestXml) throws CvqException {

        /*  L'indentation de cette méthode est basée sur la profondeur
         *  de chaque élément dans le fichier XML résultant.
         */
            RequestType rt = (RequestType) requestXml;

            String fullId = this.getConfigurationProperty("codeCommune")+"-"+new SimpleDateFormat("yyyyMMdd").format(new Date().getTime())+"-"+StringUtils.leftPad(String.valueOf(rt.getId()), 6, "0");

            MessageType mess = new MessageType();

                HeaderType header = new HeaderType();
                    header.setMessageId(fullId);
                    header.setDateEmission(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date().getTime()));
                    logger.debug(rt.getCreationDate().getTime().toString());

                    TypeDemandeType typeDemande = new TypeDemandeType();
                        typeDemande.setLibelle(this.getLibelleTypeDemande(rt));
                        typeDemande.setCode("REQUEST_EC");

                header.setTypeDemande(typeDemande);
                header.setIdOrigineApplication(idOriginApp);
                header.setIdDestinataire(idDestinataire);

                header.setIdCommune(BigInteger.valueOf(Long.valueOf(rt.getRequester().getAddress().getPostalCode())));
            mess.setEntete(header);

                BodyType body = new BodyType();
                    EnveloppeMetierType enveloppeMetier = new EnveloppeMetierType();
                      enveloppeMetier.setCanalUtilise(canalNormal);
                        DemandeActeType demandeActe = new DemandeActeType();
                            TypeActeType typeActe = new TypeActeType();

                            if (rt instanceof BirthDetailsRequestImpl)
                                typeActe.setCode(typeActeNaissance);
                            else if (rt instanceof MarriageDetailsRequestImpl)
                                typeActe.setCode(typeActeMarriage);
                            else if (rt instanceof DeathDetailsRequestImpl)
                                typeActe.setCode(typeActeDeces);

                            typeActe.setLibelle(getLibelleTypeDemande(rt));

                        demandeActe.setTypeActe(typeActe);

                            NatureActeType natureActe = new NatureActeType();

                            natureActe.setCode(getNatureActeCode(rt).toString());
                            natureActe.setLibelle(getNatureActeLibelle(rt));

                        demandeActe.setNatureActe(natureActe);


                        if (rt instanceof BirthDetailsRequestImpl)
                            demandeActe.setNombreExemplaires(((BirthDetailsRequestImpl) rt).getCopies());
                        else if (rt instanceof MarriageDetailsRequestImpl)
                            demandeActe.setNombreExemplaires(((MarriageDetailsRequestImpl) rt).getCopies());
                        else if (rt instanceof DeathDetailsRequestImpl)
                            demandeActe.setNombreExemplaires(((DeathDetailsRequestImpl) rt).getCopies());

                            MotifDemandeType motifDemande = new MotifDemandeType();

                            motifDemande.setLibelle(getMotive(rt));
                            motifDemande.setCommentaire(getComment(rt));

                        demandeActe.setMotifDemande(motifDemande);

                            DemandeurType demandeur = new DemandeurType();
                                QualiteDemandeurType qualiteDemandeur = new QualiteDemandeurType();
                                qualiteDemandeur.setCode(getRequesterQualityCode(rt).toString());
                                qualiteDemandeur.setLibelle(getRequesterQualityLibelle(rt).toString());

                            demandeur.setQualiteDemandeur(qualiteDemandeur);

                            demandeur.setNom(rt.getRequester().getLastName());
                            demandeur.setPrenom(rt.getRequester().getFirstName());
                                AdressePostaleType adresse = new AdressePostaleType();
                                //adresse.setNumeroVoie();
                                    //VoieType voie = new VoieType();
                                    //voie.setLibelle(rt.getRequester().getAddress().getStreetName());
                                adresse.setVoie(rt.getRequester().getAddress().getStreetNumber()+" "+rt.getRequester().getAddress().getStreetName());
                                adresse.setCodePostal(rt.getRequester().getAddress().getPostalCode());

                                adresse.setVille(rt.getRequester().getAddress().getCity());
                                adresse.setPays(rt.getRequester().getAddress().getCountryName());

                            demandeur.setAdresse(adresse);

                        demandeActe.setDemandeur(demandeur);

                        IndividuType titulaire = new IndividuType();

                        if(rt instanceof BirthDetailsRequestImpl)
                        {
                            titulaire.setNomNaissance(((BirthDetailsRequestImpl)rt).getBirthLastName());
                            titulaire.setNom(((BirthDetailsRequestImpl)rt).getBirthMarriageName());
                            titulaire.setPrenoms(((BirthDetailsRequestImpl)rt).getBirthFirstNames());
                                AdressePostaleType lieuNaissance = new AdressePostaleType();

                                lieuNaissance.setCodePostal(((BirthDetailsRequestImpl)rt).getBirthPostalCode());
                                lieuNaissance.setVille(((BirthDetailsRequestImpl)rt).getBirthCity());
                            titulaire.setLieuActe(lieuNaissance);

                            GregorianCalendar gcal = new GregorianCalendar();
                            gcal.setTime(((BirthDetailsRequestImpl)rt).getBirthDate().getTime());

                            titulaire.setDateActe(new SimpleDateFormat("yyyy-MM-dd").format(((BirthDetailsRequestImpl)rt).getBirthDate().getTime()));
                            FiliationType filiation = new FiliationType();

                            ParentType pere = new ParentType();
                                pere.setPrenoms(((BirthDetailsRequestImpl)rt).getFatherInformation().getFatherFirstNames());
                                pere.setNom(((BirthDetailsRequestImpl)rt).getFatherInformation().getFatherLastName());

                            ParentType mere = new ParentType();
                                mere.setPrenoms(((BirthDetailsRequestImpl)rt).getMotherInformation().getMotherFirstNames());
                                mere.setNom(((BirthDetailsRequestImpl)rt).getMotherInformation().getMotherMaidenName());

                            filiation.setPere(pere);
                            filiation.setMere(mere);

                            titulaire.setFiliation(filiation);
                        }
                        else if(rt instanceof MarriageDetailsRequestImpl)
                        {
                            if(((MarriageDetailsRequestImpl)rt).getRelationship() == MarriageRelationshipType.HUSBAND) {
                                titulaire.setNom(((MarriageDetailsRequestImpl)rt).getMarriageHusband().getMarriageHusbandLastName());
                                titulaire.setNomNaissance(((MarriageDetailsRequestImpl)rt).getMarriageHusband().getMarriageHusbandLastName());
                                titulaire.setPrenoms(((MarriageDetailsRequestImpl)rt).getMarriageHusband().getMarriageHusbandFirstNames());
                            } else {
                                titulaire.setNom(((MarriageDetailsRequestImpl)rt).getMarriageWife().getMarriageWifeLastName());
                                titulaire.setNomNaissance(((MarriageDetailsRequestImpl)rt).getMarriageWife().getMarriageWifeLastName());
                                titulaire.setPrenoms(((MarriageDetailsRequestImpl)rt).getMarriageWife().getMarriageWifeFirstNames());
                            }

                            titulaire.setDateActe(new SimpleDateFormat("yyyy-MM-dd").format(((MarriageDetailsRequestImpl)rt).getMarriage().getMarriageDate().getTime()));

                            AdressePostaleType adresseMarriage = new AdressePostaleType();

                            adresseMarriage.setCodePostal(((MarriageDetailsRequestImpl)rt).getMarriage().getMarriagePostalCode());
                            adresseMarriage.setVille(((MarriageDetailsRequestImpl)rt).getMarriage().getMarriageCity());

                            titulaire.setLieuActe(adresseMarriage);
                            
                            FiliationType filiation = new FiliationType();

                            ParentType pere = new ParentType();
                                pere.setPrenoms(((MarriageDetailsRequestImpl)rt).getFatherInformation().getFatherFirstNames());
                                pere.setNom(((MarriageDetailsRequestImpl)rt).getFatherInformation().getFatherLastName());

                            ParentType mere = new ParentType();
                                mere.setPrenoms(((MarriageDetailsRequestImpl)rt).getMotherInformation().getMotherFirstNames());
                                mere.setNom(((MarriageDetailsRequestImpl)rt).getMotherInformation().getMotherMaidenName());

                            filiation.setPere(pere);
                            filiation.setMere(mere);

                            titulaire.setFiliation(filiation);
                        }
                        else if(rt instanceof DeathDetailsRequestImpl)
                        {
                            titulaire.setNom(((DeathDetailsRequestImpl)rt).getDeathLastName());
                            titulaire.setNomNaissance(((DeathDetailsRequestImpl)rt).getDeathLastName());
                            titulaire.setPrenoms(((DeathDetailsRequestImpl)rt).getDeathFirstNames());

                            AdressePostaleType lieuActe = new AdressePostaleType();
                            
                            lieuActe.setVille(((DeathDetailsRequestImpl)rt).getDeathCity());
                            lieuActe.setCodePostal(((DeathDetailsRequestImpl)rt).getDeathPostalCode());
                            
                            titulaire.setLieuActe(lieuActe);
                            
                            ((DeathDetailsRequestImpl)rt).setDeathCity(((DeathDetailsRequestImpl)rt).getDeathCity());
                            ((DeathDetailsRequestImpl)rt).setDeathPostalCode(((DeathDetailsRequestImpl)rt).getDeathPostalCode());
                            
                            titulaire.setDateActe(new SimpleDateFormat("yyyy-MM-dd").format(((DeathDetailsRequestImpl)rt).getDeathDate().getTime()));
                        }

                        demandeActe.setTitulaire(titulaire);
                    enveloppeMetier.setDemandeActe(demandeActe);
                body.setEnveloppeMetier(enveloppeMetier);
            mess.setCorps(body);

            byte content[];

            try {
                JAXBContext context = JAXBContext.newInstance(MessageType.class);
                Marshaller m = context.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);

                if(rt instanceof BirthDetailsRequestImpl) {
                    m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.tempuri.org/ec# schema_xml_demande_acte_naissance.xsd");
                }
                else if(rt instanceof MarriageDetailsRequestImpl) {
                    m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.tempuri.org/ec# schema_xml_demande_acte_mariage.xsd");
                }
                else if(rt instanceof DeathDetailsRequestImpl) {
                    m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.tempuri.org/ec# schema_xml_demande_acte_deces.xsd");
                }

                m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

                ByteArrayOutputStream os = new ByteArrayOutputStream();
                os.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes("UTF-8"));
                m.marshal(mess, os);
                content = os.toByteArray();

                if (logger.isDebugEnabled()) {
                    logger.debug(new String(content, "UTF-8"));
                }

            } catch (IOException e) {
                logger.error("marshall ioexception", e);
                throw new CvqException(e.getMessage());
            } catch (JAXBException e) {
                logger.error("marshall jaxbexception", e);
                throw new CvqException(e.getMessage());
            }

        String senderEmail = requestTypeService.getRequestTypeByLabel(rt.getRequestTypeLabel()).getCategory().getPrimaryEmail();
        senderEmail = senderEmail != null ? senderEmail : SecurityContext.getCurrentSite().getAdminEmail();

        mailService.sendBase64Attachment(
            senderEmail,
            this.getConfigurationProperty("destinationEmailAddress"),
            null,
            "",
            "",
            content,
            fullId+".xml",
            "text/xml"
        );

        return "";
    }

    public String getLibelleTypeDemande(RequestType rt) {
        String rtLibelle = rt.getRequestTypeLabel().toString();

        if(rtLibelle.equalsIgnoreCase("Birth Details"))
            return "Acte de Naissance";
        if(rtLibelle.equalsIgnoreCase("Marriage Details"))
            return "Acte de Mariage";
        if(rtLibelle.equalsIgnoreCase("Death Details"))
            return "Acte de Decès";
        return "";
    }

    public int getQualiteDemandeurCode(String libelle){
        if("Requester".equalsIgnoreCase(libelle)) return 0;
        if("Parent".equalsIgnoreCase(libelle)) return 1;
        if("Spouse".equalsIgnoreCase(libelle)) return 2;
        if("Child".equalsIgnoreCase(libelle)) return 3;
        if("GrandParent".equalsIgnoreCase(libelle)) return 4;
        if("GrandChild".equalsIgnoreCase(libelle)) return 5;
        if("LegalRepresentant".equalsIgnoreCase(libelle)) return 6;
        if("Heir".equalsIgnoreCase(libelle)) return 7;
        if("HeirFamily".equalsIgnoreCase(libelle)) return 10;
        return 8;
    }

    public Integer getRequesterQualityCode(RequestType rt)
    {
        if(rt instanceof BirthDetailsRequestImpl)
            return getQualiteDemandeurCode(((BirthDetailsRequestImpl)rt).getRequesterQuality().toString());
        if(rt instanceof MarriageDetailsRequestImpl)
            return getQualiteDemandeurCode(((MarriageDetailsRequestImpl)rt).getRequesterQuality().toString());
        return 0;
    }

    public String getRequesterQualityLibelle(RequestType rt)
    {
        String requesterQuality = "";

        if(rt instanceof MarriageDetailsRequestImpl)
            requesterQuality = ((MarriageDetailsRequestImpl)rt).getRequesterQuality().toString();
        else if(rt instanceof BirthDetailsRequestImpl)
            requesterQuality = ((BirthDetailsRequestImpl)rt).getRequesterQuality().toString();

        if("REQUESTER".equalsIgnoreCase(requesterQuality))
            return "La personne concernée par l'acte";
        if("PARENT".equalsIgnoreCase(requesterQuality))
            return "Son père ou sa mère";
        if("SPOUSE".equalsIgnoreCase(requesterQuality))
            return "Son conjoint ou sa conjointe";
        if("CHILD".equalsIgnoreCase(requesterQuality))
            return "Son fils ou sa fille";
        if("GRAND_PARENT".equalsIgnoreCase(requesterQuality))
            return "Son grand-père ou sa grand-mère";
        if("LEGAL_REPRESENTANT".equalsIgnoreCase(requesterQuality))
            return "Son représentant légal";
        if("HEIR".equalsIgnoreCase(requesterQuality))
            return "Son héritier";
        if("HEIR_FAMILY".equalsIgnoreCase(requesterQuality))
            return "Son frère ou sa soeur";
        return "Autre";
    }
    
    public String getMotive(RequestType rt) {
        if(rt instanceof BirthDetailsRequestImpl)
        {
            if(((BirthDetailsRequestImpl) rt).getMotive() == BirthCertificateMotiveTypeImpl.FRENCH_NATIONALITY_CERTIFICATE)
                return "Certificat de nationalite francaise";
            if(((BirthDetailsRequestImpl)rt).getMotive() == BirthCertificateMotiveTypeImpl.NOTARY_ACT)
                return "Acte de notaire";
            if(((BirthDetailsRequestImpl)rt).getMotive() == BirthCertificateMotiveTypeImpl.NATIONAL_IDENTITY_CARD)
                return "Declaration d'acquisition de nationalite";
            if(((BirthDetailsRequestImpl)rt).getMotive() == BirthCertificateMotiveTypeImpl.LEGAL_PROCEEDINGS)
                return "Divorce";
        }
        else if(rt instanceof MarriageDetailsRequestImpl)
        {
            if(((MarriageDetailsRequestImpl)rt).getMotive() == MarriageCertificateMotiveTypeImpl.FRENCH_NATIONALITY_CERTIFICATE)
                return "Certificat de nationalite francaise";
            if(((MarriageDetailsRequestImpl)rt).getMotive() == MarriageCertificateMotiveTypeImpl.NOTARY_ACT)
                return "Acte de notaire";
            if(((MarriageDetailsRequestImpl)rt).getMotive() == MarriageCertificateMotiveTypeImpl.MARITAL_REGIME_CHANGE)
                return "Changement de regime matrimonial";
        }
        else if(rt instanceof DeathDetailsRequestImpl)
        {
            if(((DeathDetailsRequestImpl)rt).getMotive() == DeathCertificateMotiveTypeImpl.NOTARY_ACT)
                return "Acte de notaire";
        }
        return "Autre";
    }

    public String getComment(RequestType rt) {
        if(rt instanceof BirthDetailsRequestImpl)
            return ((BirthDetailsRequestImpl)rt).getComment();
        if(rt instanceof MarriageDetailsRequestImpl)
            return ((MarriageDetailsRequestImpl)rt).getComment();
        if(rt instanceof DeathDetailsRequestImpl)
            return ((DeathDetailsRequestImpl)rt).getComment();
        return "";
    }

    public Integer getNatureActeCode(RequestType rt) {
        if(rt instanceof BirthDetailsRequestImpl){
            if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.EXTRACT_WITH_RELATIONSHIP)
            {
                return 1;
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.EXTRACT_WITHOUT_RELATIONSHIP)
            {
                return 0;
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.FULL_COPY)
            {
                return 2;
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT)
            {
                return 3;
            }
        }
        else if(rt instanceof MarriageDetailsRequestImpl) {
            if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.EXTRACT_WITH_RELATIONSHIP)
            {
                return 5;
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.EXTRACT_WITHOUT_RELATIONSHIP)
            {
                return 4;
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.FULL_COPY)
            {
                return 6;
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT)
            {
                return 7;
            }
        }
        else if(rt instanceof DeathDetailsRequestImpl){
            if(((DeathDetailsRequestImpl) rt).getFormat() == DeathCertificateFormatTypeImpl.FULL_COPY){
                return 8;
            }
            else if(((DeathDetailsRequestImpl) rt).getFormat() == DeathCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT){
                return 9;
            }
        }
        return 0;
    }
    

    public String getNatureActeLibelle(RequestType rt) {
        if(rt instanceof BirthDetailsRequestImpl){
            if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.EXTRACT_WITH_RELATIONSHIP)
            {
                return "Extrait d'acte de naissance avec filiation";
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.EXTRACT_WITHOUT_RELATIONSHIP)
            {
                return "Extrait d'acte de naissance sans filiation";
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.FULL_COPY)
            {
                return "Copie intégrale d'acte de naissance";
            }
            else if(((BirthDetailsRequestImpl) rt).getFormat() == BirthCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT)
            {
                return "Extrait d'acte de naissance plurilingue";
            }
        }
        else if(rt instanceof MarriageDetailsRequestImpl) {
            if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.EXTRACT_WITH_RELATIONSHIP)
            {
                return "Extrait d'acte de mariage avec filiation";
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.EXTRACT_WITHOUT_RELATIONSHIP)
            {
                return "Extrait d'acte de mariage sans filiation";
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.FULL_COPY)
            {
                return "Copie intégrale d'acte de mariage";
            }
            else if(((MarriageDetailsRequestImpl) rt).getFormat() == MarriageCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT)
            {
                return "Extrait d'acte de mariage plurilingue";
            }
        }
        else if(rt instanceof DeathDetailsRequestImpl){
            if(((DeathDetailsRequestImpl) rt).getFormat() == DeathCertificateFormatTypeImpl.FULL_COPY){
                return "Copie intégrale d'acte de décès";
            }
            else if(((DeathDetailsRequestImpl) rt).getFormat() == DeathCertificateFormatTypeImpl.MULTILINGUAL_EXTRACT){
                return "Extrait d'acte de décès plurilingue";
            }
        }
        return "";
    }

    @Override
    public Map<Date, String> getConsumptions(Long key, Date dateFrom, Date dateTo)
            throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public Map<String, List<ExternalAccountItem>> getAccountsByHomeFolder(Long homeFolderId,
            String externalHomeFolderId, String externalId) throws CvqException {
        return Collections.emptyMap();
    }

    @Override
    public void loadDepositAccountDetails(ExternalDepositAccountItem edai) throws CvqException {
    }

    @Override
    public void loadInvoiceDetails(ExternalInvoiceItem eii) throws CvqException {
    }

    @Override
    public void creditHomeFolderAccounts(Collection<PurchaseItem> purchaseItems,
            String cvqReference, String bankReference, Long homeFolderId,
            String externalHomeFolderId, String externalId, Date validationDate)
            throws CvqException {

    }

    @Override
    public void checkConfiguration(ExternalServiceBean externalServiceBean,
            String localAuthorityName) throws CvqConfigurationException {
        localAuthoritySpecificConfiguration.put(localAuthorityName, externalServiceBean);
    }

    @Override
    public String helloWorld() throws CvqException {
        return "";
    }

    @Override
    public boolean supportsConsumptions() {
        return false;
    }

    @Override
    public boolean handlesTraces() {
        return false;
    }


    public String getConfigurationProperty(String propertyName) {
        String propertySpecificValue = (String)
            localAuthoritySpecificConfiguration.get(SecurityContext.getCurrentSite().getName()).getProperty(propertyName); 
        return propertySpecificValue != null ? propertySpecificValue : globalConfiguration.get(propertyName);
    }
    
    @Override
    public List<String> checkExternalReferential(XmlObject requestXml) {
        return new ArrayList<String>(0);
    }

    @Override
    public Map<String, Object> loadExternalInformations(XmlObject requestXml) throws CvqException {
        return Collections.emptyMap();
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void setRequestTypeService(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }
}

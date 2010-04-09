package fr.cg95.cvq.business.request.ecitizen;

import java.io.Serializable;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.RequestData;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.request.ecitizen.HomeFolderModificationRequestDocument;

/**
 * @author bor@zenexity.fr
 */
public class HomeFolderModificationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        HomeFolderModificationRequestData.conditions;

    private HomeFolderModificationRequestData homeFolderModificationRequestData;

    public HomeFolderModificationRequest(RequestData requestData, HomeFolderModificationRequestData homeFolderModificationRequestData) {
        super(requestData);
        this.homeFolderModificationRequestData = homeFolderModificationRequestData;
    }

    public HomeFolderModificationRequest() {
        super();
        homeFolderModificationRequestData = new HomeFolderModificationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public HomeFolderModificationRequestData getSpecificData() {
        return homeFolderModificationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(HomeFolderModificationRequestData homeFolderModificationRequestData) {
        this.homeFolderModificationRequestData = homeFolderModificationRequestData;
    }

    @Override
    public String modelToXmlString() {
        HomeFolderModificationRequestDocument object = (HomeFolderModificationRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public XmlObject modelToXml() {
        HomeFolderModificationRequestDocument homeFolderModificationRequestDoc = HomeFolderModificationRequestDocument.Factory.newInstance();
        HomeFolderModificationRequestDocument.HomeFolderModificationRequest homeFolderModificationRequest = homeFolderModificationRequestDoc.addNewHomeFolderModificationRequest();
        super.fillCommonXmlInfo(homeFolderModificationRequest);
        return homeFolderModificationRequestDoc;
    }

    public static HomeFolderModificationRequest xmlToModel(HomeFolderModificationRequestDocument homeFolderModificationRequestDoc) {
        HomeFolderModificationRequestDocument.HomeFolderModificationRequest homeFolderModificationRequestXml = homeFolderModificationRequestDoc.getHomeFolderModificationRequest();
        HomeFolderModificationRequest homeFolderModificationRequest = new HomeFolderModificationRequest();
        homeFolderModificationRequest.fillCommonModelInfo(homeFolderModificationRequest,homeFolderModificationRequestXml);
        return homeFolderModificationRequest;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HomeFolderModificationRequestDocument homeFolderModificationRequestDocument = 
            (HomeFolderModificationRequestDocument) modelToXml();
        return homeFolderModificationRequestDocument.getHomeFolderModificationRequest();
    }
}

package fr.cg95.cvq.business.request.ecitizen;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.xml.request.ecitizen.HomeFolderModificationRequestDocument;
import fr.cg95.cvq.xml.common.RequestType;

/**
 * @hibernate.joined-subclass
 *  table="home_folder_modification_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 *
 * @author bor@zenexity.fr
 */
public class HomeFolderModificationRequest extends Request implements Serializable {

	private static final long serialVersionUID = 1L;

	/** default constructor */
    public HomeFolderModificationRequest() {
        super();
    }

    @Override
    public String modelToXmlString() {
        HomeFolderModificationRequestDocument object = 
            (HomeFolderModificationRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public XmlObject modelToXml() {
        HomeFolderModificationRequestDocument hfmrRequestDoc =
            HomeFolderModificationRequestDocument.Factory.newInstance();
        HomeFolderModificationRequestDocument.HomeFolderModificationRequest hfmrRequest =
            hfmrRequestDoc.addNewHomeFolderModificationRequest();
        super.fillCommonXmlInfo(hfmrRequest);
        return hfmrRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        HomeFolderModificationRequestDocument hfmrRequestDocument = 
            (HomeFolderModificationRequestDocument) modelToXml();
        return hfmrRequestDocument.getHomeFolderModificationRequest();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}

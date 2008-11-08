package fr.cg95.cvq.business.request.environment;

import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.environment.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import fr.cg95.cvq.xml.common.RequestType;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="compostable_waste_collection_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class CompostableWasteCollectionRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public CompostableWasteCollectionRequest() {
        super();
    }


    public final String modelToXmlString() {

        CompostableWasteCollectionRequestDocument object = (CompostableWasteCollectionRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final XmlObject modelToXml() {

        Calendar calendar = Calendar.getInstance();
        Date date = null;
        CompostableWasteCollectionRequestDocument compostableWasteCollectionRequestDoc = CompostableWasteCollectionRequestDocument.Factory.newInstance();
        CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest compostableWasteCollectionRequest = compostableWasteCollectionRequestDoc.addNewCompostableWasteCollectionRequest();
        super.fillCommonXmlInfo(compostableWasteCollectionRequest);
        int i = 0;
        if (compostableWasteType != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] compostableWasteTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[compostableWasteType.size()];
            Iterator compostableWasteTypeIt = compostableWasteType.iterator();
            while (compostableWasteTypeIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) compostableWasteTypeIt.next();
                compostableWasteTypeTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            compostableWasteCollectionRequest.setCompostableWasteTypeArray(compostableWasteTypeTypeTab);
        }
        compostableWasteCollectionRequest.setCollectionAddress(this.collectionAddress);
        compostableWasteCollectionRequest.setOtherWaste(this.otherWaste);
        return compostableWasteCollectionRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        CompostableWasteCollectionRequestDocument compostableWasteCollectionRequestDoc =
            (CompostableWasteCollectionRequestDocument) modelToXml();
        return compostableWasteCollectionRequestDoc.getCompostableWasteCollectionRequest();
    }

    public static CompostableWasteCollectionRequest xmlToModel(CompostableWasteCollectionRequestDocument compostableWasteCollectionRequestDoc) {

        CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest compostableWasteCollectionRequestXml = compostableWasteCollectionRequestDoc.getCompostableWasteCollectionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        CompostableWasteCollectionRequest compostableWasteCollectionRequest = new CompostableWasteCollectionRequest();
        compostableWasteCollectionRequest.fillCommonModelInfo(compostableWasteCollectionRequest,compostableWasteCollectionRequestXml);
        List<fr.cg95.cvq.business.users.LocalReferentialData> compostableWasteTypeList = new ArrayList<fr.cg95.cvq.business.users.LocalReferentialData> ();
        if ( compostableWasteCollectionRequestXml.sizeOfCompostableWasteTypeArray() > 0) {
            for (int i = 0; i < compostableWasteCollectionRequestXml.getCompostableWasteTypeArray().length; i++) {
                compostableWasteTypeList.add(LocalReferentialData.xmlToModel(compostableWasteCollectionRequestXml.getCompostableWasteTypeArray(i)));
            }
        }
        compostableWasteCollectionRequest.setCompostableWasteType(compostableWasteTypeList);
        compostableWasteCollectionRequest.setCollectionAddress(compostableWasteCollectionRequestXml.getCollectionAddress());
        compostableWasteCollectionRequest.setOtherWaste(compostableWasteCollectionRequestXml.getOtherWaste());
        return compostableWasteCollectionRequest;
    }

    private List<fr.cg95.cvq.business.users.LocalReferentialData> compostableWasteType;

    public final void setCompostableWasteType(final List<fr.cg95.cvq.business.users.LocalReferentialData> compostableWasteType) {
        this.compostableWasteType = compostableWasteType;
    }


    /**
     * @hibernate.list
     *  inverse="false"
     *  cascade="all"
     *  table="compostable_waste_collection_request_compostable_waste_type"
     * @hibernate.key
     *  column="compostable_waste_collection_request_id"
     * @hibernate.list-index
     *  column="compostable_waste_type_index"
     * @hibernate.many-to-many
     *  column="compostable_waste_type_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final List<fr.cg95.cvq.business.users.LocalReferentialData> getCompostableWasteType() {
        return this.compostableWasteType;
    }

    private String collectionAddress;

    public final void setCollectionAddress(final String collectionAddress) {
        this.collectionAddress = collectionAddress;
    }


    /**
     * @hibernate.property
     *  column="collection_address"
     */
    public final String getCollectionAddress() {
        return this.collectionAddress;
    }

    private String otherWaste;

    public final void setOtherWaste(final String otherWaste) {
        this.otherWaste = otherWaste;
    }


    /**
     * @hibernate.property
     *  column="other_waste"
     */
    public final String getOtherWaste() {
        return this.otherWaste;
    }

}

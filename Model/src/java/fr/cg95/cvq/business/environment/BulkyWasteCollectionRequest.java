package fr.cg95.cvq.business.environment;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.environment.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="bulky_waste_collection_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class BulkyWasteCollectionRequest extends Request implements Serializable { 

    private static final long serialVersionUID = 1L;



    public BulkyWasteCollectionRequest() {
        super();
    }


    public final String modelToXmlString() {

        BulkyWasteCollectionRequestDocument object = (BulkyWasteCollectionRequestDocument) this.modelToXml();
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
        BulkyWasteCollectionRequestDocument bulkyWasteCollectionRequestDoc = BulkyWasteCollectionRequestDocument.Factory.newInstance();
        BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest bulkyWasteCollectionRequest = bulkyWasteCollectionRequestDoc.addNewBulkyWasteCollectionRequest();
        super.fillCommonXmlInfo(bulkyWasteCollectionRequest);
        bulkyWasteCollectionRequest.setCollectionAddress(this.collectionAddress);
        int i = 0;
        if (bulkyWasteType != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] bulkyWasteTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[bulkyWasteType.size()];
            Iterator bulkyWasteTypeIt = bulkyWasteType.iterator();
            while (bulkyWasteTypeIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) bulkyWasteTypeIt.next();
                bulkyWasteTypeTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            bulkyWasteCollectionRequest.setBulkyWasteTypeArray(bulkyWasteTypeTypeTab);
        }
        bulkyWasteCollectionRequest.setOtherWaste(this.otherWaste);
        return bulkyWasteCollectionRequestDoc;
    }

    public static BulkyWasteCollectionRequest xmlToModel(BulkyWasteCollectionRequestDocument bulkyWasteCollectionRequestDoc) {

        BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest bulkyWasteCollectionRequestXml = bulkyWasteCollectionRequestDoc.getBulkyWasteCollectionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        BulkyWasteCollectionRequest bulkyWasteCollectionRequest = new BulkyWasteCollectionRequest();
        bulkyWasteCollectionRequest.fillCommonModelInfo(bulkyWasteCollectionRequest,bulkyWasteCollectionRequestXml);
        bulkyWasteCollectionRequest.setCollectionAddress(bulkyWasteCollectionRequestXml.getCollectionAddress());
        HashSet bulkyWasteTypeSet = new HashSet();
        if ( bulkyWasteCollectionRequestXml.sizeOfBulkyWasteTypeArray() > 0) {
            for (int i = 0; i < bulkyWasteCollectionRequestXml.getBulkyWasteTypeArray().length; i++) {
                bulkyWasteTypeSet.add(LocalReferentialData.xmlToModel(bulkyWasteCollectionRequestXml.getBulkyWasteTypeArray(i)));
            }
        }
        bulkyWasteCollectionRequest.setBulkyWasteType(bulkyWasteTypeSet);
        bulkyWasteCollectionRequest.setOtherWaste(bulkyWasteCollectionRequestXml.getOtherWaste());
        return bulkyWasteCollectionRequest;
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

    private Set bulkyWasteType;

    public final void setBulkyWasteType(final Set bulkyWasteType) {
        this.bulkyWasteType = bulkyWasteType;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="bulky_waste_collection_request_bulky_waste_type"
     * @hibernate.key
     *  column="bulky_waste_collection_request_id"
     * @hibernate.many-to-many
     *  column="bulky_waste_type_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getBulkyWasteType() {
        return this.bulkyWasteType;
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

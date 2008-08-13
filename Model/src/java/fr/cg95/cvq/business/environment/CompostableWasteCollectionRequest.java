package fr.cg95.cvq.business.environment;

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
        compostableWasteCollectionRequest.setCollectionAddress(this.collectionAddress);
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
        compostableWasteCollectionRequest.setOtherWaste(this.otherWaste);
        return compostableWasteCollectionRequestDoc;
    }

    public static CompostableWasteCollectionRequest xmlToModel(CompostableWasteCollectionRequestDocument compostableWasteCollectionRequestDoc) {

        CompostableWasteCollectionRequestDocument.CompostableWasteCollectionRequest compostableWasteCollectionRequestXml = compostableWasteCollectionRequestDoc.getCompostableWasteCollectionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        CompostableWasteCollectionRequest compostableWasteCollectionRequest = new CompostableWasteCollectionRequest();
        compostableWasteCollectionRequest.fillCommonModelInfo(compostableWasteCollectionRequest,compostableWasteCollectionRequestXml);
        compostableWasteCollectionRequest.setCollectionAddress(compostableWasteCollectionRequestXml.getCollectionAddress());
        HashSet compostableWasteTypeSet = new HashSet();
        if ( compostableWasteCollectionRequestXml.sizeOfCompostableWasteTypeArray() > 0) {
            for (int i = 0; i < compostableWasteCollectionRequestXml.getCompostableWasteTypeArray().length; i++) {
                compostableWasteTypeSet.add(LocalReferentialData.xmlToModel(compostableWasteCollectionRequestXml.getCompostableWasteTypeArray(i)));
            }
        }
        compostableWasteCollectionRequest.setCompostableWasteType(compostableWasteTypeSet);
        compostableWasteCollectionRequest.setOtherWaste(compostableWasteCollectionRequestXml.getOtherWaste());
        return compostableWasteCollectionRequest;
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

    private Set compostableWasteType;

    public final void setCompostableWasteType(final Set compostableWasteType) {
        this.compostableWasteType = compostableWasteType;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="compostable_waste_collection_request_compostable_waste_type"
     * @hibernate.key
     *  column="compostable_waste_collection_request_id"
     * @hibernate.many-to-many
     *  column="compostable_waste_type_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getCompostableWasteType() {
        return this.compostableWasteType;
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

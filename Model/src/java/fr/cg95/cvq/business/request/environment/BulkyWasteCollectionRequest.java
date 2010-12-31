
package fr.cg95.cvq.business.request.environment;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.environment.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class BulkyWasteCollectionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = BulkyWasteCollectionRequestData.conditions;

    @AssertValid(message = "")
    private BulkyWasteCollectionRequestData bulkyWasteCollectionRequestData;

    public BulkyWasteCollectionRequest(RequestData requestData, BulkyWasteCollectionRequestData bulkyWasteCollectionRequestData) {
        super(requestData);
        this.bulkyWasteCollectionRequestData = bulkyWasteCollectionRequestData;
    }

    public BulkyWasteCollectionRequest() {
        super();
        this.bulkyWasteCollectionRequestData = new BulkyWasteCollectionRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public BulkyWasteCollectionRequestData getSpecificData() {
        return bulkyWasteCollectionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(BulkyWasteCollectionRequestData bulkyWasteCollectionRequestData) {
        this.bulkyWasteCollectionRequestData = bulkyWasteCollectionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        BulkyWasteCollectionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final BulkyWasteCollectionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        BulkyWasteCollectionRequestDocument bulkyWasteCollectionRequestDoc = BulkyWasteCollectionRequestDocument.Factory.newInstance();
        BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest bulkyWasteCollectionRequest = bulkyWasteCollectionRequestDoc.addNewBulkyWasteCollectionRequest();
        super.fillCommonXmlInfo(bulkyWasteCollectionRequest);
        int i = 0;
        
        if (getCollectionAddress() != null)
            bulkyWasteCollectionRequest.setCollectionAddress(Address.modelToXml(getCollectionAddress()));
      
        i = 0;
        if (getBulkyWasteType() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] bulkyWasteTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getBulkyWasteType().size()];
            for (LocalReferentialData object : getBulkyWasteType()) {
              bulkyWasteTypeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            bulkyWasteCollectionRequest.setBulkyWasteTypeArray(bulkyWasteTypeTypeTab);
        }
      
        bulkyWasteCollectionRequest.setOtherWaste(getOtherWaste());
      
        return bulkyWasteCollectionRequestDoc;
    }

    @Override
    public final BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest modelToXmlRequest() {
        return modelToXml().getBulkyWasteCollectionRequest();
    }

    public static BulkyWasteCollectionRequest xmlToModel(BulkyWasteCollectionRequestDocument bulkyWasteCollectionRequestDoc) {
        BulkyWasteCollectionRequestDocument.BulkyWasteCollectionRequest bulkyWasteCollectionRequestXml = bulkyWasteCollectionRequestDoc.getBulkyWasteCollectionRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        BulkyWasteCollectionRequest bulkyWasteCollectionRequest = new BulkyWasteCollectionRequest();
        bulkyWasteCollectionRequest.fillCommonModelInfo(bulkyWasteCollectionRequest, bulkyWasteCollectionRequestXml);
        
        if (bulkyWasteCollectionRequestXml.getCollectionAddress() != null)
            bulkyWasteCollectionRequest.setCollectionAddress(Address.xmlToModel(bulkyWasteCollectionRequestXml.getCollectionAddress()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> bulkyWasteTypeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(bulkyWasteCollectionRequestXml.sizeOfBulkyWasteTypeArray());
        for (LocalReferentialDataType object : bulkyWasteCollectionRequestXml.getBulkyWasteTypeArray()) {
            bulkyWasteTypeList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        bulkyWasteCollectionRequest.setBulkyWasteType(bulkyWasteTypeList);
      
        bulkyWasteCollectionRequest.setOtherWaste(bulkyWasteCollectionRequestXml.getOtherWaste());
      
        return bulkyWasteCollectionRequest;
    }

  
    public final void setCollectionAddress(final fr.cg95.cvq.business.users.Address collectionAddress) {
        bulkyWasteCollectionRequestData.setCollectionAddress(collectionAddress);
    }

    
    public final fr.cg95.cvq.business.users.Address getCollectionAddress() {
        return bulkyWasteCollectionRequestData.getCollectionAddress();
    }
  
    public final void setBulkyWasteType(final List<fr.cg95.cvq.business.request.LocalReferentialData> bulkyWasteType) {
        bulkyWasteCollectionRequestData.setBulkyWasteType(bulkyWasteType);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getBulkyWasteType() {
        return bulkyWasteCollectionRequestData.getBulkyWasteType();
    }
  
    public final void setOtherWaste(final String otherWaste) {
        bulkyWasteCollectionRequestData.setOtherWaste(otherWaste);
    }

    
    public final String getOtherWaste() {
        return bulkyWasteCollectionRequestData.getOtherWaste();
    }
  
}

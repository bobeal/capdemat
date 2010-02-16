
package fr.cg95.cvq.business.request.technical;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.technical.*;

/**
 * Generated class file, do not edit !
 */
public class TechnicalInterventionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private TechnicalInterventionRequestData technicalInterventionRequestData;

    public TechnicalInterventionRequest(RequestData requestData, TechnicalInterventionRequestData technicalInterventionRequestData) {
        super(requestData);
        this.technicalInterventionRequestData = technicalInterventionRequestData;
    }

    public TechnicalInterventionRequest() {
        super();
        this.technicalInterventionRequestData = new TechnicalInterventionRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public TechnicalInterventionRequestData getSpecificData() {
        return technicalInterventionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(TechnicalInterventionRequestData technicalInterventionRequestData) {
        this.technicalInterventionRequestData = technicalInterventionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        TechnicalInterventionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final TechnicalInterventionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        TechnicalInterventionRequestDocument technicalInterventionRequestDoc = TechnicalInterventionRequestDocument.Factory.newInstance();
        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequest = technicalInterventionRequestDoc.addNewTechnicalInterventionRequest();
        super.fillCommonXmlInfo(technicalInterventionRequest);
        int i = 0;
        
        technicalInterventionRequest.setOtherInterventionLabel(getOtherInterventionLabel());
      
        technicalInterventionRequest.setInterventionDescription(getInterventionDescription());
      
        if (getInterventionPlace() != null)
            technicalInterventionRequest.setInterventionPlace(Address.modelToXml(getInterventionPlace()));
      
        i = 0;
        if (getInterventionType() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interventionTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getInterventionType().size()];
            for (LocalReferentialData object : getInterventionType()) {
              interventionTypeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            technicalInterventionRequest.setInterventionTypeArray(interventionTypeTypeTab);
        }
      
        return technicalInterventionRequestDoc;
    }

    @Override
    public final TechnicalInterventionRequestDocument.TechnicalInterventionRequest modelToXmlRequest() {
        return modelToXml().getTechnicalInterventionRequest();
    }

    public static TechnicalInterventionRequest xmlToModel(TechnicalInterventionRequestDocument technicalInterventionRequestDoc) {
        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequestXml = technicalInterventionRequestDoc.getTechnicalInterventionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        TechnicalInterventionRequest technicalInterventionRequest = new TechnicalInterventionRequest();
        technicalInterventionRequest.fillCommonModelInfo(technicalInterventionRequest, technicalInterventionRequestXml);
        
        technicalInterventionRequest.setOtherInterventionLabel(technicalInterventionRequestXml.getOtherInterventionLabel());
      
        technicalInterventionRequest.setInterventionDescription(technicalInterventionRequestXml.getInterventionDescription());
      
        if (technicalInterventionRequestXml.getInterventionPlace() != null)
            technicalInterventionRequest.setInterventionPlace(Address.xmlToModel(technicalInterventionRequestXml.getInterventionPlace()));
      
        List<fr.cg95.cvq.business.request.LocalReferentialData> interventionTypeList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(technicalInterventionRequestXml.sizeOfInterventionTypeArray());
        for (LocalReferentialDataType object : technicalInterventionRequestXml.getInterventionTypeArray()) {
            interventionTypeList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        technicalInterventionRequest.setInterventionType(interventionTypeList);
      
        return technicalInterventionRequest;
    }

  
    public final void setOtherInterventionLabel(final String otherInterventionLabel) {
        technicalInterventionRequestData.setOtherInterventionLabel(otherInterventionLabel);
    }

    public final String getOtherInterventionLabel() {
        return technicalInterventionRequestData.getOtherInterventionLabel();
    }
  
    public final void setInterventionDescription(final String interventionDescription) {
        technicalInterventionRequestData.setInterventionDescription(interventionDescription);
    }

    public final String getInterventionDescription() {
        return technicalInterventionRequestData.getInterventionDescription();
    }
  
    public final void setInterventionPlace(final fr.cg95.cvq.business.users.Address interventionPlace) {
        technicalInterventionRequestData.setInterventionPlace(interventionPlace);
    }

    public final fr.cg95.cvq.business.users.Address getInterventionPlace() {
        return technicalInterventionRequestData.getInterventionPlace();
    }
  
    public final void setInterventionType(final List<fr.cg95.cvq.business.request.LocalReferentialData> interventionType) {
        technicalInterventionRequestData.setInterventionType(interventionType);
    }

    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getInterventionType() {
        return technicalInterventionRequestData.getInterventionType();
    }
  
}

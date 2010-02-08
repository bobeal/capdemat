
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
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.technical.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="technical_intervention_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class TechnicalInterventionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public TechnicalInterventionRequest() {
        super();
      
    }

    @Override
    public final String modelToXmlString() {
        TechnicalInterventionRequestDocument object = (TechnicalInterventionRequestDocument) this.modelToXml();
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
    
        technicalInterventionRequest.setOtherInterventionLabel(this.otherInterventionLabel);
      
        technicalInterventionRequest.setInterventionDescription(this.interventionDescription);
      
        if (this.interventionPlace != null)
            technicalInterventionRequest.setInterventionPlace(Address.modelToXml(this.interventionPlace));
      
        i = 0;
        if (interventionType != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interventionTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[interventionType.size()];
            for (LocalReferentialData object : interventionType) {
              interventionTypeTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            technicalInterventionRequest.setInterventionTypeArray(interventionTypeTypeTab);
        }
      
        return technicalInterventionRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        TechnicalInterventionRequestDocument technicalInterventionRequestDoc =
            (TechnicalInterventionRequestDocument) modelToXml();
        return technicalInterventionRequestDoc.getTechnicalInterventionRequest();
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

  
    private String otherInterventionLabel;

    public final void setOtherInterventionLabel(final String otherInterventionLabel) {
        this.otherInterventionLabel = otherInterventionLabel;
    }

    /**
 
        * @hibernate.property
        *  column="other_intervention_label"
        
      
    */
    public final String getOtherInterventionLabel() {
        return this.otherInterventionLabel;
    }
  
    private String interventionDescription;

    public final void setInterventionDescription(final String interventionDescription) {
        this.interventionDescription = interventionDescription;
    }

    /**
 
        * @hibernate.property
        *  column="intervention_description"
        
      
    */
    public final String getInterventionDescription() {
        return this.interventionDescription;
    }
  
    private fr.cg95.cvq.business.users.Address interventionPlace;

    public final void setInterventionPlace(final fr.cg95.cvq.business.users.Address interventionPlace) {
        this.interventionPlace = interventionPlace;
    }

    /**
 
        * @hibernate.many-to-one
        *  cascade="all"
        *  column="intervention_place_id"
        *  class="fr.cg95.cvq.business.users.Address"
      
    */
    public final fr.cg95.cvq.business.users.Address getInterventionPlace() {
        return this.interventionPlace;
    }
  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> interventionType;

    public final void setInterventionType(final List<fr.cg95.cvq.business.request.LocalReferentialData> interventionType) {
        this.interventionType = interventionType;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="technical_intervention_request_intervention_type"
        * @hibernate.key
        *  column="technical_intervention_request_id"
        * @hibernate.list-index
        *  column="intervention_type_index"
        * @hibernate.many-to-many
        *  column="intervention_type_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getInterventionType() {
        return this.interventionType;
    }
  
}

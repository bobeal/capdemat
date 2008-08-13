package fr.cg95.cvq.business.technical;

import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.technical.*;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;

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


    public final String modelToXmlString() {

        TechnicalInterventionRequestDocument object = (TechnicalInterventionRequestDocument) this.modelToXml();
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
        TechnicalInterventionRequestDocument technicalInterventionRequestDoc = TechnicalInterventionRequestDocument.Factory.newInstance();
        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequest = technicalInterventionRequestDoc.addNewTechnicalInterventionRequest();
        super.fillCommonXmlInfo(technicalInterventionRequest);
        int i = 0;
        if (interventionType != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] interventionTypeTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[interventionType.size()];
            Iterator interventionTypeIt = interventionType.iterator();
            while (interventionTypeIt.hasNext()) {
                LocalReferentialData object = (LocalReferentialData) interventionTypeIt.next();
                interventionTypeTypeTab[i] = LocalReferentialData.modelToXml(object);
                i = i + 1;
            }
            technicalInterventionRequest.setInterventionTypeArray(interventionTypeTypeTab);
        }
        if (this.interventionPlace != null)
            technicalInterventionRequest.setInterventionPlace(Address.modelToXml(this.interventionPlace));
        technicalInterventionRequest.setInterventionDescription(this.interventionDescription);
        return technicalInterventionRequestDoc;
    }

    public static TechnicalInterventionRequest xmlToModel(TechnicalInterventionRequestDocument technicalInterventionRequestDoc) {

        TechnicalInterventionRequestDocument.TechnicalInterventionRequest technicalInterventionRequestXml = technicalInterventionRequestDoc.getTechnicalInterventionRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        TechnicalInterventionRequest technicalInterventionRequest = new TechnicalInterventionRequest();
        technicalInterventionRequest.fillCommonModelInfo(technicalInterventionRequest,technicalInterventionRequestXml);
        HashSet interventionTypeSet = new HashSet();
        if ( technicalInterventionRequestXml.sizeOfInterventionTypeArray() > 0) {
            for (int i = 0; i < technicalInterventionRequestXml.getInterventionTypeArray().length; i++) {
                interventionTypeSet.add(LocalReferentialData.xmlToModel(technicalInterventionRequestXml.getInterventionTypeArray(i)));
            }
        }
        technicalInterventionRequest.setInterventionType(interventionTypeSet);
        if (technicalInterventionRequestXml.getInterventionPlace() != null)
            technicalInterventionRequest.setInterventionPlace(Address.xmlToModel(technicalInterventionRequestXml.getInterventionPlace()));
        technicalInterventionRequest.setInterventionDescription(technicalInterventionRequestXml.getInterventionDescription());
        return technicalInterventionRequest;
    }

    private Set interventionType;

    public final void setInterventionType(final Set interventionType) {
        this.interventionType = interventionType;
    }


    /**
     * @hibernate.set
     *  inverse="false"
     *  cascade="all"
     *  table="technical_intervention_request_intervention_type"
     * @hibernate.key
     *  column="technical_intervention_request_id"
     * @hibernate.many-to-many
     *  column="intervention_type_id"
     *  class="fr.cg95.cvq.business.users.LocalReferentialData"
     */
    public final Set getInterventionType() {
        return this.interventionType;
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

}

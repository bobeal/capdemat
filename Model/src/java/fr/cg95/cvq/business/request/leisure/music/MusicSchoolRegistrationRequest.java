
package fr.cg95.cvq.business.request.leisure.music;

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
import fr.cg95.cvq.xml.request.leisure.music.*;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.joined-subclass
 *  table="music_school_registration_request"
 *  lazy="false"
 * @hibernate.joined-subclass-key
 *  column="id"
 */
public class MusicSchoolRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public MusicSchoolRegistrationRequest() {
        super();
      
    }

    @Override
    public final String modelToXmlString() {
        MusicSchoolRegistrationRequestDocument object = (MusicSchoolRegistrationRequestDocument) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final MusicSchoolRegistrationRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc = MusicSchoolRegistrationRequestDocument.Factory.newInstance();
        MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest musicSchoolRegistrationRequest = musicSchoolRegistrationRequestDoc.addNewMusicSchoolRegistrationRequest();
        super.fillCommonXmlInfo(musicSchoolRegistrationRequest);
        int i = 0;
    
        i = 0;
        if (activity != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] activityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[activity.size()];
            for (LocalReferentialData object : activity) {
              activityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            musicSchoolRegistrationRequest.setActivityArray(activityTypeTab);
        }
      
        if (this.rulesAndRegulationsAcceptance != null)
            musicSchoolRegistrationRequest.setRulesAndRegulationsAcceptance(this.rulesAndRegulationsAcceptance.booleanValue());
      
        return musicSchoolRegistrationRequestDoc;
    }

    @Override
    public RequestType modelToXmlRequest() {
        MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc =
            (MusicSchoolRegistrationRequestDocument) modelToXml();
        return musicSchoolRegistrationRequestDoc.getMusicSchoolRegistrationRequest();
    }

    public static MusicSchoolRegistrationRequest xmlToModel(MusicSchoolRegistrationRequestDocument musicSchoolRegistrationRequestDoc) {
        MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest musicSchoolRegistrationRequestXml = musicSchoolRegistrationRequestDoc.getMusicSchoolRegistrationRequest();
        Calendar calendar = Calendar.getInstance();
        List list = new ArrayList();
        MusicSchoolRegistrationRequest musicSchoolRegistrationRequest = new MusicSchoolRegistrationRequest();
        musicSchoolRegistrationRequest.fillCommonModelInfo(musicSchoolRegistrationRequest, musicSchoolRegistrationRequestXml);
    
        List<fr.cg95.cvq.business.request.LocalReferentialData> activityList = new ArrayList<fr.cg95.cvq.business.request.LocalReferentialData>(musicSchoolRegistrationRequestXml.sizeOfActivityArray());
        for (LocalReferentialDataType object : musicSchoolRegistrationRequestXml.getActivityArray()) {
            activityList.add(fr.cg95.cvq.business.request.LocalReferentialData.xmlToModel(object));
        }
        musicSchoolRegistrationRequest.setActivity(activityList);
      
        musicSchoolRegistrationRequest.setRulesAndRegulationsAcceptance(Boolean.valueOf(musicSchoolRegistrationRequestXml.getRulesAndRegulationsAcceptance()));
      
        return musicSchoolRegistrationRequest;
    }

  
    private List<fr.cg95.cvq.business.request.LocalReferentialData> activity;

    public final void setActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> activity) {
        this.activity = activity;
    }

    /**
 
        * @hibernate.list
        *  inverse="false"
        *  lazy="false"
        *  cascade="all"
        *  table="music_school_registration_request_activity"
        * @hibernate.key
        *  column="music_school_registration_request_id"
        * @hibernate.list-index
        *  column="activity_index"
        * @hibernate.many-to-many
        *  column="activity_id"
        *  class="fr.cg95.cvq.business.request.LocalReferentialData"
      
    */
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getActivity() {
        return this.activity;
    }
  
    private Boolean rulesAndRegulationsAcceptance;

    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        this.rulesAndRegulationsAcceptance = rulesAndRegulationsAcceptance;
    }

    /**
 
        * @hibernate.property
        *  column="rules_and_regulations_acceptance"
        
      
    */
    public final Boolean getRulesAndRegulationsAcceptance() {
        return this.rulesAndRegulationsAcceptance;
    }
  
}

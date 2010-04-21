
package fr.cg95.cvq.business.request.leisure.music;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.oval.constraint.AssertValid;
import org.apache.xmlbeans.XmlOptions;

import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.request.annotation.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.leisure.music.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class MusicSchoolRegistrationRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = MusicSchoolRegistrationRequestData.conditions;

    @AssertValid(message = "")
    private MusicSchoolRegistrationRequestData musicSchoolRegistrationRequestData;

    public MusicSchoolRegistrationRequest(RequestData requestData, MusicSchoolRegistrationRequestData musicSchoolRegistrationRequestData) {
        super(requestData);
        this.musicSchoolRegistrationRequestData = musicSchoolRegistrationRequestData;
    }

    public MusicSchoolRegistrationRequest() {
        super();
        this.musicSchoolRegistrationRequestData = new MusicSchoolRegistrationRequestData();
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public MusicSchoolRegistrationRequestData getSpecificData() {
        return musicSchoolRegistrationRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(MusicSchoolRegistrationRequestData musicSchoolRegistrationRequestData) {
        this.musicSchoolRegistrationRequestData = musicSchoolRegistrationRequestData;
    }

    @Override
    public final String modelToXmlString() {
        MusicSchoolRegistrationRequestDocument object = this.modelToXml();
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
        if (getActivity() != null) {
            fr.cg95.cvq.xml.common.LocalReferentialDataType[] activityTypeTab = new fr.cg95.cvq.xml.common.LocalReferentialDataType[getActivity().size()];
            for (LocalReferentialData object : getActivity()) {
              activityTypeTab[i++] = LocalReferentialData.modelToXml(object);
            }
            musicSchoolRegistrationRequest.setActivityArray(activityTypeTab);
        }
      
        if (getRulesAndRegulationsAcceptance() != null)
            musicSchoolRegistrationRequest.setRulesAndRegulationsAcceptance(getRulesAndRegulationsAcceptance().booleanValue());
      
        return musicSchoolRegistrationRequestDoc;
    }

    @Override
    public final MusicSchoolRegistrationRequestDocument.MusicSchoolRegistrationRequest modelToXmlRequest() {
        return modelToXml().getMusicSchoolRegistrationRequest();
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

  
    public final void setActivity(final List<fr.cg95.cvq.business.request.LocalReferentialData> activity) {
        musicSchoolRegistrationRequestData.setActivity(activity);
    }

    
    public final List<fr.cg95.cvq.business.request.LocalReferentialData> getActivity() {
        return musicSchoolRegistrationRequestData.getActivity();
    }
  
    public final void setRulesAndRegulationsAcceptance(final Boolean rulesAndRegulationsAcceptance) {
        musicSchoolRegistrationRequestData.setRulesAndRegulationsAcceptance(rulesAndRegulationsAcceptance);
    }

    @IsRulesAcceptance
    public final Boolean getRulesAndRegulationsAcceptance() {
        return musicSchoolRegistrationRequestData.getRulesAndRegulationsAcceptance();
    }
  
}

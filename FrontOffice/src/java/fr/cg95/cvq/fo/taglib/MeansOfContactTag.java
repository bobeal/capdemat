package fr.cg95.cvq.fo.taglib;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;

import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.business.users.MeansOfContact;
import fr.cg95.cvq.fo.business.BusinessDictionary;
import fr.cg95.cvq.fo.business.BusinessManager;
import fr.cg95.cvq.wizard.process.ProcessStageAction;
import fr.cg95.cvq.xml.common.RequestType;

public class MeansOfContactTag extends BaseTag {
    
    static Logger logger = Logger.getLogger(MeansOfContactTag.class);
    public int doEndTag() {
        
        try {
            JspWriter out = pageContext.getOut();
            
            RequestType xmlRequest = (RequestType)RequestUtils.lookup(
                    pageContext, ProcessStageAction.getRequestDataSessionKey() , getScope());
        
            Adult adult = Adult.xmlToModel(xmlRequest.getRequester());
            
            List<MeansOfContact> mocList =    
                BusinessManager.getInstance().getAdultEnabledMeansOfContact(adult);
            
            out.println("" +
            		"<select name=\"" + name + "\">" +
            		"  <option value=\"\">Choisissez un moyen de contact</option>");
            
            for (MeansOfContact moc : mocList) {
                out.println(
                        "  <option value=\"" + moc.getType()+ "\">" +
                		     BusinessDictionary.getMeansofContactEnum(moc.getType()) +
                        "  </option>");
            }
            
            out.println("</select>");
    
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return EVAL_PAGE;
    }

}

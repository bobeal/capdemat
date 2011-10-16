
package fr.cg95.cvq.business.request.school;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 */
public class IconitoPsSubscriptionRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions = IconitoPsSubscriptionRequestData.conditions;

    @AssertValid(message = "")
    private IconitoPsSubscriptionRequestData iconitoPsSubscriptionRequestData;

    public IconitoPsSubscriptionRequest(RequestData requestData, IconitoPsSubscriptionRequestData iconitoPsSubscriptionRequestData) {
        super(requestData);
        this.iconitoPsSubscriptionRequestData = iconitoPsSubscriptionRequestData;
    }

    public IconitoPsSubscriptionRequest() {
        super();
        this.iconitoPsSubscriptionRequestData = new IconitoPsSubscriptionRequestData();
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("iconito", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          getStepStates().put("validation", stepState);
        
    }

    /**
     * Reserved for RequestDAO !
     */
    @Override
    public IconitoPsSubscriptionRequestData getSpecificData() {
        return iconitoPsSubscriptionRequestData;
    }

    /**
     * Reserved for RequestDAO !
     */
    public void setSpecificData(IconitoPsSubscriptionRequestData iconitoPsSubscriptionRequestData) {
        this.iconitoPsSubscriptionRequestData = iconitoPsSubscriptionRequestData;
    }

    @Override
    public final String modelToXmlString() {
        IconitoPsSubscriptionRequestDocument object = this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    @Override
    public final IconitoPsSubscriptionRequestDocument modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        Date date = null;
        IconitoPsSubscriptionRequestDocument iconitoPsSubscriptionRequestDoc = IconitoPsSubscriptionRequestDocument.Factory.newInstance();
        IconitoPsSubscriptionRequestDocument.IconitoPsSubscriptionRequest iconitoPsSubscriptionRequest = iconitoPsSubscriptionRequestDoc.addNewIconitoPsSubscriptionRequest();
        super.fillCommonXmlInfo(iconitoPsSubscriptionRequest);
        int i = 0;
        
        iconitoPsSubscriptionRequest.setInvoiceBarCode(getInvoiceBarCode());
      
        return iconitoPsSubscriptionRequestDoc;
    }

    @Override
    public final IconitoPsSubscriptionRequestDocument.IconitoPsSubscriptionRequest modelToXmlRequest() {
        return modelToXml().getIconitoPsSubscriptionRequest();
    }

    public static IconitoPsSubscriptionRequest xmlToModel(IconitoPsSubscriptionRequestDocument iconitoPsSubscriptionRequestDoc) {
        IconitoPsSubscriptionRequestDocument.IconitoPsSubscriptionRequest iconitoPsSubscriptionRequestXml = iconitoPsSubscriptionRequestDoc.getIconitoPsSubscriptionRequest();
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        IconitoPsSubscriptionRequest iconitoPsSubscriptionRequest = new IconitoPsSubscriptionRequest();
        iconitoPsSubscriptionRequest.fillCommonModelInfo(iconitoPsSubscriptionRequest, iconitoPsSubscriptionRequestXml);
        
        iconitoPsSubscriptionRequest.setInvoiceBarCode(iconitoPsSubscriptionRequestXml.getInvoiceBarCode());
      
        return iconitoPsSubscriptionRequest;
    }

    @Override
    public IconitoPsSubscriptionRequest clone() {
        IconitoPsSubscriptionRequest clone = new IconitoPsSubscriptionRequest(getRequestData().clone(), iconitoPsSubscriptionRequestData.clone());
        Map<String, Object> stepState;
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "uncomplete");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("iconito", stepState);
        
          stepState = new HashMap<String, Object>(4);
          stepState.put("state", "unavailable");
          stepState.put("required", true);
          stepState.put("errorMsg", null);
          stepState.put("invalidFields", new ArrayList<String>());
          clone.getStepStates().put("validation", stepState);
        
        return clone;
    }

  
    public final void setInvoiceBarCode(final String invoiceBarCode) {
        iconitoPsSubscriptionRequestData.setInvoiceBarCode(invoiceBarCode);
    }

    
    public final String getInvoiceBarCode() {
        return iconitoPsSubscriptionRequestData.getInvoiceBarCode();
    }
  
}

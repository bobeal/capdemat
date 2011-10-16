

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

import net.sf.oval.constraint.*;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="iconito_ps_subscription_request")
public class IconitoPsSubscriptionRequestData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        new HashMap<String, IConditionChecker>(RequestData.conditions);

    private Long id;

    public IconitoPsSubscriptionRequestData() {
      
    }

    @Override
    public IconitoPsSubscriptionRequestData clone() {
        IconitoPsSubscriptionRequestData result = new IconitoPsSubscriptionRequestData();
        
          
            
        result.setInvoiceBarCode(invoiceBarCode);
      
          
        
        return result;
    }

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
      @NotNull(
        
        
        profiles = {"iconito"},
        message = "invoiceBarCode"
      )
    
      @NotBlank(
        
        
        profiles = {"iconito"},
        message = "invoiceBarCode"
      )
    
    private String invoiceBarCode;

    public void setInvoiceBarCode(final String invoiceBarCode) {
        this.invoiceBarCode = invoiceBarCode;
    }

 
    @Column(name="invoice_bar_code"  )
      
    public String getInvoiceBarCode() {
        return this.invoiceBarCode;
    }
  
}

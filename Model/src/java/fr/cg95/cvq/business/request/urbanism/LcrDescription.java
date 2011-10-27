
package fr.cg95.cvq.business.request.urbanism;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.*;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.urbanism.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="lcr_description")
public class LcrDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Map<String, IConditionChecker> conditions =
        LimogesCongestionRequest.conditions;

    public LcrDescription() {
        super();
      
    }

    public final String modelToXmlString() {
        LcrDescriptionType object = (LcrDescriptionType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final LcrDescriptionType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        LcrDescriptionType lcrDescription = LcrDescriptionType.Factory.newInstance();
        int i = 0;
    
        lcrDescription.setLcrDetailHeight(this.lcrDetailHeight);
      
        lcrDescription.setLcrDetailWidth(this.lcrDetailWidth);
      
        lcrDescription.setLcrDetailLength(this.lcrDetailLength);
      
        lcrDescription.setLcrDetailOther(this.lcrDetailOther);
      
        if (this.lcrDetailDescription != null)
            lcrDescription.setLcrDetailDescription(fr.cg95.cvq.xml.request.urbanism.LcrDetailDescriptionType.Enum.forString(this.lcrDetailDescription.toString()));
      
        return lcrDescription;
    }

    public static LcrDescription xmlToModel(LcrDescriptionType lcrDescriptionDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        LcrDescription lcrDescription = new LcrDescription();
    
        lcrDescription.setLcrDetailHeight(lcrDescriptionDoc.getLcrDetailHeight());
      
        lcrDescription.setLcrDetailWidth(lcrDescriptionDoc.getLcrDetailWidth());
      
        lcrDescription.setLcrDetailLength(lcrDescriptionDoc.getLcrDetailLength());
      
        lcrDescription.setLcrDetailOther(lcrDescriptionDoc.getLcrDetailOther());
      
        if (lcrDescriptionDoc.getLcrDetailDescription() != null)
            lcrDescription.setLcrDetailDescription(fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType.forString(lcrDescriptionDoc.getLcrDetailDescription().toString()));
        else
            lcrDescription.setLcrDetailDescription(fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType.getDefaultLcrDetailDescriptionType());
      
        return lcrDescription;
    }

    @Override
    public LcrDescription clone() {
        LcrDescription result = new LcrDescription();
        
          
            
        result.setLcrDetailHeight(lcrDetailHeight);
      
          
        
          
            
        result.setLcrDetailWidth(lcrDetailWidth);
      
          
        
          
            
        result.setLcrDetailLength(lcrDetailLength);
      
          
        
          
            
        result.setLcrDetailOther(lcrDetailOther);
      
          
        
          
            
        if (lcrDetailDescription != null)
            result.setLcrDetailDescription(lcrDetailDescription);
        else
            result.setLcrDetailDescription(fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType.getDefaultLcrDetailDescriptionType());
      
          
        
        return result;
    }

    private Long id;

    public final void setId(final Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public final Long getId() {
        return this.id;
    }

  
    
    private String lcrDetailHeight;

    public void setLcrDetailHeight(final String lcrDetailHeight) {
        this.lcrDetailHeight = lcrDetailHeight;
    }


    @Column(name="lcr_detail_height"  )
      
    public String getLcrDetailHeight() {
        return this.lcrDetailHeight;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrDetailWidth"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrDetailWidth"
      )
    
    private String lcrDetailWidth;

    public void setLcrDetailWidth(final String lcrDetailWidth) {
        this.lcrDetailWidth = lcrDetailWidth;
    }


    @Column(name="lcr_detail_width"  )
      
    public String getLcrDetailWidth() {
        return this.lcrDetailWidth;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrDetailLength"
      )
    
      @NotBlank(
        
        
        profiles = {"work"},
        message = "lcrDetailLength"
      )
    
    private String lcrDetailLength;

    public void setLcrDetailLength(final String lcrDetailLength) {
        this.lcrDetailLength = lcrDetailLength;
    }


    @Column(name="lcr_detail_length"  )
      
    public String getLcrDetailLength() {
        return this.lcrDetailLength;
    }
  
    
    private String lcrDetailOther;

    public void setLcrDetailOther(final String lcrDetailOther) {
        this.lcrDetailOther = lcrDetailOther;
    }


    @Column(name="lcr_detail_other"  )
      
    public String getLcrDetailOther() {
        return this.lcrDetailOther;
    }
  
    
      @NotNull(
        
        
        profiles = {"work"},
        message = "lcrDetailDescription"
      )
    
    private fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType lcrDetailDescription;

    public void setLcrDetailDescription(final fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType lcrDetailDescription) {
        this.lcrDetailDescription = lcrDetailDescription;
    }


    @Enumerated(EnumType.STRING)
    @Column(name="lcr_detail_description"  )
      
    public fr.cg95.cvq.business.request.urbanism.LcrDetailDescriptionType getLcrDetailDescription() {
        return this.lcrDetailDescription;
    }
  
}

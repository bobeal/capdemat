
package fr.cg95.cvq.business.request.social;

import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalTime;

import net.sf.oval.constraint.*;
import org.apache.xmlbeans.XmlOptions;
import fr.cg95.cvq.business.authority.*;
import fr.cg95.cvq.business.request.*;
import fr.cg95.cvq.business.users.*;
import fr.cg95.cvq.xml.common.RequestType;
import fr.cg95.cvq.xml.common.*;
import fr.cg95.cvq.xml.request.social.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;
import javax.persistence.*;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

/**
 * Generated class file, do not edit !
 */
@Entity
@Table(name="hccr_other_folder")
public class HccrOtherFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    public HccrOtherFolder() {
        super();
      
    }

    public final String modelToXmlString() {
        HccrOtherFolderType object = (HccrOtherFolderType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final HccrOtherFolderType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        HccrOtherFolderType hccrOtherFolder = HccrOtherFolderType.Factory.newInstance();
        int i = 0;
    
        hccrOtherFolder.setOtherFolderDepartment(this.otherFolderDepartment);
      
        hccrOtherFolder.setOtherFolderName(this.otherFolderName);
      
        hccrOtherFolder.setOtherFolderNumber(this.otherFolderNumber);
      
        return hccrOtherFolder;
    }

    public static HccrOtherFolder xmlToModel(HccrOtherFolderType hccrOtherFolderDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        HccrOtherFolder hccrOtherFolder = new HccrOtherFolder();
    
        hccrOtherFolder.setOtherFolderDepartment(hccrOtherFolderDoc.getOtherFolderDepartment());
      
        hccrOtherFolder.setOtherFolderName(hccrOtherFolderDoc.getOtherFolderName());
      
        hccrOtherFolder.setOtherFolderNumber(hccrOtherFolderDoc.getOtherFolderNumber());
      
        return hccrOtherFolder;
    }

    @Override
    public HccrOtherFolder clone() {
        HccrOtherFolder result = new HccrOtherFolder();
        
          
            
        result.setOtherFolderDepartment(otherFolderDepartment);
      
          
        
          
            
        result.setOtherFolderName(otherFolderName);
      
          
        
          
            
        result.setOtherFolderNumber(otherFolderNumber);
      
          
        
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

  
    
      @MaxLength(
        
          value = 2,
        
        
        profiles = {"folders"},
        message = "otherFolderDepartment"
      )
    
    private String otherFolderDepartment;

    public void setOtherFolderDepartment(final String otherFolderDepartment) {
        this.otherFolderDepartment = otherFolderDepartment;
    }


    @Column(name="other_folder_department" , length=2 )
      
    public String getOtherFolderDepartment() {
        return this.otherFolderDepartment;
    }
  
    
      @MaxLength(
        
          value = 60,
        
        
        profiles = {"folders"},
        message = "otherFolderName"
      )
    
      @NotNull(
        
        
        profiles = {"folders"},
        message = "otherFolderName"
      )
    
      @NotBlank(
        
        
        profiles = {"folders"},
        message = "otherFolderName"
      )
    
    private String otherFolderName;

    public void setOtherFolderName(final String otherFolderName) {
        this.otherFolderName = otherFolderName;
    }


    @Column(name="other_folder_name" , length=60 )
      
    public String getOtherFolderName() {
        return this.otherFolderName;
    }
  
    
      @MaxLength(
        
          value = 30,
        
        
        profiles = {"folders"},
        message = "otherFolderNumber"
      )
    
    private String otherFolderNumber;

    public void setOtherFolderNumber(final String otherFolderNumber) {
        this.otherFolderNumber = otherFolderNumber;
    }


    @Column(name="other_folder_number" , length=30 )
      
    public String getOtherFolderNumber() {
        return this.otherFolderNumber;
    }
  
}

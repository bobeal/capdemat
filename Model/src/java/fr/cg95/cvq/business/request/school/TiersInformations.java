
package fr.cg95.cvq.business.request.school;

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
import fr.cg95.cvq.xml.request.school.*;
import fr.cg95.cvq.service.request.LocalReferential;
import fr.cg95.cvq.service.request.condition.IConditionChecker;

/**
 * Generated class file, do not edit !
 *
 * @hibernate.class
 *  table="tiers_informations"
 *  lazy="false"
 */
public class TiersInformations implements Serializable {

    private static final long serialVersionUID = 1L;

    public TiersInformations() {
        super();
      
    }

    public final String modelToXmlString() {
        TiersInformationsType object = (TiersInformationsType) this.modelToXml();
        XmlOptions opts = new XmlOptions();
        opts.setSavePrettyPrint();
        opts.setSavePrettyPrintIndent(4);
        opts.setUseDefaultNamespace();
        opts.setCharacterEncoding("UTF-8");
        return object.xmlText(opts);
    }

    public final TiersInformationsType modelToXml() {
        
        Calendar calendar = Calendar.getInstance();
        Date date = null;
        LocalTime localTime = new LocalTime();
        TiersInformationsType tiersInformations = TiersInformationsType.Factory.newInstance();
        int i = 0;
    
        tiersInformations.setTiersNom(this.tiersNom);
      
        tiersInformations.setTiersPrenom(this.tiersPrenom);
      
        tiersInformations.setTiersTelephone(this.tiersTelephone);
      
        return tiersInformations;
    }

    public static TiersInformations xmlToModel(TiersInformationsType tiersInformationsDoc) {
        Calendar calendar = Calendar.getInstance();
        LocalTime localTime = new LocalTime();
        List list = new ArrayList();
        TiersInformations tiersInformations = new TiersInformations();
    
        tiersInformations.setTiersNom(tiersInformationsDoc.getTiersNom());
      
        tiersInformations.setTiersPrenom(tiersInformationsDoc.getTiersPrenom());
      
        tiersInformations.setTiersTelephone(tiersInformationsDoc.getTiersTelephone());
      
        return tiersInformations;
    }

    @Override
    public TiersInformations clone() {
        TiersInformations result = new TiersInformations();
        
          
            
        result.setTiersNom(tiersNom);
      
          
        
          
            
        result.setTiersPrenom(tiersPrenom);
      
          
        
          
            
        result.setTiersTelephone(tiersTelephone);
      
          
        
        return result;
    }

    private Long id;

    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * @hibernate.id
     *  column="id"
     *  generator-class="sequence"
     */
    public final Long getId() {
        return this.id;
    }

  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"autorisations"},
        message = "tiersNom"
      )
    
      @NotNull(
        
        
        profiles = {"autorisations"},
        message = "tiersNom"
      )
    
      @NotBlank(
        
        
        profiles = {"autorisations"},
        message = "tiersNom"
      )
    
    private String tiersNom;

    public final void setTiersNom(final String tiersNom) {
        this.tiersNom = tiersNom;
    }

    /**
  
        * @hibernate.property
        *  column="tiers_nom"
        *  length="38"
      
    */
    public final String getTiersNom() {
        return this.tiersNom;
    }
  
    
      @MaxLength(
        
          value = 38,
        
        
        profiles = {"autorisations"},
        message = "tiersPrenom"
      )
    
      @NotNull(
        
        
        profiles = {"autorisations"},
        message = "tiersPrenom"
      )
    
      @NotBlank(
        
        
        profiles = {"autorisations"},
        message = "tiersPrenom"
      )
    
    private String tiersPrenom;

    public final void setTiersPrenom(final String tiersPrenom) {
        this.tiersPrenom = tiersPrenom;
    }

    /**
  
        * @hibernate.property
        *  column="tiers_prenom"
        *  length="38"
      
    */
    public final String getTiersPrenom() {
        return this.tiersPrenom;
    }
  
    
      @MaxLength(
        
          value = 10,
        
        
        profiles = {"autorisations"},
        message = "tiersTelephone"
      )
    
      @NotNull(
        
        
        profiles = {"autorisations"},
        message = "tiersTelephone"
      )
    
      @NotBlank(
        
        
        profiles = {"autorisations"},
        message = "tiersTelephone"
      )
    
    private String tiersTelephone;

    public final void setTiersTelephone(final String tiersTelephone) {
        this.tiersTelephone = tiersTelephone;
    }

    /**
  
        * @hibernate.property
        *  column="tiers_telephone"
        *  length="10"
      
    */
    public final String getTiersTelephone() {
        return this.tiersTelephone;
    }
  
}

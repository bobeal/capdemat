package fr.cg95.cvq.business.payment;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

@Entity
@Inheritance
public abstract class ExternalAccountItem extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_SERVICE_LABEL = "externalServiceLabel";
    public static final String SEARCH_BY_EXTERNAL_HOME_FOLDER = "externalHomeFolderId";
    public static final String SEARCH_BY_EXTERNAL_APPLICATION = "externalApplication";

    @Column(name="external_service_label")
    private String externalServiceLabel;

    @Column(name="external_item_id")
    private String externalItemId;

    @Column(name="external_application_id")
    private String externalApplicationId;

    @Column(name="external_home_folder_id")
    private String externalHomeFolderId;

    @Column(name="external_individual_id")
    private String externalIndividualId;

    /** 
     * Used to pass external service providers specific information, eg the child's card 
     * serial number for school canteen registrations. These informations are not persisted.
     */
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="purchase_item_specific_data", joinColumns=@JoinColumn(name="id"))
    @MapKeyColumn(name="key")
    @Column(name="value")
    private Map<String, String> externalServiceSpecificData = new HashMap<String, String>();
    
    public ExternalAccountItem(final String label, final Double amount,
            final String externalServiceLabel, final String externalItemId,
            final String broker) {
        super(label, amount, broker);
        this.externalServiceLabel = externalServiceLabel;
        this.externalItemId = externalItemId;
    }

    public ExternalAccountItem() {
        super();
    }

    public final String getExternalItemId() {
        return externalItemId;
    }

    public final void setExternalItemId(String externalItemId) {
        this.externalItemId = externalItemId;
    }

    public final String getExternalServiceLabel() {
        return externalServiceLabel;
    }

    public final void setExternalServiceLabel(String externalServiceLabel) {
        this.externalServiceLabel = externalServiceLabel;
    }

    public String getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(String externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }

    public String getExternalHomeFolderId() {
        return externalHomeFolderId;
    }

    public void setExternalHomeFolderId(String externalHomeFolderId) {
        this.externalHomeFolderId = externalHomeFolderId;
    }

    public String getExternalIndividualId() {
        return externalIndividualId;
    }

    public void setExternalIndividualId(String externalIndividualId) {
        this.externalIndividualId = externalIndividualId;
    }

    public void addExternalServiceSpecificData(final String key, final String value) {
        this.externalServiceSpecificData.put(key, value);
    }

    public String getExternalServiceSpecificDataByKey(final String key) {
        return this.externalServiceSpecificData.get(key);
    }

    public void removeExternalServiceSpecificData(final String key) {
        this.externalServiceSpecificData.remove(key);
    }

    public Map<String, String> getExternalServiceSpecificData() {
        return this.externalServiceSpecificData;
    }

    public void setExternalServiceSpecificData(Map<String, String> externalServiceSpecificData) {
        this.externalServiceSpecificData = externalServiceSpecificData;
    }
}

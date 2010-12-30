package fr.cg95.cvq.business.payment;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @hibernate.subclass
 * lazy="false"
 * 
 * @author bor@zenexity.fr
 */
public abstract class ExternalAccountItem extends PurchaseItem {

    private static final long serialVersionUID = 1L;

    public static final String SEARCH_BY_EXTERNAL_SERVICE_LABEL = "externalServiceLabel";
    public static final String SEARCH_BY_EXTERNAL_HOME_FOLDER = "externalHomeFolderId";

    private String externalServiceLabel;
    private String externalItemId;

    private String externalApplicationId;
    private String externalHomeFolderId;
    private String externalIndividualId;

    /** 
     * Used to pass external service providers specific information, eg the child's card 
     * serial number for school canteen registrations. These informations are not persisted.
     */
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

    /**
     * @hibernate.property
     *  column="external_item_id"
     */
    public final String getExternalItemId() {
        return externalItemId;
    }

    public final void setExternalItemId(String externalItemId) {
        this.externalItemId = externalItemId;
    }

    /**
     * @hibernate.property
     *  column="external_service_label"
     */
    public final String getExternalServiceLabel() {
        return externalServiceLabel;
    }

    public final void setExternalServiceLabel(String externalServiceLabel) {
        this.externalServiceLabel = externalServiceLabel;
    }

    /**
     * @hibernate.property
     *  column="external_application_id"
     */
    public String getExternalApplicationId() {
        return externalApplicationId;
    }

    public void setExternalApplicationId(String externalApplicationId) {
        this.externalApplicationId = externalApplicationId;
    }

    /**
     * @hibernate.property
     *  column="external_home_folder_id"
     */
    public String getExternalHomeFolderId() {
        return externalHomeFolderId;
    }

    public void setExternalHomeFolderId(String externalHomeFolderId) {
        this.externalHomeFolderId = externalHomeFolderId;
    }

    /**
     * @hibernate.property
     *  column="external_individual_id"
     */
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

    /**
     * @hibernate.map
     *  lazy="false"
     *  cascade="all"
     *  table="purchase_item_specific_data"
     * @hibernate.key
     *  column="id"
     * @hibernate.index
     *  column="key"
     *  type="string"
     * @hibernate.element
     *  column="value"
     *  type="string"
     */
    public Map<String, String> getExternalServiceSpecificData() {
        return this.externalServiceSpecificData;
    }

    public void setExternalServiceSpecificData(Map<String, String> externalServiceSpecificData) {
        this.externalServiceSpecificData = externalServiceSpecificData;
    }
}

package fr.cg95.cvq.business.users;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import fr.cg95.cvq.xml.common.AddressType;


/**
 * @hibernate.class
 *  table="address"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class Address implements fr.cg95.cvq.business.Historizable,Serializable,Cloneable {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    private Long id;
    
    private String additionalDeliveryInformation;
    private String additionalGeographicalInformation;
    private String streetNumber;
    private String streetName;
    private String placeNameOrService;
    private String postalCode;
    private String city;
    private String countryName;

    public Address() {
    }

    public Address(String streetNumber,String streetName,String postalCode,String city) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public static AddressType modelToXml(Address address) {

        AddressType addressType = AddressType.Factory.newInstance();
        if (address.getId() != null)
            addressType.setId(address.getId().longValue());
        addressType.setAdditionalDeliveryInformation(address.getAdditionalDeliveryInformation());
        addressType.setAdditionalGeographicalInformation(address.getAdditionalGeographicalInformation());
        addressType.setStreetNumber(address.getStreetNumber());
        addressType.setStreetName(address.getStreetName());
        addressType.setPostalCode(address.getPostalCode());
        addressType.setCity(address.getCity());
        addressType.setPlaceNameOrService(address.getPlaceNameOrService());
        addressType.setCountryName(address.getCountryName());
        return addressType;
    }

    public static Address xmlToModel(AddressType addressType) {

        if (addressType != null) {
            Address address = 
                new Address(addressType.getStreetNumber(), addressType.getStreetName(),
                    addressType.getPostalCode(), addressType.getCity());
            if (addressType.getId() != 0)
                address.setId(new Long(addressType.getId()));
            address.setAdditionalDeliveryInformation(addressType.getAdditionalDeliveryInformation());
            address.setAdditionalGeographicalInformation(addressType.getAdditionalGeographicalInformation());
            address.setPlaceNameOrService(addressType.getPlaceNameOrService());
            address.setCountryName(addressType.getCountryName());

            return address;
        } else {
            return null;
        }
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="additional_delivery_information"
     *  length="38"
     */
    public String getAdditionalDeliveryInformation() {
        return additionalDeliveryInformation;
    }

    public void setAdditionalDeliveryInformation(String additionalDeliveryInformation) {
        this.additionalDeliveryInformation = additionalDeliveryInformation;
    }

    /**
     * @hibernate.property
     *  column="additional_geographical_information"
     *  length="38"
     */
    public String getAdditionalGeographicalInformation() {
        return additionalGeographicalInformation;
    }

    public void setAdditionalGeographicalInformation(String additionalGeographicalInformation) {
        this.additionalGeographicalInformation = additionalGeographicalInformation;
    }

    /**
     * @hibernate.property
     *  column="street_number"
     *  length="5"
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        if (streetNumber != null)
            this.streetNumber = streetNumber.toUpperCase();
    }

    /**
     * @hibernate.property
     *  column="street_name"
     *  length="32"
     */
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        if (streetName != null)
            this.streetName = streetName.toUpperCase();
    }

    /**
     * @hibernate.property
     *  column="place_name_or_service"
     *  length="38"
     */
    public String getPlaceNameOrService() {
        return placeNameOrService;
    }

    public void setPlaceNameOrService(String placeNameOrService) {
        if (placeNameOrService != null)
            this.placeNameOrService = placeNameOrService.toUpperCase();
    }

    /**
     * @hibernate.property
     *  column="postal_code"
     *  length="5"
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @hibernate.property
     *  column="city"
     *  length="32"
     */
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        if (city != null)
            this.city = city.toUpperCase();
    }

    /**
     * @hibernate.property
     *  column="country_name"
     *  length="38"
     */
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        if (countryName != null)
            this.countryName = countryName.toUpperCase();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    @Override
    public Address clone() {
        Address clone = new Address(streetNumber, streetName, postalCode, city);
        clone.additionalDeliveryInformation = additionalDeliveryInformation;
        clone.additionalGeographicalInformation = additionalGeographicalInformation;
        clone.countryName = countryName;
        clone.placeNameOrService = placeNameOrService;
        return clone;
    }
}

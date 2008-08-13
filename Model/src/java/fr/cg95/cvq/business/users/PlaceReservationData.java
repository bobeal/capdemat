package fr.cg95.cvq.business.users;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.cg95.cvq.xml.common.PlaceReservationDataType;
import fr.cg95.cvq.xml.common.TicketTypeSelectionType;


/**
 * @hibernate.class
 *  table="place_reservation_data"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class PlaceReservationData implements Serializable {

	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long id;
    private String name;
    private Set tickets;

    public PlaceReservationData() {}

    public static PlaceReservationDataType modelToXml(PlaceReservationData placeReservationData) {

        PlaceReservationDataType placeReservationDataType =
            PlaceReservationDataType.Factory.newInstance();
        if (placeReservationData.getId() != null)
        		placeReservationDataType.setId(placeReservationData.getId().longValue());
        placeReservationDataType.setName(placeReservationData.getName());
        if (placeReservationData.getTickets() != null) {
            TicketTypeSelectionType[] ttsTab =
                new TicketTypeSelectionType[placeReservationData.getTickets().size()];
            int i = 0;
            Iterator ticketsIt = placeReservationData.getTickets().iterator();
            while (ticketsIt.hasNext()) {
                TicketTypeSelection tts = (TicketTypeSelection) ticketsIt.next();
                ttsTab[i] = TicketTypeSelection.modelToXml(tts);
                i++;
            }
            placeReservationDataType.setTicketTypeSelectionArray(ttsTab);
        }
        return placeReservationDataType;
    }

    public static PlaceReservationData xmlToModel(PlaceReservationDataType placeReservationDataType) {

        PlaceReservationData placeReservationData = new PlaceReservationData();
        if (placeReservationDataType.getId() != 0)
            placeReservationData.setId(new Long(placeReservationDataType.getId()));
        placeReservationData.setName(placeReservationDataType.getName());
        HashSet ticketsSet = new HashSet();
        if (placeReservationDataType.sizeOfTicketTypeSelectionArray() > 0) {
            for (int i = 0; i < placeReservationDataType.getTicketTypeSelectionArray().length; i++) {
                TicketTypeSelection tempData =
                    TicketTypeSelection.xmlToModel(placeReservationDataType.getTicketTypeSelectionArray (i));
                ticketsSet.add(tempData);
            }
        }
        placeReservationData.setTickets(ticketsSet);

        return placeReservationData;
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
     *  column="name"
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.set
     *  table="place_reservation_association"
     *  inverse="false"
     *  lazy="true"
     *  cascade="all-delete-orphan"
     * @hibernate.key
     *  column="place_reservation_data_id"
     * @hibernate.one-to-many
     *  class="fr.cg95.cvq.business.users.TicketTypeSelection"
     */
    public Set getTickets() {
        return this.tickets;
    }

    public void setTickets(Set tickets) {
        this.tickets = tickets;
    }
}

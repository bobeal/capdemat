package fr.cg95.cvq.business.request;

import fr.cg95.cvq.xml.common.TicketTypeSelectionType;

/**
 * @hibernate.class
 *  table="ticket_type_selection"
 *  lazy="false"
 *
 * @author bor@zenexity.fr
 */
public class TicketTypeSelection {

    private static final long serialVersionUID = 1L;

    /** identifier field */
    private Long id;
    private String name;
    private Long number;

    public TicketTypeSelection() {
    }

    public static TicketTypeSelectionType modelToXml(TicketTypeSelection ticketTypeSelection) {

        TicketTypeSelectionType ticketTypeSelectionType = 
            TicketTypeSelectionType.Factory.newInstance();
        if (ticketTypeSelection.getId() != null)
            ticketTypeSelectionType.setId(ticketTypeSelection.getId().longValue());
        ticketTypeSelectionType.setName(ticketTypeSelection.getName());
        if (ticketTypeSelection.getNumber() != null)
        	ticketTypeSelectionType.setNumber(ticketTypeSelection.getNumber().longValue());

        return ticketTypeSelectionType;
    }
    
    public static TicketTypeSelection xmlToModel(TicketTypeSelectionType ticketTypeSelectionType) {

        TicketTypeSelection ticketTypeSelection = new TicketTypeSelection();
        if (ticketTypeSelectionType.getId() != 0)
            ticketTypeSelection.setId(new Long(ticketTypeSelectionType.getId()));
        ticketTypeSelection.setName(ticketTypeSelectionType.getName());
        ticketTypeSelection.setNumber(new Long(ticketTypeSelectionType.getNumber()));
        
        return ticketTypeSelection;
    }

    /**
     * @hibernate.id
     *  generator-class="sequence"
     *  column="id"
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @hibernate.property
     *  column="name"
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.property
     *  column="number"
     */
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}

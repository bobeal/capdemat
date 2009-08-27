package fr.cg95.cvq.generator.plugins.xslfo;

/**
 * @author bor@zenexity.fr
 */
public class PlaceReservationElement extends Element {

    public PlaceReservationElement() {
        super();
    }

    public PlaceReservationElement(Element element) {
        super(element);
    }

    @Override
    public String getDisplayType() {
        return "place_reservation";
    }
}

package fr.cg95.cvq.business.request;

import java.util.HashMap;
import java.util.Map;

import fr.cg95.cvq.business.CapDematEvent;

public class RequestEvent extends CapDematEvent {

    private static final long serialVersionUID = 1L;

    public static enum EVENT_TYPE { STATE_CHANGED, REQUEST_CREATED, REQUEST_CLONED, REQUEST_VALIDATED, REQUEST_DELETED, NOTE_ADDED }
    public static enum COMP_DATA { PDF_FILE, REQUEST_NOTE }
    
    private EVENT_TYPE event;
    private Request request;
    private Map<COMP_DATA, Object> complementaryData;
    
    public RequestEvent(Object source, EVENT_TYPE event, Request request) {
        super(source);
        this.event = event;
        this.request = request;
        this.complementaryData = new HashMap<COMP_DATA, Object>();
    }

    public RequestEvent(Object source, EVENT_TYPE event, Request request, byte[] pdfData) {
        super(source);
        this.event = event;
        this.request = request;
        this.complementaryData = new HashMap<COMP_DATA, Object>();
        if (pdfData != null)
            this.addComplementaryData(COMP_DATA.PDF_FILE, pdfData);
    }

    public EVENT_TYPE getEvent() {
        return event;
    }

    public Request getRequest() {
        return request;
    }

    public void addComplementaryData(final COMP_DATA compData, final Object value) {
        this.complementaryData.put(compData, value);
    }
    
    public Object getComplementaryData(final COMP_DATA compData) {
        return this.complementaryData.get(compData);
    }
}

package fr.cg95.cvq.dao.request.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import fr.cg95.cvq.business.request.RequestState;

public class JaxbRequestStateAdapter extends XmlAdapter<String, RequestState> {

    @Override
    public RequestState unmarshal(String state) {
        return RequestState.forString(state);
    }

    @Override
    public String marshal(RequestState state) {
        return state.toString();
    }
}

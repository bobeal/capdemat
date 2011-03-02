package fr.cg95.cvq.dao.users.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import fr.cg95.cvq.business.users.UserState;

public class JaxbUserStateAdapter extends XmlAdapter<String, UserState> {

    @Override
    public UserState unmarshal(String state) {
        return UserState.forString(state);
    }

    @Override
    public String marshal(UserState state) {
        return state.toString();
    }
}

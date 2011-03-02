package fr.cg95.cvq.business.users;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.ArrayUtils;

import fr.cg95.cvq.dao.users.xml.JaxbUserStateAdapter;
import fr.cg95.cvq.security.SecurityContext;

@XmlRootElement(name = "workflow")
public class UserWorkflow {

    private static class State {

        @XmlAttribute
        public String name;

        @XmlElementWrapper(name="properties")
        @XmlElement(name="property")
        public List<String> properties = new ArrayList<String>();
    }

    private static class Transition {

        @XmlAttribute
        @XmlJavaTypeAdapter(JaxbUserStateAdapter.class)
        public UserState from;

        @XmlAttribute
        @XmlJavaTypeAdapter(JaxbUserStateAdapter.class)
        public UserState to;

        @XmlElement(name="context")
        public List<String> contexts;
    }

    public static UserWorkflow load(File file) {
        UserWorkflow workflow;
        try {
            workflow = (UserWorkflow) JAXBContext.newInstance(UserWorkflow.class).createUnmarshaller().unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        workflow.init();
        return workflow;
    }

    private void init() {
        for (Transition transition : transitions) {
            List<Transition> possibleTransitionsList = possibleTransitionsMap.get(transition.from);
            if (possibleTransitionsList == null) {
                possibleTransitionsList = new ArrayList<Transition>();
            }
            possibleTransitionsList.add(transition);
            possibleTransitionsMap.put(transition.from, possibleTransitionsList);
            List<Transition> beforeStatesList = beforeStatesMap.get(transition.to);
            if (beforeStatesList == null) {
                beforeStatesList = new ArrayList<Transition>();
            }
            beforeStatesList.add(transition);
            beforeStatesMap.put(transition.to, beforeStatesList);
        }
        for (State state : states) {
            for (String property : state.properties) {
                List<UserState> statesForPropertyList = statesProperties.get(property);
                if (statesForPropertyList == null) {
                    statesForPropertyList = new ArrayList<UserState>();
                }
                statesForPropertyList.add(UserState.forString(state.name));
                statesProperties.put(property, statesForPropertyList);
            }
        }
    }

    @XmlElement(name="state")
    public List<State> states = new ArrayList<State>();

    @XmlElement(name="transition")
    public List<Transition> transitions = new ArrayList<Transition>();

    private Map<UserState, List<Transition>> possibleTransitionsMap = new HashMap<UserState, List<Transition>>();
    private Map<UserState, List<Transition>> beforeStatesMap = new HashMap<UserState, List<Transition>>();
    private Map<String, List<UserState>> statesProperties = new HashMap<String, List<UserState>>();

    private UserWorkflow() {}

    public UserState[] getPossibleTransitions(UserState state) {
        Set<UserState> result = new TreeSet<UserState>();
        List<Transition> all = possibleTransitionsMap.get(state);
        if (all != null) {
            String context = SecurityContext.getCurrentContext();
            for (Transition transition : all) {
                if (SecurityContext.ADMIN_CONTEXT.equals(context) || transition.contexts == null
                    || transition.contexts.contains(context)) {
                    result.add(transition.to);
                }
            }
        }
        return result.toArray(new UserState[result.size()]);
    }

    public UserState[] getStatesBefore(UserState state) {
        Set<UserState> result = new TreeSet<UserState>();
        List<Transition> all = beforeStatesMap.get(state);
        if (all != null) {
            String context = SecurityContext.getCurrentContext();
            for (Transition transition : all) {
                if (SecurityContext.ADMIN_CONTEXT.equals(context) || transition.contexts == null
                    || transition.contexts.contains(context)) {
                    result.add(transition.from);
                }
            }
        }
        return result.toArray(new UserState[result.size()]);
    }

    public boolean isValidTransition(UserState from, UserState to) {
        return ArrayUtils.contains(getPossibleTransitions(from), to);
    }

    public UserState[] getStatesWithProperty(String propertyName) {
        List<UserState> result = statesProperties.get(propertyName);
        if (result == null) result = new ArrayList<UserState>();
        return result.toArray(new UserState[result.size()]);
    }
}

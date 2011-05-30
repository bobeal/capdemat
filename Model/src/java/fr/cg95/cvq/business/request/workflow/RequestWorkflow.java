package fr.cg95.cvq.business.request.workflow;

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

import fr.cg95.cvq.business.request.RequestState;
import fr.cg95.cvq.dao.request.xml.JaxbRequestStateAdapter;
import fr.cg95.cvq.security.SecurityContext;

@XmlRootElement(name = "workflow")
public class RequestWorkflow {

    private static class State {

        @XmlAttribute
        public String name;

        @XmlElementWrapper(name="properties")
        @XmlElement(name="property")
        public List<String> properties = new ArrayList<String>();
    }

    private static class Transition {

        @XmlAttribute
        @XmlJavaTypeAdapter(JaxbRequestStateAdapter.class)
        public RequestState from;

        @XmlAttribute
        @XmlJavaTypeAdapter(JaxbRequestStateAdapter.class)
        public RequestState to;

        @XmlElement(name="context")
        public List<String> contexts;
    }

    public static RequestWorkflow load(File file) {
        RequestWorkflow workflow;
        try {
            workflow = (RequestWorkflow) JAXBContext.newInstance(RequestWorkflow.class).createUnmarshaller().unmarshal(file);
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
                List<RequestState> statesForPropertyList = statesProperties.get(property);
                if (statesForPropertyList == null) {
                    statesForPropertyList = new ArrayList<RequestState>();
                }
                statesForPropertyList.add(RequestState.forString(state.name));
                statesProperties.put(property, statesForPropertyList);
            }
        }
    }

    @XmlElement(name="state")
    public List<State> states = new ArrayList<State>();

    @XmlElement(name="transition")
    public List<Transition> transitions = new ArrayList<Transition>();

    private Map<RequestState, List<Transition>> possibleTransitionsMap = new HashMap<RequestState, List<Transition>>();
    private Map<RequestState, List<Transition>> beforeStatesMap = new HashMap<RequestState, List<Transition>>();
    private Map<String, List<RequestState>> statesProperties = new HashMap<String, List<RequestState>>();

    private RequestWorkflow() {}

    public RequestState[] getPossibleTransitions(RequestState state) {
        Set<RequestState> result = new TreeSet<RequestState>();
        List<Transition> all = possibleTransitionsMap.get(state);
        if (all != null) {
            String context = SecurityContext.getCurrentContext();
            for (Transition transition : all) {
                if (transition.contexts == null || transition.contexts.contains(context)) {
                    result.add(transition.to);
                }
            }
        }
        return result.toArray(new RequestState[result.size()]);
    }

    public RequestState[] getStatesBefore(RequestState state) {
        Set<RequestState> result = new TreeSet<RequestState>();
        List<Transition> all = beforeStatesMap.get(state);
        if (all != null) {
            String context = SecurityContext.getCurrentContext();
            for (Transition transition : all) {
                if (transition.contexts == null || transition.contexts.contains(context)) {
                    result.add(transition.from);
                }
            }
        }
        return result.toArray(new RequestState[result.size()]);
    }

    public boolean isValidTransition(RequestState from, RequestState to) {
        return ArrayUtils.contains(getPossibleTransitions(from), to);
    }

    public RequestState[] getStatesWithProperty(String propertyName) {
        List<RequestState> result = statesProperties.get(propertyName);
        if (result == null) result = new ArrayList<RequestState>();
        return result.toArray(new RequestState[result.size()]);
    }
}

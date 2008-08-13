package fr.cg95.cvq.wizard.process;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.struts.util.RequestUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import fr.cg95.cvq.wizard.DateUtils;
import fr.cg95.cvq.wizard.IProcessWizard;
import fr.cg95.cvq.wizard.IStageForm;
import fr.cg95.cvq.wizard.IWizardSession;
import fr.cg95.cvq.wizard.ReferentialData;
import fr.cg95.cvq.wizard.StringUtils;
import fr.cg95.cvq.wizard.process.xmlbean.ActionType;
import fr.cg95.cvq.wizard.process.xmlbean.ButtonType;
import fr.cg95.cvq.wizard.process.xmlbean.ConditionType;
import fr.cg95.cvq.wizard.process.xmlbean.ConfirmType;
import fr.cg95.cvq.wizard.process.xmlbean.ContentType;
import fr.cg95.cvq.wizard.process.xmlbean.DisplayType;
import fr.cg95.cvq.wizard.process.xmlbean.MenuType;
import fr.cg95.cvq.wizard.process.xmlbean.OverrideType;
import fr.cg95.cvq.wizard.process.xmlbean.ProcessType;
import fr.cg95.cvq.wizard.process.xmlbean.SelectType;
import fr.cg95.cvq.wizard.process.xmlbean.SessionType;
import fr.cg95.cvq.wizard.process.xmlbean.StageType;
import fr.cg95.cvq.wizard.process.xmlbean.StateType;
import fr.cg95.cvq.wizard.process.xmlbean.TimeoutType;

public class ProcessWizard implements IProcessWizard {

    private final static int WELCOME_STAGE = Integer.MIN_VALUE + 10;

    private final static String DEFAULT_ACTION = "processSelect.do";

    /** Commons Logging instance. */
    protected static Logger log = Logger.getLogger(ProcessWizard.class);

    private ProcessType xmlbProcess = null;

    private ProcessWizard xmlbParent = null;

    public ProcessWizard(ProcessType xmlbProcess) {
        super();
        this.xmlbProcess = xmlbProcess;
    }

    public ProcessType getProcess() {
        return xmlbProcess;
    }

    /**
     * Initialise the wizard in the given PageContext - Find and set the images used - Try to get the current
     * wizardState, if not create one
     */
    void init(PageContext pageContext) throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        ProcessWizardState wizardState = null;
        try {
            wizardState = (ProcessWizardState) request.getSession().getAttribute(
                    ProcessWizardState.SESSION_KEY);
        } catch (Exception e) {
            wizardState = null;
        }
        if (wizardState == null) {
            wizardState = new ProcessWizardState();
            request.getSession().setAttribute(ProcessWizardState.SESSION_KEY, wizardState);
        }
        wizardState.setProcess(xmlbProcess);

        boolean initialize = false;
        if (ProcessWizardPlugin.getParameter(request, ProcessWizardState.NAME_REQUEST_PARAMETER) != null) {
            // Start a new session for a procedure
            try {
                if (xmlbProcess.isSetWelcome())
                    wizardState.setStage(WELCOME_STAGE);

                SessionType xmlbSession = ProcessWizardPlugin.plugin().getGlobals().getSession();

                if (xmlbSession != null) {
                    IWizardSession sessionObject = (IWizardSession) request.getSession().getAttribute(
                            xmlbSession.getData());

                    if (sessionObject == null) {
                        sessionObject = (IWizardSession) Class.forName(xmlbSession.getType()).newInstance();
                        request.getSession().setAttribute(xmlbSession.getData(), sessionObject);
                    }
                    request.getSession().setAttribute(xmlbSession.getData(), sessionObject);
                    sessionObject.init(request.getSession(), 0);
                }
                checkHierarchy();
                checkStages(request);

            } catch (ClassNotFoundException cnfe) {
                log.error("init", cnfe);
            } catch (IllegalAccessException iae) {
                log.error("init", iae);
            } catch (InstantiationException ie) {
                log.error("init", ie);
            }
            initialize = true;
        }
        if (initialize) {
            wizardState.resetStage();
        }

        wizardState.setStageOk(checkStageAction(wizardState));
        if (wizardState.isStageOk()) {
            if (initialize) {
                if (wizardState.getXmlStage() != null)
                    wizardState.setState(wizardState.getXmlStage().getDefault());
            }
        }
    }

    void init(Servlet servlet, HttpServletRequest request, HttpServletResponse response) {
        JspFactory jspFactory = JspFactory.getDefaultFactory();
        PageContext pageContext = jspFactory.getPageContext(servlet, request, response, null, true, 8192, true);

        ProcessWizardState wizardState = new ProcessWizardState();
        request.getSession().setAttribute(ProcessWizardState.SESSION_KEY, wizardState);

        wizardState.setProcess(xmlbProcess);

        checkHierarchy();
        checkStages(request);
    }

    private void checkHierarchy() {
        if (xmlbProcess.isSetExtends() && (xmlbParent == null)) {
            xmlbParent = (ProcessWizard) ProcessWizardPlugin.plugin().getProcess(xmlbProcess.getExtends());

            if (!xmlbProcess.isSetPackage())
                xmlbProcess.setPackage(xmlbParent.getProcess().getPackage());

            if (xmlbProcess.sizeOfScriptArray() == 0)
                xmlbProcess.setScriptArray(xmlbParent.getProcess().getScriptArray());

            if (xmlbProcess.sizeOfStageArray() == 0)
                xmlbProcess.setStageArray(xmlbParent.getProcess().getStageArray());

            for (int i = 0; i < xmlbProcess.sizeOfOverrideArray(); i++) {
                OverrideType xmlbOverride = xmlbProcess.getOverrideArray(i);
                if (xmlbOverride.isSetStage2()) {
                    String stage = xmlbOverride.getStage2();
                    int index = ProcessWizardPlugin.findIndex(xmlbProcess.getStageArray(), "caption", stage);
                    if (index != -1) {
                        if (xmlbOverride.isSetStage())
                            xmlbProcess.setStageArray(index, xmlbOverride.getStage());
                        else
                            xmlbProcess.removeStage(index);
                    }
                }
            }
        }
    }

    private void checkStages(HttpServletRequest request) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        wizardState.setStageArray(xmlbProcess.getStageArray());

        for (int i = wizardState.sizeOfStageArray() - 1; i >= 0; i--) {
            if (!displayStage(request, getWizardStage(wizardState, i))) {
                if (i == 0)
                    wizardState.getStageArray(i + 1).setPrevious(getWizardStage(wizardState, i).getPrevious());

                wizardState.removeStage(i);
            }
        }
    }

    private boolean displayStage(HttpServletRequest request, StageType stage) {
        return evaluate(request, stage.getCondition());
    }

    private boolean evaluate(HttpServletRequest request, ConditionType xmlbCondition) {
        // Check the condition to display
        if (xmlbCondition != null) {
            ProcessWizardState wizardState = 
                (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
            
            Object condition = null;

            String property = xmlbCondition.getProperty();
            boolean inverse = false;
            if (property.startsWith("!")) {
                inverse = true;
                property = property.substring(1);
            }

            if (xmlbCondition.isSetName()) {
                condition = callGetMethod(request, xmlbCondition.getName(), property);

            } else if (wizardState.getXmlStage() != null) {
                condition = callGetMethod(request, wizardState.getXmlStage().getName(), property);
            }

            if (condition != null) {
                if (condition instanceof Boolean)
                    // Condition object is a boolean, we display according to the boolean value
                    return (inverse) ? !((Boolean) condition).booleanValue() : ((Boolean) condition)
                            .booleanValue();

                // Condition object available and not a boolean, we display
                return (inverse) ? false : true;
            }
            // Condition object not available we do NOT display
            return false;
        }
        // No condition defined we display
        return true;
    }

    public void page(PageContext pageContext) throws JspException {
        boolean initialize = ProcessWizardPlugin.getParameter(pageContext.getRequest(),
                ProcessWizardState.NAME_REQUEST_PARAMETER) != null;
 
        ProcessWizardState wizardState = 
            (ProcessWizardState)pageContext.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        wizardState.setFrozen(false);
        // if (initialize) {
        // wizardState.resetStage();
        // }

        if (wizardState.isStageOk()) {
            // if (initialize) {
            // if (xmlbStage != null)
            // wizardState.setState(xmlbStage.getDefault());
            // }
            // checkValidState();
            wizardPage(pageContext);
        } else {
            wizardState.init();
        }
    }

    private boolean checkStageAction(ProcessWizardState wizardState) {
        int stage = wizardState.getStage();

        if ((stage >= 0) && (stage < wizardState.sizeOfStageArray())) {
            StageType xmlStage = getWizardStage(wizardState, stage);

            String state = wizardState.getState();
            if ((state.length() > 0) && (getState(xmlStage, state) == null)) {
                // The state action is not found in the current stage,
                // see if we can loacte the stage for the action
                stage = 0;
                while (stage < wizardState.sizeOfStageArray()) {
                    xmlStage = getWizardStage(wizardState, stage);
                    if (getState(xmlStage, state) != null) {
                        // We found the correct stage, position variables accordingly
                        wizardState.setStage(stage);
                        wizardState.setState(state);
                        wizardState.setXmlStage(xmlStage);
                        return true;
                    }
                    stage++;
                }
                // We didn't find the correct stage, so we reset the action
                xmlStage = getWizardStage(wizardState, wizardState.getStage());
                wizardState.setState(xmlStage.getDefault());
            }
            wizardState.setXmlStage(xmlStage);
            return true;

        } else if (stage == WELCOME_STAGE) {
            // We are at the start of the process, setup to display welcome page
            wizardState.setXmlStage(null);
            return true;
        }
        return false;
    }

    private void wizardPage(PageContext pageContext) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)pageContext.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        Template processTemplate = wizardState.getDisplayTemplate();
        if (processTemplate == null)
            processTemplate = ProcessWizardPlugin.plugin().getProcessTemplate();

        VelocityContext velocityContext = wizardState.getVelocityContext();
        if (((HttpServletRequest)pageContext.getRequest()).getSession() == null)
            log.error("WizardPage: Session null in PageContext Request.");

        velocityContext.put("pagecontext", pageContext);
        velocityContext.put("httprequest", pageContext.getRequest());
        velocityContext.put("global", ProcessWizardPlugin.plugin().getGlobals());
        velocityContext.put("wizard", this);
        velocityContext.put("wizardstate", wizardState);
        velocityContext.put("process", xmlbProcess);
        velocityContext.put("stage", wizardState.getXmlStage());
        velocityContext.put("year", DateUtils.getYear());

        try {
            processTemplate.setEncoding("UTF-8");
            processTemplate.merge(velocityContext, pageContext.getOut());

        } catch (ResourceNotFoundException e) {
            log.error("wizardPage", e);
        } catch (ParseErrorException e) {
            log.error("wizardPage", e);
        } catch (MethodInvocationException e) {
            log.error("wizardPage", e);
        } catch (Exception e) {
            log.error("wizardPage", e);
        }
    }

    public String getTimeout(HttpServletRequest request) {
        String result = null;
        TimeoutType xmlTimeout[] = ProcessWizardPlugin.plugin().getGlobals().getTimeoutArray();
        if (xmlTimeout != null) {
            for (int i = 0; i < xmlTimeout.length; i++) {
                if (xmlTimeout[i].isSetCookie() && hasCookie(request, xmlTimeout[i].getCookie()))
                    result = String.valueOf(xmlTimeout[i].getDelay().intValue() * 60 * 1000);
                else if (!xmlTimeout[i].isSetCookie())
                    result = String.valueOf(xmlTimeout[i].getDelay().intValue() * 60 * 1000);
            }
        }
        return result;
    }

    public String getTimeoutHref(HttpServletRequest request) {
        String result = null;
        TimeoutType xmlTimeout[] = ProcessWizardPlugin.plugin().getGlobals().getTimeoutArray();
        if (xmlTimeout != null) {
            for (int i = 0; i < xmlTimeout.length; i++) {
                if (xmlTimeout[i].isSetCookie() && hasCookie(request, xmlTimeout[i].getCookie()))
                    result = xmlTimeout[i].getHref();
                else if (!xmlTimeout[i].isSetCookie())
                    result = xmlTimeout[i].getHref();
            }
        }
        return result;
    }

    private boolean hasCookie(HttpServletRequest request, String cookie) {
        Cookie cookies[] = request.getCookies();

        if (cookies == null)
            return false;

        int i = 0;
        while ((i < cookies.length) && !cookies[i++].getName().equals(cookie))
            ;

        return (i < cookies.length);
    }

    public String baseReference(HttpServletRequest request) {
        String result = null;
        if (request != null) {
            result = request.getScheme() + "://" + request.getServerName();
            if (request.getScheme().equals("http") && (request.getServerPort() == 80))
                ;
            else if (request.getScheme().equals("https") && (request.getServerPort() == 443))
                ;
            else
                result += ":" + request.getServerPort();
            result += request.getContextPath() + "/";
        }
        return result;
    }

    public String getVersion(HttpServletRequest request) {
        try {
            String version = (String) callGetMethod(request, ProcessWizardPlugin.plugin().getGlobals().getSession()
                    .getData(), "version");
            if (version != null)
                return version;
        } catch (NullPointerException npe) {
        }
        return "0.0";
    }

    private String navigation(HttpServletRequest request, int direction, String stage, String prefix, String postfix) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        int stageValue = wizardState.getStage() + direction;
        StageType xmlStage = wizardState.getXmlStage();
        
        if (stage == null)
            stage = String.valueOf(stageValue);

        if (xmlStage == null) {
            if (wizardState.getStage() == WELCOME_STAGE) {
                stageValue = direction - 1;
                if (direction == -1) {
                    StageType firstStage = getWizardStage(wizardState, 0);
                    if (firstStage.isSetPrevious())
                        return getActionScript(request, firstStage, firstStage.getPrevious(), firstStage.getPrevious()
                                .getStringValue(), String.valueOf(stageValue), prefix, postfix);
                } else {
                    stage = String.valueOf(stageValue);
                }
            }

        } else if (direction < 0) {
            String prev = getPrevious(wizardState);
            if ((prev != null) && (prev.length() > 0) && !prev.equals("false")) {
                return getActionScript(request, xmlStage, xmlStage.getPrevious(), prev, stage, prefix, postfix);
            } else if (xmlStage.getPrevious() != null) {
                return getActionScript(request, xmlStage, xmlStage.getPrevious(), null, stage, prefix, postfix);
            }
        } else if (direction > 0) {
            String next = getNext(wizardState);
            if ((next != null) && (next.length() > 0) && !next.equals("false")) {
                return getActionScript(request, xmlStage, xmlStage.getNext(), next, stage, prefix, postfix);

            } else if (xmlStage.getNext() != null) {
                return getActionScript(request, xmlStage, xmlStage.getNext(), null, stage, prefix, postfix);
            }
        }
        return prefix + request.getContextPath() + "/" + DEFAULT_ACTION + "?" + ProcessWizardState.STAGE_REQUEST_PARAMETER
                + "=" + stage + postfix;
    }

    private String getPrevious(ProcessWizardState wizardState) {
        StageType xmlStage = wizardState.getXmlStage();
        String prev = wizardState.getPrevious();

        if ((prev == null) && (xmlStage != null) && xmlStage.isSetPrevious()) {
            prev = xmlStage.getPrevious().getStringValue();
        }
        if (prev == null)
            prev = "";

        return prev;
    }

    private String getNext(ProcessWizardState wizardState) {
        StageType xmlStage = wizardState.getXmlStage();
        String next = wizardState.getNext();

        if ((next == null) && (xmlStage != null) && xmlStage.isSetNext()) {
            next = xmlStage.getNext().getStringValue();
        }
        if (next == null)
            next = "";

        return next;
    }

    private String getActionScript(HttpServletRequest request, StageType currentStage, ButtonType stageAction, String overrideScript,
            String stage, String prefix, String postfix) {

        if (stageAction.isSetConfirm()) {
            ConfirmType xmlbConfirm = getConfirm(currentStage, stageAction.getConfirm());
            if (xmlbConfirm != null) {
                if (xmlbConfirm.isSetCheck()) {
                    Object condition = null;
                    if (xmlbConfirm.getCheck().length() > 0) {
                        SessionType xmlbSession = ProcessWizardPlugin.plugin().getGlobals().getSession();
                        if (xmlbSession != null)
                            condition = callGetMethod(request, xmlbSession.getData(), xmlbConfirm.getCheck());
                    } else {
                        condition = callGetMethod(request, currentStage.getName(), "complete");
                    }

                    boolean displayAlert = true;
                    if (condition != null) {
                        if (condition instanceof Boolean)
                            // Condition object is a boolean, we display according to the boolean value
                            displayAlert = !((Boolean) condition).booleanValue();
                        else
                            // Condition object avalable and not a boolean, we display
                            displayAlert = false;
                    }
                    if (displayAlert) {
                        return "javascript:alert('" + formatScriptText(xmlbConfirm.getStringValue()) + "');";
                    }
                } else {
                    prefix = "javascript:processConfirm('" + formatScriptText(xmlbConfirm.getStringValue())
                            + "','";
                    postfix = "')";
                }
            }
        }
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        int stageNo = getStageNo(wizardState, currentStage);
        String parameters = (stage == null) ? "" : ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stage;
        if (overrideScript != null) {
            if (ProcessWizardPlugin.plugin().getConfig() != null) {
                String action = RequestUtils.getActionMappingName(overrideScript);

                if (ProcessWizardPlugin.plugin().getConfig().findActionConfig(action) != null) {
                    return prefix + getAction(wizardState, overrideScript, stageNo, parameters, DEFAULT_ACTION) + postfix;
                }
            }
            return "javascript:" + overrideScript + ";";
        }
        // script and action
        String scriptAndAction = "";
        if ((stageAction.getAction() != null) && (stageAction.getScript() != null)) {
            scriptAndAction = "javascript:" + stageAction.getScript() + "('";
            scriptAndAction += getAction(wizardState, stageAction.getAction(), stageNo, parameters, DEFAULT_ACTION);
            scriptAndAction += "')";

        }
        // script only
        else if (stageAction.getScript() != null) {
            scriptAndAction = "javascript:" + stageAction.getScript() + ";";
        }
        // action only, or no action and no script
        else {
            scriptAndAction = prefix;
            scriptAndAction += getAction(wizardState, stageAction.getAction(), stageNo, parameters, DEFAULT_ACTION);
            scriptAndAction += postfix;
        }
        return scriptAndAction;
    }

    private String formatScriptText(String text) {
        String result = text.replaceAll("'", "\\\\'");
        return result;
    }

    public StageType getWizardStage(ProcessWizardState wizardState, int stage) {
        if ((stage >= 0) && (stage < wizardState.sizeOfStageArray()))
            return getWizardStage(wizardState.getStageArray(stage));

        return null;
    }

    public StageType getWizardStage(StageType xmlbStage) {

        if ((xmlbStage.getRef() != null) && (xmlbStage.getRef().length() > 0))
            xmlbStage = (StageType) ProcessWizardPlugin.find(ProcessWizardPlugin.plugin().getGlobals()
                    .getStagedefArray(), "name", xmlbStage.getRef());

        return xmlbStage;
    }

    public String getName() {
        return xmlbProcess.getName();
    }

    public String getTitle() {
        return xmlbProcess.getTitle();
    }

    public String includeJsp(PageContext pageContext, ContentType form) throws ServletException, IOException {
        return includeJsp(pageContext, "", form);
    }

    public String includeJsp(PageContext pageContext, String prefix, ContentType form) throws ServletException, IOException {
        if (displayForm(pageContext, form))
            return includeJsp(pageContext, prefix, form.getStringValue());

        return "";
    }

    public String includeJsp(PageContext pageContext, String page) throws ServletException, IOException {
        return includeJsp(pageContext, "", page);
    }

    public String includeJsp(PageContext pageContext, String prefix, String page) throws ServletException, IOException {
        String result = "";

        if (pageContext != null)
                pageContext.include(prefix + page + ".jsp");
        else
            result = "include file " + prefix + page;

        return result;
    }

    public SelectType getSelectionList(StageType stage, StateType state) {
        return getSelectionList(stage, state.getName());
    }

    public SelectType getSelectionList(StageType stage, String stateName) {
        if (stage != null) {
            for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
                SelectType select = stage.getSelectArray(i);
                if (select.isSetState() && select.getState().equals(stateName))
                    return stage.getSelectArray(i);
            }
        }
        return null;
    }

    public SelectType getSelectedList(StageType stage, StateType state) {
        for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
            SelectType select = stage.getSelectArray(i);
            if (!select.isSetState() || select.getState().equals("all"))
                return stage.getSelectArray(i);
        }
        return null;
    }

    public Collection getSelectedLists(StageType stage) {
        ArrayList<SelectType> lists = new ArrayList<SelectType>();
        for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
            SelectType select = stage.getSelectArray(i);
            if (!select.isSetState() || select.getState().equals("all"))
                lists.add(stage.getSelectArray(i));
        }
        return lists;
    }

    public MenuType getMenuList(StageType stage, StateType state) {
        if ((stage != null) && stage.isSetMenu() && stage.getMenu().isSetState()
                && stage.getMenu().getState().equals(state.getName()))
            return stage.getMenu();

        return null;
    }

    public String getPageTitle(HttpServletRequest request, StageType stage, StateType state) {
        String title = null;

        if (state.isSetTitle()) {
            ProcessWizardState wizardState = 
                (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
            
            if (!state.getTitle().isSetForce() && (stage != null)) {
                for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
                    SelectType select = stage.getSelectArray(i);
                    if (select.isSetState() && select.getState().equals("all"))
                        if (select.getAction().getParameter().equals("index"))
                            if ((wizardState.getIndex() >= 0)
                                    && (wizardState.getList().equals("") || wizardState.getList().equals(
                                            select.getProperty())))
                                title = displayItem(getItem(request, select, wizardState.getIndex()), select
                                        .getDisplayArray(), 1);
                }
            }
            if (title == null)
                title = state.getTitle().getStringValue();
            
            if (getButtonHref(request, state, "modify") != null)
                title = StringUtils.truncateLine(title, 25);
            else
                title = StringUtils.truncateLine(title, 50);
        }
        return title;
    }

    public String getPageTitleType(HttpServletRequest request, StageType stage, StateType state) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        String type = null;

        if (state.isSetTitle()) {
            if (!state.getTitle().isSetForce() && (stage != null)) {
                for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
                    SelectType select = stage.getSelectArray(i);
                    if (select.isSetState() && select.getState().equals("all"))
                        if (select.getAction().getParameter().equals("index"))
                            if ((wizardState.getIndex() >= 0)
                                    && (wizardState.getList().equals("") || wizardState.getList().equals(
                                            select.getProperty())))
                                type = displayItemType(select.getDisplayArray());
                }
            }
            if (type == null) {
                if (state.getTitle().isSetType())
                    type = state.getTitle().getType();
                else
                    type = "people";
            }
        }
        return type;
    }

    private Object getItem(HttpServletRequest request, SelectType select, int index) {
        ArrayList items = new ArrayList(getItems(request,select));
        if (index >= items.size())
            index = items.size() - 1;

        return items.get(index);
    }

//    public Collection getItems(PageContext pageContext, SelectType xmlSelect) {
//        return getItems((HttpServletRequest)pageContext.getRequest(), xmlSelect);
//    }

    public Collection getItems(HttpServletRequest request, SelectType xmlSelect) {
        Collection collection = null;
        Object items = callGetMethod(request, xmlSelect.getName(), xmlSelect.getProperty());
        if (items == null)
            return null;

        if (items instanceof Collection) {
            collection = (Collection) items;

        } else if (items instanceof ReferentialData) {
            collection = getSelectedItems(((ReferentialData)items).getChildren());

        } else {
            collection = new ArrayList();
            collection.add(items);
        }
        if (collection.isEmpty())
            return null;
        return collection;
    }

    private List<ReferentialData> getSelectedItems(List<ReferentialData> dataList) {
        ArrayList<ReferentialData> selection = new ArrayList<ReferentialData>();
        if (dataList != null) {
            for (ReferentialData data : dataList) {
                if (data.getChildren().isEmpty() && data.isSelected())
                    selection.add(data);
                else
                    selection.addAll(getSelectedItems(data.getChildren()));
            }
        }        
        return selection;
    }    
    
    public String displayItem(Object item, DisplayType[] displays, int full) {
        String select = "";

        if (item instanceof ReferentialData)
            return displayItem((ReferentialData)item);
        
        for (int i = 0; i < displays.length; i++) {
            if (displays[i].isSetName()) {
                String name = (String) ProcessWizardPlugin.callGetMethod(item, displays[i].getName());

                if (select.length() > 0)
                    select = select + " ";

                if ((full == 0) && displays[i].getInitial())
                    select = select + name.substring(0, 1).toUpperCase() + ".";
                else
                    select = select + name;
            }
        }
        // if full > 3 we truncate at the number of characters indicated by full.
        //     values 0 and 1 are reserved for compatibility reasons
        if (full > 3)
            select = StringUtils.truncate(select, full);
        
        return select;
    }

    private String displayItem(ReferentialData data) {
        String display = data.getValue();
        while (data.getParent() != null) {
            data = data.getParent();
            if (data.getValue() != null)
                display = data.getValue() + " - " + display;
        }
        return display;
    }
    
    public String displayItemType(DisplayType[] displays) {
        for (int i = 0; i < displays.length; i++) {
            if (displays[i].isSetType()) {
                return displays[i].getType();
            }
        }
        return "";
    }

    public String hrefLink(ProcessWizardState wizardState, SelectType xmlbSelect, Object item, int index) {
        return hrefLink(wizardState, xmlbSelect, item, index, "");
    }

    public String hrefLink(ProcessWizardState wizardState, int stageNo, SelectType xmlbSelect, Object item, int index) {
        return hrefLink(wizardState, xmlbSelect, item, index, "stage=" + stageNo);
    }

    private String hrefLink(ProcessWizardState wizardState, SelectType xmlbSelect, Object item, int index, String extra) {
        StageType xmlStage = wizardState.getXmlStage();
        StateType xmlbState = getState(xmlStage, wizardState.getState());
        ActionType xmlbAction = xmlbSelect.getAction();

        String prefix = "";
        String postfix = "";
        ConfirmType xmlbConfirm = getConfirm(xmlStage, xmlbAction.getConfirm());
        if (!wizardState.isEndStage())
            if ((xmlbConfirm != null) && (!xmlbConfirm.isSetCheck() || xmlbState.isSetChange())) {
                prefix = "javascript:processConfirm('" + formatScriptText(xmlbConfirm.getStringValue())
                        + "','";
                postfix = "')";
            }

        if (extra.length() > 0)
            extra = "&" + extra;

        if (xmlbAction.isSetTransition())
            extra += "&" + ProcessWizardState.TRANSITION_REQUEST_PARAMETER + "=" + xmlbAction.getTransition();

        String parameter = getSelectParameter(item, index, xmlbAction.getParameter());
        String action = getAction(wizardState, xmlbAction.getStringValue(), wizardState.getStage(), parameter + extra,
                "processSelect.do");

        return prefix + action + postfix;
    }

    private boolean displayForm(PageContext pageContext, ContentType form) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)pageContext.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        IStageForm stageForm = (IStageForm) pageContext.getSession().getAttribute(wizardState.getStageName());
        if (form.isSetCondition() && (stageForm != null)) {
            String condition = form.getCondition();

            int pos = condition.indexOf("==");
            if (pos != -1) {
                String field = condition.substring(0, pos);
                String value = condition.substring(pos + 2);

                Object fieldValue = ProcessWizardPlugin.callGetMethod(stageForm, field);

                if (fieldValue instanceof String)
                    return value.equals(fieldValue);

                if (fieldValue instanceof Boolean)
                    return fieldValue.equals(getBooleanFromValue(value));
            }
        }
        return true;
    }

    private Boolean getBooleanFromValue(String value) {
        if (value.equalsIgnoreCase("oui"))
            return new Boolean(true);

        if (value.equalsIgnoreCase("non"))
            return new Boolean(false);

        if (value.equalsIgnoreCase("yes"))
            return new Boolean(true);

        if (value.equalsIgnoreCase("no"))
            return new Boolean(false);

        return null;
    }

    private String getSelectParameter(Object item, int index, String parameter) {
        if (item instanceof ReferentialData)
            return "";
        
        if (parameter.equals(ProcessWizardState.INDEX_REQUEST_PARAMETER))
            return parameter + "=" + index;

        return parameter + "=" + ProcessWizardPlugin.callGetMethod(item, parameter);
    }

    public String href(ProcessWizardState wizardState, ButtonType xmlbButton, String defaultAction) {
        return href(wizardState, xmlbButton, defaultAction, false);
    }

    public String href(ProcessWizardState wizardState, ButtonType xmlbButton, String defaultAction, boolean forceEnd) {
        if (xmlbButton != null)
            return href(wizardState, wizardState.getXmlStage(), xmlbButton, defaultAction, "", forceEnd);

        return null;
    }

    public String href(ProcessWizardState wizardState, ButtonType xmlbButton, String defaultAction, String parameters) {
        if (xmlbButton != null)
            return href(wizardState, wizardState.getXmlStage(), xmlbButton, defaultAction, parameters, false);

        return null;
    }

    private String href(ProcessWizardState wizardState, StageType stage, ButtonType xmlbButton, String defaultAction, String parameters, boolean forceEnd) {
        String onClick = "";

        int stageNo = getStageNo(wizardState, stage);

        if (xmlbButton.isSetTransition()) {
            String seperator = (parameters.length() > 0) ? "&" : "";
            parameters += seperator + ProcessWizardState.TRANSITION_REQUEST_PARAMETER + "="
                    + xmlbButton.getTransition();
        }
        // confirm and action
        StateType xmlbState = getState(stage, wizardState.getState(stageNo));
        ConfirmType xmlbConfirm = getConfirm(stage, xmlbButton.getConfirm());
        if ((xmlbConfirm != null) && (xmlbState != null)
                && (!xmlbConfirm.isSetCheck() || xmlbState.isSetChange())) {
            onClick = "javascript:processConfirm('" + formatScriptText(xmlbConfirm.getStringValue()) + "','";
            onClick += getAction(wizardState, xmlbButton.getAction(), stageNo, parameters, defaultAction, forceEnd);
            onClick += "')";
        }
        // script and action
        else if ((xmlbButton.getAction() != null) && (xmlbButton.getScript() != null)) {
            onClick = "javascript:" + xmlbButton.getScript() + "('";
            onClick += getAction(wizardState, xmlbButton.getAction(), stageNo, parameters, defaultAction, forceEnd);
            onClick += "')";

        }
        // action only
        else if (xmlbButton.getAction() != null) {
            onClick = getAction(wizardState, xmlbButton.getAction(), stageNo, parameters, defaultAction, forceEnd);
        }
        // script only
        else if (xmlbButton.getScript() != null) {
            onClick = "javascript:" + xmlbButton.getScript() + ";";
        }
        return onClick;
    }

    private String getAction(ProcessWizardState wizardState, String action, int stageNo, String extra, String defaultAction) {
        return getAction(wizardState, action, stageNo, extra, defaultAction, false);
    }

    private String getAction(ProcessWizardState wizardState, String action, int stageNo, String extra, String defaultAction, boolean forceEnd) {
        if ((action != null) && (action.length() > 0)) {

            String parameters = "";
            int question = action.indexOf("?");
            if (question >= 0) {
                parameters = action.substring(question + 1);
                action = action.substring(0, question);
            }
            if (ProcessWizardPlugin.plugin().getConfig().findActionConfig(
                    RequestUtils.getActionMappingName(action)) != null) {
                if (!action.endsWith(".do"))
                    action += ".do";

            } else if (action.equals("next")) {
                if (forceEnd) {
                    action = defaultAction + "?" + ProcessWizardState.STAGE_REQUEST_PARAMETER + "=end";
                } else {
                    int stage = wizardState.getStage() + 1;
                    if (wizardState.getStage() == WELCOME_STAGE)
                        stage = 0;
                    action = defaultAction + "?" + ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stage;
                }

            } else if (action.equals("prev")) {
                int stage = wizardState.getStage() - 1;
                action = defaultAction + "?" + ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stage;

            } else
                action = defaultAction + "?" + action;

            String seperator = (action.indexOf("?") > 0) ? "&" : "?";
            if (parameters.length() > 0) {
                if (parameters.equals("next")) {
                    if (forceEnd) {
                        parameters = ProcessWizardState.STAGE_REQUEST_PARAMETER + "=end";
                    } else {
                        int stage = wizardState.getStage() + 1;
                        if (wizardState.getStage() == WELCOME_STAGE)
                            stage = 0;
                        parameters = ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stage;
                    }
                } else if (parameters.equals("prev")) {
                    int stage = wizardState.getStage() - 1;
                    parameters = ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stage;

                }
                action += seperator + parameters;
                if (extra.length() > 0)
                    action += "&" + extra;
            } else if (extra.length() > 0)
                action += seperator + extra;
        } else {
            action = defaultAction;
            if (extra.length() > 0)
                action += "?" + extra;
        }
        if ((stageNo >= 0) && (action.indexOf(ProcessWizardState.STAGE_REQUEST_PARAMETER) == -1)) {
            action += (action.indexOf("?") > 0) ? "&" : "?";
            action += ProcessWizardState.STAGE_REQUEST_PARAMETER + "=" + stageNo;
        }
        return action;
    }

    public StateType getState(StageType xmlbStage, String state) {
        if (xmlbStage != null)
            return (StateType) ProcessWizardPlugin.find(xmlbStage.getStateArray(), "name", state);

        return xmlbProcess.getWelcome();
    }

    private ConfirmType getConfirm(StageType currentStage, String confirm) {
        if (currentStage != null)
            return (ConfirmType) ProcessWizardPlugin.find(currentStage.getConfirmArray(), "name", confirm);

        return null;
    }

    public String getButtonLabel(HttpServletRequest request, StateType state, String type) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        StageType xmlStage = wizardState.getXmlStage();
        if (type.equals("cancel")) {
            ButtonType button = findButton(state, type, "Annuler Saisie");
            if (button == null)
                return "";

            return button.getStringValue();

        } else if (type.equals("add")) {
            ButtonType button = findButton(state, type, "");
            if (button == null)
                return "";

            return button.getStringValue();

        } else if (type.equals("print")) {
            ButtonType button = findButton(state, type, "");
            if (button == null)
                return "";

            return button.getStringValue();

        } else if (type.equals("modify")) {
            ButtonType button = findButton(state, type, "Modifier");
            if (button == null)
                return "";

            return button.getStringValue();

        } else if (type.equals("delete")) {
            ButtonType button = findButton(state, type, "Supprimer");
            if (button == null)
                return "";

            return button.getStringValue();

        } else if (type.equals("quit")) {
            ButtonType button = findButton(state, type, "");
            if (button == null)
                if ((wizardState.getStage() == WELCOME_STAGE)
                        || ((wizardState.getStage() == 0) && xmlStage.isSetDefault() && xmlStage
                                .getDefault().equals(state.getName()))) {
                    return "Annuler la demande";
                }
            if (stageMenu(wizardState)) {
                if (xmlbProcess.getSubject())
                    return "Annuler l'inscription";
                else
                    return "Annuler la demande";
            }
            return button.getStringValue();

        } else if (type.equals("previous")) {
            ButtonType button = findButton(state, type, "Page précédente");
            if (button == null)
                return "Page précédente";

            return button.getStringValue();

        } else if (type.equals("next")) {
            ButtonType button = findButton(state, type, "Page suivante");
            if (button == null)
                return "Page suivante";

            return button.getStringValue();

        } else if (type.equals("save")) {
            ButtonType button = findButton(state, type, "Enregistrer");
            if (button == null)
                return "";

            return button.getStringValue();
        }
        return null;
    }

    public String getButtonHref(HttpServletRequest request, StateType state, String type) {
        // Check valid session in request. How can a session not be valid in the request???
        if (request.getSession() == null)
            return null;
        
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        StageType xmlStage = wizardState.getXmlStage();
        if (type.equals("cancel")) {
            ButtonType button = findButton(state, type, "Annuler Saisie");
            if (button == null)
                return null;

            String parameters = "";
            if (!button.isSetAction() || (button.getAction().length() == 0))
                parameters = ProcessWizardState.STAGE_REQUEST_PARAMETER + "=end";

            return href(wizardState, button, DEFAULT_ACTION, parameters);

        } else if (type.equals("add")) {
            return href(wizardState, findButton(state, type, ""), DEFAULT_ACTION);

        } else if (type.equals("print")) {
            return href(wizardState, findButton(state, type, ""), DEFAULT_ACTION);

        } else if (type.equals("modify")) {
            return href(wizardState, findButton(state, type, "Modifier"), DEFAULT_ACTION);

        } else if (type.equals("delete")) {
            return href(wizardState, findButton(state, type, "Supprimer"), DEFAULT_ACTION);

        } else if (type.equals("quit")) {
            ButtonType button = findButton(state, type, "");
            if (button != null)
                return href(wizardState, button, DEFAULT_ACTION);

            if ((wizardState.getStage() == WELCOME_STAGE)
                    || ((wizardState.getStage() == 0) && xmlStage.isSetDefault() && xmlStage.getDefault()
                            .equals(state.getName()))) {
                ConfirmType confirm = getConfirm(xmlStage, "terminate");
                return getActionConfirm(wizardState, "endProcess", confirm, wizardState.getStage(), "", DEFAULT_ACTION);
            }
            if (stageMenu(wizardState)) {
                StageType firstStage = getWizardStage(wizardState, 0);
                if (xmlbProcess.getSubject()) {
                    ConfirmType confirm = getConfirm(firstStage, "cancel");
                    return getActionConfirm(wizardState, "resetProcess", confirm, wizardState.getStage(), "",
                            DEFAULT_ACTION);
                } else {
                    ConfirmType confirm = getConfirm(firstStage, "terminate");
                    return getActionConfirm(wizardState, "endProcess", confirm, wizardState.getStage(), "", DEFAULT_ACTION);
                }
            }
        } else if (type.equals("previous")) {
            // If we have a print button we are on the last page after validation, so no return
            if (findButton(state, "print", "") != null)
                return null;

            String href = href(wizardState, findButton(state, type, "Page précédente"), DEFAULT_ACTION);
            if (href != null)
                return href;

            String prevState = wizardState.getPrevStackState();
            if (prevState != null) {
                String action = null;
                ConfirmType confirm = null;
                if ((wizardState.getStage() == 0) && xmlStage.isSetDefault()
                        && xmlStage.getDefault().equals(prevState) && xmlbProcess.getSubject()) {
                    confirm = getConfirm(xmlStage, "cancel");
                    action = "resetProcess";
                }

                return getActionConfirm(wizardState, action, confirm, wizardState.getStage(),
                        ProcessWizardState.TRANSITION_REQUEST_PARAMETER + "=" + prevState, DEFAULT_ACTION);
            }
            if (wizardState.getStage() > 0)
                return navigation(request, -1, "end", "", "");

        } else if (type.equals("next")) {
            String href = href(wizardState, findButton(state, type, "Page suivante"), DEFAULT_ACTION, true);
            if (href != null)
                return href;

            return navigation(request, +1, "end", "", "");

        } else if (type.equals("save")) {
            return href(wizardState, findButton(state, type, "Enregistrer"), DEFAULT_ACTION, true);

        }
        return null;
    }

    private ButtonType findButton(StateType state, String type, String caption) {
        for (int i = 0; i < state.sizeOfButtonArray(); i++) {
            if (state.getButtonArray(i).isSetType() && state.getButtonArray(i).getType().equals(type))
                return state.getButtonArray(i);

            if (state.getButtonArray(i).getStringValue().equals(caption))
                return state.getButtonArray(i);
        }
        return null;
    }

    private String getActionConfirm(ProcessWizardState wizardState, String action, ConfirmType xmlbConfirm, int stageNo, String extra,
            String defaultAction) {
        String prefix = "";
        String postfix = "";
        if ((xmlbConfirm != null) && !xmlbConfirm.isSetCheck()) {
            prefix = "javascript:processConfirm('" + formatScriptText(xmlbConfirm.getStringValue()) + "','";
            postfix = "')";
        }
        return prefix + getAction(wizardState, action, stageNo, extra, defaultAction) + postfix;
    }

    public boolean stageMenu(ProcessWizardState wizardState) {
        return wizardState.isEndStage();
    }

    public String getMenuHref(HttpServletRequest request, StageType stage, int stageNo) {
        ProcessWizardState wizardState = 
            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
        
        String href = null;
        if (stage.isSetStagemenu() && stage.getStagemenu().equals("add")) {
            for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
                if (stage.getSelectArray(i).isSetButton()) {
                    href = href(wizardState, stage, stage.getSelectArray(i).getButton(), DEFAULT_ACTION, "", false);
                }
            }
        }
        if (href == null) {
            String parameter = ProcessWizardState.TRANSITION_REQUEST_PARAMETER + "=" + stage.getDefault();
            href = getAction(wizardState, null, stageNo, parameter, DEFAULT_ACTION);
        }
        return href;
    }

    public String getMenuCaption(StageType stage) {
        String caption = stage.getTitle();
        // if (stage.getStagemenu().equals("add")) {
        // for (int i = 0; i < stage.sizeOfSelectArray(); i++) {
        // if (stage.getSelectArray(i).isSetButton()) {
        // caption = stage.getSelectArray(i).getButton().getStringValue();
        // }
        // }
        // }
        return caption;
    }

    private int getStageNo(ProcessWizardState wizardState, StageType stage) {
        for (int i = 0; i < wizardState.sizeOfStageArray(); i++) {
            if (stage == getWizardStage(wizardState, i))
                return i;
        }
        return -1;
    }

    public boolean validStages(ProcessWizardState wizardState) {
        return wizardState.isStageSaved(0);
    }

    public boolean validStage(ProcessWizardState wizardState, int stage) {
        return wizardState.isStageSaved(stage);
    }

//    private String selectTitle(HttpServletRequest request, StateType state) {
//        ProcessWizardState wizardState = 
//            (ProcessWizardState)request.getSession().getAttribute(ProcessWizardState.SESSION_KEY);
//        
//        SelectType select = getSelectedList(wizardState.getXmlStage(), state);
//        if (select != null) {
//            Collection items = getItems(request, select);
//            if (items != null) {
//                int index = 0;
//                Iterator iter = items.iterator();
//                while (iter.hasNext()) {
//                    if (index == wizardState.getIndex())
//                        return displayItem(iter.next(), select.getDisplayArray(), 1);
//                    iter.next();
//                    index++;
//                }
//            }
//        }
//        return null;
//    }

//    private Object callGetMethod(PageContext pageContext, String param, String property) {
//        Object obj = null;
//        if (pageContext != null) {
//            try {
//                obj = RequestUtils.lookup(pageContext, param, property, "session");
//            } catch (JspException e) {
//                // log.warn("callGetMethod", e);
//            }
//        }
//        return obj;
//    }

    private Object callGetMethod(HttpServletRequest request, String param, String property) {
        Object obj = null;
        if (request != null) {
            try {
                Object bean = request.getSession().getAttribute(param);
                if ((bean != null) && (property != null)) 
                    obj = PropertyUtils.getProperty(bean, property);
                else
                    obj = bean;
                
            } catch (IllegalAccessException e) {
                // log.warn("callGetMethod", e);
            } catch (InvocationTargetException e) {
                // log.warn("callGetMethod", e);
            } catch (NoSuchMethodException e) {
                // log.warn("callGetMethod", e);
            }
        }
        return obj;
    }

    public String getPersistence() {
        return xmlbProcess.getPersistence();
    }

    public String getTime() {
        return xmlbProcess.getTime();
    }

    public String getProcessTitle(ProcessWizardState wizardState) {
        if (wizardState.getSeasonLabel() != null)
            return wizardState.getSeasonLabel();

        return xmlbProcess.getTitle();
    }

    public String getInformationLabel() {
        if (xmlbProcess.isSetInformation())
            return xmlbProcess.getInformation().getLabel();

        return null;
    }

    public String getInformationFile() {
        if (xmlbProcess.isSetInformation())
            return xmlbProcess.getInformation().getStringValue();

        return null;
    }

}

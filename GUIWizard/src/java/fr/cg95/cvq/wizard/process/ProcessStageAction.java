package fr.cg95.cvq.wizard.process;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import fr.cg95.cvq.wizard.DateUtils;
import fr.cg95.cvq.wizard.GuiWizardException;
import fr.cg95.cvq.wizard.IStageForm;


public class ProcessStageAction extends ProcessWizardAction {
	
	private static final String ID = "fr.cg95.cvq.wizard.process.ProcessStageAction";
    private static final String STAGE_KEY = ID + ".stage";
    private static final String CONTEXT_KEY = ID + ".context";
    
	private static Logger logger = Logger.getLogger(ProcessStageAction.class);

    protected void process(HttpServletRequest request) {
        if (request.getParameter("reset") != null)
            resetStage(request);
        
        ProcessWizardState wizardState = getWizardState(request);

        setStageForm(request, wizardState);
        
        super.process(request);
    }

    protected void resetProcessAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        // Remove request data
        session.removeAttribute(ID + ".request");

        // Remove stage data
        String processStage = (String)session.getAttribute(STAGE_KEY);

        if (processStage != null) {
            session.removeAttribute(processStage);
            session.removeAttribute(STAGE_KEY);
        }

        String processContext = (String)session.getAttribute(CONTEXT_KEY);

        if (processContext != null) {
            session.removeAttribute(processContext);
            session.removeAttribute(CONTEXT_KEY);
        }

        // Remove wizardState
        session.removeAttribute(ProcessWizardState.SESSION_KEY);
    }
    
    protected void setRequestData(HttpServletRequest request, Object requestData) {
		request.getSession().setAttribute(ID + ".request", requestData);
		request.setAttribute(ID + ".reset","");
	}
	
    protected Object getRequestData(HttpServletRequest request) {
        return request.getSession().getAttribute(ID + ".request");
    }
    
    protected IStageForm getStageForm(HttpServletRequest request) {
        return getStageForm(request.getSession());
    }
    
	protected void getUserData(HttpServletRequest request, Object stageForm) {
		if (stageForm != null) {
			Enumeration names = request.getParameterNames();
			while (names.hasMoreElements()) {
				try {
					String name = (String) names.nextElement();
					String value = request.getParameter(name);
					
					PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(stageForm, name);
					if (propertyDescriptor != null) {
						Object data = null;
						
						Class type = propertyDescriptor.getPropertyType();

						if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
							IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor)propertyDescriptor; 
							type = indexedPropertyDescriptor.getIndexedPropertyType();
						}
                        if (type.getName().equals("java.util.Calendar")) {
                            data = DateUtils.parseDate(value);
                            
                        } else if (type.getName().equals("java.math.BigInteger")) {
                            try {
                                data = new BigInteger(value);
                            } catch (NumberFormatException nfe) {
                                nfe.getMessage();
                            }
                                
                        } else if (type.getName().equals("java.lang.Double")) {
                            try {
                                data = new Double(value.replace(',','.'));
                            } catch (NumberFormatException nfe) {
                                nfe.getMessage();
                            }
                                
                        } else if (type.getName().equals("double")) {
                            try {
                                data = new Double(value.replace(',','.'));
                            } catch (NumberFormatException nfe) {
                                nfe.getMessage();
                            }
                                
                        } else if (type.getName().equals("long")) {
                            if (value instanceof String) {
                                if (value.equalsIgnoreCase("non")) {
                                    data = new Long(0);
                                } else {
                                    data = new Long(1);
                                }
                            }
                                
                        } else if (type.getName().equals("boolean")) {
							if (value.equalsIgnoreCase("non")) {
								data = new Boolean(false);
							} else {
								data = new Boolean(true);
							}
						} else {
							data = value;
						}
						PropertyUtils.setProperty(stageForm, name, data);
					}
				} catch (IllegalAccessException e) {
					logger.error("getUserData",e);
				} catch (InvocationTargetException e) {
					logger.error("getUserData",e);
				} catch (NoSuchMethodException e) {
					logger.debug("getUserData",e);
				} catch (ParseException e) {
                    logger.debug("getUserData",e);
                }
			}
		}
	}
	
	protected IStageForm newStageForm(HttpServletRequest request, ProcessWizardState wizardState, String name) throws GuiWizardException {
		try {
			IStageForm stageForm =(IStageForm)Class.forName(wizardState.getStagePackage() + ".form." + name).newInstance();

			stageForm.load(request.getSession(), getRequestData(request));
			
			return stageForm;

		} catch (ClassCastException e) {
			throw new GuiWizardException("new StageForm", e);
		} catch (InstantiationException e) {
			throw new GuiWizardException("new StageForm", e);
		} catch (IllegalAccessException e) {
			throw new GuiWizardException("new StageForm", e);
		} catch (ClassNotFoundException e) {
//			throw new GuiWizardException("new StageForm", e);
		}
		return null;
	}
	
	public static IStageForm getStageForm(HttpSession session) {
		String processStage = (String)session.getAttribute(STAGE_KEY);

		if (processStage != null)
			return (IStageForm)session.getAttribute(processStage);
		
		return null;
	}
	
	protected void setStageForm(HttpSession session, ProcessWizardState wizardState, IStageForm stageForm) {
		if (stageForm != null) {
			session.setAttribute(STAGE_KEY, wizardState.getStageName());
			session.setAttribute(wizardState.getStageName(), stageForm);
		} else {
			session.removeAttribute(wizardState.getStageName());
			session.removeAttribute(STAGE_KEY);
		}
	}
	
    private void resetStage(HttpServletRequest request) {
        request.getSession().removeAttribute(STAGE_KEY);
        request.setAttribute(ID + ".reset","");
    }
    
    private IStageForm setStageForm(HttpServletRequest request, ProcessWizardState wizardState) {
        HttpSession session = request.getSession();
        
        IStageForm stageForm = null;
        Object xmlbRequest = getRequestData(request);
        
        String context = wizardState.getStateContext();

        String processStage = (String)session.getAttribute(STAGE_KEY);
        String processContext = (String)session.getAttribute(CONTEXT_KEY);

        if (processContext != null) {
            // Get the data input by the user only if data has been submitted 
            stageForm = (IStageForm)session.getAttribute(processContext);
            if (request.getMethod().equalsIgnoreCase("POST")) {
                stageForm.reset(wizardState.getPrevState());
            }            
            getUserData(request, stageForm);

            stateChange(request, wizardState, stageForm);

            if (!processContext.equals(context) || wizardState.isEndStage()) {
                stageForm.save(session, xmlbRequest);
                
                session.removeAttribute(CONTEXT_KEY);

                if (wizardState.isEndStage()) {
                    if (processStage != null) {
                        stageForm = (IStageForm)session.getAttribute(processStage);
                        stageForm.save(session, xmlbRequest);
                        session.removeAttribute(processStage);
                        session.removeAttribute(STAGE_KEY);
                        wizardState.setStageSaved(request, processStage, stageForm.isComplete());
                    } else {
                        wizardState.setStageSaved(request, processContext);
                    }
                }   
            }
            
        } else if (processStage != null) {
            // Get the data input by the user only if data has been submitted 
            stageForm = (IStageForm)session.getAttribute(processStage);
            if (request.getMethod().equalsIgnoreCase("POST")) {
                stageForm.reset(wizardState.getPrevState());
            }            
            getUserData(request, stageForm);
            
            stateChange(request, wizardState, stageForm);

            if (!processStage.equals(wizardState.getStageName()) || wizardState.isEndStage()) {
                stageForm.save(session, xmlbRequest);
                session.removeAttribute(processStage);
                session.removeAttribute(STAGE_KEY);
                wizardState.setStageSaved(request, processStage, stageForm.isComplete());
            }
        }
        if (context != null)
            stageForm = (IStageForm)session.getAttribute(context);
        else
            stageForm = (IStageForm)session.getAttribute(wizardState.getStageName());

        if (stageForm == null) {
            try {

                if (context != null) {
                    stageForm = newStageForm(request, wizardState, context);
                    session.setAttribute(context, stageForm);
                } else {
                    stageForm = newStageForm(request, wizardState, wizardState.getStageName());
                    setStageForm(session, wizardState, stageForm);
                }
                stateChange(request, wizardState, stageForm);
                
            } catch (GuiWizardException e) {
                logger.error("setStageForm",e);
            }
        } else if (request.getAttribute(ID + ".reset") != null) {
            stageForm.load(session, xmlbRequest);
        }
        if ((context != null) && (stageForm != null)) {
            session.setAttribute(CONTEXT_KEY, context);
        }

        return stageForm;
    }

    private void stateChange(HttpServletRequest request, ProcessWizardState wizardState, IStageForm stageForm) {
        if (wizardState.getWizardListener() != null) {
            String stateName = 
                wizardState.getWizardListener().onStateChange(request, stageForm, 
                                                                       wizardState.getPrevState(), 
                                                                       wizardState.getState());
            if (stateName == null)
                wizardState.setEndStage(true);
            
            else if (!stateName.equals(wizardState.getState()))
                wizardState.setState(stateName);
        }
    }
    
    public static String getRequestDataSessionKey() {
        return ID + ".request" ;
    }
}

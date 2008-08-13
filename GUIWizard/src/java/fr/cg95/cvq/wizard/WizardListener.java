package fr.cg95.cvq.wizard;

import javax.servlet.http.HttpServletRequest;

public interface WizardListener {
    public String onStateChange(HttpServletRequest request, IStageForm stageForm, String state, String newState);

    public String onStageChange(HttpServletRequest request, IStageForm stageForm, String stageName);
}

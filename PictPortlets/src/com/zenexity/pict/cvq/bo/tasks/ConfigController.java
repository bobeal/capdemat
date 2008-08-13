package com.zenexity.pict.cvq.bo.tasks;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.AbstractController;

public class ConfigController extends AbstractController {

    public ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
        throws Exception {

        Map<String, String> model = new HashMap<String, String>();

        String title =
            request.getPreferences().getValue("title", "Taches CVQ");
        response.setTitle(title);
        
        model.put("title", title);

        return new ModelAndView("config", model);
    }

    public void handleActionRequestInternal(ActionRequest request, ActionResponse response) throws Exception {

        if (request.getParameter("submitConfig") != null) {

            PortletPreferences preferences = request.getPreferences();
            preferences.setValue("title", request.getParameter("title"));
            preferences.store();

        }

        response.setPortletMode(PortletMode.VIEW);
    }
}


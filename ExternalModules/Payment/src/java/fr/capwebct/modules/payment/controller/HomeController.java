package fr.capwebct.modules.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomeController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
            HttpServletResponse arg1) throws Exception {
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

}

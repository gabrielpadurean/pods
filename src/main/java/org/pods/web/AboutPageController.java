package org.pods.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutPageController {
    private final static String ABOUT_PAGE = "aboutPage";


    @RequestMapping(value = "/about", method = GET)
    public ModelAndView getAboutPage() {
        return new ModelAndView(ABOUT_PAGE);
    }
}
package org.pods.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    private final static String HOME_PAGE = "homePage";


    @RequestMapping(value = "/", method = GET)
    public ModelAndView getHomePage() {
        return new ModelAndView(HOME_PAGE);
    }
}
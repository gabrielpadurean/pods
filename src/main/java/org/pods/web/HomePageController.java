package org.pods.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.pods.service.NasaService;
import org.pods.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    private final static String HOME_PAGE = "homePage";

    @Autowired
    private NasaService nasaService;

    @Autowired
    private WikipediaService wikipediaService;


    @RequestMapping(value = "/", method = GET)
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(HOME_PAGE);
        modelAndView.addObject("apod", nasaService.getLastAPOD());
        modelAndView.addObject("wpod", wikipediaService.getLastWPOD());

        return modelAndView;
    }
}
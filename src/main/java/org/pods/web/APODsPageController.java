package org.pods.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.pods.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class APODsPageController {
	private static final String APODS_PAGE = "apodsPage";
	
	@Autowired
	private NasaService nasaService;
	
	
	@RequestMapping(value = "/apods", method = GET)
    public ModelAndView getAPODsPage() {
        ModelAndView modelAndView = new ModelAndView(APODS_PAGE);

        modelAndView.addObject("apods", nasaService.getLatestAPODs());

        return modelAndView;
    }
}

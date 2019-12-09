package org.pods.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.pods.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WPODsPageController {
	private static final String WPODS_PAGE = "wpodsPage";

	@Autowired
	private WikipediaService wikipediaService;

	
	@RequestMapping(value = "/wpods", method = GET)
	public ModelAndView getWPODsPage() {
		ModelAndView modelAndView = new ModelAndView(WPODS_PAGE);

		modelAndView.addObject("wpods", wikipediaService.getLatestWPODs());

		return modelAndView;
	}
}

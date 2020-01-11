package org.pods.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.pods.domain.WPOD;
import org.pods.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WikipediaController {
	@Autowired
	private WikipediaService wikipediaService;
	
	
	@RequestMapping(value = "/api/wpods", method = GET)
    public List<WPOD> getLatestWPODs() {
        return wikipediaService.getLatestWPODs();
    }
}
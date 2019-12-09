package org.pods.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.pods.domain.WPOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class WikipediaClient {
	@Value("${wikipedia.wpod.default.link}")
    private String defaultLink;

    @Value("${wikipedia.wpod.default.description}")
    private String defaultDescriptin;
    
	@Autowired
    private RestTemplate restTemplate;
	
	
    @HystrixCommand(fallbackMethod = "getDefaultWPODs")
	public List<WPOD> getWPODs() {
		return getDefaultWPODs();
	}
    
    public List<WPOD> getDefaultWPODs() {
    	WPOD wpod = new WPOD();
    	
    	wpod.setLink(defaultLink);
    	wpod.setDescription(defaultDescriptin);
    	wpod.setDate(LocalDate.now());
    	
    	List<WPOD> wpods = new ArrayList<>();
    			
    	wpods.add(wpod);
    	
		return wpods;
    }
}
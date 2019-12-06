package org.pods.client;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
	public Collection<WPOD> getWPODs() {
		return getDefaultWPODs();
	}
    
    public Collection<WPOD> getDefaultWPODs() {
    	WPOD wpod = new WPOD();
    	
    	wpod.setLink(defaultLink);
    	wpod.setDescription(defaultDescriptin);
    	wpod.setDate(LocalDate.now());
    	
    	Set<WPOD> wpods = new HashSet<>();
    			
    	wpods.add(wpod);
    	
		return wpods;
    }
}
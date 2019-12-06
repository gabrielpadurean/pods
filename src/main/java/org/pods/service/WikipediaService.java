package org.pods.service;

import java.util.Collection;

import org.pods.client.WikipediaClient;
import org.pods.domain.WPOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WikipediaService {
	@Autowired
	private WikipediaClient wikipediaClient;
	
	
	public WPOD getLastWPOD() {
		return wikipediaClient.getWPODs()
				.stream()
				.findFirst()
				.get();
	}
	
	public Collection<WPOD> getLatestWPODs() {
		return wikipediaClient.getWPODs();
	}
}
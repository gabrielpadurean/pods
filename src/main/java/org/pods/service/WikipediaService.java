package org.pods.service;

import java.util.List;

import org.pods.client.WikipediaClient;
import org.pods.domain.WPOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WikipediaService {
	@Autowired
	private WikipediaClient wikipediaClient;
	
	
	public List<WPOD> getLatestWPODs() {
		return wikipediaClient.getWPODs();
	}
}
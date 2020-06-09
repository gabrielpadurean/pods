package org.pods.client;

import java.net.URL;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.pods.domain.WPOD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Component
public class WikipediaClient {
	private static final Logger LOG = LoggerFactory.getLogger(WikipediaClient.class);
	
	@Value("${wikipedia.wpod.url}")
	private String wpodUrl;
	
	
	public List<WPOD> getWPODs() {
		List<WPOD> wpods = Collections.emptyList();
		
		try {
			SyndFeed syndFeed = new SyndFeedInput().build(new XmlReader(new URL(wpodUrl)));
	
			List<SyndEntry> entries = syndFeed.getEntries();
			
			wpods = entries
					.stream()
					.map(syndEntry -> {
						Date date = syndEntry.getPublishedDate();
						String htmlDescription = syndEntry.getDescription().getValue();
						Document document = Jsoup.parseBodyFragment(htmlDescription);
						
						WPOD wpod = new WPOD();
						
						wpod.setLink(extractLink(document));
						wpod.setDescription(extractDescription(document));
						wpod.setDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						
						return wpod;
					})
					.collect(Collectors.toList());
    	} catch(Exception e) {
    		LOG.error("Exception while reading the Wikipedia RSS feed", e);
    	}
		
		return wpods;
	}
    
    /**
     * The actual description is inside a "div" with the "description" class.
     */
    private String extractDescription(Document document) {
    	String description = document.getElementsByClass("description").text();
    	
    	if (!description.endsWith(".")) {
    		description += ".";
    	}
    	
    	return description;
    }
    
    /**
     * The src of the image has the following format: https://upload.wikimedia.org/path/thumb/path/image1.jpg/300px-image2.jpg
     * and for the path to the full image we need to remove thumb and the 300px second image.
     */
    private String extractLink(Document document) {
    	return document
    			.getElementsByTag("img")
    			.attr("src")
    			.replaceAll("thumb/", "")
    			.split("/300px")[0];
    }
}
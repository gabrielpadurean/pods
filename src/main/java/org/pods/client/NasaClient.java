package org.pods.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.pods.domain.APOD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NasaClient {
	private static final Logger LOG = LoggerFactory.getLogger(NasaClient.class);

    private static final DateTimeFormatter NASA_APOD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Value("${nasa.apiKey}")
    private String apiKey;

    @Value("${nasa.apod.url}")
    private String apodUrl;

    @Autowired
    private RestTemplate restTemplate;


    public APOD getAPOD(LocalDate localDate) {
    	APOD apod = null;
    	
    	try {
        	apod = restTemplate.getForObject(apodUrl, APOD.class, localDate.format(NASA_APOD_DATE_FORMATTER), apiKey);
        } catch (Exception e) {
        	LOG.error("Exception while calling the NASA endpoint", e);
        }
    	
    	return apod;
    }
}
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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class NasaClient {
	private static final Logger LOG = LoggerFactory.getLogger(NasaClient.class);

    private static final DateTimeFormatter NASA_APOD_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Value("${nasa.apiKey}")
    private String apiKey;

    @Value("${nasa.apod.url}")
    private String apodUrl;

    @Value("${nasa.apod.default.title}")
    private String defaultTitle;

    @Value("${nasa.apod.default.explanation}")
    private String defaultExplanation;

    @Value("${nasa.apod.default.url}")
    private String defaultUrl;

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getDefaultAPOD")
    public APOD getAPOD(LocalDate localDate) {
        try {
        	return restTemplate.getForObject(apodUrl, APOD.class, localDate.format(NASA_APOD_DATE_FORMATTER), apiKey);
        } catch (Exception e) {
        	LOG.error("Exception while calling the NASA endpoint");
        	
        	throw e;
        }
    }

    public APOD getDefaultAPOD(LocalDate localDate) {
        APOD apod = new APOD();

        apod.setTitle(defaultTitle);
        apod.setExplanation(defaultExplanation);
        apod.setHdurl(defaultUrl);
        apod.setUrl(defaultUrl);
        apod.setMediaType(APOD.IMAGE_MEDIA_TYPE);
        apod.setDate(LocalDate.now());

        return apod;
    }
}
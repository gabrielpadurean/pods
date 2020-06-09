package org.pods.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.pods.client.NasaClient;
import org.pods.domain.APOD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaService {
	private static final Logger LOG = LoggerFactory.getLogger(NasaService.class);

    @Autowired
    private NasaClient nasaClient;


    public List<APOD> getLatestAPODs() {
    	List<APOD> apods = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 9; i++) {
        	LocalDate localDate = now.minusDays(i);
        	
        	LOG.info("Get APOD for date={}", localDate);
        	
        	APOD apod = nasaClient.getAPOD(localDate);
        	
        	if (apod != null) {
        		apods.add(apod);
        	}
        }

        return apods;
    }
}
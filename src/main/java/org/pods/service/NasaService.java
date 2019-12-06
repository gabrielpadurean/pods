package org.pods.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import org.pods.client.NasaClient;
import org.pods.domain.APOD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NasaService {
    @Autowired
    private NasaClient nasaClient;


    public APOD getLastAPOD() {
    	return nasaClient.getAPOD(LocalDate.now());
    }
    
    public Collection<APOD> getLatestAPODs() {
        Collection<APOD> apods = new HashSet<>();
        LocalDate now = LocalDate.now();

        for (int i = 0; i < 10; i++) {
            apods.add(nasaClient.getAPOD(now.minusDays(i)));
        }

        return apods;
    }
}
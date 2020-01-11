package org.pods.api;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.pods.domain.APOD;
import org.pods.service.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaController {
    @Autowired
    private NasaService nasaService;


    @RequestMapping(value = "/api/apods", method = GET)
    public List<APOD> getLatestAPODs() {
        return nasaService.getLatestAPODs();
    }
}
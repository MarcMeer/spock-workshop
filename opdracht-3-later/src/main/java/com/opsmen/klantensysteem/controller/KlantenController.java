package com.opsmen.klantensysteem.controller;


import com.opsmen.klantensysteem.model.Klant;
import com.opsmen.klantensysteem.service.IKlantenService;
import com.opsmen.klantensysteem.service.KlantenServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/klanten")
public class KlantenController {
    private final IKlantenService klantenService;

    @Autowired
    public KlantenController(IKlantenService klantenService) {
        this.klantenService = klantenService;
    }

    @RequestMapping("/opklantnummer")
    public Klant getKlantOpKlantNummer(@RequestParam("klantnummer") String klantNummer) {
        try {
            return klantenService.getKlantOpKlantNummer(klantNummer);
        } catch (KlantenServiceException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/opaantaljarenklant")
    public List<Klant> getKlantenOpAantalJarenKlant(@RequestParam("aantalJaren") int aantalJarenKlant) {
        return klantenService.getKlantNummerOpAantalJarenKlant(aantalJarenKlant)
                .stream()
                .filter(p -> p != null && !p.isEmpty())
                .map(p -> {
                    try {
                        return klantenService.getKlantOpKlantNummer(p);
                    } catch (KlantenServiceException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}

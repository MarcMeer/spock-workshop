package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.Klant;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DummyKlantenService implements IKlantenService {
    @Override
    public Klant getKlantOpKlantNummer(String klantNummer) throws KlantenServiceException{
        if(klantNummer==null || klantNummer.isEmpty()) {
            throw new KlantenServiceException();
        }
        Klant klant = new Klant();
        klant.setKlantNummer(klantNummer);
        return klant;
    }

    @Override
    public List<Klant> getKlantenOpWoonplaats(String woonplaats) throws KlantenServiceException {
        List<Klant> klantList = Stream.of("12", "13", "14").map(klantnummer -> {
            Klant klant = new Klant();
            klant.setKlantNummer(klantnummer);
            return klant;
        }).collect(Collectors.toList());
        return klantList;
    }

    @Override
    public List<String> getKlantNummerOpAantalJarenKlant(int aantalJarenKlant) {
        return Arrays.asList("12","13","15");
    }
}

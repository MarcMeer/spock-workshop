package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.Klant;

import java.util.List;

public interface IKlantenService {
    Klant getKlantOpKlantNummer(String klantNummer) throws KlantenServiceException;
    List<Klant> getKlantenOpWoonplaats(String woonplaats) throws KlantenServiceException;
    List<String> getKlantNummerOpAantalJarenKlant(int aantalJarenKlant);
}

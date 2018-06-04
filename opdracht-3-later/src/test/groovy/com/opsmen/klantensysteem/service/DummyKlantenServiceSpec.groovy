package com.opsmen.klantensysteem.service

import spock.lang.Specification

class DummyKlantenServiceSpec extends Specification {
    def "getKlantOpKlantNummer moet indien klantnummer leeg of null is, een exception opgooien"() {
        given:"klantenService"
        DummyKlantenService klantenService = new DummyKlantenService()

        when:"klant wordt opgehaald op klantnummer en klant nummer is leeg of null"
        def klant = klantenService.getKlantOpKlantNummer(klantNummer)

        then:"klantenServiceException wordt opgegooid"
        thrown(KlantenServiceException)

        where:
        klantNummer << ["",null]
    }

    def "getKlantOpKlantNummer moet een klant terug geven indien klantNummer niet leeg of null is"() {
        given:"klantenService"
        DummyKlantenService klantenService = new DummyKlantenService()

        when:"klant wordt opgehaald op klantnummer en klant nummer is leeg of null"
        def klant = klantenService.getKlantOpKlantNummer(klantNummer)

        then:"klantenServiceException wordt opgegooid"
        klant != null

        where:
        klantNummer << ["123","1"]
    }
}

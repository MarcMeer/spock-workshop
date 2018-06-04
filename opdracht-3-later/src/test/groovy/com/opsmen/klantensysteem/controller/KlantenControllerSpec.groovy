package com.opsmen.klantensysteem.controller

import spock.lang.Specification
import com.opsmen.klantensysteem.model.Klant
import com.opsmen.klantensysteem.service.IKlantenService
import com.opsmen.klantensysteem.service.KlantenServiceException

class KlantenControllerSpec extends Specification {
    def "klantOpKlantNummer moet gebruik maken van de klantenService en het resultaat van de klantenService terug geven"() {
        given:"KlantenController met mock voor klantenService en klant met gegeven klantNummer"
        IKlantenService klantenService = Mock(IKlantenService)
        KlantenController klantenController = new KlantenController(klantenService)
        def klantNummer = "123"
        def serviceKlant = Mock(Klant)

        when:"klant op gegeven klantnummer wordt opgevraagd"
        def klant = klantenController.getKlantOpKlantNummer(klantNummer)


        then:"Moet de klant via de klantenService worden opgehaald"
        1 * klantenService.getKlantOpKlantNummer(klantNummer) >> serviceKlant

        and:"Resultaat hetzelfde zijn als resultaat vanuit klanten service"
        serviceKlant == klant
    }

    def "Indien klantOpKlantNummer een Exception geeft moet klantenController een runtime exception geven"() {
        given:"klantenController met mock voor klantenService"
        IKlantenService klantenService = Mock()
        KlantenController klantenController = new KlantenController(klantenService)
        when:
        klantenController.getKlantOpKlantNummer("123")

        then:
        1 * klantenService.getKlantOpKlantNummer( _ as String ) >> { throw new KlantenServiceException()}

        and:
        thrown(RuntimeException)
    }
}

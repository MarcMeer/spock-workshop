package com.opsmen.klantensysteem.controller

import com.opsmen.klantensysteem.model.UrenRegel
import com.opsmen.klantensysteem.model.WeekUrenStaat
import com.opsmen.klantensysteem.service.IUrenService
import spock.lang.Specification
import spock.lang.Unroll

class UrenControllerSpec extends Specification {

    def "UrenController verwerkt update van bestaande urenRegel"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        def bijgewerkteUrenRegel = new UrenRegel(
                weekUrenStaatId: "weekUrenStaat1",
                id:"1",
                datum: new Date(2018, 2, 1))

        def weekUrenStaat = new WeekUrenStaat(urenRegelList: [
                new UrenRegel(id:"1", datum: bijgewerkteUrenRegel.getDatum())])

        def urenService = Mock(IUrenService)
        UrenController urenController = new UrenController(urenService)

        when:"urenController.bewerken voor bestaande urenRegel wordt aangeroepen"
        urenController.urenBijwerken(bijgewerkteUrenRegel)

        then:"de uren sheet wordt opgehaald van de urenService"
        1 * urenService.getWeekUrenStaatById("weekUrenStaat1")>> weekUrenStaat

        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
        1 * urenService.update(weekUrenStaat,  Optional.of("1"), bijgewerkteUrenRegel)
    }


    def "UrenController voegt nieuwe urenRegel toe"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        def gegevenKlantNummer = "123"
        def bijgewerkteUrenRegel = new UrenRegel(
                weekUrenStaatId: "weekUrenStaat1",
                id:"2",
                datum: new Date(2018, 2, 2),
                klantNummer: gegevenKlantNummer)

        def weekUrenStaat = new WeekUrenStaat(urenRegelList: [
                new UrenRegel(id:"1", datum: bijgewerkteUrenRegel.getDatum(), klantNummer: gegevenKlantNummer)])

        def urenService = Mock(IUrenService)
        UrenController urenController = new UrenController(urenService)

        when:"urenController.bewerken voor nieuwe urenRegel wordt aangeroepen"
        urenController.urenBijwerken(bijgewerkteUrenRegel)

        then:"de uren sheet wordt opgehaald van de urenService"
        1 * urenService.getWeekUrenStaatById("weekUrenStaat1")>> weekUrenStaat

        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
        1 * urenService.update(weekUrenStaat,  Optional.empty(), bijgewerkteUrenRegel)

    }

    def "UrenController geeft exception wanneer urenstaat niet bestaat"() {
        def urenService = Mock(IUrenService)
        UrenController urenController = new UrenController(urenService)
        when:"uren controller werkt uren regel bij van niet bestaande urenweekstaat"
        urenController.urenBijwerken(new UrenRegel(weekUrenStaatId: "bestaat lekker niet"))

        then:
        1 * urenService.getWeekUrenStaatById( _ ) >> null

        and:
        thrown(RuntimeException)
    }




    @Unroll
    def "Controleer urenBijwerken urenregel #urenRegelId "() {
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        def gegevenKlantNummer = "123"
        def bijgewerkteUrenRegel = new UrenRegel(
                weekUrenStaatId: "weekUrenStaat1",
                id:urenRegelId,
                datum: new Date(2018, 2, 2),
                klantNummer: gegevenKlantNummer)

        def weekUrenStaat = new WeekUrenStaat(urenRegelList: [
                new UrenRegel(id:"1", datum: bijgewerkteUrenRegel.getDatum(), klantNummer: gegevenKlantNummer)])

        def urenService = Mock(IUrenService)
        UrenController urenController = new UrenController(urenService)

        when:"urenController.bewerken voor nieuwe urenRegel wordt aangeroepen"
        urenController.urenBijwerken(bijgewerkteUrenRegel)

        then:"de uren sheet wordt opgehaald van de urenService"
        1 * urenService.getWeekUrenStaatById("weekUrenStaat1")>> weekUrenStaat

        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
        1 * urenService.update(weekUrenStaat,  optionalUpdateUrenRegelId, bijgewerkteUrenRegel)

        where:
        urenRegelId | optionalUpdateUrenRegelId
        "1"         | Optional.of("1")
        "2"         | Optional.empty()
    }

}

package com.opsmen.klantensysteem.controller

import com.opsmen.klantensysteem.model.UrenRegel
import com.opsmen.klantensysteem.model.WeekUrenStaat
import com.opsmen.klantensysteem.service.IUrenService
import spock.lang.Specification
import spock.lang.Unroll

class UrenControllerSpec extends Specification {

    def "UrenController verwerkt update van bestaande urenRegel"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        when:"urenController.bewerken voor bestaande urenRegel wordt aangeroepen"
        then:"de uren sheet wordt opgehaald van de urenService"
        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
    }


    def "UrenController voegt nieuwe urenRegel toe"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        when:"urenController.bewerken voor nieuwe urenRegel wordt aangeroepen"
        then:"de uren sheet wordt opgehaald van de urenService"
        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
    }

    def "UrenController geeft exception wanneer urenstaat niet bestaat"() {
    }
}

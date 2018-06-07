package com.opsmen

import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {
    def "Een gebruiker van Math  moet de wortel kunnen opvragen van 9"() {
        when: "de wortel van 9 wordt opgevraagd"
        def wortelVanNegen = Math.sqrt(9)

        then: "wortelVanNegen moet 3 zijn"
        wortelVanNegen == 3
    }

    @Unroll()
    def "de wortel van #gegevenGetal moet #verwachtResultaat zijn"() {
        when: "de wortel wordt opgevraagd"
        def wortel = Math.sqrt(gegevenGetal)

        then:"wortel moet verwacht resultaat terug geven"
        wortel == verwachtResultaat

        where:
        gegevenGetal | verwachtResultaat
        9            | 3
        16           | 4
        25           | 5
        36           | 6
    }
}
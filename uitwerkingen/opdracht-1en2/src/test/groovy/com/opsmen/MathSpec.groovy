package com.opsmen

import spock.lang.Specification
import spock.lang.Unroll

class MathSpec extends Specification {
    def "2^2 moet 4 opleveren"() {
        when: "Wanneer 2^2 wordt uitgevoerd"
        def resultaat = Math.pow(2, 2)

        then: "Moet dit 4 opleveren"
        resultaat == 4
    }

    @Unroll
    def "#getal ^ #macht moet #verwachteResultaat opleveren"() {
        when:"Pow wordt uitgevoerd"
        def resultaat = Math.pow(getal, macht)

        then:"resultaat moet verwachte waarde opleveren"
        resultaat == verwachteResultaat

        where:
        getal | macht | verwachteResultaat
        2     | 2     | 4
        4     | 2     | 16
        4     | 4     | 256
        2     | 8     | 256
    }
}

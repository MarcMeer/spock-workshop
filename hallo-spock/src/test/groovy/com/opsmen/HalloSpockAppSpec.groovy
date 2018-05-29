package com.opsmen

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ HalloSpockApp.class ])
class HalloSpockAppSpec extends Specification {
    @Autowired
    TestRestTemplate restTemplate;

    def "Hallo spock moet hallo spock terug geven"() {
        when:"/hallospock api wordt aangeroepen"
        def booschap = restTemplate.getForEntity("/hallospock", Booschap.class)

        then:"is eer een boodschap JSON gegeneeerd met de melding hallo spock"
        booschap.getBody().boodschap == "hallo spock"
    }
}

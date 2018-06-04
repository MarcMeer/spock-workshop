package it.com.opsmen

import com.opsmen.klantensysteem.controller.KlantenController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.mock.DetachedMockFactory
import com.opsmen.klantensysteem.model.Klant
import com.opsmen.klantensysteem.service.IKlantenService

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [KlantenControllerSpringBeanSpec.Config.class, KlantenController.class])
class KlantenControllerRestSpec extends Specification{
    @Autowired
    IKlantenService klantenServiceMock

    @Autowired
    TestRestTemplate restTemplate

    def "klantOpKlantNummer moet gebruik maken van de klantenService en het resultaat van de klantenService terug geven"() {
        when:"klant wordt opgehaald op klantnummer"
        def klantOpKlantNummer = restTemplate.getForEntity("/klanten/opklantnummer?klantnummer=123", Klant.class).body

        then:"de klantenService.getKlantOpKlantNummer wordt aangeroepen"
        1 * klantenServiceMock.getKlantOpKlantNummer("123") >> verwachteKlant

        and:"het juiste klant object is terug gegeven"
        klantOpKlantNummer.klantNummer == verwachteKlant.klantNummer

        and:"het is echter niet hetzelfde object omdat er een nieuw object gemaakt is met dezelfde data"
        klantOpKlantNummer != verwachteKlant

        where:
        verwachteKlant = new Klant(klantNummer: "123")
    }

    @Configuration
    protected static class Config {
        def mockFactory = new DetachedMockFactory()

        @Bean
        IKlantenService klantenService() {
            return mockFactory.Mock(IKlantenService)
        }
    }
}

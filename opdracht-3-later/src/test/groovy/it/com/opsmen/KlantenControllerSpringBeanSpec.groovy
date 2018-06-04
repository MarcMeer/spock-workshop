package it.com.opsmen

import com.opsmen.klantensysteem.controller.KlantenController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.mock.DetachedMockFactory
import com.opsmen.klantensysteem.model.Klant
import com.opsmen.klantensysteem.service.IKlantenService

@SpringBootTest()
@ContextConfiguration(classes = [KlantenControllerSpringBeanSpec.Config.class, KlantenController.class])
class KlantenControllerSpringBeanSpec extends Specification {
    @Autowired
    KlantenController klantenController

    @Autowired
    IKlantenService klantenServiceMock

    def "klantOpKlantNummer moet gebruik maken van de klantenService en het resultaat van de klantenService terug geven"() {
        when:"klant wordt opgehaald op klantnummer"
        def klantOpKlantNummer = klantenController.getKlantOpKlantNummer("123")

        then:"de klantenService.getKlantOpKlantNummer wordt aangeroepen"
        1 * klantenServiceMock.getKlantOpKlantNummer("123") >> verwachteKlant

        and:"het juiste klant object is terug gegeven"
        klantOpKlantNummer == verwachteKlant

        where:
        verwachteKlant = new Klant(klantNummer: "123")
    }

    @Configuration
    static class Config {
        def mockFactory = new DetachedMockFactory()

        @Bean
        IKlantenService klantenService() {
            return mockFactory.Mock(IKlantenService)
        }
    }
}

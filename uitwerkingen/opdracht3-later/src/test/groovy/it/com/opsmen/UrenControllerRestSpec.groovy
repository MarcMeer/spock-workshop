package it.com.opsmen

import com.opsmen.klantensysteem.controller.UrenController
import com.opsmen.klantensysteem.model.UrenRegel
import com.opsmen.klantensysteem.model.WeekUrenStaat
import com.opsmen.klantensysteem.service.IUrenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [UrenControllerRestSpec.Config.class, UrenController.class])
class UrenControllerRestSpec extends Specification {
    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    IUrenService urenService

    @Configuration
    static class Config {
        def mockFactory = new DetachedMockFactory()

        @Bean
        IUrenService urenService() {
            return mockFactory.Mock(IUrenService)
        }
    }

    def "UrenController verwerkt update van bestaande urenRegel"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        def bijgewerkteUrenRegel = new UrenRegel(
                weekUrenStaatId: "weekUrenStaat1",
                id:"1",
                datum: new Date(2018, 2, 1))

        def weekUrenStaat = new WeekUrenStaat(urenRegelList: [
                new UrenRegel(id:"1", datum: bijgewerkteUrenRegel.getDatum())])


        when:"urenController.bewerken voor bestaande urenRegel wordt aangeroepen"
        def updateResult = restTemplate.postForEntity("/urenRegel/update", bijgewerkteUrenRegel, UrenRegel)

        then:"de uren sheet wordt opgehaald van de urenService"
        1 * urenService.getWeekUrenStaatById("weekUrenStaat1")>> weekUrenStaat

        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
        1 * urenService.update(weekUrenStaat,  Optional.of("1"), _ as UrenRegel)

        and:"resultaat is dezelfde uren regel"
        updateResult.body.id == bijgewerkteUrenRegel.id
    }


    def "UrenController voegt nieuwe urenRegel toe"(){
        given:"urenController, een bijgewerkte urenregel, de origineleUrenRegel en de weekUrenStaat"
        def bijgewerkteUrenRegel = new UrenRegel(
                weekUrenStaatId: "weekUrenStaat1",
                id:"2",
                datum: new Date(2018, 2, 1))

        def weekUrenStaat = new WeekUrenStaat(urenRegelList: [
                new UrenRegel(id:"1", datum: bijgewerkteUrenRegel.getDatum())])


        when:"urenController.bewerken voor bestaande urenRegel wordt aangeroepen"
        def updateResult = restTemplate.postForEntity("/urenRegel/update", bijgewerkteUrenRegel, UrenRegel)

        then:"de uren sheet wordt opgehaald van de urenService"
        1 * urenService.getWeekUrenStaatById("weekUrenStaat1")>> weekUrenStaat

        and:"urenService.update wordt aangeroepen om de juiste urenregel bij te werken"
        1 * urenService.update(weekUrenStaat,  Optional.empty(), _ as UrenRegel)

        and:"resultaat is dezelfde uren regel"
        updateResult.body.id == bijgewerkteUrenRegel.id

    }




}

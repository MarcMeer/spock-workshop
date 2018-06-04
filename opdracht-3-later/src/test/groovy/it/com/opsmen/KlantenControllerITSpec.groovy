package it.com.opsmen

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import com.opsmen.klantensysteem.KlantenSysteemApp
import com.opsmen.klantensysteem.model.Klant

import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ KlantenSysteemApp.class])
class KlantenControllerITSpec extends Specification {
    @Autowired
    TestRestTemplate restTemplate;

    def "klanten/opklantnummer moet juiste klantnummer terug geven"() {
        when:"/klanten/opklantnummer?klantnummer=123 wordt aangeroepen"
        def klant = restTemplate.getForEntity("/klanten/opklantnummer?klantnummer=123", Klant.class)

        then:"klant nummer staat in boodschapt"
        klant.getBody().klantNummer == "123"
    }

    def "klanten/klantenopleeftijd moet het juiste resultaat geven"() {
        given:
        def expectedKlantNummers = ['12', '13', '15']
        when:"/klanten/opaantaljarenklant?aantalJaren=12"
        ResponseEntity<List<Klant>> klanten = restTemplate.getForEntity("/klanten/opaantaljarenklant?aantalJaren=12",List.class)

        then:"Er moeten 3 klanten terug gegeven"
        klanten.body.size() == 3

        and:"deze klanten hebben de juiste klantnummers"
        Set<String> resultaatKlantNummers = klanten.body.stream().map { klant -> klant.klantNummer}.collect(Collectors.toSet())
        resultaatKlantNummers.size() == 3
        resultaatKlantNummers.stream().allMatch{ klantNummer -> expectedKlantNummers.contains(klantNummer)}
    }
}


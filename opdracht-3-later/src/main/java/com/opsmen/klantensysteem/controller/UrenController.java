package com.opsmen.klantensysteem.controller;

import com.opsmen.klantensysteem.model.UrenRegel;
import com.opsmen.klantensysteem.model.WeekUrenStaat;
import com.opsmen.klantensysteem.service.IUrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/urenRegel")
public class UrenController {
    private IUrenService urenService;

    /**
     * Verwerkt een post van een urenRegel
     *
     * Deze methode haalt de {@link WeekUrenStaat} van gegeven {@link UrenRegel} op (property weekUrenStaatId)
     * Vervolgens wordt gekeken of er al een urenRegel in WeekUrenstaat is met hetzelfde id als urenregel.
     * Zo ja dan wordt deze regel bijgewerkt middels urenService.update zo niet dan moet urenService.update
     * deze regel toevoegen (service krijgt een Optional.empty mee).
     *
     * De clientsite code zorgt voor een id. Dat doet deze code niet.
     *
     * Indien weekUrenStaat niet bestaat wordt een {@link RuntimeException} op gegooid
     *
     * @param urenRegel
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UrenRegel urenBijwerken(@RequestBody UrenRegel urenRegel) {
        Optional<WeekUrenStaat> weekUrenStaat = getWeekUrenStaat(urenRegel);
        Optional<UrenRegel> huidigeUrenRegel = getBijTeWerkenUrenRegel(urenRegel, weekUrenStaat);
        urenService.update(weekUrenStaat.get(), huidigeUrenRegel.map(r -> r.getId()), urenRegel);
        return urenRegel;
    }

    private Optional<UrenRegel> getBijTeWerkenUrenRegel(@RequestBody UrenRegel urenRegel, Optional<WeekUrenStaat> optionalUrenStaat) {
        return optionalUrenStaat
                    .map(p -> p.getUrenRegelList() == null ? Stream.<UrenRegel>empty() : p.getUrenRegelList().stream())
                    .orElseThrow(() -> new RuntimeException("Geen uren staat voor gegeven datum"))
                    .filter(p -> p.getId().equals(urenRegel.getId()))
                    .findFirst();
    }

    private Optional<WeekUrenStaat> getWeekUrenStaat(@RequestBody UrenRegel urenRegel) {
        return Optional.ofNullable(
                    urenService.getWeekUrenStaatById(urenRegel.getWeekUrenStaatId()));
    }


    @Autowired
    public UrenController(IUrenService urenService) {
        this.urenService = urenService;
    }
}

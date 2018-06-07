package com.opsmen.klantensysteem.controller

import spock.lang.Specification
import com.opsmen.klantensysteem.model.Klant
import com.opsmen.klantensysteem.model.VerkoopOrder
import com.opsmen.klantensysteem.service.IKlantenService
import com.opsmen.klantensysteem.service.IOrderService

class VerkoopOrderControllerSpec extends Specification {

    def "GetVerkoopOrdersOpKlantNummer #klantNummer "() {
        given:
        IKlantenService klantenService = Mock()
        IOrderService orderService = Mock()
        VerkoopOrderController verkoopOrderController = new VerkoopOrderController(klantenService, orderService)

        when:
        def verkoopOrders = verkoopOrderController.getVerkoopOrdersOpKlantNummer(klantNummer)

        then:
        1 * klantenService.getKlantOpKlantNummer(klantNummer) >> klant
        (klant == null ? 0 : 1) * orderService.getOrdersOpKlant(klant) >> orders

        and:
        verkoopOrders == verwachteResultaat

        where:
        klantNummer | klant       | orders               | verwachteResultaat
        "123"       | null        | null                 | []
        "12"        | Mock(Klant) | [Mock(VerkoopOrder)] | orders
    }
}

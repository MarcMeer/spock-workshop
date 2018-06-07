package com.opsmen.klantensysteem.controller;


import com.opsmen.klantensysteem.model.VerkoopOrder;
import com.opsmen.klantensysteem.service.IKlantenService;
import com.opsmen.klantensysteem.service.IOrderService;
import com.opsmen.klantensysteem.service.KlantenServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verkooporder")
public class VerkoopOrderController {
    private final IKlantenService klantenService;
    private final IOrderService verkoopOrderService;

    @Autowired
    public VerkoopOrderController(IKlantenService klantenService, IOrderService verkoopOrderService) {
        this.verkoopOrderService = verkoopOrderService;
        this.klantenService = klantenService;
    }

    @RequestMapping("/opklantnummer")
    public List<VerkoopOrder> getVerkoopOrdersOpKlantNummer(@RequestParam("klantnummer") String klantNummer) {
        try {
            return Optional.ofNullable(
                    klantenService.getKlantOpKlantNummer(klantNummer))
                    .flatMap(p -> Optional.ofNullable(verkoopOrderService.getOrdersOpKlant(p)))
                    .orElse(new ArrayList<>());
        } catch (KlantenServiceException e) {
            throw new RuntimeException(e);
        }
    }


}

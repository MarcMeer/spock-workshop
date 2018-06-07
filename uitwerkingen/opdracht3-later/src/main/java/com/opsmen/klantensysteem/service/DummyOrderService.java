package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.VerkoopOrder;
import com.opsmen.klantensysteem.model.Klant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyOrderService implements IOrderService {
    @Override
    public List<VerkoopOrder> getOrdersOpKlant(Klant klant) {
        return null;
    }

    @Override
    public VerkoopOrder getOrderOpOrderNummer(String orderNummer) {
        return null;
    }
}

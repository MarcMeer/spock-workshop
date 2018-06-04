package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.Klant;
import com.opsmen.klantensysteem.model.VerkoopOrder;

import java.util.List;

public interface IOrderService {
    List<VerkoopOrder> getOrdersOpKlant(Klant klant);
    VerkoopOrder getOrderOpOrderNummer(String orderNummer);
}

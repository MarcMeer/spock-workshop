package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.VerkoopOrder;
import com.opsmen.klantensysteem.model.VerkoopOrderRegel;

import java.util.List;

public class DummyOrderRegelService implements IOrderRegelService{
    @Override
    public List<VerkoopOrderRegel> getVerkoopOrderRegelVoorVerkoopOrder(VerkoopOrder verkoopOrder) {
        return null;
    }
}

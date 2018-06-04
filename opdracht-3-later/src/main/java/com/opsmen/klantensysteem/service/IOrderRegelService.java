package com.opsmen.klantensysteem.service;

import com.opsmen.klantensysteem.model.VerkoopOrder;
import com.opsmen.klantensysteem.model.VerkoopOrderRegel;

import java.util.List;

public interface IOrderRegelService {
    List<VerkoopOrderRegel> getVerkoopOrderRegelVoorVerkoopOrder(VerkoopOrder verkoopOrder);
}

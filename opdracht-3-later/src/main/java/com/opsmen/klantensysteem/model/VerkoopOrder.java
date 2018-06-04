package com.opsmen.klantensysteem.model;

import java.util.Date;
import java.util.List;

public class VerkoopOrder {
    private String orderNummer;
    private Klant klant;
    private List<VerkoopOrderRegel> verkoopOrderRegels;

    public List<VerkoopOrderRegel> getVerkoopOrderRegels() {
        return verkoopOrderRegels;
    }

    public void setVerkoopOrderRegels(List<VerkoopOrderRegel> verkoopOrderRegels) {
        this.verkoopOrderRegels = verkoopOrderRegels;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    private Date datum;

    public String getOrderNummer() {
        return orderNummer;
    }

    public void setOrderNummer(String orderNummer) {
        this.orderNummer = orderNummer;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }
}
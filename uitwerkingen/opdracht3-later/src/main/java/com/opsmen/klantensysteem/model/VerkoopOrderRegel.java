package com.opsmen.klantensysteem.model;

public class VerkoopOrderRegel {
    private VerkoopArtikel verkoopArtikel;
    private int aantal;
    private Double stuksPrijs;
    private Double korting;

    public VerkoopArtikel getVerkoopArtikel() {
        return verkoopArtikel;
    }

    public void setVerkoopArtikel(VerkoopArtikel verkoopArtikel) {
        this.verkoopArtikel = verkoopArtikel;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public Double getStuksPrijs() {
        return stuksPrijs;
    }

    public void setStuksPrijs(Double stuksPrijs) {
        this.stuksPrijs = stuksPrijs;
    }

    public Double getKorting() {
        return korting;
    }

    public void setKorting(Double korting) {
        this.korting = korting;
    }
}

package com.opsmen.klantensysteem.model;

import java.util.Date;
import java.util.List;

public class WeekUrenStaat {
    private List<UrenRegel> urenRegelList;
    private Medewerker invoerDoor;
    private Medewerker laatstAangepastDoor;
    private Medewerker goedGekeurdDoor;
    private Date datumInvoer;
    private Date datumLaatsteAanpassing;
    private Date datumGoedkeuring;
    private int jaar;
    private int weekNummer;
    private int maandNummer;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaandNummer() {
        return maandNummer;
    }

    public void setMaandNummer(int maandNummer) {
        this.maandNummer = maandNummer;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public int getWeekNummer() {
        return weekNummer;
    }

    public void setWeekNummer(int weekNummer) {
        this.weekNummer = weekNummer;
    }

    public List<UrenRegel> getUrenRegelList() {
        return urenRegelList;
    }

    public void setUrenRegelList(List<UrenRegel> urenRegelList) {
        this.urenRegelList = urenRegelList;
    }

    public Medewerker getInvoerDoor() {
        return invoerDoor;
    }

    public void setInvoerDoor(Medewerker invoerDoor) {
        this.invoerDoor = invoerDoor;
    }

    public Medewerker getLaatstAangepastDoor() {
        return laatstAangepastDoor;
    }

    public void setLaatstAangepastDoor(Medewerker laatstAangepastDoor) {
        this.laatstAangepastDoor = laatstAangepastDoor;
    }

    public Medewerker getGoedGekeurdDoor() {
        return goedGekeurdDoor;
    }

    public void setGoedGekeurdDoor(Medewerker goedGekeurdDoor) {
        this.goedGekeurdDoor = goedGekeurdDoor;
    }

    public Date getDatumInvoer() {
        return datumInvoer;
    }

    public void setDatumInvoer(Date datumInvoer) {
        this.datumInvoer = datumInvoer;
    }

    public Date getDatumLaatsteAanpassing() {
        return datumLaatsteAanpassing;
    }

    public void setDatumLaatsteAanpassing(Date datumLaatsteAanpassing) {
        this.datumLaatsteAanpassing = datumLaatsteAanpassing;
    }

    public Date getDatumGoedkeuring() {
        return datumGoedkeuring;
    }

    public void setDatumGoedkeuring(Date datumGoedkeuring) {
        this.datumGoedkeuring = datumGoedkeuring;
    }
}

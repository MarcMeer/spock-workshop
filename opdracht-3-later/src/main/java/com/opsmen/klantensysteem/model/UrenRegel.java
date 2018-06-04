package com.opsmen.klantensysteem.model;

import java.util.Date;

public class UrenRegel {
    private Date datum;
    private Double aantalUur;
    private Double verkoopUurtarief;
    private ConsultantRol consultantRol;
    private Medewerker consultant;
    private String klantNummer;
    private String weekUrenStaatId;
    private String id;

    public String getWeekUrenStaatId() {
        return weekUrenStaatId;
    }

    public void setWeekUrenStaatId(String weekUrenStaatId) {
        this.weekUrenStaatId = weekUrenStaatId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKlantNummer() {
        return klantNummer;
    }

    public void setKlantNummer(String klantNummer) {
        this.klantNummer = klantNummer;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    private Klant klant;

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getAantalUur() {
        return aantalUur;
    }

    public void setAantalUur(Double aantalUur) {
        this.aantalUur = aantalUur;
    }

    public Double getVerkoopUurtarief() {
        return verkoopUurtarief;
    }

    public void setVerkoopUurtarief(Double verkoopUurtarief) {
        this.verkoopUurtarief = verkoopUurtarief;
    }

    public ConsultantRol getConsultantRol() {
        return consultantRol;
    }

    public void setConsultantRol(ConsultantRol consultantRol) {
        this.consultantRol = consultantRol;
    }

    public Medewerker getConsultant() {
        return consultant;
    }

    public void setConsultant(Medewerker consultant) {
        this.consultant = consultant;
    }
}

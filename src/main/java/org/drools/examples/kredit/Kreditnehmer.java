package org.drools.examples.kredit;

/**
 * Created by sbacher on 01.02.2015.
 */
public class Kreditnehmer {
    private Berufsgruppe beruf;
    private double schufaRating;
    private Kredit bewilligterKredit;
    private String name;
    private Antrag antrag;

    public Berufsgruppe getBeruf() {
        return beruf;
    }

    public void setBeruf(Berufsgruppe beruf) {
        this.beruf = beruf;
    }

    public double getSchufaRating() {
        return schufaRating;
    }

    public void setSchufaRating(double schufaRating) {
        this.schufaRating = schufaRating;
    }

    public Kredit getBewilligterKredit() {
        return bewilligterKredit;
    }

    public void setBewilligterKredit(Kredit bewilligterKredit) {
        this.bewilligterKredit = bewilligterKredit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Antrag getAntrag() {
        return antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }
}

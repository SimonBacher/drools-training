package org.drools.examples.kredit;

/**
 * Created by sbacher on 01.02.2015.
 */
public class Kredit {

    private Kreditnehmer kreditnehmer;
    private double betrag;
    private double zinsen;

    public Kredit(Kreditnehmer kreditnehmer, double betrag, double zinsen) {
        this.kreditnehmer = kreditnehmer;
        this.betrag = betrag;
        this.zinsen = zinsen;
    }

    public Kreditnehmer getKreditnehmer() {
        return kreditnehmer;
    }

    public void setKreditnehmer(Kreditnehmer kreditnehmer) {
        this.kreditnehmer = kreditnehmer;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public double getZinsen() {
        return zinsen;
    }

    public void setZinsen(double zinsen) {
        this.zinsen = zinsen;
    }
}

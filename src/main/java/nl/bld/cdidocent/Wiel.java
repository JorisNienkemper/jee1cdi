package nl.bld.cdidocent;

import jakarta.inject.Inject;

public class Wiel {

    private  Velg velg;
    private  Band band;

    public Wiel() {
    }
    @Inject
    public Wiel(Velg velg, Band band){
        this.velg=velg;
        this.band=band;

    }
}

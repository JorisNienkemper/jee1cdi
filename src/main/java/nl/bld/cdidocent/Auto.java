package nl.bld.cdidocent;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

//Auto is in CDI termen een Managed Bean
//Dwz de lifecycle van de Auto wordt volledig gemaneged door CDI
//
public class Auto {

    private final Wiel wiel1;
    private final Wiel wiel2;
    private final Wiel wiel3;
    private final Wiel wiel4;
    private final Motor motor;
    private  StereoAtmos stereoAtmos;

    @Inject
    public Auto(Wiel wiel1, Wiel wiel2, Wiel wiel3, Wiel wiel4, Motor motor) {
        System.out.println("start constructor");
        this.wiel1=wiel1;
        this.wiel2=wiel2;
        this.wiel3=wiel3;
        this.wiel4=wiel4;
        this.motor=motor;
        System.out.println("end constructor");
    }

    @Inject
    public void setStereoAtmos(StereoAtmos stereoAtmos) {
        System.out.println("start setter");
        this.stereoAtmos = stereoAtmos;
        System.out.println("end setter");
    }

    @PostConstruct
    public void initFinished() {
        System.out.println("Dit is moment waarop we er van uit mogen gaan dat alle dependencies zijn gelegd");
        //Mooi moment om nog zaken klaar te zetten voor het echte gebruik in de business
        System.out.println("rijklaar");
    }

    @PreDestroy
    public void recycleMaterials(){
        System.out.println("recycle materials");
    }
}

package nl.bld.cdidocent;

import jakarta.enterprise.inject.Produces;

import java.util.List;

public class NamesProducer {

    @Produces
    @ImportantPeople
    public List<String> getNames(){
        return List.of("Dylan","Jamie","Tim");
    }
}

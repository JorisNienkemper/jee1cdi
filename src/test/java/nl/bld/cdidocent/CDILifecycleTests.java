package nl.bld.cdidocent;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CDILifecycleTests {

    WeldContainer container;

    @BeforeEach
    void setUpContainer(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        container = weld.initialize();
    }


    @Test
    @DisplayName("Een auto heeft 4 wielen een stuur en optioneel een stereo installatie met dolby atmos")
    void createAutoTheOldWay(){

        Auto auto = new Auto(new Wiel(), new Wiel(), new Wiel(), new Wiel(), new Motor());


    }

    @Test
    @DisplayName("Een auto heeft 4 wielen een stuur en optioneel een stereo installatie met dolby atmos")
    void createAutoTheNewdWay(){

        Auto auto = container.select(Auto.class).get();

        System.out.println(auto.toString());
    }

}

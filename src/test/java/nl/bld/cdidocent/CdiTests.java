package nl.bld.cdidocent;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CdiTests {

    WeldContainer container;

    @BeforeEach
    void setUpContainer(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        container = weld.initialize();
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void startCDI(){
        WeldInstance<PrinterService> cdiWrapper = container.select(PrinterService.class);
        PrinterService printerService = cdiWrapper.get();
        printerService.print("Wat een werk zeg!");
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void getImportantBeanFromCDIContainer(){
        WeldInstance<ImportantBean> cdiWrapper = container.select(ImportantBean.class);
        ImportantBean importantBean = cdiWrapper.get();
        importantBean.doWork();
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void watGeurtErHierAllemaal(){
        ImportantBean ib1 = container.select(ImportantBean.class).get();;
        ib1.doWork();
        ImportantBean ib2 = container.select(ImportantBean.class).get();;
        ib2.doWork();
        assertThat(ib1).isNotEqualTo(ib2);//importantBeans zijn verschillende instanties
        assertThat(ib1.getPrinterService()).isNotEqualTo(ib2.getPrinterService());
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

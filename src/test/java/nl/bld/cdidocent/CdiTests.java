package nl.bld.cdidocent;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CdiTests {

    @Test
    @DisplayName("Wat is dependency injection?")
    void simpleVoorbeeldZonderCDI(){

        ImportantBean importantBean = new ImportantBean();
        importantBean.doWork();

        importantBean.doWork();

    }
    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void startCDI(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        WeldContainer container = weld.initialize();
        WeldInstance<PrinterService> cdiWrapper = container.select(PrinterService.class);
        PrinterService printerService = cdiWrapper.get();
        printerService.print("Wat een werk zeg!");
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void getImportantBeanFromCDIContainer(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        WeldContainer container = weld.initialize();
        WeldInstance<ImportantBean> cdiWrapper = container.select(ImportantBean.class);
        ImportantBean importantBean = cdiWrapper.get();
        importantBean.doWork();
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void watGeurtErHierAllemaal(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        WeldContainer container = weld.initialize();
        ImportantBean ib1 = container.select(ImportantBean.class).get();;
        ib1.doWork();
        ImportantBean ib2 = container.select(ImportantBean.class).get();;
        ib2.doWork();
        assertThat(ib1).isNotEqualTo(ib2);//importantBeans zijn verschillende instanties
        assertThat(ib1.getPrinterService()).isNotEqualTo(ib2.getPrinterService());

    }

}

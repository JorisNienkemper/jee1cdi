package nl.bld.cdidocent;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CDIContextTests {
    WeldContainer container;

    @BeforeEach
    void setUpContainer(){
        Weld weld = new Weld();
        //WeldContainer container = new Weld().initialize();
        container = weld.initialize();
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void getTheSameClassTwice(){
        WeldInstance<ImportantBean> cdiwrapper = container.select(ImportantBean.class);
        ImportantBean ib1 = cdiwrapper.get();
        ib1.doWork();
        ImportantBean ib2 = container.select(ImportantBean.class).get();
        ib2.doWork();
        assertThat(ib1).isNotEqualTo(ib2);//importantBeans zijn verschillende instanties
        assertThat(ib1.getPrinterService()).isNotEqualTo(ib2.getPrinterService());
    }

    @Test
    @DisplayName("displayname")
    void printNamesImportantPersosn(){
        WeldInstance<ImportantBean> cdiwrapper = container.select(ImportantBean.class);
        ImportantBean ib1 = cdiwrapper.get();
        for (String importantPerson : ib1.getImportantPersons()) {
            System.out.println(importantPerson);
        }
    }
}

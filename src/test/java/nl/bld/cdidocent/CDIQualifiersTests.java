package nl.bld.cdidocent;

import jakarta.enterprise.util.AnnotationLiteral;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;

public class CDIQualifiersTests {

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
        //org.jboss.weld.exceptions.UnsatisfiedResolutionException:
        // WELD-001334: Unsatisfied dependencies for type PrinterService with qualifiers  WELD-001475:
        // The following beans match by type, but none have matching qualifiers:
        //  - Managed Bean [class nl.bld.cdidocent.FilePrinterService] with qualifiers [@Any @File],
        //  - Managed Bean [class nl.bld.cdidocent.ConsolePrinterService] with qualifiers [@Any @Console]
        //

        AnnotationLiteral<Console> consoleAnnotation = new AnnotationLiteral<Console>() {};
        AnnotationLiteral<File> fileAnnotation = new AnnotationLiteral<File>() {};

        WeldInstance<PrinterService> cdiWrapper = container.select(PrinterService.class,fileAnnotation);
        PrinterService printerService = cdiWrapper.get();
        printerService.print("Valt best mee!");
    }

    @Test
    @DisplayName("Start up the WeldContainer (CDI container)")
    void getImportantBeanFromCDIContainer(){
        WeldInstance<ImportantBean> cdiWrapper = container.select(ImportantBean.class);
        ImportantBean importantBean = cdiWrapper.get();
        importantBean.doWork();
    }





}

package nl.bld.cdidocent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import java.util.List;

@Dependent
public class ImportantBean {

    //PrinterService noemen we een dependency
//    @Inject
//    @File
    private PrinterService printerService;

    @Inject
    @ImportantPeople
    private List<String> importantPersons;

    public ImportantBean() {
        System.out.println("default constructor ib called");
    }

    @Inject
    public ImportantBean(@File PrinterService printerService) {
        System.out.println("Constructor ib called");
        this.printerService = printerService;
    }

    public PrinterService getPrinterService() {
        return printerService;
    }

    //  Unsatisfied dependencies for type PrinterService with qualifiers @Default
    //  at injection point [BackedAnnotatedParameter] Parameter 1 of
    //  [BackedAnnotatedMethod] @Inject @Console public nl.bld.cdidocent.ImportantBean.setPrinterService(PrinterService)
    //  at nl.bld.cdidocent.ImportantBean.setPrinterService(ImportantBean.java:0)

    @Inject
    public void setPrinterService( @File Instance<PrinterService> printerServiceInstance) {
        System.out.println("setter is called");
        if (printerServiceInstance.isResolvable()) {
            this.printerService = printerServiceInstance.get();
        }
    }


    public List<String> getImportantPersons() {
        return importantPersons;
    }

    public void doWork() {
        printerService.print("Starting doing important work");
        //Doen hier belangrijkwerk
        printerService.print("Finished doing important work");
    }
}

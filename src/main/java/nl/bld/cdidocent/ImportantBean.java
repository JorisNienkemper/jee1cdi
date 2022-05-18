package nl.bld.cdidocent;

import jakarta.inject.Inject;

public class ImportantBean {

    //PrinterService noemen we een dependency
    @Inject
    private PrinterService printerService;

    public ImportantBean() {
        System.out.println("default constructor ib called");
    }

    @Inject
    public ImportantBean(PrinterService printerService){
        System.out.println("Constructor ib called");
        this.printerService =printerService;
    }

    public PrinterService getPrinterService() {
        return printerService;
    }
    @Inject
    public void setPrinterService(PrinterService printerService){
        System.out.println("setter is called");
        this.printerService=printerService;
    }

    public void doWork() {
        printerService.print("Starting doing important work");
        //Doen hier belangrijkwerk
        printerService.print("Finished doing important work");
    }
}
package nl.bld.cdidocent;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;

@Any
@Console
@Dependent
public class ConsolePrinterService implements PrinterService {

    public void print(String message){
        System.out.println("printing to console: " + message);
    }
}

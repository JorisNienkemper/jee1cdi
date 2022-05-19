package nl.bld.cdidocent;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;

@Any
public class ConsolePrinterService implements PrinterService {

    public void print(String message){
        System.out.println("printing to console: " + message);
    }
}

package nl.bld.cdidocent;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;

@Any
@File
public class FilePrinterService  implements PrinterService  {

    public void print(String message){
        System.out.println("printing to file: " + message);
    }
}

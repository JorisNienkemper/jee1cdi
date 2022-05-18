package nl.bld.cdidocent;

public class PrinterService {
    public PrinterService() {
        System.out.println("constructor ps called" + this.hashCode());
    }

    public void print(String message) {
        System.out.println("printing: " +message);
    }
}

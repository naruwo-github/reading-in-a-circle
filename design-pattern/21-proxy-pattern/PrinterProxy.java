public class PrinterProxy implements Printable {
    private String name;
    private Printer real;

    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        if (this.real != null) {
            this.real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        this.realize();
        this.real.print(string);
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }
}
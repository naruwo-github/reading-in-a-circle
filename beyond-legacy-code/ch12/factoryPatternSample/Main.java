import abstractClass.Factory;
import abstractClass.Phone;
import concreteClass.PhoneFactory;
import enumerate.OS;

class Main {
    public static void main(String[] args) {
        Factory factory = new PhoneFactory();

        Phone galaxy5 = factory.create("Galaxy5", OS.Android);
        Phone iPhone11 = factory.create("iPhone11", OS.iOS);
        Phone linuxPhone = factory.create("lPhone", OS.Linux);

        galaxy5.call();
        iPhone11.call();
        linuxPhone.call();
    }
}
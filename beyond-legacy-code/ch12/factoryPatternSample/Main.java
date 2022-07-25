import java.util.*;
import abstractClass.Factory;
import abstractClass.Phone;
import concreteClass.AndroidPhone;
import concreteClass.iPhone;
import concreteClass.linuxPhone;
import concreteClass.PhoneFactory;
import enumerate.PhoneType;

class Main {
    public static void main(String[] args) {
        Factory factory = new PhoneFactory();

        Phone galaxy5 = factory.create("Galaxy5", PhoneType.Android);
        Phone iPhone11 = factory.create("iPhone11", PhoneType.iOS);
        Phone linuxPhone = factory.create("lPhone", PhoneType.Linux);

        galaxy5.call();
        iPhone11.call();
        linuxPhone.call();
    }
}
package concreteClass;

import abstractClass.Factory;
import abstractClass.Phone;
import enumerate.PhoneType;

public class PhoneFactory extends Factory {
    protected Phone createPhone(String name, PhoneType type) {
        switch (type) {
            case Android:
                return new AndroidPhone(name);
            case iOS:
                return new iPhone(name);
            case Linux:
                return new linuxPhone(name);
            default:
                break;
        }
        return new AndroidPhone(name);
    }

    protected void registerPhone(Phone phone) {
    }
}
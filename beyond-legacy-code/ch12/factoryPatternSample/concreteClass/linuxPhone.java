package concreteClass;

import abstractClass.Phone;

public class linuxPhone extends Phone {
    private String name;

    linuxPhone(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("Hi, " + name + " speaking!");
    }
}
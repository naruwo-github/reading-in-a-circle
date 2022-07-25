package concreteClass;

import abstractClass.Phone;

public class iPhone extends Phone {
    private String name;

    iPhone(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("Hi, " + name + " speaking!");
    }
}
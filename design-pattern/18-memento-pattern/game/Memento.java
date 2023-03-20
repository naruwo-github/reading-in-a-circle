package game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;
    private List<String> fruits;

    // narrow interface
    public int getMoney() {
        return this.money;
    }

    // wide interface
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // wide interface
    void addFruit(String fruit) {
        this.fruits.add(fruit);
    }

    // wide interface
    List<String> getFruits() {
        return new ArrayList<>(this.fruits);
    }
}
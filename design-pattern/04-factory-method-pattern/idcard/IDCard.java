package idcard;

import framework.Product;

public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("Create a card of " + owner);
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("Use " + this);
    }

    @Override
    public String toString() {
        return "[IDCard: " + this.owner + "]";
    }

    public String getOwner() {
        return this.owner;
    }
}
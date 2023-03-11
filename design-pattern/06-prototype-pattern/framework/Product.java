package framework;

public interface Product {
    // abstract class/interface for prototype

    public abstract void use(String s);

    public abstract Product createCopy();
}
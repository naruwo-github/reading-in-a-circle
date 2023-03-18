public class Trouble {
    private int number; // trouble number

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "[Trouble " + this.getNumber() + "]";
    }
}
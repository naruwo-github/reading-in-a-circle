public class AndroidPhone extends Phone {
    private String name;

    AndroidPhone(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("Hi, " + name + " speaking!");
    }
}
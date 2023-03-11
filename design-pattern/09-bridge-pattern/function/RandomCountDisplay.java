import java.util.Random;

import implementation.DisplayImpl;

public class RandomCountDisplay extends CountDisplay {
    private Random random = new Random();

    public RandomCountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void randomDisplay(int times) {
        this.multiDisplay(this.random.nextInt(times));
    }
}
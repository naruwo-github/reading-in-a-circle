import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            this.prevHand = Hand.getHand(this.random.nextInt(3));
        }
        return this.prevHand;
    }

    @Override
    public void study(boolean win) {
        this.won = win;
    }
}
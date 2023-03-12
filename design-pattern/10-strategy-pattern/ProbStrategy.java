import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            { 1, 1, 1 },
            { 1, 1, 1 },
            { 1, 1, 1 }
    };

    public ProbStrategy(int seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = this.random.nextInt(getSum(this.currentHandValue));
        int handValue = 0;
        if (bet < this.history[this.currentHandValue][0]) {
            handValue = 0;
        } else if (bet < this.history[this.currentHandValue][0] + this.history[this.currentHandValue][1]) {
            handValue = 1;
        } else {
            handValue = 2;
        }
        this.prevHandValue = this.currentHandValue;
        this.currentHandValue = handValue;
        return Hand.getHand(handValue);
    }

    private int getSum(int handValue) {
        int sum = 0;
        // for (int i = 0; i < 3; i++) {
        // sum += this.history[handValue][i];
        // }
        for (int i : this.history[handValue]) {
            sum += i;
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            this.history[this.prevHandValue][this.currentHandValue]++;
        } else {
            this.history[this.prevHandValue][(this.currentHandValue + 1) % 3]++;
            this.history[this.prevHandValue][(this.currentHandValue + 2) % 3]++;
        }
    }
}
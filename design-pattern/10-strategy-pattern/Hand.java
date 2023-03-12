public enum Hand {
    // 手を表すenum定数
    ROCK("グー", 0),
    SCISSORS("チョキ", 1),
    PAPER("パー", 2);

    // enumが持つフィールド
    private String name;
    private int handValue;

    private static Hand[] hands = {
            ROCK, SCISSORS, PAPER
    };

    private Hand(String name, int handValue) {
        this.name = name;
        this.handValue = handValue;
    }

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    // 自身がhandより強い場合にtrue
    public boolean isStrongerThan(Hand hand) {
        return this.fight(hand) == 1;
    }

    // 自身がhandより弱い場合にtrue
    public boolean isWeakerThan(Hand hand) {
        return this.fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            // 引き分け
            return 0;
        } else if ((this.handValue + 1) % 3 == hand.handValue) {
            // 自身の勝ち
            return 1;
        } else {
            // 自身の負け
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
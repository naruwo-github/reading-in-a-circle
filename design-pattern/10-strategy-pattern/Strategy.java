public interface Strategy {
    // 次に出す手を得るためのメソッド
    public abstract Hand nextHand();

    // さっき出した手によって勝ったかどうかを学習するためのメソッド
    public abstract void study(boolean win);
}
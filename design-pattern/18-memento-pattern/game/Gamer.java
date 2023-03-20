package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List<String> fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsName = { "リンゴ", "ぶどう", "バナナ", "みかん", };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    // 賭ける…ゲームの進行
    public void bet() {
        // サイコロを振る
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            this.money += 100;
            System.out.println("所持金が増えました。");
        } else if (dice == 2) {
            this.money /= 2;
            System.out.println("所持金が半分になりました。");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ(" + f + ")をもらいました。");
            this.fruits.add(f);
        } else {
            System.out.println("何も起こりませんでした。");
        }
    }

    public Memento createMemento() {
        // take a snapshot

        Memento m = new Memento(money);
        for (String f : fruits) {
            // フルーツはおいしいものだけ保存
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {
        // undo

        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    @Override
    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    private String getFruit() {
        String f = fruitsName[random.nextInt(fruitsName.length)];
        if (random.nextBoolean()) {
            return "おいしい" + f;
        } else {
            return f;
        }
    }
}
import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    private Map<String, BigChar> bigCharPool = new HashMap<>();
    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigCharのインスタンス生成(共有)
    public synchronized BigChar getBigChar(char charName) {
        BigChar bigChar = bigCharPool.get(String.valueOf(charName));
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            bigCharPool.put(String.valueOf(charName), bigChar);
        }
        return bigChar;
    }
}
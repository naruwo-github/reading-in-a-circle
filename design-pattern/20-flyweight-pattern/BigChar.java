import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 文字の名前
    private char charName;
    // 大きな文字を表現する文字列('#' '.' '\n'の列)
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            String filename = "big" + charName + ".txt";
            StringBuilder sb = new StringBuilder();
            for (String line : Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            this.fontData = sb.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.print(fontData);
    }
}
public class BigString {
    private BigChar[] bigCharArray;

    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigCharArray = new BigChar[string.length()];
        for (int i = 0; i < bigCharArray.length; i++) {
            bigCharArray[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void print() {
        for (BigChar bc : bigCharArray) {
            bc.print();
        }
    }
}
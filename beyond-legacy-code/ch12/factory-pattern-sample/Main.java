public static void main(String[] args) {
    Factory factory = new PhoneFactory();

    Phone galaxy5 = factory.create("Galaxy5", PhoneType.Android);
    Phone iPhone11 = factory.create("iPhone11", PhoneType.iOS);
    Phone linuxPhone = factory.create("lPhone", PhoneType.Linux);

    galaxy5.call();
    iPhone11.call();
    linuxPhone.call();
}
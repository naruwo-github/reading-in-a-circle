public class PhoneFactory extends Factory {
    protected Phone createPhone(String name, PhoneType type) {
        switch (type) {
            case Android:
                return new AndroidPhone(name);
            case iOS:
                return new iPhone(name);
            case Linux:
                return new linuxPhone(name);
            default:
                break;
        }
    }

    protected void registerPhone(Phone phone) {
    }
}

enum PhoneType {
    Android,
    iOS,
    Linux
}
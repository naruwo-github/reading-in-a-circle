package abstractClass;

import enumerate.OS;

public abstract class Factory {
    public final Phone create(String name, OS type) {
        Phone phone = createPhone(name, type);
        registerPhone(phone);
        return phone;
    }

    protected abstract Phone createPhone(String name, OS type);
    protected abstract void registerPhone(Phone phone);
}
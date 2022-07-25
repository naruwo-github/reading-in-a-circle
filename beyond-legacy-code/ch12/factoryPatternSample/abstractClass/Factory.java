package abstractClass;

import enumerate.PhoneType;

public abstract class Factory {
    public final Phone create(String name, PhoneType type) {
        Phone phone = createPhone(name, type);
        registerPhone(phone);
        return phone;
    }

    protected abstract Phone createPhone(String name, PhoneType type);
    protected abstract void registerPhone(Phone phone);
}
public abstract class Entry {
    private Entry parent;

    protected void setParent(Entry entry) {
        this.parent = parent;
    }

    public abstract String getName();

    public abstract int getSize();

    public void printList() {
        this.printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return this.getName() + "(" + this.getSize() + ")";
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        Entry entry = this;
        do {
            fullName.insert(0, entry.getName());
            fullName.insert(0, "/");
            entry = entry.parent;
        } while (entry != null);
        return fullName.toString();
    }
}
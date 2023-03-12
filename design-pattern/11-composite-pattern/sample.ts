interface Component {
    operation(): void;
}

class Leaf implements Component {
    operation(): void {
        console.log("Leaf operation.");
    }
}

class Composite implements Component {
    private children: Component[] = [];

    add(component: Component): void {
        this.children.push(component);
    }

    remove(component: Component): void {
        const index = this.children.indexOf(component);
        if (index !== -1) {
            this.children.splice(index, 1);
        }
    }

    operation(): void {
        console.log("Composite operation.");
        this.children.forEach((child) => {
            child.operation();
        });
    }
}

const rootDirectory = new Composite();
const directory1 = new Composite();
const directory2 = new Composite();
const file1 = new Leaf();
const file2 = new Leaf();

rootDirectory.add(directory1);
rootDirectory.add(directory2);
directory1.add(file1);
directory2.add(file2);

rootDirectory.operation();

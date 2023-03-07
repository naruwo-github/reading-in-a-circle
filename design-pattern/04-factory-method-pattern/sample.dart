abstract class Pet {
  String get name;
  String speak();

  factory Pet(String type, String name) {
    switch (type) {
      case 'cat':
        return Cat(name);
      case 'dog':
        return Dog(name);
      default:
        throw ArgumentError('Invalid pet type: $type');
    }
  }
}

class Cat implements Pet {
  final String name;

  Cat(this.name);

  @override
  String speak() => 'Meow!';
}

class Dog implements Pet {
  final String name;

  Dog(this.name);

  @override
  String speak() => 'Woof!';
}

void main() {
  final myCat = Pet('cat', 'Fluffy');
  print('${myCat.name} says ${myCat.speak()}');

  final myDog = Pet('dog', 'Rufus');
  print('${myDog.name} says ${myDog.speak()}');

  // Throws ArgumentError because "parrot" is not a valid pet type
  //final myPet = Pet('parrot', 'Polly');
}

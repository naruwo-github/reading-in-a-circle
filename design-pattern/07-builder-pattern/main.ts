class User {
  private readonly name: string;
  private readonly age: number;
  private readonly email: string;
  private readonly address: string;

  constructor(builder: UserBuilder) {
    this.name = builder.name;
    this.age = builder.age;
    this.email = builder.email;
    this.address = builder.address;
  }

  public getName(): string {
    return this.name;
  }

  public getAge(): number {
    return this.age;
  }

  public getEmail(): string {
    return this.email;
  }

  public getAddress(): string {
    return this.address;
  }
}

class UserBuilder {
  public readonly name: string;
  public age: number = 0;
  public email: string = '';
  public address: string = '';

  constructor(name: string) {
    this.name = name;
  }

  public setAge(age: number): UserBuilder {
    this.age = age;
    return this;
  }

  public setEmail(email: string): UserBuilder {
    this.email = email;
    return this;
  }

  public setAddress(address: string): UserBuilder {
    this.address = address;
    return this;
  }

  public build(): User {
    return new User(this);
  }
}

// Usage example
const user = new UserBuilder('John')
  .setAge(30)
  .setEmail('john@example.com')
  .setAddress('123 Main St')
  .build();

console.log('Name:', user.getName());
console.log('Age:', user.getAge());
console.log('Email:', user.getEmail());
console.log('Address:', user.getAddress());

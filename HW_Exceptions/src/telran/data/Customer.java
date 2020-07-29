package telran.data;

public class Customer {
    String name;
    int age;
    BankAccount account;

    public Customer(String name, int age, BankAccount account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer: (" + "name: '" + name + "', age: '" + age + "', account: " + account + ") ";
    }
}

package dz3;

public class Account {
    String type;
    int balance;

    //снять деньги
    public int remove(int balance) {
        this.balance = this.balance - balance;
        System.out.print("На счету: " + type + " "+ getBalance() + "\n");
        return this.balance;
    }

    //пополнить баланс
    public int fill (int balance) {
        this.balance = this.balance + balance;
        System.out.print("На счету: " + type + " "+ getBalance() + "\n");
        return this.balance;
    }

    public int getBalance () {
        return balance;
    }

}

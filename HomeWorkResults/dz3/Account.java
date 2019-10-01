package dz3;

public class Account {
    int maxCountAMOUNT = 30000;
    int countAMOUNT = 0;
    String type;
    int balance;

    public Account (String accountType, int amount) {
        this.type = accountType;
        this.balance = amount;
    }

    //снять деньги
    public int remove(int amount) {
        if (countAMOUNT>=maxCountAMOUNT){
            System.out.println("Не возможно снимать более 30 000 за сеанс!");
        }
        else if (balance - amount<0 && type!="Credit"){
            System.out.println("Не достаточно средств!");
        }
        else {
            balance = balance - amount;
            countAMOUNT +=amount;
        }
        return balance;
    }

    //пополнить баланс
    public int fill (int amount) {
        balance = balance + amount;
        return balance;
    }

}

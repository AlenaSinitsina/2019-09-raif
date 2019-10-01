package dz3;

import static dz3.ComparisonOperation.*;

import java.util.Scanner;

public class Bankomat {

    int maxCountAccount = 3;
    int countAccount = 0;
    Account account[] = new Account[maxCountAccount];

    public static void main(String[] args) {
        Bankomat bankomat = createBankomatAndAccount();
        bankomat.printBalanceAccounts ();
        // ??? Как умнее зациклить с использованием метода getOperation не перезатирая результат ???
        ComparisonOperation a = getOperation(bankomat);

        do {
            if (a == FULL_ON_ACCOUNT)
                fillMoneyOnAccount(bankomat, bankomat.account[getAccount(bankomat)], getSum()); //тут должен был быть вызов getAccountComparisonAccount(), не сходятся типами :(
            else if (a == REMOTE_ON_ACCOUNT)
                removeMoneyOnAccount(bankomat.account[getAccount(bankomat)], getSum());
            else if (a == TRANSFER_AMOUNT)
                withdrawMoneyOnAccount(bankomat.account[getAccount(bankomat)], bankomat.account[getAccount(bankomat)], getSum());
            bankomat.printBalanceAccounts();
            a = getOperation(bankomat);
        }while (a!=CLOSE);
    }

    private void printBalanceAccounts() {
        System.out.println("На ваших счетах:");
        for (int i =0; i< maxCountAccount; i ++) {
            System.out.println(account[i].type + ": "+ account[i].balance);
        }
    }

    private static void withdrawMoneyOnAccount(Account accountTypeOut, Account accountTypeIn, int amount) {
        if (accountTypeOut.balance>=amount) {
            accountTypeOut.remove(amount);
            accountTypeIn.fill(amount);
        } else {
            System.out.println("Не достаточно средств на счете " + accountTypeOut.type);
        }
    }

    private static void removeMoneyOnAccount(Account accountType, int amount) {
        accountType.remove(amount);
    }

    private static void fillMoneyOnAccount(Bankomat bankomat, Account accountType, int amount) {
        if (accountType== bankomat.account[2] && amount>1000000) {
            bankomat.account[1].fill(2000);
        }
        accountType.fill(amount);
    }

    private static Bankomat createBankomatAndAccount() {
        System.out.print("Добро пожаловать в банкомат.");
        Bankomat bankomat = new Bankomat();
        bankomat.addAccount("Credit", 500);
        bankomat.addAccount("Debit", 1000);
        bankomat.addAccount("Current", 2000);
        return bankomat;
    }

    private void addAccount(String accountType, int amount) {
        if (countAccount <= maxCountAccount) {
            account[countAccount] = new Account(accountType, amount);
            countAccount++;
        }
    }

    public static ComparisonOperation getOperation(Bankomat bankomat) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите операцию для дальнейшей работы.\n" + "1 - Внести деньги на счет\n"
                                 + "2 - Вывести деньги со счета\n" + "3 - Перевод на другой счет\n"
                                 + "0 - Выход из меню\n");
        String s;
        s = scanner.next();
        do {
            if (s.equals("1")) {
                return FULL_ON_ACCOUNT;
            } else if (s.equals("2")) {
                return REMOTE_ON_ACCOUNT;
            } else if (s.equals("3")) {
                return TRANSFER_AMOUNT;
            } else if (s.equals("0")) {
                return CLOSE;
            } else {
                System.out.print("Не корректный выбор операции, попробуйте еще!\n");
            }
            System.out.print("Укажите операцию для дальнейшей работы.\n" + "1 - Внести деньги на счет\n"
                                     + "2 - Вывести деньги со счета\n" + "3 - Перевод на другой счет\n"
                                     + "0 - Выход из меню\n");
            s = scanner.next();
        } while (!s.equals("0"));
        return null;
    }

    public static int getAccount(Bankomat bankomat) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n"
                                 + "3 - Текущий\n");
        String s;
        s = scanner.next();
        do {
            if (s.equals("1")) {
                return 0;
            } else if (s.equals("2")) {
                if (bankomat.account[0].balance < -20000)
                    System.out.println("Наличие кредитного счета с балансом менее минус 20 000 запрещает работу с дебетовым счетом");
                else
                    return 1;
            } else if (s.equals("3")) {
                return 2;
            } else {
                System.out.print("Не корректный выбор счета, попробуйте еще!\n");
            }
            System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n" + "3 - Текущий\n");
            s = scanner.next();
        } while (1==1);
    }

    public static int getSum() {
        System.out.print("Укажите Сумму\n");
        Scanner scanner = new Scanner(System.in);
        int sum;
        sum = scanner.nextInt();
        return sum;
    }



   /* public static ComparisonAccount getAccountComparisonAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n"
                                 + "3 - Текущий\n");
        String s;
        s = scanner.next();
        do {
            if (s.equals("1")) {
                return ComparisonAccount.DEBIT;
            } else if (s.equals("2")) {
                return ComparisonAccount.CREDIT;
            } else if (s.equals("3")) {
                return ComparisonAccount.CURRENT;
            } else {
                System.out.print("Не корректный выбор счета, попробуйте еще!\n");
            }
            System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n" + "3 - Текущий\n");
            s = scanner.next();
        } while (1==1);
    }*/

    /*private  Account getAccount1(Class<? extends Account> accountType) {
        for (Account account : account) {
            if (accountType == account.getClass()) {
                return account;
            }
        }
        return null;
    }

    private Account getAccount2 (Account accountType) {
        for (Account account : account) {
            if (accountType.equals(account.type)) {
                return account;
            }
        }
        return null;
    }*/
}

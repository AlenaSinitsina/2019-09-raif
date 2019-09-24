package dz3;

import java.util.Scanner;

public class Bankomat extends Account {

    public static void main(String[] args){
        System.out.print("Добро пожаловать в банкомат.");
        getDo();
    }

    public static void getDo(){
        System.out.print("Укажите операцию для дальнейшей работы.\n"+ "1 - Внести деньги на счет\n"+ "2 - Вывести деньги со счета\n"+ "3 - Перевод на другой счет\n"+ "0 - Выход из меню\n");
        Scanner scanner = new Scanner(System.in);
        String s;
        s = scanner.next();
         do {
             if (s.equals("1"))
                 getAcc().fill(getSum());
             else if (s.equals("2"))
                 getAcc().remove(getSum());
             else if (s.equals("3"))
                 translation(getAcc(), getAcc(), getSum());
             else
                 System.out.print("Не корректный выбор операции, попробуйте еще!\n");
             System.out.print("Укажите операцию для дальнейшей работы.\n" + "1 - Внести деньги на счет\n"
                                      + "2 - Вывести деньги со счета\n" + "3 - Перевод на другой счет\n"
                                      + "0 - Выход из меню\n");
             s = scanner.next();
         }while(!s.equals("0"));
    }

    public static Account getAcc() {
        Scanner scanner = new Scanner(System.in);
        Debit DebitAcc = new Debit();
        Credit CreditAcc = new Credit();
        Current CurrentAcc = new Current();
        String s;
        System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n"
                                 + "3 - Текущий\n");
        s = scanner.next();
        do {
            if (s.equals("1"))
                return CreditAcc;
            else if (s.equals("2"))
                return DebitAcc;
            else if (s.equals("3"))
                return CurrentAcc;
            else
                System.out.print("Не корректный выбор счета, попробуйте еще!");
            System.out.print("Укажите счет для дальнейшей работы.\n" + "1 - Кредит\n" + "2 - Дебит\n"
                                     + "3 - Текущий\n");
            s = scanner.next();
        }while(!s.equals("0"));
        return null;
    }

    public static int getSum(){
        System.out.print("Укажите Сумму\n");
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        return sum;
    }

    private static void translation(Account account1, Account account2, int sum) {
        account1.remove(sum);
        account2.fill(sum);
    }
}

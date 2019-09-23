package dz4;
import java.lang.reflect.Array;
import java.util.Scanner;

class card {

    public static void main(String[]args){
        Scanner nc = new Scanner(System.in);
        int arrNumberCard[] = new int[16];
        int count=0;
        String numberCard;
        do {
            System.out.print("Введите номер карты: " + "\n");
            numberCard = nc.next();
            if (numberCard.length() != 16)
                System.out.print("Введен не корректный номeр карты. Долно быть 16 символов." + "\n");
        }while (numberCard.length() != 16);

        System.out.print("Ведется проверка карты по алгоритму луна . . ."+ "\n");

        for (int i =0; i < arrNumberCard.length; i++) {
            arrNumberCard[i] = Integer.parseInt(numberCard.substring(i, i + 1));
            //нечетное
            if (i%2==0){
                if (arrNumberCard[i]*2>9)
                    arrNumberCard[i]=(arrNumberCard[i]*2)-9;
                else
                    arrNumberCard[i]=arrNumberCard[i]*2;
            }
            count+=arrNumberCard[i];
        }
        System.out.print("Число по алгоритму = " + count + "\n");
        if (count%10==0)
            System.out.print("Номер карты корректный");
        else
            System.out.print("Номер карты не корректный!");
    }
}
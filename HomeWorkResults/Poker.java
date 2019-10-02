package blok2dz1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Poker {
    private int countPlayers;
    private Scanner scanner = new Scanner(System.in);
    private static int maxCountCardsOut = 52;
    private static int countCardsOut = 0;
    private String[] cards = new String[maxCountCardsOut];
    private String[] cardsSort = new String [maxCountCardsOut];
    Random random= new Random();

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.initializationCards();
        poker.getCountPlayers();
        poker.sorting();
        poker.giveOut();
        System.out.println("В коллоде осталось: " + (maxCountCardsOut-countCardsOut));

    }

    private void sorting() {
        System.out.println("sorting:");
        ArrayList indexesCards = new ArrayList(maxCountCardsOut);
        int count = 0;
        while (true) {
            int randomIndex = random.nextInt(maxCountCardsOut);
            if (!indexesCards.contains(randomIndex)) {
                indexesCards.add(randomIndex);
                cardsSort[randomIndex] = cards [count++];
            }
            if (count == maxCountCardsOut) {
                break;
            }
        }
        printCards(cardsSort);
        System.out.println("\n");
    }

    private void giveOut() {
        for (int i = 1; i<=countPlayers; i++){
            String [] arr = new String[5];
            for (int c =0; c<5; c++) {
                arr[c] = cardsSort[(maxCountCardsOut-countCardsOut-1)];
                countCardsOut+=1;
            }
            printCards(arr);
        }
    }

    private void printCards(String [] arr) {
        for (String v : arr) {
            System.out.print(v);
        }
        System.out.print ("\n");
    }

    private void getCountPlayers() {
        System.out.println("Введите количество игроков");
        try {
            countPlayers = scanner.nextInt();
            if (countPlayers>10){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Не верный ввод! Попробуйте еще раз");
            getCountPlayers();
        }
    }

    private void initializationCards() {
        for (int i=0; i<9; i++){
            cards[i]=(i+2)+"-Пики ";
        }
        for (int i=9; i<18; i++){
            cards[i]=(i-7)+"-Червы ";
        }
        for (int i=18; i<27; i++){
            cards[i]=(i-16)+"-Трефы ";
        }
        for (int i=27; i<36; i++){
            cards[i]=(i-26)+"-Бубны ";
        }

        cards[36]="Т-Трефы ";
        cards[37]="К-Трефы ";
        cards[38]="Д-Трефы ";
        cards[39]="B-Трефы ";

        cards[40]="Т-Бубны ";
        cards[41]="К-Бубны ";
        cards[42]="Д-Бубны ";
        cards[43]="B-Бубны ";

        cards[44]="Т-Пики ";
        cards[45]="К-Пики ";
        cards[46]="Д-Пики ";
        cards[47]="B-Пики ";

        cards[48]="Т-Червы ";
        cards[49]="К-Червы ";
        cards[50]="Д-Червы ";
        cards[51]="B-Червы ";

        System.out.println("initializationCards:");
        printCards(cards);
    }
}

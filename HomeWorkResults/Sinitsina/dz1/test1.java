package dz1;

import java.util.Random;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Random  random= new Random();
        int randomNumber = random.nextInt(101);
        Scanner in = new Scanner(System.in);
        System.out.print("Приветствую! Это игра Горячо-холодно. Необходимо угадать число от 0 до 100, загаданное мной. "
                                 + "Я буду подсказывать на сколько ты приближаешься к победе." + "\n");
        System.out.print("Введите первое число и нажмите Enter: " + "\n");
        int inputNumber1 = in.nextInt();
        int inputNumber2 = inputNumber1;

        while (inputNumber2 != randomNumber) {
            System.out.print("Введите следующее число и нажмите Enter: " + "\n");
            inputNumber2 = in.nextInt();
            if (inputNumber2 == randomNumber) {
                System.out.print("Успех" + "\n");
                break;
            }
            if (Math.abs(inputNumber2 - randomNumber) < Math.abs(inputNumber1 - randomNumber))
                System.out.print("горячо" + "\n");
            else if (Math.abs(inputNumber1 - randomNumber) < Math.abs(inputNumber2 - randomNumber))
                System.out.print("холодно" + "\n");
            else
                System.out.print("Введенные значения равны" + "\n");
            inputNumber1 = inputNumber2;
        }
    }
}
package dz1;

import java.util.Random;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Random  random= new Random();
        int randomNumber = random.nextInt(101);
        Scanner in = new Scanner(System.in);
        System.out.print("Приветствую! Это игра Горячо-холодно. Необходимо угадать число от 0 до 100, загаданное мной. "
                                 + "Я буду подсказывать на сколько ты приближаешься к победе.\n");
        System.out.print("Введите первое число и нажмите Enter: \n");
        int inputNumberPrevious = in.nextInt();
        int inputNumberCurrent = inputNumberPrevious;

        while (inputNumberCurrent != randomNumber) {
            System.out.print("Введите следующее число и нажмите Enter: \n");
            inputNumberCurrent = in.nextInt();
            if (inputNumberCurrent == randomNumber) {
                System.out.print("Успех\n");
                break;
            }
            if (Math.abs(inputNumberCurrent - randomNumber) < Math.abs(inputNumberPrevious - randomNumber))
                System.out.print("горячо\n");
            else if (Math.abs(inputNumberPrevious - randomNumber) < Math.abs(inputNumberCurrent - randomNumber))
                System.out.print("холодно\n");
            else
                System.out.print("Введенные значения равны \n");
            inputNumberPrevious = inputNumberCurrent;
        }
    }
}
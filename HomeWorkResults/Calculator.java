package dz5;

import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);
    String inputString;
    String[] inputStringSplit;
    int result;
    int num1;
    int num2;
    String operation;

    public static void main(String[] args) {
       Calculator calculator = new Calculator();
        System.out.print("Добро пожаловать в калькулятор.\n");
       for(;;){
           calculator.inputAndParsingString();
           System.out.println("Выражение равно: " + calculator.calculation());
       }
    }

    private int calculation() {
        try {
            if ("+".equals(operation)) {
                result = num1 + num2;
            } else if ("-".equals(operation)) {
                result = num1 - num2;
            } else if ("*".equals(operation)) {
                result = num1 * num2;
            } else if ("/".equals(operation)) {
                result = num1 / num2;
            }
        } catch (Exception e){
            System.out.println("Операция не распознана. Повторите ввод.");
        }
        return result;
    }

    private void inputAndParsingString() {
        System.out.println("Введите выражение- 2 цифры и знак между ними");
        try {
            inputString = scanner.next();
            inputStringSplit = inputString.split("");
            if(inputStringSplit.length>3 || !checkNumber(inputStringSplit[0]) || !checkNumber(inputStringSplit[2]) || !checkSign(inputStringSplit[1])){
                throw new Exception();
            }
            else {
                num1 = Integer.parseInt(inputStringSplit[0]);
                operation = inputStringSplit[1];
                num2 = Integer.parseInt(inputStringSplit[2]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не корректный ввод, попробуйте еще раз!");
            inputAndParsingString();
        }
    }

    private boolean checkNumber(String number) {
       if (number.equals("0")||number.equals("1")||number.equals("2")||number.equals("3")||number.equals("4")
               ||number.equals("5")||number.equals("6")||number.equals("7")||number.equals("8")||number.equals("9"))
           return true;
       else return false;
    }

    private boolean checkSign(String number) {
       if (number.equals("+")||number.equals("-")||number.equals("*")||number.equals("/"))
           return true;
       else  return false;
    }
}
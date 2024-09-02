package com.csc;
import java.util.Scanner;

public class Menu {
    public static int promptInt(Integer lowerBound, Integer upperBound, String prompt, String errorMessage) {
        Scanner scan = new Scanner(System.in);
        Integer input = null;

        while (true) {
            System.out.print(prompt);
            if (!scan.hasNextInt()) {
                System.out.println(errorMessage);
                scan.next();
                continue;
            }
            input = scan.nextInt();
            if (lowerBound != null && input < lowerBound) {
                System.out.println(errorMessage);
                continue;
            }
            if (upperBound != null && input > upperBound) {
                System.out.println(errorMessage);
                continue;
            }
            break;
        }
        return input;
    }

    public static void main(String[] args) {
        int n1 = promptInt(1,100,"Please enter a value between 1 and 100: ","Your entry is an invalid input. Enter a valid integer between 1 and 100." );
        System.out.println("The value chosen by the user is " + n1);

        int n2 = promptInt(0,null,"Please enter a non-negative value: ","Your entry is an invalid input. Enter a non-negative integer.");
        System.out.println("The value chosen by the user is " + n2);

        int n3 = promptInt(null,null,"Please enter any integer: ","Your entry is an invalid input. Enter an integer.");
        System.out.println("The value chosen by the user is " + n3);
    }
}

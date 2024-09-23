package com.csc;

import java.util.Scanner;
public class Menu {
    public static Integer promptInt(Integer lowerBound, Integer upperBound, String prompt, String errorMessage) {
        Scanner scan = new Scanner(System.in);
        Integer input = null;
        String userInput;
        int defaultValue = 100;

        while (true) {
            System.out.print(prompt);
            userInput = scan.nextLine();
            if (userInput.equalsIgnoreCase("default")) {
                return defaultValue;
            }
            if (userInput.equalsIgnoreCase("exit")) {
                return null;
            }
            try {
                input = Integer.parseInt(userInput);
            } catch (NumberFormatException exception) {
                System.out.println(errorMessage);
                continue;
            }
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
        Integer n1 = promptInt(1, 100,
                "Please enter a value between 1 and 100, \"default\", or \"exit\" to quit: ",
                "Your entry is an invalid input. Enter a valid integer between 1 and 100.");
        if (n1 == null) {
            System.out.println("Exited the program.");
            return;
        }
        System.out.println("The value chosen by the user is " + n1);

        Integer n2 = promptInt(0, null,
                "Please enter a non-negative value, \"default\", or \"exit\" to quit: ",
                "Your entry is an invalid input. Enter a non-negative integer.");
        if (n2 == null) {
            System.out.println("Exited the program.");
            return;
        }
        System.out.println("The value chosen by the user is " + n2);

        Integer n3 = promptInt(null, null,
                "Please enter any integer, \"default\", or \"exit\" to quit: ",
                "Your entry is an invalid input. Enter an integer.");
        if (n3 == null) {
            System.out.println("Exited the program.");
            return;
        }
        System.out.println("The value chosen by the user is " + n3);
    }
}

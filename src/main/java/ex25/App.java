/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Colin Mitchell
 */

package ex25;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        evaluatePassStrength(passwordValidator(password), password);
    }

    public static int passwordValidator(String password) {
        int strength = 0;

        int special_characters = 0;
        int digits = 0;
        int chars = 0;

        char[] charpassword = password.toCharArray();

        for (int i = 0; i < password.length(); i++)
        {
            if (Character.isDigit(charpassword[i]))
            {
                digits = 1;
            }
            if (Character.isLetter(charpassword[i]))
            {
                chars = 1;
            }
        }

        if (password.contains("~") || password.contains("!") || password.contains("@")
                || password.contains("#") || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&") || password.contains("*"))
        {
            special_characters = 1;
        }

        if(password.length() < 8 && digits == 1 && special_characters == 0 && chars == 0) {
            strength = 1;
        }

        if(password.length() < 8 && digits == 0 && special_characters == 0 && chars == 1) {
            strength = 2;
        }

        if(password.length() >= 8 && digits == 1 && special_characters == 0 && chars == 1) {
            strength = 3;
        }

        if(password.length() >= 8 && digits == 1 && special_characters == 1 && chars == 1) {
            strength = 4;
        }
        System.out.println(password);
        System.out.println(digits);
        System.out.println(chars);
        System.out.println(special_characters);

        return strength;
    }

    public static void evaluatePassStrength(int strength, String password) {
        String output = "The password \'" + password + "\' is a ";

        System.out.println("Strength is " +strength);
        switch(strength) {
            case 1:
                output += "very weak password.";
                break;
            case 2:
                output += "weak password.";
                break;
            case 3:
                output += "strong password.";
                break;
            case 4:
                output += "very strong password.";
                break;
            default:
                output = "The password \'" + password + "\' does not fit within the given rules.";
        }

        System.out.println(output);
    }
}
package com.clara;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by we4954cp on 8/31/2016.
 */
public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter the credit card number, digits only:");
        //Ask user for credit card number. store number as a String.
        String ccNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(ccNumber);

        if (isValid) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cc) {

//TODO Replace with your code to process the credit card number, and determine if it is valid.
//TODO Make sure all the tests pass!
        //Create a character array using the input
        // string length as the size of the array.
        char[] characters = new char[cc.length()];

        // Convert the string to characters.
        characters = cc.toCharArray();

        // Create an integer array.
        int[] W = new int[cc.length()];
        // Convert the characters to integers
        // and store them in array W.
        for (int x = 0; x < characters.length; x++) {
            int v = characters[x] - '0';
            W[x] = v;
        }

        int sum = 0;
        int total = 0;
        int product;

        //Double the value of alternate digits of the
        // primary account number beginning with the
        // second digit from the right (the first right--hand digit is the check digit.)
        for (int i = cc.length() - 2; i >= 0; i -= 2) {

            product = 2 * W[i];

            if (product >= 10) {

                sum = sum + product % 10 + product / 10;
            } else {
                sum += product;
            }
        }

        //Add the individual digits comprising the
        // products obtained to each of
        // the unaffected digits in the original number.
        for (int y = cc.length() - 1; y >= 0; y -= 2) {
            sum = sum + W[y];

        }
        //Check to see if the total obtained end with
        // a zero and is 16 digits and begins with 4.
        if (sum % 10 == 0 & cc.length() == 16 & W[0] == 4) {
            return true;
        } else {
            return false;
        }


    }

}







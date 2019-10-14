package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String secretCode = "123456";
        String userCode;
        double divideGuess;
        int geneNum;
        String userInput;
        String compNum;
        char charUserInput;
        char charCompNum;
        int guessNum;
        int iniNum,
            endNum,
            guessCount = 1;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Please enter the secret code: ");
            userCode = scan.next();
            if(!userCode.equals(secretCode)) {
                System.out.println("Incorrect code!");
            }
            else {
                System.out.println("Access granted!");
            }
        }while(!userCode.equals(secretCode));

        do {
            System.out.print("Enter an initial number: ");
            iniNum = scan.nextInt();
            System.out.print("Enter an ending number: ");
            endNum = scan.nextInt();

            if(iniNum >= endNum) {
                System.out.println("Ending number cant be greater than or equal initial number!");
                endNum = 0;
            }
        }while(endNum == 0);

        do {
            geneNum = (int)(Math.random() * endNum + 1);
        }while((geneNum < iniNum || geneNum > endNum));

        System.out.println(geneNum);

        guessNum = (iniNum + endNum) / 2;
        divideGuess = (double)(endNum - guessNum) / 2;

        do {
            System.out.print("Is the generated number " + guessNum +  "? ");
            userInput = scan.next();
            charUserInput = userInput.charAt(0);

            if(charUserInput == 'N') {
                System.out.print("Is the generated number greater than " + guessNum  + "? ");
                compNum = scan.next();
                charCompNum = compNum.charAt(0);

                if(charCompNum == 'Y') {
                    guessNum = guessNum + (int)divideGuess;
                }
                else {
                    guessNum = guessNum - (int)divideGuess;
                }

                if(divideGuess == 1) {
                    guessCount++;
                    //divideGuess++;
                    continue;
                }
                else if ((int)(divideGuess - 1) % 2 == 0) {
                    divideGuess = (divideGuess - 1) / 2;
                    if(divideGuess % 2 != 0) {
                        divideGuess++;
                    }
                }
                else {
                    divideGuess = Math.round(divideGuess / 2);
                }
            }
            guessCount++;
            System.out.println(guessCount);
        }while(charUserInput != 'Y');

        if(geneNum != guessNum) {
            System.out.println("You cheated!");
        }
        else {
            System.out.println("Your lucky number is found after " + guessCount + " guesses. Thank you for playing.");
        }
    }

}

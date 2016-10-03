package YoutubeDerekBanasJavaTutorials;

import java.util.Scanner;
//import java.util.*; for everything in this library

public class Lesson2 {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("Your favourite number: ");

        if(userInput.hasNextInt()){ //.hasNextDouble, .hasNextFloat,  .hasNextByte
            int numberEntered = userInput.nextInt(); //.nextDouble, .nextFloat, .nextBoolean, .nextLong
            System.out.println("You entered " + numberEntered);

            int numEnteredTimes2 = numberEntered + numberEntered;
            System.out.println(numberEntered + " + " + numberEntered + " = " + numEnteredTimes2);

            int numEnteredMinus2 = numberEntered - 2;
            System.out.println(numberEntered + " - 2 = " + numEnteredMinus2);

            int numEnteredTimesSelf = numberEntered * numberEntered;
            System.out.println(numberEntered + " * " + numberEntered + " = " + numEnteredTimesSelf);

            int numEnteredDivide2 = numberEntered / 2;
            System.out.println(numberEntered + " / 2 = " + numEnteredDivide2);

            int numEnteredRemainder= numberEntered % 2;
            System.out.println(numberEntered + " % 2 = " + numEnteredRemainder);

            //numberEntered = numberEntered + 2;
            numberEntered += 2;
            numberEntered -= 2;

            numberEntered--;
            numberEntered++;

            int numberABS = Math.abs(numberEntered);
            System.out.println(numberABS);

            int whichIsBigger = Math.max(5, 7); //7
            System.out.println(whichIsBigger);
            int whichIsSmaller = Math.min(5, 7); //5
            System.out.println(whichIsSmaller);

            double numSqrt = Math.sqrt(5.23);
            System.out.println(numSqrt);

            int numCeiling = (int) Math.ceil(5.23);
            System.out.println(numCeiling);

            int numFloor = (int) Math.floor(5.23);
            System.out.println(numFloor);

            int numRound = (int) Math.round(5.63);
            System.out.println(numRound);

            int randomNumber = (int) (Math.random() * 11); // random number between 0-10 always go + 1
            System.out.println(randomNumber);

        } else {
            System.out.println("Enter an integer next time.");
        }
    }
}

package YoutubeDerekBanasJavaTutorials;

public class Lesson3 {
    public static void main(String[] args){

        int randomNumber = (int) (Math.random() * 50);

        /*
            Relational Operators:
            Java has 6 relational operators
            >   : Greater Than
            <   : Less Than
            ==  : Equal to
            !=  : Not Equal To
            >=  : Greater than or equal to
            <=  : Less than or equal to

         */

        if(randomNumber < 25){
            System.out.println("The randum number is less than 25");
        } else if(randomNumber > 40){
            System.out.println("The random number is greater than 40");
        }else if(randomNumber == 18){
            System.out.println("The random number is equal to 18");
        }else if(randomNumber != 40){
            System.out.println("The random number is not equal to 40");
        }else{
            System.out.println("Nothing Worked");
        }

        System.out.println("The random number is " + randomNumber);


        /*
            Logical Operators:
            Java has 6 logical operators
            !   : Converts the boolean value to its right to its opposite
            &   : Returns true if boolean value on the right and left are booleans
            &&  : Returns true if boolean value on the right and left are true
            |   : Returns true if either boolean value on the right or left are true
            ||  : Returns true if either boolean value on the right of left are true
            ^   : Returns true if there is 1 true and 1 false boolean value
         */

        if(!(false)){
            System.out.println("\nI turned false into true");
        }

        if((true) && (true)){ //if either is false, does not execute
            System.out.println("Both are true");
        }
        if((false) & (true)){ //check both even though they wont execute
            System.out.println("Both the values are true");
        }
        if((false) | (true)){ //check both even though they wont execute
            System.out.println("One is true");
        }
        if((false) ^ (true)){ //check both even though they wont execute
            System.out.println("One is true, the other is false");
        }


        //-------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        int valueOne = 1;
        int valueTwo = 2;

        int biggestValue = (valueOne> valueTwo) ? valueOne : valueTwo;

        System.out.println(biggestValue);

        //-------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        char theGrade = 'b';

        switch(theGrade){
            case 'a':
            case 'A':
                System.out.println("Great Job");
                break;
            case 'b':
            case 'B':
                System.out.println("Good Job");
                break;
            case 'c':
            case 'C':
                System.out.println("Ok");
                break;
            case 'd':
            case 'D':
                System.out.println("Bad");
                break;
            default:
                System.out.println("You Failed");
                break;

        }
    }
}

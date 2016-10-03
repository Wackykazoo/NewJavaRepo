package YoutubeDerekBanasJavaTutorials;

// Types of exceptions
// java.lang.RunTimeException
// java.lang.Exceptions
// ArithmeticException
// ClassNotFoundException
// IllegalArgumentException
// IndexOutOfBoundsExceptions
// InputMismatchException
// IOException

//import java.util.*;
import java.io.*;

public class Lesson6 {

    //private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
        //divideByZero(2);

        /*System.out.println("How old are you?");
        int age = checkValidAge();

        if(age != 0){
            System.out.println("You are " + age + " years old16");
        }*/

        try{
            getAFile("./somestuff.txt");
        }catch(IOException e){
            System.out.println("An IO Error Occurred");
        }

    }

    private static void getAFile(String fileName) throws IOException{

        FileInputStream file = new FileInputStream(fileName);

        file.close();

        /*//checked expression (compiler says you gotta check this stuff!)
        try {
            FileInputStream file = new FileInputStream(fileName);
        } catch (FileNotFoundException e){
            System.out.println("Sorry can't find that file");
        } catch (IOException e){
            System.out.println("Unknown IO Error");
        }catch(IOException | ClassNotFoundException e) {
        }catch(Exception e){
            System.out.println("Some error occurred");
        }finally{
            System.out.println("");
        }*/
    }

    /*private static int checkValidAge(){
        try{
            return userInput.nextInt();
        }catch(InputMismatchException e){
            userInput.next();
            System.out.print("That isn't a while number");
            return 0;
        }
    }*/

    /*public static void divideByZero(int a){
        try{
            System.out.println(a/0);
        }catch (ArithmeticException e){
            System.out.println("You can't do that.");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }*/
}

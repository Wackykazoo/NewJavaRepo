package YoutubeDerekBanasJavaTutorials;

public class HelloWorld {

    static String randomString = "String to print";
    static final double PINUM = 3.141529;

    public static void main(String[] args){
        //---------------Basics------------------------------------------------------------------
        System.out.println();

        System.out.println("Hello World");
        System.out.println(randomString);
        System.out.println(PINUM);

        int integerOne = 22;
        int integerTwo = integerOne++;

        System.out.println(integerTwo);

        //---------------Primitive variable types------------------------------------------------
        System.out.println();

        byte bigByte = 127;                     //-128
        short bigShort = 32767;                 //-32768
        int bigInt = 2100000000;                //-2100000001
        long bigLong = 9220000000000000000L;    //-9220000000000000001L
        float bigFloat = 3.14F;
        double bigDouble = 3.14823794487273487237923748;

        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        boolean trueOrFalse = true;

        char randomChar = 65;
        char anotherChar = 'A';

        char escapedChars = '\r'; // \b \f \t \\ \/ \n \' \"

        //---------------String Objects and toString--------------------------------------------
        System.out.println();

        System.out.println(randomChar);

        String randomString = "I'm a random string";
        String anotherString = "Stuff";

        String andAnotherString = randomString + ' ' + anotherString;

        System.out.println(andAnotherString);

        String byteString = Byte.toString(bigByte);
        String shortString = Short.toString(bigShort);
        String intString = Integer.toString(bigInt);
        String longString = Long.toString(bigLong);
        String floatString = Float.toString(bigFloat);
        String doubleString = Double.toString(bigDouble);
        String booleanString = Boolean.toString(trueOrFalse);

        System.out.println(byteString);
        System.out.println(shortString);
        System.out.println(intString);
        System.out.println(longString);
        System.out.println(floatString);
        System.out.println(doubleString);
        System.out.println(booleanString);

        //---------------------Casting-------------------------------------------------------------
        System.out.println();

        double aDoubleValue = 300000000000000000000000000000000.1445956863535;
        int doubleToInt = (int) aDoubleValue;

        System.out.println(doubleToInt);

        int stringToInt = Integer.parseInt(intString);
        // parseShort, parseLong, parseByte, parseInt, parseDouble
        System.out.println(stringToInt);
    }
}

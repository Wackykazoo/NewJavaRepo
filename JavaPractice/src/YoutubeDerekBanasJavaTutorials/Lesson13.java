package YoutubeDerekBanasJavaTutorials;

import java.util.Arrays;

public class Lesson13 {
    public static void main(String[] args){
        String randomString = "I'm just a random string. ";
        String gotToQuote = "He said, \"I'm here\"";
        int numTwo = 2;

        System.out.println(randomString + " " + gotToQuote);
        System.out.println(randomString + " " + numTwo);

        System.out.println();
        System.out.println();

        String upperCaseString = "BIG";
        String lowerCaseString = "big";

        if(upperCaseString.equals(lowerCaseString)){
            System.out.println("They're equal");
        }

        if(upperCaseString.equalsIgnoreCase(lowerCaseString)){
            System.out.println("They're equal, ignoring case");
        }

        System.out.println();
        System.out.println();

        String letters = "abcde";
        String moreLetters = "fghijk";
        System.out.println("2nd char: " + letters.charAt(1));
        System.out.println(letters.compareTo(moreLetters)); //if equals 0 prints, or positive when earlier latter come
                                        // first, and negative when later letters come second. I mean in the alphabet
        System.out.println(letters.contains("abc"));
        System.out.println(letters.endsWith("de")); //.startWith too
        System.out.println(letters.indexOf("cd"));

        //You can also specify the index to start searching form
        //indexOf(StringToLookFor, IndexStartPosition)
        //lastIndexOf() works like indexOf except it starts from the
        //end of the String you are searching

        System.out.println("Length: " + letters.length());
        System.out.println(letters.replace("abc", "xy"));

        letters = "abcde";
        moreLetters = "fghijk";
        String[] letterArray = letters.split("");
        System.out.println(Arrays.toString(letterArray));

        char[] charArray = letters.toCharArray();
        System.out.println(Arrays.toString(charArray));

        System.out.println();
        System.out.println();
        letters = "abcde";
        moreLetters = "fghijk";
        System.out.println(letters.substring(1, 4));
        System.out.println(letters.toUpperCase());
        System.out.println(letters.toLowerCase());

        System.out.println();
        System.out.println();
        letters = "abcde";
        moreLetters = "fghijk";
        String randString = "                    ajgkslajkf                  ";
        System.out.println(randString.trim());

        System.out.println();
        System.out.println();
        System.out.println();
        StringBuilder randSB = new StringBuilder("A random value");
        System.out.println(randSB.append(" again"));
        System.out.println(randSB);
        System.out.println(randSB.delete(15, 21));
        System.out.println(randSB.capacity());
        randSB.ensureCapacity(60);
        System.out.println(randSB.capacity());
        System.out.println(randSB.length());
        randSB.trimToSize();
        System.out.println(randSB.capacity());
        System.out.println(randSB.insert(1, "nother"));
        String oldSB = randSB.toString();
        //  charAT()
        //  indexOf()
        //  lastIndexOf()
        //  subString()
    }
}

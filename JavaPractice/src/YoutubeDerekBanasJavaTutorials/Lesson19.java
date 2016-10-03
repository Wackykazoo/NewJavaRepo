package YoutubeDerekBanasJavaTutorials;

import java.util.regex.*;

public class Lesson19 {
    public static void main(String[] args){
        String longString = " Derek Banas CA AK 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
        String longString2 = longString;
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";

        //[A-Za-za-f0-9] - Any characters you want
        //[^A-G]
        //\\s whitespace
        //\\S no whitespace
        //{n,M} find anything from min to max
        //\\w{2,20}

        //Word that is 2 to 20 characters in length
        //[A-Za-z]{2, 20}

        regexChecker("\\s[A-Za-z]{2,20}\\s", longString);
        System.out.println("\n");

        //\\d digits and number
        //\\D not digits and number
        //{5} very specific number of times

        //Zip Code 5 digits long
        regexChecker("\\s\\d{5}\\s", longString);
        System.out.println("\n");

        //2 characters that start with a C or A
        //A[KLRZ]|C[AOT]
        regexChecker("A[KLRZ]|C[AOT]", longString);
        System.out.println("\n");

        //{5,} minimum with no maximum
        //+ whatever precedes must occur once or more times
        // . ^ * + ? {} [] \| () always needs to be backslashed
        //\\w [A-Za-z0-9]
        //\\W
        // *
        regexChecker("(\\{{1,})", strangeString);
        System.out.println("\n");
        regexChecker(".{3}", strangeString);
        System.out.println("\n");
        regexChecker("//w*", strangeString);
        System.out.println("\n");

        //emails
        //johnsmith@hotmail.com
        //[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\.[A-Za-z]{2,4}
        regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", longString);
        System.out.println("\n");

        //phone numbers
        //412-555-1234 412 555-1234 1-(412)555-1212
        regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-Z0-9]{7})", longString);
        System.out.println("\n");

        //replace with regular expressions
        regexReplace(longString2);
    }

    public static void regexChecker(String theRegex, String string2Check){
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(string2Check);

        while(regexMatcher.find()){
            if(regexMatcher.group().length() != 0){
                System.out.println(regexMatcher.group().trim());
            }
            System.out.println("Start index: " + regexMatcher.start());
            System.out.println("End index: " + regexMatcher.end());
        }
    }

    public static void regexReplace(String string2Replace){
        //Pattern.CASE_INSENSITIVE same as [A-Za-z]
        Pattern replace = Pattern.compile("\\s+");

        Matcher regexMatcher = replace.matcher(string2Replace.trim());
        System.out.println(regexMatcher.replaceAll(", "));
    }
}

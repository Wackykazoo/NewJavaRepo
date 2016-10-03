package YoutubeDerekBanasJavaTutorials;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class Lesson12 {
    public static void main(String[] args){
        LinkedList linkedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<>();

        names.add("Ahmed Bennani");
        names.add("Ali Syed");
        names.addLast("Nathan Martin");
        names.addFirst("Joshua Smith");
        names.add(0, "Noah Peeters");
        names.set(2, "Paul Newman");

        names.remove(4);
        names.remove("Joshua Smith");

        for(String name : names){
            System.out.println(name);
        }
        System.out.println();
        System.out.println();

        System.out.println("\nFirst Index: " + names.get(0));
        System.out.println("\nLast Index: " + names.getLast());

        LinkedList<String> nameCopy = new LinkedList<String>(names);
        System.out.println("\nnameCopy: " + nameCopy);

        if(names.contains("Noah Peeters")){
            System.out.println("\nNoahs Here");
        }

        if(names.containsAll(nameCopy)){
            System.out.println("\nCollections the same");
        }

        System.out.println("\n Ali index at: " + names.indexOf("Ali Syed"));
        System.out.println("\nList Empty: " + names.isEmpty());
        System.out.println("\nHow many: " + names.size());
        System.out.println("\nLook without error: " + names.peek());
        System.out.println("\nRemove first element: " + nameCopy.poll());
        System.out.println("\nRemove first element: " + nameCopy.pollLast());

        System.out.println();
        nameCopy.push("Noah Peeters");
        //nameCopy.pop();
        for(String name : nameCopy){
            System.out.println(name);
        }

        System.out.println();
        Objects[] nameArray = new Objects[4];
        //nameArray = names.toArray(); Doesn't work past java 7

        System.out.println(Arrays.toString(nameArray));
        names.clear();
    }
}

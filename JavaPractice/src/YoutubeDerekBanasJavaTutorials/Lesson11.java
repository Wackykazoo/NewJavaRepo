package YoutubeDerekBanasJavaTutorials;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class Lesson11 {
    public static void main(String[] args){
        ArrayList arrayListOne;
        arrayListOne = new ArrayList();
        ArrayList arrayListTwo = new ArrayList();

        ArrayList<String> names = new ArrayList<String>();

        names.add("John Smith");
        names.add("Mohamed Alami");
        names.add("Oliver Miller");

        names.add(2, "Jack Ryan");
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }

        System.out.println();
        names.set(0, "John Adams");
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }

        System.out.println();
        names.remove(3);
        for(int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
        }

        //names.removeRange(0, 1);

        System.out.println();
        System.out.println(names);

        System.out.println();
        for(String i : names){
            System.out.println(i);
        }

        System.out.println();
        Iterator indivItems = names.iterator();

        while(indivItems.hasNext()){
            System.out.println(indivItems.next());
        }

        System.out.println();
        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();
        nameCopy.addAll(names);

        System.out.println();
        String paulYoung = "Paul Young";
        names.add(paulYoung);
        if(names.contains(paulYoung)){
            System.out.println("Paul is here");
        }

        if(names.containsAll(nameCopy)){
            System.out.println("Everything in nameCopy is in names");
        }
        if(nameCopy.containsAll(names)){
            System.out.println("Everything in names is in nameCopy");
        }

        names.clear();

        if(names.isEmpty()){
            System.out.println("Arralist is Empty");
        }

        System.out.println();
        Object[] moreNames = new Object[4];
        moreNames = nameCopy.toArray();

        System.out.println(Arrays.toString(moreNames));
    }
}

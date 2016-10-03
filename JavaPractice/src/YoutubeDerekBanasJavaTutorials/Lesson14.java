package YoutubeDerekBanasJavaTutorials;

public class Lesson14 {
    public static void main(String[] args){
        Animal genericAnimal = new Animal();
        System.out.println(genericAnimal.getName());
        System.out.println(genericAnimal.getFavFood());

        Cat morris = new Cat("Morris", "Tuna", "Rubber Mouse");
        System.out.println();

        System.out.println(morris.getName());
        System.out.println(morris.favFood);
        System.out.println(morris.favToy);

        System.out.println();

        Animal tabby = new Cat("Tabby", "Salmon", "Ball");

        acceptAnimal(tabby);
    }

    public static void acceptAnimal(Animal randAnimal){
        System.out.println();
        System.out.println(randAnimal.getName());
        System.out.println(randAnimal.favFood);
        System.out.println();

        randAnimal.walkAround();

        //System.out.println(randAnimal.favToy);

        Cat tempCat = (Cat) randAnimal;
        System.out.println(tempCat.favToy);
        System.out.println();
        System.out.println(((Cat)randAnimal).favToy); //<====Super important, look at brakets
        System.out.println();

        if(randAnimal instanceof Cat){
            System.out.println(randAnimal.getName() + " is a Cat");
        }
        if(randAnimal instanceof Animal){
            System.out.println(randAnimal.getName() + " is an Animal");
        }
    }
}

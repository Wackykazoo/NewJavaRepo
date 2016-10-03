package YoutubeDerekBanasJavaTutorials;

public class Lesson15 {
    public static void main(String[] args){
        Vehicle car = new Vehicle(4, 100.00);

        System.out.println("Car max speed " + car.getSpeed());
        System.out.println("Number of wheels " + car.getWheels());

        car.setCarStrength(10);
        System.out.println("Car strength: " + car.getCarStrength());
    }
}

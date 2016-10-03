package YoutubeDerekBanasJavaTutorials;

public class GetTheMail implements Runnable{
    private int startTime;

    public GetTheMail(int startTime){
        this.startTime = startTime;
    }

    public void run(){
        try{
            Thread.sleep(startTime * 1000);
        }catch(InterruptedException r){}
        System.out.println("Checking Mail");
    }
}

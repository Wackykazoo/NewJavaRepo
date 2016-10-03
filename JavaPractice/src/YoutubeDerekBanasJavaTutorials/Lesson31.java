package YoutubeDerekBanasJavaTutorials;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Lesson31 extends JFrame{
    private static String filepath, parentDirectory;
    private static File randomDirectory, randomFile, randomFile2;
    public static void main(String[] args){
        randomDirectory = new File("C:\\Coding\\Working\\JavaPractice\\lib\\randomFiles");
        randomDirectory.mkdir();

        randomFile = new File("random.txt");
        randomFile2 = new File("C:\\Coding\\Working\\JavaPractice\\lib\\randomFiles/random2.txt");

        try{
            randomFile.createNewFile();
            randomFile2.createNewFile();
            filepath = randomFile.getCanonicalPath();
        }catch (IOException e){
            e.printStackTrace();
        }

        if(randomFile.exists()){
            System.out.println("File Exists");
            System.out.println("File Readable " + randomFile.canRead());
            System.out.println("File Writable " + randomFile.canWrite());
            System.out.println("File Location " + filepath);
            System.out.println("File Name " + randomFile.getName());
            System.out.println("Parent Directory " + randomFile.getParentFile());

            parentDirectory = randomFile2.getParent();
            System.out.println("File 2 Parent " + parentDirectory);
            System.out.println("Is it a directory " + randomDirectory.isDirectory());

            String[] filesInDirectory = randomDirectory.list();
            System.out.println("Files in Directory\n");
            for(String fileName: filesInDirectory){
                System.out.println(fileName + "\n");
            }

            System.out.println("Is a file " + randomFile.isFile());
            System.out.println("Is Hidden " + randomFile.isHidden());
            System.out.println("Last modified " + randomFile.lastModified());
            System.out.println("File Size " + randomFile.length());

            randomFile2.renameTo(new File("C:\\Coding\\Working\\JavaPractice\\lib\\randomFiles/random3.txt"));

            new Lesson31();
        }else{
            System.out.println("File doesn't exist");
        }

        if(randomFile.delete()){
            System.out.println("File deleted");
        }

        File[] filesInDirectory = randomDirectory.listFiles();
        for(File file: filesInDirectory){
            file.delete();
        }

        if(randomDirectory.delete()){
            System.out.println("Directory deleted");
        }
    }

    private Lesson31(){
        JFileChooser fileChooser = new JFileChooser(randomDirectory);
        fileChooser.showOpenDialog(this);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class Affirmations {
    private final int numberOfLines;
    private Vector<String> affirmationList;
    private Scanner scanner;

    Affirmations(){

        readFile();

        numberOfLines = affirmationList.size();

    }



    void readFile(){

        String path = "files/affirmations.txt";
        File file = new File(path);
        affirmationList = new Vector<>();
        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){

                affirmationList.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND!");
            e.printStackTrace();
        }
        scanner.close();
    }

    String getAffirmation(){
        Random rand = new Random();

        int temp = rand.nextInt(numberOfLines - 1);
        return affirmationList.get(temp);

    }




}

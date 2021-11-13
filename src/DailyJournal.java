import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DailyJournal {
    private String path;
    private File file;
    private int counter = 1;
    private FileWriter fileWriter;

    DailyJournal(String date){

        path = "./files/journalEntries/" + date;
        file = new File(path + ".txt");
        if(file.exists()){
            path += "." + counter++;
            file = new File(path + ".txt");
        }
        try {
            System.out.println(path);

            System.out.println(file.getAbsolutePath());
            file.createNewFile();
        }catch (IOException e){
            System.out.println("FILE NOT CREATED IN JOURNAL ENTRY!");
            e.printStackTrace();
        }


    }

    void addEntry(String Entry){


        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(Entry);
            fileWriter.close();
        }catch (IOException e){
            System.out.println("FILE NOT WRITTEN TO IN JOURNAL ENTRY!");
            e.printStackTrace();
        }

    }

}

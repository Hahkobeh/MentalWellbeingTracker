import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MentalWellbeingTacker {
    private static String date;


    public static void main(String[] args){

        getDate();
        GUI gui = new GUI(date);
        /*DailyJournal dj = new DailyJournal(date);
        dj.addEntry("journal entry 1!");
        dj.addEntry("HELLO THGIS IS MY JOURNAL ENTRY#2!");*/
        //final test

    }

    static void getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        date = sdf.format(cal.getTime());
        System.out.println(date);

    }
}

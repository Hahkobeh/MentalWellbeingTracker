import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MentalWellbeingTracker {
    private static String date;
    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;
    MoodTracker moodTracker;


    public static void main(String[] args){

        getDate();
        GUI gui = new GUI(date);
        /*Affirmations aff = new Affirmations();
        System.out.println(aff.getAffirmation());
        DailyJournal dj = new DailyJournal(date);
        dj.addEntry("journal entry 1!");
        dj.addEntry("HELLO THGIS IS MY JOURNAL ENTRY#2!");
        MoodTracker md = new MoodTracker();
        md.addMood(1,"14-11-2021");
        md.grabAllMoods();*/

    }

    static void getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        date = sdf.format(cal.getTime());
        System.out.println("Today's date is: "+date);

    }
}

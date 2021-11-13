import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MentalWellbeingTacker {
    private static String date;


    public static void main(String[] args){

        getDate();
        //GUI gui = new GUI(date);
        Affirmations aff = new Affirmations();
        System.out.println(aff.getAffirmation());
        //final test

    }

    static void getDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        date = sdf.format(cal.getTime());
        System.out.println(date);

    }
}

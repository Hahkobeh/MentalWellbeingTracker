import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//did this branch correctly

public class GUI {
    private JFrame frame;
    private String date;
    Affirmations affirmations;
    DailyJournal dailyJournal;

    GUI(String date){
        this.date = date;
        initializeGUI();
        initializeAffirmations();
        initializeDailyJournal();

    }
    void initializeGUI(){

        this.frame = new JFrame("Mental Wellness Tracker");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        frame.setLocationRelativeTo(null); // Makes window open in middle of screen

        JPanel panel = new JPanel();

        frame.add(panel);

        placeComponents(panel); // Place components on the window

        frame.setVisible(true);

    }
    void initializeAffirmations(){
        affirmations = new Affirmations();
    }

    void initializeDailyJournal(){
        dailyJournal = new DailyJournal(date);
    }

    private static void placeComponents(JPanel panel) {

        //
    }

    String getAffirmation(){
        return affirmations.getAffirmation();
    }

}



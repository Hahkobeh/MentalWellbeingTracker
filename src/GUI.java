import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private String date;
    Affirmations affirmations;

    GUI(String date){
        this.date = date;
        initializeGUI();
        initializeAffirmations();

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

    private static void placeComponents(JPanel panel) {

        //
    }

}



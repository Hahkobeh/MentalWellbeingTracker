import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private String date;

    private JButton get_affirmation; 
    
    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;

    GUI(String date){
        this.date = date;
        get_affirmation = new JButton("Daily Affirmation!");
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
        frame.add(get_affirmation);

        placeComponents(panel); // Place components on the window

        get_affirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    affirmations_txt = affirmations.getAffirmation();
                    JOptionPane.showMessageDialog(null, affirmations_txt);
                }catch(Exception err){
                    System.out.println("affirmation event listener error");
                }
            }
        });

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



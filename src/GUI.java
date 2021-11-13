import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private String date;

    private JButton get_affirmation; 
    private JButton journal_entry;
    private JButton get_past_data;
    
    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;

    GUI(String date){
        this.date = date;
        get_affirmation = new JButton("Cheer me up!");
        journal_entry = new JButton("Add journal entry");
        get_past_data = new JButton("Read journal entry");
        initializeGUI();
        initializeAffirmations();
        initializeDailyJournal();
        frame.setVisible(true);

    }
    void initializeGUI(){

        this.frame = new JFrame("Mental Wellness Tracker");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        frame.setLocationRelativeTo(null); // Makes window open in middle of screen

        JPanel panel = new JPanel();
        GridLayout gridLayout = new GridLayout(5,1, 10, 5);
        panel.setLayout(gridLayout);

        frame.add(panel);
        JLabel header = new JLabel("Today is " + date , JLabel.CENTER);

        frame.add(header);
        JLabel rating = new JLabel("How was your day?" , JLabel.CENTER);

        frame.add(rating);


        frame.add(journal_entry);
        frame.add(get_affirmation);
        frame.add(get_past_data);
        

        placeComponents(panel); // Place components on the window

        get_affirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    affirmations_txt = affirmations.getAffirmation();
                    JLabel affirm = new JLabel(affirmations_txt, JLabel.CENTER);
                    frame.add(affirm);
                }catch(Exception err){
                    System.out.println("affirmation event listener error");
                }
            }
        });

        journal_entry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    JTextField journalText = new JTextField(200);


                    frame.add(journalText);
                    
                    
                }catch(Exception err){
                    System.out.println("journal_entry event listener error");
                }
            }
        });

        get_past_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    
                }catch(Exception err){
                    System.out.println("get_past_data event listener error");
                }
            }
        });



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



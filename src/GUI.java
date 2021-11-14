import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private String date;

    private JButton getAffirmation;
    private JButton journalEntry;
    private JButton getPastData;
    
    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;

    GUI(String date){
        this.date = date;
        Icon affirmationIcon = new ImageIcon("images/affirmationButtonOther 1.png");
        //getAffirmation = new JButton(affirmationIcon);
        journalEntry = new JButton("Add journal entry");
        //getPastData = new JButton("Read journal entry");
        
        initializeGUI();
        initializeAffirmations();
        initializeDailyJournal();
        frame.setVisible(true);

    }
    void initializeGUI(){

        this.frame = new JFrame("Mental Wellness Tracker");
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        frame.setLocationRelativeTo(null); // Makes window open in middle of screen

        JPanel panel = new JPanel();



        frame.add(panel);
        JLabel header = new JLabel("Today is " + date , JLabel.CENTER);
        header.setForeground(Color.BLUE);
        header.setBounds(125, 20, 340, 40);
        header.setFont(new Font("Courier", Font.PLAIN, 30));
        panel.add(header);

        JLabel rating = new JLabel("How was your day?" , JLabel.CENTER);
        rating.setBounds(150, 70, 340, 20);


        frame.add(rating);

/*
        journalEntry.setBounds(150, 120, 340, 10 );
        getAffirmation.setBounds(150, 140, 340, 10 );
        //getPastData.setBounds(150, 150, 340, 10 );
        frame.add(journalEntry);
        frame.add(getAffirmation);
        //frame.add(getPastData);
        

        placeComponents(panel); // Place components on the window

        getAffirmation.addActionListener(new ActionListener() {
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

        journalEntry.addActionListener(new ActionListener() {
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

        getPastData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    
                }catch(Exception err){
                    System.out.println("get_past_data event listener error");
                }
            }
        });*/



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



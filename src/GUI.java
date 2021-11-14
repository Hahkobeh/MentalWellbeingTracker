
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private String date;
    private boolean chooseMood = false;

    private JButton getAffirmation;
    private JButton journalEntry;
    private JButton getPastData;

    private JButton madButton;
    private JButton happyButton;
    private JButton sadButton;
    private JButton okayButton;
    private JButton notTheBestButton;

    // Icons
    private Icon affirmationIcon = new ImageIcon("../images/affirmationButtonOther 1.png");

    private ImageIcon happy = new ImageIcon("./images/happy.png");
    private ImageIcon mad = new ImageIcon("./images/mad.png");
    private ImageIcon okay = new ImageIcon("./images/okay.png");
    private ImageIcon notTheBest = new ImageIcon("./images/notTheBest.png");
    private ImageIcon sad = new ImageIcon("./images/sad.png");
    private ImageIcon affirm = new ImageIcon("./images/affirmationButtonOther 1.png");
    private ImageIcon journal = new ImageIcon("./images/journalBut.png");

    Image happyImg = happy.getImage(); // transform it
    Image happyTrans = happyImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newHappyIcon = new ImageIcon(happyTrans); // assign to a new ImageIcon instance

    Image madImg = mad.getImage(); // transform it
    Image madTrans = madImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newMadIcon = new ImageIcon(madTrans); // assign to a new ImageIcon instance

    Image okayImg = okay.getImage(); // transform it
    Image okayTrans = okayImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newOkayIcon = new ImageIcon(okayTrans); // assign to a new ImageIcon instance

    Image notTheBestImg = notTheBest.getImage(); // transform it
    Image notTheBestTrans = notTheBestImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newNotTheBestIcon = new ImageIcon(notTheBestTrans); // assign to a new ImageIcon instance

    Image sadImg = sad.getImage(); // transform it
    Image sadTrans = sadImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newSadIcon = new ImageIcon(sadTrans); // assign to a new ImageIcon instance
    
    Image journalImg = journal.getImage(); // transform it
    Image journalTrans = journalImg.getScaledInstance(350, 50, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newJournalIcon = new ImageIcon(journalTrans); // assign to a new ImageIcon instance


    Image affirmImg = affirm.getImage(); // transform it
    Image affirmTrans = affirmImg.getScaledInstance(350, 50, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newAffirmIcon = new ImageIcon(affirmTrans); // assign to a new ImageIcon instance

    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;
    MoodTracker moodTracker;

    GUI(String date) {
        this.date = date;
        initializeClasses();

        madButton = new JButton(newMadIcon);
        happyButton = new JButton(newHappyIcon);
        sadButton = new JButton(newSadIcon);
        okayButton = new JButton(newOkayIcon);
        notTheBestButton = new JButton(newNotTheBestIcon);

        getAffirmation = new JButton(affirmationIcon);
        journalEntry = new JButton("Add journal entry");
        getPastData = new JButton("Read journal entry");

        initializeGUI();
        frame.setVisible(true);

    }

    void initializeGUI() {

        this.frame = new JFrame("Mental Wellness Tracker");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        frame.setLocationRelativeTo(null); // Makes window open in middle of screen

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel header = new JLabel("Today is " + date, JLabel.CENTER);
        header.setForeground(Color.BLUE);
        header.setBounds(125, 20, 350, 40);
        header.setFont(new Font("Courier", Font.PLAIN, 30));
        panel.add(header);

        JLabel rating = new JLabel("How was your day?", JLabel.CENTER);
        rating.setBounds(125, 60, 350, 40);
        rating.setFont(new Font("Courier", Font.PLAIN, 15));
        panel.add(rating);

        // Mad Button
        madButton.setBounds(30, 90, 100, 100);
        madButton.setBorderPainted(false);
        madButton.setContentAreaFilled(false);
        madButton.setOpaque(false);
        panel.add(madButton);
        JLabel mad = new JLabel("MAD", JLabel.CENTER);
        mad.setBounds(30, 150, 100, 100);
        mad.setFont(new Font("Courier", Font.PLAIN, 12));
        panel.add(mad);

        // Sad Button
        sadButton.setBounds(140, 90, 100, 100);
        sadButton.setBorderPainted(false);
        sadButton.setContentAreaFilled(false);
        sadButton.setOpaque(false);
        panel.add(sadButton);
        JLabel sad = new JLabel("SAD", JLabel.CENTER);
        sad.setBounds(140, 150, 100, 100);
        sad.setFont(new Font("Courier", Font.PLAIN, 12));
        panel.add(sad);

        // Not the best Button
        notTheBestButton.setBounds(250, 90, 100, 100);
        notTheBestButton.setBorderPainted(false);
        notTheBestButton.setContentAreaFilled(false);
        notTheBestButton.setOpaque(false);
        panel.add(notTheBestButton);
        JLabel notTheBest = new JLabel("NOT THE BEST", JLabel.CENTER);
        notTheBest.setBounds(250, 150, 100, 100);
        notTheBest.setFont(new Font("Courier", Font.PLAIN, 12));
        panel.add(notTheBest);

        // Okay Button
        okayButton.setBounds(360, 90, 100, 100);
        okayButton.setBorderPainted(false);
        okayButton.setContentAreaFilled(false);
        okayButton.setOpaque(false);
        panel.add(okayButton);
        JLabel okay = new JLabel("OKAY", JLabel.CENTER);
        okay.setBounds(360, 150, 100, 100);
        okay.setFont(new Font("Courier", Font.PLAIN, 12));
        panel.add(okay);

        // Happy Button
        happyButton.setBounds(470, 90, 100, 100);
        happyButton.setBorderPainted(false);
        happyButton.setContentAreaFilled(false);
        happyButton.setOpaque(false);
        panel.add(happyButton);
        JLabel happy = new JLabel("HAPPY", JLabel.CENTER);
        happy.setBounds(470, 150, 100, 100);
        happy.setFont(new Font("Courier", Font.PLAIN, 12));
        panel.add(happy);
        
         journalEntry.setBorderPainted(false);
        journalEntry.setContentAreaFilled(false);
        journalEntry.setOpaque(false);
        journalEntry.setBounds(125, 270, 350, 30);
        panel.add(journalEntry);


        getAffirmation.setBorderPainted(false);
        getAffirmation.setContentAreaFilled(false);
        getAffirmation.setOpaque(false);
        getAffirmation.setBounds(125, 320, 350, 50);
        panel.add(getAffirmation);

        frame.add(panel);

        happyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chooseMood) {
                    action(5);
                    header.setText("You picked Happy!");
                }
            }
        });

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chooseMood) {
                    action(4);
                    header.setText("You picked okay.");
                }

            }
        });
        notTheBestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chooseMood) {
                    action(3);
                    header.setText("You picked not the best.");
                }
            }
        });
        sadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!chooseMood) {
                    action(2);
                    header.setText("You picked sad :(");
                }
            }
        });
        madButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chooseMood) {
                    action(1);
                    header.setText("You picked Happy!");
                }
            }
        });
        /*
         * journalEntry.setBounds(150, 120, 340, 10 ); getAffirmation.setBounds(150,
         * 140, 340, 10 ); //getPastData.setBounds(150, 150, 340, 10 );
         * frame.add(journalEntry); frame.add(getAffirmation); //frame.add(getPastData);
         * 
         * 
         * placeComponents(panel); // Place components on the window
         * 
         * getAffirmation.addActionListener(new ActionListener() {
         * 
         * @Override public void actionPerformed(ActionEvent e){ try{ affirmations_txt =
         * affirmations.getAffirmation(); JLabel affirm = new JLabel(affirmations_txt,
         * JLabel.CENTER); frame.add(affirm); }catch(Exception err){
         * System.out.println("affirmation event listener error"); } } });
         * 
         * journalEntry.addActionListener(new ActionListener() {
         * 
         * @Override public void actionPerformed(ActionEvent e){ try{ JTextField
         * journalText = new JTextField(200);
         * 
         * 
         * frame.add(journalText);
         * 
         * 
         * }catch(Exception err){
         * System.out.println("journal_entry event listener error"); } } });
         * 
         * getPastData.addActionListener(new ActionListener() {
         * 
         * @Override public void actionPerformed(ActionEvent e){ try{
         * 
         * }catch(Exception err){
         * System.out.println("get_past_data event listener error"); } } });
         */

    }
    void action(int moodValue){
        moodTracker.addMood(moodValue,date);
        chooseMood = true;

    }


    void initializeClasses() {
        affirmations = new Affirmations();
        dailyJournal = new DailyJournal(date);
        moodTracker = new MoodTracker();
    }

    private static void placeComponents(JPanel panel) {

        //
    }

    String getAffirmation() {
        return affirmations.getAffirmation();
    }


}


import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.tools.StandardJavaFileManager.PathFactory;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class GUI extends JFrame{
    // private JFrame frame;
    private String date;

    private Container con;
    private JLabel background;
    private JPanel buttons;

    private JButton getAffirmation;
    private JButton journalEntry;
    private JButton getPastData;

    private JButton backButton;
    private JButton madButton;
    private JButton happyButton;
    private JButton sadButton;
    private JButton okayButton;
    private JButton notTheBestButton;

    // Icons
    private Icon affirmationIcon = new ImageIcon("./images/affirmationButtonOther 1.png");
    private ImageIcon backgroundImg = new ImageIcon("./images/background.png");

    private ImageIcon happy = new ImageIcon("./images/happy.png");
    private ImageIcon mad = new ImageIcon("./images/mad.png");
    private ImageIcon okay = new ImageIcon("./images/okay.png");
    private ImageIcon notTheBest = new ImageIcon("./images/notTheBest.png");
    private ImageIcon sad = new ImageIcon("./images/sad.png");

    String affirmations_txt;
    Affirmations affirmations;
    DailyJournal dailyJournal;

    GUI(String date) {
        this.date = date;
        // backButton = new JButton(newbackIcon);

        madButton = new JButton(transformImage(mad, 100, 100));
        sadButton = new JButton(transformImage(sad, 100, 100));
        notTheBestButton = new JButton(transformImage(notTheBest, 100, 100));
        okayButton = new JButton(transformImage(okay, 100, 100));
        happyButton = new JButton(transformImage(happy, 100, 100));

        // getAffirmation = new JButton(affirmationIcon);
        // journalEntry = new JButton("Add journal entry");
        // getPastData = new JButton("Read journal entry");

        initializeMenuGUI();
        // initializeAffirmations();
        // initializeDailyJournal();
        setVisible(true);

    }

    void initializeMenuGUI() {
        buttons = new JPanel();
        buttons.setOpaque(false);

        con = getContentPane();

        setTitle("Mental Wellness Tracker");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
        setLocationRelativeTo(null); // Makes window open in middle of screen

        JLabel header = new JLabel("Today is " + date, JLabel.CENTER);
        header.setForeground(Color.black);
        header.setBounds(125, 120, 350, 40);
        header.setFont(new Font("Courier", Font.PLAIN, 12));
        con.add(header);

        setBackground();
        setFaceButtons();
        // setMenuButtons();
    }
    
    void setBackground(){
        background = new JLabel (transformImage(backgroundImg, 600, 600));
        con.add(background);
        background.setLayout(new FlowLayout());
        // background.add(buttons);
    }


    ImageIcon transformImage(ImageIcon image, int w, int h){
        Image imageNew = image.getImage(); // transform it
        Image imageTrans = imageNew.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
        ImageIcon newImageIcon = new ImageIcon(imageTrans); // assign to a new ImageIcon instance

        return newImageIcon;
    }

    void setButton(JButton but, int x, int y, int w, int h){
        but.setBounds(x, y, w, h);
        but.setBorderPainted(false);
        but.setContentAreaFilled(false);
        but.setOpaque(false);

        buttons.add(but);
        background.add(buttons);
    }

    void setFaceButtons(){
        setButton(madButton, 30, 200, 100, 100);
        setButton(sadButton, 140, 200, 100, 100);
        setButton(notTheBestButton, 150, 200, 100, 100);
        setButton(okayButton, 360, 200, 100, 100);
        setButton(happyButton, 470, 200, 100, 100);
    }

    void addLabel(String words, String font, int size, int x, int y, int w, int h){
        // JLabel mad = new JLabel("MAD", JLabel.CENTER);
        // mad.setBounds(30, 150, 100, 100);
        // mad.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(mad);
    }

        // JPanel panel = new JPanel();

        // JLabel header = new JLabel("Today is " + date, JLabel.CENTER);
        // header.setForeground(Color.BLUE);
        // header.setBounds(125, 20, 350, 40);
        // header.setFont(new Font("Courier", Font.PLAIN, 30));
        // panel.add(header);

        // JLabel rating = new JLabel("How was your day?", JLabel.CENTER);
        // rating.setBounds(125, 60, 350, 40);
        // rating.setFont(new Font("Courier", Font.PLAIN, 15));
        // panel.add(rating);

        // Mad Button
        // madButton.setBounds(30, 90, 100, 100);
        // madButton.setBorderPainted(false);
        // madButton.setContentAreaFilled(false);
        // madButton.setOpaque(false);
        // panel.add(madButton);
        // JLabel mad = new JLabel("MAD", JLabel.CENTER);
        // mad.setBounds(30, 150, 100, 100);
        // mad.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(mad);

        // Sad Button
        // sadButton.setBounds(140, 90, 100, 100);
        // sadButton.setBorderPainted(false);
        // sadButton.setContentAreaFilled(false);
        // sadButton.setOpaque(false);
        // panel.add(sadButton);

        // JLabel sad = new JLabel("SAD", JLabel.CENTER);
        // sad.setBounds(140, 150, 100, 100);
        // sad.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(sad);

        // // Not the best Button
        // notTheBestButton.setBounds(250, 90, 100, 100);
        // notTheBestButton.setBorderPainted(false);
        // notTheBestButton.setContentAreaFilled(false);
        // notTheBestButton.setOpaque(false);
        // panel.add(notTheBestButton);
        // JLabel notTheBest = new JLabel("NOT THE BEST", JLabel.CENTER);
        // notTheBest.setBounds(250, 150, 100, 100);
        // notTheBest.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(notTheBest);

        // // Okay Button
        // okayButton.setBounds(360, 90, 100, 100);
        // okayButton.setBorderPainted(false);
        // okayButton.setContentAreaFilled(false);
        // okayButton.setOpaque(false);
        // panel.add(okayButton);
        // JLabel okay = new JLabel("OKAY", JLabel.CENTER);
        // okay.setBounds(360, 150, 100, 100);
        // okay.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(okay);

        // // Happy Button
        // happyButton.setBounds(470, 90, 100, 100);
        // happyButton.setBorderPainted(false);
        // happyButton.setContentAreaFilled(false);
        // happyButton.setOpaque(false);
        // panel.add(happyButton);
        // JLabel happy = new JLabel("HAPPY", JLabel.CENTER);
        // happy.setBounds(470, 150, 100, 100);
        // happy.setFont(new Font("Courier", Font.PLAIN, 12));
        // panel.add(happy);

        // frame.add(panel);

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


    void initializeAffirmations() {
        affirmations = new Affirmations();
    }

    void initializeDailyJournal() {
        dailyJournal = new DailyJournal(date);
    }

    private static void placeComponents(JPanel panel) {

        //
    }

    String getAffirmation() {
        return affirmations.getAffirmation();
    }
}

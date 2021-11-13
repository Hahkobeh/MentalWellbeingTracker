import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.util.*;


public class MoodTracker {
    private private Connection connectDB;
    private static String userDB="User1";
    private static String passDB="password";

    public MoodTracker(){
        getDatabase();
    }
    public void addMood(int mood, String date){
        String query = "INSERT INTO MOODS (timeDate,Mood) VALUES ('"+ date +"',"+ mood +");";
        try{
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    List<List<String>> grabAllMoodss(){
        int numberOfEntries = 0;
        String query1 = "SELECT COUNT(*) FROM MOODS";

        //TODO - can probably remove

        try{
            Statement statement = connectDB.createStatement();

            ResultSet result = statement.executeQuery(query1);
            result.next();
            numberOfEntries = result.getInt("COUNT(*)");
            result.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        String query2 = "SELECT timeDate, moods FROM MOODS;";

        List<List<String>> data = new ArrayList<List<String>>();

        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query2);
            while(resultSet.next()){
                List<String> tempArray = new ArrayList<String>();
                tempArray.add(resultSet.getString("timeDate"));
                tempArray.add(String.valueOf(resultSet.getFloat("moods")));

                data.add(tempArray);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public void getDatabase() {
        try{
            connectDB = DriverManager.getConnection("jdbc:mysql://localhost/MoodsDB", userDB, passDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.*;
import java.util.*;

class DataPoint {
    public int id;
    public String date;
    public int moodRating;
}


@SuppressWarnings("SqlResolve")
public class MoodTracker {
    private Connection connectDB;
    private static String username="User1";
    private static String password="password";

    public MoodTracker(){
        getDatabase();
    }

    public void addMood(int mood, String date){

        String query = "INSERT INTO MOODS (timeDate,Moodrating) VALUES ('"+date+"',"+mood+");";
        try{
            PreparedStatement statement = connectDB.prepareStatement(query);
            statement.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    Vector<DataPoint> grabAllMoods(){
        /*int numberOfEntries = 0;
        String query1 = "SELECT COUNT(*) FROM MOODS";


        try{
            Statement statement = connectDB.createStatement();

            ResultSet result = statement.executeQuery(query1);
            result.next();
            numberOfEntries = result.getInt("COUNT(*)");
            result.close();

        }catch(SQLException e){
            e.printStackTrace();
        }*/

        String query2 = "SELECT EntryID, TimeDate, MoodRating FROM Moods;";

        Vector<DataPoint> data = new Vector<>();
        //List<List<String>> data = new ArrayList<List<String>>();

        try{
            Statement statement = connectDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query2);
            while(resultSet.next()){
                DataPoint temp = new DataPoint();
                temp.id = 1;
                temp.id = resultSet.getInt("EntryID");
                temp.date = resultSet.getString("TimeDate");
                temp.moodRating = resultSet.getInt("MoodRating");

                data.add(temp);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        //data.forEach((n) -> System.out.println(n.date));

        return data;
    }

    public void getDatabase() {
        try{
            connectDB = DriverManager.getConnection("jdbc:mysql://localhost/mwt", username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

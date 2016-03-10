package TriviaDB;
    
import TriviaGame.Question;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    
    public static final String DbUrl = "jdbc:derby://localhost:1527/BooksDB";
    public static final String DbDriverClass = "org.apache.derby.jdbc.ClientDriver";
    public static final String DbUser = "root";
    public static final String DbPassword = "root";
    
    
    public static ArrayList<Question> getAllQuestions()
    {
        ArrayList<Question> allQuestions = new ArrayList<Question>();
        
        try {
            Class.forName(DBUtils.DbDriverClass);
       
          
            Connection connection = DriverManager.getConnection(
                   DBUtils.DbUrl , 
                   DBUtils.DbUser , 
                   DBUtils.DbPassword);
            
            Statement st = connection.createStatement();
            ResultSet results = st.executeQuery("Select * from root.triviadbtest");
            
            
            while (results.next()) {
                 
                String question = results.getString("question");
                String[] answers = new String[4];
                answers[0] = results.getString("answer1");
                answers[1] = results.getString("answer2");
                answers[2] = results.getString("answer3");
                answers[3] = results.getString("answer4");
                int rightAns = results.getInt("CORRECT_ANSWER");
                int points = results.getInt("points");
                Question q = new Question(question, answers, points, rightAns);
                allQuestions.add(q);
                System.out.println(question);
                System.out.println(rightAns);
                System.out.println(points);
            }
            results.close();
         } catch (Exception ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allQuestions;
    }
}


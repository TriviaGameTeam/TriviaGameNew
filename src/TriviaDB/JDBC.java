package TriviaDB;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    public static void main(String[] args) {

        try {
            //load the Driver class to memory
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter ID of question, the question, 4 answers, the index of the correct answer, and the num of points for this answer:");
            //הזנת שאלות ותשובות למאגר
            String ID = input.nextLine();
            String question = input.nextLine();
            boolean was = false;
            String answer1 = input.nextLine();
            String answer2 = input.nextLine();
            String answer3 = input.nextLine();
            String answer4 = input.nextLine();
            String currectAnswer = input.nextLine();
            int points = input.nextInt();

            Connection connection = DriverManager.getConnection(
                    DBUtils.DbUrl,
                    DBUtils.DbUser,
                    DBUtils.DbPassword);

            //הזנת שאלות לטבלה
            PreparedStatement pstatement = connection.prepareStatement("insert into root.triviadbtest values (?,?,?,?,?,?,?,?,?)");

            pstatement.setString(1, ID);
            pstatement.setString(2, question);
            pstatement.setBoolean(3, was);
            pstatement.setString(4, answer1);
            pstatement.setString(5, answer2);
            pstatement.setString(6, answer3);
            pstatement.setString(7, answer4);
            pstatement.setString(8, currectAnswer);
            pstatement.setInt(9, points);

            int result = pstatement.executeUpdate();

            if (result > 0) {
                System.out.println("Value insertsd succssfuly");
            } else {
                System.out.println("Problem in insert");
            }

            connection.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver class not found! have you added it to project?");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}


package TriviaGame;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriviaJDBC {
    
    public static void main(String[] args) {
        
         try {
            //load the Driver class to memory
            Class.forName("org.apache.derby.jdbc.ClientDriver");
//            Scanner input = new Scanner (System.in);
//            String username = input.nextLine();
//            String email = input.nextLine();
//            java.util.Date d = new java.util.Date();
            
            Connection connection = DriverManager.getConnection(
                   DBUtils.DbUrl , 
                   DBUtils.DbUser , 
                   DBUtils.DbPassword);
            
            PreparedStatement pstatement = connection.prepareStatement("insert into root.Triviadbtest values (?,?,?)");
            pstatement.setInt(1,1);
            pstatement.setString(2, "What are the three primary colors?");
            pstatement.setBoolean(3, false);
            
            pstatement.setInt(1,2);
            pstatement.setString(2, "How many grams there are in 1 kilogram?");
            pstatement.setBoolean(3, false);
           
            int result = pstatement.executeUpdate();
            if (result>0)
                System.out.println("Value insertsd succssfuly");
            else 
                System.out.println("Problem in insert");
            
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver class not found! have you added it to project?");        
        } catch (SQLException ex) {
            Logger.getLogger(TriviaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

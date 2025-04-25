package ReaneyModule9ProgrammingAssignment;

import java.sql.*;

/*
*   @author: Christopher Reaney
*   This class was derived from one created by our professor, and was updated
*       with the db username/password required by the instructions on this assignment.
*       This class is used to select everything from the address33 table
*/
public class Select5{

    public static void main(String args[]){

        try{
            Connection con;

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb?";
            con = DriverManager.getConnection(url + "user=student1&password=pass");

            System.out.println("Connection established - now executing a select");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM address33");

           System.out.println("Received Results:");

           int i = rs.getMetaData().getColumnCount();

           while(rs.next()){

            for(int x = 1; x <= i; ++x){

                System.out.println(rs.getString(x));
            }
            System.out.println("");
        }

            stmt.close();
            con.close();
        }
        catch (java.lang.Exception ex){

            ex.printStackTrace();
        }
    }
}
package YoutubeDerekBanasJavaTutorials;

import java.sql.*;

public class Lesson34 {
    public static void main(String[] args){

        Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/customer","root", "F10e222b.899253");

            Statement sqlStatement = connection.createStatement();
            String selectStuff = "Select first_name from customer";
            ResultSet rows = sqlStatement.executeQuery(selectStuff);

            while(rows.next()){
                System.out.println(rows.getString("first_name"));
            }
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

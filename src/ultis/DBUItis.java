package ultis;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUItis implements Serializable{
    public static Connection openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url= "jdbc:sqlserver://localhost:1433; databaseName=BookManagement";
            Connection con= DriverManager.getConnection(url,"sa","123");
//            System.out.println("Connect Successful!!");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        openConnection();
//    }
}
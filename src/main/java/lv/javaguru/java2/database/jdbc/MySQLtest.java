package lv.javaguru.java2.database.jdbc;

//STEP 1. Import required packages
import lv.javaguru.java2.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLtest {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/etaxi";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "toor";

    public static void main(String[] args) {
        System.out.print(getCustomersListToString());
    }

    public static StringBuilder getCustomersListToString() {
            StringBuilder customersAllString = new StringBuilder();
        List<User> userList = new ArrayList<User>();
        userList = getCustomersListToList();
        for (User user : userList) {
            customersAllString.
                    append(user.getFirstName())
                    .append(user.getLastName())
                    .append("/n");
        }
        return customersAllString;
    }


    public static List<User> getCustomersListToList() {
        Connection conn = null;
        Statement stmt = null;
        List<User> userList = new ArrayList<User>();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Id, name, password FROM customers;";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                userList.add(new User(rs.getString("Id"), rs.getString("name"), rs.getString("password")));

                //String name = rs.getString("name");
                //String author = rs.getString("phone");

                //Display values

                System.out.print("Name: " + rs.getString("name"));
                System.out.println(", Password: " + rs.getString("password"));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return userList;
    }//end main
}//end FirstExample
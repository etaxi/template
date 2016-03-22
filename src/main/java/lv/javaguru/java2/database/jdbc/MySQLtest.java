package lv.javaguru.java2.database.jdbc;

//STEP 1. Import required packages
import java.sql.*;

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
        Connection conn = null;
        Statement stmt = null;
        StringBuilder customersAllString = new StringBuilder();
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
            sql = "SELECT name, phone FROM customers;";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name


                customersAllString.
                        append(rs.getString("name"))     //db type
                        .append(rs.getString("phone") + "\n");

                //String name = rs.getString("name");
                //String author = rs.getString("phone");

                //Display values

                //System.out.print("Name: " + name);
                //System.out.println(", Author: " + author);
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
        return customersAllString;
    }//end main
}//end FirstExample
// Q) Perform CRUD operations using Java.(JDBC) 

import java.util.*;
import java.sql.*;
public class S10_Q2_JDBC_CRUD {
    static final String url = "jdbc:mysql://localhost:3306/test";
    static final String user = "root";
    static final String pass = "<<>>";
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        // CREATE
        Statement st = con.createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS student(id INT PRIMARY KEY, name VARCHAR(50))");

        // INSERT
        st.executeUpdate("INSERT INTO student VALUES(1,'A'),(2,'B'),(3,'C')");

        // READ
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));

        // UPDATE
        st.executeUpdate("UPDATE student SET name='Z' WHERE id=1");

        // DELETE
        st.executeUpdate("DELETE FROM student WHERE id=2");

        con.close();
    }
}

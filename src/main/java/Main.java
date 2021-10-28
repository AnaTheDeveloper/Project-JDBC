import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Location of database in Postgresql and username and password to accesses database
        String url = "jdbc:postgresql://localhost:5432/JDBCUsingPostgreSQL";
        String uname = "postgres";
        String pass = "123";

        int userId = 1;
        String username = "xxx";
        String query = "insert into Human values (?,?)";


        //Registering the driver
        Class.forName("org.postgresql.Driver");

        //Establishing the connection
        Connection con = DriverManager.getConnection(url,uname,pass);

        //Creating the statement: Statement, PreparedStatement or Callable Statement.
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,userId);
        st.setString(2,username);

        //Executing the statement
        int rowsChanged = st.executeUpdate();
        //Processing the result
        System.out.println("Number of rows affected: " + rowsChanged);

        //Closing the connection and statement.
        st.close();
        con.close();
    }
}

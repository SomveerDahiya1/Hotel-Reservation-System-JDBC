import services.DeleteReservation;import services.ViewReservation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hotel_db";
        String userName = "Somveer";
        String password = "Dahiya@2005";
        Scanner sc = new Scanner(System.in);
        try(Connection conn = DriverManager.getConnection(url,userName,password)) {

        }
        catch (SQLException e){
            System.out.println("Connection Failed -->"+e.getMessage());
        }

    }
}

package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddReservation {

    public void addReservation(Connection conn, Scanner sc){
        try(Statement stmt = conn.createStatement()){
            System.out.print("Enter Guest Name : ");
            String guestName=sc.next();
            sc.nextLine();
            System.out.print("Enter Room No : ");
            int roomNo=sc.nextInt();
            System.out.print("Enter Contact Details :");
            String contactDetail=sc.next();
            String query = "INSERT INTO reservation(guest_name,room_no,contact_no) VALUES ('"+guestName+"',"+roomNo+",'"+contactDetail+"') ;" ;
            System.out.println("Reservation Successful ! Thank you");
            stmt.executeUpdate(query);
        }
        catch (SQLException e){
            System.out.println("Invalid Room Number --> "+e.getMessage());
        }


    }

}

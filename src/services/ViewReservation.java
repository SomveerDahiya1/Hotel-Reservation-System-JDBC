package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewReservation {
    public void viewReservation(Connection conn, Scanner sc){
        try(Statement stmt = conn.createStatement()){
            System.out.print("Enter Reservation Id: ");
            int reservationId = sc.nextInt() ;
            String query = "SELECT *FROM reservation WHERE reservation_id="+reservationId ;
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("---Reservation Details---");
            while(rs.next()){
                String guestName = rs.getString("guest_name") ;
                String contactNo = rs.getString("contact_no");
                int roomNo = rs.getInt("room_no") ;
                String reservationDate =rs.getString("reservation_date");
                System.out.println("Guest Name: "+guestName);
                System.out.println("Contact Number: "+contactNo);
                System.out.println("Room Number: "+roomNo);
                System.out.println("Reservation Date: "+reservationDate);
            }
        }
        catch (SQLException e){
            System.out.println("Invalid Reservation Id --> "+e.getMessage());
        }
}
}

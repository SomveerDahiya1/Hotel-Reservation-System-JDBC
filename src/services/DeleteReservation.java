package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation extends UpdateReservation {
    public void deleteReservation(Connection conn, Scanner sc){
        System.out.print("Enter Reservation Id: ");
        int reservationId=sc.nextInt();
        if(!isReservationExists(conn,reservationId)){
            System.out.println("Reservation is not found for the given ID !!");
            return ;
        }
        try(Statement stmt= conn.createStatement()){
            String query="DELETE FROM reservation WHERE reservation_id="+reservationId+";";
            stmt.executeUpdate(query);
            System.out.println("Deleted Successfully !");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

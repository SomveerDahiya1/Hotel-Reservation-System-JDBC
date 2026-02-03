package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateReservation {

    public boolean isReservationExists(Connection conn,int reservationId){
        try(Statement stmt = conn.createStatement()){
            String query="SELECT room_no FROM reservation WHERE reservation_id="+reservationId+";";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return true ;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false ;
    }
    public void updateReservation(Connection conn, Scanner sc){
        System.out.print("Enter Reservation Id: ");
        int reservationId=sc.nextInt();
        if(!isReservationExists(conn,reservationId)){
            System.out.println("Reservation is not found for the given ID !!");
            return ;
        }
        try(Statement stmt= conn.createStatement()){
            System.out.print("Enter New Name: ");
            String guestName=sc.next();
            sc.nextLine();
            System.out.print("Enter New Room Number: ");
            int roomNo = sc.nextInt();
            System.out.print("Enter New Contact Number: ");
            String contactNo = sc.next();

            String query="UPDATE reservation SET"+
                    " guest_name='"+guestName+"'"+
                    ",room_no='"+roomNo+"'"+
                    ",contact_no='"+contactNo+"'"+
                    " WHERE reservation_id="+reservationId+";";
            stmt.executeUpdate(query);
            System.out.println("Updated Successful !");

        }
        catch (SQLException e){
            System.out.println("Room already Reserved !!"+e.getMessage());
        }
    }
}
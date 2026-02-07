package HotelManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelReservationApp {
    static HotelReservationApp hotelReservationApp;
    private HotelReservationApp(){

    }
    public static HotelReservationApp getApp(){
        return new HotelReservationApp();
    }
    public void appMenu(){
        while(true){
            System.out.println("HOTEL MANAGEMENT SYSTEM");
            System.out.println("1. Add Reservation");
            System.out.println("2. View Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Delete Reservation");
            System.out.println("5. Exit");
            Scanner sc = new Scanner(System.in) ;
            System.out.print("Choose Option:");
            int option=sc.nextInt();
            switch (option){
                case 1: {

                    break ;
                }case 2: {

                    break ;
                }case 3: {

                    break ;
                }case 4: {

                    break ;
                }case 5: {
                    return;
                }
                default: {
                    System.out.println("Choose Valid Option !!");
                    break ;
                }
            }

        }
    }
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

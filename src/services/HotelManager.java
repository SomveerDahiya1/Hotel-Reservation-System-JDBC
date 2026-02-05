package services;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HotelManager {
    void getApp(){
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
}

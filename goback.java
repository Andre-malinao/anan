package gsp;
import static gsp.login.*;
import java.util.Scanner;
public class goback {
    static void wishTogoBack(Scanner s){
        String where;
        System.out.println("\n==========================\n");
        System.out.println("Where you wish to go back : ");
        System.out.println("(1) Back to menu.\n(2) Back to Login");
        System.out.print("Enter number here : ");
        where = s.nextLine();
        while(true){
            if (where.equalsIgnoreCase("1")){
                adminLoginSuccess(s);
                break;
            }
            else if (where.equalsIgnoreCase("2")){
                first();
                break;
            }
            else{
                System.out.print("Enter here : ");
                where = s.nextLine();
            }
        }
    }
}

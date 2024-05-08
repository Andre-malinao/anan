package gsp;

import static gsp.Gsp.*;
import static gsp.inputgrades.*;
import static gsp.viewgrades.*;
import static gsp.goback.*;
import static gsp.inputgrades.*;
import static gsp.inputgradesITE399.*;
import static gsp.login.*;
import java.util.Scanner;


public class edit {

    public static int i;

    static void chooseNameEdit(){
        
        String studentTograde;
        System.out.println("\n==========================\n");
        System.out.println("Edit Grades Area.\n"); 

        System.out.println("List of students : ");

        for (int i = 0; i < stuDents.length; i++) {
            if (stuDents[i] != null && studentNumber[i] != null) {
                System.out.println("(" + (i + 1) + ")" + stuDents[i] + " [" + studentNumber[i] + "]");
            }
        }
        
        
        System.out.print("\nWhich student you want to edit grades (Enter student number) : ");
        studentTograde = s.nextLine();
        while (true) {
             boolean isFound = false;
             
             for (int i = 0; i < studentNumber.length; i++) {
                 if (studentTograde.equalsIgnoreCase(studentNumber[i])) {
                     isFound = true; 
                     whatsubj(studentTograde, index);
                     break;
                 }
             }
            
             if (!isFound) {
                 System.out.print("Enter here (student number only) : ");
                 studentTograde = s.nextLine();
             } else {
                 break;
             }
         }
        
    }

    static void whatsubj(String studentInput, int index) {
        String studentTograde = null;
        boolean isExist = false;
    
        // Find the student based on the provided student number
        for (int a = 0; a < studentNumber.length; i++) {
            if (studentInput.equalsIgnoreCase(studentNumber[i])) {
                isExist = true;
                studentTograde = stuDents[i];
                break;
            }
        }
    
        if (!isExist) {
            System.out.println("Entered student number does not match any existing students.");
            System.out.println("Please try again.");
            chooseNameEdit();
        }
    
        String whatSubject;
        String whichPeriod;

    
        while (true) {
            System.out.print("What subject (ITE186 / ITE399) : ");
            whatSubject = s.nextLine();
            if (whatSubject.equalsIgnoreCase("ITE186")) {
     
                System.out.print("Which Period (P1 / P2 / P3) : ");
                whichPeriod = s.nextLine();
                if (whichPeriod.equalsIgnoreCase("P1"))
                    Period1ITE186(s, studentTograde, i);
                else if (whichPeriod.equalsIgnoreCase("P2"))
                    Period2ITE186(s, studentTograde, i);
                else if (whichPeriod.equalsIgnoreCase("P3"))
                    Period3ITE186(s, studentTograde, i);
                else
                    System.out.println("Invalid input. Please try again.");
                    gobackunique(studentTograde);
                    break;
            } else if (whatSubject.equalsIgnoreCase("ITE399")) {
                System.out.print("Which Period (P1 / P2 / P3) : ");
                whichPeriod = s.nextLine();
                if (whichPeriod.equalsIgnoreCase("P1"))
                    Period1ITE399(s, studentTograde, i);
                else if (whichPeriod.equalsIgnoreCase("P2"))
                    Period2ITE399(s, studentTograde, i);
                else if (whichPeriod.equalsIgnoreCase("P3"))
                    Period3ITE399(s, studentTograde, i);
                else
                    System.out.println("Invalid input.");
            } else {
                System.out.println("Invalid input. Please try again.");
                gobackunique(studentTograde);           
                break;
            }
            gobackunique(studentTograde);
        }
    }
    
    


    static void gobackunique(String studentTograde) {
        System.out.println("Where do you wish to go back : ");
        System.out.println("(1) Back to menu\n(2) Edit grades");
        System.out.print("Enter number here : ");
        String where = s.nextLine();
        if (where.equalsIgnoreCase("1")) {
            adminLoginSuccess(s);
        }
        if (where.equalsIgnoreCase("2")) {
            chooseNameEdit();
        } else {
            System.out.print("Invalid option. Enter again: ");
        }
    }
}

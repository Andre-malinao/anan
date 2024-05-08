package gsp;
import static gsp.Gsp.*;
import static gsp.goback.*;
import static gsp.login.*;
import java.util.Scanner;
public class viewgrades {
    static void viewGradesITE186(Scanner s){
        System.out.println("\n==========================\n");
        System.out.println("List of students : ");

        for (int i = 0; i < stuDents.length; i++) {
            if (stuDents[i] != null && studentNumber[i] != null) {
                 System.out.println("(" + (i+1) + ")" + stuDents[i] + " [" + studentNumber[i] + "]");
                 }
                }
        System.out.println("");
        
        System.out.println("Which student you want to view their grades ? ");
        String whichStudent;
        whichStudent = s.nextLine();
        
        while (true) {
            
             String gradeStudent;
             boolean isFound = false;
             
             for (int i = 0; i < studentNumber.length; i++) {
                 if (whichStudent.equalsIgnoreCase(studentNumber[i])) {
                     isFound = true; 
                     System.out.println(stuDents[i] + "'s grade.");
                     gradeStudent = stuDents[i];
                     gradesAll(s, stuDents, studentLastname, gradeStudent, i);
                     break;
                 }
             }
            
             if (!isFound) {
                 System.out.print("Enter here (student number only) : ");
                 whichStudent = s.nextLine();
             } else {
                 break;
             }
         }
    }
    static void gradesAll(Scanner s, String stuDents[], String studentLastname[], String gradeStudent, int index){
        System.out.println(gradeStudent + "'s" + " Grades in ITE 186 :");
        double P1Grade = gradesITE186[index][0];
        double P2Grade = gradesITE186[index][1];
        double P3Grade = gradesITE186[index][2];
        double GPA = ((P1Grade + P2Grade + P3Grade)/3);
        
        if (GPA >= 94.80) {
         System.out.println("GPA : 1.00\n");
     } else if (GPA >= 94.70) {
         System.out.println("GPA : 1.25\n");
     } else if (GPA >= 89.10) {
         System.out.println("GPA : 1.50\n");
     } else if (GPA >= 83.50) {
         System.out.println("GPA : 1.75\n");
     } else if (GPA >= 77.90) {
         System.out.println("GPA : 2.00\n");
     } else if (GPA >= 72.30) {
         System.out.println("GPA : 2.25\n");
     } else if (GPA >= 66.70) {
         System.out.println("GPA : 2.50\n");
     } else if (GPA >= 61.10) {
         System.out.println("GPA : 2.75\n");
     } else if (GPA >= 55.50) {
         System.out.println("GPA : 3.00\n");
     } else {
         System.out.println("GPA : 5.00\n");
     }
        
        
        System.out.println("Period 1 Grade : " + P1Grade);
        System.out.println("Period 2 Grade : " + P2Grade);
        System.out.println("Period 3 Grade : " + P3Grade);
        
        System.out.println("\n");
        System.out.println(gradeStudent + "'s" + " Grades in ITE 399 :");
        double P1Grade399 = gradesITE399[index][0];
        double P2Grade399 = gradesITE399[index][1];
        double P3Grade399 = gradesITE399[index][2];
        double GPA399 = ((P1Grade399 + P2Grade399 + P3Grade399)/3);
        
        if (GPA399 >= 94.80) {
         System.out.println("GPA : 1.00\n");
     } else if (GPA399 >= 94.70) {
         System.out.println("GPA : 1.25\n");
     } else if (GPA399 >= 89.10) {
         System.out.println("GPA : 1.50\n");
     } else if (GPA399 >= 83.50) {
         System.out.println("GPA : 1.75\n");
     } else if (GPA399 >= 77.90) {
         System.out.println("GPA : 2.00\n");
     } else if (GPA399 >= 72.30) {
         System.out.println("GPA : 2.25\n");
     } else if (GPA399 >= 66.70) {
         System.out.println("GPA : 2.50\n");
     } else if (GPA399 >= 61.10) {
         System.out.println("GPA : 2.75\n");
     } else if (GPA399 >= 55.50) {
         System.out.println("GPA : 3.00\n");
     } else {
         System.out.println("GPA : 5.00\n");
     }
        System.out.println("Period 1 Grade : " + P1Grade399);
        System.out.println("Period 2 Grade : " + P2Grade399);
        System.out.println("Period 3 Grade : " + P3Grade399);
        
        System.out.println("\n");
        adminLoginSuccess(s);
    } 
}

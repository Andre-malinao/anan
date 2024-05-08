package gsp;
import static gsp.Gsp.*;
import static gsp.goback.*;
import static gsp.login.*;
import static gsp.inputgradesITE399.*;
import java.util.Scanner;
public class inputgrades {
    static void chooseSubject(Scanner s){
        String subjectInput;
        System.out.println("\n==========================\n");
        System.out.println("List of Subjects : ");
        for ( int i = 0 ; i < subJects.length; i++ ){
            System.out.println("(" + (i+1) + ")" + subJects[i]);
        }
        
        System.out.println("\nWhich subject you want to input grades first.");
        subjectInput = s.nextLine();
        
        while(true){
                if (subjectInput.equalsIgnoreCase("1")){
                    ITE186(s, stuDents, studentLastname);
                    break;
                }
                if (subjectInput.equalsIgnoreCase("2")){
                    ITE399(s, stuDents, studentLastname);
                    break;
                }
                else{
                    System.out.print("Please only choose 1 or 2 : ");
                    subjectInput = s.nextLine();
                }
        }
    }
        

   public static void ITE186(Scanner s, String studDents[], String studentLastname[]){
        System.out.println("");

        System.out.println("==========================\n");
        System.out.println("List of students under ITE 186 - Computer Programming 2: ");
        
        for (int i = 0; i < stuDents.length; i++) {
            if (stuDents[i] != null && studentNumber[i] != null) {
                 System.out.println("(" + (i+1) + ")" + stuDents[i] + " [" + studentNumber[i] + "]");
                 }
                }
        System.out.println("");
        
        String studentInput;
    
        System.out.print("Which student you want to grade. Please enter student's student number : ");
        studentInput = s.nextLine();
        
        boolean isExist = false;
        while (true){
            String studentTograde;
            
            for (int i = 0; i < studentNumber.length; i++) {
                if (studentInput.equalsIgnoreCase(studentNumber[i])) {
                    isExist = true; 
                    System.out.println("\n==========================");
                    System.out.println("\n" + stuDents[i] + "'s grade.");
                    studentTograde = studentNumber[i];
                    Period1ITE186(s, studentTograde, i);
                    Period2ITE186(s, studentTograde, i);
                    Period3ITE186(s, studentTograde, i);
                    break;
                }
            }
           
            if (!isExist) {
                System.out.print("Entered student number does not match any existing students. Please try again : ");
                studentInput = s.nextLine();
            }
        }
    }
    static void Period1ITE186(Scanner s, String studentTograde, int index){
         double Activities1;
         double Quiz1;
         double Exam1;
         System.out.println("PERIOD 1\n");
         System.out.println("ACTIVITIES TOTAL (30%), QUIZZIES TOTAL (35%), PERIODICAL EXAM TOTAL (35%)\n");
         System.out.print("Enter student's ACTIVITIES score (already in percentage. no need to use '%') : ");
         while (true){
             
             if (s.hasNextDouble()){
                Activities1 = s.nextDouble();
                if (Activities1 > 30){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
         
         System.out.println("");
         System.out.print("Enter student's QUIZZES score (already in percentage. no need to use '%') : ");
         while (true){
             if (s.hasNextDouble()){
                Quiz1 = s.nextDouble();
                if (Quiz1 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
        System.out.print("Enter student's EXAM score (already in percentage. no need to use '%') : ");
        
        while (true){
             if (s.hasNextDouble()){
                Exam1 = s.nextDouble();
                if (Exam1 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
        System.out.println("");

        Double P1GradeITE186 = Activities1 + Quiz1 + Exam1;
        System.out.println("ACTIVITIES : " + Activities1);
        System.out.println("QUIZ : " + Quiz1);
        System.out.println("EXAM : " + Exam1);

        System.out.println("");
    
        System.out.println(studentTograde + "'s " + "PERIOD 1 Grade in ITE186 is : " + P1GradeITE186);
        gradesITE186[index][0] = P1GradeITE186;
        System.out.println("Grade added successfully.\n");
        //ask admin if proceed
        String proceed1;
        System.out.print("Do you want to proceed to grade " + studentTograde + "'s " + "Period 2 ? (yes/no) : ");
        proceed1 = s.nextLine();
        
        while (true){
            if (proceed1.equalsIgnoreCase("yes")){
                Period2ITE186(s, studentTograde, index);
                break;
            }
            else if (proceed1.equalsIgnoreCase("no")){
                adminLoginSuccess(s);
                break;
            }
            else {
                proceed1 = s.nextLine();
            }
        }        
}
    static void Period2ITE186(Scanner s, String studentTograde, int index){
        double Activities2;
        double Quiz2;
        double Exam2;
        System.out.println("\nPERIOD 2\n");
        System.out.println("ACTIVITIES TOTAL (30%), QUIZZIES TOTAL (35%), PERIODICAL EXAM TOTAL (35%)");
        System.out.print("Enter student's ACTIVITIES score (already in percentage. no need to use '%') : ");
        while (true){
             if (s.hasNextDouble()){
                Activities2 = s.nextDouble();
                if (Activities2 > 30){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
        System.out.print("Enter student's QUIZZIES score (already in percentage. no need to use '%') : ");
        while (true){
             if (s.hasNextDouble()){
                Quiz2 = s.nextDouble();
                if (Quiz2 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
       System.out.print("Enter student's EXAM score (already in percentage. no need to use '%') : ");
       while (true){
             if (s.hasNextDouble()){
                Exam2 = s.nextDouble();
                if (Exam2 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
       System.out.println("");
    
       Double P2GradeITE186 = Activities2 + Quiz2 + Exam2;
       System.out.println("ACTIVITIES : " + Activities2);
       System.out.println("QUIZ : " + Quiz2);
       System.out.println("EXAM : " + Exam2);

       System.out.println("");
    
       System.out.println(studentTograde + "'s " + "PERIOD 2 Grade in ITE186 is : " + P2GradeITE186);
       gradesITE186[index][1] = P2GradeITE186;
       System.out.println("Grade added successfully.\n");
       //ask admin if proceed
       String proceed2;
       System.out.print("Do you want to proceed to grade " + studentTograde + "'s " + "Period 2 ? (yes/no) : ");
       proceed2 = s.nextLine();
    
    
       while (true){
        if (proceed2.equalsIgnoreCase("yes")){
            Period3ITE186(s, studentTograde, index);
            break;
        }
        else if (proceed2.equalsIgnoreCase("no")){
            adminLoginSuccess(s);
            break;
        }
        else {
            proceed2 = s.nextLine();
        }
    }      
    }
    static void Period3ITE186 (Scanner s, String studentTograde, int index){
        double Activities3;
        double Quiz3;
        double Exam3;
        System.out.println("\nPERIOD 3\n");
        System.out.println("ACTIVITIES TOTAL (30%), QUIZZIES TOTAL (35%), PERIODICAL EXAM TOTAL (35%)");
        System.out.print("Enter student's ACTIVITIES score (already in percentage. no need to use '%') : ");
        while (true){
             if (s.hasNextDouble()){
                Activities3 = s.nextDouble();
                if (Activities3 > 30){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
        System.out.print("Enter student's QUIZZIES score (already in percentage. no need to use '%') : ");
        while (true){
             if (s.hasNextDouble()){
                Quiz3 = s.nextDouble();
                if (Quiz3 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
       System.out.print("Enter student's EXAM score (already in percentage. no need to use '%') : ");
       while (true){
             if (s.hasNextDouble()){
                Exam3 = s.nextDouble();
                if (Exam3 > 35){
                    System.out.println("Input score exceeds total score.");
                    System.out.print("Please try again : ");
                }
                else {
                    System.out.println("Valid input received.");
                    break;
                }
            }
            if (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                s.next();
            }
         }
    
       System.out.println("");
    
       Double P3GradeITE186 = Activities3 + Quiz3 + Exam3;

       System.out.println("ACTIVITIES : " + Activities3);
       System.out.println("QUIZ : " + Quiz3);
       System.out.println("EXAM : " + Exam3);

       System.out.println("");
    
       System.out.println(studentTograde + "'s " + "PERIOD 3 Grade in ITE186 is : " + P3GradeITE186);
       gradesITE186[index][2] = P3GradeITE186;
       System.out.println("Grade added successfully.\n");
       System.out.println("ITE186 Done.");
    
    //ask admin if proceed
       adminLoginSuccess(s);
    }
    }


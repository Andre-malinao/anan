package gsp;
import static gsp. Gsp.*;
import static gsp.inputgrades.*;
import static gsp.viewgrades.*;
import static gsp.goback.*;
import static gsp.edit.*;
import java.util.Scanner;
public class login {
    static int indexToRemove;
    static String studentGivenname;
    static String studentlastname;
    static String stuDents [] = new String [50];
    static {
        stuDents[0] = "Aaron Micarte"; stuDents[1] = "Andre Malinao"; stuDents[2] = "Edchel Rabanal"; stuDents[3] = "Jasmin Salaysay"; stuDents[4] = "Justine Ventic";
    }
    static String studentLastname [] = new String[50];
    static String studentNumber [] = new String[50];
    static {
        studentNumber[0] = "02-2122-034040"; studentNumber[1] = "02-2324-11779"; studentNumber[2] = "02-2324-13881"; studentNumber[3] = "02-2324-02046"; studentNumber[4] = "02-2324-05428";
    }
    static int index = 1;
    static String lenGth [] = new String[50];
    
    static void first(){
        
        String ask;
        System.out.println("[1] Login\n[2] Exit");
        System.out.print("Enter a number : ");
        ask = s.nextLine();
        
        while (true){
            if (ask.equalsIgnoreCase("1")){
                System.out.print("\n==========================\n");
                System.out.print("          LOGIN          \n");
                System.out.print("==========================\n\n");
                logIn(s);
                break;
            }
            else if (ask.equalsIgnoreCase("2")){
                System.out.println("System exit.");
                System.exit(0);
            }
            else{
                System.out.print("Please only enter 1 or 2 : ");
                ask = s.nextLine();
            }
        }
    }
        static void logIn(Scanner s){
            String adminUsername;
            String adminPassword;
            System.out.print("Enter username : ");
            adminUsername = s.nextLine();
            System.out.print("Enter password : ");
            adminPassword = s.nextLine();
            
            while (true){
                if (adminUsername.equals ("ad") && adminPassword.equals("min")){
                System.out.println("\nLogin Success.\n");
                System.out.println("==========================\n");
                System.out.println("Welcome, ADMINISTRATOR.\n");
                adminLoginSuccess(s);
                break;
                } else { 
                System.out.println("Login failed. Please try again");
                logIn(s);
                }
            }
    }
    static void adminLoginSuccess(Scanner s){
        String optionChoose;
        System.out.println("==========================\n");
        System.out.println("Please enter number only.");
        System.out.println("1. Input grades\n2. View grades\n3. Add student/s\n4. Remove student/s\n5. Edit grades\n6. Log out");
        System.out.print("\nEnter : ");
        optionChoose = s.nextLine();

         while(true){
            if (optionChoose.equals("1")){
                chooseSubject(s);
                break;
            }
            if(optionChoose.equals("2")){
                viewGradesITE186(s);
                break;
            }
            if (optionChoose.equals("3")){
                addStudent();
                break;
            }
            if ((optionChoose.equals("4"))){
                removeStudent(stuDents, studentLastname, studentNumber);
                break;
            }
            if (optionChoose.equals("5")){
                chooseNameEdit();
                break;
            }
            if (optionChoose.equals("6")){
                System.out.print("\n==========================\n");
                System.out.print("          LOGOUT          \n");
                System.out.print("==========================\n\n");
                first();
                break;
            }
            else{
                System.out.println("Invalid input.");
                System.out.print("Please try again : ");
                optionChoose = s.nextLine();
            }
            System.out.println("");
        }
    }
    static void addStudent() {
        while (true) {
            String studentnumber;
            System.out.println("==========================\n");
            System.out.println("Welcome to Add Student area.\n");
    
            System.out.print("Enter Student's Given Name : ");
            studentGivenname = s.nextLine();
    
            System.out.print("Enter Student's Last Name : ");
            studentlastname = s.nextLine();
    
            System.out.print("Enter Student's ID Number (ex. 02-2122-034040) : ");
            studentnumber = s.nextLine();
    
            boolean numberExists = false;
            for (int i = 0; i < index; i++) {
                if (studentnumber.equalsIgnoreCase(studentNumber[i])) {
                    numberExists = true;
                    break;
                }
            }
    
            while (numberExists) {
                System.out.println("ID number already exists. Please try again : ");
                studentnumber = s.nextLine();
                numberExists = false; 
                for (int i = 0; i < index; i++) {
                    if (studentnumber.equalsIgnoreCase(studentNumber[i])) {
                        numberExists = true;
                        break;
                    }
                }
            }
    
            String student = studentGivenname + " " + studentlastname;
    
            // ngita sa first empty ng aslot in the arrays to add the new student
            int emptyIndex = -1;
            for (int i = 0; i < stuDents.length; i++) {
                if (stuDents[i] == null) {
                    emptyIndex = i;
                    break;
                }
            }
    
            // Add na dayon agn student
            if (emptyIndex != -1) {
                stuDents[emptyIndex] = student;
                studentLastname[emptyIndex] = studentlastname;
                studentNumber[emptyIndex] = studentnumber;
    
                System.out.println(stuDents[emptyIndex] + " officially added.");
                System.out.println(studentNumber[emptyIndex]);
    
                index++;
    
                adminLoginSuccess(s);
            } else {
                System.out.println("Cannot add more students. Maximum capacity reached.");
                break;
            }
        }
    }
    static void removeStudent(String[] stuDents, String[] studentLastname, String[] studentNumber) {
        Scanner s = new Scanner(System.in);
        // Display students
        System.out.println("List of students:");
        for (int i = 0; i < stuDents.length; i++) {
            if (stuDents[i] != null && studentNumber[i] != null) {
                System.out.println("(" + (i + 1) + ") " + stuDents[i] + " [" + studentNumber[i] + "]");
            }
        }
    
        
        System.out.print("Enter the student number of the student to remove (ex. 02-2122-034040): ");
        String studentNumberToRemove = s.nextLine();
    
        // Find the index of the student to remove based on student number
        int removeIndex = -1;
        for (int i = 0; i < studentNumber.length; i++) {
            if (studentNumberToRemove.equals(studentNumber[i])) {
                removeIndex = i;
                break;
            }
        }
    
        if (removeIndex != -1) {
            // balhin ang elements para ma remove ang student
            for (int j = removeIndex; j < stuDents.length - 1; j++) {
                stuDents[j] = stuDents[j + 1];
                studentLastname[j] = studentLastname[j + 1];
                studentNumber[j] = studentNumber[j + 1];
            }
            //clear student
            stuDents[stuDents.length - 1] = null;
            studentLastname[studentLastname.length - 1] = null;
            studentNumber[studentNumber.length - 1] = null;
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with the provided student number not found.");
        }
        adminLoginSuccess(s);
    }
}
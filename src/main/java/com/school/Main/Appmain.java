package com.school.Main;

import com.school.schoolmanagment.student;
import com.school.schooldao.studentdao;

import java.util.List;
import java.util.Scanner;

public class Appmain {
    private static Scanner sc = new Scanner(System.in);
    private static studentdao studentdao = new studentdao();
    private static com.school.schoolmanagment.student student = new student();
    public static void main(String args[]){
        while (true){
            System.out.println("1,Save student");
            System.out.println("2, get All student");
            System.out.println("3, update student");
            System.out.println("4,delete student");
            System.out.println("5,Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    savestudents();
                    break;
                case 2:
                    getAllstudents();
                    break;
                case 3:
                    updatestudents();
                    break;
                case 4:
                    deletestudents();
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    System.exit(2);
                default:
                    System.out.println("Invalid choice please tey again");
            }
        }
    }
    private static void savestudents(){
        System.out.println("Enter firstName");
        String firstName= sc.nextLine();
        System.out.println("Enter lastName");
        String lastName= sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();

        studentdao.saveStudent(firstName,lastName,email);
    }
    private static void getAllstudents(){
        List<student> st=studentdao.getStudent();
        for (student sts: st){
            System.out.println(sts);
        }
    }
    private static void updatestudents(){
        student.setFirsName("Vibha");
        student.setLastName("Baghel");
        student.setEmail("vibhabaghel4@gamil.com");
        student.setId(3);
        System.out.println(studentdao.updatestudent(student));
    }
    private static void deletestudents(){
        System.out.println("Enter id");
        int id = sc.nextInt();
        System.out.println(studentdao.deleteStudent(id));
    }

}

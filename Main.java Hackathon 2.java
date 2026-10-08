import java.util.Scanner;

class Student {
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    double courseFee;
    double scholarship;
    double finalFee;

    // Parameterized constructor
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    void calculateFee() {
        courseFee = courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship
    void calculateScholarship() {
        if (marks >= 85) {
            scholarship = courseFee * 20 / 100;
        } else if (marks >= 70) {
            scholarship = courseFee * 10 / 100;
        } else {
            scholarship = 0;
        }
    }

    // Calculate final fee
    void calculateFinalFee() {
        finalFee = courseFee - scholarship;
    }

    // Display details
    void displayDetails() {
        System.out.println("\n----- STUDENT DETAILS -----");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks          : " + marks);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
        System.out.println("Course Fee     : Rs. " + courseFee);
        System.out.println("Scholarship    : Rs. " + scholarship);
        System.out.println("Final Fee      : Rs. " + finalFee);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        // Create Student object
        Student s = new Student(name, roll, marks, course, credits);

        // Check eligibility
        if (s.checkEligibility()) {

            s.calculateFee();
            s.calculateScholarship();
            s.calculateFinalFee();

            s.displayDetails();

        } else {
            System.out.println("\nStudent is NOT eligible for registration.");
            System.out.println("Minimum marks required: 50");
        }

        sc.close();
    }
}
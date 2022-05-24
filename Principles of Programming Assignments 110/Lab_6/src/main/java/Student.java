// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This is a Student Class that runs with the tester and the Program class


import java.security.PublicKey;

public class Student {
    private String firstName, lastName, fullName, asuId;
    private double grade;

    public Student(String firstName, String lastName, String asuId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.asuId = asuId;
        this.fullName = firstName + " " + lastName;
        this.grade = -1.00;
    }

    public String toString() {
        return String.format("Student: %s, ASU: %s, Grade: %f", fullName, asuId, grade);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAsuID() {
        return asuId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double newGrade) {
        grade = newGrade;
    }

}


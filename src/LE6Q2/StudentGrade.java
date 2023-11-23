package LE6Q2;

public class StudentGrade implements Comparable<StudentGrade> {

    private String firstName;
    private String lastName;
    private int grade;

    // Constructors
    public StudentGrade() {}

    public StudentGrade(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    // Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(StudentGrade other) {

        if(other.grade > grade){
            return -1;
        } else if(other.grade == grade){
            return 0;
        } else if (other.grade < grade ){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return String.format("\b\b\t%-8s %8s\t", firstName, lastName) + String.format(": %12d%n", grade);
    }
}

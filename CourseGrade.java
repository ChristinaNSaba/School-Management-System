package Application;

public class CourseGrade {
    private String courseName;
    private double grade;

    public CourseGrade(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }
    public CourseGrade(){
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

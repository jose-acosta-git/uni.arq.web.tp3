package integrador3.dtos;


public class CourseReportDto {
    private String courseName;
    private int year;
    private long enrolledStudents;
    private long graduatedStudents;

    public CourseReportDto(String courseName, int year, long enrolledStudents, long graduatedStudents) {
        this.courseName = courseName;
        this.year = year;
        this.enrolledStudents = enrolledStudents;
        this.graduatedStudents = graduatedStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(long enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public long getGraduatedStudents() {
        return graduatedStudents;
    }

    public void setGraduatedStudents(long graduatedStudents) {
        this.graduatedStudents = graduatedStudents;
    }
}

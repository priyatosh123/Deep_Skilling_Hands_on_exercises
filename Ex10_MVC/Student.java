package mvc;


public class Student {

    private String name;
    private String studentId;
    private String grade;

    public Student(String name, String studentId, String grade) {
        this.name      = name;
        this.studentId = studentId;
        this.grade     = grade;
    }

    public String getName()      { return name; }
    public String getStudentId() { return studentId; }
    public String getGrade()     { return grade; }

    public void setName(String name)      { this.name = name; }
    public void setGrade(String grade)    { this.grade = grade; }
}

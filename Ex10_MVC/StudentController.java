package mvc;


public class StudentController {

    private final Student model;
    private final StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view  = view;
    }

    public void updateStudentName(String name) {
        model.setName(name);
    }

    public void updateStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentName()  { return model.getName(); }
    public String getStudentGrade() { return model.getGrade(); }
    public String getStudentId()    { return model.getStudentId(); }

    public void showStudentDetails() {
        view.displayStudentDetails(
                model.getName(),
                model.getStudentId(),
                model.getGrade()
        );
    }
}

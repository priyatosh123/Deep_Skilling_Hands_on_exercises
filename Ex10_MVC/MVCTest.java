package mvc;


public class MVCTest {

    public static void main(String[] args) {
        // Model
        Student student = new Student("Priyatosh Kumar", "CS2021042", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        System.out.println("--- Initial Record ---");
        controller.showStudentDetails();

    
        controller.updateStudentGrade("A+");
        controller.updateStudentName("Priyatosh K.");

        System.out.println("\n--- After Updates ---");
        controller.showStudentDetails();
    }
}

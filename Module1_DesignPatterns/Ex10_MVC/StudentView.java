package mvc;


public class StudentView {

    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("┌─────────────────────────┐");
        System.out.println("│     Student Record      │");
        System.out.println("├─────────────────────────┤");
        System.out.printf( "│ Name  : %-15s │%n", name);
        System.out.printf( "│ ID    : %-15s │%n", id);
        System.out.printf( "│ Grade : %-15s │%n", grade);
        System.out.println("└─────────────────────────┘");
    }
}

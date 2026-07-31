package command;

public interface Command {
    void execute();
    void undo();   // bonus: undo support makes Command really useful
}

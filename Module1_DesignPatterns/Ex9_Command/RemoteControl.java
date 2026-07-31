package command;


public class RemoteControl {

    private Command lastCommand;

    public void pressButton(Command cmd) {
        cmd.execute();
        lastCommand = cmd;
    }

    public void pressUndo() {
        if (lastCommand != null) {
            System.out.print("Undoing last action... ");
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}

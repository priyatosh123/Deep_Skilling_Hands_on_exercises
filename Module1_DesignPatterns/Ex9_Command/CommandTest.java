package command;

public class CommandTest {

    public static void main(String[] args) {
        Light bedroomLight = new Light("Bedroom");
        Light livingRoomLight = new Light("Living Room");

        Command bedroomOn  = new LightOnCommand(bedroomLight);
        Command bedroomOff = new LightOffCommand(bedroomLight);
        Command livingOn   = new LightOnCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.pressButton(bedroomOn);
        remote.pressButton(livingOn);
        remote.pressButton(bedroomOff);

        System.out.println("\n--- Pressing Undo ---");
        remote.pressUndo();   // re-turns bedroom on
    }
}

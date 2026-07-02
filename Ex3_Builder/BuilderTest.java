package builder;


public class BuilderTest {

    public static void main(String[] args) {
        // Basic office machine
        Computer officePC = new Computer.Builder("Intel Core i5", 8)
                .storage(512)
                .withSSD()
                .os("Windows 11")
                .build();

        // High-end gaming rig
        Computer gamingRig = new Computer.Builder("AMD Ryzen 9", 32)
                .storage(2000)
                .withSSD()
                .withGPU()
                .os("Windows 11")
                .build();

        // Minimal dev server
        Computer devServer = new Computer.Builder("Intel Xeon", 16)
                .storage(1000)
                .build();

        System.out.println("--- Office PC ---");
        System.out.println(officePC);

        System.out.println("\n--- Gaming Rig ---");
        System.out.println(gamingRig);

        System.out.println("\n--- Dev Server ---");
        System.out.println(devServer);
    }
}

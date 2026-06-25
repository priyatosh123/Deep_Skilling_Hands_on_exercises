package builder;


public class Computer {

    // Required
    private final String cpu;
    private final int ramGB;

    // Optional
    private final int storageGB;
    private final boolean hasSSD;
    private final boolean hasGPU;
    private final String os;

    private Computer(Builder b) {
        this.cpu       = b.cpu;
        this.ramGB     = b.ramGB;
        this.storageGB = b.storageGB;
        this.hasSSD    = b.hasSSD;
        this.hasGPU    = b.hasGPU;
        this.os        = b.os;
    }

    @Override
    public String toString() {
        return "Computer {"
            + "\n  CPU       : " + cpu
            + "\n  RAM       : " + ramGB + " GB"
            + "\n  Storage   : " + storageGB + " GB (" + (hasSSD ? "SSD" : "HDD") + ")"
            + "\n  GPU       : " + (hasGPU ? "Yes" : "No")
            + "\n  OS        : " + os
            + "\n}";
    }

    // ------------------------------------------------------------------
    // Static nested Builder
    // ------------------------------------------------------------------
    public static class Builder {

        private final String cpu;
        private final int ramGB;

        private int storageGB = 256;
        private boolean hasSSD = false;
        private boolean hasGPU = false;
        private String os = "Linux";

        public Builder(String cpu, int ramGB) {
            this.cpu   = cpu;
            this.ramGB = ramGB;
        }

        public Builder storage(int gb) {
            this.storageGB = gb;
            return this;
        }

        public Builder withSSD() {
            this.hasSSD = true;
            return this;
        }

        public Builder withGPU() {
            this.hasGPU = true;
            return this;
        }

        public Builder os(String operatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

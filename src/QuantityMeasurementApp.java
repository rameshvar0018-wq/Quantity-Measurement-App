public class QuantityMeasurementApp {

    // -------- Feet Class --------
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // -------- Inches Class --------
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // -------- Method for Feet Equality --------
    public static void testFeetEquality() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: " + (f1.equals(f2) ? "Equal (true)" : "Not Equal (false)"));
    }

    // -------- Method for Inches Equality --------
    public static void testInchesEquality() {
        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(1.0);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: " + (i1.equals(i2) ? "Equal (true)" : "Not Equal (false)"));
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        testFeetEquality();
        testInchesEquality();

        // Extra Test Cases
        System.out.println("\n--- Extra Tests ---");

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);

        System.out.println("Feet Different: " + f1.equals(f2)); // false
        System.out.println("Feet Null: " + f1.equals(null));    // false
        System.out.println("Feet Same Ref: " + f1.equals(f1));  // true

        Inches i1 = new Inches(1.0);
        Inches i2 = new Inches(2.0);

        System.out.println("Inches Different: " + i1.equals(i2)); // false
        System.out.println("Inches Null: " + i1.equals(null));    // false
        System.out.println("Inches Same Ref: " + i1.equals(i1));  // true
    }
}
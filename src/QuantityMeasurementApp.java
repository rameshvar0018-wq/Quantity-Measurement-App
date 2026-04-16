public class QuantityMeasurementApp {

    // Inner class for Feet
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {

            // 1. Same reference
            if (this == obj) return true;

            // 2. Null check
            if (obj == null) return false;

            // 3. Type check
            if (getClass() != obj.getClass()) return false;

            // 4. Cast
            Feet other = (Feet) obj;

            // 5. Compare values
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        Feet f3 = new Feet(2.0);

        // UC1 Output
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: " + (f1.equals(f2) ? "Equal (true)" : "Not Equal (false)"));

        // Test Cases
        System.out.println("\n--- Test Cases ---");

        // 1. Same Value
        System.out.println("Same Value: " + f1.equals(f2)); // true

        // 2. Different Value
        System.out.println("Different Value: " + f1.equals(f3)); // false

        // 3. Null Comparison
        System.out.println("Null Comparison: " + f1.equals(null)); // false

        // 4. Non-Numeric Input
        System.out.println("Non-Numeric Input: " + f1.equals("abc")); // false

        // 5. Same Reference
        System.out.println("Same Reference: " + f1.equals(f1)); // true
    }
}
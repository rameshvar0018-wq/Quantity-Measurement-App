public class QuantityMeasurementApp {

    // -------- Enum for Units --------
    enum LengthUnit {
        FEET(1.0),          // base unit
        INCHES(1.0 / 12.0); // 1 inch = 1/12 feet

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // -------- Generic Quantity Class --------
    static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (feet)
        private double toBaseUnit() {
            return value * unit.getConversionFactor();
        }

        // Override equals()
        @Override
        public boolean equals(Object obj) {

            // 1. Same reference
            if (this == obj) return true;

            // 2. Null or type check
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            // 3. Compare after converting to base unit
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }
    }

    // -------- Demo Methods --------

    // Feet equality
    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        System.out.println("Input: Quantity(1.0, feet) and Quantity(1.0, feet)");
        System.out.println("Output: " + (l1.equals(l2) ? "Equal (true)" : "Not Equal (false)"));
    }

    // Inches equality
    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, inch) and Quantity(1.0, inch)");
        System.out.println("Output: " + (l1.equals(l2) ? "Equal (true)" : "Not Equal (false)"));
    }

    // Cross-unit comparison
    public static void demonstrateCrossComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, feet) and Quantity(12.0, inches)");
        System.out.println("Output: " + (l1.equals(l2) ? "Equal (true)" : "Not Equal (false)"));
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateCrossComparison();

        // Extra Tests
        System.out.println("\n--- Extra Tests ---");

        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(2.0, LengthUnit.FEET);
        Length c = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Different Feet: " + a.equals(b)); // false
        System.out.println("Feet vs Inches: " + a.equals(c)); // true
        System.out.println("Null Check: " + a.equals(null));  // false
        System.out.println("Same Ref: " + a.equals(a));       // true
    }
}
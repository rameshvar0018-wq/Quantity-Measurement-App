public class QuantityMeasurementApp {

    // -------- Enum for Units --------
    enum LengthUnit {
        FEET(1.0),              // base unit = feet
        INCHES(1.0 / 12.0),     // 1 inch = 1/12 feet
        YARDS(3.0),             // 1 yard = 3 feet
        CENTIMETERS(0.393701 / 12.0); // 1 cm = 0.393701 inches → convert to feet

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

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }
    }

    // -------- Demo Methods --------

    public static void testYardToFeet() {
        Length y = new Length(1.0, LengthUnit.YARDS);
        Length f = new Length(3.0, LengthUnit.FEET);

        System.out.println("1 yard == 3 feet → " + y.equals(f));
    }

    public static void testYardToInches() {
        Length y = new Length(1.0, LengthUnit.YARDS);
        Length i = new Length(36.0, LengthUnit.INCHES);

        System.out.println("1 yard == 36 inches → " + y.equals(i));
    }

    public static void testCmToInches() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, LengthUnit.INCHES);

        System.out.println("1 cm == 0.393701 inch → " + cm.equals(inch));
    }

    public static void testSameUnit() {
        Length a = new Length(2.0, LengthUnit.YARDS);
        Length b = new Length(2.0, LengthUnit.YARDS);

        System.out.println("2 yards == 2 yards → " + a.equals(b));
    }

    // -------- Main Method --------
    public static void main(String[] args) {

        testYardToFeet();
        testYardToInches();
        testCmToInches();
        testSameUnit();

        // Extra Tests
        System.out.println("\n--- Extra Tests ---");

        Length a = new Length(1.0, LengthUnit.YARDS);
        Length b = new Length(2.0, LengthUnit.FEET);

        System.out.println("1 yard == 2 feet → " + a.equals(b)); // false
        System.out.println("Null check → " + a.equals(null));    // false
        System.out.println("Same ref → " + a.equals(a));         // true

        // Transitive check
        Length c = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Transitive (yard == inch) → " + a.equals(c)); // true
    }
}
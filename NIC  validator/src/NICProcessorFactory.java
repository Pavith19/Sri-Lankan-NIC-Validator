/**
 * Factory class to create appropriate NIC processor based on input format
 */
class NICProcessorFactory {
    public static NICProcessor createProcessor(String nicNumber) {
        if (nicNumber == null || nicNumber.isEmpty()) {
            throw new IllegalArgumentException("NIC number cannot be empty");
        }

        nicNumber = nicNumber.trim();

        // Old format: 9 digits + letter (e.g., 861234567V)
        if (nicNumber.length() == 10) {
            return new OldNICProcessor(nicNumber);
        }
        // New format: 12 digits (e.g., 198612345678)
        else if (nicNumber.length() == 12) {
            return new NewNICProcessor(nicNumber);
        } else {
            throw new IllegalArgumentException("Invalid NIC format. Should be 10 characters (old) or 12 digits (new)");
        }
    }
}
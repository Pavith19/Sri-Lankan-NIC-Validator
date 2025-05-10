import java.time.LocalDate;

/**
 * Processor for the old format NIC (9 digits + letter)
 */
class OldNICProcessor implements NICProcessor {
    private final String nicNumber;

    public OldNICProcessor(String nicNumber) {
        if (!isValidOldFormat(nicNumber)) {
            throw new IllegalArgumentException("Invalid old format NIC. Should be 9 digits followed by V or X");
        }
        this.nicNumber = nicNumber;
    }

    private boolean isValidOldFormat(String nic) {
        // Check format: 9 digits followed by V or X
        return nic.matches("\\d{9}[VX]");
    }

    @Override
    public NICInfo extractInfo() {
        // First two digits represent year (19XX)
        int yearPrefix = 19; // Old NIC format assumes birth year in 1900s
        int yearSuffix = Integer.parseInt(nicNumber.substring(0, 2));
        int yearOfBirth = yearPrefix * 100 + yearSuffix;

        // Next three digits represent day of year (and gender)
        int dayOfYearCode = Integer.parseInt(nicNumber.substring(2, 5));

        boolean isFemale = dayOfYearCode > 500;
        int dayOfYear = isFemale ? dayOfYearCode - 500 : dayOfYearCode;

        // Validate day of year
        if (dayOfYear < 1 || dayOfYear > 366) {
            throw new IllegalArgumentException("Invalid day of year in NIC");
        }

        // Calculate full date of birth
        LocalDate dateOfBirth = calculateDateOfBirth(yearOfBirth, dayOfYear);

        return new NICInfo(isFemale ? "Female" : "Male", yearOfBirth, dayOfYear, dateOfBirth);
    }

    private LocalDate calculateDateOfBirth(int year, int dayOfYear) {
        return LocalDate.ofYearDay(year, dayOfYear);
    }
}

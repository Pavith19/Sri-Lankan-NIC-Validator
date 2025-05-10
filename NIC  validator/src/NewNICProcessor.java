import java.time.LocalDate;

/**
 * Processor for the new format NIC (12 digits)
 */
class NewNICProcessor implements NICProcessor {
    private final String nicNumber;

    public NewNICProcessor(String nicNumber) {
        if (!isValidNewFormat(nicNumber)) {
            throw new IllegalArgumentException("Invalid new format NIC. Should be 12 digits");
        }
        this.nicNumber = nicNumber;
    }

    private boolean isValidNewFormat(String nic) {
        // Check format: 12 digits
        return nic.matches("\\d{12}");
    }

    @Override
    public NICInfo extractInfo() {
        // First four digits represent year of birth
        int yearOfBirth = Integer.parseInt(nicNumber.substring(0, 4));

        // Next three digits represent day of year (and gender)
        int dayOfYearCode = Integer.parseInt(nicNumber.substring(4, 7));

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

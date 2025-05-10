import java.time.LocalDate;

/**
 * Value object to store extracted NIC information
 */
class NICInfo {
    private final String gender;
    private final int yearOfBirth;
    private final int dayOfYear;
    private final LocalDate dateOfBirth;

    public NICInfo(String gender, int yearOfBirth, int dayOfYear, LocalDate dateOfBirth) {
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.dayOfYear = dayOfYear;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getDayOfYear() {
        return dayOfYear;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
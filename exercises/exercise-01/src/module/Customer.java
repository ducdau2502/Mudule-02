package module;

public class Customer {
    private String fullName;
    private String dateOfBirth;
    private long id;

    public Customer() {
    }

    public Customer(String fullName, String dateOfBirth, long id) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %d ", getFullName(), getDateOfBirth(), getId());
    }
}

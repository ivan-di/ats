package ivan.di.model;

/**
 * The Applicant class represents a job seeker with personal information and a unique ID.
 */
public class Applicant {
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;
    private Address address;
    private final String id;

    /**
     * Constructs a new Applicant object with the given personal information and ID.
     *
     * @param firstName the applicant's first name
     * @param lastName the applicant's last name
     * @param age the applicant's age
     * @param email the applicant's email address
     * @param phone the applicant's phone number
     * @param address the applicant's address as an Address object
     * @param id the applicant's unique ID as a String
     */
    public Applicant(String firstName, String lastName, Integer age, String email, String phone, Address address, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    /**
     * Returns the applicant's first name.
     *
     * @return the applicant's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the applicant's last name.
     *
     * @return the applicant's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the applicant's age.
     *
     * @return the applicant's age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Returns the applicant's email address.
     *
     * @return the applicant's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the applicant's phone number.
     *
     * @return the applicant's phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns the applicant's address as an Address object.
     *
     * @return the applicant's address as an Address object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns the applicant's unique ID as a String.
     *
     * @return the applicant's unique ID as a String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the applicant's first name.
     *
     * @param firstName the applicant's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the applicant's last name.
     *
     * @param lastName the applicant's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the applicant's age.
     *
     * @param age the applicant's age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Sets the applicant's email address.
     *
     * @param email the applicant's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the applicant's phone number.
     *
     * @param phone the applicant's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}


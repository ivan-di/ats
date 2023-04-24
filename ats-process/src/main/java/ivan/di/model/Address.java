package ivan.di.model;

/**
 * The Address class represents a physical address with a street address, city, state, and zip code.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    /**
     * Constructs a new Address object with the given street address, city, state, and zip code.
     *
     * @param street the street address
     * @param city the city
     * @param state the state
     * @param zipCode the zip code
     */
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Returns the street address.
     *
     * @return the street address
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the street address.
     *
     * @param street the street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}


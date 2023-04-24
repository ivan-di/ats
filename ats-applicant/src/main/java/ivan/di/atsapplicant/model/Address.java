package ivan.di.atsapplicant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Address class represents a physical address with a street address, city, state, and zip code.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}


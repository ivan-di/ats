package ivan.di.atsapplicant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDto {

    private String street;
    private String city;
    private String state;
    private String zipCode;
}

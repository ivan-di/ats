package ivan.di.atsapplicant;

import ivan.di.atsapplicant.model.dto.AddressDto;
import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.controller.mappers.ApplicantMapper;
import ivan.di.atsapplicant.model.Address;
import ivan.di.atsapplicant.model.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicantMapperTest extends AbstractApplicantTest{
    ApplicantMapper mapper = new ApplicantMapper();

    @BeforeEach
    public void setup() {
//        this.mapper = new ModelMapper();
    }

    @Test
    public void mapApplicantDtoToApplicant() {
        // test data setup
        ApplicantDto dto = getApplicantDto();
        // convert DTO to entity
        Applicant applicant = mapper.mapToApplicant(dto);

        // check that the mapping was successful
        assertEquals(dto.getFirstName(), applicant.getFirstName());
        assertEquals(dto.getLastName(), applicant.getLastName());
        assertEquals(dto.getAge(), applicant.getAge());
        assertEquals(dto.getEmail(), applicant.getEmail());
        assertEquals(dto.getPhoneNumber(), applicant.getPhoneNumber());

        AddressDto addressDto = dto.getAddress();
        Address address = applicant.getAddress();
        assertEquals(addressDto.getStreet(), address.getStreet());
        assertEquals(addressDto.getCity(), address.getCity());
        assertEquals(addressDto.getState(), address.getState());
        assertEquals(addressDto.getZipCode(), address.getZipCode());
    }

    @Test
    public void testEntityToDtoMapping() {
        // Set up test data
        Applicant applicant = getApplicant();

        // Map entity to DTO
        ApplicantDto dto = mapper.mapToApplicantDto(applicant);

        // Ensure that the mapping was successful
        assertEquals(applicant.getFirstName(), dto.getFirstName());
        assertEquals(applicant.getLastName(), dto.getLastName());
        assertEquals(applicant.getAge(), dto.getAge());
        assertEquals(applicant.getEmail(), dto.getEmail());
        assertEquals(applicant.getPhoneNumber(), dto.getPhoneNumber());

        Address address = applicant.getAddress();
        AddressDto addressDto = dto.getAddress();

        // Ensure that the address was mapped correctly
        assertEquals(address.getStreet(), addressDto.getStreet());
        assertEquals(address.getCity(), addressDto.getCity());
        assertEquals(address.getState(), addressDto.getState());
        assertEquals(address.getZipCode(), addressDto.getZipCode());
    }
}

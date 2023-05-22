package ivan.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import ivan.di.dto.AddressDto;
import ivan.di.dto.ApplicantDto;
import ivan.di.dto.ResumeDto;

import java.util.List;

public abstract class AbstractIntegrationTest {

//    TODO: delete
//    public static final String APPLICANT_URI = "/api/applicant";
    public static final String PROCESS_URI = "/api/tracking";
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected ApplicantDto getApplicantDto() {
        return ApplicantDto.builder()
          .firstName("Ivan")
          .lastName("Diachenko")
          .age(22)
          .email("email@ivan.di")
          .phoneNumber("773355")
            .resume(generateResumeDto())
          .address(generateAddressDto())
          .build();
    }

    protected AddressDto generateAddressDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet("123 Main St");
        addressDto.setCity("Anytown");
        addressDto.setState("CA");
        addressDto.setZipCode("12345");

        return addressDto;
    }

    protected ResumeDto generateResumeDto() {
        return ResumeDto.builder()
            .bio("I am a Java and Spring Developer")
            .educationLevel("BACHELORS")
            .experienceMonths(21)
            .skills(List.of("Java", "Spring", "Git", "Kafka", "MongoDB", "PostgreSQL"))
            .build();
    }
}

package ivan.di.atsapplicant;

import ivan.di.atsapplicant.model.dto.AddressDto;
import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.model.Address;
import ivan.di.atsapplicant.model.Applicant;
import ivan.di.atsapplicant.model.dto.ResumeDto;

import java.util.List;

public abstract class AbstractApplicantTest {

    public static final String APPLICANT_URI = "/api/applicant";

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

    protected Applicant getApplicant() {
            return Applicant.builder()
                .firstName("Ivan")
                .lastName("Diachenko")
                .age(22)
                .email("email@ivan.di")
                .phoneNumber("773355")
                .address(generateAddress())
                .build();
    }

    protected Address generateAddress() {
        return Address.builder()
            .street("123 Main St")
            .city("Anytown")
            .state("CA")
            .zipCode("12345")
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

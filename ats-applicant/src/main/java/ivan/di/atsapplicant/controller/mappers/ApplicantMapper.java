package ivan.di.atsapplicant.controller.mappers;

import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.model.Applicant;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {
    private final ModelMapper mapper;

    public ApplicantMapper() {
        this.mapper = new ModelMapper();
    }

    public Applicant mapToApplicant(ApplicantDto dto) {
        return mapper.map(dto, Applicant.class);
    }

    public ApplicantDto mapToApplicantDto(Applicant applicant) {
        return mapper.map(applicant, ApplicantDto.class);
    }
}



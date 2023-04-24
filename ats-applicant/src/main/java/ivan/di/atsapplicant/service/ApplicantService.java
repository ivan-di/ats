package ivan.di.atsapplicant.service;

import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.controller.mappers.ApplicantMapper;
import ivan.di.atsapplicant.model.Applicant;
import ivan.di.atsapplicant.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
@AllArgsConstructor
public class ApplicantService {
    private final ApplicantMapper mapper;

    private final ApplicantRepository applicantRepository;

    public ApplicantDto createProduct(ApplicantDto applicantDto) {
        Applicant applicant = mapper.mapToApplicant(applicantDto);
        applicant = applicantRepository.save(applicant);

        log.info("Applicant saved with id={}", applicant.getId());
        return mapper.mapToApplicantDto(applicant);
    }

    public ApplicantDto findApplicant(String id) throws NoSuchElementException {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(NoSuchElementException::new);

        log.info("Applicant with id={} is found", applicant.getId());
        return mapper.mapToApplicantDto(applicant);
    }
}


package ivan.di.service;

import ivan.di.dto.ApplicantDto;
import ivan.di.feignclients.ApplicantFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicantService {

    private final ApplicantFeignClient applicantClient;

    @Async
    public ApplicantDto saveApplicant(ApplicantDto applicantDto) {
        ResponseEntity<ApplicantDto> response = applicantClient.createApplicant(applicantDto);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        throw new RuntimeException("Error creating applicant with status uuid " + applicantDto.getUuid());
    }
}

package ivan.di.service;

import ivan.di.model.dto.ApplicantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    public static final String APPLICANT_SERVICE_URL = "http://ats-applicant";

    private final WebClient.Builder webClientBuilder;

    public void saveApplicant(ApplicantDto applicantDto) {

        webClientBuilder.build().post()
            .uri(APPLICANT_SERVICE_URL+"/applicant");
            //.body(ApplicantDto.class, applicantDto)
            //.block();
    }
}

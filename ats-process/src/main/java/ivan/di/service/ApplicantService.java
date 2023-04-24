package ivan.di.service;

import ivan.di.model.dto.ApplicantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    public static final String APPLICANT_SERVICE_URL = "http://localhost:1102";

    private final WebClient webClient;

    public void saveApplicant(ApplicantDto applicantDto) {


        webClient.post()
            .uri(APPLICANT_SERVICE_URL+"/applicant");
            //.body(ApplicantDto.class, applicantDto)
            //.block();
    }
}

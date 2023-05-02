package ivan.di.feignclients;

import ivan.di.dto.ApplicantDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "applicantFeignClient", url = "http://ats-applicant")
public interface ApplicantFeignClient {
    @PostMapping(value = "/api/applicant", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ApplicantDto> createApplicant(@RequestBody ApplicantDto applicantDto);
}

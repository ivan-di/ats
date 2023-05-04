package ivan.di.controller;

import ivan.di.dto.ApplicantDto;
import ivan.di.service.ApplicantReviewingProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ProcessController {
    private final ApplicantReviewingProcessService applicantReviewingProcessService;

    /** Starts the process of applicant tracking.
     * @param applicantDto
     * @return process instance id
     */
    @PostMapping("/tracking")
    public String process(@RequestBody ApplicantDto applicantDto) {
        return applicantReviewingProcessService.startApplicantReviewingProcess(applicantDto);
    }
}

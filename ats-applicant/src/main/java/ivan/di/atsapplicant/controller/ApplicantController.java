package ivan.di.atsapplicant.controller;

import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ApplicantDto createApplicant(@RequestBody ApplicantDto applicantDto) {
        return applicantService.createProduct(applicantDto);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicantDto getApplicant(@PathVariable String id) {
        return applicantService.findApplicant(id);
    }
}

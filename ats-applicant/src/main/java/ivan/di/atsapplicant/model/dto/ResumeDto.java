package ivan.di.atsapplicant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
    private String bio;
    private String educationLevel;
    private Integer experienceMonths;
    private List<String> skills;
    private Integer evaluation;
}

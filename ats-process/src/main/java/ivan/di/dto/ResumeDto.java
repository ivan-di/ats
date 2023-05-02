package ivan.di.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private String bio;
    private String educationLevel;
    private Integer experienceMonths;
    private List<String> skills;
    private Integer evaluation;
}

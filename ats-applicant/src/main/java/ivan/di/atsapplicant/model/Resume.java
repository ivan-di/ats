package ivan.di.atsapplicant.model;

import lombok.Data;

import java.util.List;

/**
 * The resume fields are filled with the info on client side.
 * The binary file is uploaded into separated entity.
 */
@Data
public class Resume {
    private String bio;
    private Education educationLevel;
    private Integer experienceMonths;
    private List<String> skills;
    private Integer evaluation;
}

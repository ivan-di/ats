package ivan.di.atsapplicant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Applicant class represents a job seeker with personal information and a unique ID stored in DB.
 */
@Document(value = "applicant")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Applicant {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;
    private Address address;
}


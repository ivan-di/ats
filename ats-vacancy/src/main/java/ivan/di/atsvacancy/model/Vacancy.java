package ivan.di.atsvacancy.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

@NodeEntity
@Data
public class Vacancy {
    @Id
    private Long id;
    private String title;
    private String location;
    private String description;
    private int salary;

    @Relationship(type = "APPLIED")
    private Set<Applicant> applicants;
}

package ivan.di.atsapplicant.repository;

import ivan.di.atsapplicant.model.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ApplicantRepository extends MongoRepository<Applicant, String> {
}

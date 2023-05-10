package ivan.di.atsvacancy.repository;

import ivan.di.atsvacancy.model.Vacancy;
import org.springframework.data.neo4j.repository.Neo4jRepository;


public interface VacancyRepository extends Neo4jRepository<Vacancy, Long> {
}

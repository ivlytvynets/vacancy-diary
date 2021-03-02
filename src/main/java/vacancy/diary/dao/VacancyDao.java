package vacancy.diary.dao;

import java.util.List;
import java.util.Optional;
import vacancy.diary.model.Status;
import vacancy.diary.model.Vacancy;

public interface VacancyDao {
    Vacancy add(Vacancy vacancy);

    Optional<Vacancy> get(Long id);

    List<Vacancy> findByStatus(Status status);

    List<Vacancy> findByCompany(String company);

    List<Vacancy> getAll();

    Vacancy update(Vacancy vacancy);

    void delete(Vacancy vacancy);
}

package vacancy.diary.service;

import java.util.List;
import vacancy.diary.model.Status;
import vacancy.diary.model.Vacancy;

public interface VacancyService {
    Vacancy add(Vacancy vacancy);

    Vacancy get(Long id);

    List<Vacancy> findByStatus(Status status);

    List<Vacancy> findByCompany(String company);

    List<Vacancy> getAll();

    Vacancy update(Vacancy vacancy);

    void delete(Vacancy vacancy);
}

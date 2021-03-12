package vacancy.diary.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import vacancy.diary.dao.VacancyDao;
import vacancy.diary.exception.DataProcessingException;
import vacancy.diary.model.Status;
import vacancy.diary.model.Vacancy;
import vacancy.diary.service.VacancyService;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;

    public VacancyServiceImpl(VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }

    @Override
    public Vacancy add(Vacancy vacancy) {
        return vacancyDao.add(vacancy);
    }

    @Override
    public Vacancy get(Long id) {
        return vacancyDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get vacancy with id + " + id));
    }

    @Override
    public List<Vacancy> findByStatus(Status status) {
        return vacancyDao.findByStatus(status);
    }

    @Override
    public List<Vacancy> findByCompany(String company) {
        return vacancyDao.findByCompany(company);
    }

    @Override
    public List<Vacancy> getAll() {
        return vacancyDao.getAll();
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        return vacancyDao.update(vacancy);
    }

    @Override
    public void delete(Vacancy vacancy) {
        vacancyDao.delete(vacancy);
    }
}

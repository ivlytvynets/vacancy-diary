package vacancy.diary.dao.impl;

import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vacancy.diary.dao.VacancyDao;
import vacancy.diary.exception.DataProcessingException;
import vacancy.diary.model.Status;
import vacancy.diary.model.Vacancy;

@Repository
public class VacancyDaoImpl implements VacancyDao {
    private final SessionFactory sessionFactory;

    public VacancyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Vacancy add(Vacancy vacancy) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(vacancy);
            transaction.commit();
            return vacancy;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert vacancy to the database: "
                    + vacancy, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Vacancy> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Vacancy.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get vacancy with id: " + id, e);
        }
    }

    @Override
    public List<Vacancy> findByStatus(Status status) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select v from Vacancy v where v.status=:status",
                    Vacancy.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get vacancies with status: " + status, e);
        }
    }

    @Override
    public List<Vacancy> findByCompany(String company) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select v from Vacancy v where v.company=:company",
                    Vacancy.class).setParameter("company", company).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get vacancies with company: " + company, e);
        }
    }

    @Override
    public List<Vacancy> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select v from Vacancy v", Vacancy.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all vacancies", e);
        }
    }

    @Override
    public Vacancy update(Vacancy vacancy) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(vacancy);
            transaction.commit();
            return vacancy;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update vacancy: " + vacancy, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Vacancy vacancy) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(vacancy);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete vacancy: " + vacancy, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

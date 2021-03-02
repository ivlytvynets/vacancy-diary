package vacancy.diary.controller;

import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vacancy.diary.model.Status;
import vacancy.diary.model.User;
import vacancy.diary.model.Vacancy;
import vacancy.diary.service.UserService;
import vacancy.diary.service.VacancyService;

@Component
public class DataInitializer {
    private final UserService userService;
    private final VacancyService vacancyService;

    public DataInitializer(UserService userService, VacancyService vacancyService) {
        this.userService = userService;
        this.vacancyService = vacancyService;
    }

    @PostConstruct
    private void inject() {
        Vacancy vacancy1 = new Vacancy();
        vacancy1.setCompany("Company1");
        vacancy1.setExpectedSalary(800);
        vacancy1.setVacancyLink("link1");
        vacancy1.setPosition("Junior Java Developer");
        vacancy1.setRecruiterContacts(".....");
        vacancy1.setStatus(Status.APPLIED);
        vacancy1.setLastStatusUpdate(LocalDateTime.now());

        Vacancy vacancy2 = new Vacancy();
        vacancy2.setCompany("Company2");
        vacancy2.setExpectedSalary(700);
        vacancy2.setVacancyLink("link2");
        vacancy2.setPosition("Middle Java Developer");
        vacancy2.setRecruiterContacts(".....");
        vacancy2.setStatus(Status.APPLIED);
        vacancy2.setLastStatusUpdate(LocalDateTime.now());

        vacancyService.add(vacancy1);
        vacancyService.add(vacancy2);

        User admin = new User();
        admin.setEmail("admin4@gmail.com");
        admin.setPassword("1234");
        admin.setVacancies(List.of(vacancy1, vacancy2));
        userService.add(admin);
    }
}

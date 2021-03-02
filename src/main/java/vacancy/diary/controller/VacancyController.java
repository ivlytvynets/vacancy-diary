package vacancy.diary.controller;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vacancy.diary.model.Vacancy;
import vacancy.diary.service.UserService;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    private final UserService userService;

    public VacancyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/applications")
    public List<Vacancy> getAllApplications(Authentication authentication) {
        return userService.findByEmail(authentication.getName()).get().getVacancies();
    }
}

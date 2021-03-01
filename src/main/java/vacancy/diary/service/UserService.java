package vacancy.diary.service;

import java.util.Optional;
import vacancy.diary.model.User;

public interface UserService {
    User add(User user);

    Optional<User> findByEmail(String email);

    User get(Long id);
}

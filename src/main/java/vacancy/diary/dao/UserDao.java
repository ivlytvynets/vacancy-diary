package vacancy.diary.dao;

import java.util.Optional;
import vacancy.diary.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
